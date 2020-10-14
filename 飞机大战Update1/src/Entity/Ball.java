package Entity;

import AppConfig.AppConfig;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Ball extends FlyingObject {
    //水平方向速度  如果<0说明向左移动  >0说明向右移动
    protected int xSpeed;
    //垂直方向速度   如果<0说明向上移动  >0说明向下移动
    protected int ySpeed;
    //代表开始出现的位置  如果是0代表左边，如果是1代表右边
    protected int startLoc;
    protected Random random = new Random();

    //血量
    private int blood;

    private int initBlood;
    //代表是否能够向下移动
    protected boolean startDown;

    public int getInitBlood() {
        return initBlood;
    }

    public Ball() {
    }

    /**
     * 分裂小球的时候使用的构造方法
     *
     * @param x
     * @param y
     * @param ySpeed
     * @param initBlood
     */
    public Ball(int x, int y, int ySpeed, int initBlood) {
        //随机背景图片
        int num = random.nextInt(15);   // [0,14]
        String imgFileName = "c" + num + ".png";
        //设置图片
        img = ImageUtil.getImg(imgFileName);
        width = img.getWidth() / 2;
        height = img.getHeight() / 2;
        //设置坐标
        this.x = x;
        this.y = y;
        //设置速度
        this.ySpeed = ySpeed;
        this.xSpeed = random.nextInt(11) - 5;//[-5,5]

        //设置血量
        this.initBlood = initBlood;
        this.blood = initBlood;

        startDown = true;
    }

    public Ball(int xSpeed, int ySpeed) {
        //随机背景图片
        int num = random.nextInt(15);   // [0,14]
        String imgFileName = "c" + num + ".png";
        //设置图片
        img = ImageUtil.getImg(imgFileName);
        width = img.getWidth();
        height = img.getHeight();
        //随机位置
        startLoc = random.nextInt(2);//如果是0 代表左边，如果是1代表右边
        if (startLoc == AppConfig.LEFT) {
            //设置坐标
            x = -width;
            this.xSpeed = 2 + xSpeed;
        } else if (startLoc == AppConfig.RIGHT) {
            x = AppConfig.APP_WIDTH;
            this.xSpeed = -2 - xSpeed;
        }
        y = 100;
        this.ySpeed = 3 + ySpeed;

        blood = random.nextInt(9) + 1;
        initBlood = blood;
    }

    /**
     * 小球的移动
     */
    public void move() {
        x += xSpeed;
        //判断是否能够向下移动
        if (startLoc == AppConfig.LEFT) {
            //初始位置是左边
            if (x >= 200) {
                //可以向下移动
                startDown = true;
            }
        } else if (startLoc == AppConfig.RIGHT) {
            //初始位置是右边
            if (x <= 800) {
                //可以向下移动
                startDown = true;
            }
        }

        if (startDown) {
            y += ySpeed;
        }


        //判断是否碰撞到墙壁
        if (xSpeed < 0 && x <= 0) {
            //撞左墙
            xSpeed = -xSpeed;
        } else if (xSpeed > 0 && x >= AppConfig.APP_WIDTH - width) {
            //撞右墙
            xSpeed = -xSpeed;
        } else if (ySpeed < 0 && y <= 0) {
            //撞上墙
            ySpeed = -ySpeed;
        } else if (ySpeed > 0 && y >= AppConfig.APP_HEIGHT - 40 - height) {
            //撞下墙
            ySpeed = -ySpeed;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        //绘制血量
        g.setColor(Color.white);
        g.setFont(new Font("楷体", Font.BOLD, 30));
        //判断血量是一位还是两位
//        int dx = blood / 10 > 0 ? 15 : 10;
        int dx = 10;
        int dy = 10;

        g.drawString(String.valueOf(blood), x + width / 2 - dx, y + height / 2 + dy);
    }

    public int getBlood() {
        return blood;
    }

    public boolean shootBy(Bullet bullet) {
        boolean r = collide(bullet);

        //如果被击中了，球的血量减少
        if (r) {
            blood--;
            //被打中了球就可以下落
            startDown = true;
        }
        return r;
    }

    /**
     * 球的分裂
     *
     * @return 返回分裂出来的两个球
     */
    public ArrayList<Ball> split() {
        ArrayList<Ball> balls = new ArrayList<>();
        if (this.blood > 0) {
            Ball ball1 = new Ball(this.x, this.y, this.ySpeed, this.blood);
            Ball ball2 = new Ball(this.x, this.y, this.ySpeed, this.blood);
            balls.add(ball1);
            balls.add(ball2);
        }
        return balls;
    }
}
