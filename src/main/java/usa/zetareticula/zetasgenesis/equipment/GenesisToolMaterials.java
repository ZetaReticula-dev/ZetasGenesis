package usa.zetareticula.zetasgenesis.equipment;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class GenesisToolMaterials {
    public static final ToolMaterial ENDERIUM_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2031,
            12.0F,
            4.0F,
            15,
            ItemTags.REPAIRS_NETHERITE_ARMOR

    );
}