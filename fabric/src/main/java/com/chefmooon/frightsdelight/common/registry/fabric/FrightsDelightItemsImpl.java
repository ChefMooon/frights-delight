package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.item.*;
import com.chefmooon.frightsdelight.common.item.fabric.BoneShardItemImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightItems.*;

public class FrightsDelightItemsImpl {

    public static Item.Properties boneFoodItem(FoodProperties food) {
        return boneFoodItem(food, null);
    }

    public static Item.Properties boneFoodItem(FoodProperties food, @Nullable Consumable consumable) {
        return new Item.Properties().food(food)
                .component(DataComponents.CONSUMABLE, consumable != null ? consumable : Consumables.DEFAULT_FOOD)
                .craftRemainder(FrightsDelightItemsImpl.BONE_SHARD.get())
                .stacksTo(16);
    }

    public static final Supplier<Item> PUMPKIN_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.PUMPKIN_CANDY_BASKET,
            (properties) -> new CandyBasketItem(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get(),
                    properties.overrideDescription(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get().getDescriptionId()), CandyBasketType.PUMPKIN),
            noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));
    public static final Supplier<Item> MELON_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.MELON_CANDY_BASKET,
            (properties) -> new CandyBasketItem(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get(),
                    properties.overrideDescription(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get().getDescriptionId()), CandyBasketType.MELON),
            noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY));

    public static final Supplier<Item> UNFIRED_LOLLIPOP_MOLD = registerItemWithTab(FrightsDelightItems.UNFIRED_LOLLIPOP_MOLD,
            Item::new, basicItem());
    public static final Supplier<Item> LOLLIPOP_MOLD = registerBlockWithTab(FrightsDelightItems.LOLLIPOP_MOLD,
            BlockItem::new, FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get(), basicItem());
    public static final Supplier<Item> UNFIRED_RING_CANDY_MOLD = registerItemWithTab(FrightsDelightItems.UNFIRED_RING_CANDY_MOLD,
            Item::new, basicItem());
    public static final Supplier<Item> RING_CANDY_MOLD = registerBlockWithTab(FrightsDelightItems.RING_CANDY_MOLD,
            BlockItem::new, FrightsDelightBlocksImpl.RING_CANDY_MOLD.get(), basicItem());

    public static final Supplier<Item> FLESH_CRATE = registerBlockWithTab(FrightsDelightItems.FLESH_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.FLESH_CRATE.get(), basicItem());
    public static final Supplier<Item> BONE_CRATE = registerBlockWithTab(FrightsDelightItems.BONE_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.BONE_CRATE.get(), basicItem());
    public static final Supplier<Item> PHANTOM_CRATE = registerBlockWithTab(FrightsDelightItems.PHANTOM_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.PHANTOM_CRATE.get(), basicItem());
    public static final Supplier<Item> WEB_CRATE = registerBlockWithTab(FrightsDelightItems.WEB_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.WEB_CRATE.get(), basicItem());
    public static final Supplier<Item> SPIDER_EYE_CRATE = registerBlockWithTab(FrightsDelightItems.SPIDER_EYE_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get(), basicItem());
    public static final Supplier<Item> FERMENTED_SPIDER_EYE_CRATE = registerBlockWithTab(FrightsDelightItems.FERMENTED_SPIDER_EYE_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get(), basicItem());
    public static final Supplier<Item> POISONOUS_POTATO_CRATE = registerBlockWithTab(FrightsDelightItems.POISONOUS_POTATO_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get(), basicItem());
    public static final Supplier<Item> ROTTEN_TOMATO_CRATE = registerBlockWithTab(FrightsDelightItems.ROTTEN_TOMATO_CRATE,
            BlockItem::new, FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get(),  basicItem());

    public static final Supplier<Item> BONE_SHARD = registerItemWithTab(FrightsDelightItems.BONE_SHARD,
            BoneShardItemImpl::new, basicItem());

    public static final Supplier<Item> SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY,
            (properties) -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), properties, true),
            foodItem(FoodValues.SOUL_BERRY, FoodValues.ConsumableValues.SOUL_BERRY));
    public static final Supplier<Item> WITHER_BERRY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY,
            (properties) -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), properties, true),
            foodItem(FoodValues.WITHER_BERRY, FoodValues.ConsumableValues.WITHER_BERRY));

    public static final Supplier<Item> ROTTEN_FLESH_LOLLIPOP = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.ROTTEN_FLESH_LOLLIPOP, FoodValues.ConsumableValues.ROTTEN_FLESH_LOLLIPOP));
    public static final Supplier<Item> SPIDEREYE_LOLLIPOP = registerItemWithTab(FrightsDelightItems.SPIDEREYE_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SPIDEREYE_LOLLIPOP, FoodValues.ConsumableValues.SPIDEREYE_LOLLIPOP));
    public static final Supplier<Item> SLIMEAPPLE_LOLLIPOP = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SLIMEAPPLE_LOLLIPOP, FoodValues.ConsumableValues.SLIMEAPPLE_LOLLIPOP));
    public static final Supplier<Item> COBWEB_LOLLIPOP = registerItemWithTab(FrightsDelightItems.COBWEB_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COBWEB_LOLLIPOP, FoodValues.ConsumableValues.COBWEB_LOLLIPOP));
    public static final Supplier<Item> GHASTTEAR_LOLLIPOP = registerItemWithTab(FrightsDelightItems.GHASTTEAR_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.GHASTTEAR_LOLLIPOP, FoodValues.ConsumableValues.GHASTTEAR_LOLLIPOP));
    public static final Supplier<Item> SOUL_BERRY_LOLLIPOP = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SOUL_BERRY_LOLLIPOP, FoodValues.ConsumableValues.SOUL_BERRY_LOLLIPOP));
    public static final Supplier<Item> WITHER_BERRY_LOLLIPOP = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_LOLLIPOP,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.WITHER_BERRY_LOLLIPOP, FoodValues.ConsumableValues.WITHER_BERRY_LOLLIPOP));

    public static final Supplier<Item> ROTTEN_FLESH_RING_CANDY = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.ROTTEN_FLESH_RING_CANDY, FoodValues.ConsumableValues.ROTTEN_FLESH_RING_CANDY));
    public static final Supplier<Item> SPIDEREYE_RING_CANDY = registerItemWithTab(FrightsDelightItems.SPIDEREYE_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SPIDEREYE_RING_CANDY, FoodValues.ConsumableValues.SPIDEREYE_RING_CANDY));
    public static final Supplier<Item> SLIMEAPPLE_RING_CANDY = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SLIMEAPPLE_RING_CANDY, FoodValues.ConsumableValues.SLIMEAPPLE_RING_CANDY));
    public static final Supplier<Item> COBWEB_RING_CANDY = registerItemWithTab(FrightsDelightItems.COBWEB_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COBWEB_RING_CANDY, FoodValues.ConsumableValues.COBWEB_RING_CANDY));
    public static final Supplier<Item> GHASTTEAR_RING_CANDY = registerItemWithTab(FrightsDelightItems.GHASTTEAR_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.GHASTTEAR_RING_CANDY, FoodValues.ConsumableValues.GHASTTEAR_RING_CANDY));
    public static final Supplier<Item> SOUL_BERRY_RING_CANDY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SOUL_BERRY_RING_CANDY, FoodValues.ConsumableValues.SOUL_BERRY_RING_CANDY));
    public static final Supplier<Item> WITHER_BERRY_RING_CANDY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_RING_CANDY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.WITHER_BERRY_RING_CANDY, FoodValues.ConsumableValues.WITHER_BERRY_RING_CANDY));

    public static final Supplier<Item> APPLE_SLIME = registerItemWithTab(FrightsDelightItems.APPLE_SLIME,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.APPLE_SLIME, FoodValues.ConsumableValues.APPLE_SLIME));
    public static final Supplier<Item> UNDEAD_KEBAB = registerItemWithTab(FrightsDelightItems.UNDEAD_KEBAB,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.UNDEAD_KEBAB, FoodValues.ConsumableValues.UNDEAD_KEBAB));

    public static final Supplier<Item> BONE_KEBAB_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_ROTTEN_FLESH,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_ROTTEN_FLESH, FoodValues.ConsumableValues.BONE_KEBAB_ROTTEN_FLESH));
    public static final Supplier<Item> BONE_KEBAB_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SPIDER_EYE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_SPIDER_EYE, FoodValues.ConsumableValues.BONE_KEBAB_SPIDER_EYE));
    public static final Supplier<Item> BONE_KEBAB_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SLIMEAPPLE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_SLIMEAPPLE, FoodValues.ConsumableValues.BONE_KEBAB_SLIMEAPPLE));
    public static final Supplier<Item> BONE_KEBAB_SLIME = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SLIME,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_SLIME, FoodValues.ConsumableValues.BONE_KEBAB_SLIME));
    public static final Supplier<Item> WEB_ON_STICK = registerItemWithTab(FrightsDelightItems.WEB_ON_STICK,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.WEB_ON_STICK, FoodValues.ConsumableValues.WEB_ON_STICK));
    public static final Supplier<Item> BONE_KEBAB_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_GHAST_TEAR,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_GHAST_TEAR, FoodValues.ConsumableValues.BONE_KEBAB_GHAST_TEAR));

    public static final Supplier<Item> BONE_KEBAB_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SOUL_BERRY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_SOUL_BERRY, FoodValues.ConsumableValues.BONE_KEBAB_SOUL_BERRY));
    public static final Supplier<Item> BONE_KEBAB_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_WITHER_BERRY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            boneFoodItem(FoodValues.BONE_KEBAB_WITHER_BERRY, FoodValues.ConsumableValues.BONE_KEBAB_WITHER_BERRY));

    public static final Supplier<Item> MONSTER_MASH = registerItemWithTab(FrightsDelightItems.MONSTER_MASH,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.MONSTER_MASH, FoodValues.ConsumableValues.MONSTER_MASH));
    public static final Supplier<Item> PASTA_WITH_SLIMEBALLS = registerItemWithTab(FrightsDelightItems.PASTA_WITH_SLIMEBALLS,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.PASTA_WITH_SLIMEBALLS, FoodValues.ConsumableValues.PASTA_WITH_SLIMEBALLS));

    public static final Supplier<Item> SOUP_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.SOUP_ROTTEN_FLESH,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_ROTTEN_FLESH, FoodValues.ConsumableValues.SOUP_ROTTEN_FLESH));
    public static final Supplier<Item> SOUP_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.SOUP_SPIDER_EYE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_SPIDER_EYE, FoodValues.ConsumableValues.SOUP_SPIDER_EYE));
    public static final Supplier<Item> SOUP_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.SOUP_SLIMEAPPLE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_SLIME, FoodValues.ConsumableValues.SOUP_SLIME));
    public static final Supplier<Item> SOUP_SLIME = registerItemWithTab(FrightsDelightItems.SOUP_SLIME,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_SLIME, FoodValues.ConsumableValues.SOUP_SLIME));
    public static final Supplier<Item> SOUP_COBWEB = registerItemWithTab(FrightsDelightItems.SOUP_COBWEB,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_COBWEB, FoodValues.ConsumableValues.SOUP_COBWEB));
    public static final Supplier<Item> SOUP_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.SOUP_GHAST_TEAR,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_GHAST_TEAR, FoodValues.ConsumableValues.SOUP_GHAST_TEAR));
    public static final Supplier<Item> SOUP_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUP_SOUL_BERRY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_SOUL_BERRY, FoodValues.ConsumableValues.SOUP_SOUL_BERRY));
    public static final Supplier<Item> SOUP_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.SOUP_WITHER_BERRY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            bowlFoodItem(FoodValues.SOUP_WITHER_BERRY, FoodValues.ConsumableValues.SOUP_WITHER_BERRY));

    public static final Supplier<Item> COOKIE_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.COOKIE_ROTTEN_FLESH,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_ROTTEN_FLESH, FoodValues.ConsumableValues.COOKIE_ROTTEN_FLESH));
    public static final Supplier<Item> COOKIE_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.COOKIE_SPIDER_EYE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_SPIDER_EYE, FoodValues.ConsumableValues.COOKIE_SPIDER_EYE));
    public static final Supplier<Item> COOKIE_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.COOKIE_SLIMEAPPLE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_SLIMEAPPLE, FoodValues.ConsumableValues.COOKIE_SLIMEAPPLE));
    public static final Supplier<Item> COOKIE_SLIME = registerItemWithTab(FrightsDelightItems.COOKIE_SLIME,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_SLIME, FoodValues.ConsumableValues.COOKIE_SLIME));
    public static final Supplier<Item> COOKIE_COBWEB = registerItemWithTab(FrightsDelightItems.COOKIE_COBWEB,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_COBWEB, FoodValues.ConsumableValues.COOKIE_COBWEB));
    public static final Supplier<Item> COOKIE_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.COOKIE_GHAST_TEAR,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_GHAST_TEAR, FoodValues.ConsumableValues.COOKIE_GHAST_TEAR));
    public static final Supplier<Item> COOKIE_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_SOUL_BERRY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_SOUL_BERRY, FoodValues.ConsumableValues.COOKIE_SOUL_BERRY));
    public static final Supplier<Item> COOKIE_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_WITHER_BERRY,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COOKIE_WITHER_BERRY, FoodValues.ConsumableValues.COOKIE_WITHER_BERRY));

    public static final Supplier<Item> PUNCH_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.PUNCH_ROTTEN_FLESH,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH.get(), properties,
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.ZOMBIE_AMBIENT.location()).get().value(),true, true),
            drinkItem(FoodValues.PUNCH_ROTTEN_FLESH, FoodValues.ConsumableValues.PUNCH_ROTTEN_FLESH));
    public static final Supplier<Item> PUNCH_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCH_SPIDEREYE,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE.get(), properties,
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.location()).get().value(),true, true),
            drinkItem(FoodValues.PUNCH_SPIDER_EYE, FoodValues.ConsumableValues.PUNCH_SPIDER_EYE));
    public static final Supplier<Item> PUNCH_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCH_SLIMEAPPLE,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE.get(), properties,
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SLIME_SQUISH.location()).get().value(),true, true),
            drinkItem(FoodValues.PUNCH_SLIME_APPLE, FoodValues.ConsumableValues.PUNCH_SLIME_APPLE));
    public static final Supplier<Item> PUNCH_COBWEB = registerItemWithTab(FrightsDelightItems.PUNCH_COBWEB,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_COBWEB.get(), properties,
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.location()).get().value(),true, true),
            drinkItem(FoodValues.PUNCH_COBWEB, FoodValues.ConsumableValues.PUNCH_COBWEB));
    public static final Supplier<Item> PUNCH_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCH_GHASTTEAR,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR.get(), properties,
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.GHAST_AMBIENT.location()).get().value(),true, true),
            drinkItem(FoodValues.PUNCH_GHAST_TEAR, FoodValues.ConsumableValues.PUNCH_GHAST_TEAR));
    public static final Supplier<Item> PUNCH_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_SOUL_BERRY,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY.get(), properties, true, true),
            drinkItem(FoodValues.PUNCH_SOUL_BERRY, FoodValues.ConsumableValues.PUNCH_SOUL_BERRY));
    public static final Supplier<Item> PUNCH_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_WITHER_BERRY,
            (properties) -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY.get(), properties, true, true),
            drinkItem(FoodValues.PUNCH_WITHER_BERRY, FoodValues.ConsumableValues.PUNCH_WITHER_BERRY));


    public static final Supplier<Item> PUNCHBOWL_ROTTEN_FLESH = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_ROTTEN_FLESH,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH.get(), noStack());
    public static final Supplier<Item> PUNCHBOWL_SPIDEREYE = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_SPIDEREYE,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), noStack());
    public static final Supplier<Item> PUNCHBOWL_SLIMEAPPLE = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_SLIMEAPPLE,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), noStack());
    public static final Supplier<Item> PUNCHBOWL_COBWEB = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_COBWEB,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB.get(), noStack());
    public static final Supplier<Item> PUNCHBOWL_GHASTTEAR = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_GHASTTEAR,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), noStack());
    public static final Supplier<Item> PUNCHBOWL_SOUL_BERRY = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_SOUL_BERRY,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), noStack());
    public static final Supplier<Item> PUNCHBOWL_WITHER_BERRY = registerBlockWithTab(FrightsDelightItems.PUNCHBOWL_WITHER_BERRY,
            BlockItem::new, FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), noStack());

    public static final Supplier<Item> ROTTEN_FLESH_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, SoundEvents.ZOMBIE_AMBIENT, true),
            syrupItem(FoodValues.ROTTEN_FLESH_SYRUP_BOTTLE, FoodValues.ConsumableValues.ROTTEN_FLESH_SYRUP_BOTTLE));
    public static final Supplier<Item> SPIDEREYE_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.SPIDEREYE_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, SoundEvents.SPIDER_AMBIENT, true),
            syrupItem(FoodValues.SPIDEREYE_SYRUP_BOTTLE, FoodValues.ConsumableValues.SPIDEREYE_SYRUP_BOTTLE));
    public static final Supplier<Item> SLIMEAPPLE_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, SoundEvents.SLIME_SQUISH, true),
            syrupItem(FoodValues.SLIMEAPPLE_SYRUP_BOTTLE, FoodValues.ConsumableValues.SLIMEAPPLE_SYRUP_BOTTLE));
    public static final Supplier<Item> COBWEB_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.COBWEB_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, SoundEvents.SPIDER_AMBIENT, true),
            syrupItem(FoodValues.COBWEB_SYRUP_BOTTLE, FoodValues.ConsumableValues.COBWEB_SYRUP_BOTTLE));
    public static final Supplier<Item> GHASTTEAR_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.GHASTTEAR_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, SoundEvents.GHAST_AMBIENT, true),
            syrupItem(FoodValues.GHASTTEAR_SYRUP_BOTTLE, FoodValues.ConsumableValues.GHASTTEAR_SYRUP_BOTTLE));
    public static final Supplier<Item> SOUL_BERRY_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, true),
            syrupItem(FoodValues.SOUL_BERRY_SYRUP_BOTTLE, FoodValues.ConsumableValues.SOUL_BERRY_SYRUP_BOTTLE));
    public static final Supplier<Item> WITHER_BERRY_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_SYRUP_BOTTLE,
            (properties) -> new FrightsDelightDrinkableItem(properties, true),
            syrupItem(FoodValues.WITHER_BERRY_SYRUP_BOTTLE, FoodValues.ConsumableValues.WITHER_BERRY_SYRUP_BOTTLE));

    public static final Supplier<Item> ROTTEN_FLESH_PIE = registerBlockWithTab(FrightsDelightItems.ROTTEN_FLESH_PIE,
            BlockItem::new, FrightsDelightBlocksImpl.ROTTEN_FLESH_PIE.get(), basicItem());
    public static final Supplier<Item> ROTTEN_FLESH_PIE_SLICE = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_PIE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.ROTTEN_FLESH_PIE_SLICE, FoodValues.ConsumableValues.ROTTEN_FLESH_PIE_SLICE));

    public static final Supplier<Item> SLIMEAPPLE_PIE = registerBlockWithTab(FrightsDelightItems.SLIMEAPPLE_PIE,
            BlockItem::new, FrightsDelightBlocksImpl.SLIMEAPPLE_PIE.get(), basicItem());
    public static final Supplier<Item> SLIMEAPPLE_PIE_SLICE = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_PIE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SLIMEAPPLE_PIE_SLICE, FoodValues.ConsumableValues.SLIMEAPPLE_PIE_SLICE));

    public static final Supplier<Item> SPIDEREYE_PIE = registerBlockWithTab(FrightsDelightItems.SPIDEREYE_PIE,
            BlockItem::new, FrightsDelightBlocksImpl.SPIDEREYE_PIE.get(), basicItem());
    public static final Supplier<Item> SPIDEREYE_PIE_SLICE = registerItemWithTab(FrightsDelightItems.SPIDEREYE_PIE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SPIDEREYE_PIE_SLICE, FoodValues.ConsumableValues.SPIDEREYE_PIE_SLICE));

    public static final Supplier<Item> GHASTTEAR_PIE = registerBlockWithTab(FrightsDelightItems.GHASTTEAR_PIE,
            BlockItem::new, FrightsDelightBlocksImpl.GHASTTEAR_PIE.get(), basicItem());
    public static final Supplier<Item> GHASTTEAR_PIE_SLICE = registerItemWithTab(FrightsDelightItems.GHASTTEAR_PIE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.GHASTTEAR_PIE_SLICE, FoodValues.ConsumableValues.GHASTTEAR_PIE_SLICE));

    public static final Supplier<Item> SOUL_BERRY_CHEESECAKE = registerBlockWithTab(FrightsDelightItems.SOUL_BERRY_CHEESECAKE,
            BlockItem::new, FrightsDelightBlocksImpl.SOUL_BERRY_CHEESECAKE.get(), basicItem());
    public static final Supplier<Item> SOUL_BERRY_CHEESECAKE_SLICE = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_CHEESECAKE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.SOUL_BERRY_CHEESECAKE_SLICE, FoodValues.ConsumableValues.SOUL_BERRY_CHEESECAKE_SLICE));

    public static final Supplier<Item> WITHER_BERRY_CHEESECAKE = registerBlockWithTab(FrightsDelightItems.WITHER_BERRY_CHEESECAKE,
            BlockItem::new, FrightsDelightBlocksImpl.WITHER_BERRY_CHEESECAKE.get(), basicItem());
    public static final Supplier<Item> WITHER_BERRY_CHEESECAKE_SLICE = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_CHEESECAKE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.WITHER_BERRY_CHEESECAKE_SLICE, FoodValues.ConsumableValues.WITHER_BERRY_CHEESECAKE_SLICE));

    public static final Supplier<Item> COBWEB_PIE = registerBlockWithTab(FrightsDelightItems.COBWEB_PIE,
            BlockItem::new, FrightsDelightBlocksImpl.COBWEB_PIE.get(), basicItem());
    public static final Supplier<Item> COBWEB_PIE_SLICE = registerItemWithTab(FrightsDelightItems.COBWEB_PIE_SLICE,
            (properties) -> new FrightsDelightConsumableItem(properties, true),
            foodItem(FoodValues.COBWEB_PIE_SLICE, FoodValues.ConsumableValues.COBWEB_PIE_SLICE));

    public static Supplier<Item> registerItemWithTab(final ResourceLocation location, final Function<Item.Properties, Item> function, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, location));
        Supplier<Item> item = registerItem(location, () -> function.apply(properties));
        ItemGroupEvents.modifyEntriesEvent(FrightsDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    public static Supplier<Item> registerBlockWithTab(final ResourceLocation location, final BiFunction<Block, Item.Properties, Item> function, final Block block, final Item.Properties properties) {
        properties.setId(ResourceKey.create(Registries.ITEM, location));
        properties.useBlockDescriptionPrefix();
        Supplier<Item> item = registerItem(location, () -> function.apply(block, properties));
        ItemGroupEvents.modifyEntriesEvent(FrightsDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item.get()));
        return item;
    }

    private static <T extends Item> Supplier<T> registerItem(ResourceLocation location, Supplier<T> supplier) {
        T object = supplier.get();
        Registry.register(BuiltInRegistries.ITEM, location, object);
        return () -> object;
    }

    private static ResourceKey<Item> key(ResourceLocation resourceLocation) {
        return ResourceKey.create(Registries.ITEM, resourceLocation);
    }

    public static void register() {

    }
}
