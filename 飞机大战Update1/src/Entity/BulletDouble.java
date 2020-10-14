package Entity;

import com.hzheima.util.ImageUtil;

public class BulletDouble extends Bullet{
    public BulletDouble(int px, int py) {
        super(px, py);
        img = ImageUtil.getImg("bulletdouble.png");
        width *= 2;
        height *= 2;
    }
}
