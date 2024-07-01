package net.yesman.breakingbad;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.yesman.breakingbad.misc.ChemistryBrewingRecipeRegistry;
import net.yesman.breakingbad.server.items.BBSItemStack;
import net.yesman.breakingbad.server.items.BBSItemsRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class BreakingBadSquared implements ModInitializer {
	public static final String MODID = "bbsquared";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		BBSItemsRegistry.registerModItems();
		registerChemicalRecipes();
	}

	public static void registerChemicalRecipes() {
		ChemistryBrewingRecipeRegistry.registerItemRecipe(
                BBSItemsRegistry.PHARMACEUTIC_POTION,
				Items.NETHERITE_INGOT,
				BBSItemsRegistry.HYDROGEN);
		ChemistryBrewingRecipeRegistry.registerItemRecipe(
				BBSItemsRegistry.PHARMACEUTIC_POTION,
				Items.COPPER_INGOT,
				BBSItemsRegistry.OXYGEN);
		ChemistryBrewingRecipeRegistry.registerPotionRecipe(
				Potions.WATER,
				Items.GOLDEN_CARROT,
				BBSItemsRegistry.PHARMACEUTIC_POTION);
	}
}