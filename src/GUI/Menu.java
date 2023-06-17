package GUI;

import javax.swing.*;
import javax.swing.JDialog;
import java.awt.*;

public class Menu extends JPanel {
    Okno rodzic;

    Menu(Okno mRodzic) {
        rodzic = mRodzic;
        this.setSize(700, 700);
        this.setLayout(new GridBagLayout());

        JButton button = new JButton("Graj");
        button.addActionListener(rodzic);
        button.setPreferredSize(new Dimension(300, 100));
        button.setBackground(Color.lightGray);

        JButton button2 = new JButton("Ustawienia");
        button2.addActionListener(rodzic);
        button2.setPreferredSize(new Dimension(300, 100));
        button2.setBackground(Color.lightGray);

        JButton button3 = new JButton("Wyjście");



        button3.setPreferredSize(new Dimension(300, 100));
        button3.setBackground(Color.lightGray);
        this.setBackground(Color.cyan);
        button3.addActionListener(e -> System.exit(0));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(button, gbc);

        gbc.gridy = 1;
        this.add(button2, gbc);

        gbc.gridy = 2;
        this.add(button3, gbc);
    }
}
