public class BridgePatternDemo 
{
   public static void main(String[] args) 
   {
      Shape redCircle = new Circle(100,100, 10, new RedCircle());
      Shape greenCircle = new Circle(100,100, 10, new GreenCircle());
      Shape blueRectangle = new Rectangle(100,100, 200, 200, new BlueRectangle());
	  
      redCircle.draw();
      greenCircle.draw();
	  blueRectangle.draw();
   }
}