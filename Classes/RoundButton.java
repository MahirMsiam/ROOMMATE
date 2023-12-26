package Classes;

import javax.swing.*;
import java.awt.*;

public class RoundButton extends JButton {
    public RoundButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) { // Checks if the button is currently pressed
            g.setColor(Color.lightGray); // If pressed, sets light gray
        } else {
            g.setColor(getBackground()); // If not pressed, sets button's background color
        }
        // Draws a filled round rectangle representing the button
        g.fillRoundRect(0, 0, getWidth() - 5, getHeight() - 5, 20, 20);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground()); // Sets the color of the border to the button's foreground color
        g.drawRoundRect(0, 0, getWidth() - 5, getHeight() - 5, 20, 20);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 40); // Sets the preferred size of the button
    }
}
/*HAPPY CODING
If you liked it and it helped you drp a star
Every Method is open for all just copy and paste
DM freely on my socials in case you need help
*/