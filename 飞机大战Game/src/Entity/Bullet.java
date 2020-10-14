package Entity;

import com.hzheima.util.ImageUtil;

import java.awt.*;

public final class Bullet extends FlyingObject {
    public Bullet(int fighterX, int fighterY) {
        flyingObject = ImageUtil.getImg("fire.png");
        width = flyingObject.getWidth() / 2;
        height = flyingObject.getHeight() / 2;
        x = fighterX + 35;
        y = fighterY - 50;
        speed = 10;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.flyingObject, this.getX(), this.getY(), this.getWidth(), this.getHeight(), null);
    }

    public void move() {
        this.y -= speed;
    }

}
