package net.allan.mod.Utils.Renderer2D;

import com.mojang.blaze3d.systems.RenderSystem;
import net.allan.mod.AllanMod;
import net.allan.mod.Utils.Renderer2D.Core.FontWrapper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;

// just modified version of the games render handler :)
public class Renderer2D {

    private static MatrixStack mMatrixStack ;
    private static final FontWrapper pFontWrapper = new FontWrapper();

    public static void begin(MatrixStack matrixStack) {
        mMatrixStack = matrixStack;
    }

    public static void finish() {
        mMatrixStack = null;
    }

    public static void drawRect(float x, float y, float w, float h, Color color) {
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();

        final var matrices = mMatrixStack.peek().getPositionMatrix();
        final var bufferBuilder = Tessellator.getInstance().getBuffer();

        bufferBuilder.begin(VertexFormat.DrawMode.DEBUG_LINE_STRIP, VertexFormats.POSITION_COLOR);

        bufferBuilder.vertex(matrices, x, y + h, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x + w, y + h, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x + w, y, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x, y, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x, y + h, 0.0F).color(color.getRGB()).next();

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferRenderer.drawWithShader(bufferBuilder.end());

        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    public static void drawRectFilled(float x, float y, float w, float h, Color color) {
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();

        final var matrices = mMatrixStack.peek().getPositionMatrix();
        final var bufferBuilder = Tessellator.getInstance().getBuffer();

        bufferBuilder.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_COLOR);

        bufferBuilder.vertex(matrices, x, y + h, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x + w, y + h, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x + w, y, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x, y, 0.0F).color(color.getRGB()).next();

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferRenderer.drawWithShader(bufferBuilder.end());

        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    public static void drawLine(float x1, float y1, float x2, float y2, Color color) {
        RenderSystem.enableBlend();
        RenderSystem.disableTexture();
        RenderSystem.defaultBlendFunc();

        final var matrices = mMatrixStack.peek().getPositionMatrix();
        final var bufferBuilder = Tessellator.getInstance().getBuffer();

        bufferBuilder.begin(VertexFormat.DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);

        bufferBuilder.vertex(matrices, x1, y1, 0.0F).color(color.getRGB()).next();
        bufferBuilder.vertex(matrices, x2, y2, 0.0F).color(color.getRed()).next();

        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        BufferRenderer.drawWithShader(bufferBuilder.end());

        RenderSystem.enableTexture();
        RenderSystem.disableBlend();
    }

    public static void drawText(float x, float y, Color color, String string) {
        pFontWrapper.render(AllanMod.client.textRenderer, string, x, y, color.getRGB(), false, 1.f);
    }

    public static void drawText(float x, float y, float scale, Color color, String string) {
        pFontWrapper.render(AllanMod.client.textRenderer, string, x, y, color.getRGB(), false, scale);
    }
}