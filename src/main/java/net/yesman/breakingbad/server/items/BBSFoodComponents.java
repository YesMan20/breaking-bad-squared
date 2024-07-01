package net.yesman.breakingbad.server.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class BBSFoodComponents {
    public static final FoodComponent POWDERED_METH = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 1), 100.0f)
            .build();

    public static final FoodComponent SUSPICIOUS_POWDERED_METH = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 9500, 2), 100.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 9500, 3), 100.0F)
            .build();

    public static final FoodComponent CYANIDE = new FoodComponent.Builder()
            .hunger(0)
            .saturationModifier(0f)
            .alwaysEdible()
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER, 9500, 10), 100.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 9500, 1), 100.0F)
            .build();
}
