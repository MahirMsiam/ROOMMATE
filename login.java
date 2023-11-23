import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.*;
import java.io.*;

public class login implements ActionListener {

    private JButton lgnBtn;
    private JButton signBtn;
    private JButton exBtn;
    private JLabel lusn;
    private JLabel lpass;
    private JTextField uname;
    private JPasswordField upass;
    JFrame frame;
    private Map<String, String> userPasswordMap;// creating hashmap

    login() {

        // create frame
        frame = new JFrame("Please Login");
        // construct components
        lgnBtn = new JButton("Login");
        signBtn = new JButton("Sign Up");
        exBtn = new JButton("Exit");
        lusn = new JLabel("Username");
        lpass = new JLabel("Password");
        uname = new JTextField();
        upass = new JPasswordField();

        // set component bounds (only needed by Absolute Positioning)
        lgnBtn.setBounds(150, 185, 100, 30);
        signBtn.setBounds(305, 185, 100, 30);
        exBtn.setBounds(205, 235, 140, 30);
        lusn.setBounds(150, 105, 100, 25);
        lpass.setBounds(150, 145, 100, 25);
        uname.setBounds(305, 105, 100, 25);
        upass.setBounds(305, 145, 100, 25);

        Color fontColor = Color.WHITE;

        lgnBtn.setForeground(fontColor);
        signBtn.setForeground(fontColor);
        exBtn.setForeground(fontColor);
        lusn.setForeground(fontColor);
        lpass.setForeground(fontColor);
        uname.setForeground(fontColor);
        upass.setForeground(fontColor);

        // addActionListener
        lgnBtn.addActionListener(this);
        exBtn.addActionListener(this);
        signBtn.addActionListener(this);
        // add components
        frame.add(lgnBtn);
        frame.add(signBtn);
        frame.add(exBtn);
        frame.add(lusn);
        frame.add(lpass);
        frame.add(uname);
        frame.add(upass);

        // frame properties
        // adjust size and set layout
        frame.setSize(624, 400);
        frame.setLocationRelativeTo(null);// to center screen gui
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane();
        frame.setVisible(true);
        userPasswordMap = readdata("E:\\DOCUMENTS\\University\\OOP1\\ROOMMATE\\data.txt");// Initializing read method for mapping
        // set background color
        Color backgroundColor = new Color(12, 53, 106);
        frame.getContentPane().setBackground(backgroundColor);

        // set text field color
        Color textFieldColor = new Color(255, 196, 54); // #FFC436
        uname.setBackground(textFieldColor);
        upass.setBackground(textFieldColor);

    }

    // @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lgnBtn) {
            String user = uname.getText();
            String pass = new String(upass.getPassword());
            // validating data from txt file by checking hashmap
            if (userPasswordMap.containsKey(user) && userPasswordMap.get(user).equals(pass)) {
                showMessageDialog(null, "Login successful!");
                // new frame
                // frame.setVisible(false);
            } else {
                showMessageDialog(null, "Invalid Username or Password!");
            }
        } else if (e.getSource() == exBtn) {
            new IntroDuck();
            frame.setVisible(false);
        } else if (e.getSource() == signBtn) {
            new Signup();
            frame.setVisible(false);
        }
    }

    // Reading Lines from txt file with try catc method
    private Map<String, String> readdata(String filePath) {
        Map<String, String> userDataMap = new HashMap<>();// initializing hashmap
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    userDataMap.put(parts[0], parts[1]);
                }
            }
            // catcing exceptions and stack tracing
        } catch (IOException e) {
            // e.printStackTrace();
            showMessageDialog(null, "Error reading user data from file.");
        }

        return userDataMap;
    }

}