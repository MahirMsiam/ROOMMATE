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
    JPanel adminLogin;
    JLabel background, poster;
    JLabel userlabel, passlabel, AdminUser, AdminPassword;
    JPasswordField PasswordField, AdminPasswordField;
    JTextField UserTextfield, UserPasswordField;
    JButton login, signup, ForgotPass, exit, Admin; // login dashboard
    JButton AdminLogin, AdminExit, BackToUser; // admin Login

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

        UserTextfield = new JTextField("", 2);
        UserTextfield.setBounds(725, 242, 300, 32);

        UserTextfield.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        Font bigFont = UserTextfield.getFont().deriveFont(Font.PLAIN, 20);
        UserTextfield.setFont(bigFont);
        UserTextfield.setOpaque(false);
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

        Admin = new JButton("*Administrator portal");
        Admin.setBounds(0, 620, 200, 30);
        Admin.addActionListener(this);
        Admin.setOpaque(false);
        Admin.setContentAreaFilled(false);
        Admin.setBorderPainted(false);
        Admin.setForeground(Color.BLACK);

        loginDashboard.add(login);
        loginDashboard.add(signup);
        loginDashboard.add(ForgotPass);
        loginDashboard.add(exit);
        loginDashboard.add(Admin);
        loginDashboard.add(userlabel);
        loginDashboard.add(passlabel);
        loginDashboard.add(UserTextfield);
        loginDashboard.add(PasswordField);
        loginDashboard.add(background);
        // loginDashboard.add(slider);
        loginDashboard.setLayout(null);
        loginDashboard.setBounds(0, 0, 1100, 700);
        loginDashboard.setBackground(Color.gray);
        loginDashboard.setVisible(true);

        // admin login panel

        adminLogin = new JPanel();
        AdminUser = new JLabel("Username: ");
        AdminUser.setBounds(390, 245, 150, 20);
        AdminUser.setForeground(Color.BLACK);
        AdminUser.setFont(smallFont);

        AdminPassword = new JLabel("Password: ");
        AdminPassword.setBounds(390, 315, 150, 20);
        AdminPassword.setForeground(Color.BLACK);
        AdminPassword.setFont(smallFont);

        UserPasswordField = new JTextField("", 4);
        UserPasswordField.setBounds(495, 240, 300, 32);
        UserPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        UserPasswordField.setFont(bigFont);
        UserPasswordField.setOpaque(false);

        AdminPasswordField = new JPasswordField("", 4);
        AdminPasswordField.setBounds(495, 308, 300, 32);
        AdminPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        AdminPasswordField.setFont(bigFont);
        AdminPasswordField.setOpaque(false);

        AdminLogin = new JButton("Login");
        AdminLogin.setBounds(545, 400, 150, 50);
        AdminLogin.setOpaque(true);
        AdminLogin.setContentAreaFilled(true);
        AdminLogin.setBackground(Color.BLACK);
        AdminLogin.setBorderPainted(true);
        AdminLogin.setForeground(Color.WHITE);

        AdminExit = new JButton("Exit");
        AdminExit.setBounds(1000, 620, 80, 30);
        AdminExit.addActionListener(this);
        AdminExit.setOpaque(false);
        AdminExit.setContentAreaFilled(false);
        AdminExit.setBorderPainted(false);
        AdminExit.setForeground(Color.BLACK);

        BackToUser = new JButton("Back to user Login");
        BackToUser.setBounds(0, 620, 200, 30);
        BackToUser.addActionListener(this);
        BackToUser.setOpaque(false);
        BackToUser.setContentAreaFilled(false);
        BackToUser.setBorderPainted(false);
        BackToUser.setForeground(Color.BLACK);

        ImageIcon img = new ImageIcon("Media\\\\admindash.jpg");
        poster = new JLabel(img);
        poster.setBounds(0, 0, 1100, 700);

        adminLogin.add(AdminUser);
        adminLogin.add(AdminPassword);
        adminLogin.add(AdminLogin);
        adminLogin.add(AdminExit);
        adminLogin.add(BackToUser);
        adminLogin.add(UserPasswordField);
        adminLogin.add(AdminPasswordField);
        adminLogin.add(poster);
        // adminLogin.add(slider);
        adminLogin.setLayout(null);
        adminLogin.setBounds(0, 0, 1100, 700);
        adminLogin.setBackground(Color.blue);
        adminLogin.setVisible(false);

        loginFrame.setIconImage(icon.getImage());
        loginFrame.add(loginDashboard);
        loginFrame.add(adminLogin);

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
            String user = UserTextfield.getText();
            String pass = new String(PasswordField.getPassword());
            // validating data from txt file by checking hashmap
            if (user.isEmpty() || pass.isEmpty()) {
                showMessageDialog(null, "Both fields are required!");
                // add another condition to check for empty field
            } else if (validateLogin(user, pass)) {
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
        } else if (e.getSource() == signup)
        {
            new LandLordSignup();
            loginFrame.setVisible(false);
        } else if (e.getSource() == Admin)
        {
            loginDashboard.setVisible(false);
            adminLogin.setVisible(true);
        } else if (e.getSource() == BackToUser)
        {
            loginDashboard.setVisible(true);
            adminLogin.setVisible(false);
        } else if (e.getSource() == AdminExit) {
            new IntroDuck();
            loginFrame.setVisible(false);
        } else if (e.getSource() == AdminLogin)

        {
            String user = UserTextfield.getText();
            String pass = new String(AdminPasswordField.getPassword());
            // validating data from txt file by checking hashmap
            if (user.isEmpty() || pass.isEmpty()) {
                showMessageDialog(null, "Both fields are required!");
                // add another condition to check for empty field
            } else if (validateLogin(user, pass)) {
                showMessageDialog(null, "Login Successful");
                new AdminDashboard().setVisible(true);
                loginFrame.setVisible(false);
                // Additional logic if login is successful
            } else { // Login failed
                showMessageDialog(null, "Invalid username or password!");
            }
        }
    }

    // userpass validation methode
    private boolean validateLogin(String user, String pass) {
        try (Scanner scanner = new Scanner(new File("Data\\LandLordData.txt"))) {
            StringBuilder userData = new StringBuilder();

            // Read the entire file into a StringBuilder
            while (scanner.hasNextLine()) {
                userData.append(scanner.nextLine().trim()).append("\n");
            }
            // Check if the entered credentials exist in the data
            String userCredentials = userData.toString();
            return userCredentials.contains("Name: " + user) &&
                    userCredentials.contains("Password: " + pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // Unable to validate login
    }
}
// Hello Bad Boy!!