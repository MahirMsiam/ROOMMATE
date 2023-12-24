package Classes;

import Interfaces.*;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.*;
import java.io.*;
import java.awt.Font;

public class login implements ActionListener, Ilginval {

    JFrame loginFrame;
    JPanel loginDashboard;
    JPanel adminLogin;
    JLabel background, poster;
    JLabel userlabel, passlabel, ad_usl, ad_psl;
    JPasswordField pasF, ad_pf;
    JTextField usertf, passtf;
    RoundButton login, signup, exit;
    JButton frgtpass, Admin; // login dashboard
    JButton lgin, b7, b8, ad_exi, bc2usr; // admin Login

    login() {

        // create frame
        loginFrame = new JFrame();

        ImageIcon image = new ImageIcon("Media\\loginBg.jpg");
        background = new JLabel(image);
        background.setBounds(0, 0, 1100, 700);

        // icon
        ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");

        // login dashboard panel
        loginDashboard = new JPanel();
        userlabel = new JLabel("Email:");
        Font smallFont = userlabel.getFont().deriveFont(Font.PLAIN, 18f);
        userlabel.setBounds(610, 245, 150, 20);
        userlabel.setForeground(Color.BLACK);
        userlabel.setFont(smallFont);

        passlabel = new JLabel("Password:");
        passlabel.setBounds(610, 315, 150, 20);
        passlabel.setForeground(Color.BLACK);
        passlabel.setFont(smallFont);

        usertf = new JTextField("", 2);
        usertf.setBounds(725, 242, 300, 32);

        usertf.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        Font bigFont = usertf.getFont().deriveFont(Font.PLAIN, 20);
        usertf.setFont(bigFont);
        usertf.setOpaque(false);
        // usertf.setContentAreaFilled(false);
        // usertf.setBorderPainted(false);

        pasF = new JPasswordField("", 2);
        pasF.setBounds(725, 311, 300, 32);
        pasF.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        pasF.setFont(smallFont);
        pasF.setOpaque(false);
        // / pasF.setContentAreaFilled(false);
        // pasF.setBorderPainted(false);

        login = new RoundButton("LOGIN");
        login.setBounds(680, 420, 100, 35);
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.black);
        login.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        /*
         * login.setOpaque(true);
         * login.setContentAreaFilled(true);
         */

        signup = new RoundButton("SIGN-UP");
        signup.setBounds(850, 420, 100, 35);
        signup.addActionListener(this);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.black);
        signup.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
        /*
         * signup.setOpaque(true);
         * signup.setContentAreaFilled(true);
         */

        login.setBackground(new Color(167, 199, 231)); // pastel blue
        signup.setBackground(new Color(167, 199, 231)); // pastel blue

        frgtpass = new JButton("Forgot Password");
        frgtpass.setBounds(610, 355, 135, 20);
        frgtpass.addActionListener(this);
        frgtpass.setOpaque(false);
        frgtpass.setContentAreaFilled(false);
        frgtpass.setBorderPainted(false);
        frgtpass.setForeground(Color.BLACK);

        exit = new RoundButton("Exit");
        exit.setBounds(1000, 620, 80, 30);
        exit.addActionListener(this);
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);
        exit.setForeground(Color.BLACK);
        exit.setBackground(new Color(191, 49, 49)); // pastel blue
        exit.setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.black));

        Admin = new JButton("*Administrator portal");
        Admin.setBounds(0, 620, 200, 30);
        Admin.addActionListener(this);
        Admin.setOpaque(false);
        Admin.setContentAreaFilled(false);
        Admin.setBorderPainted(false);
        Admin.setForeground(Color.BLACK);

        loginDashboard.add(login);
        loginDashboard.add(signup);
        // loginDashboard.add(frgtpass);
        loginDashboard.add(exit);
        loginDashboard.add(Admin);
        loginDashboard.add(userlabel);
        loginDashboard.add(passlabel);
        loginDashboard.add(usertf);
        loginDashboard.add(pasF);
        loginDashboard.add(background);
        // loginDashboard.add(slider);
        loginDashboard.setLayout(null);
        loginDashboard.setBounds(0, 0, 1100, 700);
        loginDashboard.setBackground(Color.gray);
        loginDashboard.setVisible(true);

        // admin login panel

        adminLogin = new JPanel();
        ad_usl = new JLabel("Username: ");
        ad_usl.setBounds(390, 245, 150, 20);
        ad_usl.setForeground(Color.BLACK);
        ad_usl.setFont(smallFont);

        ad_psl = new JLabel("Password: ");
        ad_psl.setBounds(390, 315, 150, 20);
        ad_psl.setForeground(Color.BLACK);
        ad_psl.setFont(smallFont);

        passtf = new JTextField("", 4);
        passtf.setBounds(495, 240, 300, 32);
        passtf.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        passtf.setFont(bigFont);
        passtf.setOpaque(false);

        ad_pf = new JPasswordField("", 4);
        ad_pf.setBounds(495, 308, 300, 32);
        ad_pf.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.BLACK));
        ad_pf.setFont(bigFont);
        ad_pf.setOpaque(false);

        lgin = new JButton("Login");
        lgin.setBounds(545, 400, 150, 50);
        lgin.addActionListener(this);
        lgin.setOpaque(true);
        lgin.setContentAreaFilled(true);
        lgin.setBackground(Color.BLACK);
        lgin.setBorderPainted(true);
        lgin.setForeground(Color.WHITE);

        ad_exi = new JButton("Exit");
        ad_exi.setBounds(1000, 620, 80, 30);
        ad_exi.addActionListener(this);
        ad_exi.setOpaque(false);
        ad_exi.setContentAreaFilled(false);
        ad_exi.setBorderPainted(false);
        ad_exi.setForeground(Color.BLACK);

        bc2usr = new JButton("go back to user Login");
        bc2usr.setBounds(0, 620, 200, 30);
        bc2usr.addActionListener(this);
        bc2usr.setOpaque(false);
        bc2usr.setContentAreaFilled(false);
        bc2usr.setBorderPainted(false);
        bc2usr.setForeground(Color.BLACK);

        ImageIcon img = new ImageIcon("Media\\admindash.jpg");
        poster = new JLabel(img);
        poster.setBounds(0, 0, 1100, 700);

        adminLogin.add(ad_usl);
        adminLogin.add(ad_psl);
        adminLogin.add(lgin);
        adminLogin.add(ad_exi);
        adminLogin.add(bc2usr);
        adminLogin.add(passtf);
        adminLogin.add(ad_pf);
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
        loginFrame.setTitle("Login - ROOMMATE");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(1100, 700);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String user = usertf.getText();
            String pass = new String(pasF.getPassword());
            // validating data from txt file
            if (user.isEmpty() || pass.isEmpty()) {
                showMessageDialog(null, "Fields cannot be empty");
            }

            else if (validateLoginUser(user, pass)) {
                showMessageDialog(null, "Login successful!");
                // Additional frame here
            }

            else { // Login failed
                showMessageDialog(null, "Invalid username or password!");
            }
        }

        else if (e.getSource() == exit) {
            new IntroDuck();
            loginFrame.setVisible(false);
        } else if (e.getSource() == signup) {
            new TenantSignup();
            loginFrame.setVisible(false);
        } else if (e.getSource() == Admin) {
            loginDashboard.setVisible(false);
            adminLogin.setVisible(true);
        } else if (e.getSource() == bc2usr) {
            loginDashboard.setVisible(true);
            adminLogin.setVisible(false);
        } else if (e.getSource() == ad_exi) {
            new IntroDuck();
            loginFrame.setVisible(false);
        } else if (e.getSource() == lgin) {
            String user = passtf.getText();
            String pass = new String(ad_pf.getPassword());
            // validating data from txt file
            if (user.isEmpty() || pass.isEmpty()) {
                showMessageDialog(null, "Fields cannot be empty");
            }

            else if (validateLoginAdmin(user, pass)) {
                // showMessageDialog(null, "Login successful!");
                // Additional frame here
                new AdminDashboard().setVisible(true);
                // loginFrame.setVisible(false);

            }

            else { // Login failed
                showMessageDialog(null, "Invalid username or password!");
            }

        }
    }

    // userpass validation methode
    @Override
    public boolean validateLoginUser(String user, String pass) {
        try (Scanner scanner = new Scanner(new File("Data\\tenantdata.txt"))) {
            StringBuilder userData = new StringBuilder();

            // Reading file into a StringBuilder
            while (scanner.hasNextLine()) {
                userData.append(scanner.nextLine().trim()).append("\n");
            }
            // Check if the entered credentials exist in the data
            String userCredentials = userData.toString();// String builder to regular String
            return userCredentials.contains("Email " + user) &&
                    userCredentials.contains("Password: " + pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // if Unable to validate login
    }

    @Override
    public boolean validateLoginAdmin(String user, String pass) {
        try (Scanner scanner = new Scanner(new File("Data\\Admindata.txt"))) {
            StringBuilder userData = new StringBuilder();

            // Reading file into a StringBuilder
            while (scanner.hasNextLine()) {
                userData.append(scanner.nextLine().trim()).append("\n");
            }
            // Check if the entered credentials exist in the data
            String userCredentials = userData.toString();// String builder to regular String
            return userCredentials.contains("Name: " + user) &&
                    userCredentials.contains("Password: " + pass);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false; // if Unable to validate login
    }
}
// Hello Bad Boy!!!
