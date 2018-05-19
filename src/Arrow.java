import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Arrow extends PApplet {
    private PApplet sketch;
    private float posX = 0;
    private float posY = 200;
    int width = 40;

    private PImage arrow_right = new PImage();

    public Arrow(PApplet sketch) {
        this.sketch = sketch;
    }

    public void create() {
        arrow_right = sketch.loadImage("assets/arrow_right.png");
        arrow_right.resize(width, 15);
    }

    public void move(int speed) {
        Board board = new Board();

        sketch.image(arrow_right,  posX += speed, posY);

        if (posX > board.getWidth()) {
            posX = 0;
            posY = random(board.getHeight());
        }
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }
}
