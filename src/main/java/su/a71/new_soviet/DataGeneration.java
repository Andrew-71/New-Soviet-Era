package su.a71.new_soviet;
// === ABANDON HOPE, YE WHO ENTER HERE ===

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.tag.ItemTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class DataGeneration implements DataGeneratorEntrypoint {

    private static class BlockLootTables extends FabricBlockLootTableProvider {
        public BlockLootTables(FabricDataOutput dataOutput) {
            super(dataOutput);
        }

        @Override
        public void generate() {
            // Drops for building blocks
            addDrop(NSE_Blocks.SAND_TILES);
            addDrop(NSE_Blocks.CRACKED_SAND_TILES);
            addDrop(NSE_Blocks.MOSSY_SAND_TILES);
            addDrop(NSE_Blocks.SMALL_SAND_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_SAND_TILES);
            addDrop(NSE_Blocks.HERRINGBONE_SAND_TILES);
            addDrop(NSE_Blocks.CROSS_SAND_TILES);
            addDrop(NSE_Blocks.BIG_SAND_TILES);
            addDrop(NSE_Blocks.SAND_BRICKS);
            addDrop(NSE_Blocks.CRACKED_SAND_BRICKS);
            addDrop(NSE_Blocks.MOSSY_SAND_BRICKS);
            addDrop(NSE_Blocks.BIG_SAND_BRICKS);
            addDrop(NSE_Blocks.TEAL_TILES);
            addDrop(NSE_Blocks.CRACKED_TEAL_TILES);
            addDrop(NSE_Blocks.MOSSY_TEAL_TILES);
            addDrop(NSE_Blocks.SMALL_TEAL_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_TEAL_TILES);
            addDrop(NSE_Blocks.GLAZED_TEAL_TILES);
            addDrop(NSE_Blocks.CRACKED_GLAZED_TEAL_TILES);
            addDrop(NSE_Blocks.VARIATED_TEAL_TILES);
            addDrop(NSE_Blocks.AQUAMARINE_TILES);
            addDrop(NSE_Blocks.CRACKED_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.MOSSY_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.DIRTY_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.SMALL_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.GLAZED_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.CRACKED_GLAZED_AQUAMARINE_TILES);
            addDrop(NSE_Blocks.SMALL_DIORITE_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_DIORITE_TILES);
            addDrop(NSE_Blocks.BIG_DIORITE_TILES);
            addDrop(NSE_Blocks.DIORITE_BRICKS);
            addDrop(NSE_Blocks.CRACKED_DIORITE_BRICKS);
            addDrop(NSE_Blocks.MOSSY_DIORITE_BRICKS);
            addDrop(NSE_Blocks.CALCITE_TILES);
            addDrop(NSE_Blocks.CRACKED_CALCITE_TILES);
            addDrop(NSE_Blocks.MOSSY_CALCITE_TILES);
            addDrop(NSE_Blocks.DIAGONAL_CALCITE_TILES);
            addDrop(NSE_Blocks.DRIPSTONE_TILES);
            addDrop(NSE_Blocks.CRACKED_DRIPSTONE_TILES);
            addDrop(NSE_Blocks.MOSSY_DRIPSTONE_TILES);
            addDrop(NSE_Blocks.DRIPSTONE_BRICKS);
            addDrop(NSE_Blocks.DEEPSLATE_TILES);
            addDrop(NSE_Blocks.CRACKED_DEEPSLATE_TILES);
            addDrop(NSE_Blocks.MOSSY_DEEPSLATE_TILES);
            addDrop(NSE_Blocks.SMALL_DEEPSLATE_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_DEEPSLATE_TILES);
            addDrop(NSE_Blocks.DIAGONAL_DEEPSLATE_TILES);
            addDrop(NSE_Blocks.LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.CRACKED_LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.MOSSY_LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.SMALL_LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.GLAZED_LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.CRACKED_GLAZED_LIGHT_BLUE_TILES);
            addDrop(NSE_Blocks.LIGHT_BLUE_BRICKS);
            addDrop(NSE_Blocks.CRACKED_LIGHT_BLUE_BRICKS);
            addDrop(NSE_Blocks.MOSSY_LIGHT_BLUE_BRICKS);
            addDrop(NSE_Blocks.BIG_GRANITE_TILES);
            addDrop(NSE_Blocks.SMALL_GRANITE_TILES);
            addDrop(NSE_Blocks.SMALL_CRACKED_GRANITE_TILES);
            addDrop(NSE_Blocks.GREEN_WHITE_TILES);
            addDrop(NSE_Blocks.CRACKED_GREEN_WHITE_TILES);
            addDrop(NSE_Blocks.MOSSY_GREEN_WHITE_TILES);
            addDrop(NSE_Blocks.TUFF_TILES);
            addDrop(NSE_Blocks.CRACKED_TUFF_TILES);
            addDrop(NSE_Blocks.MOSSY_TUFF_TILES);
            addDrop(NSE_Blocks.BIG_TUFF_TILES);
            addDrop(NSE_Blocks.TUFF_BRICKS);
            addDrop(NSE_Blocks.CRACKED_TUFF_BRICKS);
            addDrop(NSE_Blocks.MOSSY_TUFF_BRICKS);
            addDrop(NSE_Blocks.INDUSTRIAL_WARNING);
            addDrop(NSE_Blocks.GRAY_WARNING);
            addDrop(NSE_Blocks.RED_WARNING);
            addDrop(NSE_Blocks.ORANGE_WARNING);
            addDrop(NSE_Blocks.YELLOW_WARNING);
            addDrop(NSE_Blocks.LIME_WARNING);
            addDrop(NSE_Blocks.GREEN_WARNING);
            addDrop(NSE_Blocks.CYAN_WARNING);
            addDrop(NSE_Blocks.LIGHT_BLUE_WARNING);
            addDrop(NSE_Blocks.BLUE_WARNING);
            addDrop(NSE_Blocks.PURPLE_WARNING);
            addDrop(NSE_Blocks.MAGENTA_WARNING);
            addDrop(NSE_Blocks.METAL_PLATING);
            addDrop(NSE_Blocks.CRATE);
            addDrop(NSE_Blocks.CONCRETE_WALL);
            addDrop(NSE_Blocks.HERRINGBONE_ACACIA_PLANKS);
            addDrop(NSE_Blocks.CROSS_ACACIA_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_OAK_PLANKS);
            addDrop(NSE_Blocks.CROSS_OAK_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_BIRCH_PLANKS);
            addDrop(NSE_Blocks.CROSS_BIRCH_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_CRIMSON_PLANKS);
            addDrop(NSE_Blocks.CROSS_CRIMSON_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_DARK_OAK_PLAKS);
            addDrop(NSE_Blocks.CROSS_DARK_OAK_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_JUNGLE_PLANKS);
            addDrop(NSE_Blocks.CROSS_JUNGLE_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_MANGROVE_PLANKS);
            addDrop(NSE_Blocks.CROSS_MANGROVE_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_SPRUCE_PLANKS);
            addDrop(NSE_Blocks.CROSS_SPRUCE_PLANKS);
            addDrop(NSE_Blocks.HERRINGBONE_PARQUET);
            addDrop(NSE_Blocks.STRAIGHT_PARQUET);
            addDrop(NSE_Blocks.SEPARATED_PARQUET);
            addDrop(NSE_Blocks.GREEN_LINOLEUM);
            addDrop(NSE_Blocks.BLUE_LINOLEUM);
            addDrop(NSE_Blocks.RED_LINOLEUM);
            addDrop(NSE_Blocks.GRAY_LINOLEUM);
            addDrop(NSE_Blocks.ORANGE_LINOLEUM);
            addDrop(NSE_Blocks.BROWN_LINOLEUM);
            addDrop(NSE_Blocks.CYAN_LINOLEUM);
            addDrop(NSE_Blocks.CROSS_ORANGE_LINOLEUM);
            addDrop(NSE_Blocks.CROSS_BROWN_LINOLEUM);

            // Drops for furniture
        }
    }

//    private static class MyTagGenerator extends ItemTagProvider {
//        public MyTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
//            super(output, completableFuture);
//        }
//
//        @Override
//        protected void configure(RegistryWrapper.WrapperLookup lookup) {
//
//        }
//    }

    private static class RecipeGenerator extends FabricRecipeProvider {
        private RecipeGenerator(FabricDataOutput generator) {
            super(generator);
        }

        @Override
        public void generate(Consumer<RecipeJsonProvider> exporter) {
        }
    }


    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack myPack = fabricDataGenerator.createPack();
        myPack.addProvider(BlockLootTables::new);
        myPack.addProvider(RecipeGenerator::new);
//        myPack.addProvider(MyTagGenerator::new);
    }
}