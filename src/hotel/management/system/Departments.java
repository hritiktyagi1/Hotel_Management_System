
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Departments extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Departments(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(180,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(450,10,100,20);
        add(l2);
        
        
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setBounds(400,200,700,480);
        setVisible(true);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
    }
    
    
    public static void main(String[] args){
        new Departments();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
        
    }
    
}
