package aeternal.ecoenergistics;

import aeternal.ecoenergistics.config.EcoConfig;
import mekanism.common.block.states.BlockStateMachine;
import mekanism.common.config.MekanismConfig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class Constants {

    public static final String MOD_ID = "mekanismecoenergistics";
    public static final String MOD_NAME = "MekanismEcoEnergistics";
    public static final String MOD_VERSION = "1.0";
    public static final String MOD_DEPS = "after:mekanism";
    public static final String PREFIX_MOD = "mekanismecoenergistics:";
    public static final String PREFIX_MODEL = PREFIX_MOD + "textures/model/";
    public static final String PREFIX_MISC = PREFIX_MOD + "textures/misc/";
    public static final String PREFIX_OBJ_MODEL = PREFIX_MOD + "model/";
    public static final boolean DraconicLoaded = Loader.isModLoaded("draconicevolution");
    public static final boolean AvaritiaLoaded = Loader.isModLoaded("avaritia");
    public static final boolean BotaniaLoaded = Loader.isModLoaded("botania");
    public static final boolean DraconicConfirm = EcoConfig.current().generators.DraconicEnable.val();
    public static final boolean AvaritiaConfirm = EcoConfig.current().generators.AvaritiaEnable.val();
    public static final boolean BotaniaConfirm = EcoConfig.current().generators.BotaniaEnable.val();

    public static final boolean PURIFICATION_ENABLED = MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.PURIFICATION_CHAMBER);
    public static final boolean INJECTION_ENABLED = MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.CHEMICAL_INJECTION_CHAMBER);
    public static final boolean INFUSION_ENABLED = MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.METALLURGIC_INFUSER);
    public static final boolean ENRICHMENT_ENABLED = MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.ENRICHMENT_CHAMBER);
    public static final boolean CRUSHER_ENABLED = MekanismConfig.current().general.machinesManager.isEnabled(BlockStateMachine.MachineType.CRUSHER);

    public static final String EMTPY_TEXTURE = "emptyTexture";

    public static ResourceLocation getResource(Constants.ResourceType type, String name) {
        return new ResourceLocation("mekanismecoenergistics", type.getPrefix() + name);
    }

    public static enum ResourceType {
        GUI("gui"),
        GUI_ELEMENT("gui/elements"),
        SOUND("sound"),
        RENDER("render"),
        TEXTURE_BLOCKS("textures/blocks"),
        TEXTURE_ITEMS("textures/items"),
        MODEL("models"),
        INFUSE("infuse");

        private String prefix;

        private ResourceType(String s) {
            this.prefix = s;
        }

        public String getPrefix() {
            return this.prefix + "/";
        }
    }

}
