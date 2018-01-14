import java.util.ArrayList;

public class Order2
{
   private int numberOfOrderLines;
   private ArrayList<OrderLine> orders;

   public Order2(int maxNumberOfOrders)
   {
      numberOfOrderLines = maxNumberOfOrders;
      orders = new ArrayList<OrderLine>(maxNumberOfOrders);
   }

   public void addOrderLine(Item item, int amount)
   {
      OrderLine ol = new OrderLine(item, amount);
      if (orders.size() < numberOfOrderLines)
         orders.add(ol);
   }

   public int getNumberOfOrderLines()
   {
      return orders.size();
   }

   public double getTotalPrice()
   {
      double total = 0;

      for (int i = 0; i < orders.size(); i++)
      {
         total += orders.get(i).getItem().getPrice()
               * orders.get(i).getAmount();
      }
      return total;
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
            sum += (((WeighedItem) orders.get(i).getItem()).getWeight());
         }
      }
      return sum;
   }

   public String toString()
   {
      String str = "";
      for (int i = 0; i < orders.size(); i++)
      {
         str += orders.get(i);
      }
      return str;
   }

}
