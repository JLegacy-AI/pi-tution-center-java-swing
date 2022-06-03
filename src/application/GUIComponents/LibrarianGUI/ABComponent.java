package application.GUIComponents.LibrarianGUI;

import application.DataClasses.Books;
import application.DataClasses.TuitionCenter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ABComponent extends JPanel implements ActionListener, TuitionCenter {

    private JButton add;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JTextField id;
    private JTextField nameField;

    public ABComponent() {
        idLabel = new JLabel("ID");
        id = new JTextField("ID");
        nameLabel = new JLabel("Name");
        nameField = new JTextField("B-Name");
        add = new JButton("Add Book");

        setLayout(new GridLayout(0, 2, 30, 20));

        add(idLabel);
        add(id);
        add(nameLabel);
        add(nameField);
        add(add);

        add.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkFields()){
            addBook(id.getText(), nameField.getText());
        }
    }

    public boolean checkFields(){
        return  !nameField.getText().isBlank() && !id.getText().isBlank();
    }

}
