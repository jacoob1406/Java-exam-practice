
public abstract class Note2
{
private String message;

   public Note2(String message)
   {
      this.message=message;
   }
   
   public String getMessage()
   {
      return message;
   }
   
   public abstract Note2 copy();
   
   public String toString()
   {
      return "Message: " + message;
   }

}
