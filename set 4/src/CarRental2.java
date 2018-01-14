import java.util.ArrayList;

public class CarRental2
{
   private String companyName;
   private String address;
   private ArrayList<Car> cars;

   public CarRental2()
   {
      this.companyName = companyName;
      this.address = address;
      cars = new ArrayList<Car>();
   }

   public String getCompanyName()
   {
      return companyName;
   }

   public String getAddress()
   {
      return address;
   }

   public int getNumOfCars()
   {
      return cars.size();
   }

   public Car getCar(int index)
   {
      return cars.get(index);
   }

   public void addCar(Car car)
   {
      cars.add(car);
   }

   public Car getCarByLicense(String licenseNo)
   {
      Car c = null;
      for (int i = 0; i < cars.size(); i++)
      {
         if (licenseNo.equals(cars.get(i).getLicenseNo()))
         {
            c = cars.get(i);
            break; //?
         }
      }
      return c;
   }
   
   
   public SportsCar getAvailableSportsCar()
   {
      SportsCar sc = null;
      
      for (int i = 0; i < cars.size(); i++)
      {
         if (cars.get(i) instanceof SportsCar)
         {
            if (((SportsCar) cars.get(i)).isAvailable())
            {
               sc = (SportsCar) cars.get(i);
            }
         }
      }
      return sc;
   }
   
   public Van getAvailableVan(int minCapacity)
   {
      Van v = null;
      
      for (int i = 0; i < cars.size(); i++)
      {
         if (cars.get(i) instanceof Van)
         {
            if (minCapacity<= (((Van)cars.get(i)).getCapacity()))
            {
               v = (Van) cars.get(i);
            }
         }
      }
      return v;
   }
   
   
}
