
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
        String str[] = {"Single","Double"};
        bedtype = new JComboBox(str);
        bedtype.setBounds(170,100,120,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        available = new JCheckBox("Only show available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
        
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(0,200,100,20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(200,200,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Cleaned Status");
        l3.setBounds(400,200,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(600,200,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed Type");
        l5.setBounds(800,200,100,20);
        add(l5);
        
        table = new JTable();
        table.setBounds(0,230,1000,300);
        add(table);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from room");
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
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            try{
                String query1 = "select * from room where bed_types='"+bedtype.getSelectedItem()+"'";
                String query2 ="select * from room where availability = 'Available' AND bed_types = '"+bedtype.getSelectedItem()+"'";
                Conn conn = new Conn();
                ResultSet rs;
                if(available.isSelected()){
                    rs = conn.s.executeQuery(query2);
                }
                else{
                    rs = conn.s.executeQuery(query1);
                }
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

