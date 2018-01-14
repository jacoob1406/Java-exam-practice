import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex2 extends JFrame
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


   public Ex2()
   {

      super("Calculator");

     
     
      field1 = new JTextField(25);
     

      calculatorPanel = new JPanel();
      calculatorPanel.setLayout(new GridLayout(4, 4));
      btn7 = new JButton("7");
      calculatorPanel.add(btn7);
      btn8 = new JButton("8");
      calculatorPanel.add(btn8);
      btn9 = new JButton("9");
      calculatorPanel.add(btn9);
      btnDiv = new JButton("/");
      calculatorPanel.add(btnDiv);
      btn4 = new JButton("4");
      calculatorPanel.add(btn4);
      btn5 = new JButton("5");
      calculatorPanel.add(btn5);
      btn6 = new JButton("6");
      calculatorPanel.add(btn6);
      btnMul = new JButton("*");
      calculatorPanel.add(btnMul);
      btn1 = new JButton("1");
      calculatorPanel.add(btn1);
      btn2 = new JButton("2");
      calculatorPanel.add(btn2);
      btn3 = new JButton("3");
      calculatorPanel.add(btn3);
      btnMinus = new JButton("-");
      calculatorPanel.add(btnMinus);
      btn0 = new JButton("0");
      calculatorPanel.add(btn0);
      btnPoint = new JButton(".");
      calculatorPanel.add(btnPoint);
      btnEquals = new JButton("=");
      calculatorPanel.add(btnEquals);
      btnPlus = new JButton("+");
      calculatorPanel.add(btnPlus);

//      mainPanel.add(textPanel, BorderLayout.NORTH);
 //     mainPanel.add(calculatorPanel, BorderLayout.SOUTH);
   //   add(mainPanel);
      field1.setPreferredSize(new Dimension(100, 30));
      add(calculatorPanel, BorderLayout.CENTER);
      add(field1, BorderLayout.NORTH);
      setSize(300, 190);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);

   }

   public static void main(String[] args)
   {
      Ex2 cgui2 = new Ex2();
   }
}