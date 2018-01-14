import java.util.ArrayList;

public class CarRental
{
   private String companyName;
   private String address;
   private ArrayList<Car> carsForRent;

   public CarRental(String companyName, String address)
   {
      this.companyName = companyName;
      this.address = address;
      carsForRent = new ArrayList<Car>();
   }

   public String getCompanyName()
   {
      return companyName;
   }

   public String getAddress()
   {
      return address;
   }

   public int getNumberOfCars()
   {
      return carsForRent.size();
   }

   public Car getCar(int index)
   {
      return carsForRent.get(index);
   }

   public void addCar(Car car)
   {
      carsForRent.add(car);
   }

   public Car getCarByLicense(String licenseNo)
   {
      Car c = null;
      for (int i = 0; i < carsForRent.size(); i++)
      {
         if (licenseNo.equals(carsForRent.get(i).getLicenseNo()))
         {
            c = carsForRent.get(i);
         }
      }
      return c;
   }

   public SportsCar getAvailableSportsCar()
   {
      SportsCar sc = null;
      for (int i = 0; i < carsForRent.size(); i++)
      {
         if (carsForRent.get(i) instanceof SportsCar)
         {
            if (((SportsCar) carsForRent.get(i)).isAvailable())
            {
               sc = (SportsCar) carsForRent.get(i);
            }
         }
      }
      return sc;
   }

   public Van getAvailableVan(int minCapacity)
   {
      Van v = null;

      for (int i = 0; i < carsForRent.size(); i++)
      {
         if (carsForRent.get(i) instanceof Van)
         {
            if (((Van) carsForRent.get(i)).isAvailable())
            {
               if (minCapacity <= (((Van) carsForRent.get(i)).getCapacity()))
               {
                  v = (Van) carsForRent.get(i);
               }
            }
         }
      }
      return v;
   }

}
