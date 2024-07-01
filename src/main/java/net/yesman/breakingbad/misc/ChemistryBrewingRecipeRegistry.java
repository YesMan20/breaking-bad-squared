package net.yesman.breakingbad.misc;

import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;

import java.util.List;

public class ChemistryBrewingRecipeRegistry extends BrewingRecipeRegistry {
    public static final List<Recipe<Item, Item>> ITEM_RECIPES = Lists.newArrayList();
    public static final List<Recipe<Potion, Item>> POTION_RECIPES = Lists.newArrayList();

    public static void registerPotionRecipe(Potion input, Item ingredient, Item output) {
        POTION_RECIPES.add(new Recipe<>(input, Ingredient.ofItems(ingredient), output));
    }

    public static void registerItemRecipe(Item input, Item ingredient, Item output) {
        ITEM_RECIPES.add(new Recipe<>(input, Ingredient.ofItems(ingredient), output));
    }

    public static class Recipe<T, A> {
        final T input;
        final Ingredient ingredient;
        final A output;

        public Recipe(T input, Ingredient ingredient, A output) {
            this.input = input;
            this.ingredient = ingredient;
            this.output = output;
        }
    }
}
