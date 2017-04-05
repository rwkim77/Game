import java.awt.*;
import java.util.ArrayList;

/**
 * Created by michael_hopps on 2/6/17.
 */
public class Zombie extends Sprite {

    private Sprite target;
    private int lives;

    public Zombie(int x, int y, Sprite target){
        super(x, y, EAST); //should pick target and stuff.
        setPic("zombieright.png", EAST);

        if (getDir() == NORTH)
            setPic("zombieback.png", NORTH);
        if (getDir() == EAST)
            setPic("zombieright.png", EAST);
        if (getDir() == SOUTH)
            setPic("zombiefront.png", SOUTH);
        if (getDir() == WEST)
            setPic("zombieleft.png", WEST);

        this.target = target;
        setSpeed(2);

        setLoc(new Point(x, y));
    }

    @Override
    public void update(){

        int d = target.getDirection(this.getLoc(), target.getLoc());

        this.setDir(d);

        setDir(d);

        super.update();
    }

    public Sprite getTarget() {
        return target;
    }

    public void setTarget(Sprite target) {
        this.target = target;
    }

    public void getHit(){
        lives--;
    }
    public int getLives(){
        return lives;
    }

}

