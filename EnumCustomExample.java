// Java program to demonstrate how values can 
// be assigned to enums. 
enum TrafficSignal 
{ 
    // This will call enum constructor with one 
    // String argument 
    RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN"); 
  
    // declaring private variable for getting values 
    private String description; 
  
    // getter method 
    public String getDescription() 
    { 
        return this.description; 
    } 
  
    // enum constructor - cannot be public or protected 
    private TrafficSignal(String description) 
    { 
        this.description = description; 
    } 
} 
  
// Driver code 
public class EnumCustomExample 
{ 
    public static void main(String args[]) 
    { 
        // let's print name of each enum and there action 
        // - Enum values() examples 
        TrafficSignal[] signals = TrafficSignal.values(); 
  
        for (TrafficSignal signal : signals) 
        { 
			switch (signal)
			{
				case RED:
				System.out.println(signal + " at index "
                             + signal.ordinal() + " should be RED");
				break;
				case GREEN:
				System.out.println(signal + " at index "
                             + signal.ordinal() + " should be GREEN");
				break;
				case ORANGE:
				System.out.println(signal + " at index "
                             + signal.ordinal() + " should be ORANGE");
				break;
			}
            // use getter method to get the value 
            System.out.println("name : " + signal.name() + 
                        " action: " + signal.getDescription() ); 
        } 
    } 
} 