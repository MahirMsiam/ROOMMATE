package Landlord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandLordDashboard extends JFrame implements ActionListener {

    private JLabel background;
    private JFrame dashframe;

    private JButton addProperty, viewProperties,logout;

    public LandLordDashboard() {


        ImageIcon img = new ImageIcon("Media\\vb.png");
        background = new JLabel(img);
        background.setBounds(0, 0, 1085, 700);

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
        addProperty.setBounds(417, 430, 200, 50);
        viewProperties.setBounds(417, 480, 200, 50);
        logout.setBounds(417, 530, 200, 50);

        // Adding components to the frame
        add(addProperty);
        add(viewProperties);
        add(logout);
        add(background);

        // Adding action listeners
        addProperty.addActionListener(this);
        viewProperties.addActionListener(this);
        logout.addActionListener(this);

        //setting color
        addProperty.setBackground(Color.ORANGE);
        viewProperties.setBackground(Color.ORANGE);
        logout.setBackground(Color.ORANGE);

        // Setting visibility
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addProperty) {
            new AddProperty();
            setVisible(false);
        } else if (e.getSource() == viewProperties) {
            JOptionPane.showMessageDialog(LandLordDashboard.this, "Frame incoming");
        } else if (e.getSource() == logout) {
            new LandLordLogin();
            setVisible(false);
        }
    }
}
