package cassetu.arcaneimbued.datagen;

import cassetu.arcaneimbued.block.ModBlocks;
import cassetu.arcaneimbued.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BATRACHITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BATRACHITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        blockStateModelGenerator.registerAmethyst(ModBlocks.CARDINAL_SPIKE_CLUSTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BATRACHITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BATRACHITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_BLADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARDINAL_SPIKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CELESTIAL_BLOOM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CERULEAN_DROP, Models.GENERATED);

        itemModelGenerator.register(ModItems.BATRACHITE_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARCANE_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRICK_WAND, Models.HANDHELD);
        itemModelGenerator.register(ModItems.CARDINAL_WAND, Models.HANDHELD);

        itemModelGenerator.register(ModItems.STARLIGHT_ASHES, Models.GENERATED);

        itemModelGenerator.register(ModItems.OBSIDIAN_BATRACHITE_SWORD, Models.HANDHELD);
    }
}
