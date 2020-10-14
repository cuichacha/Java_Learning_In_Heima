package UI;

import Config.GameConfig;
import Entity.Ball;
import Entity.Bullet;
import Entity.Fighter;
import com.hzheima.game.GameJPanel;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public final class FighterFightAchievement extends GameJPanel {



    // 空参构造
    public FighterFightAchievement() {
    }

    // 创建背景图片对象
    private final BufferedImage backgroundImage = ImageUtil.getImg("BG.png");
    // 创建金币图片对象
    private final BufferedImage moneyImage = ImageUtil.getImg("money.png");
    // 创建左括号图片对象
    private final BufferedImage leftBracket = ImageUtil.getImg("st.png");
    // 创建右括号图片对象
    private final BufferedImage rightBracket = ImageUtil.getImg("ed.png");
    // 创建飞机对象
    private Fighter fighter = new Fighter();
    ArrayList<Bullet> bulletArrayList = fighter.getBulletArray();
    private Ball ball = new Ball();
    //    ArrayList<Ball> ballArrayList = ball.getBallArrayList();
    ArrayList<Ball> ballArrayList = new ArrayList<>();
    // 创建子弹对象
//    private Bullet bullet;
    // 创建球对象
//    private Ball ball = new Ball();
    private int count;
    private boolean gameOver;

    // 设置画板背景颜色方法
    public void drawPanel() {
        // 将画板背景颜色设置为黑色
        this.setBackground(Color.black);
    }

    // 重写父类方法，进行绘制
    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        Bullet bullet = new Bullet(fighter.getX(), fighter.getY());

        // 将背景图片画入面板
        g.drawImage(backgroundImage, 0, 0, GameConfig.GAME_WIDTH, GameConfig.GAME_HEIGHT, null);
        // 设置字体信息
        g.setFont(new Font("SongTi", Font.BOLD, 25));
        // 设置字体颜色
        g.setColor(Color.white);
        // 画出文字
        g.drawString("分数", 30, 30);
        // 画出文字
        g.drawString("历史最高", 300, 60);
        // 画金币图片
        g.drawImage(moneyImage, 300, 10, 30, 30, null);
        // 画金币数量
        g.drawString("0000", 340, 32);
        // 画关卡名
        g.setFont(new Font("SongTi", Font.BOLD, 25));
        // 画关卡名
        g.drawString("关卡1", 25, 60);
        // 画左括号
        g.drawImage(leftBracket, 20, 80, 5, 25, null);
        // 设置颜色
        g.setColor(Color.gray);
        // 画灰色方块
        for (int i = 0; i < 30; i++) {
            g.fillRect(30 + i * (10 + 5), 80, 10, 25);
        }
        // 设置颜色
        g.setColor(Color.cyan);
        // 画蓝色方块
        for (int i = 0; i < 4; i++) {
            g.fillRect(30 + i * (10 + 5), 80, 10, 25);
        }
        // 画右括号
        g.drawImage(rightBracket, GameConfig.GAME_WIDTH - 30, 80, 5, 25, null);
        // 画飞机
        fighter.draw(g);
        // 画子弹
//        bullet.draw(g);
//        Bullet[] bulletArray = fighter.getBulletArray();
//        for (int i = 0; i < bulletArray.length; i++) {
//            Bullet bullet = bulletArray[i];
//            bullet.draw(g);
//        }
        // 画子弹

        for (int i = 0; i < bulletArrayList.size(); i++) {
            Bullet bullet = bulletArrayList.get(i);
            bullet.draw(g);
        }

        // 画小球

        for (int i = 0; i < ballArrayList.size(); i++) {
            Ball ball = ballArrayList.get(i);
            ball.draw(g);
        }

    }

    // 监听按键移动飞机
    @Override
    public void keyPressed(KeyEvent e) {
        fighter.move(e);
        repaint();
    }

    @Override
    public void run() {
//        new Bullet(fighter.getX(), fighter.getY());
        if (!gameOver) {
            // 发射子弹
            fighter.shoot();
            // 创建小球
//        ball.createBall();
            createBall();
            // 移动小球
//        ball.moveBall();
            moveBall();
            // 判断小球是否被击中，并进行操作
//        ball.hit();
            hit();
            // 判断飞机是否被击中
            isCrash();
        }

        repaint();
    }

    public void createBall() {
        count++;
        if (count % 20 == 0) {
            if (ballArrayList.size() < GameConfig.BALL_MAXIMUM) {
                ballArrayList.add(new Ball());
            }
            count = 0;
        }
    }

    public void moveBall() {
        for (int i = 0; i < ballArrayList.size(); i++) {
            ballArrayList.get(i).move();
//            if (i > 0) {
//                bounce(ballArrayList.get(i - 1), ballArrayList.get(i));
//            }
        }
    }

    public void hit() {
        for (int i = 0; i < ballArrayList.size(); i++) {
            Ball ball = ballArrayList.get(i);
            for (int j = 0; j < bulletArrayList.size(); j++) {
                Bullet bullet = bulletArrayList.get(j);
                if (ball.ifHit(bullet)) {
                    // 发生碰撞
                    bulletArrayList.remove(j);
                    if (ball.getBlood() == 0) {
                        ballArrayList.remove(i);
                    }
                    if (ball.getBlood() <= ball.getInitialBlood() / 2) {
                        ArrayList<Ball> newBallArrayList = ball.split();
                        ballArrayList.addAll(newBallArrayList);
                        ballArrayList.remove(ball);
                    }
                }
            }
        }
    }

    public void isCrash() {
        for (int i = 0; i < ballArrayList.size(); i++) {
            Ball ball = ballArrayList.get(i);
            if (fighter.ifCrash(ball)) {
                ballArrayList.remove(ball);
                gameOver = true;
            }
        }
    }
}
