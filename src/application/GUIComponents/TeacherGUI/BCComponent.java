package application.GUIComponents.TeacherGUI;


import application.DataClasses.*;
import application.GUIComponents.StartGUI.StartGUI;

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
    private Object[] columnName = new String [] {"C-ID", "C-Name", "C-Price","S-Available","C-Time"};
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
        st = new JTextField("Student-ID");

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
            data[i] = new Object[]{c.getId(), c.getName(), '\u00A3'+"   "+c.getPrice(), c.getCapacity(), c.getTime().format(StartGUI.dtf)};
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
                for (Course course : courses) {
                    if(course.getId().equalsIgnoreCase(id.getText())){

                        for (BookedCourses bookedCours : bookedCourses) {
                            if(bookedCours.getCourseID().equalsIgnoreCase(id.getText()) && bookedCours.getStudentID().equalsIgnoreCase(st.getText())){
                                throw new Exception("You Already Has this Booked Course");
                            }
                        }
                        for (Student student : students) {
                            if(student.getId().equalsIgnoreCase(st.getText())){
                                bookedCourses.add(new BookedCourses(course.getId(), student.getId()));
                                throw new Exception("Course Booked Successfully");
                            }
                        }
                    }
                }
                throw new Exception("Invalid Data");
            }catch (Exception f){
                JOptionPane.showMessageDialog(null,f.getMessage());
            }

        }
    }

}

