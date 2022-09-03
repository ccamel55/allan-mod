package net.allan.mod.Utils.Renderer2D.Core;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;

public class FontWrapper {

    private final MatrixStack matrices = new MatrixStack();
    private final BufferBuilder buffer = new BufferBuilder(2048);

    private final VertexConsumerProvider.Immediate immediate = VertexConsumerProvider.immediate(buffer);

    public void render(TextRenderer textRenderer, String text, float x, float y,  int color, boolean shadow, float scale) {
        x += 0.5f * scale;
        y += 0.5f * scale;

        matrices.push();
        matrices.scale(scale, scale, 1.f);

        final var matrix = matrices.peek().getPositionMatrix();
        textRenderer.draw(text, x / scale, y / scale, color, shadow, matrix, immediate, false, 0, LightmapTextureManager.MAX_LIGHT_COORDINATE);

        matrices.pop();

        MatrixStack matrixStack = RenderSystem.getModelViewStack();

        RenderSystem.disableDepthTest();
        matrixStack.push();

        RenderSystem.applyModelViewMatrix();

        immediate.draw();

        matrixStack.pop();
        RenderSystem.enableDepthTest();
        RenderSystem.applyModelViewMatrix();
    }
}
