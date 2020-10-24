/* ----------------------------------------------------------
Enum MyColor sets up pre-made colors of varying RGB values
and opacities. These will be used to color shapes and lines.
---------------------------------------------------------- */
package pack;

import javafx.scene.paint.Color;

public enum MyColor{
    RED(255,0,0,255), BLUE(0,0,255,255),
    LIME(0,255,0,255), CYAN(0,255,255,255),
    GREEN(0,128,0,255), GREY(128,128,128,255),
    MAGENTA(255,0,255,255), PURPLE(128,0,128,255),
    VIOLET(148,0,211,255), YELLOW(255,255,0,255),
    WHITE(255,255,255,255), BLACK(0,0,0,255),
    HOTPINK(255,105,180,255), ORANGE(255,165,0, 255),
    LIGHTGREY(200,200,200,255);

    private int r,g,b,a; // Value for red, green, blue, and opacity

    /* Random color picker from color library */
    public static Color getRandom() {
        int r, g, b;
        r = (int)((Math.random() * (255)));
        g = (int)((Math.random() * (255)));
        b = (int)((Math.random() * (255)));
        return Color.rgb(r,g,b,1);
    }
    MyColor(int r, int g, int b, int a){ this.r = r; this.g = g; this.b = b; this.a = a; }
    public Color getCol() { return Color.rgb(r, g, b, (double)(a/255)); }
}
