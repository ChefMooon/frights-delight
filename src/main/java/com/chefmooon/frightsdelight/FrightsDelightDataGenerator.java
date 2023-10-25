package com.chefmooon.frightsdelight;

import com.chefmooon.frightsdelight.data.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class FrightsDelightDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TranslationGenerator::new);
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
		pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(RecipeGenerator::new);
	}
}
