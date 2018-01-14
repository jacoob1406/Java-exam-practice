public class EBook extends Book
{
   private String url;

   public EBook(String url, String title, String isbn)
   {
      super(title, isbn);
      this.url = url;
   }

   public String getUrl()
   {
      return url;
   }

   public String getBookType()
   {
      return "E-book";
   }

   public String toString()
   {
      return super.toString() + "; url: " + url;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof EBook))
      {
         return false;
      }

      EBook other = (EBook) obj;
      {
         return super.equals(other) && url.equals(other.url);
      }
   }

}
