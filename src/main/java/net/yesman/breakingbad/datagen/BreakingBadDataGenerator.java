package net.yesman.breakingbad.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.RecipeCraftedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.yesman.breakingbad.BreakingBadSquared;
import net.yesman.breakingbad.server.items.BBSItemsRegistry;

import java.util.function.Consumer;

public class BreakingBadDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BBSLangProvider::new);
		pack.addProvider(BBSModelProvider::new);
		pack.addProvider(AdvancementsProvider::new);

	}

	static class AdvancementsProvider extends FabricAdvancementProvider {
		protected AdvancementsProvider(FabricDataOutput dataGenerator) {
			super(dataGenerator);
		}

		@Override
		public void generateAdvancement(Consumer<Advancement> consumer) {
			Advancement BASE = Advancement.Builder.create()
					.display(
							BBSItemsRegistry.PURE_POWDERED_METH,
							Text.literal("Jesse, we Need to Cook"),
							Text.literal("Make your first batch of Pure Powdered Meth"),
							new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
							AdvancementFrame.GOAL,
							true,
							true,
							true
					)
					.criterion("jesse_we_need_to_cook", InventoryChangedCriterion.Conditions.items(BBSItemsRegistry.PURE_POWDERED_METH))
					.build(consumer, BreakingBadSquared.MODID + "/jesse_we_need_to_cook");
		}
	}
}
