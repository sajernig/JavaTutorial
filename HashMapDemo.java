import java.util.*;
//
// Using Generics...
//
public class HashMapDemo {

   public static void main(String[] args) {
      Map<String,Integer> m1 = new HashMap<String, Integer>(); 
	  
	  //
	  // Define the mapping.
	  //
      m1.put("Zara", 8);
      m1.put("Mahnaz", 31);
      m1.put("Ayan", 12);
      m1.put("Daisy", 14);

      System.out.println();
      System.out.println(" Map Elements");
      System.out.print("\t" + m1);
	  System.out.println("\n");
	  
	  //
	  // Iterate through the mapping...
	  //
      Iterator<Map.Entry<String, Integer>> entries = m1.entrySet().iterator();
      while (entries.hasNext()) 
	  {
         Map.Entry<String, Integer> entry = entries.next();
         System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
      }

	  //
	  // Look for a specific key in the mapping and retrieve its value.
	  //
	  if (m1.containsKey("Zara"))
	  {
		  System.out.println("\n");
		  System.out.println("Found Zara! Value = " + m1.get("Zara").toString());
	  }
	  
	  //
	  // Look for a key that is not in the mapping.
	  //
	  try
	  {
		  Integer testValue = m1.get("NotFound");
		  if (testValue == null)
		  {
			System.out.println("Failure to find NotFound. Value returned as null.");
		  }
		  else
		  {
			  System.out.println("NotFound was found?. Value = " + testValue.toString());
		  }
	  }
      catch(Exception excpt){ System.out.println(excpt.toString()); }
   }
}