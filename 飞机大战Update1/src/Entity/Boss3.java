package Entity;

import com.hzheima.util.ImageUtil;

public class Boss3 extends Boss2 {
    public Boss3() {
        img = ImageUtil.getImg("FinalBoss.png");
        width = img.getWidth();
        height = img.getHeight();
    }

    @Override
    public void shoot() {
        count++;
        if (count % 10 == 0) {
            BossBullet bossBullet = new BossBullet(this.x - 60, this.y);
            bossBullets.add(bossBullet);
            count = 0;
        }

        for (int i = bossBullets.size() - 1; i >= 0; i--) {
            BossBullet bossBullet = bossBullets.get(i);
            //让子弹移动
            bossBullet.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bossBullet.getY() <= -bossBullet.getHeight()) {
                //说明移出屏幕了
                bossBullets.remove(i);
            }
        }
    }
}
