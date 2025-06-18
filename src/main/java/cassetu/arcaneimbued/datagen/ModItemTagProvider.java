package cassetu.arcaneimbued.datagen;

import cassetu.arcaneimbued.item.ModItems;
import cassetu.arcaneimbued.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.BATRACHITE)
                .add(ModItems.RAW_BATRACHITE)
                .add(ModItems.CELESTIAL_BLOOM)
                .add(ModItems.CARDINAL_SPIKE)
                .add(ModItems.CERULEAN_DROP)
                .add(ModItems.FOREST_PRISM);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.OBSIDIAN_BATRACHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.ARCANE_WAND)
                .add(ModItems.BRICK_WAND)
                .add(ModItems.BATRACHITE_WAND)
                .add(ModItems.CARDINAL_WAND)
                .add(ModItems.OBSIDIAN_BATRACHITE_SWORD);
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.OBSIDIAN_BATRACHITE_SWORD);
    }
}
