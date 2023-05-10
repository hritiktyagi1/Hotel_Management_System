package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeOfCar;
    JCheckBox available;
    Pickup(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pick up service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        
        typeOfCar = new Choice();
        typeOfCar.setBounds(160,100,150,20);
        add(typeOfCar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeOfCar.add(rs.getString("car_model"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
        
        
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(0,200,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(150,200,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300,200,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Car Company");
        l4.setBounds(450,200,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Car Model");
        l5.setBounds(600,200,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("Location");
        l6.setBounds(750,200,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Availability");
        l7.setBounds(900,200,100,20);
        add(l7);
        
        table = new JTable();
        table.setBounds(0,230,1000,300);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        setBounds(300,100,1000,700);
        setVisible(true);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(250,600,120,30);
        add(back);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(450,600,120,30);
        add(submit);
        
    }
    
    
    public static void main(String[] args){
        new Pickup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            try{
                String query1 = "select * from driver where car_model='"+typeOfCar.getSelectedItem()+"'";
                
                Conn conn = new Conn();
                ResultSet rs;
                
                    rs = conn.s.executeQuery(query1);
                
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Reception();
        }
        
    }
    
}


