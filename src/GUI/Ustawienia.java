package GUI;

import javax.swing.*;
import java.awt.*;

public class Ustawienia extends JPanel {
    private final Okno rodzic;
    private Color kolorGracz1 = Color.RED;
    private Color kolorGracz2 = Color.BLUE;


    public Ustawienia(Okno mRodzic, OknoGry oknoGry) {
        rodzic = mRodzic;
        this.setSize(300, 150);
        this.setLayout(new BorderLayout());

        JLabel etykietaGracz1 = new JLabel("Gracz 1");
        //Panel menu
        JPanel menuPanel = new JPanel();
        JButton przyciskPowrotu = new JButton("Powrót do menu");
        przyciskPowrotu.setBackground(Color.WHITE);
        menuPanel.add(przyciskPowrotu);
        przyciskPowrotu.addActionListener(rodzic);
        JPanel wybory = new JPanel();
        wybory.add(new WyborKoloru("Gracz 1", Color.RED, this));
        wybory.add(new WyborKoloru("Gracz 2", Color.BLUE, this));
        this.add(wybory, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.CENTER);
    }
    public Color pobierzKolor(int gracz) {
        if(gracz==1)
            return kolorGracz1;
        if(gracz==2)
            return kolorGracz2;

        return Color.WHITE;
    }
    public void ustawKolor(Color kolor, int gracz) {
        if(gracz==1)
            kolorGracz1 = kolor;
        if(gracz==2)
            kolorGracz2 = kolor;
    }
}
