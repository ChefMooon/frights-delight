package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.FoodValues;
import com.chefmooon.frightsdelight.common.item.fabric.FrightsDelightConsumableItemImpl;
import com.chefmooon.frightsdelight.common.item.fabric.FrightsDelightConsumableItemNameBlockItemImpl;
import com.chefmooon.frightsdelight.common.item.fabric.FrightsDelightDrinkableItemImpl;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightItems.*;

public class FrightsDelightItemsImpl {
    public static final Item FLESH_CRATE = registerItemWithTab(FrightsDelightItems.FLESH_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.FLESH_CRATE, basicItem()));
    public static final Item BONE_CRATE = registerItemWithTab(FrightsDelightItems.BONE_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.BONE_CRATE, basicItem()));
    public static final Item PHANTOM_CRATE = registerItemWithTab(FrightsDelightItems.PHANTOM_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.PHANTOM_CRATE, basicItem()));
    public static final Item WEB_CRATE = registerItemWithTab(FrightsDelightItems.WEB_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.WEB_CRATE, basicItem()));
    public static final Item SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.SPIDER_EYE_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.SPIDER_EYE_CRATE, basicItem()));
    public static final Item FERMENTED_SPIDER_EYE_CRATE = registerItemWithTab(FrightsDelightItems.FERMENTED_SPIDER_EYE_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.FERMENTED_SPIDER_EYE_CRATE, basicItem()));
    public static final Item POISONOUS_POTATO_CRATE = registerItemWithTab(FrightsDelightItems.POISONOUS_POTATO_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.POISONOUS_POTATO_CRATE, basicItem()));
    public static final Item ROTTEN_TOMATO_CRATE = registerItemWithTab(FrightsDelightItems.ROTTEN_TOMATO_CRATE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.ROTTEN_TOMATO_CRATE, basicItem()));

    public static final Item SOUL_BERRY = registerItemWithTab(FrightsDelightItems.SOUL_BERRY.getPath(),
            new FrightsDelightConsumableItemNameBlockItemImpl(FrightsDelightBlocksImpl.SOUL_BERRY_BUSH, foodItem(FoodValues.SOUL_BERRY), true));
    public static final Item WITHER_BERRY = registerItemWithTab(FrightsDelightItems.WITHER_BERRY.getPath(),
            new FrightsDelightConsumableItemNameBlockItemImpl(FrightsDelightBlocksImpl.WITHER_BERRY_BUSH, foodItem(FoodValues.WITHER_BERRY), true));

    public static final Item APPLE_SLIME = registerItemWithTab(FrightsDelightItems.APPLE_SLIME.getPath(),
            new FrightsDelightConsumableItemImpl(foodItem(FoodValues.APPLE_SLIME), true));
    public static final Item UNDEAD_KEBAB = registerItemWithTab(FrightsDelightItems.UNDEAD_KEBAB.getPath(),
            new FrightsDelightConsumableItemImpl(stickFoodItem(FoodValues.UNDEAD_KEBAB), true));
    public static final Item WEB_ON_STICK = registerItemWithTab(FrightsDelightItems.WEB_ON_STICK.getPath(),
            new FrightsDelightConsumableItemImpl(stickFoodItem(FoodValues.WEB_ON_STICK), true));

    public static final Item MONSTER_MASH = registerItemWithTab(FrightsDelightItems.MONSTER_MASH.getPath(),
            new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.MONSTER_MASH), true));
    public static final Item PASTA_WITH_SLIMEBALLS = registerItemWithTab(FrightsDelightItems.PASTA_WITH_SLIMEBALLS.getPath(),
            new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.PASTA_WITH_SLIMEBALLS), true));
    public static final Item SOUP_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.SOUP_ROTTEN_FLESH.getPath(),
            new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.SOUP_ROTTEN_FLESH), true));
    public static final Item SOUP_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.SOUP_SPIDER_EYE.getPath(),
            new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.SOUP_SPIDER_EYE), true));
    public static final Item SOUP_SLIME = registerItemWithTab(FrightsDelightItems.SOUP_SLIME.getPath(),
            new FrightsDelightConsumableItemImpl(bowlFoodItem(FoodValues.SOUP_SLIME), true));

    public static final Item COOKIE_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.COOKIE_SOUL_BERRY.getPath(),
            new FrightsDelightConsumableItemImpl(foodItem(FoodValues.COOKIE_SOUL_BERRY), true));
    public static final Item COOKIE_ROTTEN_FLESH = registerItemWithTab(FrightsDelightItems.COOKIE_ROTTEN_FLESH.getPath(),
            new FrightsDelightConsumableItemImpl(foodItem(FoodValues.COOKIE_ROTTEN_FLESH), true));
    public static final Item COOKIE_SPIDER_EYE = registerItemWithTab(FrightsDelightItems.COOKIE_SPIDER_EYE.getPath(),
            new FrightsDelightConsumableItemImpl(foodItem(FoodValues.COOKIE_SPIDER_EYE), true));

    public static final Item PUNCH_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCH_SLIMEAPPLE.getPath(),
            new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_SLIME_APPLE), true));
    public static final Item PUNCH_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCH_SPIDEREYE.getPath(),
            new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_SPIDER_EYE), true));
    public static final Item PUNCH_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCH_GHASTTEAR.getPath(),
            new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_GHAST_TEAR), true));
    public static final Item PUNCH_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_SOUL_BERRY.getPath(),
            new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_SOUL_BERRY), true));
    public static final Item PUNCH_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCH_WITHER_BERRY.getPath(),
            new FrightsDelightDrinkableItemImpl(drinkItem(FoodValues.PUNCH_WITHER_BERRY), true));

    public static final Item PUNCHBOWL_SLIMEAPPLE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SLIMEAPPLE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SLIMEAPPLE, basicItem()));
    public static final Item PUNCHBOWL_SPIDEREYE = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SPIDEREYE.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SPIDEREYE, basicItem()));
    public static final Item PUNCHBOWL_GHASTTEAR = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_GHASTTEAR.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_GHASTTEAR, basicItem()));
    public static final Item PUNCHBOWL_SOUL_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_SOUL_BERRY.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_SOUL_BERRY, basicItem()));
    public static final Item PUNCHBOWL_WITHER_BERRY = registerItemWithTab(FrightsDelightItems.PUNCHBOWL_WITHER_BERRY.getPath(),
            new BlockItem(FrightsDelightBlocksImpl.PUNCHBOWL_WITHER_BERRY, basicItem()));

    public static Item registerItemWithTab(final String name, final Item item) {
        Registry.register(BuiltInRegistries.ITEM, FrightsDelight.res(name), item);
        ItemGroupEvents.modifyEntriesEvent(FrightsDelightCreativeTabs.ITEM_GROUP).register(entries -> entries.accept(item));
        return item;
    }

    public static void register() {

    }
}