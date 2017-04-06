import java.util.ArrayList;

/**
 * Created by ryan_kim on 3/16/17.
 */
public class Guy extends Sprite{

    public Guy(){
        super(470, 250, NORTH);
        setPic("playerup.png", NORTH);
        setSpeed(this.getBoundingRectangle().height / 15);



    }

    @Override
    public void update(){


        super.update();


    }

//    public void Shoot(){
//        setDir(NORTH);
//        setSpeed(5);
//        setPic("playerleft.png", NORTH);
//    }



}
