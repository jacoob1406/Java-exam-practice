import java.util.ArrayList;

public class Order
{
   private int numberOfOrders;
   private ArrayList<OrderLine> orders;

   public Order(int maxNumerOfOrders)
   {
      numberOfOrders = maxNumerOfOrders;
      orders = new ArrayList<OrderLine>(maxNumerOfOrders);
   }

   // moje do testu

   public void add(OrderLine ol)
   {
      orders.add(ol);
   }

   public void addOrderLine(Item item, int amount)
   {
      OrderLine ol = new OrderLine(item, amount);
      orders.add(ol);
   }

   public int getNumOfOrderLines()
   {
      return orders.size();
   }

   public double getTotalPrice()
   {
      double sum = 0;
      for (int i = 0; i < orders.size(); i++)
      {
         sum += orders.get(i).getItem().getPrice() * orders.get(i).getAmount();
      }
      return sum;
   }

   public Item getOrderItem(int orderLineIndex)

   {
      return orders.get(orderLineIndex).getItem();
   }

   public int getAmountOfOrderItem(int orderLineIndex)
   {
      return orders.get(orderLineIndex).getAmount();
   }

   public double getTotalWeightForWeightedItems()
   {
      double sum = 0;
      for (int i = 0; i < orders.size(); i++)
      {
         if (orders.get(i).getItem() instanceof WeighedItem)
         {
            sum += ((WeighedItem) orders.get(i).getItem()).getWeight();
         }
      }
      return sum;
   }

   public String toString()
   {
      String str = "";

      for (int i = 0; i < orders.size(); i++)
      {
         str += orders.get(i) + "\n";
      }
      return str;
   }
}
