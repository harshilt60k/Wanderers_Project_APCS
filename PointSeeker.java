public class PointSeeker extends AbstractPointSeeker
{
    public PointSeeker(double x, double y)
    {
        super(x,y);
    }

    @Override
    public void onArrival()
    {
        setState(STAND_DOWN);
    }
}
