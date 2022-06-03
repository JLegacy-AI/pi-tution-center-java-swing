package application.GUIComponents.LibrarianGUI;


import application.DataClasses.Books;
import application.DataClasses.Student;
import application.DataClasses.TuitionCenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AVBComponent extends JPanel implements TuitionCenter {

    private JTable InfoShowingTable;
    private JScrollPane tableSP;
    private JPanel amendContainer;
    private Object[] columnName = new String [] {"S-ID","S-Name","B-ID", "B-Name"};
    DefaultTableModel d = new DefaultTableModel(columnName,0);
    private Object[][] data;

    private Books selected;

    public AVBComponent() {
        amendContainer = new JPanel();

        amendContainer.setLayout(new GridLayout(0, 2, 30, 20));



        tableSP = new JScrollPane();

        setLayout(new BorderLayout());
        d = new DefaultTableModel(columnName,0);
        InfoShowingTable = new JTable(d);

        InfoShowingTable.setColumnSelectionAllowed(true);
        tableSP.setViewportView(InfoShowingTable);
        InfoShowingTable.getColumnModel().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        books(d);

        add(tableSP, BorderLayout.CENTER);
        add(amendContainer, BorderLayout.SOUTH);
    }

    public void books(DefaultTableModel d){
        data = new Object[totalNeedBook()][4];
        for (int i = 0, j=0; i < students.size(); i++) {
            Student st = students.get(i);
            if(st.getNeedBooks().size()>0){
                for (Books needBook : st.getNeedBooks()) {
                    data[j] = new Object[]{st.getId(), st.getName(), needBook.getId(), needBook.getName()};
                    System.out.println(st.getName());
                    j++;
                }
            }

        }
        for (Object[] datum : data) {
            d.addRow(datum);
        }
    }

}

