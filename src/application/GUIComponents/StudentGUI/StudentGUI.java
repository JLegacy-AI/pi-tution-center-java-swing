package application.GUIComponents.StudentGUI;

import application.DataClasses.Books;
import application.DataClasses.Course;
import application.DataClasses.Student;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame implements ActionListener, TuitionCenter {

    public static Student student = new Student("st-123","01/02/22", 'M',"Salahuhdin", "Boys Hostel#36", "1234","03006753534");

    private JPanel buttonContainers;
    private JPanel nameContainer;
    private JPanel flexibleContainer;

    private JLabel appName;
    private JLabel GUISTATUS;


    private JButton ViewDetail;         //Done
    private JButton bookBooks;          //Done
    private JButton bookCourse;         //Done
    private JButton viewAmendBook;      //Done
    private JButton viewAmendCourse;    //Done
    private JButton rateLesson;         //Done
    private JButton viewNote;

    private Color buttonColor = new Color(111, 129, 151);

    private Dimension buttonSize = new Dimension(160, 30);

    public StudentGUI() {

        nameContainer = new JPanel();
        buttonContainers = new JPanel();
        flexibleContainer = new JPanel();

        appName = new JLabel("    Pi Tuition Center");
        GUISTATUS = new JLabel("          @Student");

        ViewDetail = new JButton("View Detail");
        bookCourse = new JButton("Book Course");
        bookBooks = new JButton("Book Books");
        viewAmendCourse = new JButton("View & Amend Course");
        viewAmendBook = new JButton("View & Amend Book");
        rateLesson = new JButton("Rate Lesson");
        viewNote = new JButton("View Note");

        setBackground(new Color(28, 55, 91));

        nameContainer.setBackground(new Color(28, 55, 91));

        appName.setFont(new Font("Century Gothic", 1, 24)); // NOI18N
        appName.setForeground(new Color(245, 245, 245));

        GUISTATUS.setForeground(new Color(255, 255, 255));

        nameContainer.setLayout(new BoxLayout(nameContainer, BoxLayout.LINE_AXIS));
        nameContainer.setPreferredSize(new Dimension(800,100));
        nameContainer.add(appName);
        nameContainer.add(GUISTATUS);

        getContentPane().add(nameContainer, BorderLayout.PAGE_START);

        buttonContainers.setBackground(new Color(204, 204, 255));
        buttonContainers.setPreferredSize(new Dimension(180, 0));
        buttonContainers.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));

        ViewDetail.setForeground(buttonColor);
        ViewDetail.setPreferredSize(buttonSize);
        buttonContainers.add(ViewDetail);

        bookCourse.setForeground(buttonColor);
        bookCourse.setPreferredSize(buttonSize);
        buttonContainers.add(bookCourse);

        bookBooks.setForeground(buttonColor);
        bookBooks.setPreferredSize(buttonSize);
        buttonContainers.add(bookBooks);

        viewAmendCourse.setForeground(buttonColor);
        viewAmendCourse.setPreferredSize(buttonSize);
        buttonContainers.add(viewAmendCourse);

        viewAmendBook.setForeground(buttonColor);
        viewAmendBook.setPreferredSize(buttonSize);
        buttonContainers.add(viewAmendBook);

        rateLesson.setForeground(buttonColor);
        rateLesson.setPreferredSize(buttonSize);
        buttonContainers.add(rateLesson);

        viewNote.setForeground(buttonColor);
        viewNote.setPreferredSize(buttonSize);
        buttonContainers.add(viewNote);

        getContentPane().add(buttonContainers, BorderLayout.LINE_START);
        getContentPane().add(flexibleContainer, BorderLayout.CENTER);

        //Action Listeners
        ViewDetail.addActionListener(this);
        bookBooks.addActionListener(this);
        bookCourse.addActionListener(this);
        viewAmendBook.addActionListener(this);
        viewAmendCourse.addActionListener(this);
        rateLesson.addActionListener(this);
        viewNote.addActionListener(this);

        setMinimumSize(new Dimension(800,600));
    }


    public static void main(String args[]) {
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
                new StudentGUI().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ViewDetail){
            SDComponent sd = new SDComponent(student);
            sd.setPreferredSize(new Dimension(600,500));
            sd.setVisible(true);
            addNode(sd);
        }
        else if(e.getSource()==bookBooks){
            BBComponent bbc = new BBComponent();
            addNode(bbc);
        }
        else if(e.getSource()==bookCourse){
            BCComponent bcc = new BCComponent();
            addNode(bcc);
        }
        else if(e.getSource()==viewAmendBook){
            VABComponent vab = new VABComponent();
            addNode(vab);
        }
        else if(e.getSource()==viewAmendCourse){
            VACComponent vac = new VACComponent();
            addNode(vac);
        }
        else if(e.getSource()==rateLesson){
            RLComponent rl = new RLComponent();
            addNode(rl);
        }else if(e.getSource()==viewNote){
            JOptionPane.showMessageDialog(null,"Click on BC-ID to get Note About Booked Course \nThank You:)|(:");
            VNComponent vn = new VNComponent();
            addNode(vn);
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
