
class MyData
{
	private final int myInteger;
	private final String myString;
	
	MyData(int myInt, String myString)
	{
		this.myInteger = myInt;
		this.myString = myString;
	}
	
	public int getMyInteger()
	{
		return this.myInteger;
	}
	public String getMyString()
	{
		return this.myString;
	}
}

public class GenericBox<T> 
{
   private T t;

   public void add(T t) 
   {
      this.t = t;
   }

   public T get() 
   {
      return t;
   }

   public static void main(String[] args) 
   {
      GenericBox<Integer> integerBox = new GenericBox<Integer>();
      GenericBox<String> stringBox = new GenericBox<String>();
      GenericBox<MyData> myDataBox = new GenericBox<MyData>();
	  
      integerBox.add(new Integer(10));
      stringBox.add(new String("Hello World"));
	  myDataBox.add(new MyData(15,"fifteen"));
	  
      System.out.printf("Integer Value :%d\n", integerBox.get());
      System.out.printf("String Value :%s\n", stringBox.get());
	  System.out.printf("MyData values : %d, %s\n", myDataBox.get().getMyInteger(),myDataBox.get().getMyString()); 
   }
}