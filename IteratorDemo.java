import java.util.*;
public class IteratorDemo 
{
   public static void main(String args[]) 
   {
	   //
      // Create an array list
	  //
      ArrayList<String> al = new ArrayList<String>();
      
	  //
      // add elements to the array list
	  //
      al.add("C");
      al.add("A");
      al.add("E");
      al.add("B");
      al.add("D");
      al.add("F");

      //
      // Use iterator to display contents of al
	  //
      System.out.print("Original contents of al: ");
      Iterator<String> itr = al.iterator();
      while(itr.hasNext()) 
	  {
         String element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();
      
	  //
      // Modify objects being iterated
	  //
      ListIterator<String> litr = al.listIterator();
      while(litr.hasNext()) 
	  {
         Object element = litr.next();
         litr.set(element + "+");
      }
      
	  //
	  // Display the modified contents.
	  //
      System.out.print("Modified contents of al: ");
	  itr = al.iterator(); // Get new iterator to reset to first of list.
      while(itr.hasNext()) 
	  {
         Object element = itr.next();
         System.out.print(element + " ");
      }
      System.out.println();

	  //
      // Now, display the list backwards. This works
	  // because litr has already traversed the list
	  // forwards. If you get a new list iterator and
	  // try this, it will return false because it is at
	  // the first of the list.
	  //
      System.out.print("Modified list backwards: ");
      while(litr.hasPrevious()) 
	  {
         Object element = litr.previous();
         System.out.print(element + " ");
      }
      System.out.println();
   }
}