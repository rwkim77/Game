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


        this.target = target;
        setSpeed(2);

        setLoc(new Point(x, y));
    }

    @Override
    public void update(){

        int d = target.getDirection(this.getLoc(), target.getLoc());

        this.setDir(d);


        if (getDir() <= NE && getDir() >= SE)
        setPic("zombieright.png", EAST);

        else if (getDir() > NE && getDir() < NW)
            setPic("zombieback.png", NORTH);

        else if (getDir() <= SE && getDir() >= SW)
            setPic("zombiefront.png", SOUTH);

        else if (getDir() >= NW && getDir() <= SW)
            setPic("zombieleft.png", WEST);

        super.update();
    }

    public void draw(Graphics2D g2){

        g2.drawImage(getPic(), getLoc().x, getLoc().y, null);
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

