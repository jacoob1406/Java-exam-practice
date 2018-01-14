import javax.swing.JOptionPane;

public class Ex3c
{
   public static void main(String[] args)
   {
      String input = JOptionPane.showInputDialog(null, "Enter a number.",
            "Input", JOptionPane.QUESTION_MESSAGE);
      System.out.println(input);
   }
}