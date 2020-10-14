package Entity;

import com.hzheima.util.ImageUtil;

public class BulletExpand1 extends Bullet{
    public BulletExpand1(int px, int py) {
        super(px, py);
        x = px - width;
        y = py + 10;
        img = ImageUtil.getImg("fire1.png");
    }

    public void move(){
        this.x -= speed;
    }
}
