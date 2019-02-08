/*-------------------------------------------------------------------------------------------------
| *** UNCLASSIFIED ***
|--------------------------------------------------------------------------------------------------
| U.S. Army Research, Development, and Engineering Command
| Aviation and Missile Research, Development, and Engineering Center
| Software Engineering Directorate, Redstone Arsenal, AL
|--------------------------------------------------------------------------------------------------
| Export-Control Act Warning: Warning - This Document contains technical data whose export is
| restricted by the Arms Export Control Act (Title 22, U.S.C., Sec 2751, et seq) or the Export
| Administration Act of 1979, as amended, Title 50, U.S.C., App. 2401 et seq. Violations of these
| export laws are subject to severe criminal penalties. Disseminate in accordance with provisions
| of DoD Directive 5230.25.
|--------------------------------------------------------------------------------------------------
| Distribution Statement C:  Distribution authorized to U.S. Government Agencies and their
| contractors, Export Controlled, Critical Technology, 13 Feb 2017. Other request for this document
| shall be referred to U.S. Army Aviation and Missile Research Development and Engineering Center
| Software Engineering Directorate, Attn: RDMR-BAW, Redstone Arsenal, AL 35898.
--------------------------------------------------------------------------------------------------*/

public class LockingSemaphore
{
  private int signals = 0;
  private final int bound   = 1;

  public synchronized void take() throws InterruptedException
  {
    while(this.getSignals() == getBound()) wait();
    this.setSignals(this.getSignals() + 1);
    this.notify();
  }

  public synchronized void release() throws InterruptedException
  {
    while(this.getSignals() == 0) wait();
    this.setSignals(this.getSignals() - 1);
    this.notify();
  }

  public int getSignals()
  {
    return signals;
  }

  public void setSignals(int signals)
  {
    this.signals = signals;
  }

  public int getBound()
  {
    return bound;
  }
}
