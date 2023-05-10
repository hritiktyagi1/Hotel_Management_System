
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class Reception extends JFrame implements ActionListener{
    JButton newCustomerForm,room,department,allEmpInfo,cusInfo,manInfo,checkOut,updateStatus,updateRoomStatus,pickUpService,searchRoom,logOut;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        newCustomerForm = new JButton("New Customer Form");
        newCustomerForm.setBounds(10,50,200,30);
        newCustomerForm.setBackground(Color.BLACK);
        newCustomerForm.setForeground(Color.WHITE);
        newCustomerForm.addActionListener(this);
        add(newCustomerForm);
        
        room = new JButton("Room");
        room.setBounds(10,100,200,30);
        room.setBackground(Color.BLACK);
        room.setForeground(Color.WHITE);
        room.addActionListener(this);
        add(room);
        
        department = new JButton("Department");
        department.setBounds(10,150,200,30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        department.addActionListener(this);
        add(department);
        
        
        allEmpInfo = new JButton("All Employee Information");
        allEmpInfo.setBounds(10,200,200,30);
        allEmpInfo.setBackground(Color.BLACK);
        allEmpInfo.setForeground(Color.WHITE);
        allEmpInfo.addActionListener(this);
        add(allEmpInfo);
        
        cusInfo = new JButton("Customer Information");
        cusInfo.setBounds(10,250,200,30);
        cusInfo.setBackground(Color.BLACK);
        cusInfo.setForeground(Color.WHITE);
        cusInfo.addActionListener(this);
        add(cusInfo);
        
        manInfo = new JButton("Manager Information");
        manInfo.setBounds(10,300,200,30);
        manInfo.setBackground(Color.BLACK);
        manInfo.setForeground(Color.WHITE);
        manInfo.addActionListener(this);
        add(manInfo);
        
        checkOut = new JButton("Check Out");
        checkOut.setBounds(10,350,200,30);
        checkOut.setBackground(Color.BLACK);
        checkOut.setForeground(Color.WHITE);
        checkOut.addActionListener(this);
        add(checkOut);
        
        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10,400,200,30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.addActionListener(this);
        add(updateStatus);
        
        updateRoomStatus = new JButton("Update Room Status");
        updateRoomStatus.setBounds(10,450,200,30);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.setForeground(Color.WHITE);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);
        
        pickUpService = new JButton("Pick Up Service");
        pickUpService.setBounds(10,500,200,30);
        pickUpService.setBackground(Color.BLACK);
        pickUpService.setForeground(Color.WHITE);
        pickUpService.addActionListener(this);
        add(pickUpService);
        
        searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,550,200,30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
        logOut = new JButton("Logout");
        logOut.setBounds(10,600,200,30);
        logOut.setBackground(Color.BLACK);
        logOut.setForeground(Color.WHITE);
        logOut.addActionListener(this);
        add(logOut);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,50,500,500);
        add(image);
        
        setBounds(350,100,800,700);
        setVisible(true);
        
        }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomerForm){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==room){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==department){
            setVisible(false);
            new Departments();
        }
        else if(ae.getSource()==allEmpInfo){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource()==cusInfo){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource()==manInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource()==searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource()==updateStatus){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource()==updateRoomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource()==pickUpService){
            setVisible(false);
            new Pickup();
        }
        else if(ae.getSource()==checkOut){
            setVisible(false);
            new CheckOut();
        }
        else if(ae.getSource()==logOut){
            setVisible(false);
            System.exit(0);
           
        }
        
    }
    public static void main(String[] args){
        new Reception();
    }
    
}
