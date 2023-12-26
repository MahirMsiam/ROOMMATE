package Landlord;

import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.lang.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddProperty extends JFrame implements ActionListener {
    private final Container c;
    private final JFrame frame;
    private final JLabel LandLordNameLabel;
    private final JLabel size;
    private final JLabel rent;
    private final JLabel address;
    private final JLabel imgLabel2;
    private final JLabel uploadLabel;

    private final JTextField LandLordNameField;
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

        LandLordNameLabel = new JLabel("LandLord :");
        LandLordNameLabel.setBounds(150, 55, 150, 50);
        Font typeFont = new Font("Times New Roman", Font.PLAIN, 20);
        LandLordNameLabel.setFont(typeFont);
        LandLordNameLabel.setForeground(Color.decode("#8ee0f0"));
        frame.add(LandLordNameLabel);

        LandLordNameField = new JTextField();
        LandLordNameField.setBounds(150, 105, 236, 30);
        Font userfieldFont = new Font("Verdana", Font.PLAIN, 17);
        LandLordNameField.setFont(userfieldFont);
        LandLordNameField.setOpaque(false);
        LandLordNameField.setForeground(new Color(219, 226, 233));
        LandLordNameField.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder1 = BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(14, 14, 14));
        LandLordNameField.setBorder(redBorder1);
        frame.add(LandLordNameField);

        address = new JLabel("Place :");
        address.setBounds(150, 155, 150, 50);
        Font fullNameFont = new Font("Times New Roman", Font.PLAIN, 20);
        address.setFont(fullNameFont);
        address.setForeground(Color.decode("#8ee0f0"));
        frame.add(address);

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

        uploadLabel= new JLabel("No image selected");



        imgLabel2 = new JLabel();
        panel.add(imgLabel2);


        submitButton.addActionListener(this);
        attachButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == submitButton) {
            //getting input
            String address = addressField.getText();
            String rent = rentField.getText();
            String size = sizeField.getText();
            String LandLordName = LandLordNameField.getText();

            if (address.isEmpty() || rent.isEmpty() || LandLordName.isEmpty() || size.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");

            } else if (validateInputs(address, rent, LandLordName, size)) {
                saveDataToFile(address, rent, LandLordName, size);
                JOptionPane.showMessageDialog(null, "Property Added Successfully");
                new LandLordDashboard();
                frame.setVisible(false);
            }
        } else if (e.getSource() == attachButton) {
            BufferedImage img = selectImage();
            if (img != null) {
                try {
                    File outputFile = new File("Apartments\\"+LandLordNameField.getText()+".jpg");
                    outputFile.getParentFile().mkdirs(); // Create parent directories if needed
                    ImageIO.write(img, "jpg", outputFile);
                    System.out.println("Image saved successfully!");
                    imgLabel2.setIcon(new ImageIcon(img));
                    imgLabel2.setBounds(0, 0, 260, 260);
                    imgLabel2.setVisible(true);
                    panel.add(imgLabel2);
                    panel.repaint();

                } catch (IOException e1) {
                    System.err.println("Error saving image: " + e1.getMessage());
                }
            } else {
                System.out.println("No image was selected.");
            }
        }
        else if (e.getSource() == backButton) {
            new LandLordDashboard();
            frame.setVisible(false);
        }
    }

    private boolean validateInputs(String address, String rent, String LandLordName, String size) {
        // validation logic here

        // check if the fields are not empty
        if (address.isEmpty() || rent.isEmpty() || LandLordName.isEmpty() || size.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }
        return true;
    }

    private void saveDataToFile(String address,String rent, String LandLordName, String size){
        try (BufferedWriter writer= new BufferedWriter(new FileWriter("Apartments\\Property.txt",true))) {
            //Append the user data to the text file
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.write("====================\n");
            writer.write("Property added at: " + dtf.format(now)+ "\n");
            writer.write("Name: " + LandLordName + "\n");
            writer.write("Location: " + address + "\n");
            writer.write("Rent: " + rent + "\n");
            writer.write("Size: " + size + "\n");
            writer.write("====================\n");
        } catch (IOException ioException){
            ioException.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data");
        }
    }

    private BufferedImage selectImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            String imagePath = fileChooser.getSelectedFile().getPath();
            uploadLabel.setText("Selected Image: " + imagePath);

            try {
                return ImageIO.read(new File(imagePath)); // Load the image using ImageIO
            } catch (IOException e) {
                System.err.println("Error loading image: " + e.getMessage());
                // Optionally, provide a user-friendly error message here
                return null; // Indicate failure to load the image
            }
        } else {
            return null; // No image was selected
        }
    }

}
/*HAPPY CODING
If you liked it and it helped you drp a star
Every Method is open for all just copy and paste
DM freely on my socials in case you need help
*/
