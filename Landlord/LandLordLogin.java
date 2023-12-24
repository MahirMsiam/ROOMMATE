package Landlord;

import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static javax.swing.JOptionPane.showMessageDialog;

public class LandLordLogin implements ActionListener {

    JFrame loginFrame;
    JPanel loginDashboard;
    JLabel background;
    JLabel userlabel, passlabel;
    JPasswordField PasswordField;
    JTextField emailTextField, UserPasswordField;
    JButton login;
    JButton signup;
    JButton ForgotPass;
    JButton exit;
    JToggleButton showPassword;
    ImageIcon on, off;

    public LandLordLogin() {

        // create frame
        loginFrame = new JFrame();

        ImageIcon image = new ImageIcon("Media\\loginBg.jpg");
        background = new JLabel(image);
        background.setBounds(0, 0, 1100, 700);

        // icon
        ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");

        // login dashboard panel
        loginDashboard = new JPanel();
        userlabel = new JLabel("Username:");
        Font smallFont = userlabel.getFont().deriveFont(Font.PLAIN, 18f);
        userlabel.setBounds(610, 245, 150, 20);
        userlabel.setForeground(Color.BLACK);
        userlabel.setFont(smallFont);

        passlabel = new JLabel("Password:");
        passlabel.setBounds(610, 315, 150, 20);
        passlabel.setForeground(Color.BLACK);
        passlabel.setFont(smallFont);

        emailTextField = new JTextField("", 2);
        emailTextField.setBounds(725, 242, 300, 32);

        emailTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        Font bigFont = emailTextField.getFont().deriveFont(Font.PLAIN, 20);
        emailTextField.setFont(bigFont);
        emailTextField.setOpaque(false);
        // usertf.setContentAreaFilled(false);
        // usertf.setBorderPainted(false);

        PasswordField = new JPasswordField("", 2);
        PasswordField.setBounds(725, 311, 300, 32);
        PasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        PasswordField.setFont(smallFont);
        PasswordField.setOpaque(false);
        // / pasF.setContentAreaFilled(false);
        // pasF.setBorderPainted(false);

        login = new JButton("Login as Land Lord");
        login.setBounds(680, 420, 150, 50);
        login.addActionListener(this);
        login.setOpaque(true);
        login.setContentAreaFilled(true);
        login.setBackground(Color.BLACK);
        login.setBorderPainted(true);
        login.setForeground(Color.WHITE);

        signup = new JButton("Sign-up as Land Lord");
        signup.setBounds(850, 420, 170, 50);
        signup.addActionListener(this);
        signup.setOpaque(true);
        signup.setContentAreaFilled(true);
        signup.setBackground(Color.BLACK);
        signup.setBorderPainted(true);
        signup.setForeground(Color.WHITE);

        ForgotPass = new JButton("Forgot Password");
        ForgotPass.setBounds(610, 355, 135, 20);
        ForgotPass.addActionListener(this);
        ForgotPass.setOpaque(false);
        ForgotPass.setContentAreaFilled(false);
        ForgotPass.setBorderPainted(false);
        ForgotPass.setForeground(Color.BLACK);

        exit = new JButton("Exit");
        exit.setBounds(1000, 620, 80, 30);
        exit.addActionListener(this);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setForeground(Color.BLACK);


        on = new ImageIcon("Media\\show.png");
        off = new ImageIcon("Media\\hidden.png");
        showPassword = new JToggleButton(off);
        showPassword.setBounds(1025, 303, 40, 40);
        showPassword.setBackground(new Color(0, 0, 0, 0));
        showPassword.setForeground(new Color(0, 0, 0, 0));
        showPassword.setOpaque(false);
        showPassword.addActionListener(this);
        loginFrame.add(showPassword);


        loginDashboard.add(login);
        loginDashboard.add(signup);
        loginDashboard.add(ForgotPass);
        loginDashboard.add(exit);
        //loginDashboard.add(Admin);
        loginDashboard.add(userlabel);
        loginDashboard.add(passlabel);
        loginDashboard.add(emailTextField);
        loginDashboard.add(PasswordField);
        loginDashboard.add(background);

        // loginDashboard.add(slider);
        loginDashboard.setLayout(null);
        loginDashboard.setBounds(0, 0, 1100, 700);
        loginDashboard.setBackground(Color.gray);
        loginDashboard.setVisible(true);


        UserPasswordField = new JTextField("", 4);
        UserPasswordField.setBounds(495, 240, 300, 32);
        UserPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        UserPasswordField.setFont(bigFont);
        UserPasswordField.setOpaque(false);



        loginFrame.setIconImage(icon.getImage());
        loginFrame.add(loginDashboard);

        loginFrame.setLayout(null);
        loginFrame.setTitle("Login - LandLord");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(1100, 700);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String email = emailTextField.getText();
            String pass = new String(PasswordField.getPassword());
            // validating data from txt file by checking hashmap
            if (email.isEmpty() || pass.isEmpty()) {
                showMessageDialog(null, "Both fields are required!");
                // add another condition to check for empty field
            } else if (validateLogin(email, pass)) {
                showMessageDialog(null, "Login Successful");
                LandLordDashboard frame = new LandLordDashboard();
                frame.setVisible(true);
                loginFrame.setVisible(false);
                // Additional logic if login is successful
            } else { // Login failed
                showMessageDialog(null, "Invalid username or password!");
            }
        }

        else if (e.getSource() == exit)
        {
            new IntroDuck();
            loginFrame.setVisible(false);
        } else if (e.getSource() == signup) {
            new LandLordSignup();
            loginFrame.setVisible(false);
         }
    }



    // userpass validation methode
    private boolean validateLogin(String pass,String email) {
        try (Scanner scanner = new Scanner(new File("Data\\LandLordData.txt"))) {
            StringBuilder userData = new StringBuilder();

            // Read the entire file into a StringBuilder
            while (scanner.hasNextLine()) {
                userData.append(scanner.nextLine().trim()).append("\n");
            }
            // Check if the entered credentials exist in the data
            String userCredentials = userData.toString();
            return userCredentials.contains("Email " + email) &&
                    userCredentials.contains("Password: " + pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // Unable to validate login
    }


}
// Hello Bad Boy!!