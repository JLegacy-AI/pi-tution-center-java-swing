package application.GUIComponents.TeacherGUI;

import application.DataClasses.Student;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VSComponent extends JPanel implements TuitionCenter {

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private Object[] columnName = new String [] {
        "S-ID", "S-Name", "S-Address", "S-Password", "S-Gender", "S-PhoneNumber", "S-DOB"
    };

    public VSComponent(ArrayList<Student> students) {
        DefaultTableModel d = new DefaultTableModel(columnName,0);

        tableSP = new JScrollPane();
        InfoShowingTable = new JTable(d);

        setLayout(new BorderLayout());

        InfoShowingTable.setColumnSelectionAllowed(true);
        tableSP.setViewportView(InfoShowingTable);
        InfoShowingTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        Object[][] data = new Object[students.size()][7];
        for (int i = 0; i < data.length; i++) {
            Student s = students.get(i);
            data[i] = new Object[]{s.getId(), s.getName(), s.getAddress(), s.getPassword(), s.getGender(), s.getEgPhoneNumber(), s.getDob()};
            System.out.println(s.getName());
        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }


        add(tableSP, java.awt.BorderLayout.CENTER);
    }



}
