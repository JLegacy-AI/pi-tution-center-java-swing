package application.GUIComponents.StudentGUI;


import application.DataClasses.BookedCourses;
import application.DataClasses.Books;
import application.DataClasses.Course;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class BCComponent extends JPanel implements MouseListener, ActionListener, TuitionCenter {

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"Course-ID", "Course-Name", "Course-Price","Seat-Available","Time"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    private JLabel idLabel;
    private JLabel stLabel;

    private JButton add;

    private JTextField id;
    private JTextField st;

    private Course selected;

    public BCComponent() {
        amendContainer = new JPanel();

        idLabel = new JLabel("ID");
        stLabel = new JLabel("Student-ID");

        id = new JTextField("ID");
        st = new JTextField(StudentGUI.student.getId());
        st.setEnabled(false);

        add = new JButton("Add Course");

        amendContainer.setLayout(new GridLayout(0, 2, 30, 20));



        tableSP = new JScrollPane();

        setLayout(new BorderLayout());
        d = new DefaultTableModel(columnName,0);
        InfoShowingTable = new JTable(d);

        InfoShowingTable.setColumnSelectionAllowed(true);
        tableSP.setViewportView(InfoShowingTable);
        InfoShowingTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        InfoShowingTable.addMouseListener(this);

        books(d);


        amendContainer.add(idLabel);
        amendContainer.add(id);
        amendContainer.add(stLabel);
        amendContainer.add(st);
        amendContainer.add(add);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);

        add.addActionListener(this);
    }

    public void books(DefaultTableModel d){
        data = new Object[courses.size()][5];
        for (int i = 0; i < data.length; i++) {
            Course c = courses.get(i);
            data[i] = new Object[]{c.getId(), c.getName(),c.getPrice(), c.getCapacity(), c.getTime()};
            System.out.println(c.getName());
        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = InfoShowingTable.rowAtPoint(e.getPoint());
        int column = InfoShowingTable.columnAtPoint(e.getPoint());
        if(row>=0 && column==0){
            id.setText((String) data[row][column]);
            selected= courses.get(row);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!id.getText().equalsIgnoreCase("ID") && !id.getText().isBlank()){
            try{
                Course c = null;
                if((c=getCourse(id.getText()))!=null){
                    if(capacityFull(c.getId())){
                        throw new Exception("Capacity is Full more students Not Allowed");
                    }
                    BookedCourses bc =null;
                    if(alreadyBookedCourse(id.getText(),StudentGUI.student.getId())){
                        throw new Exception("You Already Has this Booked Course");
                    }else{
                        addBookedCourse(c.getId(), StudentGUI.student.getId());
                        throw new Exception("Book Added Successfully");
                    }
                }
                throw new Exception("Invalid information Entered :(");
            }catch (Exception f){
                JOptionPane.showMessageDialog(null,f.getMessage());
            }

        }
    }

}
