public class AviPlayer implements AdvancedMediaPlayer
{
   @Override
   public void playAvi(String fileName) 
   {
      System.out.println("Playing avi file. Name: "+ fileName);		
   }

   @Override
   public void playMp4(String fileName) 
   {
      //do nothing
   }
   @Override
   public void playVlc(String fileName) 
   {
      //do nothing
   }
}