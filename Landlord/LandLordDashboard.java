package Landlord;

import Classes.IntroDuck;

import javax.swing.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class LandLordDashboard extends JFrame implements ActionListener {

    private JLabel background;
    private JFrame dashframe;

    private JButton addProperty, viewProperties,logout;

    public LandLordDashboard() {


        ImageIcon img = new ImageIcon("Media\\landlord.jpg");
        background = new JLabel(img);
        background.setBounds(0, 0, 1100, 700);

        // Setting up the frame
        setTitle("LandLord Dashboard");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating components
        addProperty = new JButton("Add Property");
        viewProperties = new JButton("View Property");
        logout = new JButton("Logout");

        // Setting bounds for components
        addProperty.setBounds(450, 200, 200, 50);
        viewProperties.setBounds(450, 300, 200, 50);
        logout.setBounds(450, 600, 200, 50);

        // Adding components to the frame
        add(addProperty);
        add(viewProperties);
        add(logout);
        add(background);

        // Adding action listeners
        addProperty.addActionListener(this);
        viewProperties.addActionListener(this);
        logout.addActionListener(this);

        // Setting visibility
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addProperty) {
            //new AddProperty();
            setVisible(false);
        } else if (e.getSource() == viewProperties) {
            JOptionPane.showMessageDialog(LandLordDashboard.this, "Frame incoming");
        } else if (e.getSource() == logout) {
            new LandLordLogin();
        }
    }
}
