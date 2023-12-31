/*


package aeternal.ecoenergistics.client.gui;

import java.util.Collections;

import aeternal.ecoenergistics.common.inventory.container.ContainerEcoSolarPanel;
import aeternal.ecoenergistics.common.tile.solar.panel.TileEntitySolarPanelAdvanced;
import mekanism.client.gui.element.GuiEnergyInfo;
import mekanism.client.gui.element.GuiRedstoneControl;
import mekanism.client.gui.element.GuiSlot;
import mekanism.client.gui.element.GuiSlot.SlotOverlay;
import mekanism.client.gui.element.GuiSlot.SlotType;
import mekanism.client.gui.element.tab.GuiSecurityTab;
import mekanism.client.render.MekanismRenderer;
import mekanism.common.util.LangUtils;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSolarPanel extends GuiEcoTile<TileEntitySolarPanelAdvanced> {

    public GuiSolarPanel(InventoryPlayer inventory, TileEntitySolarPanelAdvanced tile) {
        super(tile, new ContainerEcoSolarPanel(inventory, tile));
        ResourceLocation resource = getGuiLocation();
        addGuiElement(new GuiRedstoneControl(this, tileEntity, resource));
        addGuiElement(new GuiSecurityTab(this, tileEntity, resource));
        addGuiElement(new GuiEnergyInfo(Collections::emptyList, this, resource));
        addGuiElement(new GuiSlot(SlotType.NORMAL, this, resource, 142, 34).with(SlotOverlay.POWER));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(tileEntity.getName(), !tileEntity.fullName.contains("Advanced") ? 45 : 30, 6, 0x404040);
        fontRenderer.drawString(LangUtils.localize("container.inventory"), 8, (ySize - 96) + 2, 0x404040);
        renderCenteredText(48, 80, 28, 0x00CD00, LangUtils.localize("gui.producing"));
        renderCenteredText(48, 80, 42, 0x00CD00, MekanismUtils.getEnergyDisplay(tileEntity.getProduction()) + "/t");
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTick, int mouseX, int mouseY) {
        //Ensure the GL color is white as mods adding an overlay (such as JEI for bookmarks), might have left
        // it in an unexpected state.
        MekanismRenderer.resetColor();
        mc.renderEngine.bindTexture(getGuiLocation());
        drawTexturedModalRect(guiLeft + 20, guiTop + 37, 176, tileEntity.canSeeSun() ? 52 : 64, 12, 12);
        int xAxis = mouseX - guiLeft;
        int yAxis = mouseY - guiTop;
        drawGuiContainerBackgroundLayer(xAxis, yAxis);
        //   guiElements.forEach(element -> element.renderBackground(xAxis, yAxis, guiLeft, guiTop));
    }

    @Override
    protected ResourceLocation getGuiLocation() {
        return MekanismUtils.getResource(ResourceType.GUI, "GuiSolarGenerator.png");
    }

}

 @Override
    protected void drawGuiContainerBackgroundLayer(int xAxis, int yAxis) {
        super.drawGuiContainerBackgroundLayer(xAxis, yAxis);
        drawTexturedModalRect(guiLeft + 20, guiTop + 37, 176, tileEntity.canSeeSun() ? 52 : 64, 12, 12);
    }




    @Override
    protected ResourceLocation getGuiLocation() {
        return MekanismUtils.getResource(ResourceType.GUI, "GuiSolarGenerator.png");
    }
}

*/
