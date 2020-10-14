package Entity;

import com.hzheima.util.ImageUtil;

public class BossBullet extends Bullet {
    public BossBullet(int px, int py) {
        super(px, py);
        img = ImageUtil.getImg("blue.png");

        width = img.getWidth();
        height = img.getHeight();

        x = px + 115;
        y = py + 80;

        speed = 20;
    }

    @Override
    public void move() {
        this.y += speed;
    }

    public boolean shootBy(Bullet bullet) {
        boolean r = collide(bullet);

        return r;
    }
}
