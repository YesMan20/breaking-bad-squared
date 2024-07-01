package net.yesman.breakingbad.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.yesman.breakingbad.server.items.BBSItemsRegistry;

public class BBSLangProvider extends FabricLanguageProvider {
    protected BBSLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        // Items
        translationBuilder.add(BBSItemsRegistry.PURE_CRYSTAL_METH, "Pure Crystal Methamphetamine");
        translationBuilder.add(BBSItemsRegistry.PURE_POWDERED_METH, "Pure Powdered Methamphetamine");

        translationBuilder.add(BBSItemsRegistry.CRYSTAL_METH, "Crystal Methamphetamine");
        translationBuilder.add(BBSItemsRegistry.POWDERED_METH, "Powdered Methamphetamine");

        translationBuilder.add(BBSItemsRegistry.SUSPICIOUS_CRYSTAL_METH, "Suspicious Crystal Methamphetamine");
        translationBuilder.add(BBSItemsRegistry.SUSPICIOUS_POWDERED_METH, "Suspicious Powdered Methamphetamine");

        translationBuilder.add("item.bbsquared.hydrogen.effect.empty", "Bottle of Hydrogen");
        translationBuilder.add("item.bbsquared.methynol.effect.empty", "Bottle of Methynol");
        translationBuilder.add("item.bbsquared.nitrogen.effect.empty", "Bottle of Nitrogen");
        translationBuilder.add("item.bbsquared.ammonia.effect.empty", "Bottle of Ammonia");
        translationBuilder.add("item.bbsquared.methylamine.effect.empty", "Bottle of Methylamine");
        translationBuilder.add("item.bbsquared.oxygen.effect.empty", "Bottle of Oxygen");
        translationBuilder.add("item.bbsquared.acetic_anhydride.effect.empty", "Bottle of Acetic Anhydride");
        translationBuilder.add("item.bbsquared.phenylacetic_acid.effect.empty", "Bottle of Phenylacetic Acid");
        translationBuilder.add("item.bbsquared.phenylacetone.effect.empty", "Bottle of Phenylacetone");

        translationBuilder.add(BBSItemsRegistry.CYANIDE, "Cyanide");
        translationBuilder.add(BBSItemsRegistry.IODINE, "Iodine");
        translationBuilder.add(BBSItemsRegistry.RED_PHOSPHORUS, "Red Phosphorus");
        translationBuilder.add(BBSItemsRegistry.WHITE_PHOSPHORUS, "White Phosphorus");
        translationBuilder.add(BBSItemsRegistry.PSEUDOEPHEDRINE, "Pseudophedrine");
        translationBuilder.add("item.bbsquared.pharmaceutic_potion.effect.empty", "Pharmaceutic Potion");

        //ToolTipped Compat
        translationBuilder.add("yapping_tooltips.item.bbsquared.pure_crystal_meth.desc", "The purest of crystal methamphetamine, made from phenylacetone  & methylamine.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.pure_powdered_meth.desc", "Pure crystal meth crushed up into a fine powder.");

        translationBuilder.add("yapping_tooltips.item.bbsquared.crystal_meth.desc", "A fine crystal methamphetamine made from iodine, red phosphorus, pseudoephedrine, and water.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.powdered_meth.desc", "Crystal methamphetamine crushed into powder");

        translationBuilder.add("yapping_tooltips.item.bbsquared.hydrogen.desc", "A bottle of hydrogen, made by mixing the pharmaceutic potion and a netherite ingot.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.methynol.desc", "A bottle of methynol, made by mixing hydrogen, a netherite ingot, and charcoal.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.nitrogen.desc", "A bottle of nitrogen, made by combining 3 potatoes and an empty bottle.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.ammonia.desc", "A bottle of ammonia, made by heating up nitrogen.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.methylamine.desc", "A bottle of methylamine, made by mixing nitrogen, an amethyst shard, and methynol.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.oxygen.desc", "A bottle of oxygen, made by mixing the pharmaceutic potion and a copper ingot.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.acetic_anhydride.desc", "A bottle of acetic anhydride, made by combining oxygen and sugar.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.phenylacetic_acid.desc", "A bottle of phenylacetic acid, made by mixing cyanide and the pharmaceutic potion.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.phrnylacetone.desc", "A bottle of phenylacetone, made by mixing acetic anhydride and phenylacetic acid.");

        translationBuilder.add("yapping_tooltips.item.bbsquared.cyanide.desc", "A deadly poison extracted from bamboo.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.iodine.desc", "A nonmetallic chemical element extracted from seaweed.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.red_phosphorus.desc", "A flammable chemical made by heating up white phosphorus.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.white_phosphorus.desc", "A powder-like chemical extracted from sand.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.pseudoephedrine.desc", "A powder-like chemical extracted from wheat.");
        translationBuilder.add("yapping_tooltips.item.bbsquared.pharmaceutic_potion.desc", "A potion made by mixing water & golden carrots.");
    }
}
