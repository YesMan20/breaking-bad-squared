package net.yesman.breakingbad;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Items;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.yesman.breakingbad.server.items.BBSItemsRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BreakingBadSquared implements ModInitializer {
	public static final String MODID = "bbsquared";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		BBSItemsRegistry.registerModItems();
		registerChemicalRecipes();
	}

	public static void registerChemicalRecipes() {
		BrewingRecipeRegistry.registerItemRecipe(
                BBSItemsRegistry.PHARMACEUTIC_POTION,
				Items.NETHERITE_INGOT,
				BBSItemsRegistry.HYDROGEN);
		BrewingRecipeRegistry.registerItemRecipe(
				BBSItemsRegistry.PHARMACEUTIC_POTION,
				Items.COPPER_INGOT,
				BBSItemsRegistry.OXYGEN);
		BrewingRecipeRegistry.registerItemRecipe(
				Items.POTION,
				Items.GOLDEN_CARROT,
				BBSItemsRegistry.PHARMACEUTIC_POTION);
	}
}