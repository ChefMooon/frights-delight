package com.chefmooon.frightsdelight.common.registry.neoforge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.GlassCupBlock;
import com.chefmooon.frightsdelight.common.block.drinkableFeastBlocks.*;
import com.chefmooon.frightsdelight.common.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.WitherBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.glassCupBlocks.*;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks.slimeApplePunchBowlLight;
import static com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks.slimeApplePunchLight;

public class FrightsDelightBlocksImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, FrightsDelight.MOD_ID);

    public static final Supplier<Block> SOUL_BERRY_BUSH = registerBlock(FrightsDelightBlocks.SOUL_BERRY_BUSH, SoulBerryBushBlock::new);
    public static final Supplier<Block> WITHER_BERRY_BUSH = registerBlock(FrightsDelightBlocks.WITHER_BERRY_BUSH, WitherBerryBushBlock::new);

    public static final Supplier<Block> FLESH_CRATE = registerBlock(FrightsDelightBlocks.FLESH_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> BONE_CRATE = registerBlock(FrightsDelightBlocks.BONE_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> PHANTOM_CRATE = registerBlock(FrightsDelightBlocks.PHANTOM_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> WEB_CRATE = registerBlock(FrightsDelightBlocks.WEB_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.SPIDER_EYE_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> FERMENTED_SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.FERMENTED_SPIDER_EYE_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> POISONOUS_POTATO_CRATE = registerBlock(FrightsDelightBlocks.POISONOUS_POTATO_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> ROTTEN_TOMATO_CRATE = registerBlock(FrightsDelightBlocks.ROTTEN_TOMATO_CRATE,
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final Supplier<Block> PUNCH_ROTTEN_FLESH = registerBlock(FrightsDelightBlocks.PUNCH_ROTTEN_FLESH,
            () -> new RottenFleshGlassCupBlock(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCH_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCH_SLIMEAPPLE,
            () -> new SlimeAppleGlassCupBlock(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(slimeApplePunchLight())));
    public static final Supplier<Block> PUNCH_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCH_SPIDEREYE,
            () -> new SpiderEyeGlassCupBlock(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCH_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCH_GHASTTEAR,
            () -> new GhastTearGlassCupBlock(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCH_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCH_SOUL_BERRY,
            () -> new SoulBerryGlassCupBlock(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCH_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCH_WITHER_BERRY,
            () -> new WitherBerryGlassCupBlock(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));
    public static final Supplier<Block> PUNCH_COBWEB = registerBlock(FrightsDelightBlocks.PUNCH_COBWEB,
            () -> new CobwebGlassCupBlock(FrightsDelightItemsImpl.PUNCH_COBWEB, BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)));

    public static final Supplier<Block> PUNCHBOWL_ROTTEN_FLESH = registerBlock(FrightsDelightBlocks.PUNCHBOWL_ROTTEN_FLESH,
            () -> new RottenFleshDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SLIMEAPPLE,
            () -> new SlimeAppleDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS).lightLevel(slimeApplePunchBowlLight())));
    public static final Supplier<Block> PUNCHBOWL_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SPIDEREYE,
            () -> new SpiderEyeDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SPIDEREYE,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCHBOWL_GHASTTEAR,
            () -> new GhastTearDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_GHASTTEAR,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SOUL_BERRY,
            () -> new SoulBerryDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_WITHER_BERRY,
            () -> new WitherBerryDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final Supplier<Block> PUNCHBOWL_COBWEB = registerBlock(FrightsDelightBlocks.PUNCHBOWL_COBWEB,
            () -> new CobwebDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_COBWEB,
                    Block.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));

    public static final Supplier<Block> ROTTEN_FLESH_PIE = registerBlock(FrightsDelightBlocks.ROTTEN_FLESH_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE));
    public static final Supplier<Block> SLIMEAPPLE_PIE = registerBlock(FrightsDelightBlocks.SLIMEAPPLE_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE));
    public static final Supplier<Block> SPIDEREYE_PIE = registerBlock(FrightsDelightBlocks.SPIDEREYE_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE));
    public static final Supplier<Block> GHASTTEAR_PIE = registerBlock(FrightsDelightBlocks.GHASTTEAR_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE));
    public static final Supplier<Block> SOUL_BERRY_CHEESECAKE = registerBlock(FrightsDelightBlocks.SOUL_BERRY_CHEESECAKE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE));
    public static final Supplier<Block> WITHER_BERRY_CHEESECAKE = registerBlock(FrightsDelightBlocks.WITHER_BERRY_CHEESECAKE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE));
    public static final Supplier<Block> COBWEB_PIE = registerBlock(FrightsDelightBlocks.COBWEB_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), FrightsDelightItemsImpl.COBWEB_PIE_SLICE));

    public static Supplier<Block> registerBlock(final ResourceLocation location, final Supplier<Block> block) {
        return BLOCKS.register(location.getPath(), block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
