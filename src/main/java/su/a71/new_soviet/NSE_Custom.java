package su.a71.new_soviet;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import su.a71.new_soviet.blocks.RadioBlock;
import su.a71.new_soviet.blocks.TVBlock;

import java.util.Optional;
import java.util.function.Supplier;

public class NSE_Custom {

    public static final TVBlock TV = new TVBlock();
    public static final TVBlock RED_TV = new TVBlock();
    public static final TVBlock BROWN_TV = new TVBlock();

    public static final RadioBlock RADIO = new RadioBlock();

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
        Registry.register(Registries.ITEM_GROUP, new Identifier("new_soviet", "custom"), NSE_CUSTOM_TAB);
        register("tv", () -> TV, NSE_CUSTOM_TAB);
        register("red_tv", () -> RED_TV, NSE_CUSTOM_TAB);
        register("brown_tv", () -> BROWN_TV, NSE_CUSTOM_TAB);
        register("radio", () -> RADIO, NSE_CUSTOM_TAB);
    }
}