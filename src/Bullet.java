import java.awt.*;
import java.util.ArrayList;
/**
 * Created by christian_brown on 3/27/17.
 */
public class Bullet extends Sprite {

    public Bullet(int x, int y, int dir) {
        super(x, y, dir);
        setDir(NORTH);
        setSpeed(5);
        setPic("blank.png", NORTH);
    }

    @Override
    public void update() {
        super.update();
    }
}


