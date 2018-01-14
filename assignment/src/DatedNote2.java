
public class DatedNote2 extends Note2
{
private MyDate2 date;

   public DatedNote2(String message, MyDate2 date)
   {
      super (message);
      this.date = date;
   }
   
   public MyDate2 getDate()
   {
      return date.copy();
   }
   
   public Note2 copy()
   {
      return new DatedNote2(getMessage(), date);
   }
   
   public String toString()
   {
      return super.toString() + "; date: " + date;
   }

}
