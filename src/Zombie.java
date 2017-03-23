import java.awt.*;
import java.util.ArrayList;

/**
 * Created by michael_hopps on 2/6/17.
 */
public class Zombie extends Chaser {

    public Zombie(int x, int y, World w){
        super(x, y, w); //should pick target and stuff.
        setPic("zombieright.png", EAST);

        if (getDir() == NORTH)
            setPic("zombieback.png", NORTH);
        if (getDir() == EAST)
            setPic("zombieright.png", EAST);
        if (getDir() == SOUTH)
            setPic("zombiefront.png", SOUTH);
        if (getDir() == WEST)
            setPic("zombieleft.png", WEST);
    }

    @Override
    public void update(){

        if(!getTarget().equals(this) && !(getTarget() instanceof Zombie) && getTarget().intersects(this)){ //caught target
            Point loc = getTarget().getLoc(); //target's loc
            getWorld().removeSprite(getTarget()); //remove old target
            Chaser zombie = new Zombie(loc.x, loc.y, getWorld());
            getWorld().addSprite(zombie); //replace old target with zombie

            //pick new target.  copied and pasted from Chaser constructor
            pickTarget();
        }

        if(getTarget() instanceof Zombie){
            setTarget(this);
//            pickTarget();
        }

        super.update();
    }
}
