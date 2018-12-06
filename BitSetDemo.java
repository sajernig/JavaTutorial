import java.util.BitSet;
public class BitSetDemo 
{
  private static class ConvertBitSetToString
  {
	  String bitSetString = "";
	  BitSet localBitSet;
	  
	  public void setBitSet(BitSet value)
	  {
		  localBitSet = value;
	  }
	  
	  public String ConvertBitSet()
	  {
		  //
	      // Construct a string to hold the binary BitSet.
	      //
		  bitSetString = "";
	      for (int i = 0; i < localBitSet.length()+1; i++)
	      {
		      if (localBitSet.get(i))
		      {
			      bitSetString = bitSetString + "1";
		      }
		      else
		      {
			      bitSetString = bitSetString + "0";
		      }
		   }
		   return(bitSetString);
	     }
	}
	
  
  public static void main(String args[]) 
  {
      BitSet bits1 = new BitSet(16);
      BitSet bits2 = new BitSet(16);
      ConvertBitSetToString convertToString = new ConvertBitSetToString();
	  
      // set some bits
      for(int i = 0; i < 16; i++) 
	  {
         if((i % 2) == 0) bits1.set(i);
         if((i % 5) != 0) bits2.set(i);
      }
     
	  //
	  // Construct a string to hold the binary BitSet.
	  //
	  convertToString.setBitSet(bits1);
	  String bitString = convertToString.ConvertBitSet();
	  System.out.println("bitString = " + bitString);
	  
	  //
	  // Convert the binary string to a hex string.
	  //
	  int decimal = Integer.parseInt(bitString,2);
      String hexStr = Integer.toString(decimal,16);
      System.out.println("bitString  as hex = " + hexStr); 
	 
      //
      // Get the first byte
	  //
	  BitSet firstByte = bits1.get(0, 3);
	  convertToString.setBitSet(firstByte);
	  bitString = convertToString.ConvertBitSet();
	  System.out.println("first byte = " + bitString);
	  
	  
	  
	  
	  
      System.out.println("Initial pattern in bits1: ");
      System.out.println(bits1);
      System.out.println("\nInitial pattern in bits2: ");
      System.out.println(bits2);

      // AND bits
      bits2.and(bits1);
      System.out.println("\nbits2 AND bits1: ");
      System.out.println(bits2);

      // OR bits
      bits2.or(bits1);
      System.out.println("\nbits2 OR bits1: ");
      System.out.println(bits2);

      // XOR bits
      bits2.xor(bits1);
      System.out.println("\nbits2 XOR bits1: ");
      System.out.println(bits2);
   }
}