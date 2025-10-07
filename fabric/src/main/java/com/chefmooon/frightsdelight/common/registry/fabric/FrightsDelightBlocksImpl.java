package com.chefmooon.frightsdelight.common.registry.fabric;

import com.chefmooon.frightsdelight.common.block.*;
import com.chefmooon.frightsdelight.common.block.drinkableFeastBlocks.*;
import com.chefmooon.frightsdelight.common.block.glassCupBlocks.*;
import com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.storage.loot.LootTable;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.refabricated.RegUtils;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks.slimeApplePunchBowlLight;
import static com.chefmooon.frightsdelight.common.registry.FrightsDelightBlocks.slimeApplePunchLight;

public class FrightsDelightBlocksImpl {
    public static final Supplier<Block> SOUL_BERRY_BUSH = registerBlock(FrightsDelightBlocks.SOUL_BERRY_BUSH, SoulBerryBushBlock::new,
            Block.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));
    public static final Supplier<Block> WITHER_BERRY_BUSH = registerBlock(FrightsDelightBlocks.WITHER_BERRY_BUSH, WitherBerryBushBlock::new,
            Block.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH));

    public static final Supplier<Block> FLESH_CRATE = registerBlock(FrightsDelightBlocks.FLESH_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> BONE_CRATE = registerBlock(FrightsDelightBlocks.BONE_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> PHANTOM_CRATE = registerBlock(FrightsDelightBlocks.PHANTOM_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> WEB_CRATE = registerBlock(FrightsDelightBlocks.WEB_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.SPIDER_EYE_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> FERMENTED_SPIDER_EYE_CRATE = registerBlock(FrightsDelightBlocks.FERMENTED_SPIDER_EYE_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> POISONOUS_POTATO_CRATE = registerBlock(FrightsDelightBlocks.POISONOUS_POTATO_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    public static final Supplier<Block> ROTTEN_TOMATO_CRATE = registerBlock(FrightsDelightBlocks.ROTTEN_TOMATO_CRATE,
            Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD));
    
    public static final Supplier<Block> PUNCH_ROTTEN_FLESH = registerBlock(FrightsDelightBlocks.PUNCH_ROTTEN_FLESH,
            (properties) -> new RottenFleshGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final Supplier<Block> PUNCH_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCH_SLIMEAPPLE,
            (properties) -> new SlimeAppleGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).lightLevel(slimeApplePunchLight()));
    public static final Supplier<Block> PUNCH_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCH_SPIDEREYE,
            (properties) -> new SpiderEyeGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final Supplier<Block> PUNCH_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCH_GHASTTEAR,
            (properties) -> new GhastTearGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final Supplier<Block> PUNCH_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCH_SOUL_BERRY,
            (properties) -> new SoulBerryGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final Supplier<Block> PUNCH_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCH_WITHER_BERRY,
            (properties) -> new WitherBerryGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));
    public static final Supplier<Block> PUNCH_COBWEB = registerBlock(FrightsDelightBlocks.PUNCH_COBWEB,
            (properties) -> new CobwebGlassCupBlock(() -> FrightsDelightItemsImpl.PUNCH_COBWEB.get(), properties), BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS));

    public static final Supplier<Block> PUNCHBOWL_ROTTEN_FLESH = registerBlock(FrightsDelightBlocks.PUNCHBOWL_ROTTEN_FLESH,
            (properties) -> new RottenFleshDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_ROTTEN_FLESH.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS));
    public static final Supplier<Block> PUNCHBOWL_SLIMEAPPLE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SLIMEAPPLE,
            (properties) -> new SlimeAppleDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_SLIMEAPPLE.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS).lightLevel(slimeApplePunchBowlLight()));
    public static final Supplier<Block> PUNCHBOWL_SPIDEREYE = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SPIDEREYE,
            (properties) -> new SpiderEyeDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_SPIDEREYE.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS));
    public static final Supplier<Block> PUNCHBOWL_GHASTTEAR = registerBlock(FrightsDelightBlocks.PUNCHBOWL_GHASTTEAR,
            (properties) -> new GhastTearDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_GHASTTEAR.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS));
    public static final Supplier<Block> PUNCHBOWL_SOUL_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_SOUL_BERRY,
            (properties) -> new SoulBerryDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_SOUL_BERRY.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS));
    public static final Supplier<Block> PUNCHBOWL_WITHER_BERRY = registerBlock(FrightsDelightBlocks.PUNCHBOWL_WITHER_BERRY,
            (properties) -> new WitherBerryDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_WITHER_BERRY.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS));
    public static final Supplier<Block> PUNCHBOWL_COBWEB = registerBlock(FrightsDelightBlocks.PUNCHBOWL_COBWEB,
            (properties) -> new CobwebDrinkableFeastBlock(() -> FrightsDelightItemsImpl.PUNCH_COBWEB.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).strength(2.0F).sound(SoundType.GLASS));

    public static final Supplier<Block> ROTTEN_FLESH_PIE = registerBlock(FrightsDelightBlocks.ROTTEN_FLESH_PIE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.ROTTEN_FLESH_PIE_SLICE.get()),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> SLIMEAPPLE_PIE = registerBlock(FrightsDelightBlocks.SLIMEAPPLE_PIE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.SLIMEAPPLE_PIE_SLICE.get()),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> SPIDEREYE_PIE = registerBlock(FrightsDelightBlocks.SPIDEREYE_PIE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.SPIDEREYE_PIE_SLICE.get()),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> GHASTTEAR_PIE = registerBlock(FrightsDelightBlocks.GHASTTEAR_PIE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.GHASTTEAR_PIE_SLICE.get()),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> SOUL_BERRY_CHEESECAKE = registerBlock(FrightsDelightBlocks.SOUL_BERRY_CHEESECAKE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.SOUL_BERRY_CHEESECAKE_SLICE.get()),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> WITHER_BERRY_CHEESECAKE = registerBlock(FrightsDelightBlocks.WITHER_BERRY_CHEESECAKE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.WITHER_BERRY_CHEESECAKE_SLICE.get()),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
    public static final Supplier<Block> COBWEB_PIE = registerBlock(FrightsDelightBlocks.COBWEB_PIE,
            (properties) -> new PieBlock(properties, () -> FrightsDelightItemsImpl.COBWEB_PIE_SLICE.get()),
            BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));

    public static Supplier<Block> registerBlock(final ResourceLocation location, final Function<BlockBehaviour.Properties, Block> function, final BlockBehaviour.Properties properties) {
        properties.setId(ResourceKey.create(Registries.BLOCK, location));
        return regBlock(location, () -> function.apply(properties));
    }

    private static <B extends Block> Supplier<B> regBlock(final ResourceLocation location, Supplier<B> supplier) {
        B object = supplier.get();
        Registry.register(BuiltInRegistries.BLOCK, location, object);
        return () -> object;
    }

    public static void register() {

    }
}
