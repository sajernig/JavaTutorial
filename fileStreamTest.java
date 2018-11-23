import java.io.*;
public class fileStreamTest 
{

   static String readFile(String fileName) throws IOException 
   {
    try 
	{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
	    StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) 
		{
            sb.append(line);
            line = br.readLine();
			if (line != null) {	sb.append("\n"); }
        }
		br.close();
        return sb.toString();
    } 
	catch (IOException e) { System.out.print("Exception"); }
    return "";	
   }
   
   public static void main(String args[]) 
   {
      String myString = "test String to output\nline2";
   
      try 
	  {
		// Write the string
		PrintWriter out = new PrintWriter("output.txt");
		out.println(myString);
		out.close();
      } 
	  catch (IOException e) { System.out.print("Exception"); }	

     try 
	  {
		// Read the string
		String inputString = readFile("output.txt");
		System.out.println(myString);
		System.out.println(inputString);
		if (inputString.equals(myString))
		{
			System.out.println("Strings match!");
		}
		else
		{
			System.out.println("Strings do not mmatch.");			
		}
      } 
	  catch (IOException e) { System.out.print("Exception"); }		  
 }
}