import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Created by JFormDesigner on Tue Aug 03 11:02:27 PDT 2021
 */



/**
 * @author unknown
 */
public class Database extends JFrame {

    Connection_1 con = new Connection_1();
    Connection_1 conObj = con.connect();

    public static void main(String[] args) {
        Database form1= new Database();
        form1.setVisible(true);

    }

    public void UpdateTable() throws SQLException {
        String quer1 = "Select * from Category";
        PreparedStatement query = conObj.prepareStatement(quer1);

        ResultSet rs=query.executeQuery();
        DefaultTableModel df = (DefaultTableModel) table1.getModel();

        rs.last();

        int z = rs.getRow();
        rs.beforeFirst();


        String [][] array = new String[0][];
        if(z>0){
            array=new String[z][2];
        }


        int j=0;

        while(rs.next()){
            array[j][0]= rs.getString("catcode");
            array[j][1]= rs.getString("catdesc");
            ++j;
        }


        String[] cols={"Category code", "category Description"};
        DefaultTableModel model = new DefaultTableModel(array,cols);
        table1.setModel(model);


    }
    public Database() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        label1 = new JLabel();
        txtCatCode = new JTextField();
        label2 = new JLabel();
        txtCatDesc = new JTextField();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        btnAdd = new JButton();
        btnEdit = new JButton();
        btnDelete = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "hidemode 3",
            // columns
            "[fill]" +
            "[fill]",
            // rows
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]" +
            "[]"));

        //---- label1 ----
        label1.setText("Enter category code");
        contentPane.add(label1, "cell 0 1");
        contentPane.add(txtCatCode, "cell 1 1");

        //---- label2 ----
        label2.setText("Enter category description");
        contentPane.add(label2, "cell 0 2");

        //---- txtCatDesc ----
        txtCatDesc.setColumns(32);
        contentPane.add(txtCatDesc, "cell 1 2");

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1, "cell 1 3");

        //---- btnAdd ----
        btnAdd.setText("Add");
        contentPane.add(btnAdd, "cell 1 4");

        //---- btnEdit ----
        btnEdit.setText("Edit");
        contentPane.add(btnEdit, "cell 1 4");

        //---- btnDelete ----
        btnDelete.setText("Delete");
        contentPane.add(btnDelete, "cell 1 4");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JLabel label1;
    private JTextField txtCatCode;
    private JLabel label2;
    private JTextField txtCatDesc;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
