package su.a71.new_soviet.registration;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import su.a71.new_soviet.NewSoviet;
import su.a71.new_soviet.blocks.*;

import java.util.Optional;
import java.util.function.Supplier;

public class NSE_Combat {

    public static final LandMineBlock LANDMINE = new LandMineBlock(FabricBlockSettings.create().mapColor(MapColor.LIGHT_GRAY));

    private static final ItemGroup NSE_COMBAT_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(LANDMINE))
            .displayName(Text.translatable("itemGroup.new_soviet.combat"))
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
        Registry.register(Registries.ITEM_GROUP, new Identifier("new_soviet", "combat"), NSE_COMBAT_TAB);
        register("landmine", () -> LANDMINE, NSE_COMBAT_TAB);

    }
}
