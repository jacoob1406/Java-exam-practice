import javax.swing.JOptionPane;

public class Ex3e
{
   public static void main(String[] args)
   {
      int choice = JOptionPane.showConfirmDialog(null,
            "Do You want to continue?", "Please confirm", JOptionPane.YES_NO_OPTION);
//      if (choice == JOptionPane.YES_OPTION)
//         System.out.println("Choice is yes");
//      else if (choice == JOptionPane.NO_OPTION)
//         System.out.println("Choice is no");
   }
}