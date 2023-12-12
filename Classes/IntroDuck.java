package Classes;

// Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IntroDuck extends JFrame {
    private JButton Tenant, landLord, Areaguide, Admin;

    IntroDuck() {
        ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");//icon
        // Setting title and close operation
        setTitle("ROOMMATE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLayout(null);
        getContentPane();
        setLocationRelativeTo(null);
        setIconImage(icon.getImage());
        // setting image
        ImageIcon BG = new ImageIcon("Media\\front.jpg");
        JLabel BGlabel = new JLabel(BG);
        BGlabel.setBounds(0, 0, getWidth(), getHeight());
        add(BGlabel);
        // Setting buttons
        Tenant = new JButton("Tenant");
        landLord = new JButton("Land Lord");
        Areaguide = new JButton("Area Guide");
        Admin = new JButton("Admin");

        Tenant.setBounds(660, 250, 120, 35);
        landLord.setBounds(760, 300, 120, 35);
        Areaguide.setBounds(860, 350, 120, 35);
        Admin.setBounds(1020,0, 70, 35);

        // adding actionlisteners
        Tenant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
            }
        });
        landLord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
                ;
            }
        });
        Areaguide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(IntroDuck.this, "Frame incoming");
            }
        });
        Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
            }
        });

        // adding buttons
        BGlabel.add(Tenant);
        BGlabel.add(landLord);
        BGlabel.add(Areaguide);
        BGlabel.add(Admin);
        setVisible(true);
    }
}



