import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame
{
   private JPanel mainPanel;
   private JPanel textPanel;
   private JTextField field1;
   private JPanel calculatorPanel;

   private JButton btn0;
   private JButton btn1;
   private JButton btn2;
   private JButton btn3;
   private JButton btn4;
   private JButton btn5;
   private JButton btn6;
   private JButton btn7;
   private JButton btn8;
   private JButton btn9;
   private JButton btnDiv;
   private JButton btnMul;
   private JButton btnMinus;
   private JButton btnPoint;
   private JButton btnEquals;
   private JButton btnPlus;

   private double x;
   private double y;
   private char operator;

   private MyButtonListener buttonListener;

   public Calculator()
   {

      super("Calculator");

      buttonListener = new MyButtonListener();

      field1 = new JTextField(25);

      calculatorPanel = new JPanel();
      calculatorPanel.setLayout(new GridLayout(4, 4));

      btn7 = new JButton("7");
      calculatorPanel.add(btn7);
      btn7.addActionListener(buttonListener);

      btn8 = new JButton("8");
      calculatorPanel.add(btn8);
      btn8.addActionListener(buttonListener);

      btn9 = new JButton("9");
      calculatorPanel.add(btn9);
      btn9.addActionListener(buttonListener);

      btnDiv = new JButton("/");
      calculatorPanel.add(btnDiv);
      btnDiv.addActionListener(buttonListener);

      btn4 = new JButton("4");
      calculatorPanel.add(btn4);
      btn4.addActionListener(buttonListener);

      btn5 = new JButton("5");
      calculatorPanel.add(btn5);
      btn5.addActionListener(buttonListener);

      btn6 = new JButton("6");
      calculatorPanel.add(btn6);
      btn6.addActionListener(buttonListener);

      btnMul = new JButton("*");
      calculatorPanel.add(btnMul);
      btnMul.addActionListener(buttonListener);

      btn1 = new JButton("1");
      calculatorPanel.add(btn1);
      btn1.addActionListener(buttonListener);

      btn2 = new JButton("2");
      calculatorPanel.add(btn2);
      btn2.addActionListener(buttonListener);

      btn3 = new JButton("3");
      calculatorPanel.add(btn3);
      btn3.addActionListener(buttonListener);

      btnMinus = new JButton("-");
      calculatorPanel.add(btnMinus);
      btnMinus.addActionListener(buttonListener);

      btn0 = new JButton("0");
      calculatorPanel.add(btn0);
      btn0.addActionListener(buttonListener);

      btnPoint = new JButton(".");
      calculatorPanel.add(btnPoint);
      btnPoint.addActionListener(buttonListener);

      btnEquals = new JButton("=");
      calculatorPanel.add(btnEquals);
      btnEquals.addActionListener(buttonListener);

      btnPlus = new JButton("+");
      calculatorPanel.add(btnPlus);
      btnPlus.addActionListener(buttonListener);

      // mainPanel.add(textPanel, BorderLayout.NORTH);
      // mainPanel.add(calculatorPanel, BorderLayout.SOUTH);
      // add(mainPanel);
      field1.setPreferredSize(new Dimension(100, 30));
      add(calculatorPanel, BorderLayout.CENTER);
      add(field1, BorderLayout.NORTH);
      setSize(300, 190);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

   }

   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == btn1)
         {
            field1.setText(field1.getText() + "1");
         }
         if (e.getSource() == btn2)
         {
            field1.setText(field1.getText() + "2");
         }
         if (e.getSource() == btn3)
         {
            field1.setText(field1.getText() + "3");
         }
         if (e.getSource() == btn4)
         {
            field1.setText(field1.getText() + "4");
         }
         if (e.getSource() == btn5)
         {
            field1.setText(field1.getText() + "5");
         }
         if (e.getSource() == btn6)
         {
            field1.setText(field1.getText() + "6");
         }
         if (e.getSource() == btn7)
         {
            field1.setText(field1.getText() + "7");
         }
         if (e.getSource() == btn8)
         {
            field1.setText(field1.getText() + "8");
         }
         if (e.getSource() == btn9)
         {
            field1.setText(field1.getText() + "9");
         }
         if (e.getSource() == btn0)
         {
            field1.setText(field1.getText() + "0");
         }
         if (e.getSource() == btnDiv)
         {
            x = Double.parseDouble(field1.getText());
            operator = '/';
            field1.setText("");
         }
         if (e.getSource() == btnMinus)
         {
            x = Double.parseDouble(field1.getText());
            operator = '-';
            field1.setText("-");
         }
         if (e.getSource() == btnMul)
         {
            x = Double.parseDouble(field1.getText());
            operator = '*';
            field1.setText("*");
         }
         if (e.getSource() == btnPlus)
         {
            x = Double.parseDouble(field1.getText());
            operator = '+';
            field1.setText("+");
         }
         if (e.getSource() == btnPoint)
         {
            if (!field1.getText().contains("."))
            {
            field1.setText(field1.getText() + ".");
            }
         }
         if (e.getSource() == btnEquals)
         {
            y = Double.parseDouble(field1.getText());

            if (operator == '/')
            {
               if (y != 0)
               {
                  double result = x / y;
                  field1.setText(result + "");
               }
               else
                  field1.setText("ERROR");
            }
            else if (operator == '+')
            {
               double result = x + y;
               field1.setText(result + "");
            }
            else if (operator == '-')
            {
               double result = x - y;
               field1.setText(result + "");
            }
            else if (operator == '*')
            {
               double result = x * y;
               field1.setText(result + "");
            }
         }
      }
   }

   public static void main(String[] args)
   {
      Calculator cgui2 = new Calculator();
   }
}