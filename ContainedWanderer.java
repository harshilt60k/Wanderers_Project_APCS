import sacco.*;
public class ContainedWanderer extends ImprovedWanderer
{
    public ContainedWanderer(double x, double y)
    {
        super(x,y);
    }

    public void update(){
        super.update();
        if( getX() < 0)
            setX(0);
        if( getY() < 0)
            setY(0);

        if( getX() > 640-getWidth())
        {
            setX(640-getWidth());
        }  

        if( getY() > 640-getHeight())
        {
            setY(640-getHeight());
        }
    }
}