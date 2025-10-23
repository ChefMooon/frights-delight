package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.block.AbstractMoldBlock;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.ToIntFunction;

public class FrightsDelightBlocks {

    public static ToIntFunction<BlockState> slimeApplePunchLight() {
        return (state) -> {
            if (state.hasProperty(GlassCupBlock.SERVINGS)) {
                int servings = state.getValue(GlassCupBlock.SERVINGS);
                return switch (servings) {
                    case 0 -> 3;
                    case 1 -> 6;
                    case 2 -> 9;
                    case 3 -> 12;
                    default -> 0;
                };
            }
            return 0;
        };
    }

    public static ToIntFunction<BlockState> slimeApplePunchBowlLight() {
        return (state) -> {
            if (state.hasProperty(DrinkableFeastBlock.SERVINGS)) {
                int servings = state.getValue(DrinkableFeastBlock.SERVINGS);
                return switch (servings) {
                    case 0 -> 1;
                    case 1 -> 3;
                    case 2 -> 6;
                    case 3 -> 9;
                    case 4 -> 12;
                    default -> 0;
                };
            }
            return 0;
        };
    }

    public static ToIntFunction<BlockState> slimeAppleAbstractMoldLight() {
        return (state) -> {
            if (state.hasProperty(AbstractMoldBlock.SYRUP_TYPE)) {
                if (state.getValue(AbstractMoldBlock.SYRUP_TYPE) == Syrups.SLIMEAPPLE) return 8;
            }
            return 0;
        };
    }

    public static final ResourceLocation SOUL_BERRY_BUSH = block("soul_berry_bush");
    public static final ResourceLocation WITHER_BERRY_BUSH = block("wither_berry_bush");

    public static final ResourceLocation LOLLIPOP_MOLD = block("lollipop_mold");
    public static final ResourceLocation RING_CANDY_MOLD = block("ring_candy_mold");

    public static final ResourceLocation FLESH_CRATE = block("flesh_crate");
    public static final ResourceLocation BONE_CRATE = block("bone_crate");
    public static final ResourceLocation PHANTOM_CRATE = block("phantom_crate");
    public static final ResourceLocation WEB_CRATE = block("web_crate");
    public static final ResourceLocation SPIDER_EYE_CRATE = block("spider_eye_crate");
    public static final ResourceLocation FERMENTED_SPIDER_EYE_CRATE = block("fermented_spider_eye_crate");
    public static final ResourceLocation POISONOUS_POTATO_CRATE = block("poisonous_potato_crate");
    public static final ResourceLocation ROTTEN_TOMATO_CRATE = block("rotten_tomato_crate");

    public static final ResourceLocation PUNCH_ROTTEN_FLESH = block("punch_rotten_flesh");
    public static final ResourceLocation PUNCH_SLIMEAPPLE = block("punch_slimeapple");
    public static final ResourceLocation PUNCH_SPIDEREYE = block("punch_spidereye");
    public static final ResourceLocation PUNCH_GHASTTEAR = block("punch_ghasttear");
    public static final ResourceLocation PUNCH_SOUL_BERRY = block("punch_soul_berry");
    public static final ResourceLocation PUNCH_WITHER_BERRY = block("punch_wither_berry");
    public static final ResourceLocation PUNCH_COBWEB = block("punch_cobweb");

    public static final ResourceLocation PUNCHBOWL_ROTTEN_FLESH = block("punchbowl_rotten_flesh");
    public static final ResourceLocation PUNCHBOWL_SLIMEAPPLE = block("punchbowl_slimeapple");
    public static final ResourceLocation PUNCHBOWL_SPIDEREYE = block("punchbowl_spidereye");
    public static final ResourceLocation PUNCHBOWL_GHASTTEAR = block("punchbowl_ghasttear");
    public static final ResourceLocation PUNCHBOWL_SOUL_BERRY = block("punchbowl_soul_berry");
    public static final ResourceLocation PUNCHBOWL_WITHER_BERRY = block("punchbowl_wither_berry");
    public static final ResourceLocation PUNCHBOWL_COBWEB = block("punchbowl_cobweb");

    public static final ResourceLocation ROTTEN_FLESH_PIE = block("rotten_flesh_pie");
    public static final ResourceLocation SLIMEAPPLE_PIE = block("slimeapple_pie");
    public static final ResourceLocation SPIDEREYE_PIE = block("spidereye_pie");
    public static final ResourceLocation GHASTTEAR_PIE = block("ghasttear_pie");
    public static final ResourceLocation SOUL_BERRY_CHEESECAKE = block("soul_berry_cheesecake");
    public static final ResourceLocation WITHER_BERRY_CHEESECAKE = block("wither_berry_cheesecake");
    public static final ResourceLocation COBWEB_PIE = block("cobweb_pie");

    public static final ResourceLocation ROTTEN_FLESH_SYRUP = block("rotten_flesh_syrup");
    public static final ResourceLocation SLIMEAPPLE_SYRUP = block("slimeapple_syrup");
    public static final ResourceLocation SPIDEREYE_SYRUP = block("spidereye_syrup");
    public static final ResourceLocation GHASTTEAR_SYRUP = block("ghasttear_syrup");
    public static final ResourceLocation SOUL_BERRY_SYRUP = block("soul_berry_syrup");
    public static final ResourceLocation WITHER_BERRY_SYRUP = block("wither_berry_syrup");
    public static final ResourceLocation COBWEB_SYRUP = block("cobweb_syrup");

    public static final ResourceLocation PUMPKIN_CANDY_BASKET = block("pumpkin_candy_basket");
    public static final ResourceLocation MELON_CANDY_BASKET = block("melon_candy_basket");

    private static ResourceLocation block(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }

}
