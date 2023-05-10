
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
    
    JMenuItem reception,addRooms,addDriver,addEmployee;
    Dashboard(){
        setBounds(0,0,1550,1000);
        
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("The TAJ GROUP WELCOME YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,45) );
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.black);
        mb.add(hotel);
        
        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.black);
        mb.add(admin);
        
        addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        addRooms = new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        admin.add(addRooms);
        addDriver = new JMenuItem("ADD DRIVER");
        addDriver.addActionListener(this);
        admin.add(addDriver);
        
        
        
        
        
        
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== reception){
            new Reception();
            
        }else if(ae.getSource()==addEmployee){
            new AddEmployee();
            
        }else if(ae.getSource()==addRooms){
            new AddRooms();
            
        }else if(ae.getSource()==addDriver){
            new AddDriver();
            
        }
        
    }
    public static void main(String[] args){
        new Dashboard();
    }
    
}
