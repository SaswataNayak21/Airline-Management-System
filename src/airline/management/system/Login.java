/*package airline.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JButton submit, reset , close;
    JTextField tfusername;
    JPasswordField tfpassword;
    
    
    public Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblusername = new  JLabel("Username:");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        add(tfpassword);
        
        JLabel lblpassword = new  JLabel("Password:");
        lblpassword.setBounds(20,60,100,20);
        add(lblpassword);
        
        reset = new JButton("Reset");
        reset.setBounds(40 , 120 , 120 , 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("Submit");
        submit.setBounds(190 , 120 , 120 , 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("Close");
        close.setBounds(120 , 160 , 120 , 20);
        close.addActionListener(this);
        add(close);
        
        setSize(400,250);
        setLocation(600 , 250);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
     if(ae.getSource()== submit ){
         String username = tfusername.getText();
         String passsword = tfpassword.getText();
         
         try{
           Conn c = new Conn();
           
           String query = "select * from login where username = '" + username + "'and password = '" + passsword+"'";
           ResultSet rs = c.s.executeQuery(query);
           
           if (rs.next()){
               new Home();
               setVisible(false);
           }else{
               JOptionPane.showMessageDialog(null, "Invalid Username or Password");
               setVisible(false);
           }
         }catch(Exception e){
           e.printStackTrace();
         }
     }else if(ae.getSource()== close){
         setVisible(false);
     }else if(ae.getSource()== reset){
         tfusername.setText("");
         tfpassword.setText("");
     }
    }
    
    public static void main(String[] args ){
      new Login();  
    }
    
}
*/


package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    JButton submit, reset, close;
    JTextField tfusername;
    JPasswordField tfpassword;

    public Login() {
        setTitle("Airline Management Login");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username:");
        lblusername.setBounds(50, 30, 100, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(160, 30, 180, 25);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password:");
        lblpassword.setBounds(50, 70, 100, 25);
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(160, 70, 180, 25);
        add(tfpassword);

        submit = new JButton("Login");
        submit.setBounds(50, 120, 90, 30);
        styleButton(submit);
        submit.addActionListener(this);
        add(submit);

        reset = new JButton("Reset");
        reset.setBounds(150, 120, 90, 30);
        styleButton(reset);
        reset.addActionListener(this);
        add(reset);

        close = new JButton("Close");
        close.setBounds(250, 120, 90, 30);
        styleButton(close);
        close.addActionListener(this);
        add(close);

        setSize(400, 220);
        setLocation(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void styleButton(JButton btn) {
        btn.setBackground(new Color(0, 102, 204));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfusername.getText().trim();
            String password = new String(tfpassword.getPassword()).trim();

            try {
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    new Home();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == reset) {
            tfusername.setText("");
            tfpassword.setText("");

        } else if (ae.getSource() == close) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
