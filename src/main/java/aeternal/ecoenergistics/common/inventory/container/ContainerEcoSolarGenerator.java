package aeternal.ecoenergistics.common.inventory.container;

import aeternal.ecoenergistics.common.tile.TileEntityEcoSolarPanel;
import mekanism.common.inventory.slot.SlotEnergy;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerEcoSolarGenerator extends ContainerPassiveEcoGenerator<TileEntityEcoSolarPanel> {

    public ContainerEcoSolarGenerator(InventoryPlayer inventory, TileEntityEcoSolarPanel generator) {
        super(inventory, generator);
    }

    @Override
    protected void addSlots() {
        addSlotToContainer(new SlotEnergy.SlotCharge(tileEntity, 0, 143, 35));
    }
}
