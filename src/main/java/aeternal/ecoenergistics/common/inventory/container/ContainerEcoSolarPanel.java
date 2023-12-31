package aeternal.ecoenergistics.common.inventory.container;

import mekanism.common.inventory.slot.SlotEnergy.SlotCharge;
import aeternal.ecoenergistics.common.tile.solar.panel.TileEntitySolarPanelAdvanced;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerEcoSolarPanel extends ContainerPassiveGenerator<TileEntitySolarPanelAdvanced> {

    public ContainerEcoSolarPanel(InventoryPlayer inventory, TileEntitySolarPanelAdvanced generator) {
        super(inventory, generator);
    }

    @Override
    protected void addSlots() {
        addSlotToContainer(new SlotCharge(tileEntity, 0, 143, 35));
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityPlayer) {
        return true;
    }
}