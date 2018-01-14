import java.util.ArrayList;

public class ApartmentComplex2
{
   private String address;
   private ArrayList<Residence> residences;

   public ApartmentComplex2(String address)
   {
      this.address = address;
      residences = new ArrayList<Residence>();
   }

   public int getNumberOfResidences()
   {
      return residences.size();
   }

   public void add(Residence residence)
   {
      residences.add(residence);
   }

   public Residence getResidence(int index)
   {
      return residences.get(index);
   }

   public Residence getResidenceByNumber(int number)
   {
      Residence r = null;

      for (int i = 0; i < residences.size(); i++)
      {
         if (number == residences.get(i).getNumber())
         {
            r = residences.get(i);
         }
      }
      return r;
   }

   public Room getFirstAvailableRoom()
   {
      Room r = null;

      for (int i = 0; i < residences.size(); i++)
      {
         if (residences.get(i) instanceof Room)
         {
            if (((Room) residences.get(i)).isAvailable())
            {
               r = (Room) residences.get(i);
               break;
            }
         }
      }
      return r;
   }

   public Apartment getFirstAvailableApartment(int minNoOfRooms)
   {
      Apartment ap = null;

      for (int i = 0; i < residences.size(); i++)
      {
         if (residences.get(i) instanceof Apartment)
         {
            if (((Apartment) residences.get(i)).isAvailable())
            {
               if (minNoOfRooms <= (((Apartment) residences.get(i))
                     .getNumberOfRooms()))
               {
                  ap = (Apartment) residences.get(i);
                  break;
               }
            }
         }
      }
      return ap;
   }

}
