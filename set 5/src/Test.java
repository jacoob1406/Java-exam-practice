
public class Test
{

   public static void main(String[] args)
   {
      WeighedItem wi1 = new WeighedItem("first", 1, 1);
      WeighedItem wi2 = new WeighedItem("second", 2, 2);
      WeighedItem wi3 = new WeighedItem("third", 3, 3);
      WeighedItem wi4 = new WeighedItem("fourth", 4, 4);
      WeighedItem wi5 = new WeighedItem("fivth", 5, 5);
      WeighedItem wi6 = new WeighedItem("sixth", 6, 6);
      
      UnitItem unit1 = new UnitItem("uno", 111);
      UnitItem unit2 = new UnitItem("dos", 222);
      UnitItem unit3 = new UnitItem("tres", 333);
      
      OrderLine ol1 = new OrderLine(wi1, 10);
      OrderLine ol2 = new OrderLine(wi2, 10);
      OrderLine ol3 = new OrderLine(wi3, 10);
      OrderLine ol4 = new OrderLine(wi4, 10);
      OrderLine ol5 = new OrderLine(wi5, 10);
      OrderLine ol6 = new OrderLine(wi6, 10);
      OrderLine ol7 = new OrderLine(unit1, 10);
      OrderLine ol8 = new OrderLine(unit2, 10);
      OrderLine ol9 = new OrderLine(unit3, 10);
      
      Order order1 = new Order(15);
      
      order1.add(ol1);
      order1.add(ol2);
      order1.add(ol3);
      order1.add(ol4);
      order1.add(ol5);
      order1.add(ol6);
      order1.add(ol7);
      order1.add(ol8);
      order1.add(ol9);
      
     // System.out.println(order1.getAmountOfOrderItem(6));
//      System.out.println(order1.getTotalPrice());
//      System.out.println(order1.getNumOfOrderLines());
//      System.out.println(order1.getTotalWeightForWeightedItems());
      System.out.println(order1);
   }

}
