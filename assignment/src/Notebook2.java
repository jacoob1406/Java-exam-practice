import java.util.ArrayList;


public class Notebook2
{
   private ArrayList<Note2> notes;
   private int numberOfNotes;

   public Notebook2(int maxnumberOfNotes)
   {
      numberOfNotes = maxnumberOfNotes;
      notes = new ArrayList<Note2>(maxnumberOfNotes);
   }

   public void addNote(Note2 note)
   {
      if (notes.size() < numberOfNotes)
         notes.add(note);
   }

   public void setNote(Note2 note, int index)
   {
      notes.set(index, note);
   }

   public void removeNote(int index)
   {
      notes.remove(index);
   }

   public Note2 getNote(int index)
   {
      if (index < notes.size())
      {
         return notes.get(index).copy();
      }
      else

         return null;
   }
   
   public int getNumOfPrioNotes()
   {
      int count=0;
      
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote2 )
            count++;
      }
      
      return count;
   }
   
   public PriorityNote[] getPriorityNotes()
   {
      int counter = 0;

      PriorityNote[] allPrioNotes = new PriorityNote[getNumOfPrioNotes()];
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote2)
         {
            if (((PriorityNote2) notes.get(i)).getPriority() == 1)
            {
               allPrioNotes[counter++] = (PriorityNote2) notes.get(i);
            }
         }
      }
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote2)
         {
            if (((PriorityNote2) notes.get(i)).getPriority() == 2)
            {
               allPrioNotes[counter++] = (PriorityNote2) notes.get(i);
            }
         }
      }
      for (int i = 0; i < notes.size(); i++)
      {
         if (notes.get(i) instanceof PriorityNote2)
         {
            if (((PriorityNote2) notes.get(i)).getPriority() == 3)
            {
               allPrioNotes[counter++] = (PriorityNote2) notes.get(i);
            }
         }
      }

      return allPrioNotes;
   }

}
