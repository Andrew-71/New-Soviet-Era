package su.a71.new_soviet.registration;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import su.a71.new_soviet.NewSoviet;
import su.a71.new_soviet.blocks.*;
import su.a71.new_soviet.entity.TVBlockEntity;

import java.util.Optional;
import java.util.function.Supplier;

public class NSE_Custom {
    public static final TVBlock TV = new TVBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_YELLOW));
    public static final TVBlock RED_TV = new TVBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_RED));
    public static final TVBlock BROWN_TV = new TVBlock(FabricBlockSettings.create().mapColor(MapColor.TERRACOTTA_BROWN));
    public static final BlockEntityType<TVBlockEntity> TV_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(NewSoviet.MOD_ID, "tv_block_entity"),
            FabricBlockEntityTypeBuilder.create(TVBlockEntity::new, TV, RED_TV, BROWN_TV).build()
    );
    public static final RadioBlock RADIO = new RadioBlock();
    public static final LampBlock LAMP = new LampBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.LANTERN).strength(1f, 1.5f).mapColor(MapColor.WHITE));
    public static final LightBulbBlock LIGHT_BULB = new LightBulbBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.GLASS).strength(1f, 1.5f).mapColor(MapColor.WHITE));
    public static final SoundEvent LIGHT_BULB_BROKEN_SOUND = SoundEvent.of(new Identifier(NewSoviet.MOD_ID, "light_bulb_broken_sound"));

    public static final CeilingFanBlock CEILING_FAN = new CeilingFanBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL).strength(1f, 1.5f).mapColor(MapColor.WHITE));

    public static final SirenBlock SIREN = new SirenBlock();
    public static final SoundEvent SIREN_SOUND = SoundEvent.of(new Identifier(NewSoviet.MOD_ID, "siren_sound"));

    public static final LandMineBlock LANDMINE = new LandMineBlock(FabricBlockSettings.create().mapColor(MapColor.LIGHT_GRAY));

    private static final ItemGroup NSE_CUSTOM_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(TV))
            .displayName(Text.translatable("itemGroup.new_soviet.custom"))
            .build();


    private static void register(String name, Supplier<? extends Block> supplier, ItemGroup tab) {
        Registry.register(Registries.BLOCK, new Identifier(NewSoviet.MOD_ID, name), supplier.get());
        BlockItem blockItem = new BlockItem(supplier.get(), new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(NewSoviet.MOD_ID, name), blockItem);

        Optional<RegistryKey<ItemGroup>> key = Registries.ITEM_GROUP.getKey(tab);
        key.ifPresent(itemGroupRegistryKey -> ItemGroupEvents.modifyEntriesEvent(itemGroupRegistryKey).register(content -> {
            content.add(blockItem);
        }));
    }

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(NewSoviet.MOD_ID, "custom"), NSE_CUSTOM_TAB);
        register("tv", () -> TV, NSE_CUSTOM_TAB);
        register("red_tv", () -> RED_TV, NSE_CUSTOM_TAB);
        register("brown_tv", () -> BROWN_TV, NSE_CUSTOM_TAB);
        register("radio", () -> RADIO, NSE_CUSTOM_TAB);
        register("lamp", () -> LAMP, NSE_CUSTOM_TAB);
        register("light_bulb", () -> LIGHT_BULB, NSE_CUSTOM_TAB);
        register("ceiling_fan", () -> CEILING_FAN, NSE_CUSTOM_TAB);
        register("siren", () -> SIREN, NSE_CUSTOM_TAB);
        register("landmine", () -> LANDMINE, NSE_CUSTOM_TAB);

        Registry.register(Registries.SOUND_EVENT, new Identifier(NewSoviet.MOD_ID, "siren_sound"), SIREN_SOUND);
        Registry.register(Registries.SOUND_EVENT, new Identifier(NewSoviet.MOD_ID, "light_bulb_broken_sound"), LIGHT_BULB_BROKEN_SOUND);
    }
}