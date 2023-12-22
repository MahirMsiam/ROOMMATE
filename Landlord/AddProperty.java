package Landlord;
import Landlord.LandLordDashboard;

import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class AddProperty extends JFrame implements ActionListener {

    private JTextField addressField, rentField, descriptionField;
    private JLabel addressLabel, rentLabel, image, descriptionLabel, WifiLabel, background, imageLabel;
    private JFrame frame;
    private JPanel panel;
    private JButton submit, Back, upload;
    private JComboBox wifiCombo;
    BufferedImage img;


    public AddProperty() {

        ImageIcon img = new ImageIcon("Media\\Roommate logo.gif");
        background = new JLabel(img);
        background.setBounds(0, 0, 1100, 700);

        // Setting up the frame
        setTitle("Add Property");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating components
        addressLabel = new JLabel("Address :");
        rentLabel = new JLabel("Rent :");
        descriptionLabel = new JLabel("Description :");
        WifiLabel = new JLabel("Wifi :");
        image = new JLabel("Image :");
        addressField = new JTextField();
        rentField = new JTextField();
        descriptionField = new JTextField();
        wifiCombo = new JComboBox();


        submit = new JButton("Submit");
        Back = new JButton("Back");
        upload = new JButton("Upload");
        imageLabel = new JLabel();

        // Setting bounds for components

        addressLabel.setBounds(570, 120, 160, 30);
        rentLabel.setBounds(570, 170, 200, 30);
        descriptionLabel.setBounds(570, 220, 200, 30);
        WifiLabel.setBounds(570, 270, 200, 30);
        image.setBounds(570, 320, 200, 30);

        addressField.setBounds(810, 120, 180, 30);
        rentField.setBounds(810, 170, 180, 30);
        descriptionField.setBounds(810, 220, 180, 30);
        wifiCombo.setBounds(810, 270, 180, 30);
        imageLabel.setBounds(810, 320, 180, 30);
        upload.setBounds(1000, 320, 100, 30);
        submit.setBounds(840, 450, 100, 35);
        Back.setBounds(840, 500, 100, 35);

        // Adding components to the frame

        //Labels
        add(addressLabel);
        add(rentLabel);
        add(descriptionLabel);
        add(WifiLabel);
        add(image);

        //Fields
        add(addressField);
        add(rentField);
        add(descriptionField);
        add(wifiCombo);
        add(imageLabel);

        //Buttons
        add(upload);
        add(submit);
        add(Back);

        add(background);

        setLocationRelativeTo(null);
        setVisible(true);
    }


        @Override
        public void actionPerformed(ActionEvent e) {
            this.e = e;
            if(e.getSource() == Back){
                new LandLordDashboard();
                dispose();
            }
        }

        //implement wifi combo box with yes or no
        //implement image upload
        //implement submit button

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            // getting inputs from signup page
            String name = rentField.getText();
            String address = addressField.getText();
            String descriptionFieldText = descriptionField.getText();
            String wifi = wifiCombo.getSelectedItem().toString();

            // Validate and process the user input
            if (validate(name, address, descriptionFieldText, wifi)) {
                saveDataToFile(name, address, descriptionFieldText, wifi);//if if=true then data will be written in tenantdata.txt file
                JOptionPane.showMessageDialog(this, "Signup successful!");
            } // else {
            // JOptionPane.showMessageDialog(this, "Invalid input or passwords do not
            // match.");
            // }
        } else if (e.getSource() == Back) {
            new LandLordDashboard();
            setVisible(false);
        }
    }

    private boolean validate(String name, String address, String descriptionFieldText, String wifi) {
        if (name.isEmpty() || address.isEmpty() || descriptionFieldText.isEmpty() || wifi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }
        return true;
    }

    private void saveDataToFile(String name, String address, String descriptionFieldText, String wifi) {

    }

    private void saveDatatoProp(addressField, rentField, descriptionField, wifiCombo, imageLabel){
            try{
                FileWriter fw = new FileWriter("Media\\Property.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(addressField.getText());
                pw.println(rentField.getText());
                pw.println(descriptionField.getText());
                pw.println(wifiCombo.getSelectedItem());
                pw.println(imageLabel.getText());

                pw.flush();
                pw.close();

                JOptionPane.showMessageDialog(null, "Data Saved");
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Data not Saved");
            }



    }




}