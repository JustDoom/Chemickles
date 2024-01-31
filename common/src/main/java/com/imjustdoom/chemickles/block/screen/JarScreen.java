package com.imjustdoom.chemickles.block.screen;

import com.imjustdoom.chemickles.Chemickles;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class JarScreen extends AbstractContainerScreen<JarScreenHandler> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Chemickles.MOD_ID, "textures/gui/pickle_jar.png");

    public JarScreen(JarScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleLabelX = (imageWidth - font.width(title)) / 2;
    }

    @Override
    protected void renderBg(PoseStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        GuiComponent.blit(matrices, x, y, 0, 0, imageWidth, imageHeight);

        renderProgressArrow(matrices, x, y);
    }

    private void renderProgressArrow(PoseStack matrices, int x, int y) {
        if(menu.isCrafting()) {
            GuiComponent.blit(matrices, x + 105, y + 33, 176, 0, 8, menu.getScaledProgress());
        }
    }

    @Override
    public void render(PoseStack matrices, int mouseX, int mouseY, float delta) {
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        renderTooltip(matrices, mouseX, mouseY);
    }
}
