
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class IntroDuck extends JFrame {
    private JButton Tenant, landLord, Areaguide, Admin;

    IntroDuck() {
        // Setting title and close operation
        setTitle("ROOMMATE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(null);
        getContentPane();
        setLocationRelativeTo(null);
        // setting image
        ImageIcon BG = new ImageIcon("D:\\Project\\ROOMMATE\\front.jpg");
        JLabel BGlabel = new JLabel(BG);
        BGlabel.setBounds(0, 0, getWidth(), getHeight());
        add(BGlabel);
        // Setting buttons
        Tenant = new JButton("Tenant");
        landLord = new JButton("Land Lord");
        Areaguide = new JButton("Area Guide");
        Admin = new JButton("Admin");

        Tenant.setBounds(350, 220, 100, 30);
        landLord.setBounds(350, 270, 100, 30);
        Areaguide.setBounds(350, 320, 100, 30);
        Admin.setBounds(710, -1, 80, 30);

        // adding actionlisteners
        Tenant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
            }
        });
        landLord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
                ;
            }
        });
        Areaguide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(IntroDuck.this, "Frame incoming");
            }
        });
        Admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
            }
        });

        // adding buttons
        BGlabel.add(Tenant);
        BGlabel.add(landLord);
        BGlabel.add(Areaguide);
        BGlabel.add(Admin);
        setVisible(true);
    }
}


