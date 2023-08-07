package su.a71.new_soviet;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import su.a71.new_soviet.entity.TVBlockEntity;

@Environment(EnvType.CLIENT)
public class TVBlockEntityRenderer implements BlockEntityRenderer<TVBlockEntity> {
    public TVBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(TVBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
//        Rendering stuff here
        matrices.pop();
    }
}