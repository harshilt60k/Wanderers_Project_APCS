import sacco.*;
public class ImprovedWanderer extends Wanderer 
{
    private static final int UP = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3; 
    private static final int RIGHT = 4;

    public ImprovedWanderer(double i, double j)
    {
        super(i,j); 
    }

    public void run()
    {
        if( getState() == STAND_UP)
            setState(RUN_UP);
        if( getState() == STAND_DOWN)
            setState(RUN_DOWN);
        if( getState() == STAND_LEFT)
            setState(RUN_LEFT);
        if( getState() == STAND_RIGHT)
            setState(RUN_RIGHT);
    }

    public void stand()
    {
        if( getState() == RUN_UP)
            setState(STAND_UP);
        if( getState() == RUN_DOWN)
            setState(STAND_DOWN);
        if( getState() == RUN_LEFT)
            setState(STAND_LEFT);
        if( getState() == RUN_RIGHT)
            setState(STAND_RIGHT);
    }

    public void faceDirection(int dir)
    {
        boolean bool = super.isRunning();

        if( dir == UP)
        {
            setState(STAND_UP);
        }
        else if( dir == DOWN)
        {
            setState(STAND_DOWN);
        }
        else if( dir == LEFT)
        {
            setState(STAND_LEFT);
        }
        else if( dir == RIGHT)
        {
            setState(STAND_RIGHT);
        }

        if(bool)
        {
            run();
        }
    }

    public static void improvedTester()
    {
        WanderWorld world = new WanderWorld();

        for(int i = 0; i < 500; i++)
        {
            ImprovedWanderer wanda = new ImprovedWanderer((int)(Math.random()*620),(int)(Math.random()*620)); 
            wanda.setAutomation(false);
            wanda.faceDirection(wanda.DOWN);
            world.add( wanda );
        }

        world.launch();
    }

    public boolean containsPoint(int x, int y)
    {
        return x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight();
    }

}
