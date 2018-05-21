import processing.core.PApplet;
import processing.core.PImage;

public class Man extends PApplet {
    private PApplet sketch;
    private int currentFrame = 0;
    private PImage[] img_right = new PImage[9];
    private PImage[] img_left = new PImage[9];
    private PImage[] img_up_down = new PImage[9];
    private PImage restPose = new PImage();
    private int width = 20;
    private int height = 50;
    private int coins = 10;
    private int coinCount = coins;
    private boolean isAlive = true;

    private float xPos;
    private float yPos;

    public Man(PApplet sketch) {
        this.sketch = sketch;
    }

    public void create() {
        // running right
        img_right[0] = sketch.loadImage("assets/man_running_right/running0.png");
        img_right[1] = sketch.loadImage("assets/man_running_right/running1.png");
        img_right[2] = sketch.loadImage("assets/man_running_right/running2.png");
        img_right[3] = sketch.loadImage("assets/man_running_right/running3.png");
        img_right[4] = sketch.loadImage("assets/man_running_right/running4.png");
        img_right[5] = sketch.loadImage("assets/man_running_right/running5.png");
        img_right[6] = sketch.loadImage("assets/man_running_right/running6.png");
        img_right[7] = sketch.loadImage("assets/man_running_right/running7.png");
        img_right[8] = sketch.loadImage("assets/man_running_right/running8.png");

        // running left
        img_left[0] = sketch.loadImage("assets/man_running_left/running0.png");
        img_left[1] = sketch.loadImage("assets/man_running_left/running1.png");
        img_left[2] = sketch.loadImage("assets/man_running_left/running2.png");
        img_left[3] = sketch.loadImage("assets/man_running_left/running3.png");
        img_left[4] = sketch.loadImage("assets/man_running_left/running4.png");
        img_left[5] = sketch.loadImage("assets/man_running_left/running5.png");
        img_left[6] = sketch.loadImage("assets/man_running_left/running6.png");
        img_left[7] = sketch.loadImage("assets/man_running_left/running7.png");
        img_left[8] = sketch.loadImage("assets/man_running_left/running8.png");

        // running up and down
        img_up_down[0] = sketch.loadImage("assets/man_running_down_up/running0.png");
        img_up_down[1] = sketch.loadImage("assets/man_running_down_up/running1.png");
        img_up_down[2] = sketch.loadImage("assets/man_running_down_up/running2.png");
        img_up_down[3] = sketch.loadImage("assets/man_running_down_up/running3.png");
        img_up_down[4] = sketch.loadImage("assets/man_running_down_up/running4.png");
        img_up_down[5] = sketch.loadImage("assets/man_running_down_up/running5.png");
        img_up_down[6] = sketch.loadImage("assets/man_running_down_up/running6.png");
        img_up_down[7] = sketch.loadImage("assets/man_running_down_up/running7.png");
        img_up_down[8] = sketch.loadImage("assets/man_running_down_up/running8.png");

        restPose = sketch.loadImage("assets/man_resting.png");

        sketch.frameRate(10);
    }

    public void move() {
        currentFrame = (currentFrame + 1) % 3;
        if (sketch.keyPressed == true) {
            if (sketch.keyCode == RIGHT) {
                sketch.image(img_right[currentFrame % 9], xPos += 10, yPos);
            } else if (sketch.keyCode == LEFT) {
                sketch.image(img_left[currentFrame % 9], xPos -= 10, yPos);
            } else if (sketch.keyCode == UP) {
                sketch.image(img_up_down[currentFrame % 9], xPos, yPos -= 10);
            } else if (sketch.keyCode == DOWN) {
                sketch.image(img_up_down[currentFrame % 9], xPos, yPos += 10);
            }
        } else {
            sketch.image(restPose, xPos, yPos);
        }
    }

    public float getxPos() {
        return xPos;
    }

    public float getyPos() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }
}
