import java.util.ArrayList;

/**
 * Created by ryan_kim on 4/16/17
 */
public class Chaser extends Sprite {

    private Sprite target;

    public Chaser(int x, int y, World world) {
        super(x, y, EAST);

        ArrayList<Sprite> sprites = world.getAllSprites();
        target = sprites.get( (int)(Math.random()*sprites.size()) );
        while(target.equals(this) && sprites.size() > 1){
            target = sprites.get( (int)(Math.random()*sprites.size()) );
        }
        setPic("zombieback.png", NORTH);
        setSpeed(10);

    }


    @Override
    public void update(){
        int d = getWorld().getDirection(this.getLoc(), target.getLoc());
        setDir(d);

        super.update();
    }

    public Sprite getTarget(){
        return target;
    }
    public void setTarget(Sprite Guy){
        target = Guy;
    }

    public void pickTarget(){
        ArrayList<Sprite> sprites = getWorld().getAllSprites();
        target = sprites.get( (int)(Math.random()*sprites.size()) );
        while(target.equals(this) && sprites.size() > 1){
            target = sprites.get( (int)(Math.random()*sprites.size()) );
        }
    }

}

