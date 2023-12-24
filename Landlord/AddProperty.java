package Landlord;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.nio.file.*;

public class AddProperty implements ActionListener {
    private final Container c;
    private final JFrame frame;
    private final JLabel type;
    private final JLabel size;
    private final JLabel rent;
    private final JLabel place;
    private final JLabel imgLabel2;

    private final JTextField attach;
    private final JTextField LandLordName;
    private final JTextField rentField;
    private final JTextField sizeField;
    private final JTextField addressField;

    private final JButton attachButton;
    private final JButton submitButton;
    private final JButton backButton;

    private final JPanel panel;

    private final Cursor cursor;

    public AddProperty() {

        frame = new JFrame();
        frame.setBounds(50, 40, 850, 550);
        frame.setTitle("Add Property");
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#1d65ad"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("images/market.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        panel = new JPanel();
        panel.setBounds(520, 120, 260, 260);
        panel.setLayout(null);
        panel.setVisible(true);
        panel.setBackground(new Color(142, 224, 240));
        c.add(panel);

        JLabel add = new JLabel("Add Property Details");
        add.setBounds(360, 0, 200, 30);
        Font addFont = new Font("Times New Roman", Font.BOLD, 22);
        add.setFont(addFont);
        add.setForeground(Color.decode("#8ee0f0"));
        frame.add(add);

        type = new JLabel("LandLord :");
        type.setBounds(150, 55, 150, 50);
        Font typeFont = new Font("Times New Roman", Font.PLAIN, 20);
        type.setFont(typeFont);
        type.setForeground(Color.decode("#8ee0f0"));
        frame.add(type);

        LandLordName = new JTextField();
        LandLordName.setBounds(150, 105, 236, 30);
        Font userfieldFont = new Font("Verdana", Font.PLAIN, 17);
        LandLordName.setFont(userfieldFont);
        LandLordName.setOpaque(false);
        LandLordName.setForeground(new Color(219, 226, 233));
        LandLordName.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(14, 14, 14));
        LandLordName.setBorder(redBorder1);
        frame.add(LandLordName);

        place = new JLabel("Place :");
        place.setBounds(150, 155, 150, 50);
        Font fullNameFont = new Font("Times New Roman", Font.PLAIN, 20);
        place.setFont(fullNameFont);
        place.setForeground(Color.decode("#8ee0f0"));
        frame.add(place);

        addressField = new JTextField();
        addressField.setBounds(150, 195, 236, 30);
        Font fullFieldFont = new Font("Verdana", Font.PLAIN, 17);
        addressField.setFont(fullFieldFont);
        addressField.setOpaque(false);
        addressField.setForeground(new Color(219, 226, 233));
        addressField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0));
        addressField.setBorder(redBorder);
        frame.add(addressField);

        size = new JLabel("Size :");
        size.setBounds(150, 245, 150, 50);
        Font passwordFont = new Font("Times New Roman", Font.PLAIN, 20);
        size.setFont(passwordFont);
        size.setForeground(Color.decode("#8ee0f0"));
        frame.add(size);

        sizeField = new JTextField();
        sizeField.setBounds(150, 285, 236, 30);
        Font passfieldFont = new Font("Verdana", Font.PLAIN, 17);
        sizeField.setFont(passfieldFont);
        sizeField.setOpaque(false);
        sizeField.setForeground(new Color(219, 226, 233));
        sizeField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0));
        sizeField.setBorder(redBorder3);
        frame.add(sizeField);


        rent = new JLabel("Rent per month :");
        rent.setBounds(150, 335, 150, 50);
        Font emailFont = new Font("Times New Roman", Font.PLAIN, 20);
        rent.setFont(emailFont);
        rent.setForeground(Color.decode("#8ee0f0"));
        frame.add(rent);

        rentField = new JTextField();
        rentField.setBounds(150, 375, 236, 30);
        Font emailFieldFont = new Font("Verdana", Font.PLAIN, 17);
        rentField.setFont(emailFieldFont);
        rentField.setOpaque(false);
        rentField.setForeground(new Color(219, 226, 233));
        rentField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(0, 0, 0));
        rentField.setBorder(redBorder2);
        frame.add(rentField);

        JLabel addPhoto = new JLabel("Add a photo here ");
        addPhoto.setBounds(570, 55, 200, 30);
        Font addPhotoFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        addPhoto.setFont(addPhotoFont);
        addPhoto.setForeground(Color.decode("#8ee0f0"));
        frame.add(addPhoto);


        attach = new JTextField();
        attach.setBounds(540, 365, 220, 30);
        Font attachFont = new Font("Verdana", Font.PLAIN, 17);
        attach.setFont(attachFont);
        attach.setOpaque(false);
        attach.setForeground(new Color(219, 226, 233));
        attach.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder5 = BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(14, 37, 110));
        attach.setBorder(redBorder5);
        frame.add(attach);

        attachButton = new JButton("Attachment");
        attachButton.setBounds(520, 395, 120, 60);
        attachButton.setBackground(new Color(219, 219, 9));
        attachButton.setForeground(Color.decode("#000000"));
        Font attachButtonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        attachButton.setFont(attachButtonFont);
        attachButton.setCursor(cursor);
        attachButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(attachButton);

        submitButton = new JButton("Submit");
        submitButton.setBounds(661, 395, 120, 60);
        submitButton.setBackground(new Color(219, 219, 9));
        submitButton.setForeground(Color.decode("#000000"));
        Font submitButtonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        submitButton.setFont(submitButtonFont);
        submitButton.setCursor(cursor);
        submitButton.setBorder(BorderFactory.createEmptyBorder());
        frame.add(submitButton);




        backButton = new JButton("Back");
        backButton.setBackground(new Color(142, 224, 240));
        backButton.setForeground(Color.decode("#000000"));
        Font backbuttonFont = new Font("Comic Sans MS", Font.PLAIN, 20);
        backButton.setFont(backbuttonFont);
        backButton.setCursor(cursor);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setBounds(150, 450, 236, 30);
        frame.add(backButton);



        imgLabel2 = new JLabel();
        panel.add(imgLabel2);


        submitButton.addActionListener(this);
        attachButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String name1 = LandLordName.getText();
        String size1 = sizeField.getText();
        String rent1 = rentField.getText();
        String addressField = this.addressField.getText();
        String attach1 = attach.getText();

        boolean typeEmpty = name1.isEmpty();
        boolean sizeEmpty = size1.isEmpty();
        boolean rentEmpty = rent1.isEmpty();
        boolean placeEmpty = addressField.isEmpty();
        boolean attachEmpty = attach1.isEmpty();

        if (e.getSource() == submitButton) {
            if (!typeEmpty && !sizeEmpty && !rentEmpty && !attachEmpty) {
                try {
                    int n = Integer.parseInt(rent1);
                    String line = "Apartments\\Property.txt";
                    try {
                        File file = new File(line);
                        if (!file.exists()) {
                            file.createNewFile();
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);
                            printWriter.close();
                        }

                        BufferedReader readFile3 = new BufferedReader(new FileReader("Apartments\\Property.txt"));
                        int totalLines3 = 0;
                        while (readFile3.readLine() != null) {
                            totalLines3++;
                        }
                        readFile3.close();

                        boolean flag = true;
                        for (int k = 0; k < totalLines3; k++) {

                            String linek = Files.readAllLines(Paths.get("Apartments\\Property.txt")).get(k);
                            if (linek.equals(name1)) {
                                flag = false;
                                break;
                            }

                        }
                        if (flag) {
                            String image = "";
                            String p = attach1;
                            char ch;
                            for (int i = attach1.length() - 1; i >= 0; i--) {
                                if (p.charAt(i) == '\\') {
                                    break;
                                } else {
                                    ch = p.charAt(i);
                                    image = ch + image;
                                }
                            }
                            image = "Apartments\\" + image;
                            FileWriter fileWriter = new FileWriter(file, true);
                            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                            PrintWriter printWriter = new PrintWriter(bufferedWriter);


                            printWriter.println(name1);
                            printWriter.println(size1);
                            printWriter.println(rent1);
                            printWriter.println(addressField);
                            printWriter.println(image);
                            printWriter.println();
                            printWriter.close();
                        } else {
                            JOptionPane.showMessageDialog(null, "Same type shop already exist", "Error",
                                    JOptionPane.WARNING_MESSAGE);
                        }
                        frame.setVisible(false);
                        new LandLordDashboard();

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Rent Field", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }

            } else if (!typeEmpty && !sizeEmpty && !rentEmpty && !placeEmpty && attachEmpty) {
                JOptionPane.showMessageDialog(null, "Please attach a photo", "Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all the field", "Error",
                        JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == attachButton)

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
            }

        } else if (e.getSource() == backButton) {
            frame.setVisible(false);
            new LandLordDashboard();
        }
    }

}