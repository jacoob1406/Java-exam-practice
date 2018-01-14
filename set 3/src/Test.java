
public class Test
{

   public static void main(String[] args)
   {
      Programme program1 = new Programme("AFC", "SDJ", "high");
      Programme program2 = new Programme("WER", "WEE", "low");
      
      School school1 = new School("asd", "LO3", School.HIGH_SCHOOL);
      
      Student student1 = new Student("Jakub", school1);
      
      StudentList lista = new StudentList();
      
      lista.addStudent(student1);
      
      System.out.println(lista.getNumberOfHighSchoolStudents());

   }

}
