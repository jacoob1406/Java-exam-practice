import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CircumferenceGUI<MyButtonListener> extends JFrame
{
   private JPanel panelek;
   private JTextField input;
   private JButton button1;
   private JLabel label1;
   private JLabel label2;

   public CircumferenceGUI()
   {
      super("Area and circumference of the circle");

      panelek = new JPanel();
      //panelek.setLayout(new BoxLayout(panelek, BoxLayout.Y_AXIS));

      input = new JTextField(7);
      button1 = new JButton("Calculate");
      button1.addActionListener(new MyButtonListener());
      label1 = new JLabel();
      label2 = new JLabel();
      panelek.add(input);
      panelek.add(button1);
      panelek.add(label1);
      panelek.add(label2);

      add(panelek);

      
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setSize(300, 140);
      setVisible(true);
      setLocationRelativeTo(null);
   }

   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == button1)
         {
            // convert the entered text to a double
            double temp = Double.parseDouble(input.getText());

            double area = Math.PI * temp * temp;
            double circumference = 2 * Math.PI * temp;

            label1.setText("AREA: " + area);
            label2.setText("CIRCUMFERENCE: " + circumference);

         }
      }
   }

   public static void main(String[] args)
   {
      CircumferenceGUI areacirc = new CircumferenceGUI();
   }
}
