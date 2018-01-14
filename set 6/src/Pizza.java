import java.util.ArrayList;

public class Pizza
{
   private String name;
   private double initialPrice;
   private int numberOfToppings;
   private static final int MAX_NUMBER_OF_TOPPINGS = 5;
   private ArrayList<Topping> toppings;

   public Pizza(String name, double initialPrice)
   {
      this.name = name;
      this.initialPrice = initialPrice;
      toppings = new ArrayList<Topping>(MAX_NUMBER_OF_TOPPINGS);
   }

   public int getNumberOfToppings()
   {
      return toppings.size();
   }

   public void addTopping(Topping topping)
   {
      if (toppings.size()<=MAX_NUMBER_OF_TOPPINGS)
      toppings.add(topping);
   }

   public void removeTopping(String toppingName)
   {
      toppings.remove(toppingName);
   }

   public double getTotalPrice()
   {
      double sum = initialPrice;
      for (int i = 0; i < toppings.size(); i++)
      {
         sum += toppings.get(i).getPrice();
      }
      return sum;
   }

}
