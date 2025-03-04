package usa.zetareticula.zetasgenesis.block.render;

import usa.zetareticula.zetasgenesis.block.custom.StoveBlock;
import usa.zetareticula.zetasgenesis.block.entity.StoveBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Direction;


public class StoveBlockEntityRender implements BlockEntityRenderer<StoveBlockEntity> {
    private final ItemRenderer itemRenderer;

    public StoveBlockEntityRender(BlockEntityRendererFactory.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(StoveBlockEntity stoveBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        // Get the facing direction of the block
        Direction direction = stoveBlockEntity.getCachedState().get(StoveBlock.FACING);

        // Get the items being cooked
        DefaultedList<ItemStack> defaultedList = stoveBlockEntity.getItemsBeingCooked();
        int k = (int) stoveBlockEntity.getPos().asLong();

        // Rotate the entire grid to face the direction of the stove block
        matrixStack.push();

        // Translate to center the items on the stove
        matrixStack.translate(0.5, 1.01, 0.5);

        // Rotate the grid based on the block's facing direction
        float rotationAngle = -direction.getHorizontalQuarterTurns();
        matrixStack.multiply(RotationAxis.NEGATIVE_Y.rotationDegrees(rotationAngle));

        for (int l = 0; l < defaultedList.size(); l++) {
            ItemStack itemStack = defaultedList.get(l);
            if (!itemStack.isEmpty()) {
                matrixStack.push();

                // Custom positioning (nudge) based on index
                switch (l) {
                    case 0 -> matrixStack.translate(-0.31F, 0, -0.2F); // Bottom-left
                    case 1 -> matrixStack.translate(0F, 0, -0.2F);     // Bottom-middle
                    case 2 -> matrixStack.translate(0.31F, 0, -0.2F);  // Bottom-right
                    case 3 -> matrixStack.translate(-0.31F, 0, 0.2F);  // Top-left
                    case 4 -> matrixStack.translate(0F, 0, 0.2F);      // Top-middle
                    case 5 -> matrixStack.translate(0.31F, 0, 0.2F);   // Top-right
                }

                // Rotate the items 180 degrees if the block is facing North or South to make them face the player
                if (direction == Direction.NORTH || direction == Direction.SOUTH) {
                    matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0F));
                }

                // Lay the item flat on the stove (rotate around X-axis by 90 degrees)
                matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90.0F));

                // Scale the item down to fit
                matrixStack.scale(0.37F, 0.37F, 0.37F);

                // Render the item
                this.itemRenderer.renderItem(itemStack, net.minecraft.item.ModelTransformationMode.FIXED, i, j, matrixStack, vertexConsumerProvider, stoveBlockEntity.getWorld(), k + l);

                matrixStack.pop();
            }
        }

        matrixStack.pop(); // Pop the grid rotation transformation
    }
}
