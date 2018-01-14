
public class PriorityNote2 extends Note2
{
private int priority;

   public PriorityNote2(String message, int priority)
   {
      // TODO Auto-generated constructor stub
      super (message);
      this.priority=priority;
   }
   
   public int getPriority()
   {
      return priority;
   }
   
   public Note2 copy()
   {
      return new PriorityNote2(getMessage(), priority);
   }
   public String toString()
   {
      return super.toString() + "; priority: " + priority;
   }
}
