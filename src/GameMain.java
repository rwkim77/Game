import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMain extends JPanel {

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;

    private Timer timer;
    private World theWorld;

    public GameMain(){

        theWorld = new World(FRAMEWIDTH, FRAMEHEIGHT);

        //These are the Sprites that are added to the World...
        for (int i = 0; i < 1; i++) {
            int rand = (int)(Math.random()*3);
            int x = (int)(Math.random()*400 + 50);
            int y = (int)(Math.random()*400 + 50);
//            if(rand == 0)
//                theWorld.addSprite(new Bug(x, y, theWorld));
//            else if(rand == 1)
//                theWorld.addSprite(new BoxSprite(x, y, (int)(Math.random()*40+15), theWorld));
//            else if(rand == 2 && theWorld.getAllSprites().size() > 1)
//                theWorld.addSprite(new BoxSprite(x, y, 30, theWorld));
//            else
//                theWorld.addSprite(new Sprite(x, y, Sprite.EAST, theWorld));
        }
//        theWorld.addSprite(new Chaser(10, 10, theWorld));


        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                //This will call update on each sprite.
                theWorld.updateSprites();
                repaint();
            }
        });
        timer.start();


        //EventListeners.  Not using them at the moment.
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                //Ask the world if any sprites contain the click
                theWorld.click(mouseEvent);

                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });


    }

    //Our paint method.
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        //Draws all the sprites.
        theWorld.drawSprites(g2);

    }

    //sets ups the panel and frame.
    public static void main(String[] args) {
        JFrame window = new JFrame("SpriteLand");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22); //(x, y, w, h) 20 due to title bar.

        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);

        panel.setFocusable(true);
        panel.grabFocus();


        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
}