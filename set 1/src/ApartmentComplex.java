import java.util.ArrayList;

public class ApartmentComplex
{
   private String address;
   private ArrayList<Residence> residences;

   public ApartmentComplex(String address)
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
      Residence temp = null;
      for (int i = 0; i < residences.size(); i++)
      {
         if (number == residences.get(i).getNumber())
            temp = residences.get(i);
      }

      return temp;
   }

   // public Room getFirstAvailableRoom2 ()
   // {
   // Room r = null;
   // for (int i = 0; i < residences.size(); i++)
   // {
   // if (residences.get(i) instanceof Room)
   // {
   // if (((Room) residences.get(i)).isAvailable())
   // {
   // r = (Room) residences.get(i);
   // break;
   // }
   // }
   // }
   // return r;
   // }
   //

   public Apartment getFirstAvailableApartment2(int minNoOfRooms)
   {
      Apartment a = null;

      for (int i = 0; i < residences.size(); i++)
      {
         if (residences.get(i) instanceof Apartment)
         {
            if (((Apartment) residences.get(i)).isAvailable())
            {
               if (((Apartment) residences.get(i)).getNumberOfRooms() >= minNoOfRooms)
               {
                  a = (Apartment) residences.get(i);
                  break;
               }
            }
         }
      }
      return a;
   }

   public Room getFirsAvailableRoom()
   {
      Room temp = null;
      for (int i = 0; i < residences.size(); i++)
      {
         if (residences.get(i) instanceof Room)
         {
            if (((Room) residences.get(i)).isAvailable())
            {
               temp = (Room) residences.get(i);
               break; // ?????
            }
         }
      }
      return temp;
   }

   public Apartment getFirstAvailableApartment(int minNumOfRooms)
   {
      Apartment temp = null;
      for (int i = 0; i < residences.size(); i++)
      {
         if (residences.get(i) instanceof Apartment)
         {
            if (((Apartment) residences.get(i)).isAvailable())
            {
               if (minNumOfRooms <= (((Apartment) residences.get(i))
                     .getNumberOfRooms()))
               {
                  temp = (Apartment) residences.get(i);
                  break;
               }
            }
         }
      }
      return temp;
   }

}
