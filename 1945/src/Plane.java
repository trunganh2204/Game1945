import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anh on 2/28/2016.
 */
public class Plane
{
    public Plane(){
        //khong co kieu tra ve
        //ten ham giong ten class
        this.positionX=300;
        this.positionY=300;
        this.speed=4;
        try{
            this.sprite= ImageIO.read(new File("Resouces/PLANE1.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Plane(int positionX,int positionY,int speed,int planeType){

    }
    private int positionX;
    private int positionY;
    private int damage;
    private int speed;
    private int heath;
    private int planeType;
    public BufferedImage sprite;
    public boolean hidden;
    int direction;

    //toa do x
    public void setPositionX(int x)
    {
        this.positionX=x;
    }
    public int getPositionX(int i)
    {
        return positionX;
    }
    //toa do y
    public void setPositionY(int y)
    {
        this.positionY=y;
    }
    public int getPositionY(int i)
    {
        return positionY;
    }
    //toc do speed
    public void setSpeed(int sp)
    {
        this.speed=sp;
    }
    public int getSpeed(int i)
    {
        return speed;
    }
    //Hp heath
    public void setHeath(int HP)
    {
        this.heath=HP;
    }
    public int getHeath()
    {
        return heath;
    }
    // sat thuong damage
    public void setDamage(int st)
    {
        this.damage=st;
    }
    public int getDamage()
    {
        return damage;
    }

    //hidden cursor



    void move()
    {

        if (direction == 0)
        {

        } else if (direction == 1)
        {
            this.positionY-=this.speed;
        } else if (direction == 2)
        {
            this.positionY+=this.speed;
        } else if (direction == 3)
        {
            this.positionX-=this.speed;
        } else if (direction == 4)
        {
            this.positionX+=this.speed;
        }
    }
    public void update()
    {
        move();
    }
    public void draw(Graphics g)
    {
        g.drawImage(this.sprite,this.positionX,this.positionY,null);
    }



}