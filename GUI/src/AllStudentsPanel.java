import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 * A GUI panel containing components for displaying a list of students.
 * @author Allan Henriksen
 * @version 2.0
 */  
public class AllStudentsPanel extends JPanel
{
   private StudentFileAdapter adapter;
   private MyButtonListener buttonListener;
   
   private JTable allStudentsTable;
   private String[] columnNames;
   private DefaultTableModel dtm;
   private JScrollPane allStudentsScrollPane;
   
   private JButton getButton;
   private JButton getEmployeeButton;
   
   /**
    * Constructor initializing the GUI components
    * @param adapter StudentFileAdapter object used for retrieving and storing student information
    */
   public AllStudentsPanel(StudentFileAdapter adapter)
   {
      this.adapter = adapter;
      buttonListener = new MyButtonListener();
            
      columnNames = new String[3];
      columnNames[0] = "First name";
      columnNames[1] = "Last name";
      columnNames[2] = "Country";
      
      dtm = new DefaultTableModel(columnNames, 0);
      
      allStudentsTable = new JTable(dtm);
      allStudentsTable.setEnabled(false);
      allStudentsTable.getTableHeader().setReorderingAllowed(false);
      allStudentsTable.getTableHeader().setResizingAllowed(false);
      allStudentsTable.setPreferredScrollableViewportSize(new Dimension(500, allStudentsTable.getRowHeight()*18));
      
      allStudentsScrollPane = new JScrollPane(allStudentsTable);
      allStudentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

      add(allStudentsScrollPane);

      getButton = new JButton("Get Students");
      getButton.addActionListener(buttonListener);
      
      

      
      add(getButton);
   }
   
   /**
    * Enables or disables editing of the allStudentsTable.
    * @param bool if true then the table will be editable, if false then it will not
    */
   public void changeEditableState(boolean bool)
   {
     allStudentsTable.setEnabled(bool);
     allStudentsTable.clearSelection();
   }
   
   /**
    * Updates the allStudentsTable JTable with information from the students file
    */
   public void updateStudentTable()
   {
      StudentList students = adapter.getAllStudents();
      Object[][] data = new Object[students.size()][3];
      
      for(int i = 0; i<students.size();i++)
      {
         data[i][0] = students.get(i).getFirstName();
         data[i][1] = students.get(i).getLastName();
         data[i][2] = students.get(i).getCountry();
      }
      dtm = new DefaultTableModel(data, columnNames);
      allStudentsTable.setModel(dtm);
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
         if (e.getSource() == getButton)
         {
            updateStudentTable();
         }
      }
   }
}
