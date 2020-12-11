import sacco.*;
public class MixedWorld extends WanderWorld
{

    public void onMousePress(MouseEvent m)
    {
        for(Wanderer w: getWanderers())
        {
            if (w instanceof PointSeeker)
            {
                PointSeeker p = (PointSeeker)w;
                p.randomizeDestination();
            }
            
            if(w instanceof ContainedWanderer)
            {
                ContainedWanderer c = (ContainedWanderer)w;
                c.setState(Wanderer.STAND_DOWN); 
                c.setAutomation(false);
            }
        }
    }

    public static void main()
    {
        MixedWorld world = new MixedWorld();
    
        for(int i = 0; i < 40; i++)
        {
            int rand = (int)(Math.random()*2);
            if(rand == 0)
            {
                ContainedWanderer c = new ContainedWanderer(220,220);
                c.setCharacterNumber(4);         //All ContainedWanderers are Dr. Robotnik/Eggman
                world.add(c);
            }
            else 
            {
                PointSeeker p = new PointSeeker(220,220);
                p.setCharacterNumber(0);        //All PointSeekers are Mario
                p.randomizeDestination(); 
                world.add(p);
            }
        }
    
        world.launch();
    }


}
