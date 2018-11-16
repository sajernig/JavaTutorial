public class Puppy extends Dog {
   public Puppy(String name) {
      // This constructor has one parameter, name.
      System.out.println("Passed Name is :" + name );
   }

   public void setAge( int puppyAge ) {
      age = puppyAge;
   }

   public int getAge( ) {
      System.out.println("Puppy's age is :" + age );
      return age;
   }
   
   public static void main(String []args) {
      // Following statement would create an object myPuppy
      Puppy myPuppy = new Puppy( "tommy" );
	  
	  myPuppy.setAge( 2 );
	  int pupAge = myPuppy.getAge();
	  boolean bLaysEggs = myPuppy.laysEggs();
	  if (bLaysEggs)
	  {
	     System.out.println("Puppys lay eggs" );	  
	  }
	  else
	  {
	     System.out.println("Puppys DO NOT lay eggs" );		  
	  }
	  myPuppy.barking();
	  myPuppy.hungry();
	  myPuppy.sleeping();
   }
}