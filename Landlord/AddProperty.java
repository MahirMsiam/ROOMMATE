package Landlord;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AddProperty extends JFrame implements ActionListener {

    private JTextField addressField, rentField, descriptionField;
    private JLabel background;

    private JButton submit, Back, upload;
    private JComboBox wifiCombo;
    private JFileChooser chooser;
    File file;
    BufferedImage img;
    String filExtension = "";

    public AddProperty() {




        ImageIcon img = new ImageIcon("Media\\blu.jpg");
        background = new JLabel(img);
        background.setBounds(0, 0, 1100, 700);

        // Setting up the frame
        setTitle("Add Property");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creating components
        JLabel addressLabel = new JLabel("Address :");
        JLabel rentLabel = new JLabel("Rent :");
        JLabel descriptionLabel = new JLabel("Description :");
        JLabel WifiLabel = new JLabel("Wifi :");
        JLabel uploadLabel = new JLabel("Choose Image :");


        addressField = new JTextField();
        rentField = new JTextField();
        descriptionField = new JTextField();
        wifiCombo = new JComboBox();


        submit = new JButton("Submit");
        Back = new JButton("Back");
        upload = new JButton("Upload");

        // Adding action listeners
        submit.addActionListener(this);
        Back.addActionListener(this);
        upload.addActionListener(this);


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
        submit.setBounds(170, 370, 100, 35);
        Back.setBounds(170, 420, 100, 35);
        upload.setBounds(260, 320, 180, 30);

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
        add(submit);
        add(Back);
        add(upload);

        add(background);

        setVisible(true);

        wifiCombo = new JComboBox();
        wifiCombo.addItem("Yes");
        wifiCombo.addItem("No");
        wifiCombo.setSelectedIndex(1);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            //getting input
            String address = addressField.getText();
            String rent = rentField.getText();
            String description = descriptionField.getText();
            String wifi = (String) wifiCombo.getSelectedItem();

            if (address.isEmpty() || rent.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");

            } else if (validateInputs(address, rent, description, wifi)) {
                saveDataToFile(address, rent, description, wifi);//saves data to file if true
                try {
                    ImageIO.write(img, filExtension, new File(".\\AptPictures\\" + address + filExtension));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(null, "Property Added Successfully");
            }
        } else if (e.getSource() == upload) {
            try {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg", "gif", "png");
                chooser = new JFileChooser();
                chooser.setFileFilter(filter);
                chooser.showOpenDialog(this);
                file = chooser.getSelectedFile();
                img = ImageIO.read(file);

                ImageIcon icon = new ImageIcon(img);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));

                upload.setIcon(imageIcon);
                String extensions[] = {".jpg", ".png", ".gif" };
                for (String extension : extensions) {
                    if (file.getName().toLowerCase().endsWith(extension)) {
                        filExtension = extension;
                        break;
                    }
                }

                upload.revalidate();
                upload.repaint();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (Exception ex2) {
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












