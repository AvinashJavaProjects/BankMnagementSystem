package bank.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{

  
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton eyes,eno,syes,sno;
    JComboBox religon,category,income,occupation,education ;
    String formno;
    
    public SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        Random ran = new Random();
        setTitle("New Account application - Page 2");
                
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details" );
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,20));
        additionalDetails.setBounds(150,80,400,30);
        add(additionalDetails);
        
        JLabel religionlabel = new JLabel("Religion : " );
        religionlabel.setFont(new Font("Raleway",Font.BOLD,16));
        religionlabel.setBounds(60,140,100,30);
        add(religionlabel);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christan","Other"};
        religon = new JComboBox(valReligion);
        religon.setBounds(200, 140, 300, 30);
        add(religon);

        JLabel categoryLabel = new JLabel("Category : " );
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,16));
        categoryLabel.setBounds(60,175,200,30);
        add(categoryLabel);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(200, 175, 300, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel incomeLabel = new JLabel("Income : " );
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,16));
        incomeLabel.setBounds(60,210,200,30);
        add(incomeLabel);
        
        String incomeCategory[] = {"null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(200, 210, 300, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel labelEducational = new JLabel("Educational" );
        labelEducational.setFont(new Font("Raleway",Font.BOLD,16));
        labelEducational.setBounds(60,245,200,30);
        add(labelEducational);
                         
        JLabel labelQualification = new JLabel("Qualification : " );
        labelQualification.setFont(new Font("Raleway",Font.BOLD,16));
        labelQualification.setBounds(60,265,200,30);
        add(labelQualification);
        
        String educationalValue[] = {"Non-Graduation","Graduate","Post-Graduate","Doctrate","Other"};
        education = new JComboBox(educationalValue);
        education.setBounds(200, 260, 300, 30);
        education.setBackground(Color.WHITE);
        add(education);
         
        JLabel labelOccupation = new JLabel("Occupation : " );
        labelOccupation.setFont(new Font("Raleway",Font.BOLD,16));
        labelOccupation.setBounds(60,315,200,30);
        add(labelOccupation);
        
        String occupationalValue[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        occupation = new JComboBox(occupationalValue);
        occupation.setBounds(200, 315, 300, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
      
        JLabel panNumber = new JLabel("Pan No. : " );
        panNumber.setFont(new Font("Raleway",Font.BOLD,16));
        panNumber.setBounds(60,350,200,30);
        add(panNumber);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(200, 350, 300, 30);
        add(pan);
        
        JLabel labelAadhar = new JLabel("Aadhar No. : " );
        labelAadhar.setFont(new Font("Raleway",Font.BOLD,16));
        labelAadhar.setBounds(60,385,200,30);
        add(labelAadhar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(200, 385, 300, 30);
        add(aadhar);
        
        JLabel labelSeniorCitizen = new JLabel("Senior Citizen : " );
        labelSeniorCitizen.setFont(new Font("Raleway",Font.BOLD,16));
        labelSeniorCitizen.setBounds(60,420,200,30);
        add(labelSeniorCitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(210, 420, 80, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(300, 420, 80, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
     
        ButtonGroup scitizengroup = new ButtonGroup();
        scitizengroup.add(syes);
        scitizengroup.add(sno);
                      
        JLabel labelExistingAccount = new JLabel("Existing Account : " );
        labelExistingAccount.setFont(new Font("Raleway",Font.BOLD,16));
        labelExistingAccount.setBounds(60,455,200,30);
        add(labelExistingAccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(210, 455, 80, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(300, 455, 80, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
     
        ButtonGroup existingAccgroup = new ButtonGroup();
        existingAccgroup.add(eyes);
        existingAccgroup.add(eno);
        
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
        String sreligion = (String) religon.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();
        String seniorCitizen = null;
        if (syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if (eyes.isSelected()){
            existingAccount = "Yes";
        }else if(eno.isSelected()){
            existingAccount = "No";
        }    
        try{
            if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar No. is Required");
            }
            else{
                Conn c = new Conn();
                String query = "insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"',"
                        + "'"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorCitizen+"','"+existingAccount+"')";
                c.s.executeUpdate(query);
            }
            
            setVisible(false);
            new SignupThree(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
 
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
