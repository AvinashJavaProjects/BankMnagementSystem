package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("New Account application - Page 3");
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,20));
        l1.setBounds(180,20,300,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,20));
        type.setBounds(40,90,150,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(40,125,170,30);
        r1.setBackground(Color.WHITE);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(250,125,250,30);
        r2.setBackground(Color.WHITE);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(40,160,170,30);
        r3.setBackground(Color.WHITE);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(250,160,250,30);
        r4.setBackground(Color.WHITE);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Raleway",Font.BOLD,20));
        card.setBounds(40,200,250,30);
        add(card);
        
        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-4184");
        cardno.setFont(new Font("Raleway",Font.BOLD,20));
        cardno.setBounds(250,200,250,30);
        add(cardno);
        
        JLabel carddetails = new JLabel("Your 16-digit card number.");
        carddetails.setFont(new Font("Raleway",Font.BOLD,10));
        carddetails.setBounds(40,220,250,30);
        add(carddetails);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setBounds(40,245,250,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,20));
        pnumber.setBounds(250,245,250,30);
        add(pnumber);
        
        JLabel pindetails = new JLabel("Your 4 digit password.");
        pindetails.setFont(new Font("Raleway",Font.BOLD,10));
        pindetails.setBounds(40,265,250,30);
        add(pindetails);
        
        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Raleway",Font.BOLD,20));
        services.setBounds(40,300,250,30);
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD ,16));
        c1.setBounds(40,340,200,20);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD ,16));
        c2.setBounds(280,340,200,20);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD ,16));
        c3.setBounds(40,370,200,20);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD ,16));
        c4.setBounds(280,370,200,20);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD ,16));
        c5.setBounds(40,400,200,20);
        add(c5);
        
        c6 = new JCheckBox("eStatement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD ,16));
        c6.setBounds(280,400,200,20);
        add(c6);
        
        c7 = new JCheckBox("I hear by declare that the above entred details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD ,10));
        c7.setBounds(40,450,450,20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,12));
        submit.setBounds(180,530,100,30);
        submit.addActionListener(this);
        add(submit);       
        
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,12));
        cancel.setBounds(320,530,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(600,650);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        String accountType = null;
        if (ae.getSource()== submit){
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if (r3.isSelected()){
                accountType = "Current Account";
            }else if (r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
                
           Random random = new Random();
           String cardnumber = "" + Math.abs((random.nextLong()%90000000L)+504093600000000L);
           
           String pinnumber = ""+ Math.abs((random.nextLong()%9000L)+1000L);
           
           String facility = "";
           if(c1.isSelected()){
               facility = facility + " ATM Card";
           }else if(c2.isSelected()){
               facility = facility + " Internet Banking";
           }else if(c3.isSelected()){
               facility = facility + " Mobile Banking";
           }else if(c4.isSelected()){
               facility = facility + " Email & SMS Alerts";
           }else if(c5.isSelected()){
               facility = facility + " Cheque Book";
           }else if(c6.isSelected()){
               facility = facility + " E-Statement";
           }
           
           try{
               if(accountType.equals("")){
                   JOptionPane.showMessageDialog(null, "Account Type is Required");
               }else{
                   Conn conn = new Conn();
                   String query1 =  "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                   String query2 =  "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\nPin: "+pinnumber);
                   setVisible(false);
                   new Deposit(pinnumber).setVisible(false);
               }
               
               
               
               
           }catch(Exception e){
               System.out.println(e);
           }
          
           
        }else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String args[]) {
        new SignupThree("");
    }
}
