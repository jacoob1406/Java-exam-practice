import java.util.ArrayList;

public class StudentList
{
   private int size;
   private ArrayList<Student> list;

   public StudentList()
   {
      list = new ArrayList<Student>();
      // this.size=0;
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
      int count = 0;
      for (int i = 0; i < list.size(); i++)
      {
         if (education.equals(list.get(i).getEducation()))
         {
            count++;
         }
      }
      return count;
   }

   public Student[] getStudentsByEducation(Education education)
   {
      // albo
      int counter = 0;
      for (int i = 0; i < list.size(); i++)
      {
         if (education.equals(list.get(i).getEducation()))
         {
            counter++;
         }
      }

      Student[] all = new Student[counter];

      int counter2 = 0;
      for (int i = 0; i < list.size(); i++)
      {
         if (education.equals(list.get(i).getEducation()))
         {
            all[counter2] = list.get(i);
            counter2++;
         }
      }
      return all;
   }


   public int getNumberOfHighSchoolStudents()
   {
      int count = 0;
      for (int i = 0; i < list.size(); i++)
      {
         if (list.get(i).getEducation() instanceof School)
         {
            if (((School) list.get(i).getEducation()).getSchoolType().equals(
                  School.HIGH_SCHOOL))
            {
               count++;
            }
         }
      }
      return count;
   }

   public void doubleTheListCapacity()
   {
      ArrayList nAL = new ArrayList<Student>(list.size() * 2);

      for (int i = 0; i < list.size(); i++)
         nAL.add(list.get(i));

      list = nAL;
   }

}
