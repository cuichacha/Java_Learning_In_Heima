package Entity;

import com.hzheima.util.ImageUtil;

public class Bullet extends FlyingObject {
    public Bullet(int px,int py) {
        img = ImageUtil.getImg("fire.png");

        width = img.getWidth();
        height = img.getHeight();

        x = px + 25;
        y = py - 65;

        speed = 20;
    }

    //子弹移动
    public void move(){
        this.y -= speed;
    }
}
