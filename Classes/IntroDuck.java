package Classes;

import java.awt.Color;
// Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IntroDuck extends JFrame {
    private JButton Tenant, landLord;

    IntroDuck() {
        ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");// icon
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
        RoundButton Tenant = new RoundButton("TENANT");
        RoundButton landLord = new RoundButton("LANDLORD");

        Tenant.setBackground(Color.red);
        Tenant.setForeground(Color.black);
        Tenant.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.black));
        Tenant.setForeground(Color.black);
        landLord.setBackground(Color.PINK);
        landLord.setForeground(Color.black);
        landLord.setBorder(BorderFactory.createMatteBorder(1, 1, 2, 1, Color.black));
<<<<<<< HEAD
        landLord.setForeground(Color.black);  
        
       
        Tenant.setBounds(720, 290, 120, 38);
        landLord.setBounds(830, 340, 120, 38);
=======
        landLord.setForeground(Color.black);

        Tenant.setBounds(720, 290, 100, 35);
        landLord.setBounds(830, 340, 100, 35);
>>>>>>> 299e63140fae4ef9e749b563fddc8abb846258c4
        // Set button colors using RGB values
        Tenant.setBackground(new Color(255, 219, 88)); // mustard yellow
        landLord.setBackground(new Color(255, 219, 88)); // mustard yellow

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

        // adding buttons
        BGlabel.add(Tenant);
        BGlabel.add(landLord);
        setVisible(true);
    }
}
