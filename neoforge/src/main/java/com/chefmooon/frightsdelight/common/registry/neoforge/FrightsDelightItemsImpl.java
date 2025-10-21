package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.data.types.CandyBasketType;
import com.chefmooon.frightsdelight.common.item.*;
import com.chefmooon.frightsdelight.common.item.neoforge.BoneShardItemImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import com.google.common.collect.Sets;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemContainerContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightItems.*;

public class FrightsDelightItemsImpl {

    public static Item.Properties boneFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(FrightsDelightItemsImpl.BONE_SHARD.get()).stacksTo(16);
    }

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, FrightsDelight.MOD_ID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static final Supplier<Item> PUMPKIN_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.PUMPKIN_CANDY_BASKET,
            () -> new CandyBasketItem(FrightsDelightBlocksImpl.PUMPKIN_CANDY_BASKET.get(), noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY), CandyBasketType.PUMPKIN));
    public static final Supplier<Item> MELON_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.MELON_CANDY_BASKET,
            () -> new CandyBasketItem(FrightsDelightBlocksImpl.MELON_CANDY_BASKET.get(), noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY), CandyBasketType.MELON));

//    public static final Supplier<Item> CREEPER_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.CREEPER_CANDY_BASKET,
//            () -> new CandyBasketItem(FrightsDelightBlocksImpl.CREEPER_CANDY_BASKET.get(), noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY), CandyBasketType.CREEPER));
//    public static final Supplier<Item> SKELETON_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.SKELETON_CANDY_BASKET,
//            () -> new CandyBasketItem(FrightsDelightBlocksImpl.SKELETON_CANDY_BASKET.get(), noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY), CandyBasketType.SKELETON));
//    public static final Supplier<Item> WITHER_SKELETON_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.WITHER_SKELETON_CANDY_BASKET,
//            () -> new CandyBasketItem(FrightsDelightBlocksImpl.WITHER_SKELETON_CANDY_BASKET.get(), noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY), CandyBasketType.SKELETON));
//    public static final Supplier<Item> ZOMBIE_CANDY_BASKET = registerItemWithTab(FrightsDelightItems.ZOMBIE_CANDY_BASKET,
//            () -> new CandyBasketItem(FrightsDelightBlocksImpl.ZOMBIE_CANDY_BASKET.get(), noStack().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY), CandyBasketType.ZOMBIE));

    public static final Supplier<Item> UNFIRED_LOLLIPOP_MOLD = registerItemWithTab(FrightsDelightItems.UNFIRED_LOLLIPOP_MOLD,
            () -> new Item(basicItem()));
    public static final Supplier<Item> LOLLIPOP_MOLD = registerItemWithTab(FrightsDelightItems.LOLLIPOP_MOLD,
            () -> new BlockItem(FrightsDelightBlocksImpl.LOLLIPOP_MOLD.get(), basicItem()));
    public static final Supplier<Item> UNFIRED_RING_CANDY_MOLD = registerItemWithTab(FrightsDelightItems.UNFIRED_RING_CANDY_MOLD,
            () -> new Item(basicItem()));
    public static final Supplier<Item> RING_CANDY_MOLD = registerItemWithTab(FrightsDelightItems.RING_CANDY_MOLD,
            () -> new BlockItem(FrightsDelightBlocksImpl.RING_CANDY_MOLD.get(), basicItem()));

    public static final Supplier<Item> FLESH_CRATE = registerItemWithTab(FrightsDelightItems.FLESH_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.FLESH_CRATE.get(), basicItem()));
    public static final Supplier<Item> BONE_CRATE = registerItemWithTab(FrightsDelightItems.BONE_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.BONE_CRATE.get(), basicItem()));
    public static final Supplier<Item> PHANTOM_CRATE = registerItemWithTab(FrightsDelightItems.PHANTOM_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.PHANTOM_CRATE.get(), basicItem()));
    public static final Supplier<Item> WEB_CRATE = registerItemWithTab(FrightsDelightItems.WEB_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.WEB_CRATE.get(), basicItem()));
    public static final Supplier<Item> SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.SPIDER_EYE_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE.get(), basicItem()));
    public static final Supplier<Item> FERMENTED_SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.FERMENTED_SPIDER_EYE_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE.get(), basicItem()));
    public static final Supplier<Item> POISONOUS_POTATO_CRATE = registerItemWithTab(FrightsDelightItems.POISONOUS_POTATO_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE.get(), basicItem()));
    public static final Supplier<Item> ROTTEN_TOMATO_CRATE = registerItemWithTab(FrightsDelightItems.ROTTEN_TOMATO_CRATE,
            () -> new BlockItem(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE.get(), basicItem()));

    public static final Supplier<Item> BONE_SHARD = registerItemWithTab(FrightsDelightItems.BONE_SHARD,
            () -> new BoneShardItemImpl(basicItem()));

    public static final Supplier<Item> SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY,
            () -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH.get(), foodItem(FoodValues.SOUL_BERRY), true));
    public static final Supplier<Item> WITHER_BERRY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY,
            () -> new FrightsDelightConsumableItemNameBlockItem(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH.get(), foodItem(FoodValues.WITHER_BERRY), true));

    public static final Supplier<Item> ROTTEN_FLESH_LOLLIPOP = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.ROTTEN_FLESH_LOLLIPOP), true));
    public static final Supplier<Item> SPIDEREYE_LOLLIPOP = registerItemWithTab(FrightsDelightItems.SPIDEREYE_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SPIDEREYE_LOLLIPOP), true));
    public static final Supplier<Item> SLIMEAPPLE_LOLLIPOP = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SLIMEAPPLE_LOLLIPOP), true));
    public static final Supplier<Item> COBWEB_LOLLIPOP = registerItemWithTab(FrightsDelightItems.COBWEB_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COBWEB_LOLLIPOP), true));
    public static final Supplier<Item> GHASTTEAR_LOLLIPOP = registerItemWithTab(FrightsDelightItems.GHASTTEAR_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.GHASTTEAR_LOLLIPOP), true));
    public static final Supplier<Item> SOUL_BERRY_LOLLIPOP = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUL_BERRY_LOLLIPOP), true));
    public static final Supplier<Item> WITHER_BERRY_LOLLIPOP = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_LOLLIPOP,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.WITHER_BERRY_LOLLIPOP), true));

    public static final Supplier<Item> ROTTEN_FLESH_RING_CANDY = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.ROTTEN_FLESH_RING_CANDY), true));
    public static final Supplier<Item> SPIDEREYE_RING_CANDY = registerItemWithTab(FrightsDelightItems.SPIDEREYE_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SPIDEREYE_RING_CANDY), true));
    public static final Supplier<Item> SLIMEAPPLE_RING_CANDY = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SLIMEAPPLE_RING_CANDY), true));
    public static final Supplier<Item> COBWEB_RING_CANDY = registerItemWithTab(FrightsDelightItems.COBWEB_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COBWEB_RING_CANDY), true));
    public static final Supplier<Item> GHASTTEAR_RING_CANDY = registerItemWithTab(FrightsDelightItems.GHASTTEAR_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.GHASTTEAR_RING_CANDY), true));
    public static final Supplier<Item> SOUL_BERRY_RING_CANDY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUL_BERRY_RING_CANDY), true));
    public static final Supplier<Item> WITHER_BERRY_RING_CANDY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_RING_CANDY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.WITHER_BERRY_RING_CANDY), true));

    public static final Supplier<Item> APPLE_SLIME = registerItemWithTab(FrightsDelightItems.APPLE_SLIME,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.APPLE_SLIME), true));
    public static final Supplier<Item> UNDEAD_KEBAB = registerItemWithTab(FrightsDelightItems.UNDEAD_KEBAB,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.UNDEAD_KEBAB), true));

    public static final Supplier<Item> BONE_KEBAB_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_ROTTEN_FLESH,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_ROTTEN_FLESH), true));
    public static final Supplier<Item> BONE_KEBAB_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SPIDER_EYE,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SPIDER_EYE), true));
    public static final Supplier<Item> BONE_KEBAB_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SLIMEAPPLE,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SLIMEAPPLE), true));
    public static final Supplier<Item> BONE_KEBAB_SLIME = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SLIME,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SLIME), true));
    public static final Supplier<Item> WEB_ON_STICK = registerItemWithTab(FrightsDelightItems.WEB_ON_STICK,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.WEB_ON_STICK), true));
    public static final Supplier<Item> BONE_KEBAB_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_GHAST_TEAR,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_GHAST_TEAR), true));

    public static final Supplier<Item> BONE_KEBAB_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_SOUL_BERRY,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_SOUL_BERRY), true));
    public static final Supplier<Item> BONE_KEBAB_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.BONE_KEBAB_WITHER_BERRY,
            () -> new FrightsDelightConsumableItem(boneFoodItem(FoodValues.BONE_KEBAB_WITHER_BERRY), true));

    public static final Supplier<Item> MONSTER_MASH = registerItemWithTab(FrightsDelightItems.MONSTER_MASH,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.MONSTER_MASH), true));
    public static final Supplier<Item> PASTA_WITH_SLIMEBALLS = registerItemWithTab(FrightsDelightItems.PASTA_WITH_SLIMEBALLS,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.PASTA_WITH_SLIMEBALLS), true));

    public static final Supplier<Item> SOUP_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.SOUP_ROTTEN_FLESH,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_ROTTEN_FLESH), true));
    public static final Supplier<Item> SOUP_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.SOUP_SPIDER_EYE,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SPIDER_EYE), true));
    public static final Supplier<Item> SOUP_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.SOUP_SLIMEAPPLE,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SLIME), true));
    public static final Supplier<Item> SOUP_SLIME = registerItemWithTab(FrightsDelightItems.SOUP_SLIME,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SLIME), true));
    public static final Supplier<Item> SOUP_COBWEB = registerItemWithTab(FrightsDelightItems.SOUP_COBWEB,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_COBWEB), true));
    public static final Supplier<Item> SOUP_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.SOUP_GHAST_TEAR,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_GHAST_TEAR), true));
    public static final Supplier<Item> SOUP_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUP_SOUL_BERRY,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_SOUL_BERRY), true));
    public static final Supplier<Item> SOUP_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.SOUP_WITHER_BERRY,
            () -> new FrightsDelightConsumableItem(bowlFoodItem(FoodValues.SOUP_WITHER_BERRY), true));

    public static final Supplier<Item> COOKIE_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.COOKIE_ROTTEN_FLESH,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_ROTTEN_FLESH), true));
    public static final Supplier<Item> COOKIE_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.COOKIE_SPIDER_EYE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SPIDER_EYE), true));
    public static final Supplier<Item> COOKIE_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.COOKIE_SLIMEAPPLE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SLIMEAPPLE), true));
    public static final Supplier<Item> COOKIE_SLIME = registerItemWithTab(FrightsDelightItems.COOKIE_SLIME,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SLIME), true));
    public static final Supplier<Item> COOKIE_COBWEB = registerItemWithTab(FrightsDelightItems.COOKIE_COBWEB,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_COBWEB), true));
    public static final Supplier<Item> COOKIE_GHAST_TEAR = registerItemWithTab(FrightsDelightItems.COOKIE_GHAST_TEAR,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_GHAST_TEAR), true));
    public static final Supplier<Item> COOKIE_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_SOUL_BERRY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_SOUL_BERRY), true));
    public static final Supplier<Item> COOKIE_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_WITHER_BERRY,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COOKIE_WITHER_BERRY), true));

    public static final Supplier<Item> PUNCH_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.PUNCH_ROTTEN_FLESH,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_ROTTEN_FLESH.get(), drinkItem(FoodValues.PUNCH_ROTTEN_FLESH),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.ZOMBIE_AMBIENT.getLocation()), true, true));
    public static final Supplier<Item> PUNCH_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCH_SPIDEREYE,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_SPIDEREYE.get(), drinkItem(FoodValues.PUNCH_SPIDER_EYE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.getLocation()), true, true));
    public static final Supplier<Item> PUNCH_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCH_SLIMEAPPLE,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_SLIMEAPPLE.get(), drinkItem(FoodValues.PUNCH_SLIME_APPLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SLIME_SQUISH.getLocation()), true, true));
    public static final Supplier<Item> PUNCH_COBWEB = registerItemWithTab(FrightsDelightItems.PUNCH_COBWEB,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_COBWEB.get(), drinkItem(FoodValues.PUNCH_COBWEB),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.getLocation()), true, true));
    public static final Supplier<Item> PUNCH_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCH_GHASTTEAR,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_GHASTTEAR.get(), drinkItem(FoodValues.PUNCH_GHAST_TEAR),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.GHAST_AMBIENT.getLocation()), true, true));
    public static final Supplier<Item> PUNCH_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_SOUL_BERRY,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_SOUL_BERRY.get(), drinkItem(FoodValues.PUNCH_SOUL_BERRY), true, true));
    public static final Supplier<Item> PUNCH_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_WITHER_BERRY,
            () -> new FrightsDelightDrinkableBlockItem(FrightsDelightBlocksImpl.PUNCH_WITHER_BERRY.get(), drinkItem(FoodValues.PUNCH_WITHER_BERRY), true, true));

    public static final Supplier<Item> PUNCHBOWL_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_ROTTEN_FLESH,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_ROTTEN_FLESH.get(), noStack()));
    public static final Supplier<Item> PUNCHBOWL_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SPIDEREYE,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE.get(), noStack()));
    public static final Supplier<Item> PUNCHBOWL_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SLIMEAPPLE,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE.get(), noStack()));
    public static final Supplier<Item> PUNCHBOWL_COBWEB = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_COBWEB,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_COBWEB.get(), noStack()));
    public static final Supplier<Item> PUNCHBOWL_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_GHASTTEAR,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR.get(), noStack()));
    public static final Supplier<Item> PUNCHBOWL_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SOUL_BERRY,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY.get(), noStack()));
    public static final Supplier<Item> PUNCHBOWL_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_WITHER_BERRY,
            () -> new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY.get(), noStack()));

    public static final Supplier<Item> ROTTEN_FLESH_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.ROTTEN_FLESH_SYRUP_BOTTLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.ZOMBIE_AMBIENT.getLocation()), true));
    public static final Supplier<Item> SPIDEREYE_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.SPIDEREYE_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.SPIDEREYE_SYRUP_BOTTLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.getLocation()), true));
    public static final Supplier<Item> SLIMEAPPLE_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.SLIMEAPPLE_SYRUP_BOTTLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SLIME_SQUISH.getLocation()), true));
    public static final Supplier<Item> COBWEB_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.COBWEB_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.COBWEB_SYRUP_BOTTLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.SPIDER_AMBIENT.getLocation()), true));
    public static final Supplier<Item> GHASTTEAR_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.GHASTTEAR_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.GHASTTEAR_SYRUP_BOTTLE),
                    BuiltInRegistries.SOUND_EVENT.get(SoundEvents.GHAST_AMBIENT.getLocation()), true));
    public static final Supplier<Item> SOUL_BERRY_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.SOUL_BERRY_SYRUP_BOTTLE), true));
    public static final Supplier<Item> WITHER_BERRY_SYRUP_BOTTLE = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_SYRUP_BOTTLE,
            () -> new FrightsDelightDrinkableItem(syrupItem(FoodValues.WITHER_BERRY_SYRUP_BOTTLE), true));

    public static final Supplier<Item> ROTTEN_FLESH_PIE = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_PIE,
            () -> new BlockItem(FrightsDelightBlocksImpl.ROTTEN_FLESH_PIE.get(), basicItem()));
    public static final Supplier<Item> SPIDEREYE_PIE = registerItemWithTab(FrightsDelightItems.SPIDEREYE_PIE,
            () -> new BlockItem(FrightsDelightBlocksImpl.SPIDEREYE_PIE.get(), basicItem()));
    public static final Supplier<Item> SLIMEAPPLE_PIE = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_PIE,
            () -> new BlockItem(FrightsDelightBlocksImpl.SLIMEAPPLE_PIE.get(), basicItem()));
    public static final Supplier<Item> COBWEB_PIE = registerItemWithTab(FrightsDelightItems.COBWEB_PIE,
            () -> new BlockItem(FrightsDelightBlocksImpl.COBWEB_PIE.get(), basicItem()));
    public static final Supplier<Item> GHASTTEAR_PIE = registerItemWithTab(FrightsDelightItems.GHASTTEAR_PIE,
            () -> new BlockItem(FrightsDelightBlocksImpl.GHASTTEAR_PIE.get(), basicItem()));
    public static final Supplier<Item> SOUL_BERRY_CHEESECAKE = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_CHEESECAKE,
            () -> new BlockItem(FrightsDelightBlocksImpl.SOUL_BERRY_CHEESECAKE.get(), basicItem()));
    public static final Supplier<Item> WITHER_BERRY_CHEESECAKE = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_CHEESECAKE,
            () -> new BlockItem(FrightsDelightBlocksImpl.WITHER_BERRY_CHEESECAKE.get(), basicItem()));

    public static final Supplier<Item> ROTTEN_FLESH_PIE_SLICE = registerItemWithTab(FrightsDelightItems.ROTTEN_FLESH_PIE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.ROTTEN_FLESH_PIE_SLICE), true));
    public static final Supplier<Item> SPIDEREYE_PIE_SLICE = registerItemWithTab(FrightsDelightItems.SPIDEREYE_PIE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SPIDEREYE_PIE_SLICE), true));
    public static final Supplier<Item> SLIMEAPPLE_PIE_SLICE = registerItemWithTab(FrightsDelightItems.SLIMEAPPLE_PIE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SLIMEAPPLE_PIE_SLICE), true));
    public static final Supplier<Item> COBWEB_PIE_SLICE = registerItemWithTab(FrightsDelightItems.COBWEB_PIE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.COBWEB_PIE_SLICE), true));
    public static final Supplier<Item> GHASTTEAR_PIE_SLICE = registerItemWithTab(FrightsDelightItems.GHASTTEAR_PIE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.GHASTTEAR_PIE_SLICE), true));
    public static final Supplier<Item> SOUL_BERRY_CHEESECAKE_SLICE = registerItemWithTab(FrightsDelightItems.SOUL_BERRY_CHEESECAKE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.SOUL_BERRY_CHEESECAKE_SLICE), true));
    public static final Supplier<Item> WITHER_BERRY_CHEESECAKE_SLICE = registerItemWithTab(FrightsDelightItems.WITHER_BERRY_CHEESECAKE_SLICE,
            () -> new FrightsDelightConsumableItem(foodItem(FoodValues.WITHER_BERRY_CHEESECAKE_SLICE), true));

    public static Supplier<Item> registerItemWithTab(final ResourceLocation location, final Supplier<Item> supplier) {
        Supplier<Item> item = ITEMS.register(location.getPath(), supplier);
        CREATIVE_TAB_ITEMS.add(item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
