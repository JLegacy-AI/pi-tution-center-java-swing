package application.GUIComponents.TeacherGUI;


import application.DataClasses.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RComponent extends JPanel implements TuitionCenter {

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"Course-ID","Course-Name","Time", "Revenue","Reviews"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    public RComponent() {
        amendContainer = new JPanel();

        amendContainer.setLayout(new GridLayout(0, 2, 30, 20));



        tableSP = new JScrollPane();

        setLayout(new BorderLayout());
        d = new DefaultTableModel(columnName,0);
        InfoShowingTable = new JTable(d);

        InfoShowingTable.setColumnSelectionAllowed(true);
        tableSP.setViewportView(InfoShowingTable);
        InfoShowingTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        books(d);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);
    }

    public void books(DefaultTableModel d){
        data = new Object[courses.size()][5];
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            System.out.println(c.getName()+"   courses");
            data[i] = new Object[]{c.getId(), c.getName(), c.getTime(),'\u00A4'+"   "+getDetails(c.getId())[0], getDetails(c.getId())[1]};
        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }
    }

    public float[] getDetails(String cid){
        float x=0;
        float sum=0;
        float review=0;
        for (BookedCourses cours : bookedCourses) {
            if(cid.equalsIgnoreCase(cours.getCourseID())){
                x++;
                sum+=getCourse(cours.getCourseID()).getPrice();
                review+=cours.getReview();
                System.out.println(cours.getReview()+"   "+cours.getBookingID());
            }
        }
        return new float[]{sum,review/x};
    }

}

