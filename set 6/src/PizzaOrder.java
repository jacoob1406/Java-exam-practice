import java.util.ArrayList;

public class PizzaOrder
{
   private ArrayList<Pizza> orders;
   private Customer customer;

   public PizzaOrder(Customer customer)
   {
      this.customer = customer;
      orders = new ArrayList<Pizza>();
   }

   public Customer getCustomer()
   {
      return customer;
   }

   public int getNumberOfPizzas()
   {
      return orders.size();
   }

   public void addPizza(Pizza pizza)
   {
      orders.add(pizza);
   }

   public Pizza getPizza(int index)
   {
      return orders.get(index);
   }

   // public Pizza getPizza (String pizzaName) //NIE DA SIÊ BEZ GETNAME
   // {
   // (orders.
   // }

   public double getTotalPrice()
   {
      double sum = 0;
      if (getCustomer() instanceof PrivilegedCustomer)
      {
         for (int i = 0; i < orders.size(); i++)
         {
            sum += orders.get(i).getTotalPrice();
         }
         sum = sum * (((PrivilegedCustomer) customer)).getDiscount();
      }
      else
      {
         for (int i = 0; i < orders.size(); i++)
         {
            sum += orders.get(i).getTotalPrice();
         }
      }
      return sum;
   }

}
