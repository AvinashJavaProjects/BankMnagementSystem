package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    
    JButton login ,clear ,signUp;
    JTextField cardTextField;
    JPasswordField  pinTextField;      
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(270, 50, 400, 40);
        add(text);
        
        JLabel cardNo = new JLabel("Card No. :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,30));
        cardNo.setBounds(120, 150, 400, 40);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300,150, 230,30);
        cardTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,30));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220, 230,30);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(250, 100);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();           
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==signUp){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
