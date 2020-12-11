import sacco.*;
import sacco.Point;
public class Bomber extends AbstractPointSeeker
{
    public Bomber(double x, double y)
    {
        super(x,y);
    }

    @Override
    public void onArrival()
    {
        /*ImprovedWanderer i = new ImprovedWanderer( this.getX(), this.getY());

        i.setCharacterNumber(7);
        i.setScale(0.6);
        i.setAutomation(false);
        i.stand();
        WanderWorld myWorld = getWorld();
        myWorld.add(i);
        randomizeDestination();*/
    }


    public static void bomberRunner()
    {
        WanderWorld world = new WanderWorld();

        Bomber b = new Bomber(320,320);
        world.add(b);
        b.randomizeDestination();

        world.launch();
    }
}
