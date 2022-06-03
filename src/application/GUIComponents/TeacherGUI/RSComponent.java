package application.GUIComponents.TeacherGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RSComponent extends JPanel implements ActionListener {

    private JPanel addressContainer;
    private JPanel radioContainer;

    private JScrollPane addressSP;

    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;

    private JTextField dayField;
    private JTextField monthField;
    private JTextField phoneNumberField;
    private JTextField studentIDField;
    private JTextField studentNameField;
    private JTextField studentPasswordField;
    private JTextField yearField;

    private JTextArea addressTextArea;

    private JButton register;

    private Dimension fieldSize = new Dimension(100, 30);

    public RSComponent() {

        addressSP = new JScrollPane();

        radioContainer = new JPanel();
        addressContainer = new JPanel();

        studentIDField = new JTextField("Student-ID");
        studentPasswordField = new JTextField("Password");
        studentNameField = new JTextField("Student-Name");
        dayField = new JTextField("DD");
        monthField = new JTextField("MM");
        yearField = new JTextField("YYYY");
        phoneNumberField = new JTextField("Phone Number");

        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        addressTextArea = new JTextArea("Address:");
        register = new JButton("Register");

        addressTextArea.setColumns(20);
        addressTextArea.setRows(5);

        addressContainer.setLayout(new GridLayout(1, 0, 20, 0));

        dayField.setPreferredSize(fieldSize);
        monthField.setPreferredSize(fieldSize);
        yearField.setPreferredSize(fieldSize);

        //Here Order is also Mandatory
        addressContainer.add(dayField);
        addressContainer.add(monthField);
        addressContainer.add(yearField);


        radioContainer.setLayout(new GridLayout());

        radioContainer.add(maleRadioButton);
        radioContainer.add(femaleRadioButton);

        addressSP.setViewportView(addressTextArea);

        //Here Order is Mandatory
        add(studentIDField);
        add(studentNameField);
        add(studentPasswordField);
        add(addressContainer);
        add(radioContainer);
        add(addressSP);
        add(phoneNumberField);
        add(register);

        //JPanel Size
        setMinimumSize(new Dimension(500, 450));
        setLayout(new GridLayout(0, 1, 10, 20));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(areFieldFilled()){
            System.out.println("Yes Filled");
        }else{
            System.out.println("Empty");
        }
    }

    public boolean areFieldFilled(){
        return !studentNameField.getText().isBlank() && !studentPasswordField.getText().isBlank() && !dayField.getText().isBlank() && !yearField.getText().isBlank() && !monthField.getText().isBlank() && !phoneNumberField.getText().isBlank() && !addressTextArea.getText().isBlank();
    }
}
