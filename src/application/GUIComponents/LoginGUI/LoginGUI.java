package application.GUIComponents.LoginGUI;

import application.GUIComponents.LibrarianGUI.LibrarianGUI;
import application.GUIComponents.StudentGUI.StudentGUI;
import application.GUIComponents.TeacherGUI.RSComponent;
import application.GUIComponents.TeacherGUI.TeacherGUI;
import application.DataClasses.Student;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener, TuitionCenter {

    private JLabel appName;
    private JPanel buttonSpacer;
    private JLabel idLabel;
    private JPanel idLabelFieldContainer;
    private JPanel idSpacer;
    private JButton login;
    private JButton register;
    private JPanel loginButtonContainer;
    private JPanel nameContainer;
    private JPanel passowordSpacer;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JPanel passwordLabelFieldContainer;
    private JTextField userIDField;

    private Dimension spaceSize = new Dimension(500, 10);
    private Dimension fieldSize = new Dimension(200, 30);

    public static int STATE;

    public LoginGUI() {
        nameContainer = new JPanel();
        loginButtonContainer = new JPanel();
        idLabelFieldContainer = new JPanel();
        passwordLabelFieldContainer = new JPanel();

        idSpacer = new JPanel();
        passowordSpacer = new JPanel();
        buttonSpacer = new JPanel();

        appName = new JLabel("                Pi Tuition Center");
        idLabel = new JLabel("ID:                      ");
        passwordLabel = new JLabel("Password:      ");

        userIDField = new JTextField("User ID");
        passwordField = new JPasswordField("password");

        login = new JButton("Log In");
        register = new JButton("Register");

        register.setVisible(STATE==1);

        FlowLayout alignmentOnly = new FlowLayout();
        alignmentOnly.setAlignOnBaseline(true);

        nameContainer.setBackground(new Color(99, 26, 81));
        nameContainer.setPreferredSize(new Dimension(500, 100));
        nameContainer.setLayout(new BorderLayout());

        appName.setFont(new Font("Century Gothic", 1, 24)); // NOI18N
        appName.setForeground(new Color(255, 255, 255));


        userIDField.setPreferredSize(fieldSize);
        passwordField.setPreferredSize(fieldSize);


        idLabelFieldContainer.setPreferredSize(new Dimension(500, 50));
        passwordLabelFieldContainer.setPreferredSize(new Dimension(500, 50));


        idSpacer.setPreferredSize(new Dimension(500, 40));
        buttonSpacer.setPreferredSize(spaceSize);
        passowordSpacer.setPreferredSize(spaceSize);

        loginButtonContainer.setLayout(new BorderLayout());

        idLabelFieldContainer.add(idLabel);
        idLabelFieldContainer.add(userIDField);

        passwordLabelFieldContainer.add(passwordLabel);
        passwordLabelFieldContainer.add(passwordField);

        nameContainer.add(appName, BorderLayout.CENTER);
        loginButtonContainer.add(login, BorderLayout.SOUTH);
        loginButtonContainer.add(register, BorderLayout.NORTH);


        //Here Order is Very Important Take Care of it
        getContentPane().add(nameContainer);
        getContentPane().add(idSpacer);
        getContentPane().add(idLabelFieldContainer);
        getContentPane().add(passowordSpacer);
        getContentPane().add(passwordLabelFieldContainer);
        getContentPane().add(buttonSpacer);
        getContentPane().add(loginButtonContainer);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(204, 204, 255));
        setMinimumSize(new Dimension(500,450));
        getContentPane().setLayout(alignmentOnly);
        setResizable(false);

        //Action Listener
        login.addActionListener(this);
        register.addActionListener(this);
    }

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginGUI lg = new LoginGUI();
                lg.setVisible(true);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==register){
            RSComponent rs = new RSComponent();
            rs.setBounds(150,50,400,500);
            JFrame jf = new JFrame();
            jf.setLayout(null);
            jf.setResizable(false);
            jf.setMinimumSize(new Dimension(700,600));
            jf.setVisible(true);
            jf.add(rs);
            return;
        }
        if(STATE==-1){
            if(userIDField.getText().equals("lib123") && passwordField.getText().equals("7145")){
                this.setVisible(false);
                LibrarianGUI.main(null);
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! Librarian Invalid Info");
            }
        }else if(STATE==0){
            if(userIDField.getText().equals("teach123") && passwordField.getText().equals("7145")){
                this.setVisible(false);
                TeacherGUI.main(null);
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! Teacher Invalid Info");
            }

        }else if(STATE==1){
            Student st=null;
            System.out.println("Student");
            if((st = loginStudent(userIDField.getText(),passwordField.getText()))!=null){
                this.setVisible(false);
                StudentGUI.student = st;
                StudentGUI.main(null);
            }else{
                JOptionPane.showMessageDialog(null,"Sorry! Student Invalid Info");
            }
        }
    }
}
