package su.a71.new_soviet;
// === ABANDON HOPE, YE WHO ENTER HERE ===

import com.google.common.collect.Lists;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Util;
import su.a71.new_soviet.registration.NSE_Blocks;
import su.a71.new_soviet.registration.NSE_Combat;
import su.a71.new_soviet.registration.NSE_Custom;
import su.a71.new_soviet.registration.NSE_Items;

import java.util.List;
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
            addDrop(NSE_Blocks.HERRINGBONE_DARK_OAK_PLANKS);
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
            addDrop(NSE_Blocks.WHITE_CONCRETE);
            addDrop(NSE_Blocks.CRACKED_WHITE_CONCRETE);
            addDrop(NSE_Blocks.BEIGE_CONCRETE);
            addDrop(NSE_Blocks.CRACKED_BEIGE_CONCRETE);
            addDrop(NSE_Blocks.BLUE_CONCRETE);
            addDrop(NSE_Blocks.CRACKED_BLUE_CONCRETE);
            addDrop(NSE_Blocks.RED_CONCRETE);
            addDrop(NSE_Blocks.CRACKED_RED_CONCRETE);
            addDrop(NSE_Blocks.YELLOW_CONCRETE);
            addDrop(NSE_Blocks.CRACKED_YELLOW_CONCRETE);
            addDrop(NSE_Blocks.GREEN_CONCRETE);
            addDrop(NSE_Blocks.CRACKED_GREEN_CONCRETE);
            addDrop(NSE_Blocks.WHITEWASH);
            addDrop(NSE_Blocks.CRACKED_WHITEWASH);
            addDrop(NSE_Blocks.VERY_CRACKED_WHITEWASH);

            // Drops for furniture/electronics/appliances
            addDrop(NSE_Custom.TV);
            addDrop(NSE_Custom.RED_TV);
            addDrop(NSE_Custom.BROWN_TV);
            addDrop(NSE_Custom.RADIO);
            addDrop(NSE_Custom.SIREN);
            addDrop(NSE_Custom.LAMP);
            addDrop(NSE_Custom.CEILING_FAN);
        }
    }

    private static class BlockTagGenerator extends FabricTagProvider.BlockTagProvider {

        public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            // Blocks mined with a pickaxe
            getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                    .add(NSE_Blocks.SAND_TILES)
                    .add(NSE_Blocks.CRACKED_SAND_TILES)
                    .add(NSE_Blocks.MOSSY_SAND_TILES)
                    .add(NSE_Blocks.SMALL_SAND_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_SAND_TILES)
                    .add(NSE_Blocks.HERRINGBONE_SAND_TILES)
                    .add(NSE_Blocks.CROSS_SAND_TILES)
                    .add(NSE_Blocks.BIG_SAND_TILES)
                    .add(NSE_Blocks.SAND_BRICKS)
                    .add(NSE_Blocks.CRACKED_SAND_BRICKS)
                    .add(NSE_Blocks.MOSSY_SAND_BRICKS)
                    .add(NSE_Blocks.BIG_SAND_BRICKS)
                    .add(NSE_Blocks.TEAL_TILES)
                    .add(NSE_Blocks.CRACKED_TEAL_TILES)
                    .add(NSE_Blocks.MOSSY_TEAL_TILES)
                    .add(NSE_Blocks.SMALL_TEAL_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_TEAL_TILES)
                    .add(NSE_Blocks.GLAZED_TEAL_TILES)
                    .add(NSE_Blocks.CRACKED_GLAZED_TEAL_TILES)
                    .add(NSE_Blocks.VARIATED_TEAL_TILES)
                    .add(NSE_Blocks.AQUAMARINE_TILES)
                    .add(NSE_Blocks.CRACKED_AQUAMARINE_TILES)
                    .add(NSE_Blocks.MOSSY_AQUAMARINE_TILES)
                    .add(NSE_Blocks.DIRTY_AQUAMARINE_TILES)
                    .add(NSE_Blocks.SMALL_AQUAMARINE_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_AQUAMARINE_TILES)
                    .add(NSE_Blocks.GLAZED_AQUAMARINE_TILES)
                    .add(NSE_Blocks.CRACKED_GLAZED_AQUAMARINE_TILES)
                    .add(NSE_Blocks.SMALL_DIORITE_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_DIORITE_TILES)
                    .add(NSE_Blocks.BIG_DIORITE_TILES)
                    .add(NSE_Blocks.DIORITE_BRICKS)
                    .add(NSE_Blocks.CRACKED_DIORITE_BRICKS)
                    .add(NSE_Blocks.MOSSY_DIORITE_BRICKS)
                    .add(NSE_Blocks.CALCITE_TILES)
                    .add(NSE_Blocks.CRACKED_CALCITE_TILES)
                    .add(NSE_Blocks.MOSSY_CALCITE_TILES)
                    .add(NSE_Blocks.DIAGONAL_CALCITE_TILES)
                    .add(NSE_Blocks.DRIPSTONE_TILES)
                    .add(NSE_Blocks.CRACKED_DRIPSTONE_TILES)
                    .add(NSE_Blocks.MOSSY_DRIPSTONE_TILES)
                    .add(NSE_Blocks.DRIPSTONE_BRICKS)
                    .add(NSE_Blocks.DEEPSLATE_TILES)
                    .add(NSE_Blocks.CRACKED_DEEPSLATE_TILES)
                    .add(NSE_Blocks.MOSSY_DEEPSLATE_TILES)
                    .add(NSE_Blocks.SMALL_DEEPSLATE_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_DEEPSLATE_TILES)
                    .add(NSE_Blocks.DIAGONAL_DEEPSLATE_TILES)
                    .add(NSE_Blocks.LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.CRACKED_LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.MOSSY_LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.SMALL_LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.GLAZED_LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.CRACKED_GLAZED_LIGHT_BLUE_TILES)
                    .add(NSE_Blocks.LIGHT_BLUE_BRICKS)
                    .add(NSE_Blocks.CRACKED_LIGHT_BLUE_BRICKS)
                    .add(NSE_Blocks.MOSSY_LIGHT_BLUE_BRICKS)
                    .add(NSE_Blocks.BIG_GRANITE_TILES)
                    .add(NSE_Blocks.SMALL_GRANITE_TILES)
                    .add(NSE_Blocks.SMALL_CRACKED_GRANITE_TILES)
                    .add(NSE_Blocks.GREEN_WHITE_TILES)
                    .add(NSE_Blocks.CRACKED_GREEN_WHITE_TILES)
                    .add(NSE_Blocks.MOSSY_GREEN_WHITE_TILES)
                    .add(NSE_Blocks.TUFF_TILES)
                    .add(NSE_Blocks.CRACKED_TUFF_TILES)
                    .add(NSE_Blocks.MOSSY_TUFF_TILES)
                    .add(NSE_Blocks.BIG_TUFF_TILES)
                    .add(NSE_Blocks.TUFF_BRICKS)
                    .add(NSE_Blocks.CRACKED_TUFF_BRICKS)
                    .add(NSE_Blocks.MOSSY_TUFF_BRICKS)
                    .add(NSE_Blocks.INDUSTRIAL_WARNING)
                    .add(NSE_Blocks.GRAY_WARNING)
                    .add(NSE_Blocks.RED_WARNING)
                    .add(NSE_Blocks.ORANGE_WARNING)
                    .add(NSE_Blocks.YELLOW_WARNING)
                    .add(NSE_Blocks.LIME_WARNING)
                    .add(NSE_Blocks.GREEN_WARNING)
                    .add(NSE_Blocks.CYAN_WARNING)
                    .add(NSE_Blocks.LIGHT_BLUE_WARNING)
                    .add(NSE_Blocks.BLUE_WARNING)
                    .add(NSE_Blocks.PURPLE_WARNING)
                    .add(NSE_Blocks.MAGENTA_WARNING)
                    .add(NSE_Blocks.METAL_PLATING)
                    .add(NSE_Blocks.CONCRETE_WALL);

            // Blocks mined with an axe
            getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                    .add(NSE_Blocks.CRATE)
                    .add(NSE_Blocks.CONCRETE_WALL)
                    .add(NSE_Blocks.HERRINGBONE_ACACIA_PLANKS)
                    .add(NSE_Blocks.CROSS_ACACIA_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_OAK_PLANKS)
                    .add(NSE_Blocks.CROSS_OAK_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_BIRCH_PLANKS)
                    .add(NSE_Blocks.CROSS_BIRCH_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_CRIMSON_PLANKS)
                    .add(NSE_Blocks.CROSS_CRIMSON_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_DARK_OAK_PLANKS)
                    .add(NSE_Blocks.CROSS_DARK_OAK_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_JUNGLE_PLANKS)
                    .add(NSE_Blocks.CROSS_JUNGLE_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_MANGROVE_PLANKS)
                    .add(NSE_Blocks.CROSS_MANGROVE_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_SPRUCE_PLANKS)
                    .add(NSE_Blocks.CROSS_SPRUCE_PLANKS)
                    .add(NSE_Blocks.HERRINGBONE_PARQUET)
                    .add(NSE_Blocks.STRAIGHT_PARQUET)
                    .add(NSE_Blocks.SEPARATED_PARQUET)
                    .add(NSE_Blocks.GREEN_LINOLEUM)
                    .add(NSE_Blocks.BLUE_LINOLEUM)
                    .add(NSE_Blocks.RED_LINOLEUM)
                    .add(NSE_Blocks.GRAY_LINOLEUM)
                    .add(NSE_Blocks.ORANGE_LINOLEUM)
                    .add(NSE_Blocks.BROWN_LINOLEUM)
                    .add(NSE_Blocks.CYAN_LINOLEUM)
                    .add(NSE_Blocks.CROSS_ORANGE_LINOLEUM)
                    .add(NSE_Blocks.CROSS_BROWN_LINOLEUM);
        }
    }


    private static class RecipeGenerator extends FabricRecipeProvider {
        private RecipeGenerator(FabricDataOutput generator) {
            super(generator);
        }

        private void mossRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output).input(input).input(Items.VINE).criterion(FabricRecipeProvider.hasItem(output),
                    FabricRecipeProvider.conditionsFromItem(output)).criterion(FabricRecipeProvider.hasItem(input),
                    FabricRecipeProvider.conditionsFromItem(output)).criterion(FabricRecipeProvider.hasItem(Items.VINE),
                    FabricRecipeProvider.conditionsFromItem(output)).offerTo(exporter);
        }

        private void stoneCuttingCategory(Consumer<RecipeJsonProvider> exporter, List<ItemConvertible> category, RecipeCategory recipe_category) {
            for (int i = 0; i < category.size(); i++) {
                for (int j = 0; j < category.size(); j++) {
                    if (i != j) {
                        offerStonecuttingRecipe(exporter, recipe_category,
                                category.get(i), category.get(j));
                    }
                }
            }
        }

        private void diceRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible dice) {
            var buttons = Util.make(Lists.newArrayList(), list -> {
                list.add(Blocks.OAK_BUTTON);
                list.add(Blocks.BAMBOO_BUTTON);
                list.add(Blocks.BIRCH_BUTTON);
                list.add(Blocks.CHERRY_BUTTON);
                list.add(Blocks.ACACIA_BUTTON);
                list.add(Blocks.CRIMSON_BUTTON);
                list.add(Blocks.DARK_OAK_BUTTON);
                list.add(Blocks.JUNGLE_BUTTON);
                list.add(Blocks.MANGROVE_BUTTON);
                list.add(Blocks.SPRUCE_BUTTON);
                list.add(Blocks.WARPED_BUTTON);
            });
            for (Object button : buttons) {
                offerStonecuttingRecipe(exporter, RecipeCategory.MISC, dice, (ItemConvertible) button);
            }
        }

        private void warningStripeRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
            .pattern("D#D")
                .pattern("#D#")
                .pattern("D#D")
                .input('D', dye)
                .input('#', Items.IRON_INGOT)
                .criterion(RecipeProvider.hasItem(Items.IRON_INGOT),
                        RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                .criterion(RecipeProvider.hasItem(dye),
                        RecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter);
        }

        private void crissCrossRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input1, ItemConvertible input2) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, output, 4)
                    .pattern("XY")
                    .pattern("YX")
                    .input('X', input1)
                    .input('Y', input2)
                    .criterion(RecipeProvider.hasItem(input1),
                            RecipeProvider.conditionsFromItem(input1))
                    .criterion(RecipeProvider.hasItem(input2),
                            RecipeProvider.conditionsFromItem(input2))
                    .offerTo(exporter);
        }

        private void tvRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible dye) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                    .pattern("N N")
                    .pattern("DGD")
                    .pattern("DRD")
                    .input('D', dye)
                    .input('N', Items.IRON_NUGGET)
                    .input('R', Items.REDSTONE)
                    .input('G', Items.GLASS_PANE)
                    .criterion(RecipeProvider.hasItem(Items.IRON_NUGGET),
                            RecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
                    .criterion(RecipeProvider.hasItem(Items.GLASS_PANE),
                            RecipeProvider.conditionsFromItem(Items.GLASS_PANE))
                    .criterion(RecipeProvider.hasItem(Items.REDSTONE),
                            RecipeProvider.conditionsFromItem(Items.REDSTONE))
                    .criterion(RecipeProvider.hasItem(dye),
                            RecipeProvider.conditionsFromItem(dye))
                    .offerTo(exporter);
        }

        private void radioRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                    .pattern("  N")
                    .pattern("MMM")
                    .pattern("III")
                    .input('M', Blocks.NOTE_BLOCK)
                    .input('N', Items.IRON_NUGGET)
                    .input('I', Items.IRON_INGOT)
                    .criterion(RecipeProvider.hasItem(Items.IRON_NUGGET),
                            RecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
                    .criterion(RecipeProvider.hasItem(Items.NOTE_BLOCK),
                            RecipeProvider.conditionsFromItem(Items.NOTE_BLOCK))
                    .criterion(RecipeProvider.hasItem(Items.IRON_INGOT),
                            RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);
        }

        private void ceilingFanRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                    .pattern(" S ")
                    .pattern("WNW")
                    .input('S', Items.STICK)
                    .input('N', Items.IRON_NUGGET)
                    .input('W', Items.WHITE_WOOL)
                    .criterion(RecipeProvider.hasItem(Items.IRON_NUGGET),
                            RecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
                    .criterion(RecipeProvider.hasItem(Items.STICK),
                            RecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(RecipeProvider.hasItem(Items.WHITE_WOOL),
                            RecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                    .offerTo(exporter);
        }

        private void lampRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 3)
                    .pattern("WWW")
                    .pattern("WTW")
                    .pattern(" S ")

                    .input('S', Items.STICK)
                    .input('T', Items.TORCH)
                    .input('W', Items.WHITE_WOOL)
                    .criterion(RecipeProvider.hasItem(Items.TORCH),
                            RecipeProvider.conditionsFromItem(Items.TORCH))
                    .criterion(RecipeProvider.hasItem(Items.STICK),
                            RecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(RecipeProvider.hasItem(Items.WHITE_WOOL),
                            RecipeProvider.conditionsFromItem(Items.WHITE_WOOL))
                    .offerTo(exporter);
        }

        private void sickleRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, output, 1)
                    .pattern(" I ")
                    .pattern("  I")
                    .pattern(" S ")
                    .input('S', Items.STICK)
                    .input('I', Items.IRON_INGOT)
                    .criterion(RecipeProvider.hasItem(Items.STICK),
                            RecipeProvider.conditionsFromItem(Items.STICK))
                    .criterion(RecipeProvider.hasItem(Items.IRON_INGOT),
                            RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);
        }

        @Override
        public void generate(Consumer<RecipeJsonProvider> exporter) {
            crissCrossRecipe(exporter, NSE_Blocks.SAND_TILES, Blocks.SMOOTH_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE);
            crissCrossRecipe(exporter, NSE_Blocks.LIGHT_BLUE_TILES, Blocks.STONE, Items.LIGHT_BLUE_DYE);
            crissCrossRecipe(exporter, NSE_Blocks.SMALL_WHITE_TILES, Blocks.STONE, Items.WHITE_DYE);
            crissCrossRecipe(exporter, NSE_Blocks.GREEN_WHITE_TILES, Blocks.POLISHED_DIORITE, Items.GREEN_DYE);

            tvRecipe(exporter, NSE_Custom.TV, Items.ORANGE_DYE);
            tvRecipe(exporter, NSE_Custom.BROWN_TV, Items.BROWN_DYE);
            tvRecipe(exporter, NSE_Custom.RED_TV, Items.RED_DYE);
            radioRecipe(exporter, NSE_Custom.RADIO);
            ceilingFanRecipe(exporter, NSE_Custom.CEILING_FAN);
            lampRecipe(exporter, NSE_Custom.LAMP);
            sickleRecipe(exporter, NSE_Items.SICKLE);

            // Cracked blocks
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_SAND_TILES, NSE_Blocks.SAND_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_SAND_TILES, NSE_Blocks.SMALL_SAND_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_SAND_BRICKS, NSE_Blocks.SAND_BRICKS);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_TEAL_TILES, NSE_Blocks.TEAL_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_TEAL_TILES, NSE_Blocks.SMALL_TEAL_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_GLAZED_TEAL_TILES, NSE_Blocks.GLAZED_TEAL_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_AQUAMARINE_TILES, NSE_Blocks.AQUAMARINE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_AQUAMARINE_TILES, NSE_Blocks.SMALL_AQUAMARINE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_GLAZED_AQUAMARINE_TILES, NSE_Blocks.GLAZED_AQUAMARINE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_DIORITE_TILES, NSE_Blocks.SMALL_DIORITE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_DIORITE_BRICKS, NSE_Blocks.DIORITE_BRICKS);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_CALCITE_TILES, NSE_Blocks.CALCITE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_DRIPSTONE_TILES, NSE_Blocks.DRIPSTONE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_DEEPSLATE_TILES, NSE_Blocks.DEEPSLATE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_DEEPSLATE_TILES, NSE_Blocks.SMALL_DEEPSLATE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_LIGHT_BLUE_TILES, NSE_Blocks.LIGHT_BLUE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_LIGHT_BLUE_TILES, NSE_Blocks.SMALL_LIGHT_BLUE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_GLAZED_LIGHT_BLUE_TILES, NSE_Blocks.GLAZED_LIGHT_BLUE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_LIGHT_BLUE_BRICKS, NSE_Blocks.LIGHT_BLUE_BRICKS);
            offerCrackingRecipe(exporter, NSE_Blocks.SMALL_CRACKED_GRANITE_TILES, NSE_Blocks.SMALL_GRANITE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_GREEN_WHITE_TILES, NSE_Blocks.GREEN_WHITE_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_TUFF_TILES, NSE_Blocks.TUFF_TILES);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_TUFF_BRICKS, NSE_Blocks.TUFF_BRICKS);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_WHITEWASH, NSE_Blocks.WHITEWASH);
            offerCrackingRecipe(exporter, NSE_Blocks.VERY_CRACKED_WHITEWASH, NSE_Blocks.CRACKED_WHITEWASH);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_WHITE_CONCRETE, NSE_Blocks.WHITE_CONCRETE);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_BEIGE_CONCRETE, NSE_Blocks.BEIGE_CONCRETE);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_BLUE_CONCRETE, NSE_Blocks.BLUE_CONCRETE);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_RED_CONCRETE, NSE_Blocks.RED_CONCRETE);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_YELLOW_CONCRETE, NSE_Blocks.YELLOW_CONCRETE);
            offerCrackingRecipe(exporter, NSE_Blocks.CRACKED_GREEN_CONCRETE, NSE_Blocks.GREEN_CONCRETE);

            mossRecipe(exporter, NSE_Blocks.MOSSY_SAND_TILES, NSE_Blocks.SAND_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_SAND_BRICKS, NSE_Blocks.SAND_BRICKS);
            mossRecipe(exporter, NSE_Blocks.MOSSY_TEAL_TILES, NSE_Blocks.TEAL_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_AQUAMARINE_TILES, NSE_Blocks.AQUAMARINE_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_DIORITE_BRICKS, NSE_Blocks.DIORITE_BRICKS);
            mossRecipe(exporter, NSE_Blocks.MOSSY_CALCITE_TILES, NSE_Blocks.CALCITE_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_DRIPSTONE_TILES, NSE_Blocks.DRIPSTONE_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_DEEPSLATE_TILES, NSE_Blocks.DEEPSLATE_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_LIGHT_BLUE_TILES, NSE_Blocks.LIGHT_BLUE_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_LIGHT_BLUE_BRICKS, NSE_Blocks.LIGHT_BLUE_BRICKS);
            mossRecipe(exporter, NSE_Blocks.MOSSY_GREEN_WHITE_TILES, NSE_Blocks.GREEN_WHITE_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_TUFF_TILES, NSE_Blocks.TUFF_TILES);
            mossRecipe(exporter, NSE_Blocks.MOSSY_TUFF_BRICKS, NSE_Blocks.TUFF_BRICKS);

            warningStripeRecipe(exporter, NSE_Blocks.INDUSTRIAL_WARNING, Items.BLACK_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.RED_WARNING, Items.RED_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.BLUE_WARNING, Items.BLUE_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.LIGHT_BLUE_WARNING, Items.LIGHT_BLUE_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.CYAN_WARNING, Items.CYAN_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.YELLOW_WARNING, Items.YELLOW_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.ORANGE_WARNING, Items.ORANGE_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.GREEN_WARNING, Items.GREEN_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.LIME_WARNING, Items.LIME_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.PURPLE_WARNING, Items.PURPLE_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.MAGENTA_WARNING, Items.MAGENTA_DYE);
            warningStripeRecipe(exporter, NSE_Blocks.GRAY_WARNING, Items.GRAY_DYE);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.SAND_TILES);
                list.add(NSE_Blocks.SAND_BRICKS);
                list.add(NSE_Blocks.SMALL_SAND_TILES);
                list.add(NSE_Blocks.BIG_SAND_TILES);
                list.add(NSE_Blocks.BIG_SAND_BRICKS);
                list.add(NSE_Blocks.CROSS_SAND_TILES);
                list.add(NSE_Blocks.HERRINGBONE_SAND_TILES);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.TEAL_TILES);
                list.add(NSE_Blocks.SMALL_TEAL_TILES);
                list.add(NSE_Blocks.GLAZED_TEAL_TILES);
                list.add(NSE_Blocks.VARIATED_TEAL_TILES);
                list.add(Blocks.PRISMARINE_BRICKS);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.AQUAMARINE_TILES);
                list.add(NSE_Blocks.GLAZED_AQUAMARINE_TILES);
                list.add(NSE_Blocks.SMALL_AQUAMARINE_TILES);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.DIORITE_BRICKS);
                list.add(NSE_Blocks.BIG_DIORITE_TILES);
                list.add(NSE_Blocks.SMALL_DIORITE_TILES);
                list.add(Blocks.POLISHED_DIORITE);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CALCITE_TILES);
                list.add(NSE_Blocks.DIAGONAL_CALCITE_TILES);
                list.add(Blocks.CALCITE);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.DRIPSTONE_TILES);
                list.add(NSE_Blocks.DRIPSTONE_BRICKS);
                list.add(Blocks.DRIPSTONE_BLOCK);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.DEEPSLATE_TILES);
                list.add(NSE_Blocks.DIAGONAL_DEEPSLATE_TILES);
                list.add(NSE_Blocks.SMALL_DEEPSLATE_TILES);
                list.add(Blocks.POLISHED_DEEPSLATE);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.LIGHT_BLUE_TILES);
                list.add(NSE_Blocks.LIGHT_BLUE_BRICKS);
                list.add(NSE_Blocks.GLAZED_LIGHT_BLUE_TILES);
                list.add(NSE_Blocks.SMALL_LIGHT_BLUE_TILES);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.BIG_GRANITE_TILES);
                list.add(NSE_Blocks.SMALL_GRANITE_TILES);
                list.add(Blocks.POLISHED_GRANITE);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.TUFF_TILES);
                list.add(NSE_Blocks.TUFF_BRICKS);
                list.add(NSE_Blocks.BIG_TUFF_TILES);
                list.add(Blocks.TUFF);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.SMALL_WHITE_TILES);
                list.add(NSE_Blocks.SMALL_CRACKED_WHITE_TILES);
                list.add(NSE_Blocks.GLAZED_WHITE_TILES);
                list.add(NSE_Blocks.CRACKED_GLAZED_WHITE_TILES);
            }), RecipeCategory.BUILDING_BLOCKS);

            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_ACACIA_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_ACACIA_PLANKS);
                list.add(Blocks.ACACIA_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_OAK_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_OAK_PLANKS);
                list.add(Blocks.OAK_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_BIRCH_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_BIRCH_PLANKS);
                list.add(Blocks.BIRCH_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_CRIMSON_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_CRIMSON_PLANKS);
                list.add(Blocks.CRIMSON_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_DARK_OAK_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_DARK_OAK_PLANKS);
                list.add(Blocks.DARK_OAK_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_JUNGLE_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_JUNGLE_PLANKS);
                list.add(Blocks.JUNGLE_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_MANGROVE_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_MANGROVE_PLANKS);
                list.add(Blocks.MANGROVE_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);
            stoneCuttingCategory(exporter, Util.make(Lists.newArrayList(), list -> {
                list.add(NSE_Blocks.CROSS_SPRUCE_PLANKS);
                list.add(NSE_Blocks.HERRINGBONE_SPRUCE_PLANKS);
                list.add(Blocks.SPRUCE_PLANKS);
            }), RecipeCategory.BUILDING_BLOCKS);

            diceRecipe(exporter, NSE_Items.DICE_D4);
            diceRecipe(exporter, NSE_Items.DICE_D6);
            diceRecipe(exporter, NSE_Items.DICE_D20);

            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSE_Blocks.CHISELED_MANGROVE_DOOR, Blocks.MANGROVE_DOOR);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSE_Blocks.CHISELED_OAK_DOOR, Blocks.OAK_DOOR);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSE_Blocks.CHISELED_SPRUCE_DOOR, Blocks.SPRUCE_DOOR);
            offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NSE_Blocks.CHISELED_BIRCH_DOOR, Blocks.BIRCH_DOOR);

            createStairsRecipe(NSE_Blocks.SAND_TILES_STAIRS, Ingredient.ofItems(NSE_Blocks.SAND_TILES))
                    .criterion(hasItem(NSE_Blocks.SAND_TILES), conditionsFromItem(NSE_Blocks.SAND_TILES)).offerTo(exporter);

            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, NSE_Custom.LIGHT_BULB, 1)
                    .input('X', Items.IRON_INGOT).input('Y', Items.IRON_NUGGET).input('Z', NSE_Items.LIGHT_BULB)
                    .pattern(" X ").pattern(" Y ").pattern(" Z ")
                    .criterion(hasItem(NSE_Items.LIGHT_BULB), conditionsFromItem(NSE_Items.LIGHT_BULB)).offerTo(exporter);
        }
    }

    // This is often used once to generate some model and then move it into "proper" assets folder
    private static class ModelGenerator extends FabricModelProvider {
        private ModelGenerator(FabricDataOutput generator) {
            super(generator);
        }

        @Override
        public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        }

        @Override
        public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        }
    }

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack NSEPack = fabricDataGenerator.createPack();
        NSEPack.addProvider(BlockLootTables::new);
        NSEPack.addProvider(RecipeGenerator::new);
        NSEPack.addProvider(BlockTagGenerator::new);
        NSEPack.addProvider(ModelGenerator::new);
    }
}