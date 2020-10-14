package Entity;

import AppConfig.AppConfig;
import Util.MusicUtil;
import com.hzheima.util.ImageUtil;

import java.util.ArrayList;


public class Plane extends FlyingObject {
    public Plane() {
        //设置背景图片
        img = ImageUtil.getImg("hero.png");
        //设置坐标
        x = 500;
        y = 620;
        //设置宽高
        width = img.getWidth() / 2;
        height = img.getHeight() / 2;
        //设置速度
        speed = 10;
    }

    public Plane(String name, int x) {
        img = ImageUtil.getImg(name);
        super.x = x;
        super.y = 620;
        //设置宽高
        width = img.getWidth() / 2;
        height = img.getHeight() / 2;
        //设置速度
        speed = 10;
    }


    /**
     * 向左移动
     */
    public void moveToLeft() {
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    /**
     * 向右移动
     */
    public void moveToRight() {
        x += speed;
        if (x > AppConfig.APP_WIDTH - 10 - width) {
            x = AppConfig.APP_WIDTH - 10 - width;
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
        if (y >= AppConfig.APP_HEIGHT + 2 - this.getHeight()) {
            y = AppConfig.APP_HEIGHT + 2 - this.getHeight();
        }
    }

    //存储子弹
    private ArrayList<Bullet> bullets = new ArrayList<>();

    public ArrayList<Bullet> getBullets() {
        return bullets;
    }

    private ArrayList<BulletDouble> bulletDoubleArrayList = new ArrayList<>();

    public ArrayList<BulletDouble> getBulletDoubleArrayList() {
        return bulletDoubleArrayList;
    }

    private ArrayList<BulletFast> bulletFastArrayList = new ArrayList<>();

    public ArrayList<BulletFast> getBulletFastArrayList() {
        return bulletFastArrayList;
    }

    private ArrayList<BulletExpand1> bulletExpand1ArrayList = new ArrayList<>();

    public ArrayList<BulletExpand1> getBulletExpand1ArrayList() {
        return bulletExpand1ArrayList;
    }

    private ArrayList<BulletExpand2> bulletExpand2ArrayList = new ArrayList<>();

    public ArrayList<BulletExpand2> getBulletExpand2ArrayList() {
        return bulletExpand2ArrayList;
    }

    int count;

    /**
     * 发射子弹  每隔300ms
     */
    public void shoot() {
        //每隔10次创建一次子弹
//        MusicUtil.playMp3("shoot.mp3");
        count++;
        if (count % 10 == 0) {
            Bullet bullet = new Bullet(this.x, this.y);
            bullets.add(bullet);
            count = 0;
        }

        for (int i = bullets.size() - 1; i >= 0; i--) {
            Bullet bullet = bullets.get(i);
            //让子弹移动
            bullet.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bullet.getY() <= -bullet.getHeight()) {
                //说明移出屏幕了
                bullets.remove(i);
            }
        }
    }

    public void shoot1() {
        //每隔10次创建一次子弹
        MusicUtil.playMp3("shoot.mp3");
        count++;
        if (count % 10 == 0) {
            BulletDouble bulletDouble = new BulletDouble(this.x, this.y);
            bulletDoubleArrayList.add(bulletDouble);
            count = 0;
        }

        for (int i = bulletDoubleArrayList.size() - 1; i >= 0; i--) {
            BulletDouble bulletDouble = bulletDoubleArrayList.get(i);
            //让子弹移动
            bulletDouble.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bulletDouble.getY() <= -bulletDouble.getHeight()) {
                //说明移出屏幕了
                bulletDoubleArrayList.remove(i);
            }
        }
    }

    public void shoot2() {
        //每隔10次创建一次子弹
        MusicUtil.playMp3("shoot.mp3");
        count++;

        BulletFast fasBullet = new BulletFast(this.x, this.y);
        bulletFastArrayList.add(fasBullet);
        count = 0;

        for (int i = bulletFastArrayList.size() - 1; i >= 0; i--) {
            BulletFast bulletFast = bulletFastArrayList.get(i);
            //让子弹移动
            bulletFast.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bulletFast.getY() <= -bulletFast.getHeight()) {
                //说明移出屏幕了
                bulletFastArrayList.remove(i);
            }
        }
    }

    public void shoot3() {
        //每隔10次创建一次子弹

        count++;
        if (count % 10 == 0) {
            BulletExpand1 bulletExpand1 = new BulletExpand1(this.x, this.y);
            bulletExpand1ArrayList.add(bulletExpand1);
            count = 0;
        }

        for (int i = bulletExpand1ArrayList.size() - 1; i >= 0; i--) {
            BulletExpand1 bulletExpand1 = bulletExpand1ArrayList.get(i);
            //让子弹移动
            bulletExpand1.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bulletExpand1.getX() <= -bulletExpand1.getHeight()) {
                //说明移出屏幕了
                bulletExpand1ArrayList.remove(i);
            }
        }
    }

    public void shoot4() {
        //每隔10次创建一次子弹

        count++;
        if (count % 10 == 0) {
            BulletExpand2 bulletExpand2 = new BulletExpand2(this.x, this.y);
            bulletExpand2ArrayList.add(bulletExpand2);
            count = 0;
        }

        for (int i = bulletExpand2ArrayList.size() - 1; i >= 0; i--) {
            BulletExpand2 bulletExpand2 = bulletExpand2ArrayList.get(i);
            //让子弹移动
            bulletExpand2.move();

            //判断是否移出屏幕，如果移出了就从集合中删除
            if (bulletExpand2.getX() <= -bulletExpand2.getHeight()) {
                //说明移出屏幕了
                bulletExpand2ArrayList.remove(i);
            }
        }
    }

    /**
     * 判断球和飞机是否碰撞
     *
     * @param ball
     * @return
     */
    public boolean isCrash(Ball ball) {
        boolean r = collide(ball);

        if (r) {
            //撞上了。就切换成炸毁的图片
            changeImg();
        }
        return r;
    }

    //切换成炸毁的图片
    private void changeImg() {
        img = ImageUtil.getImg("boom.png");
    }

    public boolean eatGold(Gold gold) {
        return collide(gold);
    }

    public boolean eatGem(Gem gem) {
        return collide(gem);
    }
}
