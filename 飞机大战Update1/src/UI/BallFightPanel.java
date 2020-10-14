package UI;

import AppConfig.AppConfig;
import Entity.*;
import com.hzheima.game.GameJPanel;
import com.hzheima.util.ImageUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BallFightPanel extends GameJPanel {
    // 背景图片
    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage img5;
    //金币图标
    BufferedImage money;
    BufferedImage boss1Die;
    BufferedImage st;
    BufferedImage ed;
    Plane plane;
    Boss1 boss1;
    Boss2 boss2;
    Boss3 boss3;

    ArrayList<Ball> balls = new ArrayList<>();
    ArrayList<Gold> golds = new ArrayList<>();
    ArrayList<Gem> gems = new ArrayList<>();
    ArrayList<Boss1> boss1ArrayList = new ArrayList<>();
    ArrayList<Integer> cheat = new ArrayList<>();
    ArrayList<Integer> userCheat = new ArrayList<>();

    int count;
    private int num = 1;
    private int rect = 1;
    boolean gameover;
    private boolean ifMoveToLeft;
    private boolean ifMoveToRight;
    private boolean ifMoveUp;
    private boolean ifMoveDown;
    private int ifPause;
    private int ifCheat;
    private int score;
    private int level = 1;
    private int life = 300;
    private int goldCount;
    private int highestScore;
    private int bgY = -1632;
    private boolean eatGem;
    private int gemNumber;
    private int boss1Life = 500;
    private int boss2Life = 500;
    private int boss3Life = 1015;


    public BallFightPanel() {
        //设置背景色为粉色
        setBackground(Color.PINK);


        img1 = ImageUtil.getImg("BG1.png");
        img2 = ImageUtil.getImg("BG2.png");
        img3 = ImageUtil.getImg("BG3.png");
        img4 = ImageUtil.getImg("BG4.png");
        img5 = ImageUtil.getImg("BG5.png");
        boss1Die = ImageUtil.getImg("boom.png");
        //加载金币图片
        money = ImageUtil.getImg("money.png");

        st = ImageUtil.getImg("st.png");

        ed = ImageUtil.getImg("ed.png");

        plane = new Plane();
        boss1 = new Boss1();
        boss2 = new Boss2();
        boss3 = new Boss3();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!gameover && (ifPause % 2 == 0)) {
            bgY++;
        }

        if (level == 1) {
            g.drawImage(img1, 0, bgY, 1080, 2400, null);
        } else if (level == 2) {
            g.drawImage(img2, 0, bgY, 1080, 2400, null);
        } else if (level == 3) {
            g.drawImage(img3, 0, bgY, 1080, 2400, null);
        } else if (level == 4) {
            g.drawImage(img4, 0, bgY, 1080, 2400, null);
        } else if (level == 5) {
            g.drawImage(img5, 0, bgY, 1080, 2400, null);
        } else {
            g.drawImage(img1, 0, bgY, 1080, 2400, null);
            gameover = true;
        }


        //画分数
        g.setFont(new Font("楷体", Font.PLAIN, 25));
        //设置颜色
        g.setColor(Color.white);
        g.drawString("分数：" + score, 25, 30);

        g.drawString("按ESC键暂停游戏", 200, 30);
        g.drawString("生命：" + life, 200, 60);

        //画历史最高
        g.drawString("历史最高：" + highestScore, 900, 60);

        //画金币图标
        g.drawImage(money, 900, 10, 30, 30, null);
        g.drawString("" + goldCount, 940, 32);

        //画关卡名
        g.setFont(new Font("楷体", Font.PLAIN, 25));
        g.drawString("关卡" + level, 25, 60);


        //绘制关卡进度
        //绘制左括号
        g.drawImage(st, 20, 80, 5, 25, null);

        //绘制总进度
        //设置颜色
        g.setColor(Color.gray);
        for (int i = 0; i < 68; i++) {
            g.fillRect(30 + i * 15, 80, 10, 25);
        }

        //绘制当前进度
        g.setColor(Color.cyan);
        if (ifPause % 2 == 0) {
            num++;
            if (num % 20 == 0 && rect < 68 && !gameover) {
                rect++;
                num = 0;
            }
        }
        for (int i = 0; i < rect; i++) {
            g.fillRect(30 + i * 15, 80, 10, 25);
        }

        if (life <= 0) {
            life = 0;
            gameover = true;
        }


//        if (level < 5) {
//            for (int i = 0; i < rect; i++) {
//                g.fillRect(30 + i * 15, 80, 10, 25);
//            }
//        } else if (level == 5) {
//            g.setColor(Color.gray);
//            g.fillRect(30, 80, 1015, 25);
//            g.setColor(Color.red);
//            for (int i = 0; i < boss3Life; i++) {
//                g.fillRect(30 + i * 15, 80, 10, 25);
//            }
//        }

        //绘制右括号
        g.drawImage(ed, AppConfig.APP_WIDTH - 30, 80, 5, 25, null);

        //绘制飞机
//        g.drawImage(plane.getImg(),plane.getX(),plane.getY(),plane.getWidth(),plane.getHeight(),null);
        plane.draw(g);

        if (gemNumber == 1) {
            ArrayList<BulletDouble> bulletDoubleArrayList = plane.getBulletDoubleArrayList();
            for (int i = 0; i < bulletDoubleArrayList.size(); i++) {
                BulletDouble bulletDouble = bulletDoubleArrayList.get(i);
                bulletDouble.draw(g);
            }
        } else if (gemNumber == 2) {
            ArrayList<BulletFast> bulletFastArrayList = plane.getBulletFastArrayList();
            for (int i = 0; i < bulletFastArrayList.size(); i++) {
                BulletFast bulletFast = bulletFastArrayList.get(i);
                bulletFast.draw(g);
            }
        } else if (gemNumber == 3) {
            ArrayList<BulletExpand1> bulletExpand1ArrayList = plane.getBulletExpand1ArrayList();
            for (int i = 0; i < bulletExpand1ArrayList.size(); i++) {
                BulletExpand1 bulletExpand1 = bulletExpand1ArrayList.get(i);
                bulletExpand1.draw(g);
            }
            ArrayList<BulletExpand2> bulletExpand2ArrayList = plane.getBulletExpand2ArrayList();
            for (int i = 0; i < bulletExpand2ArrayList.size(); i++) {
                BulletExpand2 bulletExpand2 = bulletExpand2ArrayList.get(i);
                bulletExpand2.draw(g);
            }
            //绘制普通子弹
            ArrayList<Bullet> bullets = plane.getBullets();
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.draw(g);
            }
        } else {
            //绘制普通子弹
            ArrayList<Bullet> bullets = plane.getBullets();
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                bullet.draw(g);
            }
        }

        if (level <= 4) {
            //遍历绘制小球
            for (int i = 0; i < balls.size(); i++) {
                Ball ball = balls.get(i);
                ball.draw(g);
            }
        }

        //遍历绘制金币
        for (int i = 0; i < golds.size(); i++) {
            Gold gold = golds.get(i);
            gold.draw(g);
        }

        //绘制宝石
        for (int i = 0; i < gems.size(); i++) {
            Gem gem = gems.get(i);
            gem.draw(g);
        }

        // 绘制Boss1
        if (level == 3 && rect >= 10 && rect < 68 && boss1Life > 0) {
            boss1.draw(g);
        }

        //绘制Boss2
        if (level == 4 && rect > 10 && rect < 68 && boss2Life > 0) {
            boss2.draw(g);
        }

        ArrayList<BossBullet> boss2Bullets = boss2.getBossBullets();
        for (int i = 0; i < boss2Bullets.size(); i++) {
            BossBullet bossBullet = boss2Bullets.get(i);
            bossBullet.draw(g);
        }

        //绘制Boss3
        if (level == 5 && rect < 68 && boss2Life > 0) {
            boss3.draw(g);
        }

        ArrayList<BossBullet> boss3Bullets = boss3.getBossBullets();
        for (int i = 0; i < boss3Bullets.size(); i++) {
            BossBullet bossBullet = boss3Bullets.get(i);
            bossBullet.draw(g);
        }

        if (rect == 68) {
            level++;
            bgY = -1632;
            rect = 1;
            eatGem = false;
            gems.clear();
            boss2Bullets.clear();
            boss3Bullets.clear();
        }

        //如果游戏结束了就绘制提示
        if (gameover) {
            //绘制半透明红色矩形
            g.setColor(Color.red);
            Graphics2D g2d = (Graphics2D) g;
            //设置透明度
            AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.42f);
            g2d.setComposite(alphaComposite);
            g2d.fillRect(0, 200, AppConfig.APP_WIDTH, 400);


            //设置回不透明 画笔变白色
            AlphaComposite alphaComposite2 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);
            g2d.setComposite(alphaComposite2);
            g.setColor(Color.white);

            g.setFont(new Font("楷体", Font.BOLD, 30));
            //写游戏结束
            g.drawString("游戏结束", 480, 240);

            //画本次得分，获得金币
            g.setColor(Color.yellow);
            g.drawString("本次得分：" + score, 450, 300);
            g.drawString("获得金币：", 400, 370);
            g.drawImage(money, 550, 340, 40, 40, null);
            g.drawString("" + goldCount, 600, 370);

            //画重新开始提示
            g.setColor(Color.white);
            g.drawString("{按回车键重新开始游戏}", 400, 480);
            g.drawString("{按空格键回到主界面}", 400, 580);
        }
    }

    /**
     * 该方法在键盘某个键被按下的时候就会被调用到
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 'A' && !gameover) {
            ifMoveToLeft = true;

        } else if (e.getKeyCode() == 'D' && !gameover) {
            ifMoveToRight = true;
        } else if (e.getKeyCode() == 'S' && !gameover) {
            ifMoveDown = true;
        } else if (e.getKeyCode() == 'W' && !gameover) {
            ifMoveUp = true;
        } else if (e.getKeyCode() == 10 && gameover) {
            //游戏重新开始
            gameover = false;
            //小球清空
            balls.clear();
            //飞机重新创建
            plane = new Plane();
            rect = 1;
            ifMoveToLeft = false;
            ifMoveToRight = false;
            ifMoveUp = false;
            ifMoveDown = false;
            ifPause = 0;
            highestScore = Math.max(highestScore, score);
            score = 0;
            life = 300;
            level = 1;
            bgY = -1632;
            golds.clear();
            gems.clear();
            eatGem = false;
            gemNumber = 0;
            userCheat.clear();
            cheat.clear();

        } else if (e.getKeyCode() == 32 && gameover) {
            MainInterface mainInterface = new MainInterface();
            mainInterface.mainInterface();
        } else if (e.getKeyCode() == 27 && !gameover) {
            ifPause++;
        } else if (e.getKeyCode() == 123 && !gameover) {
            ifCheat++;
//        } else if (e.getKeyCode() == 37 && !gameover) {
//            userCheat.add(37);
//        } else if (e.getKeyCode() == 38 && !gameover) {
//            userCheat.add(38);
//        } else if (e.getKeyCode() == 39 && !gameover) {
//            userCheat.add(39);
//        } else if (e.getKeyCode() == 40 && !gameover) {
//            userCheat.add(40);
//        } else if (e.getKeyCode() == 66 && !gameover) {
//            userCheat.add(66);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 'A' && !gameover) {
            ifMoveToLeft = false;
        } else if (e.getKeyCode() == 'D' && !gameover) {
            ifMoveToRight = false;
        } else if (e.getKeyCode() == 'S' && !gameover) {
            ifMoveDown = false;
        } else if (e.getKeyCode() == 'W' && !gameover) {
            ifMoveUp = false;
        }
    }

    @Override
    public void run() {
        if (!gameover && (ifPause % 2 == 0)) {
            // 飞机流畅移动
            if (ifMoveToLeft) {
                plane.moveToLeft();
            }
            if (ifMoveToRight) {
                plane.moveToRight();
            }
            if (ifMoveDown) {
                plane.moveDown();
            }
            if (ifMoveUp) {
                plane.moveUp();
            }

            if (gemNumber == 1) {
                plane.shoot1();
            } else if (gemNumber == 2) {
                plane.shoot2();
            } else if (gemNumber == 3) {
                plane.shoot();
                plane.shoot3();
                plane.shoot4();
            } else {
                //发射子弹  每隔300ms
                plane.shoot();
            }

            //创建小球
            createBall();

            //移动小球
            moveBall();

            //创建金币
            createGold();

            // 移动金币
            moveGold();

            //创建宝石
            if (level >= 3 && !eatGem) {
                createGem();
            }

            //移动宝石
            moveGem();

            if (level == 3 && boss1Life > 0) {
//                createBoss1();
                isShootBoss();
                isCrashBoss1();
                boss1.move();
            }

            if (level == 4 && boss2Life > 0) {
                isShootBoss();
                isCrashBoss2();
                boss2.move();
                boss2.shoot();
                isShootBullet();
            }

            if (level == 5 && boss3Life > 0) {
                isShootBoss();
                isCrashBoss3();
                boss3.move();
                boss3.shoot();
                isShootBullet();
            }

            if (gemNumber == 1) {
                isShootBall1();
            } else if (gemNumber == 2) {
                isShootBall2();
            } else if (gemNumber == 3) {
                isShootBall();
                isShootBall3();
                isShootBall4();
            } else {
                //判断球是否被击中
                isShootBall();
            }

//            cheating();
//            if (isCheat()) {
//                gameover = true;
//            }
            if (ifCheat % 2 == 0) {
                //判断小球和飞机是否碰撞
                isCrash();
//                isCrashBoss1();
//                isCrashBoss2();
//                isCrashBoss3();
            }
        }
        repaint();
    }

    //创建小球
    public void createBall() {
        count++;
        if (count % 10 == 0) {
            if (balls.size() < level + 1) {
                Ball ball = new Ball(level * 2, level * 2);
                balls.add(ball);
            }
            count = 0;
        }
    }

    //创建金币
    public void createGold() {
        if (golds.size() < 1) {
            Gold gold = new Gold();
            golds.add(gold);
        }
    }

    //创建宝石
    public void createGem() {
        if (gems.size() < 2) {
            Gem gem = new Gem();
            gems.add(gem);
        }
    }

    //创建Boss
    public void createBoss1() {
        if (boss1ArrayList.size() < 1) {
            Boss1 boss1 = new Boss1();
            boss1ArrayList.add(boss1);
        }
    }

    private void moveBall() {
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            ball.move();
        }
    }

    private void moveGold() {
        for (int i = 0; i < golds.size(); i++) {
            Gold gold = golds.get(i);
            gold.move();
        }
    }

    private void moveGem() {
        for (int i = 0; i < gems.size(); i++) {
            Gem gem = gems.get(i);
            gem.move();
        }
    }

    private void moveBoss1() {
        for (int i = 0; i < boss1ArrayList.size(); i++) {
            Boss1 boss1 = boss1ArrayList.get(i);
            boss1.move();
        }
    }

    /**
     * 判断球是否被击中 如果被击中了做相应的处理
     */
    public void isShootBall() {
        //遍历所有的球
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball = balls.get(i);
            ArrayList<Bullet> bullets = plane.getBullets();
            for (int j = bullets.size() - 1; j >= 0; j--) {
                Bullet bullet = bullets.get(j);
                //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
                if (ball.shootBy(bullet)) {
                    //球被子弹打中
                    //子弹消失
                    bullets.remove(j);
                    score++;
                    //如果当前球的血量为0，球要消失
                    if (ball.getBlood() <= 0) {
                        balls.remove(ball);
                    }

                    //如果血量降低为原来的一半，就让球分裂
                    if (ball.getBlood() <= ball.getInitBlood() / 2) {
                        //球应该分裂
                        ArrayList<Ball> newBallList = ball.split();
                        //把分裂出来的球添加到balls
                        balls.addAll(newBallList);
                        //把本分裂的球移出集合
                        balls.remove(ball);
                    }
                }
            }
        }
    }

    public void isShootBall1() {
        //遍历所有的球
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball = balls.get(i);
            ArrayList<BulletDouble> bulletDoubleArrayList = plane.getBulletDoubleArrayList();
            for (int j = bulletDoubleArrayList.size() - 1; j >= 0; j--) {
                BulletDouble bulletDouble = bulletDoubleArrayList.get(j);
                //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
                if (ball.shootBy(bulletDouble)) {
                    //球被子弹打中
                    //子弹消失
                    bulletDoubleArrayList.remove(j);
                    score++;
                    //如果当前球的血量为0，球要消失
                    if (ball.getBlood() <= 0) {
                        balls.remove(ball);
                    }

                    //如果血量降低为原来的一半，就让球分裂
                    if (ball.getBlood() <= ball.getInitBlood() / 2) {
                        //球应该分裂
                        ArrayList<Ball> newBallList = ball.split();
                        //把分裂出来的球添加到balls
                        balls.addAll(newBallList);
                        //把本分裂的球移出集合
                        balls.remove(ball);
                    }
                }
            }
        }
    }

    public void isShootBall2() {
        //遍历所有的球
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball = balls.get(i);
            ArrayList<BulletFast> bulletFastArrayList = plane.getBulletFastArrayList();
            for (int j = bulletFastArrayList.size() - 1; j >= 0; j--) {
                BulletFast bulletFast = bulletFastArrayList.get(j);
                //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
                if (ball.shootBy(bulletFast)) {
                    //球被子弹打中
                    //子弹消失
                    bulletFastArrayList.remove(j);
                    score++;
                    //如果当前球的血量为0，球要消失
                    if (ball.getBlood() <= 0) {
                        balls.remove(ball);
                    }

                    //如果血量降低为原来的一半，就让球分裂
                    if (ball.getBlood() <= ball.getInitBlood() / 2) {
                        //球应该分裂
                        ArrayList<Ball> newBallList = ball.split();
                        //把分裂出来的球添加到balls
                        balls.addAll(newBallList);
                        //把本分裂的球移出集合
                        balls.remove(ball);
                    }
                }
            }
        }
    }

    public void isShootBall3() {
        //遍历所有的球
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball = balls.get(i);
            ArrayList<BulletExpand1> bulletExpand1ArrayList = plane.getBulletExpand1ArrayList();
            for (int j = bulletExpand1ArrayList.size() - 1; j >= 0; j--) {
                BulletExpand1 bulletExpand1 = bulletExpand1ArrayList.get(j);
                //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
                if (ball.shootBy(bulletExpand1)) {
                    //球被子弹打中
                    //子弹消失
                    bulletExpand1ArrayList.remove(j);
                    score++;
                    //如果当前球的血量为0，球要消失
                    if (ball.getBlood() <= 0) {
                        balls.remove(ball);
                    }

                    //如果血量降低为原来的一半，就让球分裂
                    if (ball.getBlood() <= ball.getInitBlood() / 2) {
                        //球应该分裂
                        ArrayList<Ball> newBallList = ball.split();
                        //把分裂出来的球添加到balls
                        balls.addAll(newBallList);
                        //把本分裂的球移出集合
                        balls.remove(ball);
                    }
                }
            }
        }
    }

    public void isShootBall4() {
        //遍历所有的球
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball = balls.get(i);
            ArrayList<BulletExpand2> bulletExpand2ArrayList = plane.getBulletExpand2ArrayList();
            for (int j = bulletExpand2ArrayList.size() - 1; j >= 0; j--) {
                BulletExpand2 bulletExpand2 = bulletExpand2ArrayList.get(j);
                //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
                if (ball.shootBy(bulletExpand2)) {
                    //球被子弹打中
                    //子弹消失
                    bulletExpand2ArrayList.remove(j);
                    score++;
                    //如果当前球的血量为0，球要消失
                    if (ball.getBlood() <= 0) {
                        balls.remove(ball);
                    }

                    //如果血量降低为原来的一半，就让球分裂
                    if (ball.getBlood() <= ball.getInitBlood() / 2) {
                        //球应该分裂
                        ArrayList<Ball> newBallList = ball.split();
                        //把分裂出来的球添加到balls
                        balls.addAll(newBallList);
                        //把本分裂的球移出集合
                        balls.remove(ball);
                    }
                }
            }
        }
    }

    public void isShootBoss() {
//        for (int i = 0; i < boss1ArrayList.size(); i++) {
//            Boss1 boss1 = boss1ArrayList.get(i);

        ArrayList<Bullet> bullets = plane.getBullets();
        for (int j = bullets.size() - 1; j >= 0; j--) {
            Bullet bullet = bullets.get(j);
            //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
            if (boss1.shootBy(bullet)) {
                //球被子弹打中
                //子弹消失
                bullets.remove(bullet);
                score++;
                boss1Life--;
            }
            if (boss2.shootBy(bullet)) {
                bullets.remove(bullet);
                score++;
                boss2Life--;
            }
            if (boss3.shootBy(bullet)) {
                bullets.remove(bullet);
                score++;
                boss3Life--;
            }
        }
        ArrayList<BulletDouble> bulletDoubleArrayList = plane.getBulletDoubleArrayList();
        for (int j = bulletDoubleArrayList.size() - 1; j >= 0; j--) {
            BulletDouble bulletDouble = bulletDoubleArrayList.get(j);
            //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
            if (boss1.shootBy(bulletDouble)) {
                //球被子弹打中
                //子弹消失
                bulletDoubleArrayList.remove(bulletDouble);
                score++;
                boss1Life--;
            }
            if (boss2.shootBy(bulletDouble)) {
                bulletDoubleArrayList.remove(bulletDouble);
                score++;
                boss2Life--;
            }
            if (boss3.shootBy(bulletDouble)) {
                bullets.remove(bulletDouble);
                score++;
                boss3Life--;
            }
        }
        ArrayList<BulletFast> bulletFastArrayList = plane.getBulletFastArrayList();
        for (int j = bulletFastArrayList.size() - 1; j >= 0; j--) {
            BulletFast bulletFast = bulletFastArrayList.get(j);
            //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
            if (boss1.shootBy(bulletFast)) {
                //球被子弹打中
                //子弹消失
                bulletFastArrayList.remove(bulletFast);
                score++;
                boss1Life--;
            }
            if (boss2.shootBy(bulletFast)) {
                bulletFastArrayList.remove(bulletFast);
                score++;
                boss2Life--;
            }
            if (boss3.shootBy(bulletFast)) {
                bullets.remove(bulletFast);
                score++;
                boss3Life--;
            }
        }
        ArrayList<BulletExpand1> bulletExpand1ArrayList = plane.getBulletExpand1ArrayList();
        for (int j = bulletExpand1ArrayList.size() - 1; j >= 0; j--) {
            BulletExpand1 bulletExpand1 = bulletExpand1ArrayList.get(j);
            //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
            if (boss1.shootBy(bulletExpand1)) {
                //球被子弹打中
                //子弹消失
                bulletExpand1ArrayList.remove(bulletExpand1);
                score++;
                boss1Life--;
            }
            if (boss2.shootBy(bulletExpand1)) {
                bulletExpand1ArrayList.remove(bulletExpand1);
                score++;
                boss2Life--;
            }
            if (boss3.shootBy(bulletExpand1)) {
                bullets.remove(bulletExpand1);
                score++;
                boss3Life--;
            }
        }
        ArrayList<BulletExpand2> bulletExpand2ArrayList = plane.getBulletExpand2ArrayList();
        for (int j = bulletExpand2ArrayList.size() - 1; j >= 0; j--) {
            BulletExpand2 bulletExpand2 = bulletExpand2ArrayList.get(j);
            //判断ball和bullet是否碰撞 ，如果被击中了做相应的处理
            if (boss1.shootBy(bulletExpand2)) {
                //球被子弹打中
                //子弹消失
                bulletExpand2ArrayList.remove(bulletExpand2);
                score++;
                boss1Life--;
            }
            if (boss2.shootBy(bulletExpand2)) {
                bulletExpand2ArrayList.remove(bulletExpand2);
                score++;
                boss2Life--;
            }
            if (boss3.shootBy(bulletExpand2)) {
                bullets.remove(bulletExpand2);
                score++;
                boss3Life--;
            }
        }
//        }
    }

    public void isShootBullet() {
        ArrayList<BossBullet> bossBullets2 = boss2.getBossBullets();
        for (int i = bossBullets2.size() - 1; i >= 0; i--) {
            BossBullet bossBullet = bossBullets2.get(i);

            ArrayList<Bullet> bullets = plane.getBullets();
            for (int j = bullets.size() - 1; j >= 0; j--) {
                Bullet bullet = bullets.get(j);
                if (bossBullet.shootBy(bullet)) {
                    bullets.remove(bullet);
                    bossBullets2.remove(bossBullet);
                }
            }

            ArrayList<BulletDouble> bulletDoubleArrayList = plane.getBulletDoubleArrayList();
            for (int j = bulletDoubleArrayList.size() - 1; j >= 0; j--) {
                BulletDouble bulletDouble = bulletDoubleArrayList.get(j);
                if (bossBullet.shootBy(bulletDouble)) {
                    bulletDoubleArrayList.remove(bulletDouble);
                    bossBullets2.remove(bossBullet);
                }
            }

            ArrayList<BulletFast> bulletFastArrayList = plane.getBulletFastArrayList();
            for (int j = bulletFastArrayList.size() - 1; j >= 0; j--) {
                BulletFast bulletFast = bulletFastArrayList.get(j);
                if (bossBullet.shootBy(bulletFast)) {
                    bulletFastArrayList.remove(bulletFast);
                    bossBullets2.remove(bossBullet);
                }
            }

            ArrayList<BulletExpand1> bulletExpand1ArrayList = plane.getBulletExpand1ArrayList();
            for (int j = bulletExpand1ArrayList.size() - 1; j >= 0; j--) {
                BulletExpand1 bulletExpand1 = bulletExpand1ArrayList.get(j);
                if (bossBullet.shootBy(bulletExpand1)) {
                    bulletExpand1ArrayList.remove(bulletExpand1);
                    bossBullets2.remove(bossBullet);
                }
            }

            ArrayList<BulletExpand2> bulletExpand2ArrayList = plane.getBulletExpand2ArrayList();
            for (int j = bulletExpand2ArrayList.size() - 1; j >= 0; j--) {
                BulletExpand2 bulletExpand2 = bulletExpand2ArrayList.get(j);
                if (bossBullet.shootBy(bulletExpand2)) {
                    bulletExpand2ArrayList.remove(bulletExpand2);
                    bossBullets2.remove(bossBullet);
                }
            }
        }

        ArrayList<BossBullet> bossBullets3 = boss3.getBossBullets();
        for (int i = bossBullets3.size() - 1; i >= 0; i--) {
            BossBullet bossBullet = bossBullets3.get(i);

            ArrayList<Bullet> bullets = plane.getBullets();
            for (int j = bullets.size() - 1; j >= 0; j--) {
                Bullet bullet = bullets.get(j);
                if (bossBullet.shootBy(bullet)) {
                    bullets.remove(bullet);
                    bossBullets3.remove(bossBullet);
                }
            }

            ArrayList<BulletDouble> bulletDoubleArrayList = plane.getBulletDoubleArrayList();
            for (int j = bulletDoubleArrayList.size() - 1; j >= 0; j--) {
                BulletDouble bulletDouble = bulletDoubleArrayList.get(j);
                if (bossBullet.shootBy(bulletDouble)) {
                    bulletDoubleArrayList.remove(bulletDouble);
                    bossBullets3.remove(bossBullet);
                }
            }

            ArrayList<BulletFast> bulletFastArrayList = plane.getBulletFastArrayList();
            for (int j = bulletFastArrayList.size() - 1; j >= 0; j--) {
                BulletFast bulletFast = bulletFastArrayList.get(j);
                if (bossBullet.shootBy(bulletFast)) {
                    bulletFastArrayList.remove(bulletFast);
                    bossBullets3.remove(bossBullet);
                }
            }

            ArrayList<BulletExpand1> bulletExpand1ArrayList = plane.getBulletExpand1ArrayList();
            for (int j = bulletExpand1ArrayList.size() - 1; j >= 0; j--) {
                BulletExpand1 bulletExpand1 = bulletExpand1ArrayList.get(j);
                if (bossBullet.shootBy(bulletExpand1)) {
                    bulletExpand1ArrayList.remove(bulletExpand1);
                    bossBullets3.remove(bossBullet);
                }
            }

            ArrayList<BulletExpand2> bulletExpand2ArrayList = plane.getBulletExpand2ArrayList();
            for (int j = bulletExpand2ArrayList.size() - 1; j >= 0; j--) {
                BulletExpand2 bulletExpand2 = bulletExpand2ArrayList.get(j);
                if (bossBullet.shootBy(bulletExpand2)) {
                    bulletExpand2ArrayList.remove(bulletExpand2);
                    bossBullets3.remove(bossBullet);
                }
            }
        }
    }


//    private boolean isGoldOut() {
//        for (int i = 0; i < golds.size(); i++) {
//            Gold gold = golds.get(i);
//            if (gold.getX() < -gold.getWidth()) {
//                return true;
//            }
//        }
//        return false;
//    }

    //判断小球和飞机是否碰撞  如果撞上了做相应的处理
    private void isCrash() {
        //遍历所有的球，如果撞上了  做相应的处理
        for (int i = balls.size() - 1; i >= 0; i--) {
            Ball ball = balls.get(i);
            //拿球和飞机做判断
            if (plane.isCrash(ball)) {
                //说明撞上了， 让球消失
                balls.remove(ball);
                if (life > 0) {
                    life--;
                    plane = new Plane();
                } else {
                    //飞机炸毁了，游戏暂停
                    gameover = true;
                }
            }
        }

        for (int i = golds.size() - 1; i >= 0; i--) {
            Gold gold = golds.get(i);
            if (plane.eatGold(gold)) {
                golds.remove(gold);
                goldCount++;
            }
        }

        for (int i = gems.size() - 1; i >= 0; i--) {
            Gem gem = gems.get(i);
            if (plane.eatGem(gem)) {
                gemNumber = gem.getI();
                if (gemNumber == 4) {
                    life += 3;
                }
                gems.remove(gem);
                eatGem = true;
            }
        }

//        for (int i = 0; i < boss1ArrayList.size(); i++) {
//            Boss1 boss1 = boss1ArrayList.get(i);


    }

    private void isCrashBoss1() {
        if (plane.isCrash(boss1)) {
            boss1Life -= 20;
            if (life > 0) {
                life--;
                plane = new Plane();
            } else if (boss1Life <= 0) {
                boss1.changeImg();
                boss1.setX(-500);
            } else {
                //飞机炸毁了，游戏暂停
                gameover = true;
            }
        }
    }

    private void isCrashBoss2() {
        if (boss2.isCrash(plane)) {
            boss2Life -= 50;
            if (life > 0) {
                life--;
                plane = new Plane();
            } else if (boss2Life <= 0) {
                boss2.changeImg();
                boss2.setX(-500);
            } else {
                //飞机炸毁了，游戏暂停
                gameover = true;
            }
        }
    }

    private void isCrashBoss3() {
        if (boss3.isCrash(plane)) {

            boss3Life -= 50;
            if (life > 0) {
                life--;
                plane = new Plane();
            } else if (boss3Life <= 0) {
                boss3.changeImg();
            } else {
                //飞机炸毁了，游戏暂停
                gameover = true;
            }
        }
    }

    private boolean isCheat() {
        if (cheat.containsAll(userCheat)) {
            return true;
        }
        return false;
    }

    private void cheating() {
        cheat.add(38);
        cheat.add(38);
        cheat.add(40);
        cheat.add(40);
        cheat.add(37);
        cheat.add(39);
        cheat.add(37);
        cheat.add(39);
        cheat.add(66);
        cheat.add(66);
    }
}
