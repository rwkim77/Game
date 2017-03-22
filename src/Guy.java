/**
 * Created by ryan_kim on 3/16/17.
 */
public class Guy extends Sprite{

    public Guy(int x, int y, World aWorld){
        super(x, y,NORTH, aWorld);
        setPic("playerup.png", NORTH);
        setSpeed(this.getBoundingRectangle().height);
    }

    @Override
    public void update(){

    }
}
