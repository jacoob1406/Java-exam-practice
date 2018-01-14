import java.util.ArrayList;

public class StudentList2
{
   private int size;
   private ArrayList<Student> list;

   public StudentList2()
   {
      this.size = 0;
      list = new ArrayList<Student>();
   }

   public void addStudent(Student student)
   {
      list.add(student);
   }

   public Student getStudent(int index)
   {
      return list.get(index);
   }

   public void removeStudent(Student student)
   {
      list.remove(student);
   }

   public int getNumberOfStudents()
   {
      return list.size();
   }

   public int getNumberOfStudentsByEducation(Education education)
   {
      int sum = 0;

      for (int i = 0; i < list.size(); i++)
      {
         if (education.equals(list.get(i).getEducation()))
         {
            sum++;
         }
      }
      return sum;
   }

   public Student[] getStudentsByEducation(Education education)
   {
      ArrayList<Student> temp = new ArrayList<Student>();

      for (int i = 0; i < list.size(); i++)
      {
         if (education.equals(list.get(i).getEducation()))
         {
            temp.add(list.get(i));
         }
      }
      Student[] fin = new Student[temp.size()];

      return temp.toArray(fin);
   }

   public int getNumberOfHighSchoolStudents()
   {
      int sum = 0;

      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getEducation() instanceof School)
         {
            if (((School) list.get(i).getEducation()).getSchoolType().equals(
                  School.HIGH_SCHOOL))
            {
               sum++;
            }
         }
      }
      return sum;
   }

   public void doubleTheListCapacity()
   {
      ArrayList<Student> nowa = new ArrayList<Student>(list.size());

      for (int i = 0; i < list.size(); i++)
      {
         nowa.add(list.get(i));
      }

      list = nowa;
   }

}
