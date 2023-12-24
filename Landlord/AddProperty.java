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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.nio.file.*;


public class AddProperty implements ActionListener {

    private JFrame frame;
    private Container c;
    private JTextField addressField, rentField, sizeField,attach;
    private JLabel addressLabel;
    private JLabel imgLabel2;
    private JPanel panel;
    private Cursor cursor;
    private JButton submit, Back, upload;
    private JRadioButton wifiYes, wifiNo;
    String uniqueID= UUID.randomUUID().toString();
    BufferedImage img;

    public AddProperty() {
        frame = new JFrame();
        frame.setBounds(50,50,1100,700);
        frame.setTitle("Add Property");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#24292e"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("Media\\landlord.png");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        panel = new JPanel();
        panel.setBounds(200,200,360,300);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(49,11,112,50));
        c.add(panel);

        JLabel add = new JLabel("Add Property Details");
        add.setBounds(250, 50, 300, 30);
        Font addFont = new Font("Arial", Font.BOLD, 20);
        add.setFont(addFont);
        add.setForeground(Color.WHITE);
        frame.add(add);

        addressLabel = new JLabel("Address :");
        addressLabel.setBounds(170, 120, 160, 30);
        Font fullNameFont = new Font("Arial", Font.BOLD, 15);
        addressLabel.setFont(fullNameFont);
        addressLabel.setForeground(Color.WHITE);
        frame.add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(260, 120, 180, 30);
        Font fullFieldFont= new Font("Arial", Font.BOLD, 15);
        addressField.setFont(fullFieldFont);
        addressField.setOpaque(false);
        addressField.setForeground(Color.WHITE);
        addressField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        frame.add(addressField);

        sizeField = new JTextField();
        sizeField.setBounds(150, 260, 236, 30);
        Font passfieldFont = new Font("Verdana", Font.PLAIN, 17);
        sizeField.setFont(passfieldFont);
        sizeField.setOpaque(false);
        sizeField.setForeground(Color.WHITE);
        frame.add(sizeField);

        JLabel rentLabel = new JLabel("Rent per month :");
        rentLabel.setBounds(150, 400, 150, 50);
        Font emailFont = new Font("Times New Roman", Font.PLAIN, 20);
        rentLabel.setFont(emailFont);
        rentLabel.setForeground(Color.WHITE);
        frame.add(rentLabel);

        rentField = new JTextField();
        rentField.setBounds(150, 440, 236, 30);
        Font emailFieldFont = new Font("Verdana", Font.PLAIN, 17);
        rentField.setFont(emailFieldFont);
        rentField.setOpaque(false);
        rentField.setForeground(Color.WHITE);
        frame.add(rentField);

        attach = new JTextField();
        attach.setBounds(540, 365, 220, 30);
        Font attachFont = new Font("Verdana", Font.PLAIN, 17);
        attach.setFont(attachFont);
        attach.setOpaque(false);
        attach.setForeground(new Color(219, 226, 233));
        attach.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(49, 111, 112));
        attach.setBorder(redBorder5);
        frame.add(attach);

        upload = new JButton("Upload");
        upload.setBounds(540, 400, 220, 30);
        upload.setBackground(new Color(49, 111, 112));
        upload.setForeground(Color.WHITE);
        upload.setFont(new Font("Arial", Font.BOLD, 15));
        upload.setBorder(BorderFactory.createEmptyBorder());
        upload.setCursor(cursor);
        frame.add(upload);

        submit = new JButton("Submit");
        submit.setBounds(150, 500, 100, 35);
        submit.setBackground(new Color(49, 111, 112));
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setCursor(cursor);
        frame.add(submit);

        Back = new JButton("Back");
        Back.setBounds(150, 550, 100, 35);
        Back.setBackground(new Color(49, 111, 112));
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Arial", Font.BOLD, 15));
        Back.setBorder(BorderFactory.createEmptyBorder());
        Back.setCursor(cursor);
        frame.add(Back);

        JLabel imgLabel2 = new JLabel();
        panel.add(imgLabel2);


        //adding action listeners
        submit.addActionListener(this);
        upload.addActionListener(this);
        Back.addActionListener(this);



    }

    public void actionPerformed(ActionEvent e) {

        String wifi = "";
        String size1 = sizeField.getText();
        String rent1 = rentField.getText();
        String address1 = addressField.getText();
        String attach1 = attach.getText();

        boolean sizeEmpty = size1.isEmpty();
        boolean rentEmpty = rent1.isEmpty();
        boolean addressEmpty = address1.isEmpty();
        boolean attachEmpty = attach1.isEmpty();

        if (e.getSource() == submit) {
            if (addressEmpty == false && rentEmpty == false && attachEmpty == false && sizeEmpty == false) {
                try {
                    int n = Integer.parseInt(rent1);
                    String line = "Apartments\\\\Property.txt";
                    try {
                        File file = new File(line);
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);
                            printWriter.close();
                        }

                        BufferedReader readFile3 = new BufferedReader(new FileReader("Apartments\\\\Property.txt"));
                        int totalLines3 = 0;
                        while (readFile3.readLine() != null) {
                            totalLines3++;
                        }
                        readFile3.close();
                        frame.setVisible(false);
                        new LandLordDashboard();

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Rent Field", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }

            } else if (!sizeEmpty && !rentEmpty && attachEmpty && !addressEmpty) {
                JOptionPane.showMessageDialog(null, "Please attach a photo", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all the field", "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == upload)

        {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(null);
                File f = chooser.getSelectedFile();
                String filename = f.getAbsolutePath();
                attach.setText(filename);
                imgLabel2.setIcon(new ImageIcon(filename));
                imgLabel2.setBounds(0, 0, 260, 260);

            } catch (Exception ex) {
                return;
            }
        } else if (e.getSource() == Back)
            frame.setVisible(false);
        new LandLordDashboard();
    }
}













