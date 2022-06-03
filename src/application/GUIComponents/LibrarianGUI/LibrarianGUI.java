package application.GUIComponents.LibrarianGUI;

import application.DataClasses.Books;
import application.DataClasses.TuitionCenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LibrarianGUI extends JFrame implements ActionListener, TuitionCenter {

    private JPanel nameContainer;
    private JPanel buttonsContainer;
    private JPanel amendContainer;
    private JPanel flexibleContainer;

    private JLabel appName;
    private JLabel GUISTATUS;


    private JButton addBooks;       //Done
    private JButton availableBooks; //Done
    private JButton viewAmendBooks; //Done


    public LibrarianGUI() {
        Books b = new Books("123","Paulo Cohelo");
        Books b1 = new Books("42","Pakistan");

        books.add(b);
        books.add(b1);



        nameContainer = new JPanel();
        buttonsContainer = new JPanel();
        flexibleContainer = new JPanel();
        amendContainer = new JPanel();

        appName = new JLabel("    Pi Tuition Center");
        GUISTATUS = new JLabel("          @Librarian");

        availableBooks = new JButton("Available Book");
        addBooks = new JButton("Add Book");
        viewAmendBooks = new JButton("View/Amend Book");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        nameContainer.setBackground(new Color(99, 26, 81));

        appName.setFont(new Font("Century Gothic", 1, 24)); // NOI18N
        appName.setForeground(new Color(255, 255, 255));

        GUISTATUS.setForeground(new Color(255, 255, 255));

        nameContainer.setLayout(new BoxLayout(nameContainer, BoxLayout.LINE_AXIS));
        nameContainer.setPreferredSize(new Dimension(800,100));
        nameContainer.add(appName);
        nameContainer.add(GUISTATUS);


        buttonsContainer.setBackground(new Color(245, 245, 245));
        buttonsContainer.setPreferredSize(new Dimension(180, 3));

        FlowLayout buttonContainerLayout = new FlowLayout(FlowLayout.CENTER, 5, 20);
        buttonContainerLayout.setAlignOnBaseline(true);
        buttonsContainer.setLayout(buttonContainerLayout);

        availableBooks.setForeground(new Color(111, 129, 151));
        availableBooks.setPreferredSize(new Dimension(150, 30));

        addBooks.setForeground(new Color(111, 129, 151));
        addBooks.setPreferredSize(new Dimension(150, 30));

        viewAmendBooks.setForeground(new Color(111, 129, 151));
        viewAmendBooks.setPreferredSize(new Dimension(150, 30));

        buttonsContainer.add(availableBooks);
        buttonsContainer.add(addBooks);
        buttonsContainer.add(viewAmendBooks);



        setMinimumSize(new Dimension(800,600));

        getContentPane().add(nameContainer, BorderLayout.PAGE_START);
        getContentPane().add(buttonsContainer, BorderLayout.LINE_START);
        getContentPane().add(flexibleContainer, BorderLayout.CENTER);
        getContentPane().add(amendContainer, BorderLayout.SOUTH);
        //Action Listener
        availableBooks.addActionListener(this);
        addBooks.addActionListener(this);
        viewAmendBooks.addActionListener(this);
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
                LibrarianGUI lb = new LibrarianGUI();
                lb.setPreferredSize(new Dimension(800,600));
                lb.setVisible(true);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==availableBooks){
            System.out.println("AvailAble Book");
            AVBComponent  avb = new AVBComponent();
            addNode(avb);
        }
        else if(e.getSource()==addBooks){
            System.out.println("Add Books");
            ABComponent ab= new ABComponent();
            addNode(ab);
        }
        else if(e.getSource()==viewAmendBooks){
            VABComponent vab = new VABComponent();
            addNode(vab);
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
