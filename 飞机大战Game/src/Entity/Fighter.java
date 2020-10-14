package Entity;

import Config.GameConfig;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.util.ArrayList;

public final class Fighter extends FlyingObject {
    //    Bullet bulletArray[] = new Bullet[3];
    private ArrayList<Bullet> bulletArray = new ArrayList<>();
    private int count;

    public Fighter() {
        flyingObject = ImageUtil.getImg("hero.png");
        width = flyingObject.getWidth() / 2;
        height = flyingObject.getHeight() / 2;
        x = 200;
        y = 620;
        speed = 10;
    }

//    public Bullet[] getBulletArray() {
//        return bulletArray;
//    }


    public ArrayList<Bullet> getBulletArray() {
        return bulletArray;
    }

    // 画飞机方法
    @Override
    public void draw(Graphics g) {
        g.drawImage(this.flyingObject, this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    public void moveToLeft() {
        x -= speed;
        if (x <= 0) {
            x = 0;
        }

    }

    public void moveToRight() {
        x += speed;
        if (x >= GameConfig.GAME_WIDTH + 5 - this.getWidth()) {
            x = GameConfig.GAME_WIDTH + 5 - this.getWidth();
        }
    }

    public void moveUp() {
        y -= speed;
        if (y <= 0) {
            y = 0;
        }
    }

    public void moveDown() {
        y += speed;
        if (y >= GameConfig.GAME_HEIGHT + 2 - this.getHeight()) {
            y = GameConfig.GAME_HEIGHT + 2 - this.getHeight();
        }
    }

    public void shoot() {
        count++;
        if (count % 5 == 0) {
            Bullet bullet = new Bullet(this.getX(), this.getY());
            bulletArray.add(bullet);
            count = 0;
        }

        for (int i = bulletArray.size() - 1; i >= 0; i--) {
            Bullet bullet = bulletArray.get(i);
            bullet.move();
            if (bullet.y < -bullet.height) {
                bulletArray.remove(bullet);
            }
        }
    }

    public boolean ifCrash(Ball ball) {
        if (this.y + this.height >= ball.y && ball.y + ball.height >= this.y &&
                ball.x + ball.width >= this.x && this.x + this.width >= ball.x) {
            changeImage();
            return true;
        }
        return false;
    }

    public void changeImage() {
        flyingObject = ImageUtil.getImg("boom.png");
    }

//        if (count % 10 == 0) {
//            Bullet bullet = new Bullet(this.getX(), this.getY());
//            bulletArray[0] = bullet;
//
//        } else if (count % 15 == 0) {
//            Bullet bullet = new Bullet(this.getX(), this.getY());
//            bulletArray[1] = bullet;
//
//        } else if (count % 25 == 0) {
//            Bullet bullet = new Bullet(this.getX(), this.getY());
//            bulletArray[2] = bullet;
//
//        }

//        for (int i = 0; i < bulletArray.length; i++) {
//            Bullet bullet = bulletArray[i];
//            bullet.move();
//        }
//        } else if (count % 35 == 0) {
//            Bullet bullet = new Bullet(this.getX(), this.getY());
//            bulletArray[3] = bullet;
//        } else if (count % 45 == 0) {
//            Bullet bullet = new Bullet(this.getX(), this.getY());
//            bulletArray[4] = bullet;
//        } else if (count % 40 == 0) {
//            Bullet bullet = new Bullet(this.getX(), this.getY());
//            bulletArray[5] = bullet;
//        }


//    public void generateBullet(Graphics g, Bullet bullet) {
//        bullet.draw(g);
//    }
//
//    public void method(Graphics g) {
//
//    }
}
