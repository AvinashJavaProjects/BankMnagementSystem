package bank.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance_enquiry,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,700);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(150,250,700,35);
      //text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(112,325,120,25);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(244,325,130,25);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(112,350,120,25);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(244,350,130,25);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(112,375,120,25);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balance_enquiry = new JButton("Rs 10000");
        balance_enquiry.setBounds(244,375,130,25);
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);
        
        back = new JButton("BACK");
        back.setBounds(244,405,130,25);
        back.addActionListener(this);
        image.add(back);
                
        setSize(650,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!= back && balance < Integer.parseInt(amount) ){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" debitted successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                    
            }
        }
    }
    public static void main(String args[]) {
        new FastCash("");
    }
}
