package cassetu.arcaneimbued.block;

import cassetu.arcaneimbued.ArcaneImbued;
import cassetu.arcaneimbued.block.custom.MagicBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BATRACHITE_ORE = registerBlock("batrachite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));
    public static final Block BATRACHITE_DEEPSLATE_ORE = registerBlock("batrachite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

   public static final Block CARDINAL_SPIKE_CLUSTER = registerBlock("cardinal_spike_cluster",
           new AmethystClusterBlock(7, 3, AbstractBlock.Settings.create()
                   .mapColor(MapColor.PURPLE)
                   .solid()
                   .nonOpaque()
                   .sounds(BlockSoundGroup.AMETHYST_CLUSTER)
                   .strength(1.5F)
                   .luminance(state -> 4)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ArcaneImbued.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ArcaneImbued.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        ArcaneImbued.LOGGER.info("Registering Mod Blocks for " + ArcaneImbued.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        });
    }
}
