import java.util.ArrayList;

public class BookList2
{
   private ArrayList<Book> books;

   public BookList2()
   {
      books = new ArrayList<Book>();
   }

   public int getNumberOfBook()
   {
      return books.size();
   }

   public void addBook(Book book)
   {
      books.add(book);
   }

   public Book getBook(int index)
   {
      return books.get(index);
   }

   public Book getBook(String isbn)
   {
      Book b = null;
      for (int i = 0; i < books.size(); i++)
      {
         if (isbn.equals(books.get(i).getIsbn()))
         {
            b = books.get(i);
         }
      }
      return b;
   }

   public void removeBook(int index) // ?? void? book?
   {
      books.remove(index);
   }

   public int getIndexOfFirstPrintedBook()
   {
      int temp = 0;

      for (int i = 0; i < books.size(); i++)
      {
         if (books.get(i) instanceof PrintedBook)
         {
            temp = i;
            break;
         }
      }
      return temp;
   }

   public int getNumberOfBooksByType(String bookType)
   {
      int sum = 0;

      for (int i = 0; i < books.size(); i++)
      {
         if (bookType.equals(books.get(i).getBookType()))
         {
            sum++;
         }
      }
      return sum;
   }

   public Book[] getBooksByType(String bookType)
   {
      ArrayList<Book> temp = new ArrayList<Book>();

      for (int i = 0; i < books.size(); i++)
      {
         if (bookType.equals(books.get(i).getBookType()))
         {
            temp.add(books.get(i));
         }
      }
      Book[] fin = new Book[temp.size()];
      return temp.toArray(fin);
   }

   public EBook[] getAllEBooks()
   {
      int count = 0;
      for (int i = 0; i < books.size(); i++)
      {
         if (books.get(i) instanceof EBook)
         {
            count++;
         }
      }
      EBook[] ebuki = new EBook[count];

      int count2 = 0;

      for (int i = 0; i < books.size(); i++)
      {
         if (books.get(i) instanceof EBook)
         {
            ebuki[count2] = (EBook) books.get(i);
            count2++;
         }
      }
      return ebuki;
   }

   public String toString()
   {
      String str = "";

      for (int i = 0; i < books.size(); i++)
      {
         str += books.get(i) + "\n";
      }
      return str;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof BookList2))
      {
         return false;
      }

      BookList2 other = (BookList2) obj;

      return books.equals(other.books);
   }
}
