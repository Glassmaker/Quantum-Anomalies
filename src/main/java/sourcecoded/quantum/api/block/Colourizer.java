package sourcecoded.quantum.api.block;

import net.minecraft.item.ItemDye;

import java.util.Arrays;

public enum Colourizer {

    RED("red", 1F, 0F, 0F),
    ORANGE("orange", 1F, 0.5F, 0F),
    YELLOW("yellow", 1F, 1F, 0F),
    GREEN("green", 0F, 0.6F, 0F),
    LIME("lime", 0F, 1F, 0F),
    BLUE("blue", 0F, 0F, 1F),
    LIGHT_BLUE("lightBlue", 0F, 0.5F, 1F),
    MAGENTA("magenta", 0.7F, 0.5F, 0.7F),
    PINK("pink", 0.9F, 0.5F, 0.9F),
    WHITE("white", 1F, 1F, 1F),
    GRAY("gray", 0.5F, 0.5F, 0.5F),
    LIGHT_GRAY("silver", 0.7F, 0.7F, 0.7F),
    BLACK("black", 0F, 0F, 0F),
    BROWN("brown", 0.4F, 0.3F, 0.1F),
    CYAN("cyan", 0.4F, 0.6F, 0.8F),
    PURPLE("purple", 0.7F, 0F, 0.7F);

    public float[] rgb;
    public int meta;

    Colourizer(String name, float r, float g, float b) {
        rgb = new float[] {r, g, b};
        meta = Arrays.asList(ItemDye.field_150923_a).indexOf(name);
    }

    public static Colourizer match(int meta) {
        for (Colourizer colour : Colourizer.values())
            if (colour.meta == meta) return colour;

        return Colourizer.PURPLE;
    }

}
