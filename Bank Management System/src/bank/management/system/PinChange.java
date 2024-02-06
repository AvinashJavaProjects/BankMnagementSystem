package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin ,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber ){  
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,700);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(160,220,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,15));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN : ");
        pintext.setBounds(115,260,120,25);
        pintext.setFont(new Font("Raleway",Font.BOLD,12));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,12));
        pin.setBounds(240,260,130,25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN : ");
        repintext.setBounds(115,290,120,25);
        repintext.setFont(new Font("Raleway",Font.BOLD,12));
        repintext.setForeground(Color.WHITE);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,12));
        repin.setBounds(240,290,130,25);
        image.add(repin);
        
        change =  new JButton("Change");
        change.setBounds(270,370,100,20);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(270,400,100,20);
        back.addActionListener(this);
        image.add(back);
        
        setSize(650,700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource() == change){
            try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if (!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN dose not match.");
                return;
            }
            
            if(npin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please enter new PIN.");
                 return;              
            }
            if(rpin.equals("")){
                 JOptionPane.showMessageDialog(null, "Please re-enter new PIN.");
                 return;              
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String query3 = "update signupthree set pinNumber = '"+rpin+"' where pinNumber = '"+pinnumber+"'";
            
            conn.s.executeLargeUpdate(query1);
            conn.s.executeLargeUpdate(query2);
            conn.s.executeLargeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN changed successfully.");
            
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }else{
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }
    } 
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
       
    }
}
