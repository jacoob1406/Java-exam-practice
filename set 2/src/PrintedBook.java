public class PrintedBook extends Book
{
   private boolean isPaperback;

   public PrintedBook(String title, String isbn, boolean isPaperback)
   {
      super(title, isbn);
      this.isPaperback = isPaperback;
   }

   public boolean isPaperback()
   {
      if (isPaperback)
         return true;
      else
         return false;
   }

   public String getBookType()
   {
      if (isPaperback() == true)
      {
         return "Paperback";
      }
      else
      {
         return "Hard cover";
      }
   }

   public String toString()
   {
      return super.toString() + "is paperback? :" + isPaperback;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof PrintedBook))
      {
         return false;
      }

      PrintedBook other = (PrintedBook) obj;

      return super.equals(other) && isPaperback == other.isPaperback;
   }

}
