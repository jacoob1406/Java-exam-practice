
public class Tenant
{
private String name;
private MyDate rentedFrom;

   public Tenant(String name)
   {
      this.name=name;
      rentedFrom=null;
   }
   
   public String getName()
   {
      return name;
   }
   
   public MyDate getRentedFrom()
   {
      return rentedFrom.copy();
   }
   
   public void setRenedFrom(MyDate date)
   {
      rentedFrom=date;  //najpierw rentedFrom po lewej stronie równiania!!!!
   }

}
