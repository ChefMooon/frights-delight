package com.chefmooon.frightsdelight.common.registry;

import com.chefmooon.frightsdelight.common.block.AbstractMoldBlock;
import com.chefmooon.frightsdelight.common.block.DrinkableFeastBlock;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.data.types.Syrups;
import com.chefmooon.frightsdelight.common.utility.TextUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.block.PieBlock;

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

    public static ToIntFunction<BlockState> slimeApplePieLight() {
        return (state) -> {
            if (state.hasProperty(PieBlock.BITES)) {
                int bites = state.getValue(PieBlock.BITES);
                return switch (bites) {
                    case 0 -> 8;
                    case 1 -> 6;
                    case 2 -> 4;
                    case 3 -> 2;
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

    public static final Identifier SOUL_BERRY_BUSH = block("soul_berry_bush");
    public static final Identifier WITHER_BERRY_BUSH = block("wither_berry_bush");

    public static final Identifier LOLLIPOP_MOLD = block("lollipop_mold");
    public static final Identifier RING_CANDY_MOLD = block("ring_candy_mold");

    public static final Identifier FLESH_CRATE = block("flesh_crate");
    public static final Identifier BONE_CRATE = block("bone_crate");
    public static final Identifier PHANTOM_CRATE = block("phantom_crate");
    public static final Identifier WEB_CRATE = block("web_crate");
    public static final Identifier SPIDER_EYE_CRATE = block("spider_eye_crate");
    public static final Identifier FERMENTED_SPIDER_EYE_CRATE = block("fermented_spider_eye_crate");
    public static final Identifier POISONOUS_POTATO_CRATE = block("poisonous_potato_crate");
    public static final Identifier ROTTEN_TOMATO_CRATE = block("rotten_tomato_crate");

    public static final Identifier PUNCH_ROTTEN_FLESH = block("punch_rotten_flesh");
    public static final Identifier PUNCH_SLIMEAPPLE = block("punch_slimeapple");
    public static final Identifier PUNCH_SPIDEREYE = block("punch_spidereye");
    public static final Identifier PUNCH_GHASTTEAR = block("punch_ghasttear");
    public static final Identifier PUNCH_SOUL_BERRY = block("punch_soul_berry");
    public static final Identifier PUNCH_WITHER_BERRY = block("punch_wither_berry");
    public static final Identifier PUNCH_COBWEB = block("punch_cobweb");

    public static final Identifier PUNCHBOWL_ROTTEN_FLESH = block("punchbowl_rotten_flesh");
    public static final Identifier PUNCHBOWL_SLIMEAPPLE = block("punchbowl_slimeapple");
    public static final Identifier PUNCHBOWL_SPIDEREYE = block("punchbowl_spidereye");
    public static final Identifier PUNCHBOWL_GHASTTEAR = block("punchbowl_ghasttear");
    public static final Identifier PUNCHBOWL_SOUL_BERRY = block("punchbowl_soul_berry");
    public static final Identifier PUNCHBOWL_WITHER_BERRY = block("punchbowl_wither_berry");
    public static final Identifier PUNCHBOWL_COBWEB = block("punchbowl_cobweb");

    public static final Identifier ROTTEN_FLESH_PIE = block("rotten_flesh_pie");
    public static final Identifier SLIMEAPPLE_PIE = block("slimeapple_pie");
    public static final Identifier SPIDEREYE_PIE = block("spidereye_pie");
    public static final Identifier GHASTTEAR_PIE = block("ghasttear_pie");
    public static final Identifier SOUL_BERRY_CHEESECAKE = block("soul_berry_cheesecake");
    public static final Identifier WITHER_BERRY_CHEESECAKE = block("wither_berry_cheesecake");
    public static final Identifier COBWEB_PIE = block("cobweb_pie");

    public static final Identifier ROTTEN_FLESH_SYRUP = block("rotten_flesh_syrup");
    public static final Identifier SLIMEAPPLE_SYRUP = block("slimeapple_syrup");
    public static final Identifier SPIDEREYE_SYRUP = block("spidereye_syrup");
    public static final Identifier GHASTTEAR_SYRUP = block("ghasttear_syrup");
    public static final Identifier SOUL_BERRY_SYRUP = block("soul_berry_syrup");
    public static final Identifier WITHER_BERRY_SYRUP = block("wither_berry_syrup");
    public static final Identifier COBWEB_SYRUP = block("cobweb_syrup");

    public static final Identifier PUMPKIN_CANDY_BASKET = block("pumpkin_candy_basket");
    public static final Identifier JACK_O_LANTERN_CANDY_BASKET = block("jack_o_lantern_candy_basket");
    public static final Identifier MELON_CANDY_BASKET = block("melon_candy_basket");

    private static Identifier block(String string) {
        return TextUtils.res(string);
    }

    public static void init() {
    }

}
