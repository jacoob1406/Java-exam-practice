import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentFileAdapterGUI extends JFrame
{ 
   private StudentFileAdapter adapter;
   
   private JTabbedPane tabPane;
 
   private JPanel allStudentsPanel;
   private JPanel changeCountryPanel;
   private JPanel inputPanel;
 
   private JTextArea allStudentsArea;
   private JScrollPane allStudentsScrollPane;

   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel countryLabel;

   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField countryField;

   private JButton getButton;
   private JButton updateButton;
   
   private JPanel studentsFromCountryPanel;
   private JLabel countriesLabel;
   private JTextField countriesField;
   private JTextArea countriesTextArea;
   private JButton countriesButton;
   

   private MyButtonListener buttonListener;

   public StudentFileAdapterGUI()
   {
      super("Student File Adapter GUI");

      adapter = new StudentFileAdapter("students.bin");

      buttonListener = new MyButtonListener();

      allStudentsPanel = new JPanel();

      allStudentsArea = new JTextArea(20, 50);

      allStudentsScrollPane = new JScrollPane(allStudentsArea);

      allStudentsPanel.add(allStudentsScrollPane);

      getButton = new JButton("Get Students");
      getButton.addActionListener(buttonListener);
      allStudentsPanel.add(getButton);

      changeCountryPanel = new JPanel();

      inputPanel = new JPanel();

      firstNameLabel = new JLabel("First Name:    ");
      firstNameField = new JTextField(15);

      lastNameLabel = new JLabel("Last Name:    ");
      lastNameField = new JTextField(15);

      countryLabel = new JLabel("Country:          ");
      countryField = new JTextField(15);

      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);

      //tu jest robione zadanko 
      studentsFromCountryPanel = new JPanel();
      countriesLabel = new JLabel ("Country: ");
      countriesField = new JTextField(15);
      countriesTextArea = new JTextArea(20, 50);
      countriesButton = new JButton ("Students from there");
      countriesButton.addActionListener(buttonListener);
      studentsFromCountryPanel.add(countriesLabel);
      studentsFromCountryPanel.add(countriesField);
      studentsFromCountryPanel.add(countriesButton);
      studentsFromCountryPanel.add(countriesTextArea);

      
      inputPanel.add(firstNameLabel);
      inputPanel.add(firstNameField);

      inputPanel.add(lastNameLabel);
      inputPanel.add(lastNameField);

      inputPanel.add(countryLabel);
      inputPanel.add(countryField);

      inputPanel.add(updateButton); 
      
      changeCountryPanel.add(inputPanel);
      inputPanel.setPreferredSize(new Dimension(300, 120));

      tabPane = new JTabbedPane();
      tabPane.addTab("All Students", allStudentsPanel);
      tabPane.addTab("Change Country", changeCountryPanel);
      tabPane.addTab("Students from country", studentsFromCountryPanel);

      add(tabPane);
      setSize(575, 430);
      setVisible(true);
      setResizable(false);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }

   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == getButton)
         {
            StudentList students = adapter.getAllStudents();
            allStudentsArea.setText(students.toString());
         }
         if (e.getSource() == updateButton)
         {
            adapter.changeCountry(firstNameField.getText(),
                                   lastNameField.getText(), 
                                   countryField.getText());
         
            allStudentsArea.setText("");
         }
         if (e.getSource() == countriesButton)
         {
            
            StudentList countrystudents = adapter.getStudentsFrom(countriesField.getText());        
            countriesTextArea.setText(countrystudents.toString());
            
            
         }
      }
   }

   public static void main(String[] args)
   {
      StudentFileAdapterGUI sfagui = new StudentFileAdapterGUI();
   }
}
