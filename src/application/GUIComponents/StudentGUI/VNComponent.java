package application.GUIComponents.StudentGUI;

import application.DataClasses.*;
import application.GUIComponents.StudentGUI.StudentGUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VNComponent extends JPanel implements MouseListener, TuitionCenter{

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"BC-ID","S-ID", "S-Name", "C-ID", "C-Name","Note"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;


    public VNComponent() {
        amendContainer = new JPanel();

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





        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);

    }

    public void books(DefaultTableModel d){
        data = new Object[getTotalSize()][6];
        int x=0;
        for (int i = 0; i < bookedCourses.size(); i++) {
            BookedCourses b = bookedCourses.get(i);
            if(b.getStudentID().equalsIgnoreCase(StudentGUI.student.getId())){
                String status = "";
                if(getNote(b.getBookingID())==null){
                    status = "No Note";
                }else{
                    status = "Note Added";
                }
                data[x] = new Object[]{b.getBookingID(), getStudent(b.getStudentID()).getId(), getStudent(b.getStudentID()).getName(), getCourse(b.getCourseID()).getId(), getCourse(b.getCourseID()).getName(), status};
                x++;
            }
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
            if(row>=0 && column==0 && getNote((String)data[row][0])!=null){
                JOptionPane.showMessageDialog(null, getNote((String)data[row][0]));
            }else if(getNote((String)data[row][0])==null){
                JOptionPane.showMessageDialog(null, "Not Yet Note Added By Your Teacher.");
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


    public int getTotalSize(){
        int x=0;
        for (BookedCourses bc : bookedCourses) {
            if(bc.getStudentID().equalsIgnoreCase(StudentGUI.student.getId())){
                System.out.println();
                x++;
            }
        }

        return x;
    }
}
