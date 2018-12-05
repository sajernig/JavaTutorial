import java.util.*;

//
// CollectionsDemo.java - using generics.
//
public class CollectionsDemo 
{
   //
   // A private class to exercise the collections below.
   //
   private static class MyData
   {
	   int myInteger = -1; // Just a recognizable default.
	   String myString = "Test String"; // Something to start with....
	   
	   //
	   // Constructors
	   //
	   MyData()
	   {
	   }
	   MyData(int seedValue, String seedString)
	   {
	       this.myInteger = seedValue;
		   this.myString = seedString;
	   }
	   
	   //
	   // Get and Set myInteger value.
	   //
	   public int getMyInteger()
	   {
		   return this.myInteger;
	   }
	   public void setMyInteger(int newValue)
	   {
		   this.myInteger = newValue;
	   }
	   
	   //
	   // Get and set myString value.
	   //
	   public String getMyString()
	   {
		   return this.myString;
	   }
	   public void setMyString(String newString)
	   {
		   this.myString = newString;
	   }
	   
	   //
	   // Override equals for the MyData class to insure we know
	   // what constitutes equality. This checks the equality of the
	   // variables myInteger and myString plus the class name.
	   //
	   @Override
       public boolean equals(Object obj) 
	   {
           if (obj == null) 
		   {
               return false;
           }

		   if (getClass() != obj.getClass())   
		   {
               return false;
           }

           final MyData other = (MyData) obj;
           if ((this.myString == null) ? (other.getMyString() != null) : !this.getMyString().equals(other.getMyString())) 
		   {
               return false;
           }

           if (this.myInteger != other.getMyInteger()) 
		   {
               return false;
           }

           return true;
       }
	   
	   //
	   // Override hashcode since we overrode equals.
	   //
	   @Override
       public int hashCode() 
	   {
           int hash = 3;
           hash = 53 * hash + (this.myString != null ? this.myString.hashCode() : 0);
           hash = 53 * hash + this.myInteger;
           return hash;
       }
   }
   
   //
   // A private class to iterate through a MyData list and print it.
   //
   private static class MyDataListPrint
   {
	   private Iterator<MyData> listItr; // Iterator to use...
	   private String listTitle; // List title to print.
	   
	   //
	   // Constructors.
	   //
	   MyDataListPrint()
	   {
	   }
	   MyDataListPrint(String listTitle, Iterator<MyData> listItr)
	   {
		   this.listTitle = listTitle;
		   this.listItr = listItr;
	   }
	   
	   //
	   // Set title and iterator.
	   //
	   public void setListTitle(String listTitle)
	   {
		   this.listTitle = listTitle;
	   }
	   public void setIterator(Iterator<MyData> listItr)
	   {
		   this.listItr = listItr;
	   }
	   
	   //
	   // Print the MyData values.
	   //
	   public void PrintMyData()
	   {
		    System.out.println(this.listTitle);
	        while(this.listItr.hasNext()) 
	        {
                MyData element = this.listItr.next();
                System.out.print(element.getMyInteger() + "," + element.getMyString() + " ");
            }
            System.out.println();
	  }
   }
   
   public static void main(String[] args) 
   {
	  //
      // ArrayList example
	  //
      List<MyData> aList = new ArrayList<MyData>();
      aList.add(new MyData(0, "Zara"));
	  aList.add(new MyData(1, "Mahnaz"));
	  aList.add(new MyData(2, "Ayan"));
	  MyDataListPrint printList = new MyDataListPrint( "ArrayList Elements", aList.iterator());
	  printList.PrintMyData();

      //
      // LinkedList example
	  //
      LinkedList<MyData> myLinkedList = new LinkedList<MyData>();
      myLinkedList.add(new MyData(0, "F"));
	  myLinkedList.add(new MyData(1, "B"));
	  myLinkedList.add(new MyData(2, "D"));
	  myLinkedList.add(new MyData(3, "E"));
	  myLinkedList.add(new MyData(4, "C"));
	  myLinkedList.addLast(new MyData(5, "Z"));
	  myLinkedList.addFirst(new MyData(6, "A"));
	  myLinkedList.add(1, new MyData(7, "A2"));
	  printList.setIterator(myLinkedList.iterator());
	  printList.setListTitle("\nLinkedList Elements");
	  printList.PrintMyData();
	  
	  //
      // Remove elements from the linked list
	  //
	  MyData classToMatch = myLinkedList.get(2);
      myLinkedList.remove(classToMatch); // remove by class match
      myLinkedList.remove(2); // remove via index.
	  printList.setIterator(myLinkedList.iterator());
	  printList.setListTitle("Contents of LinkedList after deletion.");
	  printList.PrintMyData();
	  
	  //
      // Remove first and last elements
	  //
      myLinkedList.removeFirst();
      myLinkedList.removeLast();
	  printList.setIterator(myLinkedList.iterator());
	  printList.setListTitle("Contents of LinkedList after first and last removed.");
	  printList.PrintMyData();
	  
      //
      // Get and set a value
	  //
      MyData val = myLinkedList.get(2);
	  MyData newVal = new MyData(13, val.getMyString() + " changed.");
      myLinkedList.set(2, newVal);
	  printList.setIterator(myLinkedList.iterator());
	  printList.setListTitle("LinkedList after change to index 2.");
	  printList.PrintMyData();
	   
	  //
      // HashSet example
	  //
      HashSet<MyData> myHashSet = new HashSet<MyData>(); 
	  MyData zaraData = new MyData(24323, "Zara"); // Save this object for a later test.
	  MyData zaraDuplicateData = new MyData(24323, "Zara"); // Same data as zaraData but different object.
	  MyData unknownData = new MyData(1313, "Mockingbird Lane"); // Data that should not be in hashset
	  myHashSet.add(zaraData);
	  myHashSet.add(new MyData(45666, "Mahnaz"));
	  myHashSet.add(new MyData(64546, "Ayan"));
	  printList.setIterator(myHashSet.iterator());
	  printList.setListTitle("\nHashSet Elements.");
	  printList.PrintMyData();
	  
	  //
	  // Look for some objects in the hashset. We match on class name and 
	  // the class variables. See MyData equals method.
	  //
	  if (myHashSet.contains(zaraData))
	  {
		  System.out.println("Found zaraData object in hashset.");
	  }
	  else
	  {
		  System.out.println("Error: Did not find zaraData object in hashset.");
	  }
	  if (myHashSet.contains(zaraDuplicateData))
	  {
		  System.out.println("Found zaraDuplicateData object in hashset.");
	  }
	  else
	  {
		  System.out.println("Error: Did not find zaraDuplicateData object in hashset.");
	  }
	  if (myHashSet.contains(unknownData))
	  {
		  System.out.println("Error: Found unknownData object in hashset.");
	  }
	  else
	  {
		  System.out.println("Did not find unknownData object in hashset.");
	  }
	  
	  //
	  // Remove zaraDuplicateData and look for it again (this works for zaraData as well).
	  //
	  myHashSet.remove(zaraDuplicateData);
	  if (myHashSet.contains(zaraData))
	  {
		  System.out.println("Error: Found zaraData object in hashset after remove.");
	  }
	  else
	  {
		  System.out.println("Did not find zaraData object in hashset after remove.");
	  }
	  if (myHashSet.contains(zaraDuplicateData))
	  {
		  System.out.println("Error: Found zaraDuplicateData object in hashset after remove.");
	  }
	  else
	  {
		  System.out.println("Did not find zaraDuplicateData object in hashset after remove.");
	  }

      //
      // HashMap example.
	  //
      HashMap<String,MyData> myHashMap = new HashMap<String, MyData>(); 
      myHashMap.put("Zara", new MyData(2000, "123 highland Dr"));
      myHashMap.put("Mahnaz", new MyData(3000, "456 Lowland Dr"));
      myHashMap.put("Ayan", new MyData(4000, "789 Midland Dr"));
      myHashMap.put("Daisy", new MyData(5000, "13 Swampland Dr"));
	  
	  //
	  // We will iterate a HashMap differently than the others.
	  //
	  // Get a set of the entries and an iterator then display the contents.
	  //
	  System.out.println("\nHashMap elements - Key: MyData values");
      Set<Map.Entry<String,MyData>> set = myHashMap.entrySet();
      Iterator<Map.Entry<String,MyData>> hashMapItr = set.iterator();
      while(hashMapItr.hasNext()) 
	  {
         Map.Entry<String,MyData> mapEntry = hashMapItr.next();
         System.out.print(mapEntry.getKey() + ": ");
         System.out.println(mapEntry.getValue().getMyInteger() + ", " + mapEntry.getValue().getMyString());
      }
      System.out.println();

      //
	  // Look for a specific key and if found, get its values.
	  //
      if (myHashMap.containsKey("Ayan"))
	  {
		  MyData tempObject = myHashMap.get("Ayan");
		  System.out.println("Found Ayan: " + tempObject.getMyInteger() + ", " + tempObject.getMyString());
	  }
   }
}