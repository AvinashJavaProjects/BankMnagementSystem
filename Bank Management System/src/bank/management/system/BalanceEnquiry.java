package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import javax.swing.JFrame;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,700);
        add(image);
        
        back = new JButton("Back");
        back.setBounds(270,400,100,20);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
            
        JLabel text = new JLabel("Your current account balance is Rs. "+balance);
        text.setForeground(Color.WHITE);
        text.setBounds(120,230,300,35);
        image.add(text);
        
        setSize(650,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
