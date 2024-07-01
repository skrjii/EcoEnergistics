package aeternal.ecoenergistics.client.gui;

import aeternal.ecoenergistics.common.EcoEnergistics;
import mekanism.common.util.LangUtils;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class GuiEcoEnergisticsConfig extends GuiConfig {

    public GuiEcoEnergisticsConfig(GuiScreen parent) {
        super(parent, getConfigElements(), EcoEnergistics.MOD_ID, false, false, "Mekanism Eco Energistics");
    }

    private static List<IConfigElement> getConfigElements() {
        List<IConfigElement> list = new ArrayList<>();
        list.add(new DummyConfigElement.DummyCategoryElement(LangUtils.localize("mekanismecoenergistics.configgui.ctgy.generation"), "mekanismecoenergistics.configgui.ctgy.generation", GenerationEntry.class));
        list.add(new DummyConfigElement.DummyCategoryElement(LangUtils.localize("mekanismecoenergistics.configgui.ctgy.machines"), "mekanismecoenergistics.configgui.ctgy.machines", MachinesEntry.class));
        list.add(new DummyConfigElement.DummyCategoryElement(LangUtils.localize("mekanismecoenergistics.configgui.ctgy.storage"), "mekanismecoenergistics.configgui.ctgy.storage", StorageEntry.class));
        list.add(new DummyConfigElement.DummyCategoryElement(LangUtils.localize("mekanismecoenergistics.configgui.ctgy.tier"), "mekanismecoenergistics.configgui.ctgy.tier", TierEntry.class));
        list.add(new DummyConfigElement.DummyCategoryElement(LangUtils.localize("mekanismecoenergistics.configgui.ctgy.integration"), "mekanismecoenergistics.configgui.ctgy.integration", IntegrationEntry.class));
        return list;
    }

    public static class MachinesEntry extends CategoryEntry {

        public MachinesEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(owningScreen, new ConfigElement(EcoEnergistics.configuration.getCategory("machines")).getChildElements(), owningScreen.modID,
                    Configuration.CATEGORY_GENERAL, false, false, GuiConfig.getAbridgedConfigPath(EcoEnergistics.configuration.toString()));
        }
    }

    public static class GenerationEntry extends CategoryEntry {
        public GenerationEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(owningScreen, new ConfigElement(EcoEnergistics.configuration.getCategory("generation")).getChildElements(), owningScreen.modID,
                    Configuration.CATEGORY_GENERAL, false, false, GuiConfig.getAbridgedConfigPath(EcoEnergistics.configuration.toString()));
        }
    }

    public static class StorageEntry extends CategoryEntry {

        public StorageEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(owningScreen, new ConfigElement(EcoEnergistics.configuration.getCategory("storage")).getChildElements(), owningScreen.modID,
                    Configuration.CATEGORY_GENERAL, false, false, GuiConfig.getAbridgedConfigPath(EcoEnergistics.configuration.toString()));
        }
    }

    public static class TierEntry extends CategoryEntry {
        public TierEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(owningScreen, new ConfigElement(EcoEnergistics.configuration.getCategory("tier")).getChildElements(), owningScreen.modID,
                    Configuration.CATEGORY_GENERAL, false, false, GuiConfig.getAbridgedConfigPath(EcoEnergistics.configuration.toString()));
        }
    }

    public static class IntegrationEntry extends CategoryEntry {
        public IntegrationEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
            super(owningScreen, owningEntryList, prop);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            return new GuiConfig(owningScreen, new ConfigElement(EcoEnergistics.configurationIntegration.getCategory("integration")).getChildElements(), owningScreen.modID,
                    Configuration.CATEGORY_GENERAL, false, false, GuiConfig.getAbridgedConfigPath(EcoEnergistics.configurationIntegration.toString()));
        }
    }
}
