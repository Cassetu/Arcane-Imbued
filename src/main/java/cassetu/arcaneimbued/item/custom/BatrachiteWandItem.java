package cassetu.arcaneimbued.item.custom;

import cassetu.arcaneimbued.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class BatrachiteWandItem extends Item {
    private static final Map<Block, Block> BATRACHITE_WAND_MAP =
            Map.of(
                    Blocks.DIAMOND_ORE, ModBlocks.BATRACHITE_ORE,
                    Blocks.DEEPSLATE_DIAMOND_ORE, ModBlocks.BATRACHITE_DEEPSLATE_ORE
            );

    public BatrachiteWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(BATRACHITE_WAND_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), BATRACHITE_WAND_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.arcane-imbued.batrachite_wand.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.arcane-imbued.press_shift"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
