/*package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
     
    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);   
       
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220 , 20 , 500 , 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN , 36));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60 , 80 , 150 , 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN ,16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        setSize(900 , 600);
        setLocation(200,150);
        setVisible(true); 
    }
     public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
         try{
              Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
        
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
            setVisible(false);
         }catch(Exception e){
            e.printStackTrace();
         }
     }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
*/





package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE); // Light background for the form
        setLayout(null);

        // Header with blue-to-black gradient
        JPanel header = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 102, 204), getWidth(), 0, Color.BLACK);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setBounds(0, 0, 900, 70);
        header.setLayout(new BorderLayout());
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS", SwingConstants.CENTER);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        heading.setForeground(Color.WHITE);
        header.add(heading);
        add(header);

        // Labels and fields with a modern design
        createLabelAndTextField("Name", 80);
        tfname = createTextField(220, 80);

        createLabelAndTextField("Nationality", 130);
        tfnationality = createTextField(220, 130);

        createLabelAndTextField("Aadhar Number", 180);
        tfaadhar = createTextField(220, 180);

        createLabelAndTextField("Address", 230);
        tfaddress = createTextField(220, 230);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setForeground(Color.BLACK); // Dark text for better visibility
        add(lblgender);

        ButtonGroup gendergroup = new ButtonGroup();

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE); // Light background
        rbmale.setForeground(Color.BLACK);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE); // Light background
        rbfemale.setForeground(Color.BLACK);
        add(rbfemale);

        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);

        createLabelAndTextField("Phone", 330);
        tfphone = createTextField(220, 330);

        // Save Button
        JButton save = new JButton("SAVE");
        save.setBackground(new Color(0, 102, 204)); // Blue background for button
        save.setForeground(Color.WHITE);
        save.setFont(new Font("Tahoma", Font.BOLD, 16));
        save.setBounds(220, 380, 150, 35);
        save.addActionListener(this);
        save.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(save);

        // Customer image
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airline/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);

        // Frame config
        setSize(900, 600);
        setLocation(200, 150);
        setVisible(true);
    }

    private void createLabelAndTextField(String labelText, int yPos) {
        JLabel label = new JLabel(labelText);
        label.setBounds(60, yPos, 150, 25);
        label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        label.setForeground(Color.BLACK); // Dark text for better visibility
        add(label);
    }

    private JTextField createTextField(int xPos, int yPos) {
        JTextField textField = new JTextField();
        textField.setBounds(xPos, yPos, 150, 25);
        textField.setBackground(new Color(240, 240, 240)); // Light background for text fields
        textField.setForeground(Color.BLACK); // Dark text color
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
        textField.setCaretColor(Color.BLACK); // Black caret for better visibility
        add(textField);
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;

        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        try {
            Conn conn = new Conn();
            String query = "insert into passenger values('" + name + "', '" + nationality + "', '" + phone + "', '" + address + "', '" + aadhar + "', '" + gender + "')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");

            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
