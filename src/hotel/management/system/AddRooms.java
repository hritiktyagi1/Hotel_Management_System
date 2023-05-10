
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    JButton addRooms,cancel;
    JTextField roomField,priceField;
    JComboBox jAvailable,jCStatus,jBedTypes;
    AddRooms(){
        setBounds(330,200,940,470);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("Add Rooms");
        heading.setBounds(160,40,150,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        
        JLabel roomNo = new JLabel("Room Number");
        roomNo.setBounds(50,100,150,30);
        roomNo.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(roomNo);
        
        roomField= new JTextField();
        roomField.setBounds(220,100,150,30);
        add(roomField);
        
        
        JLabel available = new JLabel("Available");
        available.setBounds(50,150,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(available);
        
        String str[] ={"Available","Ocupied"};
        jAvailable = new JComboBox(str);
        jAvailable.setBounds(220,150,150,30);
        add(jAvailable);
        
        JLabel cStatus = new JLabel("Cleaning Status");
        cStatus.setBounds(50,200,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(cStatus);
        
        String str1[] ={"Cleaned","Dirty"};
        jCStatus = new JComboBox(str1);
        jCStatus.setBounds(220,200,150,30);
        add(jCStatus);
        
        JLabel price = new JLabel("Price");
        price.setBounds(50,250,150,30);
        price.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(price);
        
        priceField= new JTextField();
        priceField.setBounds(220,250,150,30);
        add(priceField);
        
        
        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(50,300,150,30);
        bedType.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(bedType);
        
        String str2[] ={"Single","Double"};
        jBedTypes = new JComboBox(str2);
        jBedTypes.setBounds(220,300,150,30);
        add(jBedTypes);
        
        addRooms = new JButton("Add Rooms");
        addRooms.setBounds(50,360,150,30);
        addRooms.setBackground(Color.BLACK);
        addRooms.setForeground(Color.WHITE);
        addRooms.addActionListener(this);
        add(addRooms);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220,360,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,450,350);
        add(image);
        
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== addRooms){
            String roomNumber = roomField.getText();
            String availability = (String)jAvailable.getSelectedItem();
            String status = (String)jCStatus.getSelectedItem();
            String price = priceField.getText();
            String bedType = (String)jBedTypes.getSelectedItem();
            
            try{
                Conn conn = new Conn();
                String str = "insert into room values('"+roomNumber+"','"+availability+"','"+status+"','"+price+"','"+bedType+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "New Room Added Successfully");
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== cancel){
            setVisible(false);
        }
        
    }
    public static void main(String[] args){
        new AddRooms();
    }
    
}
