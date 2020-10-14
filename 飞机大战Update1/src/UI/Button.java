package UI;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private String name;
    private int x;
    private int y;
    private int width = 250;
    private int height = 80;

    public Button() {
    }

    public Button(String name, int x, int y) {
        this.name = name;
        this.setText(name);
        this.x = x;
        this.y = y;
        this.setBounds(x, y, width, height);
        this.setFont(new Font("楷体", Font.BOLD, 40));
        this.setForeground(Color.orange);
        this.setBackground(Color.LIGHT_GRAY);
        this.setOpaque(true);
    }
}
