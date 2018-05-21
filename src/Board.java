import processing.core.PApplet;
import processing.core.PFont;

import java.util.ArrayList;


public class Board extends PApplet {
    private int width = 640;
    private int height = 480;
    PFont myFont;
    PFont welcome;

//    //status
//    boolean homeScreen = false;
    boolean playGame = false;
    boolean gameOver = false;
    boolean homeScreen = true;
    boolean youWin = false;
//    boolean youWin = false;

    // objects
    Man man;
    ArrayList<Coin> coin = new ArrayList<>();
    Arrow[] arrow = new Arrow[3];

    int outOfBounds = 1000;

    public void settings() {
        size(width, height);
    }

    public void setup() {
        man = new Man(this);
        man.create();
        for (int i = 0; i < arrow.length; i++) {
            arrow[i] = new Arrow(this);
            arrow[i].create();
        }
        for (int i = 0; i < man.getCoins(); i++) {
            coin.add(new Coin(this));
            coin.get(i).setPosX(random(100, width - 50));
            coin.get(i).setPosY(random(100, height - 50));
        }

        myFont = createFont("MonotypeGurmukhi", 12);
        textFont(myFont);
    }

    public void draw() {
        background(255);
        welcome = createFont("MonotypeGurmukhi", 20);
        textFont(welcome);
        textAlign(CENTER, CENTER);

        if (homeScreen == true) {

            text("play ", width / 2, 250);
            if (mouseX > width / 2 - 50 && mouseX < width / 2 + 50
                    && mouseY > 250 && mouseY < 250 + 20) {
                fill(66, 244, 155);
                System.out.println("over");
                if (mousePressed == true) {
                    playGame = true;
                }
            } else {
                fill(0);
            }
        }
        if (playGame == true) {

            gameOver = false;
            homeScreen = false;
            play();
        }


        if (gameOver == true) {
            text("play again?", width/2, 250);
            if (mouseX > width/2 - 100 && mouseX < width/2 + 100
                    && mouseY > 250 && mouseY < 250 + 20) {
                if (mousePressed == true) {
                    playGame = true;
                }
                fill(66, 244, 155);
            } else {
                fill(0);
            }
        }
        if (youWin == true) {
            text("play again?", width/2, 250);
            if (mouseX > width/2 - 100 && mouseX < width/2 + 100
                    && mouseY > 250 && mouseY < 250 + 20) {
                if (mousePressed == true) {
                    playGame = true;
                    youWin = false;
                }
                fill(66, 244, 155);
            } else {
                fill(0);
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void play() {
        //int coinCoint = 10;

        background(255);
        text("coins remaining: " + man.getCoinCount(), width/2, 12);
        fill(0);


        // DISPLAY OBJECTS
        man.move();
        for (int i = 0; i < man.getCoins(); i++) {
            coin.get(i).create();
        }
        for (int i = 0; i < arrow.length; i++) {
            arrow[i].move(i + 10);
        }

        // collision #1: man and arrow
        for (int i = 0; i < arrow.length; i++) {
            if (arrow[i].getPosX() + arrow[i].getWidth() > man.getxPos()
                    && arrow[i].getPosX() + arrow[i].getWidth() < man.getxPos() + man.getWidth()
                    && arrow[i].getPosY() + arrow[i].getHeight() > man.getyPos()
                    && arrow[i].getPosY() < man.getyPos() + man.getHeight()) {
                resetBoard();
                gameOver = true;
                playGame = false;
                System.out.println("you ded");
            }
        }
        //collision #2: man and coin
        for (int i = 0; i < coin.size(); i++) {
            if (coin.get(i).getPosX() + coin.get(i).getSize() < man.getxPos() + man.getWidth()
                    && man.getxPos() < coin.get(i).getPosX() + coin.get(i).getSize()
                    && coin.get(i).getPosY() > man.getyPos() - man.getHeight()
                    && coin.get(i).getPosY() < man.getyPos() + man.getHeight()) {
                coin.get(i).setPosY(outOfBounds);
                man.setCoinCount(man.getCoinCount()-1);
                if (man.getCoinCount() == 0) {
                    playGame = false;
                    youWin = true;
                    resetBoard();
                }
            }
        }
    }
    public void resetBoard() {
        for (int j = 0; j < arrow.length; j++) {
            arrow[j].setPosX(0);
        }
        for (int j = 0; j < 10; j++) {
            coin.get(j).setPosY(random(300));
            coin.get(j).setPosX(random(400));
        }
        man.setCoinCount(10);
    }
}


