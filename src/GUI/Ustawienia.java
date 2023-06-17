package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class Ustawienia extends JDialog {
    private OknoGry oknoGry;
    Okno rodzic;
    private JButton przyciskGracz1;
    private JButton przyciskGracz2;


    public Ustawienia(Okno mRodzic, OknoGry oknoGry) {
        rodzic = mRodzic;
        this.oknoGry = oknoGry;
        this.setSize(300, 150);
        this.setLayout(new GridLayout(3, 2));

        JLabel etykietaGracz1 = new JLabel("Gracz 1");
        przyciskGracz1 = new JButton("Wybierz kolor");
        przyciskGracz1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color kolor = JColorChooser.showDialog(Ustawienia.this, "Wybierz kolor", oknoGry.getKolor(1));
                if (kolor != null) {
                    oknoGry.ustawKolorGracza1(kolor);
                    przyciskGracz1.setBackground(kolor);
                }
            }
        });

        JLabel etykietaGracz2 = new JLabel("Gracz 2");
        przyciskGracz2 = new JButton("Wybierz kolor");
        przyciskGracz2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color kolor = JColorChooser.showDialog(Ustawienia.this, "Wybierz kolor", oknoGry.getKolor(2));
                if (kolor != null) {
                    oknoGry.ustawKolorGracza2(kolor);
                    przyciskGracz2.setBackground(kolor);
                }
            }
        });

        JButton przyciskPowrotu = new JButton("Powrót do menu");
        przyciskPowrotu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ustawienia.this.setVisible(false);
                oknoGry.setVisible(false);
                rodzic.setVisible(true);
            }
        });

        this.add(etykietaGracz1);
        this.add(przyciskGracz1);
        this.add(etykietaGracz2);
        this.add(przyciskGracz2);
        this.add(przyciskPowrotu);
    }

}
