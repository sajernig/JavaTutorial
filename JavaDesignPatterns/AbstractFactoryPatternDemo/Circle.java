//
// Circle.java
//
public class Circle implements Shape 
{
   private static final Integer numPoints = 100000;
	
   @Override
   public void draw() 
   {
      System.out.println("Inside Circle::draw() method.");
   }
       
   @Override
   public String getShapeName()
   {
	   return("Circle");
   }
   
   @Override
   public Integer getNumPoints()
   {
	   return( numPoints );
   }
}