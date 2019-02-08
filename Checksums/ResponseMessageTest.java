import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ResponseMessageTest
{
  public static byte CalculateGyrocamCheckSum( byte[] bytes )
  {
    byte checkSum = 0, i = 0; // Must be declared as byte to get -128 to 127 range.
    for( i = 0; i < bytes.length; i++)
    {
      checkSum += (byte)(bytes[i] & 0xFF); // restrict to 8-bits discarding overflow
    }
    checkSum = (byte)((~(checkSum & 0xFF) + 1) & 0xFF); // take 2's compliment

    return(checkSum);
  }

  public static byte[] asBytes (String s) {
    String tmp;
    byte[] b = new byte[s.length() / 2];
    int i;
    for (i = 0; i < s.length() / 2; i++) {
      tmp = s.substring(i * 2, i * 2 + 2);
      b[i] = (byte)(Integer.parseInt(tmp, 16) & 0xff);
    }
    return b;                                            //return bytes
  }

  private static void checkChecksums()
  {
    ArrayList<String> filesToRead = new ArrayList<String>();
    filesToRead.add("c:/temp/IR_Azimuth Test 1.txt");
    filesToRead.add("c:/temp/IR_Elevation Test 1.txt");
    filesToRead.add("c:/temp/IR_Zoom Test 1.txt");
    filesToRead.add("c:/temp/Narrow_Zoom Test 1.txt");
    filesToRead.add("c:/temp/Switch_Zoom Test 1.txt");
    filesToRead.add("c:/temp/Wide_Zoom Test 1.txt");

    for (String filename : filesToRead)
    {
      File fin = new File(filename);
      try
      {
        readResponseFile(fin);
      }
      catch (IOException ex)
      {
      }
    }
  }

  private static boolean validateChecksumRange(short checksum)
  {
    boolean validated = true;

    if ((checksum < -128) || (checksum > 127))
    {
      validated = false;
    }

    return validated;
  }

  private static void readResponseFile(File fin) throws IOException
  {
    byte[] packet = null;
    short inputChecksum;
    short calcChecksum;
    int successfulChecksums = 0;
    int numAttempts = 0;

    // Construct BufferedReader from FileReader
    BufferedReader br = new BufferedReader(new FileReader(fin));

    String line = null;
    while ((line = br.readLine()) != null)
    {
      packet = asBytes(line);
      if (packet.length == 52)
      {
        numAttempts++;
        inputChecksum = packet[51];
        if (!validateChecksumRange(inputChecksum))
        {
          System.out.println("checksum is out of acceptable range: " + inputChecksum);
        }
        packet[51] = 0;
        calcChecksum = CalculateGyrocamCheckSum(packet);
        if (calcChecksum != inputChecksum)
        {
          System.out.println("Checksums do not match: input = " + inputChecksum + " calc = " + calcChecksum);
        }
        else
        {
          successfulChecksums++;
        }
      }
    }

    System.out.println("We had " + successfulChecksums + " successful checksums out of " + numAttempts);
    br.close();
  }
  
  public static void main(String args[]) 
  {
      checkChecksums();
   }
}