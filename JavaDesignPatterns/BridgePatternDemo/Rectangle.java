public class Rectangle extends Shape 
{
   private int x1, y1, x2, y2;

   public Rectangle(int x1, int y1, int x2, int y2, DrawAPI drawAPI) 
   {
      super(drawAPI);
      this.x1 = x1;  
      this.y1 = y1;  
      this.x2 = x2;
	  this.y2 = y2;
   }

   public void draw() 
   {
      drawAPI.drawRectangle(x1,y1,x2,y2);
   }
}