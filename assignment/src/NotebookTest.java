public class NotebookTest
{

   public static void main(String[] args)
   {
      MyDate date1 = new MyDate(27, 11, 1995);
      MyDate date2 = new MyDate(11, 12, 1999);
      MyDate date3 = new MyDate(17, 6, 2000);
      MyDate date4 = new MyDate(9, 1, 2016);
      MyDate date5 = new MyDate(4, 2, 1995);
      DatedNote dnote1 = new DatedNote("Allan", date1);
      DatedNote dnote2 = new DatedNote("Filip", date2);
      DatedNote dnote3 = new DatedNote("£obuz", date3);
      DatedNote dnote4 = new DatedNote("Jakub", date4);
      DatedNote dnote5 = new DatedNote("Adam", date5);
      PriorityNote pnote1 = new PriorityNote("Allan", 3);
      PriorityNote pnote2 = new PriorityNote("Filip", 2);
      PriorityNote pnote3 = new PriorityNote("£obuz", 2);
      PriorityNote pnote4 = new PriorityNote("Jakub", 1);
      PriorityNote pnote5 = new PriorityNote("Adam", 3);
      Notebook notebook1 = new Notebook(10);
      notebook1.addNote(dnote1);
      notebook1.addNote(dnote2);
      notebook1.addNote(dnote3);
      notebook1.addNote(dnote4);
      notebook1.addNote(dnote5);
      notebook1.addNote(pnote1);
      notebook1.addNote(pnote2);
      notebook1.addNote(pnote3);
      notebook1.addNote(pnote4);
      notebook1.addNote(pnote5);
      System.out.println(dnote1);
      System.out.println(pnote1);
      System.out.println(notebook1.getNumberOfPriorityNotes());
      PriorityNote[] allpn = notebook1.getPriorityNotes();
      for (int i = 0; i < allpn.length; i++)
      {
         System.out.println(allpn[i]);
      }
      System.out.println();
      System.out.println("--------------");
      System.out.println(notebook1);
      System.out.println(notebook1.getNote(14));

   }

}
