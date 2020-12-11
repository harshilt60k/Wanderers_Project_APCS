import sacco.Color;
import sacco.Card;
import sacco.objects.Date;
public class CodedStringGenerator
{   
    //Precondition: arr is populated with Color, Date, and Card objects
    public static String generateCodedString(Object[] arr)
    {
        String str = ""; 
        for(int i =0; i < arr.length; i++)
        {
            if(arr[i] instanceof Color)
            {
                Color c = (Color)arr[i];

                if(c.getRed() > c.getBlue())
                {    
                    if(c.getRed() > c.getGreen())
                    {
                        str += "R";
                    }
                     else 
                    {
                        str += "G";
                    }
                }
                else if(c.getBlue() > c.getGreen())
                {
                    str += "B";
                }
                else
                {
                    str += "G";
                }
            }
            
            if(arr[i] instanceof Date)
            {
                Date d = (Date)arr[i];
                
                if(d.isALeapYear())
                    str += "L";
                else 
                    str += "N";
            }
            
            if(arr[i] instanceof Card)
            {
                Card ca = (Card)arr[i];
                
                str += ca.getSuit().charAt(0);
            }
        }
        return str; 
    }
    
    public static void main()
{
    Object[] objArr = {new Color(222,100,236), new Card("A","S"), new Date(1,1,2005), new Color(99,120,112), new Date(12,31,1999), new Card("T","D")};
    String code = generateCodedString(objArr);
    System.out.println(code);        
}
}
