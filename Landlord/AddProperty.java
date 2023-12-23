package Landlord;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;



public class AddProperty extends JFrame implements ActionListener {

    private JTextField addressField, rentField, descriptionField;
    private JLabel addressLabel, rentLabel, image, descriptionLabel, WifiLabel, uploadLabel, background;
    private JFrame frame;
    private JPanel panel;
    private JButton submit, Back, upload;
    private JComboBox wifiCombo;
    private JFileChooser chooser;
    File file;
    BufferedImage img;
    String filExtension = "";

    public AddProperty() {

        wifiCombo = new JComboBox();
        wifiCombo.addItem("Yes");
        wifiCombo.addItem("No");

        ImageIcon img = new ImageIcon("Media\\blu.jpg");
        background = new JLabel(img);
        background.setBounds(0, 0, 1100, 700);

        // Setting up the frame
        setTitle("Add Property");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating components
        addressLabel = new JLabel("Address :");
        rentLabel = new JLabel("Rent :");
        descriptionLabel = new JLabel("Description :");
        WifiLabel = new JLabel("Wifi :");
        uploadLabel = new JLabel("Choose Image :");


        addressField = new JTextField();
        rentField = new JTextField();
        descriptionField = new JTextField();
        wifiCombo = new JComboBox();


        submit = new JButton("Submit");
        Back = new JButton("Back");
        upload = new JButton("Upload");

        // Setting bounds for components

        addressLabel.setBounds(170, 120, 160, 30);
        rentLabel.setBounds(170, 170, 200, 30);
        descriptionLabel.setBounds(170, 220, 200, 30);
        WifiLabel.setBounds(170, 270, 200, 30);
        uploadLabel.setBounds(170, 320, 200, 30);

        addressField.setBounds(260, 120, 180, 30);
        rentField.setBounds(260, 170, 180, 30);
        descriptionField.setBounds(260, 220, 180, 30);
        wifiCombo.setBounds(260, 270, 180, 30);
        upload.setBounds(290, 320, 100, 30);
        submit.setBounds(170, 370, 100, 35);
        Back.setBounds(170, 420, 100, 35);

        // Adding components to the frame

        //Labels
        add(addressLabel);
        add(rentLabel);
        add(descriptionLabel);
        add(WifiLabel);
        add(uploadLabel);

        //Fields
        add(addressField);
        add(rentField);
        add(descriptionField);
        add(wifiCombo);

        //Buttons
        add(upload);
        add(submit);
        add(Back);

        add(background);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            //getting input
            String address = addressField.getText();
            String rent = rentField.getText();
            String description = descriptionField.getText();
            String wifi = (String) wifiCombo.getSelectedItem();

            if (validateInputs(address,rent,description,wifi)){
                saveDataToFile(address,rent,description,wifi);//saves data to file if true
                JOptionPane.showMessageDialog(null, "Property Added Successfully");
            } else {
                try {
                    FileWriter fw = new FileWriter("Apartments\\Property.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    pw.println(address + "," + rent + "," + description + "," + wifi + ",");
                    pw.flush();
                    pw.close();

                    JOptionPane.showMessageDialog(null, "Property Added Successfully");
                    dispose();
                    new LandLordDashboard();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error Occurred");
                }
            }
        }
        else if (e.getSource() == upload) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
            chooser.addChoosableFileFilter(filter);
            int result = chooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                file = chooser.getSelectedFile();
                String path = file.getAbsolutePath();
                filExtension = path.substring(path.lastIndexOf(".") + 1, path.length());
            } else if (result == JFileChooser.CANCEL_OPTION) {
                System.out.println("No Data");
            }
        }

        else if (e.getSource() == Back) {
            new LandLordDashboard();
            setVisible(false);
        }
    }

    private boolean validateInputs(String address, String rent, String description, String wifi) {
        // validation logic here

        // check if the fields are not empty
        if (address.isEmpty() || rent.isEmpty() || description.isEmpty() || wifi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }
        return true;
    }

    private void saveDataToFile(String address,String rent, String description, String wifi){
        try (BufferedWriter writer= new BufferedWriter(new FileWriter("Apartments\\Property.txt",true))) {
            //Append the user data to the text file
            writer.write("Address: " + address + "\n");
            writer.write("Rent: " + rent + "\n");
            writer.write("Description: " + description + "\n");
            writer.write("Wifi: " + wifi + "\n");
            writer.write("====================\n");
        } catch (IOException ioException){
            ioException.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data");//Add a separator between entries
        }
    }
}
