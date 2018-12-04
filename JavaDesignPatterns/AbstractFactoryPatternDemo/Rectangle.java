//
// Rectangle.java
//
public class Rectangle implements Shape 
{
   private static final Integer numPoints = 4;
	   
   @Override
   public void draw() 
   {
      System.out.println("Inside Rectangle::draw() method.");
   }
     
   @Override
   public String getShapeName()
   {
	   return("Rectangle");
   }
   
   @Override
   public Integer getNumPoints()
   {
	   return( numPoints );
   }
}