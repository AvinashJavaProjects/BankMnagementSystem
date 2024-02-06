
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{

    long random;
    
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField ;
    JButton next;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;
    
    public SignupOne() {
        setLayout(null);
        setTitle("New Account application - Page 1");
        Random ran = new Random();
         random = Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formno = new JLabel("Aplication Form No. " + random );
        formno.setFont(new Font("Raleway",Font.BOLD,34));
        formno.setBounds(100,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1 : Personal Details" );
        personDetails.setFont(new Font("Raleway",Font.BOLD,20));
        personDetails.setBounds(150,80,400,30);
        add(personDetails);
        
        JLabel name = new JLabel("Name : " );
        name.setFont(new Font("Raleway",Font.BOLD,16));
        name.setBounds(60,140,100,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(200, 140, 300, 30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name : " );
        fname.setFont(new Font("Raleway",Font.BOLD,16));
        fname.setBounds(60,175,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(200, 175, 300, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth : " );
        dob.setFont(new Font("Raleway",Font.BOLD,16));
        dob.setBounds(60,210,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(200, 210, 300, 30);
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender : " );
        gender.setFont(new Font("Raleway",Font.BOLD,16));
        gender.setBounds(60,245,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(200, 245, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(300, 245, 70, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email : " );
        email.setFont(new Font("Raleway",Font.BOLD,16));
        email.setBounds(60,280,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(200, 280, 300, 30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status : " );
        marital.setFont(new Font("Raleway",Font.BOLD,16));
        marital.setBounds(60,315,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(200, 315, 80, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(300, 315, 90, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        others = new JRadioButton("Others");
        others.setBounds(420, 315, 70, 30);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup marriedgroup = new ButtonGroup();
        marriedgroup.add(married);
        marriedgroup.add(unmarried);
        marriedgroup.add(others);
        
        JLabel address = new JLabel("Address : " );
        address.setFont(new Font("Raleway",Font.BOLD,16));
        address.setBounds(60,350,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(200, 350, 300, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City : " );
        city.setFont(new Font("Raleway",Font.BOLD,16));
        city.setBounds(60,385,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(200, 385, 300, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State : " );
        state.setFont(new Font("Raleway",Font.BOLD,16));
        state.setBounds(60,420,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(200, 420, 300, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode : " );
        pincode.setFont(new Font("Raleway",Font.BOLD,16));
        pincode.setBounds(60,455,200,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(200, 455, 300, 30);
        add(pinTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(420, 510, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(600,650);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = "" + random; //long value gets converted into string if we concat it with "" example ("" +)
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        
        String marital = null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(others.isSelected()){
            marital="Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"',"
                        + "'"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
 
    public static void main(String args[]) {
        new SignupOne();
    }
}