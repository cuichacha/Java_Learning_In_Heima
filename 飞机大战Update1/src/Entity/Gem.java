package Entity;

import com.hzheima.util.ImageUtil;

public class Gem extends Gold {
    int i;

    public Gem() {
        i = random.nextInt(4) + 1;
        img = ImageUtil.getImg("gem" + i + ".png");
        width = img.getWidth() / 10;
        height = img.getHeight() / 10;
        xSpeed = random.nextInt(15) + 5;
        ySpeed = random.nextInt(15) + 5;
    }

    public int getI() {
        return i;
    }
}
