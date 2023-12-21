package Classes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AdminDashboard extends JFrame {
    private JTable userListTable;
    private JTable landLordListTable;
    private DefaultTableModel userListTableModel;
    private DefaultTableModel landLordListTableModel;

    public AdminDashboard() {
        setTitle("ADMIN-Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        // Create labels with clickable images
        add(createClickableLabel("Tenant List", "1.jpeg"));
        add(createClickableLabel("LandLord List", "2.jpeg"));
        add(createClickableLabel("Properties", "3.jpeg"));
        add(createClickableLabel("Contributors", "4.jpeg"));

        setSize(1000, 600);
        setLocationRelativeTo(null);
    }

    private JLabel createClickableLabel(String labelText, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image scaledImage = icon.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel(labelText, scaledIcon, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);

        label.addMouseListener(new MouseClickListener(labelText, this));

        return label;
    }

    private class MouseClickListener extends MouseAdapter {
        private final String labelText;
        private final AdminDashboard mainFrame;

        public MouseClickListener(String labelText, AdminDashboard mainFrame) {
            this.labelText = labelText;
            this.mainFrame = mainFrame;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if ("Tenant List".equals(labelText)) {
                showUserList();
            } else if ("LandLord List".equals(labelText)) {
                showLandLordList();
            } else if ("Contributors".equals(labelText)) {
                showContributorsImage();
            } else {
                JLabel clickedLabel = (JLabel) e.getSource();

                // Open a new frame or perform other actions when a label is clicked
                JFrame newFrame = new JFrame("Clicked Label: " + clickedLabel.getText());
                newFrame.setSize(300, 300);
                newFrame.setLocationRelativeTo(null);
                newFrame.setVisible(true);
            }
        }

        private void showUserList() {
            mainFrame.loadUserData();

            JFrame userListFrame = new JFrame("Tenant List");
            userListFrame.setLayout(new BorderLayout());
            userListFrame.add(new JScrollPane(mainFrame.userListTable), BorderLayout.CENTER);

            // Add search and delete functionality
            JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(20);
            JButton searchButton = new JButton("Search");
            JButton deleteButton = new JButton("Delete");

            searchButton.addActionListener(e -> searchUser(searchField.getText()));
            deleteButton.addActionListener(e -> deleteUser());

            searchPanel.add(new JLabel("Search Email: "));
            searchPanel.add(searchField);
            searchPanel.add(searchButton);
            searchPanel.add(deleteButton);

            userListFrame.add(searchPanel, BorderLayout.SOUTH);

            userListFrame.setSize(800, 600);
            userListFrame.setLocationRelativeTo(mainFrame);
            userListFrame.setVisible(true);
        }

        private void showLandLordList() {
            mainFrame.loadLandLordData();

            JFrame landLordListFrame = new JFrame("LandLord List");
            landLordListFrame.setLayout(new BorderLayout());
            landLordListFrame.add(new JScrollPane(mainFrame.landLordListTable), BorderLayout.CENTER);

            // Add search and delete functionality
            JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(20);
            JButton searchButton = new JButton("Search");
            JButton deleteButton = new JButton("Delete");

            searchButton.addActionListener(e -> searchLandLord(searchField.getText()));
            deleteButton.addActionListener(e -> deleteLandLord());

            searchPanel.add(new JLabel("Search Email: "));
            searchPanel.add(searchField);
            searchPanel.add(searchButton);
            searchPanel.add(deleteButton);

            landLordListFrame.add(searchPanel, BorderLayout.SOUTH);

            landLordListFrame.setSize(800, 600);
            landLordListFrame.setLocationRelativeTo(mainFrame);
            landLordListFrame.setVisible(true);
        }

        private void showContributorsImage() {
            // Change the path to the actual image file
            ImageIcon contributorsImage = new ImageIcon("2.jpeg");

            // Create a new frame to display the image
            JFrame contributorsFrame = new JFrame("Contributors");
            JLabel contributorImageLabel = new JLabel(contributorsImage);
            contributorsFrame.add(contributorImageLabel);

            // Adjust the size of the frame based on the image size
            contributorsFrame.setSize(contributorsImage.getIconWidth(), contributorsImage.getIconHeight());

            contributorsFrame.setLocationRelativeTo(mainFrame);
            contributorsFrame.setVisible(true);
        }

        private void searchUser(String email) {
            if (mainFrame.userListTableModel != null) {
                for (int row = 0; row < mainFrame.userListTableModel.getRowCount(); row++) {
                    String tableEmail = (String) mainFrame.userListTableModel.getValueAt(row, 3);
                    if (tableEmail.equals(email)) {
                        mainFrame.userListTable.setRowSelectionInterval(row, row);
                        return;
                    }
                }
            }

            JOptionPane.showMessageDialog(mainFrame, "User not found", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }

        private void deleteUser() {
            if (mainFrame.userListTableModel != null && mainFrame.userListTable != null) {
                int selectedRow = mainFrame.userListTable.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(mainFrame,
                            "Are you sure you want to delete this user?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        mainFrame.userListTableModel.removeRow(selectedRow);
                        mainFrame.saveUserDataToFile();
                    }
                }
            }
        }

        private void searchLandLord(String email) {
            if (mainFrame.landLordListTableModel != null) {
                for (int row = 0; row < mainFrame.landLordListTableModel.getRowCount(); row++) {
                    String tableEmail = (String) mainFrame.landLordListTableModel.getValueAt(row, 3);
                    if (tableEmail.equals(email)) {
                        mainFrame.landLordListTable.setRowSelectionInterval(row, row);
                        return;
                    }
                }
            }

            JOptionPane.showMessageDialog(mainFrame, "LandLord not found", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }

        private void deleteLandLord() {
            if (mainFrame.landLordListTableModel != null && mainFrame.landLordListTable != null) {
                int selectedRow = mainFrame.landLordListTable.getSelectedRow();
                if (selectedRow != -1) {
                    int confirm = JOptionPane.showConfirmDialog(mainFrame,
                            "Are you sure you want to delete this LandLord?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        mainFrame.landLordListTableModel.removeRow(selectedRow);
                        mainFrame.saveLandLordDataToFile();
                    }
                }
            }
        }
    }

    private void loadUserData() {
        String[] columnNames = {"Name", "Address", "Contact Number", "Email", "Password"};
        userListTableModel = new DefaultTableModel(columnNames, 0);
        userListTable = new JTable(userListTableModel);
    
        try (BufferedReader br = new BufferedReader(new FileReader("Media\\tenantdata.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    String name = line.substring(6).trim();
                    String address = br.readLine().substring(9).trim();
                    String contactNumber = br.readLine().substring(17).trim();
                    String email = br.readLine().substring(7).trim();
                    String password = br.readLine().substring(10).trim();
                    br.readLine(); // Skip a line (Separator line)
    
                    Object[] data = {name, address, contactNumber, email, password};
                    userListTableModel.addRow(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUserDataToFile() {
        if (userListTableModel != null) {
            try (FileWriter writer = new FileWriter("Media\\tenantdata.txt")) {
                for (int row = 0; row < userListTableModel.getRowCount(); row++) {
                    writer.write("Name: " + userListTableModel.getValueAt(row, 0) + "\n");
                    writer.write("Address: " + userListTableModel.getValueAt(row, 1) + "\n");
                    writer.write("Contact Number: " + userListTableModel.getValueAt(row, 2) + "\n");
                    writer.write("Email: " + userListTableModel.getValueAt(row, 3) + "\n");
                    writer.write("Password: " + userListTableModel.getValueAt(row, 4) + "\n");
                    writer.write("====================\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadLandLordData() {
        String[] columnNames = {"Name", "Address", "Contact Number", "Email", "Password"};
        landLordListTableModel = new DefaultTableModel(columnNames, 0);
        landLordListTable = new JTable(landLordListTableModel);
    
        try (BufferedReader br = new BufferedReader(new FileReader("Media\\LandLordData.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Name:")) {
                    String name = line.substring(6).trim();
                    String address = br.readLine().substring(9).trim();
                    String contactNumber = br.readLine().substring(17).trim();
                    String email = br.readLine().substring(7).trim();
                    String password = br.readLine().substring(10).trim();
                    br.readLine(); // Skip a line (Separator line)
    
                    Object[] data = {name, address, contactNumber, email, password};
                    landLordListTableModel.addRow(data);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveLandLordDataToFile() {
        if (landLordListTableModel != null) {
            try (FileWriter writer = new FileWriter("Media\\LandLordData.txt")) {
                for (int row = 0; row < landLordListTableModel.getRowCount(); row++) {
                    writer.write("Name: " + landLordListTableModel.getValueAt(row, 0) + "\n");
                    writer.write("Address: " + landLordListTableModel.getValueAt(row, 1) + "\n");
                    writer.write("Contact Number: " + landLordListTableModel.getValueAt(row, 2) + "\n");
                    writer.write("Email: " + landLordListTableModel.getValueAt(row, 3) + "\n");
                    writer.write("Password: " + landLordListTableModel.getValueAt(row, 4) + "\n");
                    writer.write("====================\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

