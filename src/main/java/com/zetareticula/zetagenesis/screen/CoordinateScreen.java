
/*
package com.zetareticula.zetagenesis.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CoordinateScreen extends Screen {

    private final MinecraftClient client;
    private TextFieldWidget xField;
    private TextFieldWidget yField;
    private TextFieldWidget zField;

    public CoordinateScreen() {
        super(Text.literal("Enter Coordinates"));
        this.client = MinecraftClient.getInstance();
    }

    @Override
    protected void init() {
        // Create text fields for X, Y, Z coordinates
        this.xField = new TextFieldWidget(this.textRenderer, this.width / 2 - 50, this.height / 2 - 30, 100, 20, Text.literal("X"));
        this.yField = new TextFieldWidget(this.textRenderer, this.width / 2 - 50, this.height / 2, 100, 20, Text.literal("Y"));
        this.zField = new TextFieldWidget(this.textRenderer, this.width / 2 - 50, this.height / 2 + 30, 100, 20, Text.literal("Z"));

        // Add text fields to the screen
        this.addSelectableChild(xField);
        this.addSelectableChild(yField);
        this.addSelectableChild(zField);

        // Add a button to confirm the input
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Teleport"), button -> {
            onTeleport();
        }).dimensions(this.width / 2 - 50, this.height / 2 + 60, 100, 20).build());
    }

    // Render the screen
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, 0,0,0);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        xField.render(context, mouseX, mouseY, delta);
        yField.render(context, mouseX, mouseY, delta);
        zField.render(context, mouseX, mouseY, delta);
    }

    // Handle teleportation logic when the player clicks the "Teleport" button
    private void onTeleport() {
        try {
            double x = Double.parseDouble(this.xField.getText());
            double y = Double.parseDouble(this.yField.getText());
            double z = Double.parseDouble(this.zField.getText());

            Vec3d coordinates = new Vec3d(x, y, z);
            BlockPos teleportPos = BlockPos.ofFloored(x, y, z);  // Convert double to BlockPos

            // Send a message to the player (optional)
            MinecraftClient.getInstance().player.sendMessage(Text.literal("Teleporting to: " + coordinates), false);

            // Close the screen
            this.close();

            // Perform teleportation directly (client-side teleport in single-player)
            MinecraftClient.getInstance().player.setPos(x, y, z);

        } catch (NumberFormatException e) {
            MinecraftClient.getInstance().player.sendMessage(Text.literal("Invalid coordinates!"), false);
        }
    }
}
 */


