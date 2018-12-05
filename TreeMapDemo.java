import java.util.*;
public class TreeMapDemo 
{
   public static void main(String args[]) 
   { 
	  //
      // Create a tree map.
	  //
      TreeMap<String, Double> treeMap = new TreeMap<String, Double>();
      
	  //
      // Put elements to the map. TreeMap will assure Ascending key order.
	  //
      treeMap.put("Zara", new Double(3434.34));
      treeMap.put("Mahnaz", new Double(123.22));
      treeMap.put("Ayan", new Double(1378.00));
      treeMap.put("Daisy", new Double(99.22));
      treeMap.put("Qadir", new Double(-19.08));
      
	  //
      // Get a set of the entries and the iterator.
	  //
      Set<Map.Entry<String,Double>> set = treeMap.entrySet();
      Iterator<Map.Entry<String,Double>> treeMapItr = set.iterator();
      
	  //
      // Display elements...
	  //
      while(treeMapItr.hasNext()) 
	  {
         Map.Entry<String, Double> myTreeMapEntry = treeMapItr.next();
         System.out.print(myTreeMapEntry.getKey() + ": ");
         System.out.println(myTreeMapEntry.getValue());
      }
      System.out.println();
      
	  //
      // Deposit 1000 into Zara's account
	  //
      double balance = treeMap.get("Zara").doubleValue();
      treeMap.put("Zara", new Double(balance + 1000));
      System.out.println("Zara's new balance: " + treeMap.get("Zara"));
   }
}