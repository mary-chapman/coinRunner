import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

public class Coin extends PApplet {
    private PApplet sketch;
    private PImage coin = new PImage();
    float posX = random(400);
    float posY = random(300);
    int size = 20;

    public Coin(PApplet sketch) {
        Random rand = new Random();
        this.sketch = sketch;
    }

    public void create() {
        coin = sketch.loadImage("assets/coin2.png");
        coin.resize(0, size);
        sketch.image(coin, posX, posY);
    }


    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public int getSize() {
        return size;
    }

}
