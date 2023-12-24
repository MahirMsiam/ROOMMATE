package Landlord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandLordDashboard extends JFrame implements ActionListener {

    private final JButton addProperty;
    private final JButton logout;

    public LandLordDashboard() {


        ImageIcon img = new ImageIcon("Media\\vb.png");
        JLabel background = new JLabel(img);
        background.setBounds(0, 0, 1085, 700);

        // Setting up the frame
        setTitle("LandLord Dashboard");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating components
        addProperty = new JButton("Add Property");
        logout = new JButton("Logout");

        // Setting bounds for components
        addProperty.setBounds(432, 455, 170, 65);
        logout.setBounds(431, 520, 171, 65);

        // Adding components to the frame
        add(addProperty);
        add(logout);
        add(background);

        // Adding action listeners
        addProperty.addActionListener(this);
        logout.addActionListener(this);

        //setting color
        addProperty.setBackground(Color.ORANGE);
        logout.setBackground(Color.ORANGE);

        // Setting visibility
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addProperty) {
            new AddProperty();
            setVisible(false);;
        } else if (e.getSource() == logout) {
            new LandLordLogin();
            setVisible(false);
        }
    }
}
