package application.GUIComponents.LibrarianGUI;

import application.DataClasses.Books;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VABComponent extends JPanel implements MouseListener, ActionListener, TuitionCenter {

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"B-ID", "B-Name"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    private JLabel idLabel;
    private JLabel nameLabel;

    private JButton add;

    private JTextField id;
    private JTextField nameField;

    private Books selected;

    public VABComponent() {
        amendContainer = new JPanel();
        idLabel = new JLabel("ID");
        id = new JTextField("ID");
        nameLabel = new JLabel("Name");
        nameField = new JTextField("Book-Name");
        add = new JButton("Add Book");

        amendContainer.setLayout(new GridLayout(0, 2, 30, 20));



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
        amendContainer.add(nameLabel);
        amendContainer.add(nameField);
        amendContainer.add(add);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);

        add.addActionListener(this);
    }

    public void books(DefaultTableModel d){
        data = new Object[books.size()][2];
        for (int i = 0; i < data.length; i++) {
            Books b = books.get(i);
            data[i] = new Object[]{b.getId(), b.getName()};
            System.out.println(b.getName());
        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = InfoShowingTable.rowAtPoint(e.getPoint());
        int column = InfoShowingTable.columnAtPoint(e.getPoint());
        if(row>=0 && column==0){
            id.setText((String) data[row][column]);
            nameField.setText((String) data[row][column+1]);
            selected= books.get(row);
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
        if(!id.getText().isBlank() && !nameField.getText().isBlank()){

            removeBook(selected);
            addBook(id.getText(), nameField.getText());

            int rowCount = d.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                d.removeRow(i);
            }
            books(d);

        }
    }

}