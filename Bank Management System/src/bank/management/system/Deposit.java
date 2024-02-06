package bank.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,700);
        add(image);
        
        JLabel text = new JLabel("Enter the Amount you want to deposit");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,12));
        text.setBounds(120,230,300,35);
        image.add(text);
                
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,12));
        amount.setBounds(120,280,230,25);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(270,370,80,20);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(270,400,80,20);
        back.addActionListener(this);
        image.add(back);        
        //getContentPane().setBackground(Color.WHITE);
        setSize(650,700);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to depost.");
            }else{
                try{
                    Conn conn = new Conn();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"')";
                conn.s.executeLargeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Deposit("");
    }
}
