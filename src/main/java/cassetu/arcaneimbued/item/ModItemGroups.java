package cassetu.arcaneimbued.item;

import cassetu.arcaneimbued.ArcaneImbued;
import cassetu.arcaneimbued.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ARCANE_IMBUED_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArcaneImbued.MOD_ID, "arcane_imbued_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BATRACHITE))
                    .displayName(Text.translatable("itemgroup.arcane-imbued.arcane_imbued_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BATRACHITE);
                        entries.add(ModItems.RAW_BATRACHITE);

                        entries.add(ModItems.BRICK_WAND);
                        entries.add(ModItems.ARCANE_WAND);
                        entries.add(ModItems.BATRACHITE_WAND);

                        entries.add(ModItems.OBSIDIAN_BATRACHITE_SWORD);

                        entries.add(ModItems.CAULIFLOWER);

                        entries.add(ModItems.STARLIGHT_ASHES);
                    }).build());

    public static final ItemGroup ARCANE_IMBUED_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ArcaneImbued.MOD_ID, "arcane_imbued_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MAGIC_BLOCK))
                    .displayName(Text.translatable("itemgroup.arcane-imbued.arcane_imbued_blocks"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.BATRACHITE_ORE);
                        entries.add(ModBlocks.BATRACHITE_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_BLOCK);

                    }).build());


    public static void registerItemGroups() {
        ArcaneImbued.LOGGER.info("Registering Item Groups for " + ArcaneImbued.MOD_ID);
    }
}
