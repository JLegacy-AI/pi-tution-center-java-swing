package application.GUIComponents.TeacherGUI;

        import application.DataClasses.*;

        import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;

public class ANComponent extends JPanel implements MouseListener, ActionListener, TuitionCenter{

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"BC-ID","S-ID", "S-Name", "C-ID", "C-Name","Note"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    private JLabel idLabel;

    private JButton addNote;

    private JTextField id;


    private JScrollPane addressSP;



    private JTextField stID;
    private JTextField courseID;
    private JTextArea note;

    private JLabel stIDLabel;
    private JLabel courseIDLabel;
    private JLabel noteLabel;

    public ANComponent() {
        amendContainer = new JPanel();
        addressSP = new JScrollPane();

        idLabel = new JLabel("BC-ID");
        id = new JTextField("BC-ID");

        stID = new JTextField("Student-ID");
        stIDLabel = new JLabel("Student-ID");


        courseID = new JTextField("Book-ID");
        courseIDLabel = new JLabel("Book-ID");

        note = new JTextArea("");
        noteLabel = new JLabel("Note:");

        addNote = new JButton("Add Note");

        stID.setEnabled(false);
        courseID.setEnabled(false);

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


        note.setLineWrap(true);
        addressSP.setViewportView(note);

        amendContainer.add(idLabel);
        amendContainer.add(id);

        amendContainer.add(stIDLabel);
        amendContainer.add(stID);

        amendContainer.add(courseIDLabel);
        amendContainer.add(courseID);

        amendContainer.add(noteLabel);
        amendContainer.add(addressSP);


        amendContainer.add(addNote);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);

        addNote.addActionListener(this);
    }

    public void books(DefaultTableModel d){
        data = new Object[bookedCourses.size()][6];
        int x=0;
        for (int i = 0; i < bookedCourses.size(); i++) {
            BookedCourses b = bookedCourses.get(i);
            String status = "";
            if(getNote(b.getBookingID())==null){
                status = "No Note";
            }else{
                status = "Note Added";
            }

            data[x] = new Object[]{b.getBookingID(), getStudent(b.getStudentID()).getId(), getStudent(b.getStudentID()).getName(), getCourse(b.getCourseID()).getId(), getCourse(b.getCourseID()).getName(), status};
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
                courseID.setText((String) data[row][column+3]);
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
        if(e.getSource()==addNote){

            if(!id.getText().isBlank() && getBookedCourse(id.getText())!=null){
                if(getNote(id.getText())!=null){
                    JOptionPane.showMessageDialog(null,"Already Note Added:\n"+getNote(id.getText()));
                    return;
                }
                if(!note.getText().isBlank()){
                    Notes note = new Notes();
                    note.setNotes(this.note.getText());
                    note.setBid(id.getText());
                    notes.add(note);
                }else{
                    JOptionPane.showMessageDialog(null, "PLease Add Something in Message");
                }

                note.setText("");

            }else{
                JOptionPane.showMessageDialog(null,"You Entered Invalid Booking Id.");
            }
        }

        int rowCount = d.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            d.removeRow(i);
        }
        books(d);

    }

}

