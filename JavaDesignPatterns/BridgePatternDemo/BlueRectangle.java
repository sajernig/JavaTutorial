public class BlueRectangle implements DrawAPI 
{
   @Override
   public void drawCircle(int radius, int x, int y) 
   {
   }
   
   @Override
   public void drawRectangle(int x1, int y1, int x2, int y2)
   {
       System.out.println("Drawing Rectangle[ color: blue, x1,y1 : " + x1 + ", " + y1 + " x2,y2 " + x2 + ", " + y2 + "]");
   }
}