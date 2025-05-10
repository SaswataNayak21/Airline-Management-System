/*package airline.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {
    
      public FlightInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table = new JTable();
        try{
             Conn conn = new Conn();
          ResultSet rs = conn.s.executeQuery("select * from flight");
          table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 550);
        add(jsp);
        
        setSize(800, 550);
        setLocation(400, 200);
        setVisible(true);     
        }
    public static void main(String[] args){
      new FlightInfo();
    }
}
*/

package airline.management.system;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame {

    public FlightInfo() {
        getContentPane().setBackground(new Color(20, 24, 30)); // Dark background
        setLayout(new BorderLayout(10, 10));

        // Header with blue to black gradient
        JPanel header = new JPanel() {
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gp = new GradientPaint(0, 0, new Color(0, 102, 204), getWidth(), 0, Color.BLACK);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        header.setPreferredSize(new Dimension(getWidth(), 70));
        header.setLayout(new BorderLayout());

        JLabel heading = new JLabel("Available Flight Information", JLabel.CENTER);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 28));
        header.add(heading);

        add(header, BorderLayout.NORTH);

        // Table with light blue theme
        JTable table = new JTable();
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setForeground(Color.DARK_GRAY);
        table.setBackground(new Color(173, 216, 230)); // Light blue
        table.setGridColor(Color.BLACK); // Black grid lines
        table.setRowHeight(28);
        table.setFillsViewportHeight(true);
        table.setSelectionBackground(new Color(30, 144, 255)); // Dodger blue
        table.setSelectionForeground(Color.WHITE);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));

            // Center-align text
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            private final Color evenColor = new Color(173, 216, 230);
            private final Color oddColor = new Color(191, 229, 242);

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? evenColor : oddColor);
                    c.setForeground(Color.DARK_GRAY);
                }
                return c;
            }
        });

        // Scroll pane with borders
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 20, 15, 20),
                BorderFactory.createLineBorder(Color.BLACK, 2) // Black border
        ));
        jsp.getViewport().setBackground(new Color(20, 24, 30));
        add(jsp, BorderLayout.CENTER);

        // Frame configuration
        setSize(900, 600);
        setLocationRelativeTo(null);
        setTitle("Flight Information");
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
