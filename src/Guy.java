/**
 * Created by ryan_kim on 3/16/17.
 */
public class Guy extends Sprite{

    public Guy(){
        super(500, 400, NORTH);
        setPic("zombieback.png", NORTH);
        setSpeed(this.getBoundingRectangle().height);
    }

    @Override
    public void update(){
        super.update();


    }
}
