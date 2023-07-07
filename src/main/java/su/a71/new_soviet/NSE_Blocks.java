package su.a71.new_soviet;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Supplier;

public class NSE_Blocks {

    // BUILDING BRICKS/TILES ====================
    public static final Block SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block CRACKED_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block MOSSY_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block SMALL_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block SMALL_CRACKED_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block BIG_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block HERRINGBONE_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block SAND_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block CRACKED_SAND_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block MOSSY_SAND_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block BIG_SAND_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));
    public static final Block CROSS_SAND_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.MUD_BRICKS));

    public static final Block TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block MOSSY_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_CRACKED_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block GLAZED_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_GLAZED_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block VARIATED_TEAL_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE)); // TODO: name?

    public static final Block AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block MOSSY_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block DIRTY_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_CRACKED_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block GLAZED_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_GLAZED_AQUAMARINE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));

    public static final Block SMALL_DIORITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_CRACKED_DIORITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block BIG_DIORITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block DIORITE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_DIORITE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block MOSSY_DIORITE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));

    public static final Block CALCITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.CALCITE));
    public static final Block CRACKED_CALCITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.CALCITE));
    public static final Block MOSSY_CALCITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.CALCITE));
    public static final Block DIAGONAL_CALCITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.CALCITE));

    public static final Block DRIPSTONE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DRIPSTONE_BLOCK));
    public static final Block CRACKED_DRIPSTONE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DRIPSTONE_BLOCK));
    public static final Block MOSSY_DRIPSTONE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DRIPSTONE_BLOCK));
    public static final Block DRIPSTONE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DRIPSTONE_BLOCK));

    public static final Block DEEPSLATE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block CRACKED_DEEPSLATE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block MOSSY_DEEPSLATE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block SMALL_DEEPSLATE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block SMALL_CRACKED_DEEPSLATE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES));
    public static final Block DIAGONAL_DEEPSLATE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.DEEPSLATE_TILES));

    public static final Block LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block MOSSY_LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_CRACKED_LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block GLAZED_LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_GLAZED_LIGHT_BLUE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block LIGHT_BLUE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_LIGHT_BLUE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block MOSSY_LIGHT_BLUE_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));

    public static final Block BIG_GRANITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block SMALL_GRANITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));

    public static final Block GREEN_WHITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block CRACKED_GREEN_WHITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));
    public static final Block MOSSY_GREEN_WHITE_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));

    public static final Block TUFF_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));
    public static final Block CRACKED_TUFF_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));
    public static final Block MOSSY_TUFF_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));
    public static final Block TUFF_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));
    public static final Block CRACKED_TUFF_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));
    public static final Block MOSSY_TUFF_BRICKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));
    public static final Block BIG_TUFF_TILES = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.TUFF));

    // Industrial =====================================
    public static final Block INDUSTRIAL_WARNING = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL));
    public static final Block RED_WARNING = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL));
    public static final Block ORANGE_WARNING = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL));
    public static final Block METAL_PLATING = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.METAL));
    public static final WallBlock CONCRETE_WALL = new WallBlock(FabricBlockSettings.create().sounds(BlockSoundGroup.STONE));

    // WOOD/FLOOR ======
    public static final Block HERRINGBONE_ACACIA_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_ACACIA_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_OAK_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_OAK_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_BIRCH_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_BIRCH_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_CRIMSON_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_CRIMSON_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_DARK_OAK_PLAKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_DARK_OAK_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_JUNGLE_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_JUNGLE_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_MANGROVE_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_MANGROVE_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block HERRINGBONE_SPRUCE_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_SPRUCE_PLANKS = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));

    public static final Block HERRINGBONE_PARQUET = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block STRAIGHT_PARQUET = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block SEPARATED_PARQUET = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));

    public static final Block GREEN_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block BLUE_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block RED_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block GRAY_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block ORANGE_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block BROWN_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CYAN_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_ORANGE_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));
    public static final Block CROSS_BROWN_LINOLEUM = new Block(FabricBlockSettings.create().sounds(BlockSoundGroup.WOOD));

    // Concrete

    private static final ItemGroup NSE_TAB = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CALCITE_TILES))
            .displayName(Text.translatable("itemGroup.new_soviet.building_blocks"))
            .build();


    private static void register(String name, Supplier<? extends Block> supplier, ItemGroup tab)
    {
        Registry.register(Registries.BLOCK, new Identifier(NewSoviet.MOD_ID, name), supplier.get());
        BlockItem blockItem = new BlockItem(supplier.get(), new FabricItemSettings());
        Registry.register(Registries.ITEM, new Identifier(NewSoviet.MOD_ID, name), blockItem);

        Optional<RegistryKey<ItemGroup>> key = Registries.ITEM_GROUP.getKey(tab);
        key.ifPresent(itemGroupRegistryKey -> ItemGroupEvents.modifyEntriesEvent(itemGroupRegistryKey).register(content -> {
            content.add(blockItem);
        }));
    }

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("new_soviet", "building_blocks"), NSE_TAB);
        register("sand_tiles", () -> SAND_TILES, NSE_TAB);
        register("cracked_sand_tiles", () -> CRACKED_SAND_TILES, NSE_TAB);
        register("mossy_sand_tiles", () -> MOSSY_SAND_TILES, NSE_TAB);
        register("small_sand_tiles", () -> SMALL_SAND_TILES, NSE_TAB);
        register("small_cracked_sand_tiles", () -> SMALL_CRACKED_SAND_TILES, NSE_TAB);
        register("herringbone_sand_tiles", () -> HERRINGBONE_SAND_TILES, NSE_TAB);
        register("big_sand_tiles", () -> BIG_SAND_TILES, NSE_TAB);
        register("sand_bricks", () -> SAND_BRICKS, NSE_TAB);
        register("cracked_sand_bricks", () -> CRACKED_SAND_BRICKS, NSE_TAB);
        register("mossy_sand_bricks", () -> MOSSY_SAND_BRICKS, NSE_TAB);
        register("big_sand_bricks", () -> BIG_SAND_BRICKS, NSE_TAB);
        register("cross_sand_tiles", () -> CROSS_SAND_TILES, NSE_TAB);
        register("teal_tiles", () -> TEAL_TILES, NSE_TAB);
        register("cracked_teal_tiles", () -> CRACKED_TEAL_TILES, NSE_TAB);
        register("mossy_teal_tiles", () -> MOSSY_TEAL_TILES, NSE_TAB);
        register("small_teal_tiles", () -> SMALL_TEAL_TILES, NSE_TAB);
        register("small_cracked_teal_tiles", () -> SMALL_CRACKED_TEAL_TILES, NSE_TAB);
        register("glazed_teal_tiles", () -> GLAZED_TEAL_TILES, NSE_TAB);
        register("cracked_glazed_teal_tiles", () -> CRACKED_GLAZED_TEAL_TILES, NSE_TAB);
        register("variated_teal_tiles", () -> VARIATED_TEAL_TILES, NSE_TAB);
        register("aquamarine_tiles", () -> AQUAMARINE_TILES, NSE_TAB);
        register("cracked_aquamarine_tiles", () -> CRACKED_AQUAMARINE_TILES, NSE_TAB);
        register("mossy_aquamarine_tiles", () -> MOSSY_AQUAMARINE_TILES, NSE_TAB);
        register("dirty_aquamarine_tiles", () -> DIRTY_AQUAMARINE_TILES, NSE_TAB);
        register("small_aquamarine_tiles", () -> SMALL_AQUAMARINE_TILES, NSE_TAB);
        register("small_cracked_aquamarine_tiles", () -> SMALL_CRACKED_AQUAMARINE_TILES, NSE_TAB);
        register("glazed_aquamarine_tiles", () -> GLAZED_AQUAMARINE_TILES, NSE_TAB);
        register("cracked_glazed_aquamarine_tiles", () -> CRACKED_GLAZED_AQUAMARINE_TILES, NSE_TAB);
        register("small_diorite_tiles", () -> SMALL_DIORITE_TILES, NSE_TAB);
        register("small_cracked_diorite_tiles", () -> SMALL_CRACKED_DIORITE_TILES, NSE_TAB);
        register("big_diorite_tiles", () -> BIG_DIORITE_TILES, NSE_TAB);
        register("diorite_bricks", () -> DIORITE_BRICKS, NSE_TAB);
        register("cracked_diorite_bricks", () -> CRACKED_DIORITE_BRICKS, NSE_TAB);
        register("mossy_diorite_bricks", () -> MOSSY_DIORITE_BRICKS, NSE_TAB);
        register("calcite_tiles", () -> CALCITE_TILES, NSE_TAB);
        register("cracked_calcite_tiles", () -> CRACKED_CALCITE_TILES, NSE_TAB);
        register("mossy_calcite_tiles", () -> MOSSY_CALCITE_TILES, NSE_TAB);
        register("diagonal_calcite_tiles", () -> DIAGONAL_CALCITE_TILES, NSE_TAB);
        register("dripstone_tiles", () -> DRIPSTONE_TILES, NSE_TAB);
        register("cracked_dripstone_tiles", () -> CRACKED_DRIPSTONE_TILES, NSE_TAB);
        register("mossy_dripstone_tiles", () -> MOSSY_DRIPSTONE_TILES, NSE_TAB);
        register("dripstone_bricks", () -> DRIPSTONE_BRICKS, NSE_TAB);
        register("deepslate_tiles", () -> DEEPSLATE_TILES, NSE_TAB);
        register("cracked_deepslate_tiles", () -> CRACKED_DEEPSLATE_TILES, NSE_TAB);
        register("mossy_deepslate_tiles", () -> MOSSY_DEEPSLATE_TILES, NSE_TAB);
        register("small_deepslate_tiles", () -> SMALL_DEEPSLATE_TILES, NSE_TAB);
        register("small_cracked_deepslate_tiles", () -> SMALL_CRACKED_DEEPSLATE_TILES, NSE_TAB);
        register("diagonal_deepslate_tiles", () -> DIAGONAL_DEEPSLATE_TILES, NSE_TAB);
        register("light_blue_tiles", () -> LIGHT_BLUE_TILES, NSE_TAB);
        register("cracked_light_blue_tiles", () -> CRACKED_LIGHT_BLUE_TILES, NSE_TAB);
        register("mossy_light_blue_tiles", () -> MOSSY_LIGHT_BLUE_TILES, NSE_TAB);
        register("small_light_blue_tiles", () -> SMALL_LIGHT_BLUE_TILES, NSE_TAB);
        register("small_cracked_light_blue_tiles", () -> SMALL_CRACKED_LIGHT_BLUE_TILES, NSE_TAB);
        register("light_blue_bricks", () -> LIGHT_BLUE_BRICKS, NSE_TAB);
        register("glazed_light_blue_tiles", () -> GLAZED_LIGHT_BLUE_TILES, NSE_TAB);
        register("cracked_glazed_light_blue_tiles", () -> CRACKED_GLAZED_LIGHT_BLUE_TILES, NSE_TAB);
        register("cracked_light_blue_bricks", () -> CRACKED_LIGHT_BLUE_BRICKS, NSE_TAB);
        register("mossy_light_blue_bricks", () -> MOSSY_LIGHT_BLUE_BRICKS, NSE_TAB);
        register("big_granite_tiles", () -> BIG_GRANITE_TILES, NSE_TAB);
        register("small_granite_tiles", () -> SMALL_GRANITE_TILES, NSE_TAB);
        register("green_white_tiles", () -> GREEN_WHITE_TILES, NSE_TAB);
        register("cracked_green_white_tiles", () -> CRACKED_GREEN_WHITE_TILES, NSE_TAB);
        register("mossy_green_white_tiles", () -> MOSSY_GREEN_WHITE_TILES, NSE_TAB);
        register("tuff_tiles", () -> TUFF_TILES, NSE_TAB);
        register("cracked_tuff_tiles", () -> CRACKED_TUFF_TILES, NSE_TAB);
        register("mossy_tuff_tiles", () -> MOSSY_TUFF_TILES, NSE_TAB);
        register("tuff_bricks", () -> TUFF_BRICKS, NSE_TAB);
        register("cracked_tuff_bricks", () -> CRACKED_TUFF_BRICKS, NSE_TAB);
        register("mossy_tuff_bricks", () -> MOSSY_TUFF_BRICKS, NSE_TAB);
        register("big_tuff_tiles", () -> BIG_TUFF_TILES, NSE_TAB);

        register("industrial_warning", () -> INDUSTRIAL_WARNING, NSE_TAB);
        register("red_warning", () -> RED_WARNING, NSE_TAB);
        register("orange_warning", () -> ORANGE_WARNING, NSE_TAB);
        register("metal_plating", () -> METAL_PLATING, NSE_TAB);
        register("concrete_wall", () -> CONCRETE_WALL, NSE_TAB);  // TODO: Broken

        register("herringbone_acacia_planks", () -> HERRINGBONE_ACACIA_PLANKS, NSE_TAB);
        register("cross_acacia_planks", () -> CROSS_ACACIA_PLANKS, NSE_TAB);
        register("herringbone_oak_planks", () -> HERRINGBONE_OAK_PLANKS, NSE_TAB);
        register("cross_oak_planks", () -> CROSS_OAK_PLANKS, NSE_TAB);
        register("herringbone_birch_planks", () -> HERRINGBONE_BIRCH_PLANKS, NSE_TAB);
        register("cross_birch_planks", () -> CROSS_BIRCH_PLANKS, NSE_TAB);
        register("herringbone_crimson_planks", () -> HERRINGBONE_CRIMSON_PLANKS, NSE_TAB);
        register("cross_crimson_planks", () -> CROSS_CRIMSON_PLANKS, NSE_TAB);
        register("herringbone_dark_oak_planks", () -> HERRINGBONE_DARK_OAK_PLAKS, NSE_TAB);
        register("cross_dark_oak_planks", () -> CROSS_DARK_OAK_PLANKS, NSE_TAB);
        register("herringbone_jungle_planks", () -> HERRINGBONE_JUNGLE_PLANKS, NSE_TAB);
        register("cross_jungle_planks", () -> CROSS_JUNGLE_PLANKS, NSE_TAB);
        register("herringbone_mangrove_planks", () -> HERRINGBONE_MANGROVE_PLANKS, NSE_TAB);
        register("cross_mangrove_planks", () -> CROSS_MANGROVE_PLANKS, NSE_TAB);
        register("herringbone_spruce_planks", () -> HERRINGBONE_SPRUCE_PLANKS, NSE_TAB);
        register("cross_spruce_planks", () -> CROSS_SPRUCE_PLANKS, NSE_TAB);

        register("herringbone_parquet", () -> HERRINGBONE_PARQUET, NSE_TAB);
        register("straight_parquet", () -> STRAIGHT_PARQUET, NSE_TAB);
        register("separated_parquet", () -> SEPARATED_PARQUET, NSE_TAB);

        register("green_linoleum", () -> GREEN_LINOLEUM, NSE_TAB);
        register("blue_linoleum", () -> BLUE_LINOLEUM, NSE_TAB);
        register("red_linoleum", () -> RED_LINOLEUM, NSE_TAB);
        register("gray_linoleum", () -> GRAY_LINOLEUM, NSE_TAB);
        register("orange_linoleum", () -> ORANGE_LINOLEUM, NSE_TAB);
        register("brown_linoleum", () -> BROWN_LINOLEUM, NSE_TAB);
        register("cyan_linoleum", () -> CYAN_LINOLEUM, NSE_TAB);
        register("cross_orange_linoleum", () -> CROSS_ORANGE_LINOLEUM, NSE_TAB);
        register("cross_brown_linoleum", () -> CROSS_BROWN_LINOLEUM, NSE_TAB);
    }
}
