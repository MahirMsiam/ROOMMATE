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
    //private Font Rancho;

    public Signup() {

        
        ImageIcon img = new ImageIcon("D:\\UNIVERSITY\\OOP1\\Project\\ROOMMATE\\sugnup.jpg");
        background = new JLabel(img);
        background.setBounds(0, 0, 1100, 700);

        // Setting up the frame
        setTitle("Signup Frame");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating components
        JLabel nameLabel = new JLabel("Name:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel contactLabel = new JLabel("Contact Number:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");

        nameField = new JTextField();
        addressField = new JTextField();
        contactField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        signupButton = new JButton("Signup");
        Back = new JButton("Back");

        /*try{
        Rancho = Font.createFont(Font.TRUETYPE_FONT,new File("D:\Project\ROOMMATE\Rancho-Regular.ttf"));
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,new File("D:\Project\ROOMMATE\Rancho-Regular.ttf")));
        }
        catch(IOException | FontFormatException e){

        }*/

        // Setting bounds for components
        nameLabel.setBounds(300, 120, 160, 30);
        addressLabel.setBounds(300, 160, 80, 30);
        contactLabel.setBounds(300, 200, 200, 30);
        emailLabel.setBounds(300, 240, 150, 30);
        passwordLabel.setBounds(300, 280, 150, 30);
        confirmPasswordLabel.setBounds(300, 320, 150, 30);

        /*Setting Fontstyle
        nameLabel.setFont(Rancho);
        addressLabel.setFont(new Font("Monoapaced",Font.ITALIC,25));*/

        nameField.setBounds(550, 120, 160, 30);
        addressField.setBounds(550, 160, 160, 30);
        contactField.setBounds(550, 200, 160, 30);
        emailField.setBounds(550, 240, 160, 30);
        passwordField.setBounds(550, 280, 160, 30);
        confirmPasswordField.setBounds(550, 320, 160, 30);
        setLocationRelativeTo(null);
        Back.setBounds(560, 380, 100, 25);
        Back.setBackground(Color.PINK);
        Back.setForeground(Color.black);

        signupButton.setBounds(380, 380, 100, 25);
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\DOCUMENTS\\University\\OOP1\\ROOMMATE\\tenantdata.txt", true))) {
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
