package application.GUIComponents.TeacherGUI;

import application.DataClasses.BookedCourses;
import application.DataClasses.Course;
import application.DataClasses.Student;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VBCComponent extends JPanel implements TuitionCenter {

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private Object[] columnName = new String [] {
            "BC-ID","S-ID", "S-Name", "C-ID", "C-Name"
    };

    public VBCComponent() {
        DefaultTableModel d = new DefaultTableModel(columnName,0);

        tableSP = new JScrollPane();
        InfoShowingTable = new JTable(d);

        setLayout(new BorderLayout());

        InfoShowingTable.setColumnSelectionAllowed(true);
        tableSP.setViewportView(InfoShowingTable);
        InfoShowingTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        Object[][] data = new Object[bookedCourses.size()][5];
        for (int i = 0; i < data.length; i++) {
            BookedCourses bc = bookedCourses.get(i);
            data[i] = new Object[]{bc.getBookingID(),getStudent(bc.getStudentID()).getId(), getStudent(bc.getStudentID()).getName(), getCourse(bc.getCourseID()).getId(), getCourse(bc.getCourseID()).getName()};
            System.out.println(getCourse(bc.getCourseID()).getName()+"    "+bc.getBookingID());
        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }


        add(tableSP, java.awt.BorderLayout.CENTER);
    }

}
