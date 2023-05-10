
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;

public class CheckOut extends JFrame implements ActionListener{
    Choice cCustomer;
    JLabel roomnumber,checkintime,checkouttime;
    JButton jcheckout,back,filldetail;
    CheckOut(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,200,30);
        text.setFont(new Font("Tahoma",Font.PLAIN,30));
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        
        
        cCustomer = new Choice();
        cCustomer.setBounds(150,80,150,25);
        add(cCustomer);
        
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,80,20,20);
        add(image);
        
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30,130,100,30);
        add(lblroom);
        
        roomnumber= new JLabel();
        roomnumber.setBounds(150,130,150,30);
        add(roomnumber);
        
        
        JLabel checkin = new JLabel("CheckIn Tme");
        checkin.setBounds(30,180,100,30);
        add(checkin);
        
        checkintime= new JLabel();
        checkintime.setBounds(150,180,150,30);
        add(checkintime);
        
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            while(rs.next()){
                cCustomer.add(rs.getString("number"));
                roomnumber.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
                
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        JLabel checkout = new JLabel("Checkout Tme");
        checkout.setBounds(30,230,100,30);
        add(checkout);
        
        Date date = new Date();
        checkouttime= new JLabel("" +date);
        checkouttime.setBounds(150,230,150,30);
        add(checkouttime);
        
        jcheckout = new JButton("CheckOut");
        jcheckout.setForeground(Color.WHITE);
        jcheckout.setBackground(Color.BLACK);
        jcheckout.setBounds(30,270,150,30);
        jcheckout.addActionListener(this);
        add(jcheckout);
        
        
        
        back = new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(200,270,150,30);
        back.addActionListener(this);

        add(back);
        
        filldetail = new JButton("Fill Detail");
        filldetail.setForeground(Color.WHITE);
        filldetail.setBackground(Color.BLACK);
        filldetail.setBounds(100,320,150,30);
        filldetail.addActionListener(this);

        add(filldetail);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(360,50,400,250);
        add(image2);
        
        
        
        
        
        
        
        
        
        
        setBounds(300,200,800,400);
        setVisible(true);
        
    }
    public static void main(String[] args){
        new CheckOut();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==jcheckout){
            String query = "delete from customer where number = '"+cCustomer.getSelectedItem()+"'" ;
            String query2 = "update room set availability = 'Available' where roomnumber = '"+roomnumber.getText()+"'";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout done");
                setVisible(false);
                new Reception();
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
        else if(ae.getSource()==filldetail){
            try{
            Conn conn = new Conn();
            ResultSet rs2 = conn.s.executeQuery("select * from customer where number = '"+cCustomer.getSelectedItem()+"'");
            while(rs2.next()){
                
                roomnumber.setText(rs2.getString("room"));
                checkintime.setText(rs2.getString("checkintime"));
                
                
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
            
        }
    }
    
}
