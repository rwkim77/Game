import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMain extends JPanel {

    public static final int FRAMEWIDTH = 1000, FRAMEHEIGHT = 600;

    private Timer timer;
    private boolean[] keys;
    private Sprite guy;
    private World theWorld;


    public GameMain(){

        keys = new boolean[512];


        guy = new Guy();



        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (keys[KeyEvent.VK_W]) {
                    guy.setDir(Sprite.NORTH);
                    guy.update();
                    keys[KeyEvent.VK_W] = false; //probably.
                }
                if (keys[KeyEvent.VK_A]) {
                    guy.setDir(Sprite.WEST);
                    guy.update();
                    keys[KeyEvent.VK_A] = false; //probably.
                }
                if (keys[KeyEvent.VK_D]) {
                    guy.setDir(Sprite.EAST);
                    guy.update();
                    keys[KeyEvent.VK_D] = false; //probably.
                }
                if (keys[KeyEvent.VK_S]) {
                    guy.setDir(Sprite.SOUTH);
                    guy.update();
                    keys[KeyEvent.VK_S] = false; //probably.
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