package sourcecoded.quantum.crafting.arrangement;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import sourcecoded.quantum.api.arrangement.ArrangementRegistry;
import sourcecoded.quantum.api.arrangement.ArrangementShapedRecipe;
import sourcecoded.quantum.registry.QABlocks;

public class ArrangementRecipes {

    public static void init() {
        ArrangementRegistry.addRecipe(new ArrangementShapedRecipe(new ItemStack(Blocks.stonebrick, 1, 3), " s ", " b ", " s ", 'b', Blocks.stonebrick, 's', new ItemStack(Blocks.stone_slab, 1, OreDictionary.WILDCARD_VALUE)));

        ArrangementRegistry.addRecipe(new ArrangementShapedRecipe(new ItemStack(QABlocks.INJECTED_STONE.getBlock(), 8), " o ", "oso", " o ", 'o', Blocks.obsidian, 's', Blocks.stone));
        ArrangementRegistry.addRecipe(new ArrangementShapedRecipe(new ItemStack(QABlocks.INJECTED_CORNERSTONE.getBlock(), 8), " o ", "oso", " o ", 'o', Blocks.obsidian, 's', new ItemStack(Blocks.stonebrick, 1, 3)));
    }

}
