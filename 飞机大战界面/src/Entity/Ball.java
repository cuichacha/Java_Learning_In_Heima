package Entity;

import Config.GameConfig;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public final class Ball extends FlyingObject {
    private final Random random = new Random();
    private final String imageName = "c" + random.nextInt(15) + ".png";
    private int speedX;
    private int speedY;
    private boolean drop;
    private int ballSpawnLocation = random.nextInt(2);
    private ArrayList<Ball> ballArrayList = new ArrayList<>();
//    private Fighter fighter = new Fighter();
    private int count;
    private int blood;
    private int initialBlood;
    private int currentBlood;

    public Ball() {
        flyingObject = ImageUtil.getImg(imageName);
        width = flyingObject.getWidth();
        height = flyingObject.getHeight();

        if (ballSpawnLocation == GameConfig.LEFT_BALL) {
            x = -width;
            speedX = 3;
        } else if (ballSpawnLocation == GameConfig.RIGHT_BALL) {
            x = GameConfig.GAME_WIDTH;
            speedX = -3;
        }

        y = 100;
        speedY = 3;
        blood = random.nextInt(10);
        initialBlood = blood;
    }

    public Ball(int x, int y, int speedY, int initialBlood) {
        flyingObject = ImageUtil.getImg(imageName);
        width = flyingObject.getWidth();
        height = flyingObject.getHeight();
        this.x = x;
        this.y = y;
        this.speedY = speedY;
        this.speedX = random.nextInt(11) - 5;
        this.initialBlood = initialBlood;
        this.blood = initialBlood;
    }

    public ArrayList<Ball> getBallArrayList() {
        return ballArrayList;
    }

    public int getBlood() {
        return blood;
    }

    public int getInitialBlood() {
        return initialBlood;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.setColor(Color.white);
        g.setFont(new Font("SongTi", Font.BOLD, 30));
//        int distanceX = blood >= 10 ? 15 : 10;
//        g.drawString(String.valueOf(blood), x + width / 2 - distanceX, y + height / 2 + 10);
        int distance = 10;
        g.drawString(String.valueOf(blood), x + width / 2 - distance, y + height / 2 + distance);
    }

    public void move() {
        x += speedX;
        if (ballSpawnLocation == GameConfig.LEFT_BALL) {
            if (x >= (GameConfig.GAME_WIDTH / 2)) {
                drop = true;
            }
        } else if (ballSpawnLocation == GameConfig.RIGHT_BALL) {
            if (x <= (GameConfig.GAME_WIDTH / 2)) {
                drop = true;
            }
        }
        y += speedY;
        if (x <= 0 && speedX < 0) {
            speedX = -speedX;
        } else if (x >= (GameConfig.GAME_WIDTH - width) && speedX > 0) {
            speedX = -speedX;
        } else if (y <= 0 && speedY < 0) {
            speedY = -speedY;
        } else if (y >= (GameConfig.GAME_HEIGHT - height) && speedY > 0) {
            speedY = -speedY;
        }

        if (drop = true) {
            y += speedY;
        }
    }

    public void createBall() {
        count++;
        if (count % 10 == 0) {
            if (ballArrayList.size() < GameConfig.BALL_MAXIMUM) {
                ballArrayList.add(new Ball());
            }
            count = 0;
        }

    }

    public void moveBall() {
        for (int i = 0; i < ballArrayList.size(); i++) {
            ballArrayList.get(i).move();
//            if (i > 0) {
//                bounce(ballArrayList.get(i - 1), ballArrayList.get(i));
//            }
        }
    }

//    public void hit() {
//        for (int i = 0; i < getBallArrayList().size(); i++) {
//            Ball ball = getBallArrayList().get(i);
//            for (int j = 0; j < fighter.getBulletArray().size(); j++) {
//                Bullet bullet = fighter.getBulletArray().get(j);
//                if (ball.ifHit(bullet)) {
//                    // 发生碰撞
//                    fighter.getBulletArray().remove(j);
//                    if (blood == 0) {
//                        getBallArrayList().remove(i);
//                    }
//                }
//            }
//        }
//    }

    public boolean ifHit(Bullet bullet) {
        if (this.y + this.height >= bullet.y && bullet.y + bullet.height >= this.y &&
            bullet.x + bullet.width >= this.x && this.x + this.width >= bullet.x) {
            blood--;
            drop = true;
            return true;
        }
        return false;
    }

//    private void bounce(Ball ball1, Ball ball2) {
//        if (ball1.x + width >= ball2.x && ball2.y + height >= ball2.y) {
//            ball1.speedX = -speedX;
//            ball1.speedY = -speedY;
//            ball2.speedX = -speedX;
//            ball2.speedY = -speedY;
//
//        }
//    }

//    public void removeBall() {
//        for (int i = 0; i < ballArrayList.size(); i++) {
//            if (ballArrayList.get(i).x < -width && ballArrayList.get(i).y > (GameConfig.GAME_HEIGHT + height)) {
//                ballArrayList.remove(i);
//            }
//        }
//    }

    public ArrayList<Ball> split() {
        ArrayList<Ball> newBallArrayList = new ArrayList<>();
        if (this.blood > 0) {
            Ball ball1 = new Ball(this.x, this.y, this.speedY, this.blood);
            Ball ball2 = new Ball(this.x, this.y, this.speedY, this.blood);
            newBallArrayList.add(ball1);
            newBallArrayList.add(ball2);
        }

        return newBallArrayList;
    }

}
