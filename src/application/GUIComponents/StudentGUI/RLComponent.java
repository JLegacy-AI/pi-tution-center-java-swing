package application.GUIComponents.StudentGUI;

import application.DataClasses.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class RLComponent extends JPanel implements MouseListener, ActionListener, TuitionCenter{

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"BC-ID","Student-ID", "Student-Name", "Course-ID", "Course-Name","Booking-Status"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    private JLabel idLabel;
    private JButton addReview;


    private JTextField id;

    private Books selected;

    private ArrayList<Books> books = StudentGUI.student.getNeedBooks();

    private JTextField rateLesson;
    private JLabel rateLessonLabel;

    private ButtonGroup bg = new ButtonGroup();
    private ArrayList<JRadioButton> reviewRadioButtonList = new ArrayList<>();


    public RLComponent() {

        amendContainer = new JPanel();

        idLabel = new JLabel("BC-ID");
        id = new JTextField("BC-ID");

        rateLesson = new JTextField("1-5");
        rateLessonLabel = new JLabel("Rate");


        addReview = new JButton("Add Review");
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

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        amendContainer.add(rateLessonLabel);
        for (int i=0; i<5; i++) {
            JRadioButton jrb = new JRadioButton(""+(i+1));
            jrb.addActionListener(this);
            jPanel.add(jrb);
            reviewRadioButtonList.add(jrb);
            bg.add(jrb);
        }
        amendContainer.add(jPanel);


        amendContainer.add(addReview);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);

        addReview.addActionListener(this);
    }

    public void books(DefaultTableModel d){
        data = new Object[studentNeedBookQuantity(StudentGUI.student.getId())][6];
        int x=0;
        for (int i = 0; i < bookedCourses.size(); i++) {
            BookedCourses b = bookedCourses.get(i);
            if(b.getStudentID().equalsIgnoreCase(StudentGUI.student.getId()) && !(b.getReview()>0)){
                data[x] = new Object[]{b.getBookingID(), getStudent(b.getStudentID()).getId(), getStudent(b.getStudentID()).getName(), getCourse(b.getCourseID()).getId(), getCourse(b.getCourseID()).getName(), b.getCourseStatus()};
                x++;
                System.out.println(b.getBookingID());
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
            if(row>=0 && column==0){
                id.setText((String) data[row][column]);
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
        if(e.getSource()==addReview){
            int r=-1;
            for (JRadioButton jrb : reviewRadioButtonList) {
                if(jrb.isSelected()){
                    r = Integer.parseInt(jrb.getText());
                    break;
                }
            }

            for (BookedCourses bookedCourses : bookedCourses) {
                if(bookedCourses.getBookingID().equalsIgnoreCase(id.getText()) && (r>0) ){
                        bookedCourses.setReview(r);
                        JOptionPane.showMessageDialog(null,"Reviewed Successfully");
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
