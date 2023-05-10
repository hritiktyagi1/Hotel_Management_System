
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    
    JTextField nameField,ageField,salaryField,phoneField,emailField,aadharField;
    JComboBox jComb;
    JRadioButton male,female;
    JButton submit;
    
    AddEmployee(){
        setBounds(100,100,900,700);
        setLayout(null);
        
        JLabel name = new JLabel("Name");
        name.setBounds(100,100,100,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);
        
        nameField = new JTextField();
        nameField.setBounds(220,100,150,30);
        add(nameField);
        
        
        
        
        JLabel age = new JLabel("Age");
        age.setBounds(100,150,100,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);
        
        ageField = new JTextField();
        ageField.setBounds(220,150,150,30);
        add(ageField);
        
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(100,200,100,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(220,200,60,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(300,200,70,30);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        
        
        
        
        JLabel job = new JLabel("Job");
        job.setBounds(100,250,100,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);
        
        String str[] ={"Front Desk Cleark","Porters","House Keeping","Kitchen Staff","Room Service","Chefs","Waiter","Manager","Accountant"};
        jComb = new JComboBox(str);
        jComb.setBounds(220,250,150,30);
        add(jComb);
        
        
        
        JLabel salary = new JLabel("Salary");
        salary.setBounds(100,300,100,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);
        
        salaryField = new JTextField();
        salaryField.setBounds(220,300,150,30);
        add(salaryField);
        
        
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(100,350,100,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);
        
        phoneField = new JTextField();
        phoneField.setBounds(220,350,150,30);
        add(phoneField);
        
        
        JLabel email = new JLabel("Email");
        email.setBounds(100,400,100,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);
        
        emailField = new JTextField();
        emailField.setBounds(220,400,150,30);
        add(emailField);
        
        
        JLabel aadhar = new JLabel("Aadhar");
        aadhar.setBounds(100,450,100,30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(aadhar);
        
        aadharField = new JTextField();
        aadharField.setBounds(220,450,150,30);
        add(aadharField);
        
        
        submit = new JButton("Submit");
        submit .setBounds(100,500,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100,450,370);
        add(image);
        
        
        
        
        
        
        
        setVisible(true);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent ae){
        String name = nameField.getText();
        String age = ageField.getText();
        String salary = salaryField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String aadhar = aadharField.getText();
        
        String gender =null;
        
        if(male.isSelected()){
            gender ="Male";
        }
        else if(female.isSelected()){
            gender = "female";
        }
        
        String job = (String)jComb.getSelectedItem();
        
        try{
            Conn conn = new Conn();
            
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args){
        new AddEmployee();
    }
    
}
