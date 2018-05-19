import processing.core.PApplet;


public class Board extends PApplet {
    private int width = 640;
    private int height = 480;
    Man man;
    Coin[] coin = new Coin[5];
    Arrow arrow;
    int outOfBounds = 1000;

    public void settings() {
        size(width, height);
    }

    public void setup() {
        man = new Man(this);
        man.create();

        arrow = new Arrow(this);
        arrow.create();

        for (int i = 0; i < 5; i++) {
            coin[i] = new Coin(this);
            coin[i].setPosY(random(height));
            coin[i].setPosX(random(width));
        }
    }

    public void draw() {
        background(255);

        man.move();

        for (int i = 0; i < 5; i++) {
            coin[i].create();
        }

        arrow.move(10);

        //COLLISSIONS
        // collision # 1: man and arrow
        if (arrow.getPosX() + arrow.getWidth() > man.getxPos()
                && arrow.getPosX() + arrow.getWidth() < man.getxPos() + man.getHeight()
                && arrow.getPosY() > man.getyPos() - man.getHeight()
                && arrow.getPosY() < man.getyPos() + man.getHeight()) {
            System.out.println("you ran into the arrow");
            //noLoop();
        }

        //collision #2: man and coin
        for (int i = 0; i < coin.length; i++) {
            if (coin[i].getPosX() + coin[i].getSize() < man.getxPos() + man.getWidth()
                    && man.getxPos() < coin[i].getPosX() + coin[i].getSize()
//                    && coin[i].getPosX() - coin[i].getSize() > man.getxPos() + man.getWidth()
                    && coin[i].getPosY() > man.getyPos() - man.getHeight()
                    && coin[i].getPosY() < man.getyPos() + man.getHeight()) {
                System.out.println("you grabbed a coin");
                coin[i].setPosX(outOfBounds);
                coin[i].setPosY(outOfBounds);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
