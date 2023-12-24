package Classes;

import javax.swing.*;

import Landlord.LandLord;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TenantDashboard extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    private JPanel imagePanel;

    public TenantDashboard() {
        setTitle("Search Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Search Panel
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(20);
        searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                JOptionPane.showMessageDialog(TenantDashboard.this, "Searching for: " + searchTerm);
            }
        });

        searchPanel.add(new JLabel("Enter search term: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Image Panel
        imagePanel = new JPanel(new GridLayout(2, 3));
        addImages();

        mainPanel.add(imagePanel, BorderLayout.CENTER);

        add(mainPanel);

        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private void addImages() {
        for (int i = 1; i <= 6; i++) {
            ImageIcon icon = new ImageIcon("Media\\3.jpeg"); // Replace with your image file names
            Image scaledImage = icon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
            icon = new ImageIcon(scaledImage);

            JLabel imageLabel = new JLabel(icon);
            imagePanel.add(imageLabel);
        }
    }

   
}



