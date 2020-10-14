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

public final class FighterFightPanel extends GameJPanel {


    // 空参构造
    public FighterFightPanel() {
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
    private int num = 1;
    private int rect = 1;
    private boolean gameOver;
    private boolean ifMoveToLeft = false;
    private boolean ifMoveToRight = false;
    private boolean ifMoveUp = false;
    private boolean ifMoveDown = false;


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

        num++;
        if (num % 50 == 0 && rect < 30 && !gameOver) {
            rect++;
            num = 0;
        }
        for (int i = 0; i < rect; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
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

        if (gameOver) {
            //设置画笔为红色
            g.setColor(Color.red);
            Graphics2D g2d = (Graphics2D) g;
            //设置透明度,绘制红色矩形
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.42f);
            g2d.setComposite(alphaComposite);
            g2d.fillRect(0, 200, GameConfig.GAME_WIDTH, 300);


            //透明度设置回来，然后设置成白色
            AlphaComposite alphaComposite1 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
            g2d.setComposite(alphaComposite1);

            g.setColor(Color.white);
            g.setFont(new Font("楷体", Font.BOLD, 30));
            g.drawString("游戏结束", 180, 240);

            g.setColor(Color.yellow);
            g.drawString("本次得分：0", 150, 300);
            g.drawString("获得金币：", 100, 370);
            g.drawImage(moneyImage, 250, 340, 40, 40, null);
            g.drawString("0.00k", 300, 370);

            g.setColor(Color.white);
            g.drawString("{按F1重新开始游戏}", 80, 480);

        }
    }

    // 监听按键移动飞机
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 'A' && !gameOver) {
            ifMoveToLeft = true;

        } else if (e.getKeyCode() == 'D' && !gameOver) {
            ifMoveToRight = true;

        } else if (e.getKeyCode() == 'S' && !gameOver) {
            ifMoveDown = true;

        } else if (e.getKeyCode() == 'W' && !gameOver) {
            ifMoveUp = true;

        } else if (e.getKeyCode() == 112) {
            //游戏重新开始
            gameOver = false;
            //小球清空
            ballArrayList.clear();
            //飞机重新创建
            fighter = new Fighter();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 'A' && !gameOver) {
            ifMoveToLeft = false;
        } else if (e.getKeyCode() == 'D' && !gameOver) {
            ifMoveToRight = false;
        } else if (e.getKeyCode() == 'S' && !gameOver) {
            ifMoveDown = false;
        } else if (e.getKeyCode() == 'W' && !gameOver) {
            ifMoveUp = false;
        }
    }

    @Override
    public void run() {
//        new Bullet(fighter.getX(), fighter.getY());
        if (!gameOver) {
            // 飞机流畅移动
            if (ifMoveToLeft) {
                fighter.moveToLeft();
            }
            if (ifMoveToRight) {
                fighter.moveToRight();
            }
            if (ifMoveDown) {
                fighter.moveDown();
            }
            if (ifMoveUp) {
                fighter.moveUp();
            }
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
