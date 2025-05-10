/*package airline.management.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Home extends JFrame implements ActionListener{
    
    public Home(){
      
        setLayout(null);
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);
       
       JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
       heading.setBounds(550, 75, 1000, 40);
       heading.setForeground(Color.BLACK);
       heading.setFont(new Font("Tahoma", Font.BOLD , 36));
       image.add(heading);
       
       JMenuBar menubar = new JMenuBar();
       setJMenuBar(menubar);
       
       JMenu details = new JMenu("DETAILS");
       menubar.add(details);
       
       JMenuItem flightDetails = new JMenuItem("Flight Details");
       flightDetails.addActionListener(this);
       details.add(flightDetails);
        
       JMenuItem customerDetails = new JMenuItem("Add Customer Details");
       customerDetails.addActionListener(this);
       details.add(customerDetails);
       
       JMenuItem bookFlight = new JMenuItem("Book Flight ");
       bookFlight.addActionListener(this);
       details.add(bookFlight);
       
       JMenuItem JourneyDetails = new JMenuItem("Journey Details");
       JourneyDetails.addActionListener(this);
       details.add(JourneyDetails);
       
       JMenuItem ticketCancel = new JMenuItem("Cancel Ticket ");
       ticketCancel.addActionListener(this);
       details.add(ticketCancel);
       
       JMenu ticket = new JMenu("TICKET");
       ticket.setForeground(Color.red);
       menubar.add(ticket);
       
       JMenuItem BoardingPass = new JMenuItem("Boarding Pass Details");
       BoardingPass.addActionListener(this);
       ticket.add(BoardingPass);
             
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
        
    public void actionPerformed(ActionEvent ae){
     String text = ae.getActionCommand();
     
     if(text.equals("Add Customer Details")){
          new AddCustomer();
         
    }else if(text.equals("Flight Details")){
        new FlightInfo();
        
     }else if(text.equals("Book Flight ")){
        new BookFlight();
     
     }else if(text.equals("Journey Details")){
        new JourneyDetails();
        
     }else if (text.equals("Cancel Ticket ")) {
            new Cancel();
            
        }else if (text.equals("Boarding Pass Details")) {
        new BoardingPass(); 
    }    
    }
    public static void main(String[] args ){
      new Home();  
    }
    
}
*/

package airline.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);
        
        // Get screen dimensions
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
int width = (int) screenSize.getWidth();
int height = (int) screenSize.getHeight();

// Load and scale the image to fit the full screen
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/icons/front2.png"));
Image img = i1.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
ImageIcon scaledIcon = new ImageIcon(img);

// Set as background
JLabel background = new JLabel(scaledIcon);
background.setBounds(0, 0, width, height);
add(background);


        // Heading with semi-transparent panel
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(new Color(255, 255, 255, 180));
        headingPanel.setBounds(500, 60, 600, 60);
        headingPanel.setLayout(new BorderLayout());

        JLabel heading = new JLabel("✈ AIR INDIA WELCOMES YOU ✈", SwingConstants.CENTER);
        heading.setFont(new Font("SansSerif", Font.BOLD, 32));
        heading.setForeground(new Color(0, 51, 102));
        headingPanel.add(heading);
        background.add(headingPanel);

        // Modern JMenuBar with styling
        JMenuBar menubar = new JMenuBar();
        menubar.setBackground(new Color(30, 30, 30));
        menubar.setForeground(Color.WHITE);
        menubar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        // DETAILS Menu
        JMenu details = new JMenu("DETAILS");
        details.setForeground(Color.WHITE);
        details.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menubar.add(details);

        JMenuItem flightDetails = createMenuItem("Flight Details");
        JMenuItem customerDetails = createMenuItem("Add Customer Details");
        JMenuItem bookFlight = createMenuItem("Book Flight ");
        JMenuItem journeyDetails = createMenuItem("Journey Details");
        JMenuItem ticketCancel = createMenuItem("Cancel Ticket ");

        details.add(flightDetails);
        details.add(customerDetails);
        details.add(bookFlight);
        details.add(journeyDetails);
        details.add(ticketCancel);

        // TICKET Menu
        JMenu ticket = new JMenu("TICKET");
        ticket.setForeground(new Color(255, 85, 85));
        ticket.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menubar.add(ticket);

        JMenuItem boardingPass = createMenuItem("Boarding Pass Details");
        ticket.add(boardingPass);

        // Menu item actions
        flightDetails.addActionListener(this);
        customerDetails.addActionListener(this);
        bookFlight.addActionListener(this);
        journeyDetails.addActionListener(this);
        ticketCancel.addActionListener(this);
        boardingPass.addActionListener(this);

        setJMenuBar(menubar);

        // Frame config
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setTitle("Air India Management System");
        setVisible(true);
    }

    private JMenuItem createMenuItem(String title) {
        JMenuItem item = new JMenuItem(title);
        item.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        item.setBackground(new Color(240, 240, 240));
        item.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
        return item;
    }

    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        switch (text) {
            case "Add Customer Details":
                new AddCustomer();
                break;
            case "Flight Details":
                new FlightInfo();
                break;
            case "Book Flight ":
                new BookFlight();
                break;
            case "Journey Details":
                new JourneyDetails();
                break;
            case "Cancel Ticket ":
                new Cancel();
                break;
            case "Boarding Pass Details":
                new BoardingPass();
                break;
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
