import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class opening {
    public opening() {
            
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ImageIcon icon = new ImageIcon("Media\\Frmlogo.png");//icon
                // Create the frames (cards)
                JPanel card1 = new JPanel();
                ImageIcon imageIcon1 = new ImageIcon("Media\\Roommate logo.gif");
                JLabel label1 = new JLabel(imageIcon1);
                card1.add(label1);
    
                JPanel card2 = new JPanel();
                ImageIcon imageIcon2 = new ImageIcon("Media\\pg2.jpg");
                JLabel label2 = new JLabel(imageIcon2);
                card2.add(label2);

                // Create the panel that contains the "cards"
                CardLayout cl = new CardLayout();
                JPanel cards = new JPanel(cl);
                cards.add(card1, "Card 1");
                cards.add(card2, "Card 2");

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

                // Create a timer that waits 1.5 seconds then shows the second card
                Timer timer = new Timer(2200, e -> cl.show(cards, "Card 2"));
                timer.setRepeats(false); // Only execute once
                timer.start(); // Start timer
            }
        });
    }
}