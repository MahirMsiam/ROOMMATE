package Classes;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LandLordSignup extends JFrame implements ActionListener {
    private JTextField nameField, addressField, contactField, emailField,rentfield,roomfield,locationfield,bathroomfield;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signupButton, Back;
    private JLabel background;

    public LandLordSignup() {


        ImageIcon img = new ImageIcon("Media\\sugnup.jpg");
        background = new JLabel(img);
        background.setBounds(0, 0, 1100, 700);

        // Setting up the frame
        setTitle("Signup Frame");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating components
        JLabel nameLabel = new JLabel("Name :");
        JLabel addressLabel = new JLabel("Address :");
        JLabel contactLabel = new JLabel("Contact Number :");
        JLabel emailLabel = new JLabel("Email :");
        JLabel passwordLabel = new JLabel("Password :");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password :");
        JLabel rentLabel = new JLabel("Rent :");
        JLabel roomLabel = new JLabel("Rooms :");
        JLabel locationLabel = new JLabel("Location :");
        JLabel bathroomLabel = new JLabel("Bathroom :");


        nameField = new JTextField();
        addressField = new JTextField();
        contactField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();
        rentfield = new JTextField();
        roomfield = new JTextField();
        locationfield = new JTextField();
        bathroomfield = new JTextField();


        signupButton = new JButton("Signup");
        Back = new JButton("Back");

        // Setting bounds for components
        nameLabel.setBounds(570, 120, 160, 30);
        addressLabel.setBounds(570, 170, 200, 30);
        contactLabel.setBounds(570, 220, 200, 30);
        emailLabel.setBounds(570, 270, 200, 30);
        passwordLabel.setBounds(570, 320,200, 30);
        confirmPasswordLabel.setBounds(570, 370, 200, 30);
        rentLabel.setBounds(570, 420, 200, 30);
        roomLabel.setBounds(570, 470, 200, 30);
        locationLabel.setBounds(570, 520, 200, 30);
        bathroomLabel.setBounds(570, 570, 200, 30);


        nameField.setBounds(810, 120, 180, 30);
        addressField.setBounds(810, 170, 180, 30);
        contactField.setBounds(810, 220, 180, 30);
        emailField.setBounds(810, 270, 180, 30);
        passwordField.setBounds(810, 320, 180, 30);
        confirmPasswordField.setBounds(810, 370, 180, 30);
        rentfield.setBounds(810, 420, 180, 30);
        roomfield.setBounds(810, 470, 180, 30);
        locationfield.setBounds(810, 520, 180, 30);
        bathroomfield.setBounds(810, 570, 180, 30);

        setLocationRelativeTo(null);
        Back.setBounds(780, 610, 100, 35);
        Back.setBackground(Color.PINK);
        Back.setForeground(Color.black);

        signupButton.setBounds(890, 610, 100,35);
        signupButton.setBackground(Color.PINK);
        signupButton.setForeground(Color.black);
        signupButton.addActionListener(this);
        Back.addActionListener(this);

        // Adding components to the frame
        add(nameLabel);
        add(addressLabel);
        add(contactLabel);
        add(emailLabel);
        add(passwordLabel);
        add(confirmPasswordLabel);
        add(rentLabel);
        add(roomLabel);
        add(locationLabel);
        add(bathroomLabel);

        add(nameField);
        add(addressField);
        add(contactField);
        add(emailField);
        add(passwordField);
        add(confirmPasswordField);
        add(rentfield);
        add(roomfield);
        add(locationfield);
        add(bathroomfield);


        add(signupButton);
        add(Back);
        add(background);
        // Setting frames
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            // getting inputs from signup page
            String name = nameField.getText();
            String address = addressField.getText();
            String contact = contactField.getText();
            String email = emailField.getText();
            String rent = rentfield.getText();
            String room = roomfield.getText();
            String location = locationfield.getText();
            String bathroom = bathroomfield.getText();

            char[] password = passwordField.getPassword();
            char[] confirmPassword = confirmPasswordField.getPassword();

            // Validate and process the user input
            if (validateInputs(name, address, contact, email, password, confirmPassword,rent,room,location,bathroom)) {
                saveDataToFile(name, address, contact, email, password,rent,room,location,bathroom);//if if=true then data will be written in tenantdata.txt file
                JOptionPane.showMessageDialog(this, "Signup successful!");
            } // else {
            // JOptionPane.showMessageDialog(this, "Invalid input or passwords do not
            // match.");
            // }
        } else if (e.getSource() == Back) {
            new login();
            setVisible(false);
        }
    }

    private boolean validateInputs(String name, String address, String contact, String email, char[] password, char[] confirmPassword, String rent, String room, String location, String bathroom) {
        boolean b = false;
        return b;
    }


    private boolean validateInputs(String name, String address, String contact, String email,
                                   char[] password, char[] confirmPassword) {
        // validation logic here

        // check if the fields are not empty
        if (name.isEmpty() || address.isEmpty() || contact.isEmpty() || email.isEmpty() ||
                password.length == 0 || confirmPassword.length == 0) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }
        // validate email format
        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format.");
            return false;
        }
        // ensure that password and confirmPassword match.
        if (!new String(password).equals(new String(confirmPassword))) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return false;
        }
        return true;
    }

    // email validation method
    private boolean isValidEmail(String email) {

        String emaicheck = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emaicheck);
    }

    // saving user data in a txt file
    private void saveDataToFile(String name, String address, String contact, String email, char[] password, String rent, String room, String location, String bathroom) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\moyaz\\OneDrive\\Desktop\\Siam Roomie version 2\\src\\tenantdata.txt", true))) {
            // Append the user data to the text file
            writer.write("Name: " + name + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Contact Number: " + contact + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Password: " + new String(password) + "\n");
            writer.write("Rent: " + rent + "\n");
            writer.write("Room: " + room + "\n");
            writer.write("Location: " + location + "\n");
            writer.write("Bathroom: " + bathroom + "\n");
            writer.write("====================\n"); // Add a separator between entries
        } catch (IOException ioException) {
            ioException.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data to file.");
        }
    }

}
