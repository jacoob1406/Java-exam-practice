
public class Test
{

   public static void main(String[] args)
   {
      MyDate date1 = new MyDate(27, 11, 1995);
      MyDate date2 = new MyDate(11, 05, 1997);
      
      Tenant tenant1 = new Tenant("Allan");
      Tenant tenant2 = new Tenant("Jakub");
      
      Room room1 = new Room(4, 3);
      Room room2 = new Room(5, 2);
      Room room3 = new Room(8, 2);
      
      Apartment apartment1 = new Apartment(1, 3, 3);
      Apartment apartment2 = new Apartment(2, 6, 2);
      Apartment apartment3 = new Apartment(3, 7, 6);
      Apartment apartment4 = new Apartment(9, 2, 3);
      
      ApartmentComplex complex1 = new ApartmentComplex("jfsjfab");
      
      room1.rentTo(tenant1, date1);
      room2.rentTo(tenant2, date2);
      
      apartment1.rentTo(tenant1, date1);
      apartment2.rentTo(tenant2, date2);
      
      complex1.add(room1);
      complex1.add(room2);
      complex1.add(apartment1);
      complex1.add(apartment2);
      complex1.add(room3);
      complex1.add(apartment3);
      complex1.add(apartment4);
      
      
      System.out.println(tenant1.getRentedFrom().getDay());
      System.out.println(tenant2.getRentedFrom());
      System.out.println(complex1.getNumberOfResidences());
      System.out.println(complex1.getResidence(0));
      System.out.println(complex1.getResidenceByNumber(4));
      System.out.println();
      System.out.println("--------------");
      System.out.println(apartment3);
      System.out.println(complex1.getFirstAvailableApartment(2));


   }

}
