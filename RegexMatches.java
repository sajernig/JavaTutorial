import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

   private static final String REGEX = "\\bcat\\b";
   private static final String INPUT = "cat cat cat cattie cat";

   private static final String REGEX_FOO = "foo";
   private static final String INPUT_FOO = "fooooooooooooooooo";
   private static Pattern patternFoo;
   private static Matcher matcherFoo;
   
   private static String REGEX_REPLACE = "dog";
   private static String INPUT_REPLACE = "The dog says meow. " + "All dogs say meow.";
   private static String REPLACE = "cat";
   
   private static String REGEX_APPREPLACE = "a*b";
   private static String INPUT_APPREPLACE = "aabfooaabfooabfoob";
   private static String REPLACE_APPREPLACE = "-";
   
   public static void main( String args[] ) {
      Pattern p = Pattern.compile(REGEX);
      Matcher m = p.matcher(INPUT);   // get a matcher object
      int count = 0;

      while(m.find()) {
         count++;
         System.out.println("Match number "+count);
         System.out.println("start(): "+m.start());
         System.out.println("end(): "+m.end());
      }
	  
	  // matches and lookingAt
	  patternFoo = Pattern.compile(REGEX_FOO);
      matcherFoo = patternFoo.matcher(INPUT_FOO);

      System.out.println("Current REGEX is: "+REGEX_FOO);
      System.out.println("Current INPUT is: "+INPUT_FOO);

      System.out.println("lookingAt(): "+matcherFoo.lookingAt());
      System.out.println("matches(): "+matcherFoo.matches());
	  
	  // Replacing text wholesale using RegEx
      System.out.println("Before string = " + INPUT_REPLACE);
      p = Pattern.compile(REGEX_REPLACE);
      m = p.matcher(INPUT_REPLACE); 
      INPUT_REPLACE = m.replaceAll(REPLACE);
      System.out.println("After string = " + INPUT_REPLACE);
	  
	  // Replacing text and appending to new string
	  p = Pattern.compile(REGEX_APPREPLACE);
      
      // get a matcher object
      System.out.println("Before string = " + INPUT_APPREPLACE);
      m = p.matcher(INPUT_APPREPLACE);
      StringBuffer sb = new StringBuffer();
      while(m.find()) {
         m.appendReplacement(sb, REPLACE_APPREPLACE);
      }
      m.appendTail(sb);
      System.out.println("After string = " + sb.toString());
   }
}