package aeternal.ecoenergistics;

import net.minecraft.util.ResourceLocation;

public class Constants {

    public static final String MOD_ID = "mekanismecoenergistics";
    public static final String MOD_NAME = "MekanismEcoEnergistics";
    public static final String MOD_VERSION = "1.0";
    public static final String MOD_DEPS = "after:mekanism";
    public static final String PREFIX_MOD = "mekanismecoenergistics:";
    public static final String PREFIX_MODEL = PREFIX_MOD + "textures/model/";
    public static final String PREFIX_MISC = PREFIX_MOD + "textures/misc/";
    public static final String PREFIX_OBJ_MODEL = PREFIX_MOD + "model/";

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
