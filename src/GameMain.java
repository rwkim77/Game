import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GameMain extends JPanel {

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;

    private Timer timer;
    private boolean[] keys;
    private Sprite guy;
    private World theWorld;
    private ArrayList<Sprite> zooombies;


    public GameMain(){

        keys = new boolean[512];

        theWorld = new World(FRAMEWIDTH, FRAMEHEIGHT);
        guy = new Guy();

        theWorld.addSprite(new Guy());

//        Zombie z = new Zombie(100,100,theWorld);
//        zooombies.add(z);



        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (keys[KeyEvent.VK_W] && keys[KeyEvent.VK_D]) {
                    guy.setDir(Sprite.NE);
                    guy.setPic("playerupright.png", Sprite.NE);
                    guy.update();
//                    keys[KeyEvent.VK_W] = false;
//                    keys[KeyEvent.VK_D] = false; //probably.
                }
                else if (keys[KeyEvent.VK_W] && keys[KeyEvent.VK_A]) {
                    guy.setDir(Sprite.NW);
                    guy.setPic("playerupleft.png", Sprite.NW);
                    guy.update();
//                    keys[KeyEvent.VK_W] = false;
//                    keys[KeyEvent.VK_A] = false; //probably.
                }
                else if (keys[KeyEvent.VK_S] && keys[KeyEvent.VK_A]) {
                    guy.setDir(Sprite.SW);
                    guy.setPic("playerbottomleft.png", Sprite.SW);
                    guy.update();
//                    keys[KeyEvent.VK_S] = false;
//                    keys[KeyEvent.VK_A] = false; //probably.
                }
                else if (keys[KeyEvent.VK_S] && keys[KeyEvent.VK_D]) {
                    guy.setDir(Sprite.SE);
                    guy.setPic("playerbottomright.png", Sprite.SE);
                    guy.update();
//                    keys[KeyEvent.VK_S] = false;
//                    keys[KeyEvent.VK_D] = false; //probably.
                }

                else if (keys[KeyEvent.VK_W]) {
                    guy.setDir(Sprite.NORTH);
                    guy.setPic("playerup.png", Sprite.NORTH);
                    guy.update();
//                    keys[KeyEvent.VK_W] = false; //probably.
                }
                else if (keys[KeyEvent.VK_A]) {
                    guy.setDir(Sprite.WEST);
                    guy.setPic("playerleft.png", Sprite.WEST);
                    guy.update();
//                    keys[KeyEvent.VK_A] = false; //probably.
                }
                else if (keys[KeyEvent.VK_D]) {
                    guy.setDir(Sprite.EAST);
                    guy.setPic("playerright.png", Sprite.EAST);
                    guy.update();
//                    keys[KeyEvent.VK_D] = false; //probably.
                }
                else if (keys[KeyEvent.VK_S]) {
                    guy.setDir(Sprite.SOUTH);
                    guy.setPic("playerdown.png", Sprite.SOUTH);
                    guy.update();
//                    keys[KeyEvent.VK_S] = false; //probably.
                }


                //This will call update on each sprite.
                repaint();

                }
            });
        timer.start();

            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent keyEvent) {

                }

                @Override
                public void keyPressed(KeyEvent keyEvent) {
                    keys[keyEvent.getKeyCode()] = true;
                }

                @Override
                public void keyReleased(KeyEvent keyEvent) {
                    keys[keyEvent.getKeyCode()] = false;
                }
            });

        }

                //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;


        guy.draw(g2);

//        for(Sprite s: zooombies){
//            s.draw(g2);
//        }

        //draw all the things.
//        for(Sprite s: obstacles){
//            s.draw(g2);
//        }

    }

    //sets ups the panel and frame.
    public static void main(String[] args) {
        JFrame window = new JFrame("BoxHead!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 22 due to title bar.

        GameMain panel = new GameMain();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();

        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}