/*package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
    JTable table;
    JTextField pnr;
    JButton show;
    
    public JourneyDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblpnr.setBounds(50, 50, 100, 25);
        add(lblpnr);
        
        pnr = new JTextField();
        pnr.setBounds(160, 50, 120, 25);
        add(pnr);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+pnr.getText()+"'");
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}*/

package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener {

    JTable table;
    JTextField pnrField;
    JButton showButton;

    public JourneyDetails() {
        setLayout(null);
        setTitle("Journey Details");

        // Gradient Header
        JPanel header = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 102, 204), 0, getHeight(), Color.BLACK);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setBounds(0, 0, 800, 60);
        header.setLayout(new BorderLayout());

        JLabel heading = new JLabel("Journey Details", SwingConstants.CENTER);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.WHITE);
        header.add(heading);

        add(header);

        // PNR Input
        JLabel pnrLabel = new JLabel("Enter PNR:");
        pnrLabel.setBounds(50, 80, 100, 25);
        pnrLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pnrLabel);

        pnrField = new JTextField();
        pnrField.setBounds(160, 80, 150, 25);
        add(pnrField);

        showButton = new JButton("Show Details");
        showButton.setBounds(330, 80, 140, 25);
        styleButton(showButton);
        showButton.addActionListener(this);
        add(showButton);

        // Table for showing journey details
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
        table.setRowHeight(22);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(220, 220, 220));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 130, 750, 300);
        add(scrollPane);

        // Frame settings
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 500);
        setLocation(400, 150);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
    }

    public void actionPerformed(ActionEvent ae) {
        String inputPnr = pnrField.getText().trim();

        if (inputPnr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a PNR number");
            return;
        }

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM reservation WHERE PNR = '" + inputPnr + "'");

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(this, "No Information Found");
                return;
            }

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error fetching data");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
