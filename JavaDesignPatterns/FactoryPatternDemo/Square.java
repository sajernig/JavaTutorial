//
// Square.java
//
public class Square implements Shape 
{
   private static final Integer numPoints = 4;
   
   @Override
   public void draw() 
   {
      System.out.println("Inside Square::draw() method.");
   }
   
   @Override
   public String getShapeName()
   {
	   return("Square");
   }
   
   @Override
   public Integer getNumPoints()
   {
	   return( numPoints );
   }
}