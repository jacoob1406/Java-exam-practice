
public class Test
{

   public static void main(String[] args)
   {
      Topping topping1 = new Topping("czosnkowy", 2);
      Topping topping2 = new Topping("pomidorowy", 2);
      Topping topping3 = new Topping("zio³owy", 2);
      
      Pizza pizza1 = new Pizza("Pepperoni", 23);
      Pizza pizza2 = new Pizza("Best", 16);
      Pizza pizza3 = new Pizza("Manchester", 20);
      
      Customer customer1 = new Customer("Ada");
      Customer customer2 = new Customer("Allan");
      
      PizzaOrder order1 = new PizzaOrder(customer1);
      order1.addPizza(pizza1);
      order1.addPizza(pizza2);
      order1.addPizza(pizza3);

   }

}
