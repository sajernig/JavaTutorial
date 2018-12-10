import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest
{
  @Test
  public void testSetState()
  {
    Subject subject = new Subject();

    HexaObserver hexaObserver = new HexaObserver(subject);
    OctalObserver octalObserver = new OctalObserver(subject);
    BinaryObserver binaryObserver = new BinaryObserver(subject);

    System.out.println("First state change: 15");
    subject.setState(15);
    System.out.println("Second state change: 10");
    subject.setState(10);
  }
}