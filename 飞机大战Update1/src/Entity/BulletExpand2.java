package Entity;

import com.hzheima.util.ImageUtil;

public class BulletExpand2 extends Bullet {
    public BulletExpand2(int px, int py) {
        super(px, py);
        x = px + width;
        y = py + 10;
        img = ImageUtil.getImg("fire2.png");
    }

    public void move(){
        this.x += speed;
    }
}
