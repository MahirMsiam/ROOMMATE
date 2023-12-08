import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Signup extends JFrame implements ActionListener {
    private JTextField nameField, addressField, contactField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signupButton, Back;
    private JLabel background;

    public Signup() {

        
        ImageIcon img = new ImageIcon("D:\\Project\\ROOMMATE\\sugnup.jpg");
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

        nameField = new JTextField();
        addressField = new JTextField();
        contactField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        signupButton = new JButton("Signup");
        Back = new JButton("Back");

        // Setting bounds for components
        nameLabel.setBounds(570, 120, 160, 30);
        addressLabel.setBounds(570, 170, 200, 30);
        contactLabel.setBounds(570, 220, 200, 30);
        emailLabel.setBounds(570, 270, 200, 30);
        passwordLabel.setBounds(570, 320,200, 30);
        confirmPasswordLabel.setBounds(570, 370, 200, 30);

        nameField.setBounds(810, 120, 180, 30);
        addressField.setBounds(810, 170, 180, 30);
        contactField.setBounds(810, 220, 180, 30);
        emailField.setBounds(810, 270, 180, 30);
        passwordField.setBounds(810, 320, 180, 30);
        confirmPasswordField.setBounds(810, 370, 180, 30);
        setLocationRelativeTo(null);
        Back.setBounds(840, 450, 100, 35);
        Back.setBackground(Color.PINK);
        Back.setForeground(Color.black);

        signupButton.setBounds(620, 450, 100,35);
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

        add(nameField);
        add(addressField);
        add(contactField);
        add(emailField);
        add(passwordField);
        add(confirmPasswordField);

        add(signupButton);
        add(Back);
        add(background);
        // Setting frame properties
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signupButton) {
            // Handle signup logic here
            String name = nameField.getText();
            String address = addressField.getText();
            String contact = contactField.getText();
            String email = emailField.getText();
            char[] password = passwordField.getPassword();
            char[] confirmPassword = confirmPasswordField.getPassword();

            // Validate and process the user input
            if (validateInputs(name, address, contact, email, password, confirmPassword)) {
                saveDataToFile(name, address, contact, email, password);//if if=true then data will be written in tenantdata.txt file
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
    private void saveDataToFile(String name, String address, String contact, String email, char[] password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Project\\ROOMMATE\\tenantdata.txt", true))) {
            // Append the user data to the text file
            writer.write("Name: " + name + "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Contact Number: " + contact + "\n");
            writer.write("Email: " + email + "\n");
            writer.write("Password: " + new String(password) + "\n");
            writer.write("====================\n"); // Add a separator between entries
        } catch (IOException ioException) {
            ioException.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data to file.");
        } 
    }

}
