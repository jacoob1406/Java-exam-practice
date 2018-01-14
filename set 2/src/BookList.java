import java.util.ArrayList;

public class BookList
{
   private ArrayList<Book> lista;

   public BookList()
   {
      lista = new ArrayList<Book>();
   }

   public int getNumOfBooks()
   {
      return lista.size();
   }

   public void addBook(Book book)
   {
      lista.add(book);
   }

   public Book getBook(int index)
   {
      return lista.get(index);
   }

   public Book getBook(String isbn)
   {
      Book b = null;
      for (int i = 0; i < lista.size(); i++)
      {
         if (isbn.equals(lista.get(i).getIsbn()))
            b = lista.get(i);
      }
      return b;
   }

   public void removeBook(int index)
   {
      lista.remove(index);
   }

   public int getIndexOfFirstPrintedBook()
   {
      int index = 00;

      for (int i = 0; i < lista.size(); i++)
      {
         if (lista.get(i) instanceof PrintedBook)
         {
            index = i;
            break;
         }
      }
      return index;
   }

   public int getNumOfBooksByType(String bookType)
   {
      int sum = 0;

      for (int i = 0; i < lista.size(); i++)
      {
         if (bookType.equals(lista.get(i).getBookType()))
            sum++;
      }
      return sum;
   }


   public Book[] getBooksByType(String bookType)
   {
      ArrayList<Book> books = new ArrayList<Book>();

      for (int i = 0; i < lista.size(); i++)
      {
         if (bookType.equals(lista.get(i).getBookType()))
         {
            books.add(lista.get(i));
         }
      }
      Book[] books2 = new Book[books.size()];
      return books.toArray(books2);
   }

   public EBook[] getAllEbooks()
   {
      ArrayList<EBook> ebuki = new ArrayList<EBook>();

      for (int i = 0; i < lista.size(); i++)
      {
         if (lista.get(i) instanceof EBook)
         {
            ebuki.add((EBook) lista.get(i));
         }
      }
      EBook[] ebuczki = new EBook[ebuki.size()];
      return ebuki.toArray(ebuczki);
   }

   public String toString()
   {
      String str = "";
      for (int i = 0; i < lista.size(); i++)
      {
         str += lista.get(i);
      }
      return str;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof BookList))
      {
         return false;
      }

      BookList other = (BookList) obj;

      return lista.equals(other.lista);
   }

}
