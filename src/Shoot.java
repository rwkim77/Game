/**
 * Created by ryan_kim on 3/31/17.
 */
public class Shoot extends Sprite{

    private int life;

    public Shoot(int x, int y, int dir){
        super(x,y,dir);
        setSpeed(60);
        setPic("bullet.png", NORTH);
        life=1;


    }
    public void update(){
        super.update();

    }

    public void getHit(){
        life--;
    }

    public int getLife(){
        return life;
    }


}
