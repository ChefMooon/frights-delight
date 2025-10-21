package com.chefmooon.frightsdelight.common.registry.forge;

import com.chefmooon.frightsdelight.FrightsDelight;
import com.chefmooon.frightsdelight.common.block.LollipopMoldBlock;
import com.chefmooon.frightsdelight.common.block.RingCandyMoldBlock;
import com.chefmooon.frightsdelight.common.block.SoulBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.WitherBerryBushBlock;
import com.chefmooon.frightsdelight.common.block.drinkableFeastBlocks.*;
import com.chefmooon.frightsdelight.common.block.glassCupBlocks.*;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightFluids;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks.slimeApplePunchBowlLight;
import static com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks.slimeApplePunchLight;

public class FrightsDelightBlocksImpl {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, FrightsDelight.MOD_ID);

    public static final RegistryObject<Block> SOUL_BERRY_BUSH = registerBlock(FrightsDelightBlocks.SOUL_BERRY_BUSH, SoulBerryBushBlock::new);
    public static final RegistryObject<Block> WITHER_BERRY_BUSH = registerBlock(FrightsDelightBlocks.WITHER_BERRY_BUSH, WitherBerryBushBlock::new);

    public static final Supplier<Block> LOLLIPOP_MOLD = registerBlock(FrightsDelightBlocks.LOLLIPOP_MOLD,
            () -> new LollipopMoldBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)));
    public static final Supplier<Block> RING_CANDY_MOLD = registerBlock(FrightsDelightBlocks.RING_CANDY_MOLD,
            () -> new RingCandyMoldBlock(BlockBehaviour.Properties.copy(Blocks.TERRACOTTA)));

    public static final RegistryObject<Block> FLESH_CRATE = registerBlock(FrightsDelightBlocks.FLESH_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BONE_CRATE = registerBlock(FrightsDelightBlocks.BONE_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PHANTOM_CRATE = registerBlock(FrightsDelightBlocks.PHANTOM_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> WEB_CRATE = registerBlock(FrightsDelightBlocks.WEB_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.SPIDER_EYE_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> FERMENTED_SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.FERMENTED_SPIDER_EYE_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> POISONOUS_POTATO_CRATE = registerBlock(FrightsDelightBlocks.POISONOUS_POTATO_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> ROTTEN_TOMATO_CRATE = registerBlock(FrightsDelightBlocks.ROTTEN_TOMATO_CRATE,
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> PUNCH_ROTTEN_FLESH = registerBlock(FrightsDelightBlocks.PUNCH_ROTTEN_FLESH,
            () -> new RottenFleshGlassCupBlock(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> PUNCH_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCH_SLIMEAPPLE,
            () -> new SlimeAppleGlassCupBlock(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE, BlockBehaviour.Properties.copy(Blocks.GLASS).lightLevel(slimeApplePunchLight())));
    public static final RegistryObject<Block> PUNCH_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCH_SPIDEREYE,
            () -> new SpiderEyeGlassCupBlock(FrightsDelightItemsImpl.PUNCH_SPIDEREYE, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> PUNCH_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCH_GHASTTEAR,
            () -> new GhastTearGlassCupBlock(FrightsDelightItemsImpl.PUNCH_GHASTTEAR, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> PUNCH_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCH_SOUL_BERRY,
            () -> new SoulBerryGlassCupBlock(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> PUNCH_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCH_WITHER_BERRY,
            () -> new WitherBerryGlassCupBlock(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> PUNCH_COBWEB = registerBlock(FrightsDelightBlocks.PUNCH_COBWEB,
            () -> new CobwebGlassCupBlock(FrightsDelightItemsImpl.PUNCH_COBWEB, BlockBehaviour.Properties.copy(Blocks.GLASS)));
    
    public static final RegistryObject<Block> PUNCHBOWL_ROTTEN_FLESH = registerBlock(FrightsDelightBlocks.PUNCHBOWL_ROTTEN_FLESH,
            () -> new RottenFleshDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SLIMEAPPLE,
            () -> new SlimeAppleDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS).lightLevel(slimeApplePunchBowlLight())));
    public static final RegistryObject<Block> PUNCHBOWL_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SPIDEREYE,
            () -> new SpiderEyeDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SPIDEREYE,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCHBOWL_GHASTTEAR,
            () -> new GhastTearDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_GHASTTEAR,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SOUL_BERRY,
            () -> new SoulBerryDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_SOUL_BERRY,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_WITHER_BERRY,
            () -> new WitherBerryDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_WITHER_BERRY,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));
    public static final RegistryObject<Block> PUNCHBOWL_COBWEB = registerBlock(FrightsDelightBlocks.PUNCHBOWL_COBWEB,
            () -> new CobwebDrinkableFeastBlock(FrightsDelightItemsImpl.PUNCH_COBWEB,
                    Block.Properties.copy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS)));

    public static final RegistryObject<Block> ROTTEN_FLESH_PIE = registerBlock(FrightsDelightBlocks.ROTTEN_FLESH_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE));
    public static final RegistryObject<Block> SLIMEAPPLE_PIE = registerBlock(FrightsDelightBlocks.SLIMEAPPLE_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE));
    public static final RegistryObject<Block> SPIDEREYE_PIE = registerBlock(FrightsDelightBlocks.SPIDEREYE_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE));
    public static final RegistryObject<Block> GHASTTEAR_PIE = registerBlock(FrightsDelightBlocks.GHASTTEAR_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE));

    public static final RegistryObject<Block> SOUL_BERRY_CHEESECAKE = registerBlock(FrightsDelightBlocks.SOUL_BERRY_CHEESECAKE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE));
    public static final RegistryObject<Block> WITHER_BERRY_CHEESECAKE = registerBlock(FrightsDelightBlocks.WITHER_BERRY_CHEESECAKE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE));
    public static final RegistryObject<Block> COBWEB_PIE = registerBlock(FrightsDelightBlocks.COBWEB_PIE,
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), FrightsDelightItemsImpl.COBWEB_PIE_SLICE));

    public static final Supplier<LiquidBlock> ROTTEN_FLESH_SYRUP = BLOCKS.register(FrightsDelightBlocks.ROTTEN_FLESH_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.ROTTEN_FLESH_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> SLIMEAPPLE_SYRUP = BLOCKS.register(FrightsDelightBlocks.SLIMEAPPLE_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.SLIMEAPPLE_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> SPIDEREYE_SYRUP = BLOCKS.register(FrightsDelightBlocks.SPIDEREYE_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.SPIDEREYE_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> GHASTTEAR_SYRUP = BLOCKS.register(FrightsDelightBlocks.GHASTTEAR_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.GHASTTEAR_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> SOUL_BERRY_SYRUP = BLOCKS.register(FrightsDelightBlocks.SOUL_BERRY_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.SOUL_BERRY_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> WITHER_BERRY_SYRUP = BLOCKS.register(FrightsDelightBlocks.WITHER_BERRY_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.WITHER_BERRY_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));
    public static final Supplier<LiquidBlock> COBWEB_SYRUP = BLOCKS.register(FrightsDelightBlocks.COBWEB_SYRUP.getPath(),
            () -> new LiquidBlock(FrightsDelightFluidsImpl.COBWEB_SYRUP, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static RegistryObject<Block> registerBlock(final ResourceLocation location, final Supplier<Block> block) {
        return BLOCKS.register(location.getPath(), block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
