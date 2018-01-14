
public class Test
{

   public static void main (String[] args)
   {
      PrintedBook book1 = new PrintedBook("HP", "fdaf32", true);
      PrintedBook book2 = new PrintedBook("LOTR", "r23fvd", true);
      PrintedBook book3 = new PrintedBook("SW", "sdg3", true);
      PrintedBook book4 = new PrintedBook("LA LA LAND <3", "fdsfs23", false);
      
      EBook ebuk1 = new EBook("fdsew32", "allan", "fesdfewe");
      EBook ebuk2 = new EBook("fsd2few", "jakub", "f32fwe");
      EBook ebuk3 = new EBook("fasfa", "anna", "fewsd");
      
      BookList2 lista = new BookList2();
      
      lista.addBook(book1);
      lista.addBook(book2);
      lista.addBook(book3);
      lista.addBook(book4);
      lista.addBook(ebuk1);
      lista.addBook(ebuk2);
      lista.addBook(ebuk3);

      
      System.out.println(lista.getNumberOfBook());
      System.out.println(lista.getBook(1));
      System.out.println(lista.getBook("fdsfs23"));
      System.out.println();
      System.out.println("---------------------");
      Book[] allbooks = lista.getBooksByType("Paperback");
      for (int i = 0; i < allbooks.length; i++)
      {
         System.out.println(allbooks[i]);
      }
      System.out.println();
      System.out.println("---------------------");
      EBook[] allebuks = lista.getAllEBooks();
      for (int i = 0; i < allebuks.length; i++)
      {
         System.out.println(allebuks[i]);
      }
      
      
      
      
   }

}
