package Classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TenantDashboard extends JFrame {
    private JTable propertyTable;

    public TenantDashboard() {
        setTitle("Property Dashboard");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model with column names
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Location");
        tableModel.addColumn("Rent");

        // Read property details from the text file
        File file = new File("Apartments\\Property.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String name = null;
            String location = null;
            String rent = null;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    name = line.substring("Name: ".length());
                } else if (line.startsWith("Location:")) {
                    location = line.substring("Location: ".length());
                } else if (line.startsWith("Rent:")) {
                    rent = line.substring("Rent: ".length());

                    // Add a new row to the table
                    tableModel.addRow(new Object[] { name, location, rent });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create a label for the title "Properties"
        JLabel titleLabel = new JLabel("Properties");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        // ...

        // Set the icon image
        ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");
        setIconImage(icon.getImage());

        setSize(1100,800);
        // ...
        // Create the JTable with the model
        propertyTable = new JTable(tableModel);

        // Add the JTable to a scroll pane
        /*
         * JScrollPane scrollPane = new JScrollPane(propertyTable);
         * add(scrollPane);
         */

        // Add the JTable to a scroll pane and set the size of the table
        JScrollPane scrollPane = new JScrollPane(propertyTable);
        propertyTable.setPreferredScrollableViewportSize(new Dimension(800, 400)); // Set your desired table size here
        add(scrollPane, BorderLayout.CENTER);

        // Create a "Show Details" button
        JButton showDetailsButton = new JButton("Show Details");
        showDetailsButton.setBackground(new Color(135, 206, 235));

        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = propertyTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) propertyTable.getValueAt(selectedRow, 0);
                    String location = (String) propertyTable.getValueAt(selectedRow, 1);
                    String rent = (String) propertyTable.getValueAt(selectedRow, 2);

                    showPropertyDetails(name, location, rent);
                } else {
                    JOptionPane.showMessageDialog(TenantDashboard.this,
                            "Please select a property to view details.",
                            "No Property Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Create a "Confirm Booking" button
        JButton confirmBookingButton = new JButton("Confirm Booking");
        confirmBookingButton.setBackground(new Color(135, 206, 235));
        confirmBookingButton.addActionListener(new ActionListener() {
            private void removePropertyFromExistingFile(String name, String location, String rent) {
                File existingFile = new File("Apartments\\Property.txt");
                File tempFile = new File("Apartments\\temp.txt");

                try (BufferedReader reader = new BufferedReader(new FileReader(existingFile));
                        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

                    String line;
                    String propertyDetails = "Name: " + name + "\nLocation: " + location + "\nRent: " + rent;

                    while ((line = reader.readLine()) != null) {
                        if (!line.contains(propertyDetails)) {
                            writer.write(line + System.getProperty("line.separator"));
                        }
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                // Rename the temporary file to the original file
                tempFile.renameTo(existingFile);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = propertyTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) propertyTable.getValueAt(selectedRow, 0);
                    String location = (String) propertyTable.getValueAt(selectedRow, 1);
                    String rent = (String) propertyTable.getValueAt(selectedRow, 2);

                    // Remove property details from the existing file
                    removePropertyFromExistingFile(name, location, rent);

                    // Remove image file
                    removeImageFile(name);

                    // Display booking confirmation message
                    JOptionPane.showMessageDialog(TenantDashboard.this,
                            "Booking confirmed for property: " + name,
                            "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);

                    // Update the table model to reflect changes
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(TenantDashboard.this,
                            "Please select a property to confirm booking.",
                            "No Property Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Add the buttons to the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showDetailsButton);
        buttonPanel.add(confirmBookingButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up the JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showPropertyDetails(String name, String location, String rent) {
        JFrame detailsFrame = new JFrame("Property Details");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Set the content pane to a panel with a background image
        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("Apartments\\"); // Replace "background.jpg" with your image
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Create panel for property information with GridBagLayout
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Use Roboto Bold font
        Font robotoBoldFont = new Font("Roboto", Font.BOLD, 16);

        // Add labels to detailsPanel with Roboto Bold font
        addDetailLabel(detailsPanel, gbc, "Name:", robotoBoldFont, 0, 0);
        addDetailLabel(detailsPanel, gbc, name, robotoBoldFont, 1, 0);
        addDetailLabel(detailsPanel, gbc, "Location:", robotoBoldFont, 0, 1);
        addDetailLabel(detailsPanel, gbc, location, robotoBoldFont, 1, 1);
        addDetailLabel(detailsPanel, gbc, "Rent:", robotoBoldFont, 0, 2);
        addDetailLabel(detailsPanel, gbc, rent, robotoBoldFont, 1, 2);

        // Create image label
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("Apartments/" + name + ".jpg")
                .getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon);

        // Create a panel for image and property information
        JPanel imageAndDetailsPanel = new JPanel(new BorderLayout());
        imageAndDetailsPanel.add(imageLabel, BorderLayout.WEST);
        imageAndDetailsPanel.add(detailsPanel, BorderLayout.CENTER);

        // Create a "Back" button
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsFrame.dispose();
            }
        });

        // Add components to the detailsFrame
        detailsFrame.setContentPane(contentPane);
        detailsFrame.setLayout(new BorderLayout());
        detailsFrame.add(imageAndDetailsPanel, BorderLayout.CENTER);
        detailsFrame.add(backButton, BorderLayout.SOUTH);

        // Set the size of the detailsFrame
        detailsFrame.setSize(800, 400);

        // Set up the detailsFrame
        detailsFrame.setLocationRelativeTo(null);
        detailsFrame.setVisible(true);
    }

    // Helper method to add detail labels to the detailsPanel with a specified font
    private void addDetailLabel(JPanel detailsPanel, GridBagConstraints gbc, String text, Font font, int gridx,
            int gridy) {
        JLabel label = new JLabel(text);
        label.setFont(font); // Set font
        detailsPanel.add(label, gbc);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        detailsPanel.add(label, gbc);
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE;
    }

    private void removeImageFile(String name) {
        File imageFile = new File("Apartments\\" + name + ".jpg");
        if (imageFile.exists()) {
            if (imageFile.delete()) {
                System.out.println("Image file deleted successfully");
            } else {
                System.err.println("Failed to delete image file");
            }
        } else {
            System.err.println("Image file not found");
        }
    }

    // public static void main(String[] args) {
    //     new PropertyDashboard();
    // }
}
