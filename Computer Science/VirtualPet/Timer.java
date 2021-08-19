package VirtualPet;


/**
 * Used for the Bathroom Status.
 * And so the user knows how long
 * they kept the pet alive.
 */
public class Timer
{
  //Attributes
  long startTime = 0;
  long stopTime = 0;
  long elapsedTime = 0;
  long startTime1 = 0;
  long stopTime1 = 0;
   long startTime2 = 0;
  long stopTime2 = 0;
  //Behaviors
  public void start()
  {
      startTime = System.currentTimeMillis();
    } 
  public void stop()
  {
      stopTime = System.currentTimeMillis();
    } 
  public long elapsedTime()
  {
      elapsedTime = System.currentTimeMillis() - startTime;
      //Start here tomorrow
      elapsedTime = elapsedTime/1000;
     return elapsedTime;
    }
  public void start1()
  {
      startTime1 = System.currentTimeMillis();
    }
  public void stop1()
  {
      stopTime1 = System.currentTimeMillis();
    }
     public void start2()
  {
      startTime2 = System.currentTimeMillis();
    }
  public void stop2()
  {
      stopTime2 = System.currentTimeMillis();
    }
}