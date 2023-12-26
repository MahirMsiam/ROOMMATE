package Classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class opening {
    public opening() {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");// icon
                // Creating the Cards
                JPanel card1 = new JPanel();
                ImageIcon img1 = new ImageIcon("Media\\Roommate logo.gif");
                JLabel label1 = new JLabel(img1);
                card1.add(label1);

                JPanel card2 = new JPanel();
                ImageIcon img2 = new ImageIcon("Media\\pg2.jpg ");
                JLabel label2 = new JLabel(img2);
                card2.add(label2);

                // Creating the panel that contains the cards
                CardLayout cl = new CardLayout();
                JPanel cards = new JPanel(cl);
                cards.add(card1, "Loading");
                cards.add(card2, "swipeup");

                // Create and set up the window
                JFrame frame = new JFrame("ROOMMATE");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.add(cards);
                frame.pack();
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setIconImage(icon.getImage());

                // Add a mouse listener to card2 for swipe detection
                card2.addMouseListener(new MouseAdapter() {
                    Point point = new Point();
                    @Override
                    public void mousePressed(MouseEvent e) {
                        point = e.getPoint();
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        // Check if the mouse was dragged upwards
                        if (e.getPoint().y < point.y) {
                            // Switch to Login class
                            frame.dispose(); // Dispose the current frame
                            IntroDuck IntroDuck = new IntroDuck();
                            IntroDuck.setVisible(true);
                        }
                    }
                });

                // Create a timer that waits 2.2 seconds then shows the second card
                Timer timer = new Timer(2200, e -> cl.show(cards, "swipeup"));
                timer.setRepeats(false); // Only execute once
                timer.start(); // Start timer
            }
        });
    }
}
/*HAPPY CODING
If you liked it and it helped you drp a star
Every Method is open for all just copy and paste
DM freely on my socials in case you need help
*/