
class Mammal {
	boolean laysEggs() {
		return(false);
	}
}

public class Dog extends Mammal {
   String breed;
   int age;
   String color;

   public Dog() {
	   age = 2;
   }

   void barking() {
	   System.out.println("Barking..." );
   }

   void hungry() {
   	   System.out.println("Hungry..." );
   }

   void sleeping() {
   	   System.out.println("Sleeping..." );
   }
}
