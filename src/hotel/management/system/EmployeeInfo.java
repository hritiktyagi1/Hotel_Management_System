
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    EmployeeInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(100,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(200,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(300,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(400,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(500,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(600,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar");
        l8.setBounds(700,10,100,20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0,40,800,400);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setBounds(300,200,800,600);
        setVisible(true);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(300,500,120,30);
        add(back);
        
    }
    
    
    public static void main(String[] args){
        new EmployeeInfo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
        
    }
    
}

