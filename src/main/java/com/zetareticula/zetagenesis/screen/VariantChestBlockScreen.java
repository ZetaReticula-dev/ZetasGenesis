package com.zetareticula.zetagenesis.screen;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.screenhandler.BasketBlockScreenHandler;
import com.zetareticula.zetagenesis.screenhandler.VariantChestBlockScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class VariantChestBlockScreen extends HandledScreen<VariantChestBlockScreenHandler> {
    private static final Identifier TEXTURE = ZetaGenesis.id("textures/gui/container/generic_27.png");

    public VariantChestBlockScreen(VariantChestBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundWidth = 176;
        this.backgroundHeight = 168;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }



    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight);

    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
