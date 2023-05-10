
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddDriver extends JFrame implements ActionListener {
    JButton addDriver,cancel;
    JTextField nameField,ageField,cCField,cMField,locationField;
    JComboBox jGender,jAvailable;
    AddDriver(){
        setBounds(225,175,1000,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        
        
        
        JLabel heading = new JLabel("Add Driver");
        heading.setBounds(160,40,150,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel name = new JLabel("Name");
        name.setBounds(50,100,150,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(name);
        
        nameField = new JTextField();
        nameField.setBounds(220,100,150,30);
        add(nameField);
        
        JLabel age = new JLabel("Age");
        age.setBounds(50,150,150,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(age);
        
        ageField = new JTextField();
        ageField.setBounds(220,150,150,30);
        add(ageField);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(50,200,150,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(gender);
        
        String str[] = {"Male","Female"};
        jGender= new JComboBox(str);
        jGender.setBounds(220,200,150,30);
        add(jGender);
        
        JLabel carCompany = new JLabel("Car Company");
        carCompany.setBounds(50,250,150,30);
        carCompany.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(carCompany);
        
        cCField = new JTextField();
        cCField.setBounds(220,250,150,30);
        add(cCField);
        
        JLabel carModel = new JLabel("Car Model");
        carModel.setBounds(50,300,150,30);
        carModel.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(carModel);
        
        cMField = new JTextField();
        cMField.setBounds(220,300,150,30);
        add(cMField);
        
        JLabel available = new JLabel("Available");
        available.setBounds(50,350,150,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(available);
        
        String str1[] = {"Available","Unavailable"};
        jAvailable= new JComboBox(str1);
        jAvailable.setBounds(220,350,150,30);
        add(jAvailable);
        
        JLabel location = new JLabel("Location");
        location.setBounds(50,400,150,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(location);
        
        locationField = new JTextField();
        locationField.setBounds(220,400,150,30);
        add(locationField);
        
        
        addDriver= new JButton("Add Driver");
        addDriver.setBounds(50,460,150,30);
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);
        add(addDriver);
        
        cancel= new JButton("Cancel");
        cancel.setBounds(220,460,150,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,450);
        
        add(image);
        
        
        
        
        
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addDriver){
            String name = nameField.getText();
            String age = ageField.getText();
            String carCompany = cCField.getText();
            String carModel= cMField.getText();
            String location = locationField.getText();
            String gender = (String)jGender.getSelectedItem();
            String availability= (String)jAvailable.getSelectedItem();
            try{
                Conn conn = new Conn();
   
                String query = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+carCompany+"','"+carModel+"','"+location+"','"+availability+"')";
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"New Driver added successfully");
                
                
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            
        }
        
    }
    public static void main(String[] args){
        new AddDriver();
    }
}
