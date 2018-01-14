public class MyDate2
{
   private int day;
   private int month;
   private int year;

   public MyDate2(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }

   public int getDay()
   {
      return day;
   }

   public int getMonth()
   {
      return month;
   }

   public int getYear()
   {
      return year;
   }

   public MyDate2 copy()
   {
      return new MyDate2 (day, month, year);
   }

   public String toString()
   {
      return day + "/" + month + "/" + year;
   }

}
