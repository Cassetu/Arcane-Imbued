package cassetu.arcaneimbued.datagen;

import cassetu.arcaneimbued.ArcaneImbued;
import cassetu.arcaneimbued.block.ModBlocks;
import cassetu.arcaneimbued.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> BATRACHITE_SMELTABLES = List.of(ModItems.RAW_BATRACHITE, ModBlocks.BATRACHITE_ORE,
                ModBlocks.BATRACHITE_DEEPSLATE_ORE);

        offerSmelting(exporter, BATRACHITE_SMELTABLES, RecipeCategory.MISC, ModItems.BATRACHITE, 0.25f, 800, "batrachite");
        offerBlasting(exporter, BATRACHITE_SMELTABLES, RecipeCategory.MISC, ModItems.BATRACHITE, 0.25f, 400, "batrachite");

//        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.OBSIDIAN_BATRACHITE_SWORD)
                .pattern(" O ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.BATRACHITE)
                .input('O', ModItems.OBSIDIAN_BLADE)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BATRACHITE), conditionsFromItem(ModItems.BATRACHITE))
                .criterion(hasItem(ModItems.OBSIDIAN_BLADE), conditionsFromItem(ModItems.OBSIDIAN_BLADE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.OBSIDIAN_BLADE)
                .pattern(" O ")
                .pattern(" O ")
                .pattern(" O ")
                .input('O', Items.OBSIDIAN)
                .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                .offerTo(exporter);

//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
//                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
//                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
//                .offerTo(exporter);
    }
}
