import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
  
/**
 * A user interface that allows for displaying and modifying information about students.
 * @author Allan Henriksen
 * @version 5.0
 */ 
public class StudentFileAdapterGUI5 extends JFrame
{
   private StudentFileAdapter adapter;

   private JTabbedPane tabPane;

   private AllStudentsPanel allStudentsPanel;
   private ChangeCountryPanel changeCountryPanel;
    
   private MyButtonListener buttonListener;
   private MyTabListener tabListener;
      
   private JMenuBar menuBar;
   
   private JMenu fileMenu;
   private JMenu editMenu;
   private JMenu aboutMenu;
   
   private JMenuItem exitMenuItem;
   private JMenuItem aboutMenuItem;
   
   private JCheckBoxMenuItem editAreaMenuItem;
   private JCheckBoxMenuItem editFieldsMenuItem;

   /**
    * No-argument constructor initializing the GUI components 
    */
   public StudentFileAdapterGUI5()
   {
      super("Student File Adapter GUI 5.0");

      adapter = new StudentFileAdapter("students.bin");

      buttonListener = new MyButtonListener();
      tabListener = new MyTabListener();
      
      exitMenuItem = new JMenuItem("Exit");
      exitMenuItem.addActionListener(buttonListener);

      aboutMenuItem = new JMenuItem("About");
      aboutMenuItem.addActionListener(buttonListener);
      
      editAreaMenuItem = new JCheckBoxMenuItem("Edit student table", false);
      editAreaMenuItem.addActionListener(buttonListener);
      
      editFieldsMenuItem = new JCheckBoxMenuItem("Edit name fields", false);
      editFieldsMenuItem.addActionListener(buttonListener);
      
      fileMenu = new JMenu("File");
      editMenu = new JMenu("Edit");
      aboutMenu = new JMenu("About");
         
      fileMenu.add(exitMenuItem);
      
      editMenu.add(editAreaMenuItem);
      editMenu.add(editFieldsMenuItem);
      
      aboutMenu.add(aboutMenuItem);
      
      menuBar = new JMenuBar();
      
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(aboutMenu);
      
      setJMenuBar(menuBar);
            
      allStudentsPanel = new AllStudentsPanel(adapter);
      changeCountryPanel = new ChangeCountryPanel(adapter);
      
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
   
   /*
    * Inner action listener class 
    * @author Allan Henriksen
    * @version 4.0
    */
   private class MyButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
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
            allStudentsPanel.changeEditableState(true);
            }
            else
            {
               allStudentsPanel.changeEditableState(false);
            }
         }

         if (e.getSource() == editFieldsMenuItem)
         {
            if (editFieldsMenuItem.isSelected())
            {
               changeCountryPanel.changeEditableState(true);
            }
            else
            {
               changeCountryPanel.changeEditableState(false);
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
            allStudentsPanel.updateStudentTable();
         } 
 
         if(((JTabbedPane)e.getSource()).getSelectedIndex()==1)
         {
            changeCountryPanel.updateStudentBox();
         }
      }
   }
   
   public static void main(String[] args)
   {
      StudentFileAdapterGUI5 sfagui5 = new StudentFileAdapterGUI5();
   }
}
