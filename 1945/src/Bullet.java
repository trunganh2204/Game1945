import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Anh on 2/29/2016.
 */
public class Bullet  {
    private int PositionX;
    private int PositionY;
    public BufferedImage sprite;
    public boolean hidden;

    public void setPositionX(int x)
    {
        this.PositionX=x;
    }
    public int getPositionX()
    {
        return this.PositionX;
    }

    public void setPositionY(int y)
    {
        this.PositionY=y;
    }
    public int getPositionY()
    {
        return this.PositionY;
    }


    public void move()
    {
        this.PositionY-=3;
    }
    public void update()
    {
        move();
    }
    public void draw(Graphics g)
    {
        g.drawImage(this.sprite,this.PositionX,this.PositionY,null);
    }
}
