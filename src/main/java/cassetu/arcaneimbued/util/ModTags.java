package cassetu.arcaneimbued.util;

import cassetu.arcaneimbued.ArcaneImbued;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> NEEDS_BATRACHITE_TOOL = createTag("needs_batrachite_tool");
        public static TagKey<Block> INCORRECT_FOR_BATRACHITE_TOOL = createTag("incorrect_for_batrachite_tool");

        public static TagKey<Block> NEEDS_CARDINAL_TOOL = createTag("needs_cardinal_tool");
        public static TagKey<Block> INCORRECT_FOR_CARDINAL_TOOL = createTag("incorrect_for_cardinal_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ArcaneImbued.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ArcaneImbued.MOD_ID, name));
        }
    }
}
