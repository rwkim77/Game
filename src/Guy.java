/**
 * Created by ryan_kim on 3/16/17.
 */
public class Guy extends Sprite{

    public Guy(){
        super(470, 250, NORTH);
        setPic("playerup.png", NORTH);
        setSpeed(this.getBoundingRectangle().height / 2);
    }

    @Override
    public void update(){
        super.update();


    }


}
