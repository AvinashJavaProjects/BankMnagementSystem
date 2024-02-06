package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance_enquiry,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,700);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(150,250,700,35);
      //  text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(112,325,120,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(244,325,130,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(112,350,120,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(244,350,130,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("PIN Change");
        pinchange.setBounds(112,375,120,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance_enquiry = new JButton("Balance Enquiry");
        balance_enquiry.setBounds(244,375,130,25);
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(244,405,130,25);
        exit.addActionListener(this);
        image.add(exit);
                
        setSize(650,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource() ==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource() == balance_enquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement){
            //setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    public static void main(String args[]) {
        new Transactions("");
    }
}
