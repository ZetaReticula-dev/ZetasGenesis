package usa.zetareticula.zetasgenesis.item.custom;

import usa.zetareticula.zetasgenesis.equipment.GenesisTools;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HalberdItem extends Item {
    public HalberdItem(GenesisTools material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(material.applyHalberdSettings(settings, attackDamage, attackSpeed));
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return true;
    }

    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }
}
