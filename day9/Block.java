
import java.awt.Color;
import java.awt.Graphics;

/**
 * 几种颜色不同的小方块
 */
class Block {

    public int colorIndex;

    public static Color[] colors = {Color.red, Color.blue, Color.magenta,
            Color.orange, Color.green, Color.cyan, Color.yellow};

    public Block(int colorIndex) {
        this.colorIndex = colorIndex;
    }

    public void draw(Graphics g, int scale, int x, int y) {
        int px = scale * x + 1;
        int py = scale * y + 1;

        int size = scale - 2;

        g.setColor(colors[this.colorIndex]);
        g.fillRect(px, py, size, size);
    }

}
