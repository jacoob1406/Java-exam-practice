import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Ex1 extends JFrame
{
   private JPanel mainPanel;
   private JPanel exitPanel;
   private JPanel xyPanel;
   private JPanel choicePanel;
   private JPanel xPanel;
   private JPanel yPanel;

   private JPanel buttonsPanel;

   private JLabel textLabel1;
   private JLabel textLabel2;

   private JCheckBox okCheckBox;
   private JCheckBox cancelCheckBox;

   private JLabel xLabel;
   private JLabel yLabel;

   private JTextField xField;
   private JTextField yField;

   private JButton okButton;
   
   private JButton cancelButton;
   private JButton clearButton;

   public Ex1()
   {
      super("Align");

      mainPanel = new JPanel();
      mainPanel.setLayout(new BorderLayout());

      exitPanel = new JPanel();
      exitPanel.setLayout(new BoxLayout(exitPanel, BoxLayout.Y_AXIS));
      exitPanel.setBorder(new EmptyBorder(17, 0, 0, 0));
      okCheckBox = new JCheckBox("Exit on OK");
      cancelCheckBox = new JCheckBox("Exit on Cancel");
      exitPanel.add(okCheckBox);
      exitPanel.add(cancelCheckBox);

      xyPanel = new JPanel();
      xyPanel.setLayout(new BoxLayout(xyPanel, BoxLayout.Y_AXIS));
      xyPanel.setBorder(new EmptyBorder(7, 0, 0, 0));
      xPanel = new JPanel();
      xPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      xLabel = new JLabel("X");
      xField = new JTextField(15);
      yPanel = new JPanel();
      yPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
      yLabel = new JLabel("Y");
      yField = new JTextField(15);

      xPanel.add(xLabel);
      xPanel.add(xField);
      yPanel.add(yLabel);
      yPanel.add(yField);
      xyPanel.add(xPanel);
      xyPanel.add(yPanel);

      buttonsPanel = new JPanel();
      buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
      buttonsPanel.setBorder(new EmptyBorder(5, 6, 16, 6));
      okButton = new JButton("OK");
      cancelButton = new JButton("Cancel");
      clearButton = new JButton("Clear");
      okButton.addActionListener(new MyButtonListener());
      cancelButton.addActionListener(new MyButtonListener());
      clearButton.addActionListener(new MyButtonListener());
      buttonsPanel.add(okButton);
      buttonsPanel.add(cancelButton);
      buttonsPanel.add(clearButton);

      mainPanel.add(exitPanel, BorderLayout.WEST);
      mainPanel.add(xyPanel, BorderLayout.CENTER);
      mainPanel.add(buttonsPanel, BorderLayout.EAST);
      add(mainPanel);
      setSize(400, 145);
      setVisible(true);
      setResizable(true);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }
   
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == okButton)
         {        
            if (okCheckBox.isSelected())
            {
               System.exit(0);
            }
            else
            {
               JOptionPane.showMessageDialog(null, xField.getText());
               JOptionPane.showMessageDialog(null, yField.getText());
            }

         }
         else if (e.getSource() == cancelButton)
         {
            if (cancelCheckBox.isSelected())
            {
               System.exit(0);
            }
         }
         else if (e.getSource() == clearButton)
         {
            xField.setText("");
            yField.setText("");
         }
         
      }
   }

   public static void main(String[] args)
   {
      Ex1 cgui1 = new Ex1();
   }
}
