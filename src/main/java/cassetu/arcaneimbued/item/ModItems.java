package cassetu.arcaneimbued.item;

import cassetu.arcaneimbued.ArcaneImbued;
import cassetu.arcaneimbued.item.custom.ArcaneWandItem;
import cassetu.arcaneimbued.item.custom.BatrachiteWandItem;
import cassetu.arcaneimbued.item.custom.BrickWandItem;
import cassetu.arcaneimbued.item.custom.CardinalWandItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item BATRACHITE = registerItem("batrachite", new Item(new Item.Settings()));
    public static final Item RAW_BATRACHITE = registerItem("raw_batrachite", new Item(new Item.Settings()));

    public static final Item BRICK_WAND = registerItem("brick_wand", new BrickWandItem(new Item.Settings().maxDamage(32)));
    public static final Item ARCANE_WAND = registerItem("arcane_wand", new ArcaneWandItem(new Item.Settings().maxDamage(56)));
    public static final Item BATRACHITE_WAND = registerItem("batrachite_wand", new BatrachiteWandItem(new Item.Settings().maxDamage(32)));
    public static final Item CARDINAL_WAND = registerItem("cardinal_wand", new CardinalWandItem(new Item.Settings().maxDamage(32)));

    public static final Item OBSIDIAN_BLADE = registerItem("obsidian_blade", new Item(new Item.Settings()));
    public static final Item CARDINAL_SPIKE = registerItem("cardinal_spike", new Item(new Item.Settings()));
    public static final Item CELESTIAL_BLOOM = registerItem("celestial_bloom", new Item(new Item.Settings()));
    public static final Item CERULEAN_DROP = registerItem("cerulean_drop", new Item(new Item.Settings()));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.arcane-imbued.cauliflower.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    public static final Item OBSIDIAN_BATRACHITE_SWORD = registerItem("obsidian_batrachite_sword",
            new SwordItem(ModToolMaterials.BATRACHITE, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BATRACHITE, 3, -2.4f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ArcaneImbued.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ArcaneImbued.LOGGER.info("Registering Mod Items for " + ArcaneImbued.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BATRACHITE);
            entries.add(RAW_BATRACHITE);
        });
    }
}