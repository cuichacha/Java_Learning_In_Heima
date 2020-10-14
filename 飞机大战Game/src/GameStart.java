/*
    重新开始之后，子弹有问题
    碰撞没有抽取方法
 */

import UI.FighterFightFrame;
import UI.FighterFightPanel;

public final class GameStart {
    public static void main(String[] args) {
        // 创建窗口子类对象
        FighterFightFrame fighterFightFrame = new FighterFightFrame();
        // 调用窗口创建方法
        fighterFightFrame.drawFrame();
        // 创建面板子类对象
        FighterFightPanel fighterFightPanel = new FighterFightPanel();
        // 调用设置面板背景颜色方法
        fighterFightPanel.drawPanel();
        // 将面板添加到窗口上
        fighterFightFrame.add(fighterFightPanel);
        // 开启子弹绘制线程
        fighterFightPanel.action();
        // 设置窗口显示
        fighterFightFrame.setVisible(true);
    }
}
