package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

class FlyingObject {
    protected BufferedImage flyingObject;
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int speed;

    public FlyingObject() {
    }

    public FlyingObject(BufferedImage flyingObject, int x, int y, int width, int height, int speed) {
        this.flyingObject = flyingObject;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
    }

    public BufferedImage getFlyingObject() {
        return flyingObject;
    }

    public void setFlyingObject(BufferedImage flyingObject) {
        this.flyingObject = flyingObject;
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
        g.drawImage(this.getFlyingObject(), this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }
}
