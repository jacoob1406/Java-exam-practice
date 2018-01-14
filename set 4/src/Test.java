public class Test
{

   public static void main(String[] args)
   {
      Customer customer1 = new Customer("Allan", "VIA");
      Customer customer2 = new Customer("Jakub", "Gdynia");
      Customer customer3 = new Customer("Roberto", "Italia");
      Customer customer4 = new Customer("Amelia", "Paryü");

      SportsCar sc1 = new SportsCar("AQK7", 555);
      SportsCar sc2 = new SportsCar("AQF4", 666);
      SportsCar sc3 = new SportsCar("RQK1", 777);
      SportsCar sc4 = new SportsCar("ATY8", 888);

      Van van1 = new Van("KJU8", 111, 5);
      Van van2 = new Van("IUQ9", 222, 4);
      Van van3 = new Van("23DKA", 333, 3);
      Van van4 = new Van("90JFS", 444, 8);
      Van van5 = new Van("ZZZ7", 123, 9);
      Van van6 = new Van("POL9", 321, 6);

      CarRental wypoøyczalnia = new CarRental("U KUBY", "Malediwy");

      wypoøyczalnia.addCar(sc1);
      wypoøyczalnia.addCar(sc2);
      wypoøyczalnia.addCar(sc3);
      wypoøyczalnia.addCar(sc4);

      wypoøyczalnia.addCar(van1);
      wypoøyczalnia.addCar(van2);
      wypoøyczalnia.addCar(van3);
      wypoøyczalnia.addCar(van4);
      wypoøyczalnia.addCar(van5);
      wypoøyczalnia.addCar(van6);

      sc1.setRentedTo(customer1);
      sc2.setRentedTo(customer2);
      sc3.setRentedTo(customer3);
      sc4.setRentedTo(customer4);

      van1.setRentedTo(customer1);
      van2.setRentedTo(customer1);
      van3.setRentedTo(customer1);
      van4.setRentedTo(customer1);
      van5.setRentedTo(customer1);

      // System.out.println(sc3.isAvailable());
      // System.out.println(van5.isAvailable());
      // System.out.println(van6.isAvailable());

      // System.out.println(van1.getRentedTo());
      
     // System.out.println(sc2.getType());
      
      System.out.println(wypoøyczalnia.getAvailableSportsCar());
      System.out.println(wypoøyczalnia.getAvailableVan(8));
      
      System.out.println();
      System.out.println("---------------");
      System.out.println(wypoøyczalnia.getCarByLicense("POL9"));
   }

}
