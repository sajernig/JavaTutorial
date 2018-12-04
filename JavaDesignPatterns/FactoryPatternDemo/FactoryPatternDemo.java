//
// FactoryPatternDemo.java
//
public class FactoryPatternDemo {

   public static void main(String[] args) {
      ShapeFactory shapeFactory = new ShapeFactory();

      //get an object of Circle and call its draw method.
      Shape shape1 = shapeFactory.getShape("CIRCLE");

      //call draw method of Circle
      shape1.draw();
	  System.out.println(shape1.getShapeName());
      System.out.println(shape1.getNumPoints().toString());
	  
      //get an object of Rectangle and call its draw method.
      Shape shape2 = shapeFactory.getShape("RECTANGLE");

      //call draw method of Rectangle
      shape2.draw();
      System.out.println(shape2.getShapeName());
      System.out.println(shape2.getNumPoints().toString());

      //get an object of Square and call its draw method.
      Shape shape3 = shapeFactory.getShape("SQUARE");

      //call draw method of square
      shape3.draw();
	  System.out.println(shape3.getShapeName());
	  System.out.println(shape3.getNumPoints().toString());
   }
}