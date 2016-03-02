
import com.sun.java.swing.plaf.motif.MotifInternalFrameUI;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.GraphicAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by Anh on 27/02/2016.
 */
public class Gamewindow extends Frame implements MouseMotionListener,MouseListener,KeyListener,Runnable {

    Plane plane,plane2;
    BufferedImage background;
    Image image;
    Graphics seconds;




    public Gamewindow() {
        this.hiddenmouse();
        
        plane=new Plane();
        plane.setPositionX(200);
        plane.setPositionY(250);
        plane.setSpeed(3);

        plane2=new Plane();
        plane2.setPositionX(150);
        plane2.setPositionY(200);



        this.setTitle("Game 1945");
        this.setSize(400, 600);
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
                                   @Override
                                   public void windowClosing(WindowEvent e) {
                                       super.windowClosing(e);
                                       System.exit(0);
                                   }
                               }
        );





        try {
            background = ImageIO.read(new File("Resouces/Background.png"));
            plane.sprite = ImageIO.read(new File("Resouces/PLANE1.png"));
            plane2.sprite = ImageIO.read(new File("Resouces/PLANE2.png"));
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        repaint();

    }

    private void hiddenmouse() {
        Toolkit g = Toolkit.getDefaultToolkit();
        Point h = new Point(0,0);
        BufferedImage hidden = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = g.createCustomCursor(hidden, h, "InvisibleCursor");
        setCursor(invisibleCursor);
    }

    private void addWindowListener(MouseAdapter mouseAdapter) {
    }



    public void update(Graphics g){
        if(image==null){
            image= createImage(this.getWidth(),this.getHeight());
            seconds=image.getGraphics();

        }
        seconds.setColor(getBackground());
        seconds.fillRect(0,0,getWidth(),getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image,0,0,null);


    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, null);

        plane.draw(g);
        plane2.draw(g);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("May vua bam phim " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            plane.direction = 1;
            //repaint();
        }
        if (e.getKeyChar() == 'd') {
            plane.direction = 4;
            //repaint();
        }
        if (e.getKeyChar() == 'a') {
            plane.direction = 3;
            //repaint();
        }
        if (e.getKeyChar() == 'x') {
            plane.direction = 2;
            //repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void run() {

        while (true) {
            plane.move();

            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public  void mouseClicked(MouseEvent event)
    {

    }

    @Override
    public void mousePressed(MouseEvent event)
    {

    }

    @Override
    public void mouseReleased(MouseEvent event)
    {

    }

    @Override
    public void mouseEntered(MouseEvent event)
    {

    }

    @Override
    public void mouseExited(MouseEvent event)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {

    }

    @Override
    public void mouseMoved(MouseEvent event)
    {
        plane2.setPositionX(event.getX());
        plane2.setPositionY(event.getY());
    }
}


