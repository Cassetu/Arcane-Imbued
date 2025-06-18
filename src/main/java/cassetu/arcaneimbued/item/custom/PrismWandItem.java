package cassetu.arcaneimbued.item.custom;

import cassetu.arcaneimbued.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class PrismWandItem extends Item {
    private static final Map<Block, Block> PRISM_WAND_MAP =
            Map.of(
                    Blocks.FLOWERING_AZALEA_LEAVES, ModBlocks.AZALEA_PRISM_LEAVES
            );

    public PrismWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState clickedBlockState = world.getBlockState(pos);
        Block clickedBlock = clickedBlockState.getBlock();

        if(PRISM_WAND_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                Block newBlock = PRISM_WAND_MAP.get(clickedBlock);
                BlockState newBlockState = newBlock.getDefaultState();

                // Copy the WATERLOGGED property if it exists
                if (clickedBlockState.contains(Properties.WATERLOGGED) && newBlockState.contains(Properties.WATERLOGGED)) {
                    newBlockState = newBlockState.with(Properties.WATERLOGGED, clickedBlockState.get(Properties.WATERLOGGED));
                }

                world.setBlockState(pos, newBlockState);

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, pos, SoundEvents.BLOCK_AZALEA_LEAVES_HIT, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.arcane-imbued.prism_wand.tooltip"));
        } else {
            tooltip.add(Text.translatable("tooltip.arcane-imbued.press_shift"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
