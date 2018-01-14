import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * A GUI panel containing components for changing a students country.
 * @author Allan Henriksen
 * @version 2.0
 */ 
public class ChangeCountryPanel extends JPanel
{
   private StudentFileAdapter adapter;
   private MyButtonListener buttonListener;
   private MyListSelectionListener listListener;
    
   private JPanel inputPanel;
   
   private JLabel firstNameLabel;
   private JLabel lastNameLabel;
   private JLabel countryLabel;

   private JTextField firstNameField;
   private JTextField lastNameField;
   private JTextField countryField;
   
   private JButton updateButton;
   
   private JPanel comboPanel;
   private JList<Student> studentList;
   private DefaultListModel<Student> listModel;
   private JScrollPane allStudentsScrollPane;
   
   private ImageIcon logoIcon;
   private JLabel logoLabel;
   
   /**
    * Constructor initializing the GUI components
    * @param adapter StudentFileAdapter object used for retrieving and storing student information
    */
   public ChangeCountryPanel(StudentFileAdapter adapter)
   {
      this.adapter = adapter;
      buttonListener = new MyButtonListener();
      listListener = new MyListSelectionListener();
      
      inputPanel = new JPanel();

      firstNameLabel = new JLabel("First Name:    ");
      firstNameField = new JTextField(15);
      firstNameField.setEditable(false);

      lastNameLabel = new JLabel("Last Name:    ");
      lastNameField = new JTextField(15);
      lastNameField.setEditable(false);

      countryLabel = new JLabel("Country:          ");
      countryField = new JTextField(15);

      updateButton = new JButton("Update");
      updateButton.addActionListener(buttonListener);

      inputPanel.add(firstNameLabel);
      inputPanel.add(firstNameField);

      inputPanel.add(lastNameLabel);
      inputPanel.add(lastNameField);

      inputPanel.add(countryLabel);
      inputPanel.add(countryField);

      add(inputPanel);
      inputPanel.setPreferredSize(new Dimension(280, 300));

      comboPanel = new JPanel();
            
      listModel = new DefaultListModel<Student>();
      studentList = new JList<Student>(listModel);
      studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      studentList.addListSelectionListener(listListener);
      studentList.setVisibleRowCount(12); 
      
      allStudentsScrollPane = new JScrollPane(studentList);
      allStudentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            
      comboPanel.add(allStudentsScrollPane);
            
      add(comboPanel);
      comboPanel.setPreferredSize(new Dimension(260, 300));
      
      inputPanel.add(updateButton);
      
      logoIcon = new ImageIcon("img/vialogoah.gif");
      logoLabel = new JLabel();
      logoLabel.setIcon(logoIcon);
      
      add(logoLabel);
      logoLabel.setPreferredSize(new Dimension(145, 65));
   }
   
   /**
    * Enables or disables editing of firstNameField and lastNameField.
    * @param bool if true then the fields will be editable, if false then they will not
    */
   public void changeEditableState(boolean bool)
   {
      firstNameField.setEditable(bool);
      lastNameField.setEditable(bool);
   }
   
   /**
    * Updates the studentBox JComboBox with information from the students file  
    */
  public void updateStudentBox()
   {
      int currentIndex = studentList.getSelectedIndex();
      
      listModel.clear();
      
      StudentList students = adapter.getAllStudents();
      for(int i = 0; i<students.size(); i++)
      {
         listModel.addElement(students.get(i));
      }

      if(currentIndex==-1 && listModel.size()>0)
      {
         studentList.setSelectedIndex(0);
      }
      else
      {
         studentList.setSelectedIndex(currentIndex);
      }
   }

   /*
    * Inner action listener class 
    * @author Allan Henriksen
    * @version 3.0
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
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
      }
   }
   
   private class MyListSelectionListener implements ListSelectionListener 
   {
      public void valueChanged(ListSelectionEvent e) 
      {
         if (e.getSource() == studentList)
         {
            if (studentList.getSelectedValue() instanceof Student)
            {
               Student temp = (Student)studentList.getSelectedValue();
               firstNameField.setText(temp.getFirstName());
               lastNameField.setText(temp.getLastName());
            }
         }
      }
   }
}
