package application.GUIComponents.StudentGUI;

import application.DataClasses.Student;

import javax.swing.*;
import java.awt.*;

public class SDComponent extends JPanel {

    private JLabel address;
    private JLabel addressLabel;
    private JLabel dob;
    private JLabel dobLabel;
    private JLabel gender;
    private JLabel genderLabel;
    private JLabel id;
    private JLabel idLabel;
    private JLabel name;
    private JLabel nameLabel;
    private JLabel password;
    private JLabel passwordLabel;
    private JLabel phoneNumber;
    private JLabel pnLabel;

    public SDComponent(Student s) {

        idLabel = new JLabel(s.getId());
        nameLabel = new JLabel(s.getName());
        genderLabel = new JLabel(""+s.getGender());
        passwordLabel = new JLabel(s.getPassword());
        pnLabel = new JLabel(s.getEgPhoneNumber());
        dobLabel = new JLabel(s.getDob());
        addressLabel = new JLabel(s.getAddress());

        id = new JLabel("ID");
        name = new JLabel("Name");
        gender = new JLabel("Gender");
        password = new JLabel("Password");
        phoneNumber = new JLabel("Phone Number");
        dob = new JLabel("Date of Birth");
        address = new JLabel("Address");

        setLayout(new GridLayout(0, 2));

        idLabel.setHorizontalAlignment(SwingConstants.LEFT);
        nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
        genderLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passwordLabel.setHorizontalAlignment(SwingConstants.LEFT);
        pnLabel.setHorizontalAlignment(SwingConstants.LEFT);
        dobLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);

        id.setHorizontalAlignment(SwingConstants.LEFT);
        name.setHorizontalAlignment(SwingConstants.LEFT);
        gender.setHorizontalAlignment(SwingConstants.LEFT);
        password.setHorizontalAlignment(SwingConstants.LEFT);
        phoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
        dob.setHorizontalAlignment(SwingConstants.LEFT);
        address.setHorizontalAlignment(SwingConstants.LEFT);

        //Order is Mandatory Do not Disturb Please
        add(id);
        add(idLabel);
        add(name);
        add(nameLabel);
        add(gender);
        add(genderLabel);
        add(password);
        add(passwordLabel);
        add(phoneNumber);
        add(pnLabel);
        add(dob);
        add(dobLabel);
        add(address);
        add(addressLabel);
    }

}
