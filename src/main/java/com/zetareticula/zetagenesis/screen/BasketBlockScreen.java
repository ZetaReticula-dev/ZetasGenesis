package com.zetareticula.zetagenesis.screen;

import com.zetareticula.zetagenesis.ZetaGenesis;
import com.zetareticula.zetagenesis.screenhandler.BasketBlockScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BasketBlockScreen extends HandledScreen<BasketBlockScreenHandler> {
    private static final Identifier TEXTURE = ZetaGenesis.id("textures/gui/container/basket.png");

    public BasketBlockScreen(BasketBlockScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
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
