


package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    CustomerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       
        
        JLabel l1 = new JLabel("Document");
        l1.setBounds(0,10,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Number");
        l2.setBounds(100,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Nmae");
        l3.setBounds(200,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(300,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(400,10,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(500,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Check in time");
        l7.setBounds(600,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(700,10,100,20);
        add(l8);
        
        table = new JTable();
        table.setBounds(0,40,800,400);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
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
        new CustomerInfo();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Reception();
        
    }
    
}

