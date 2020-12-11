import sacco.*;
import sacco.Point;

public abstract class AbstractPointSeeker extends ImprovedWanderer
{
    private Point dest;

    public abstract void onArrival();

    public AbstractPointSeeker(double x, double y)
    {
        super(x,y);
        this.setDestination(null);
        this.setState(Wanderer.STAND_DOWN);
        this.onArrival();
    }

    public void setDestination(Point p)
    {
        dest = p;
    }

    public Point getDestination()
    {
        return dest;
    }

    public void update()
    {
        super.update();
        if(dest == null)
            return;

        if( getX() < dest.getX() - getSpeed()/2)
            setState(RUN_RIGHT);
        else if( getX() > dest.getX()+getSpeed()/2)
            setState(RUN_LEFT);
        else if( getY() < dest.getY() - getSpeed()/2)
            setState(RUN_DOWN);
        else if( getY() > dest.getY()+getSpeed()/2)
            setState(RUN_UP);
        else
            setState(STAND_DOWN);
    }

    public static void horizontalSeekerRunner()
    {
        WanderWorld world = new WanderWorld();
        world.setSize(320,320);

        PointSeeker a = new PointSeeker(20, 20);
        PointSeeker b = new PointSeeker(20, 100);
        PointSeeker c = new PointSeeker(280, 180);
        PointSeeker d = new PointSeeker(280, 260);

        a.setDestination(new Point(280,20));
        b.setDestination(new Point(150,120));
        c.setDestination(new Point(150,180));
        d.setDestination(new Point(20,260));

        world.add(a);
        world.add(b);
        world.add(c);
        world.add(d);

        world.launch();
    }

    public static void spiralSeeker()
    {
        WanderWorld world = new WanderWorld();
        world.setSize(400,400);

        for(int i = 0; i<360*4; i+=5)
        {
            PointSeeker p = new PointSeeker(185,180);
            double x = 185+50*i/360.0*Math.cos(Math.toRadians(i)); 
            double y = 180+50*i/360.0*Math.sin(Math.toRadians(i)); 
            p.setDestination(new Point((int)x,(int)y));    
            world.add(p);
        }

        world.launch();
    }

    public void randomizeDestination()
    {
        int x = (int)(Math.random()*500)+0;
        int y = (int)(Math.random()*500)+0;
        
//         PointSeeker p = new PointSeeker(x,y);
        this.setDestination(new Point(x,y));
    }

    public void randomizeLocation()
    {
        int x = (int)(Math.random()*500)+0;
        int y = (int)(Math.random()*500)+0;
        this.setX(x); 
        this.setY(y);
    }
}
