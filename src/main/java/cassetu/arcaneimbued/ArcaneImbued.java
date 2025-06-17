package cassetu.arcaneimbued;

import cassetu.arcaneimbued.block.ModBlocks;
import cassetu.arcaneimbued.item.ModItemGroups;
import cassetu.arcaneimbued.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArcaneImbued implements ModInitializer {
	public static final String MOD_ID = "arcane-imbued";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);
	}
}