package application.GUIComponents.TeacherGUI;

import application.DataClasses.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VACComponent extends JPanel implements MouseListener, ActionListener, TuitionCenter{

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"BC-ID","S-ID", "S-Name", "C-ID", "C-Name","BC-Status"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    private JLabel idLabel;
    private JLabel nameLabel;

    private JButton changeBooking;
    private JButton cancelBooking;

    private JTextField id;
    private JTextField nameField;

    private Books selected;


    private JTextField stID;
    private JTextField courseID;
    private JTextField bookName;

    private JLabel stIDLabel;
    private JLabel courseIDLabel;
    private JLabel bookNameLabel;

    public VACComponent() {
        amendContainer = new JPanel();

        idLabel = new JLabel("BC-ID");
        id = new JTextField("BC-ID");

        stID = new JTextField("Student-ID");
        stIDLabel = new JLabel("Student-ID");

        nameLabel = new JLabel("Name");
        nameField = new JTextField("Student-Name");

        courseID = new JTextField("Book-ID");
        courseIDLabel = new JLabel("Book-ID");

        bookName = new JTextField("Book-Name");
        bookNameLabel = new JLabel("Book-Name");

        changeBooking = new JButton("Change Booking");
        cancelBooking = new JButton("Cancel Booking");

        nameField.setEnabled(false);
        bookName.setEnabled(false);
        stID.setEnabled(false);
        bookName.setEnabled(false);

        amendContainer.setLayout(new GridLayout(0, 2, 20, 5));



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

        amendContainer.add(stIDLabel);
        amendContainer.add(stID);

        amendContainer.add(nameLabel);
        amendContainer.add(nameField);

        amendContainer.add(courseIDLabel);
        amendContainer.add(courseID);

        amendContainer.add(bookNameLabel);
        amendContainer.add(bookName);

        amendContainer.add(changeBooking);
        amendContainer.add(cancelBooking);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);

        changeBooking.addActionListener(this);
        cancelBooking.addActionListener(this);
    }

    public void books(DefaultTableModel d){
        data = new Object[bookedCourses.size()][6];
        int x=0;
        for (int i = 0; i < bookedCourses.size(); i++) {
            BookedCourses b = bookedCourses.get(i);
            data[x] = new Object[]{b.getBookingID(), getStudent(b.getStudentID()).getId(), getStudent(b.getStudentID()).getName(), getCourse(b.getCourseID()).getId(), getCourse(b.getCourseID()).getName(), b.getCourseStatus()};
            System.out.println(b.getBookingID());
            x++;
        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try{

            int row = InfoShowingTable.rowAtPoint(e.getPoint());
            int column = InfoShowingTable.columnAtPoint(e.getPoint());
            if(row>=0 && column==0){
                id.setText((String) data[row][column]);
                stID.setText((String) data[row][column+1]);
                nameField.setText((String) data[row][column+2]);
                courseID.setText((String) data[row][column+3]);
                bookName.setText((String) data[row][column+4]);
                selected= books.get(row);
            }
        }catch (Exception f){
            System.out.println("Leave This Shit");
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
        if(e.getSource()==cancelBooking){
            for (BookedCourses bookedCourses : bookedCourses) {
                if(bookedCourses.getBookingID().equalsIgnoreCase(id.getText()) && !bookedCourses.getCourseStatus().equalsIgnoreCase("cancelled")){
                    bookedCourses.setCourseStatus("Cancelled");
                    JOptionPane.showMessageDialog(null,"Cancel Successfully:");
                    break;
                }
            }
        }else if(e.getSource()==changeBooking){
            for (BookedCourses bookedCourses : bookedCourses) {
                if(!bookedCourses.getCourseID().equalsIgnoreCase(courseID.getText()) && bookedCourses.getBookingID().equalsIgnoreCase(id.getText()) && !bookedCourses.getCourseStatus().equalsIgnoreCase("cancelled")){
                    bookedCourses.setCourseStatus("Changed");
                    if(getCourse(courseID.getText())!=null){
                        bookedCourses.setCourseID(courseID.getText());
                        JOptionPane.showMessageDialog(null,"Changed Successfully:");
                        break;
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid Course-ID");
                    }
                }
                if(bookedCourses.getCourseID().equalsIgnoreCase(courseID.getText())){
                    JOptionPane.showMessageDialog(null,"Cancelled Course Cannot be Changed");
                }
            }
        }
        int rowCount = d.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            d.removeRow(i);
        }
        books(d);
    }
}
