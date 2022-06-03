package application.GUIComponents.StartGUI;

import application.DataClasses.*;
import application.GUIComponents.LoginGUI.LoginGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartGUI extends JPanel implements ActionListener, TuitionCenter {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private JPanel centerContainer;
    private JPanel libraianPanel;
    private JPanel librarianImageContainer;
    private JPanel nameContainer;
    private JPanel studentPanel;
    private JPanel teacherImageContainer;
    private JPanel teacherPanel;

    private JLabel appName;

    private JButton librarianButton;
    private JButton studentButton;
    private JButton teacherButton;

    public StartGUI() {

        Student st = new Student("st-123","01/02/22", 'M',"Salahuhdin", "Boys Hostel#36", "1234","03006753534");
        Student st1 = new Student("st-124","02/02/22", 'M',"Farman", "Boys Hostel#36", "1234","03006753534");
        Student st2 = new Student("st-125","03/23/22", 'F',"Fiza", "Girls Hostel#36", "1ads4","032506753534");
        Student st3 = new Student("st-126","04/02/22", 'M',"Asghar", "Boys Hostel#36", "15634","03006753534");
        Student st4 = new Student("st-127","05/02/22", 'M',"Faizan", "Boys Hostel#36", "1234","03006753534");
        Student st5 = new Student("st-128","06/02/22", 'M',"Sultan", "Boys Hostel#36", "1234","03006753534");
        Student st6 = new Student("st-129","07/23/22", 'F',"Izzah", "Girls Hostel#36", "1ads4","032506753534");
        Student st7 = new Student("st-130","08/02/22", 'M',"Taj", "Boys Hostel#36", "15634","03006753534");
        Student st8= new Student("st-131","09/02/22", 'M',"Tayyab", "Boys Hostel#36", "1234","03006753534");
        Student st9 = new Student("st-132","10/02/22", 'M',"Khalil", "Boys Hostel#36", "1234","03006753534");
        Student st10 = new Student("st-133","01/23/22", 'F',"Hafsa", "Girls Hostel#36", "1ads4","032506753534");
        Student st11 = new Student("st-134","20/02/22", 'M',"Kamran", "Boys Hostel#36", "15634","03006753534");
        Student st12 = new Student("st-135","01/02/22", 'M',"Bilal", "Boys Hostel#36", "1234","03006753534");
        Student st13 = new Student("st-136","01/02/22", 'M',"Bilawal", "Boys Hostel#36", "1234","03006753534");
        Student st14 = new Student("st-137","01/23/22", 'F',"Kalsoom", "Girls Hostel#36", "1ads4","032506753534");
        Student st15 = new Student("st-138","20/02/22", 'M',"Hussain", "Boys Hostel#36", "15634","03006753534");
        Student st16 = new Student("st-139","01/02/22", 'M',"Saud", "Boys Hostel#36", "1234","03006753534");
        Student st17 = new Student("st-140","01/02/22", 'M',"Zulfiqar", "Boys Hostel#36", "1234","03006753534");
        Student st18 = new Student("st-141","01/23/22", 'F',"Arsalan", "Girls Hostel#36", "1ads4","032506753534");
        Student st19 = new Student("st-142","20/02/22", 'M',"Ayyan", "Boys Hostel#36", "15634","03006753534");
        Student st20 = new Student("st-143","01/02/22", 'M',"Qais", "Boys Hostel#36", "1234","03006753534");
        Student st21 = new Student("st-144","01/02/22", 'M',"Basit", "Boys Hostel#36", "1234","03006753534");
        Student st22 = new Student("st-145","01/23/22", 'F',"Javeria", "Girls Hostel#36", "1ads4","032506753534");
        Student st23 = new Student("st-146","20/02/22", 'M',"Talha", "Boys Hostel#36", "15634","03006753534");
        Student st24 = new Student("st-147","01/02/22", 'M',"Sabahat", "Boys Hostel#36", "1234","03006753534");
        Student st25 = new Student("st-148","01/02/22", 'M',"Farhad", "Boys Hostel#36", "1234","03006753534");
        Student st26 = new Student("st-149","01/23/22", 'F',"Samia", "Girls Hostel#36", "1ads4","032506753534");
        Student st27 = new Student("st-150","20/02/22", 'M',"Ali", "Boys Hostel#36", "15634","03006753534");
        Student st28 = new Student("st-151","01/02/22", 'M',"Rashid", "Boys Hostel#36", "1234","03006753534");
        Student st29 = new Student("st-152","01/02/22", 'M',"Fakhar", "Boys Hostel#36", "1234","03006753534");
        Student st30 = new Student("st-153","01/23/22", 'F',"Nimra", "Girls Hostel#36", "1ads4","032506753534");

        students.add(st);
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students.add(st6);
        students.add(st7);
        students.add(st8);
        students.add(st9);
        students.add(st10);
        students.add(st11);
        students.add(st12);
        students.add(st13);
        students.add(st14);
        students.add(st15);
        students.add(st16);
        students.add(st17);
        students.add(st18);
        students.add(st19);
        students.add(st20);
        students.add(st21);
        students.add(st22);
        students.add(st23);
        students.add(st24);
        students.add(st25);
        students.add(st26);
        students.add(st27);
        students.add(st28);
        students.add(st29);
        students.add(st30);

        Books b = new Books("B-123","LeaderShip");
        Books b1 = new Books("B-124","The Kite Runner");
        Books b2 = new Books("B-125","Mental Math");
        Books b3= new Books("B-126","Moon Light");
        Books b4 = new Books("B-127","Physics Revolution");
        Books b5 = new Books("B-128","Python Kivy");
        Books b6= new Books("B-129","Javascript Real World");
        Books b7 = new Books("B-130","Helpless");
        Books b8 = new Books("B-131","Functional English");

        books.add(b);
        books.add(b1);
        books.add(b2);
        books.add(b3);
        books.add(b4);
        books.add(b5);
        books.add(b6);
        books.add(b7);
        books.add(b8);

        Course c1 = new Course("C-123",15,"Maths", LocalDateTime.parse("01-06-2022 10:00", dtf));
        Course c2 = new Course("C-124",25,"English",LocalDateTime.parse("01-06-2022 10:00", dtf));
        Course c3 = new Course("C-125",19,"Physics",LocalDateTime.parse("01-05-2022 10:00", dtf));
        Course c4 = new Course("C-126",15,"Science",LocalDateTime.parse("01-05-2022 12:00", dtf));
        Course c5 = new Course("C-127",19,"Python",LocalDateTime.parse("01-04-2022 12:00", dtf));
        Course c6 = new Course("C-128",15,"Computer Arch",LocalDateTime.parse("01-04-2022 12:00", dtf));
        Course c7 = new Course("C-129",19,"Operating System",LocalDateTime.parse("01-05-2022 12:00", dtf));
        Course c8 = new Course("C-130",15,"Multi-varied Calculus",LocalDateTime.parse("01-01-2022 18:00", dtf));
        Course c9 = new Course("C-131",19,"Technical Report",LocalDateTime.parse("01-01-2022 18:00", dtf));



        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
        courses.add(c5);
        courses.add(c6);
        courses.add(c7);
        courses.add(c8);
        courses.add(c9);

        addBookedCourse("C-123","st-126");
        addBookedCourse("C-125","st-123");
        addBookedCourse("C-124","st-124");
        addBookedCourse("C-124","st-125");
        addBookedCourse("C-124","st-126");
        addBookedCourse("C-124","st-127");
        addBookedCourse("C-125","st-125");
        addBookedCourse("C-126","st-125");

        addStudentBook(getStudent("st-123"), b);
        addStudentBook(getStudent("st-123"), b1);
        addStudentBook(getStudent("st-123"), b2);
        addStudentBook(getStudent("st-124"), b3);
        addStudentBook(getStudent("st-125"), b3);
        addStudentBook(getStudent("st-123"), b3);


        //Some Setting of JPanel
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(660, 800));

        //Label Which Have Application Name
        appName = new JLabel("  Pi Tuition Center");

        //JPanels Which work as a Container only
        nameContainer = new JPanel();
        centerContainer = new JPanel();
        teacherImageContainer = new JPanel();
        librarianImageContainer = new JPanel();

        //JPanels which have images
        studentPanel = new JPanel();
        teacherPanel = new JPanel();
        libraianPanel = new JPanel();

        //Button which open Respective Windows
        studentButton = new JButton("Student");
        teacherButton = new JButton("Teacher");
        librarianButton = new JButton("Librarian");



        appName.setFont(new Font("Century Gothic", Font.BOLD, 24));
        appName.setForeground(new Color(255, 255, 255));

        nameContainer.setBackground(new Color(59, 48, 138));
        nameContainer.setPreferredSize(new Dimension(800,100));
        nameContainer.setLayout(new BoxLayout(nameContainer, BoxLayout.LINE_AXIS));
        nameContainer.add(appName);

        centerContainer.setLayout(new GridLayout());

        FlowLayout fl = new FlowLayout();
        fl.setVgap(200);
        fl.setHgap(150);
        fl.setAlignment(FlowLayout.CENTER);
        studentPanel.setLayout(fl);
        studentPanel.add(studentButton);
        studentPanel.add(teacherButton);
        studentPanel.add(librarianButton);

        teacherPanel.setLayout(new BorderLayout());
        teacherPanel.add(teacherImageContainer, BorderLayout.CENTER);

        libraianPanel.setLayout(new BorderLayout());
        libraianPanel.add(librarianImageContainer, BorderLayout.CENTER);

        centerContainer.add(studentPanel);

        add(centerContainer, BorderLayout.CENTER);
        add(nameContainer, BorderLayout.PAGE_START);

        librarianButton.addActionListener(this);
        studentButton.addActionListener(this);
        teacherButton.addActionListener(this);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(800, 600);
        StartGUI ms = new StartGUI();
        jf.add(ms);
        jf.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==librarianButton){
            System.out.println("Librarian Button");
            this.setVisible(false);
            LoginGUI.STATE = -1;
            LoginGUI.main(null);
        }
        else if(e.getSource()==studentButton){
            System.out.println("Student Button");
            LoginGUI.STATE = 1;
            LoginGUI.main(null);
        }
        else if(e.getSource()==teacherButton){
            System.out.println("Teahcer Button");
            LoginGUI.STATE = 0;
            LoginGUI.main(null);
        }
    }
}
