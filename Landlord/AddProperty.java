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
    private final JLabel descriptionField;
    private final JLabel size;
    private final JLabel rent;
    private final JLabel place;
    private final JLabel imgLabel2;
    private final JLabel uploadLabel;

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

        descriptionField = new JLabel("LandLord :");
        descriptionField.setBounds(150, 55, 150, 50);
        Font typeFont = new Font("Times New Roman", Font.PLAIN, 20);
        descriptionField.setFont(typeFont);
        descriptionField.setForeground(Color.decode("#8ee0f0"));
        frame.add(descriptionField);

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
            String description = descriptionField.getText();

            if (address.isEmpty() || rent.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields");

            } else if (validateInputs(address, rent, description)) {
                saveDataToFile(address, rent, description);//saves data to file if true
                JOptionPane.showMessageDialog(null, "Property Added Successfully");
            }
        } else if (e.getSource() == attachButton) {
            BufferedImage img = selectImage();
            if (img != null) {
                try {
                    File outputFile = new File("C:\\Users\\moyaz\\OneDrive\\Documents\\New folder\\ROOMMATE\\Apartments\\"+LandLordName.getText()+".jpg");
                    outputFile.getParentFile().mkdirs(); // Create parent directories if needed
                    ImageIO.write(img, "jpg", outputFile);
                    System.out.println("Image saved successfully!");
                } catch (IOException e1) {
                    System.err.println("Error saving image: " + e1.getMessage());
                    // Optionally, provide a user-friendly error message here
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






    private boolean validateInputs(String address, String rent, String description) {
        // validation logic here

        // check if the fields are not empty
        if (address.isEmpty() || rent.isEmpty() || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return false;
        }
        return true;
    }

    private void saveDataToFile(String address,String rent, String description){
        try (BufferedWriter writer= new BufferedWriter(new FileWriter("Apartments\\Property.txt",true))) {
            //Append the user data to the text file
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.write("Property added at: " + dtf.format(now)+ "\n");
            writer.write("Address: " + address + "\n");
            writer.write("Rent: " + rent + "\n");
            writer.write("Description: " + description + "\n");
            writer.write("====================\n");
        } catch (IOException ioException){
            ioException.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data");//Add a separator between entries
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