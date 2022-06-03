package application.GUIComponents.TeacherGUI;

import application.DataClasses.*;
import application.GUIComponents.LibrarianGUI.VABComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherGUI extends JFrame implements ActionListener, TuitionCenter {

    private JLabel appName;
    private JLabel GUISTATUS;

    private JPanel nameContainer;
    private JPanel buttonContainers;
    private JPanel flexibleContainer;

    private JButton bookCourse;             //Done
    private JButton reports;                //Done
    private JButton registerStudent;        //Done
    private JButton changeBooking;          //Done
    private JButton viewAmendBooks;         //Done
    private JButton viewBookedCourse;       //Done
    private JButton viewStudent;            //Done
    private JButton addNote;                //Done

    private Color color = new Color(111, 129, 151);
    private Dimension buttonDimension = new Dimension(150, 30);

    public TeacherGUI() {

        nameContainer = new JPanel();
        buttonContainers = new JPanel();
        flexibleContainer = new JPanel();


        appName = new JLabel("    Pi Tuition Center");
        GUISTATUS = new JLabel("      @Teacher");

        registerStudent = new JButton("Register Student");
        viewStudent = new JButton("View Student");
        bookCourse = new JButton("Book Course");
        viewBookedCourse = new JButton("View Booked Course");
        changeBooking = new JButton("Change Booking");
        viewAmendBooks = new JButton("View/Amend Books");
        addNote = new JButton("Add Note");
        reports = new JButton("Reports");


        nameContainer.setBackground(new Color(99, 26, 81));

        appName.setFont(new Font("Century Gothic", Font.BOLD, 24));
        appName.setForeground(Color.WHITE);

        GUISTATUS.setForeground(Color.WHITE);

        nameContainer.setPreferredSize(new Dimension(800,100));
        nameContainer.setLayout(new BoxLayout(nameContainer, BoxLayout.LINE_AXIS));
        nameContainer.add(appName);
        nameContainer.add(GUISTATUS);

        buttonContainers.setBackground(new Color(245, 245, 245));
        buttonContainers.setPreferredSize(new Dimension(170, 60));
        buttonContainers.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));

        registerStudent.setForeground(color);
        registerStudent.setPreferredSize(buttonDimension);
        buttonContainers.add(registerStudent);

        viewStudent.setForeground(color);
        viewStudent.setPreferredSize(buttonDimension);
        buttonContainers.add(viewStudent);

        bookCourse.setForeground(color);
        bookCourse.setPreferredSize(buttonDimension);
        buttonContainers.add(bookCourse);

        viewBookedCourse.setForeground(color);
        viewBookedCourse.setPreferredSize(buttonDimension);
        buttonContainers.add(viewBookedCourse);

        changeBooking.setForeground(color);
        changeBooking.setPreferredSize(buttonDimension);
        buttonContainers.add(changeBooking);

        addNote.setForeground(color);
        addNote.setPreferredSize(buttonDimension);
        buttonContainers.add(addNote);

        viewAmendBooks.setForeground(color);
        viewAmendBooks.setPreferredSize(buttonDimension);
        buttonContainers.add(viewAmendBooks);


        reports.setForeground(color);
        reports.setPreferredSize(buttonDimension);
        buttonContainers.add(reports);

        setMinimumSize(new Dimension(1000,500));
        getContentPane().add(nameContainer, BorderLayout.PAGE_START);
        getContentPane().add(buttonContainers, BorderLayout.LINE_START);
        getContentPane().add(flexibleContainer, BorderLayout.CENTER);

        //Action Listener
        bookCourse.addActionListener(this);
        reports.addActionListener(this);
        registerStudent.addActionListener(this);
        changeBooking.addActionListener(this);
        viewAmendBooks.addActionListener(this);
        addNote.addActionListener(this);
        viewBookedCourse.addActionListener(this);
        viewStudent.addActionListener(this);

    }

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                TeacherGUI tg = new TeacherGUI();
                tg.setVisible(true);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == registerStudent){
            RSComponent rsComponent = new RSComponent();
            rsComponent.setPreferredSize(new Dimension(400,500));
            rsComponent.setVisible(true);
            addNode(rsComponent);
        }else if(e.getSource() == reports){
            System.out.println("Reports");
            RComponent r = new RComponent();
            addNode(r);
        }else if(e.getSource() == bookCourse){
            System.out.println("Book Course");
            BCComponent bcc = new BCComponent();
            addNode(bcc);
        }else if(e.getSource() == viewStudent){
            System.out.println("View Students");
            VSComponent vc = new VSComponent(students);
            vc.setPreferredSize(new Dimension(1000, 600));
            addNode(vc);
        }else if(e.getSource() == viewAmendBooks){
            System.out.println("View and Amend Books");
            VABComponent vab = new VABComponent();
            addNode(vab);
        }else if(e.getSource() == viewBookedCourse){
            System.out.println("View and Amend Booked Course");
            VBCComponent vbc = new VBCComponent();
            addNode(vbc);
        }else if(e.getSource() == changeBooking){
            System.out.println("Change Booking");
            VACComponent vac = new VACComponent();
            addNode(vac);
        }else if(e.getSource() == addNote){
            System.out.println("Add Note");
            ANComponent an = new ANComponent();
            addNode(an);
        }
    }

    public void addNode(Component node){
        for (Component component : flexibleContainer.getComponents()) {
            flexibleContainer.remove(component);
        }
        flexibleContainer.add(node);
        repaint();
        revalidate();
    }
}
