public class GreenCircle implements DrawAPI 
{
   @Override
   public void drawCircle(int radius, int x, int y) 
   {
      System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
   }
   
   @Override
   public void drawRectangle(int x1, int y1, int x2, int y2)
   {
   }
}