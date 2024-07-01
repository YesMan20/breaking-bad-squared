package net.yesman.breakingbad.server.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemStack;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.command.argument.BlockArgumentParser;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.item.trim.ArmorTrim;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.*;
import net.minecraft.util.*;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public final class BBSItemStack implements FabricItemStack {
    public static final BBSItemStack EMPTY = new BBSItemStack((Void)null);
    private int count;
    @Nullable
    private final Item item;
    @Nullable
    private NbtCompound nbt;

    public BBSItemStack(ItemConvertible item) {
        this(item, 1);
    }

    public BBSItemStack(RegistryEntry<Item> entry) {
        this(entry.value(), 1);
    }

    public BBSItemStack(ItemConvertible item, int count, Optional<NbtCompound> nbt) {
        this(item, count);
        nbt.ifPresent(this::setNbt);
    }

    public BBSItemStack(RegistryEntry<Item> itemEntry, int count) {
        this(itemEntry.value(), count);
    }

    public BBSItemStack(ItemConvertible item, int count) {
        this.item = item.asItem();
        this.count = count;
        if (this.item.isDamageable()) {
            this.setDamage(this.getDamage());
        }

    }

    private BBSItemStack(@Nullable Void void_) {
        this.item = null;
    }

    public boolean isEmpty() {
        return this == EMPTY || this.item == Items.AIR || this.count <= 0;
    }

    public Item getItem() {
        return this.isEmpty() ? Items.AIR : this.item;
    }

    public int getDamage() {
        return this.nbt == null ? 0 : this.nbt.getInt("Damage");
    }

    public void setDamage(int damage) {
        this.getOrCreateNbt().putInt("Damage", Math.max(0, damage));
    }

    public String toString() {
        int var10000 = this.getCount();
        return "" + var10000 + " " + this.getItem();
    }

    public boolean hasNbt() {
        return !this.isEmpty() && this.nbt != null && !this.nbt.isEmpty();
    }

    @Nullable
    public NbtCompound getNbt() {
        return this.nbt;
    }

    public NbtCompound getOrCreateNbt() {
        if (this.nbt == null) {
            this.setNbt(new NbtCompound());
        }

        return this.nbt;
    }

    public void setNbt(@Nullable NbtCompound nbt) {
        this.nbt = nbt;
        if (this.getItem().isDamageable()) {
            this.setDamage(this.getDamage());
        }

        if (nbt != null) {
            this.getItem().postProcessNbt(nbt);
        }

    }

    public void setSubNbt(String key, NbtElement element) {
        this.getOrCreateNbt().put(key, element);
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        Object multimap;
        if (this.hasNbt() && this.nbt.contains("AttributeModifiers", 9)) {
            multimap = HashMultimap.create();
            NbtList nbtList = this.nbt.getList("AttributeModifiers", 10);

            for(int i = 0; i < nbtList.size(); ++i) {
                NbtCompound nbtCompound = nbtList.getCompound(i);
                if (!nbtCompound.contains("Slot", 8) || nbtCompound.getString("Slot").equals(slot.getName())) {
                    Optional<EntityAttribute> optional = Registries.ATTRIBUTE.getOrEmpty(Identifier.tryParse(nbtCompound.getString("AttributeName")));
                    if (optional.isPresent()) {
                        EntityAttributeModifier entityAttributeModifier = EntityAttributeModifier.fromNbt(nbtCompound);
                        if (entityAttributeModifier != null && entityAttributeModifier.getId().getLeastSignificantBits() != 0L && entityAttributeModifier.getId().getMostSignificantBits() != 0L) {
                            ((Multimap)multimap).put((EntityAttribute)optional.get(), entityAttributeModifier);
                        }
                    }
                }
            }
        } else {
            multimap = this.getItem().getAttributeModifiers(slot);
        }

        return (Multimap)multimap;
    }

    public int getCount() {
        return this.isEmpty() ? 0 : this.count;
    }
}
