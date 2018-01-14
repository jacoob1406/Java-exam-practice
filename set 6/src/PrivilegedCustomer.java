public class PrivilegedCustomer extends Customer
{
   private double discount;

   public PrivilegedCustomer(String name)
   {
      super(name);
      discount = 0.05;
   }

   public double getDiscount()
   {
      return discount;
   }

   private void setDiscount(double percentage)
   {
      discount = percentage;
   }

}
