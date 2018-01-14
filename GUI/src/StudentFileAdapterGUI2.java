import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
  
public class StudentFileAdapterGUI2 extends JFrame
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
    
   private JPanel comboPanel;
   private JComboBox<Student> studentBox;

   private MyButtonListener buttonListener;
   private MyTabListener tabListener;
   
   private ImageIcon logoIcon;
   private JLabel logoLabel;
   
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;
   
   private JMenuItem exitMenuItem;
   private JMenuItem aboutMenuItem;
   
   private JCheckBoxMenuItem editAreaMenuItem;
   private JCheckBoxMenuItem editFieldsMenuItem;
   private JCheckBoxMenuItem editCountryFieldItem;
   
   private JComboBox ex1;

   public StudentFileAdapterGUI2()
   {
      super("Student File Adapter GUI 2.0");

      adapter = new StudentFileAdapter("students.bin");

      buttonListener = new MyButtonListener();
      tabListener = new MyTabListener();
      
      exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.addActionListener(buttonListener);

      aboutMenuItem = new JMenuItem("About");
      aboutMenuItem.addActionListener(buttonListener);
      
      editAreaMenuItem = new JCheckBoxMenuItem("Edit student area", false);
      editAreaMenuItem.addActionListener(buttonListener);
      
      editFieldsMenuItem = new JCheckBoxMenuItem("Edit name fields", false);
      editFieldsMenuItem.addActionListener(buttonListener);
      
      editCountryFieldItem = new JCheckBoxMenuItem("Edit country field", false);
      editCountryFieldItem.addActionListener(buttonListener);
      
      fileMenu = new JMenu("File");
      editMenu = new JMenu("Edit");
      aboutMenu = new JMenu("About");
         
      fileMenu.add(exitMenuItem);
      
      editMenu.add(editAreaMenuItem);
      editMenu.add(editFieldsMenuItem);
      editMenu.add(editCountryFieldItem);
      
      aboutMenu.add(aboutMenuItem);
      
      menuBar = new JMenuBar();
      
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(aboutMenu);
      
      setJMenuBar(menuBar);
            
      allStudentsPanel = new JPanel();
      allStudentsArea = new JTextArea(20, 50);
      allStudentsArea.setEditable(false);

      allStudentsScrollPane = new JScrollPane(allStudentsArea);
      allStudentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      allStudentsPanel.add(allStudentsScrollPane);

      getButton = new JButton("Get Students");
      getButton.addActionListener(buttonListener);
      allStudentsPanel.add(getButton);

      changeCountryPanel = new JPanel();

      inputPanel = new JPanel();

      firstNameLabel = new JLabel("First Name:    ");
      firstNameField = new JTextField(15);
      firstNameField.setEditable(false);

      lastNameLabel = new JLabel("Last Name:    ");
      lastNameField = new JTextField(15);
      lastNameField.setEditable(false);
      
      

      countryLabel = new JLabel("Country:          ");
      countryField = new JTextField(15);
      countryField.setEditable(false);

      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);

      inputPanel.add(firstNameLabel);
      inputPanel.add(firstNameField);

      inputPanel.add(lastNameLabel);
      inputPanel.add(lastNameField);

      inputPanel.add(countryLabel);
      inputPanel.add(countryField);

      changeCountryPanel.add(inputPanel);
      inputPanel.setPreferredSize(new Dimension(280, 300));

      comboPanel = new JPanel();
            
      studentBox = new JComboBox<Student>();
      studentBox.addActionListener(buttonListener);
      comboPanel.add(studentBox);
      
      //tutaj wale zadanie 1
      ex1 = new JComboBox<String>(adapter.getAllCountries());
      ex1.addActionListener(buttonListener);
      comboPanel.add(ex1);
            
      changeCountryPanel.add(comboPanel);
      comboPanel.setPreferredSize(new Dimension(260, 300));
      
      inputPanel.add(updateButton);
      
      logoIcon = new ImageIcon("img/vialogoah.gif");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);
      
      changeCountryPanel.add(logoLabel);
      logoLabel.setPreferredSize(new Dimension(145, 65));
      
      tabPane = new JTabbedPane();
      tabPane.addTab("All Students", allStudentsPanel);
      tabPane.addTab("Change Country", changeCountryPanel);
      tabPane.addChangeListener(tabListener);

      add(tabPane);
      setSize(575, 452);
      setVisible(true);
      setResizable(false);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
   }

   private void updateStudentBox()
   {
      int currentIndex = studentBox.getSelectedIndex();
      
      studentBox.removeAllItems();
      
      StudentList students = adapter.getAllStudents();
      for(int i = 0; i<students.size(); i++)
      {
         studentBox.addItem(students.get(i));
      }

      if(currentIndex==-1 && studentBox.getItemCount()>0)
      {
         studentBox.setSelectedIndex(0);
      }
      else
      {
         studentBox.setSelectedIndex(currentIndex);
      }
   }
   

   private void updateStudentArea()
   {
      StudentList students = adapter.getAllStudents();
      allStudentsArea.setText(students.toString());
   }  
   
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if (e.getSource() == getButton)
         {
            updateStudentArea();
         }
         if (e.getSource() == updateButton)
         {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String country = countryField.getText();

            if (country.equals(""))
            {
               country = "?";
            }

            adapter.changeCountry(firstName, lastName, country);
            updateStudentBox();
            countryField.setText("");
         }
         if (e.getSource() == studentBox)
         {
            if (studentBox.getSelectedItem() instanceof Student)
            {
               Student temp = (Student)studentBox.getSelectedItem();
               firstNameField.setText(temp.getFirstName());
               lastNameField.setText(temp.getLastName());
            }
         }
         if (e.getSource() == ex1)
         {
            if (ex1.getSelectedItem() instanceof String)
            {
               String temp = (String)ex1.getSelectedItem();
               countryField.setText(temp);
            }
         }
 
         if (e.getSource() == exitMenuItem)
         {
            int choice = JOptionPane.showConfirmDialog(null,
                  "Do you really want to exit the program?", "Exit",
                  JOptionPane.YES_NO_OPTION);

            if (choice == JOptionPane.YES_OPTION)
            {
               System.exit(0);
            }
         }

         if (e.getSource() == editAreaMenuItem)
         {
            if (editAreaMenuItem.isSelected())
            {
               allStudentsArea.setEditable(true);
            }
            else
            {
               allStudentsArea.setEditable(false);
            }
         }

         if (e.getSource() == editFieldsMenuItem)
         {
            if (editFieldsMenuItem.isSelected())
            {
               firstNameField.setEditable(true);
               lastNameField.setEditable(true);
            }
            else
            {
               firstNameField.setEditable(false);
               lastNameField.setEditable(false);
            }
         }
         
         if (e.getSource() == editCountryFieldItem)
         {
            if (editCountryFieldItem.isSelected())
            {
               countryField.setEditable(true);
            }
            else
            {
               countryField.setEditable(false);
            }
         }

         if (e.getSource() == aboutMenuItem)
         {
            JOptionPane.showMessageDialog(
                        null,
                        "This is just a little program that demonstrates some of the GUI features in Java",
                        "About", JOptionPane.PLAIN_MESSAGE);
         }
      }
   }

   private class MyTabListener implements ChangeListener
   {
      public void stateChanged(ChangeEvent e)
      {
         if(((JTabbedPane)e.getSource()).getSelectedIndex()==0)
         {
            updateStudentArea();
         } 
 
         if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
         {
            updateStudentBox();
         }
      }
   }
   
   public static void main(String[] args)
   {
      StudentFileAdapterGUI2 sfagui2 = new StudentFileAdapterGUI2();
   }
}
