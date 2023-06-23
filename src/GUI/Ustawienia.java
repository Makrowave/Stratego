package GUI;

import javax.swing.*;
import java.awt.*;

import static GUI.Kolory.kolorGuzika;
import static GUI.Kolory.kolorTla;

public class Ustawienia extends JPanel {
    private Color kolorGracz1 = Color.RED;
    private Color kolorGracz2 = Color.BLUE;

    public Ustawienia(Okno mRodzic) {
        this.setBackground(kolorTla);
        this.setLayout(new BorderLayout());

        //Panel menu
        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(kolorTla);
        //Powrot
        JButton przyciskPowrotu = new JButton("Powrót do menu");
        przyciskPowrotu.setBackground(kolorGuzika);
        przyciskPowrotu.setPreferredSize(new Dimension(200, 50));
        przyciskPowrotu.setFont(new Font("Helvetica", Font.BOLD, 16));
        menuPanel.add(przyciskPowrotu);
        przyciskPowrotu.addActionListener(mRodzic);
        //Wybory koloru
        JPanel wybory = new JPanel();
        wybory.setBackground(kolorTla);
        wybory.add(new WyborKoloru("Gracz 1", kolorGracz1, this));
        wybory.add(new WyborKoloru("Gracz 2", kolorGracz2, this));
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
