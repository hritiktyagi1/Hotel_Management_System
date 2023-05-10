
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox idCombo;
    Choice cRooms;
    JButton addCustomer,back;
    JRadioButton male,female;
    JTextField numberField,nameField,countryField,depositField;
    JLabel cInTime;
    AddCustomer(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("New Customer Form");
        heading.setBounds(100,20,300,30);
        heading.setFont(new Font("Raleway",Font.PLAIN,20));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel id = new JLabel("ID");
        id.setBounds(20,70,150,30);
        id.setFont(new Font("Raleway",Font.PLAIN,15));
        add(id);
        
        String[] str ={"Aadhar card","Driving Liceance","Pan card","Voter ID card","Passport"};
        idCombo = new JComboBox(str);
        idCombo.setBounds(200,70,150,30);
        idCombo.setBackground(Color.WHITE);
        add(idCombo);
        
        JLabel number = new JLabel("Number");
        number.setBounds(20,120,150,30);
        number.setFont(new Font("Raleway",Font.PLAIN,15));
        add(number);
        
        numberField = new JTextField();
        numberField.setBounds(200,120,150,30);
        add(numberField);
        
        
        
        
        JLabel name = new JLabel("Name");
        name.setBounds(20,170,150,30);
        name.setFont(new Font("Raleway",Font.PLAIN,15));
        add(name);
        
        nameField = new JTextField();
        nameField.setBounds(200,170,150,30);
        add(nameField);
        
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(20,220,150,30);
        gender.setFont(new Font("Raleway",Font.PLAIN,15));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(200,220,70,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(280,220,70,30);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        
        
        JLabel country = new JLabel("Country");
        country.setBounds(20,270,150,30);
        country.setFont(new Font("Raleway",Font.PLAIN,15));
        add(country);
        
        countryField = new JTextField();
        countryField.setBounds(200,270,150,30);
        add(countryField);
        
        
        
        
        
        JLabel allocatedRoomNu = new JLabel("Allocated Room Number");
        allocatedRoomNu.setBounds(20,320,170,30);
        allocatedRoomNu.setFont(new Font("Raleway",Font.PLAIN,15));
        add(allocatedRoomNu);
        
        cRooms = new Choice();
        
        try{
            Conn conn = new Conn();
            String query = "select * from room where availability='Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                cRooms.add(rs.getString("roomnumber"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        cRooms.setBounds(200,320,150,30);
        add(cRooms);
        
        
        
        JLabel checkInTime = new JLabel("Check in time");
        checkInTime.setBounds(20,370,150,30);
        checkInTime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkInTime);
        
        Date date = new Date();
        cInTime = new JLabel(""+date);
        cInTime.setBounds(200,370,170,30);
        cInTime.setFont(new Font("Raleway",Font.BOLD,12));
        add(cInTime);
        
        
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(20,420,150,30);
        deposit.setFont(new Font("Raleway",Font.PLAIN,15));
        add(deposit);
        
        depositField = new JTextField();
        depositField.setBounds(200,420,150,30);
        add(depositField);
        
        
        
        
        addCustomer = new JButton("Add Customer");
        addCustomer.setBounds(30,470,150,30);
        addCustomer.setBackground(Color.BLACK);
        addCustomer.setForeground(Color.WHITE);
        addCustomer.addActionListener(this);
        add(addCustomer);
        
        back = new JButton("Back");
        back.setBounds(200,470,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,130,300,300);
        add(image);
        
        
        
        
        
        setBounds(350,200,800,600);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addCustomer){
            String id = (String)idCombo.getSelectedItem();
            String number = numberField.getText();
            String name = nameField.getText();
            String gender = null;
            if(male.isSelected()){
                gender = "Male";
            }else if(female.isSelected()){
                gender = "Female";
            }
            String country = countryField.getText();
            String room = cRooms.getSelectedItem();
            String time = cInTime.getText();
            String deposit = depositField.getText();
            
            try{
                Conn conn = new Conn();
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set availability = 'ocupied' where roomnumber= '"+room+"'";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "New customer added successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
            
        }
        
    }
    public static void main(String[] args){
        new AddCustomer();
    }
    
}
