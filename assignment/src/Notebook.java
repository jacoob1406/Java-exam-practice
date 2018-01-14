import java.util.ArrayList;

public class Notebook
{
   private int numberOfNotes;
   private ArrayList<Note> notes;

   public Notebook(int maxNumberOfNotes)
   {
      numberOfNotes = maxNumberOfNotes;
      notes = new ArrayList<Note>(maxNumberOfNotes);
   }

   public void addNote(Note note)
   {
      if(notes.size()< numberOfNotes)
         notes.add(note);
   }

   public void setNote(Note note, int index)
   {
      notes.set(index, note);
   }

   public void removeNote(int index)
   {
      notes.remove(index);
   }

   public Note getNote(int index)
   {
      if(index<notes.size())
      {
         return notes.get(index).copy();
      }
      else
      
      return null;
   }

   public int getNumberOfPriorityNotes()
   {
      int sum = 0;
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote)
            sum++;
      }
      return sum;
   }

   public PriorityNote[] getPriorityNotes()
   {
      int counter = 0;

      PriorityNote[] allPrioNotes = new PriorityNote[getNumberOfPriorityNotes()];
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote)
         {
            if (((PriorityNote) notes.get(i)).getPriority() == 1)
            {
               allPrioNotes[counter++] = (PriorityNote) notes.get(i);
            }
         }
      }
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote)
         {
            if (((PriorityNote) notes.get(i)).getPriority() == 2)
            {
               allPrioNotes[counter++] = (PriorityNote) notes.get(i);
            }
         }
      }
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote)
         {
            if (((PriorityNote) notes.get(i)).getPriority() == 3)
            {
               allPrioNotes[counter++] = (PriorityNote) notes.get(i);
            }
         }
      }

      return allPrioNotes;
   }

   public String toString()
   {
      String str = "";

      for (int i = 0; i < notes.size(); i++)
      {
         str += notes.get(i) + "\n";
      }
      return str;
   }
}
