package com.zetareticula.zetasgenesis.mixin;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.zetareticula.zetasgenesis.item.custom.PickAndAxe;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "disablesShield", at = @At("HEAD"), cancellable = true)
    private void modifyDisablesShield(CallbackInfoReturnable<Boolean> cir) {
        LivingEntity entity = (LivingEntity) (Object) this;
        ItemStack weapon = entity.getMainHandStack();

        if (weapon.getItem() instanceof AxeItem || weapon.getItem() instanceof PickAndAxe) {
            cir.setReturnValue(true);
        }
    }
}
