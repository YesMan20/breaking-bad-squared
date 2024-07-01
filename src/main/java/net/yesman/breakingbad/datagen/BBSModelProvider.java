package net.yesman.breakingbad.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.yesman.breakingbad.server.items.BBSItemsRegistry;

public class BBSModelProvider extends FabricModelProvider {
    public BBSModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(BBSItemsRegistry.PURE_CRYSTAL_METH, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.PURE_POWDERED_METH, Models.GENERATED);

        itemModelGenerator.register(BBSItemsRegistry.CRYSTAL_METH, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.POWDERED_METH, Models.GENERATED);

        itemModelGenerator.register(BBSItemsRegistry.SUSPICIOUS_CRYSTAL_METH, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.SUSPICIOUS_POWDERED_METH, Models.GENERATED);

        itemModelGenerator.register(BBSItemsRegistry.HYDROGEN, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.METHYNOL, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.NITROGEN, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.AMMONIA, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.METHYLAMINE, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.OXYGEN, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.ACETIC_ANHYDRIDE, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.PHENYLACETIC_ACID, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.PHENYLACETONE, Models.GENERATED);

        itemModelGenerator.register(BBSItemsRegistry.CYANIDE, Models.GENERATED);
        itemModelGenerator.register(BBSItemsRegistry.PHARMACEUTIC_POTION, Models.GENERATED);
    }
}
