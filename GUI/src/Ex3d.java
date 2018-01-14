import javax.swing.JOptionPane;

public class Ex3d
{
   public static void main(String[] args)
   {
      int choice = JOptionPane.showConfirmDialog(null,
            "Do You want to continue?");
      if (choice == JOptionPane.YES_OPTION)
         System.out.println("Choice is yes");
      else if (choice == JOptionPane.NO_OPTION)
         System.out.println("Choice is no");
      else if (choice == JOptionPane.CANCEL_OPTION)
         System.out.println("Choice is cancel");
   }
}