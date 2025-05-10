/*package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;
    
    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("League Spartan", Font.PLAIN, 32));
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        JButton okButton = new JButton("OK");
        okButton.setBounds(420, 350, 120, 30);
        okButton.setBackground(Color.BLUE);
        okButton.setForeground(Color.BLACK);
        okButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
        setVisible(false); 
        new Home();        
    }
});
add(okButton);


        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '"+pnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tfname.setText(rs.getString("name")); 
                tfnationality.setText(rs.getString("nationality")); 
                lblsrc.setText(rs.getString("src")); 
                lbldest.setText(rs.getString("des"));  
                labelfname.setText(rs.getString("flightname"));  
                labelfcode.setText(rs.getString("flightcode"));  
                labeldate.setText(rs.getString("ddate")); 
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}*/



package airline.management.system;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class BoardingPass extends JFrame implements ActionListener {

    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton;
    JPanel boardingPass;

    public BoardingPass() {
        setTitle("Air India - Boarding Pass");
        getContentPane().setBackground(new Color(240, 240, 240));
        setLayout(null);

        // Input Panel
        JLabel lblaadhar = new JLabel("Enter PNR:");
        lblaadhar.setBounds(40, 30, 100, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(150, 30, 150, 25);
        add(tfpnr);

        fetchButton = new JButton("Generate");
        fetchButton.setBounds(320, 30, 120, 25);
        styleButton(fetchButton);
        fetchButton.addActionListener(this);
        add(fetchButton);

        // Boarding Pass Panel
        boardingPass = new JPanel();
        boardingPass.setLayout(null);
        boardingPass.setBounds(40, 80, 900, 300);
        boardingPass.setBackground(Color.WHITE);
        boardingPass.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        add(boardingPass);

        JLabel title = new JLabel("BOARDING PASS");
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setBounds(20, 10, 250, 30);
        boardingPass.add(title);

        JLabel airIndia = new JLabel("AIR INDIA");
        airIndia.setFont(new Font("Tahoma", Font.BOLD, 28));
        airIndia.setForeground(new Color(204, 0, 0));
        airIndia.setBounds(700, 10, 180, 30);
        boardingPass.add(airIndia);

        JLabel lblname = new JLabel("Passenger:");
        lblname.setBounds(20, 60, 120, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lblname);

        tfname = new JLabel();
        tfname.setBounds(140, 60, 200, 25);
        boardingPass.add(tfname);

        JLabel lblnationality = new JLabel("Nationality:");
        lblnationality.setBounds(20, 100, 120, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(140, 100, 200, 25);
        boardingPass.add(tfnationality);

        JLabel lblfrom = new JLabel("From:");
        lblfrom.setBounds(20, 140, 120, 25);
        lblfrom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lblfrom);

        lblsrc = new JLabel();
        lblsrc.setBounds(140, 140, 200, 25);
        boardingPass.add(lblsrc);

        JLabel lblto = new JLabel("To:");
        lblto.setBounds(20, 180, 120, 25);
        lblto.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lblto);

        lbldest = new JLabel();
        lbldest.setBounds(140, 180, 200, 25);
        boardingPass.add(lbldest);

        JLabel lblfcode = new JLabel("Flight Code:");
        lblfcode.setBounds(460, 60, 120, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(600, 60, 200, 25);
        boardingPass.add(labelfcode);

        JLabel lblfname = new JLabel("Flight Name:");
        lblfname.setBounds(460, 100, 120, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(600, 100, 200, 25);
        boardingPass.add(labelfname);

        JLabel lbldate = new JLabel("Date of Travel:");
        lbldate.setBounds(460, 140, 120, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        boardingPass.add(lbldate);

        labeldate = new JLabel();
        labeldate.setBounds(600, 140, 200, 25);
        boardingPass.add(labeldate);

        // Branding
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        JLabel imgLabel = new JLabel(new ImageIcon(i2));
        imgLabel.setBounds(700, 170, 100, 100);
        boardingPass.add(imgLabel);

        // OK Button
        JButton okButton = new JButton("OK");
        okButton.setBounds(820, 390, 100, 30);
        styleButton(okButton);
        okButton.setBackground(Color.BLUE);
        okButton.setForeground(Color.WHITE);
        okButton.addActionListener(e -> {
            setVisible(false);
            new Home();
        });
        add(okButton);

        // Print Button
        JButton printButton = new JButton("Print");
        printButton.setBounds(700, 390, 100, 30);
        styleButton(printButton);
        printButton.setBackground(Color.GREEN.darker());
        printButton.setForeground(Color.WHITE);
        printButton.addActionListener(e -> printBoardingPass(boardingPass));
        add(printButton);

        // Save as PNG Button
        JButton saveButton = new JButton("Save as PNG");
        saveButton.setBounds(540, 390, 140, 30);
        styleButton(saveButton);
        saveButton.setBackground(Color.DARK_GRAY);
        saveButton.setForeground(Color.WHITE);
        saveButton.addActionListener(e -> saveBoardingPassAsImage(boardingPass));
        add(saveButton);

        setSize(1000, 500);
        setLocation(300, 150);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 51, 153));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
    }

    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText().trim();

        if (pnr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid PNR.");
            return;
        }

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("src"));
                lbldest.setText(rs.getString("des"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
            } else {
                JOptionPane.showMessageDialog(this, "No reservation found for PNR: " + pnr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printBoardingPass(JPanel panel) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Boarding Pass");

        job.setPrintable((graphics, pageFormat, pageIndex) -> {
            if (pageIndex > 0) return Printable.NO_SUCH_PAGE;

            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            panel.printAll(g2d);
            return Printable.PAGE_EXISTS;
        });

        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Print failed: " + ex.getMessage());
            }
        }
    }

    private void saveBoardingPassAsImage(JPanel panel) {
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        panel.paint(g2d);
        g2d.dispose();

        try {
            String filename = "BoardingPass_" + new Date().getTime() + ".png";
            File outputfile = new File(filename);
            ImageIO.write(image, "png", outputfile);
            JOptionPane.showMessageDialog(this, "Saved as: " + outputfile.getAbsolutePath());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to save image: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
