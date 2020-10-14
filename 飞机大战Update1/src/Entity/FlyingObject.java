package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FlyingObject {
    protected BufferedImage img;
    //坐标
    protected int x;
    protected int y;
    //宽高
    protected int width;
    protected int height;

    //移动速度
    protected int speed;


    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void draw(Graphics g) {
        //绘制
        g.drawImage(img, x, y, width, height, null);

    }

    public boolean collide(FlyingObject flyingObject) {
        boolean r = flyingObject.y < this.y + this.height && flyingObject.y + flyingObject.height > this.y &&
                flyingObject.x + flyingObject.width > this.x && this.x + this.width > flyingObject.x;
        return r;
    }
}
