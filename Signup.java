import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    private JTextField nameField, addressField, contactField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signupButton,Back;

    public Signup() {
        // Setting up the frame
        setTitle("Signup Frame");
        setSize(800, 600);
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
        Back =new JButton("Back");
        
        // Setting bounds for components
        nameLabel.setBounds(20, 20, 80, 25);
        addressLabel.setBounds(20, 60, 80, 25);
        contactLabel.setBounds(20, 100, 120, 25);
        emailLabel.setBounds(20, 140, 80, 25);
        passwordLabel.setBounds(20, 180, 80, 25);
        confirmPasswordLabel.setBounds(20, 220, 150, 25);

        nameField.setBounds(180, 20, 150, 25);
        addressField.setBounds(180, 60, 150, 25);
        contactField.setBounds(180, 100, 150, 25);
        emailField.setBounds(180, 140, 150, 25);
        passwordField.setBounds(180, 180, 150, 25);
        confirmPasswordField.setBounds(180, 220, 150, 25);
        setLocationRelativeTo(null);
        Back.setBounds(100,280,100,25);
        signupButton.setBounds(250, 280, 100, 25);
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
                // Perform signup logic (e.g., save to database, show confirmation)
                JOptionPane.showMessageDialog(this, "Signup successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid input or passwords do not match.");
            }
        }
        else if(e.getSource()==Back){
            new login();
            setVisible(false);
        }
    }

    private boolean validateInputs(String name, String address, String contact, String email,
                                    char[] password, char[] confirmPassword) {
        // Add your validation logic here
        // For example, check if the fields are not empty, validate email format,
        // and ensure that password and confirmPassword match.

        // For simplicity, this example just checks if the password and confirmPassword match.
        return new String(password).equals(new String(confirmPassword));
    }

//     public static void main(String[] args) {
//         new Signup();
//     }
}
