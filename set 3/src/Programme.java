
public class Programme extends Education
{
private String level;

   public Programme(String code, String title, String level)
   {
      super(code, title); //calling the superclass constructor
      this.level=level;
   }
   public String getLevel()
   {
      return level;
   }
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Programme))
      {
         return false;
      }
      Programme other = (Programme) obj;
      //!!!! super.equals(obj)
      return super.equals(obj) && level.equals(other.level);
   }
   
   public String toString()
   {
      return super.toString() + "; level: " + level;
   }

}
