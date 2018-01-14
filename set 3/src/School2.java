public class School2 extends Education
{
   private String type;
   public static final String INFANT_SCHOOL = "Infant school";
   public static final String JUNIOR_SCHOOL = "Junior school";
   public static final String SECONDARY_SCHOOL = "Secondary school";
   public static final String HIGH_SCHOOL = "High school";

   public School2(String code, String title, String type)
   {
      super(code, title);
      this.type = type;
   }

   public String getSchoolType()
   {
      return type;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof School))
      {
         return false;
      }

      School2 other = (School2) obj;
      return super.equals(other) && type.equals(other.type);
   }

   public String toString()
   {
      return super.toString() + "school type: " + type;
   }

}
