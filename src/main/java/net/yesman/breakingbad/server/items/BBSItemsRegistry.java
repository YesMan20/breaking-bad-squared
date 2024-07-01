package net.yesman.breakingbad.server.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.yesman.breakingbad.BreakingBadSquared;

public class BBSItemsRegistry {
    public static final Item PURE_CRYSTAL_METH = registerItem("pure_crystal_meth", new Item(new FabricItemSettings()));
    public static final Item PURE_POWDERED_METH = registerItem("pure_powdered_meth", new Item(new FabricItemSettings().food(BBSFoodComponents.POWDERED_METH)));

    public static final Item CRYSTAL_METH = registerItem("crystal_meth", new Item(new FabricItemSettings()));
    public static final Item POWDERED_METH = registerItem("powdered_meth", new Item(new FabricItemSettings().food(BBSFoodComponents.POWDERED_METH)));

    public static final Item SUSPICIOUS_CRYSTAL_METH = registerItem("suspicious_crystal_meth", new Item(new FabricItemSettings()));
    public static final Item SUSPICIOUS_POWDERED_METH = registerItem("suspicious_powdered_meth", new Item(new FabricItemSettings().food(BBSFoodComponents.SUSPICIOUS_POWDERED_METH)));

    public static final Item CYANIDE = registerItem("cyanide", new Item(new FabricItemSettings().food(BBSFoodComponents.CYANIDE)));
    public static final Item IODINE = registerItem("iodine", new Item(new FabricItemSettings()));
    public static final Item RED_PHOSPHORUS = registerItem("red_phosphorus", new Item(new FabricItemSettings()));
    public static final Item WHITE_PHOSPHORUS = registerItem("white_phosphorus", new Item(new FabricItemSettings()));
    public static final Item PSEUDOEPHEDRINE = registerItem("pseudoephedrine", new Item(new FabricItemSettings()));

    public static final Item PHARMACEUTIC_POTION = registerItem("pharmaceutic_potion", new PotionItem(new FabricItemSettings().maxCount(1)));

    public static final Item HYDROGEN = registerItem("hydrogen", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item METHYNOL = registerItem("methynol", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item NITROGEN = registerItem("nitrogen", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item AMMONIA = registerItem("ammonia", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item METHYLAMINE = registerItem("methylamine", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item OXYGEN = registerItem("oxygen", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item ACETIC_ANHYDRIDE = registerItem("acetic_anhydride", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item PHENYLACETIC_ACID = registerItem("phenylacetic_acid", new PotionItem(new FabricItemSettings().maxCount(1)));
    public static final Item PHENYLACETONE = registerItem("phenylacetone", new PotionItem(new FabricItemSettings().maxCount(1)));

    public static void addItemsToFoodItemGroup(FabricItemGroupEntries entries) {
        entries.add(PURE_CRYSTAL_METH);
        entries.add(PURE_POWDERED_METH);

        entries.add(CRYSTAL_METH);
        entries.add(POWDERED_METH);

        entries.add(SUSPICIOUS_CRYSTAL_METH);
        entries.add(SUSPICIOUS_POWDERED_METH);
    }

    public static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(HYDROGEN);
        entries.add(METHYNOL);
        entries.add(NITROGEN);
        entries.add(AMMONIA);
        entries.add(METHYLAMINE);
        entries.add(OXYGEN);
        entries.add(ACETIC_ANHYDRIDE);
        entries.add(PHENYLACETIC_ACID);
        entries.add(PHENYLACETONE);
        entries.addAfter(Items.GUNPOWDER, CYANIDE);
        entries.addAfter(CYANIDE, IODINE);
        entries.addAfter(IODINE, WHITE_PHOSPHORUS);
        entries.addAfter(WHITE_PHOSPHORUS, RED_PHOSPHORUS);
        entries.addAfter(RED_PHOSPHORUS, PSEUDOEPHEDRINE);
        entries.addAfter(Items.DRAGON_BREATH, PHARMACEUTIC_POTION);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(BreakingBadSquared.MODID, name), item);
    }

    public static void registerModItems() {
        BreakingBadSquared.LOGGER.info("Registering items for" + BreakingBadSquared.MODID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(BBSItemsRegistry::addItemsToFoodItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(BBSItemsRegistry::addItemsToIngredientItemGroup);
    }
}
