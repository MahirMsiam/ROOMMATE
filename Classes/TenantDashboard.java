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
        setTitle("Tenant-Dashboard");

        // creating table
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Name");
        tableModel.addColumn("Location");
        tableModel.addColumn("Rent");

        // reading details from txt
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

        // label for the title "Properties"
        JLabel titleLabel = new JLabel("Properties");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        // Seting the icon image
        ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");
        setIconImage(icon.getImage());

        setSize(1100, 800);

        // JTable with tablemodel
        propertyTable = new JTable(tableModel);

        // adds scroll pane to JLable
        JScrollPane scrollPane = new JScrollPane(propertyTable);
        propertyTable.setPreferredScrollableViewportSize(new Dimension(800, 400)); // Set your desired table size here
        add(scrollPane, BorderLayout.CENTER);

        // Show button with action
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

        // confirm button part1 adds deails to temp file
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

                // renaming temp file to the origin file
                tempFile.renameTo(existingFile);
            }

            // part2 removes from details+img
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = propertyTable.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) propertyTable.getValueAt(selectedRow, 0);
                    String location = (String) propertyTable.getValueAt(selectedRow, 1);
                    String rent = (String) propertyTable.getValueAt(selectedRow, 2);

                    removePropertyFromExistingFile(name, location, rent);
                    removeImageFile(name);

                    // display msg
                    JOptionPane.showMessageDialog(TenantDashboard.this,
                            "Booking confirmed for property: " + name,
                            "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    tableModel.removeRow(selectedRow);// instant removal
                } else {
                    JOptionPane.showMessageDialog(TenantDashboard.this,
                            "Please select a property to confirm booking.",
                            "No Property Selected", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showDetailsButton);
        buttonPanel.add(confirmBookingButton);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //////// *IMPORTANT METHODS *////////////

    private void showPropertyDetails(String name, String location, String rent) {
        JFrame detailsFrame = new JFrame("Property Details");
        detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // property information with GridBagLayout
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        Font robotoBoldFont = new Font("Roboto", Font.BOLD, 16);

        // labels to detailsPanel
        addDetailLabel(detailsPanel, gbc, "Name:", robotoBoldFont, 0, 0);
        addDetailLabel(detailsPanel, gbc, name, robotoBoldFont, 1, 0);
        addDetailLabel(detailsPanel, gbc, "Location:", robotoBoldFont, 0, 1);
        addDetailLabel(detailsPanel, gbc, location, robotoBoldFont, 1, 1);
        addDetailLabel(detailsPanel, gbc, "Rent:", robotoBoldFont, 0, 2);
        addDetailLabel(detailsPanel, gbc, rent, robotoBoldFont, 1, 2);

        // scaled image label
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("Apartments/" + name + ".jpg")
                .getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon);

        // panel for image and property info
        JPanel imageAndDetailsPanel = new JPanel(new BorderLayout());
        imageAndDetailsPanel.add(imageLabel, BorderLayout.WEST);
        imageAndDetailsPanel.add(detailsPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(255, 102, 102));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailsFrame.dispose();
            }
        });

        // components to detailsFrame
        // detailsFrame.setContentPane(contentPane);
        detailsFrame.setLayout(new BorderLayout());
        detailsFrame.add(imageAndDetailsPanel, BorderLayout.CENTER);
        detailsFrame.add(backButton, BorderLayout.SOUTH);

        detailsFrame.setSize(800, 400);

        detailsFrame.setLocationRelativeTo(null);
        detailsFrame.setVisible(true);
    }

    // adds detail labels to the detailsPanel
    // NB. this is to make code orgaized and easy to understand
    private void addDetailLabel(JPanel detailsPanel, GridBagConstraints gbc, String text, Font font, int gridx,
            int gridy) {
        JLabel label = new JLabel(text);
        label.setFont(font);
        detailsPanel.add(label, gbc);
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        detailsPanel.add(label, gbc);
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE;
    }

    // removing img with prop details
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

}
/*HAPPY CODING
If you liked it and it helped you drp a star
Every Method is open for all just copy and paste
DM freely on my socials in case you need help
*/

