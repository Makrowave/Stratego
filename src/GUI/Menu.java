package GUI;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    Okno rodzic;

    Menu(Okno mRodzic) {
        rodzic = mRodzic;
        this.setSize(700, 700);
        this.setLayout(new GridBagLayout());

        //Przycisk graj
        JButton przyciskGraj = new JButton("Graj");
        przyciskGraj.addActionListener(rodzic);
        przyciskGraj.setPreferredSize(new Dimension(300, 100));
        przyciskGraj.setBackground(Color.lightGray);

        //Przycisk ustawienia
        JButton przyciskUstawienia = new JButton("Ustawienia");
        przyciskUstawienia.addActionListener(rodzic);
        przyciskUstawienia.setPreferredSize(new Dimension(300, 100));
        przyciskUstawienia.setBackground(Color.lightGray);

        //Przycisk wyjscie
        JButton przyciskWyjscie = new JButton("Wyjście");
        przyciskWyjscie.setPreferredSize(new Dimension(300, 100));
        przyciskWyjscie.setBackground(Color.lightGray);
        przyciskWyjscie.addActionListener(e -> System.exit(0));

        this.setBackground(Color.cyan);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(przyciskGraj, gbc);

        gbc.gridy = 1;
        this.add(przyciskUstawienia, gbc);

        gbc.gridy = 2;
        this.add(przyciskWyjscie, gbc);
    }
}
