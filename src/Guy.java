/**
 * Created by ryan_kim on 3/16/17.
 */
public class Guy extends Sprite{

    public Guy(int x, int y, World aWorld){
        super(x, y,EAST, aWorld);
        setPic("zombieback.png", NORTH);
        setSpeed(10);
    }

    @Override
    public void update(){

    }
}
