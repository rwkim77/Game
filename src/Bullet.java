import java.awt.*;
import java.util.ArrayList;
/**
 * Created by christian_brown on 3/27/17.
 */
public class Bullet {
    private int x, y;
    private int dx = 10;
    private int width = 10;
    private int height = 10;
    private boolean dead = true;
    private int bullet_limit = 50;
    private int bullet_range = 200;
//    private image;



    public void Shoot() {
        x += dx;
        if (x > bullet_range) {
            dead = false;

        }
    }

//    public void paint(Graphics g) {
//        g.drawImage("blank.png", x, y, width, height, null);

    }
//}


