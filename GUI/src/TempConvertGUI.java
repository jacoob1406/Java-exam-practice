import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TempConvertGUI extends JFrame
{
   private JPanel radioPanel;
   private JPanel inputPanel;
   private JPanel msgPanel;

   private JButton convertButton;
   private JTextField inputField;
   private JLabel temperatureLabel;
   private JLabel msgLabel;

   private JRadioButton c2f;
   private JRadioButton f2c;
   private ButtonGroup radioGroup;

   private MyButtonListener buttonListener;

   private final Color BORDER_COLOR = new Color(180, 200, 240);

   private DecimalFormat formatter;

   private TempConvert convert;

   public TempConvertGUI()
   {
      super("Temperature Converter");

      buttonListener = new MyButtonListener();

      convert = new TempConvert();

      formatter = new DecimalFormat("#0.0");

      c2f = new JRadioButton("\u00b0C to \u00b0F", true); // \u00b0 = degree
                                                          // symbol
      f2c = new JRadioButton("\u00b0F to \u00b0C");

      radioPanel = new JPanel();
      radioPanel.setBorder(new LineBorder(BORDER_COLOR));
      radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

      radioGroup = new ButtonGroup();
      radioGroup.add(c2f);
      radioGroup.add(f2c);

      radioPanel.add(c2f);
      radioPanel.add(f2c);

      inputPanel = new JPanel();
      inputPanel.setBorder(new LineBorder(BORDER_COLOR));

      temperatureLabel = new JLabel("Temperature:");
      inputField = new JTextField(5);
      convertButton = new JButton("Convert");
      convertButton.addActionListener(buttonListener);

      inputPanel.add(temperatureLabel);
      inputPanel.add(inputField);
      inputPanel.add(convertButton);

      msgPanel = new JPanel();
      msgPanel.setBorder(new LineBorder(BORDER_COLOR));

      msgLabel = new JLabel();
      msgPanel.add(msgLabel);

      add(inputPanel, BorderLayout.CENTER);
      inputPanel.setPreferredSize(new Dimension(200, 120));

      add(radioPanel, BorderLayout.EAST);
      radioPanel.setPreferredSize(new Dimension(100, 100));

      add(msgPanel, BorderLayout.SOUTH);
      msgPanel.setPreferredSize(new Dimension(300, 25));

      setDefaultCloseOperation(EXIT_ON_CLOSE);

      setSize(300, 145);
      setVisible(true);
      setLocationRelativeTo(null);
   }

   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == convertButton)
         {
            // convert the entered text to a double
            double temp = Double.parseDouble(inputField.getText());

            double result = -1;

            if (c2f.isSelected())
            {
               result = convert.celsiusToFahrenheit(temp);
               msgLabel.setText(temp + "\u00b0C = " + formatter.format(result)
                     + "\u00b0F");
            }
            else if (f2c.isSelected())
            {
               result = convert.fahrenheitToCelsius(temp);
               msgLabel.setText(temp + "\u00b0F = " + formatter.format(result)
                     + "\u00b0C");
            }
         }
      }
   }

   public static void main(String[] args)
   {
      TempConvertGUI tcgui = new TempConvertGUI();
   }
}
