package GUI;

import Logic.Gra;
import Logic.Plansza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JDialog;

public class OknoGry extends JPanel implements ActionListener {
    private int ROZMIAR = 7;
    private Gra gra;
    private JPanel PLANSZA = new JPanel(new GridLayout(ROZMIAR+1, ROZMIAR+1));
    private JTextField[] panelBok;
    private JTextField[] panelDol;
    private JButton[][] guziki;
    private WskaznikWyniku wynik = new WskaznikWyniku();
    private Okno rodzic;
    private Color kolorGracza1 = Color.BLUE;
    private Color kolorGracza2 = Color.RED;
    private Color[] koloryGraczy = {Color.BLUE, Color.RED};
    public OknoGry(Okno mRodzic) {
        this.setSize(700, 700);
        this.setLayout(new BorderLayout());

        JPanel przyciskiPanel = new JPanel(new FlowLayout()); // Panel dla przycisków
        przyciskiPanel.setPreferredSize(new Dimension(700, 50));

        JButton powrotZGry = new JButton("Powrót do menu");
        rodzic = mRodzic;
        powrotZGry.addActionListener(rodzic);
        powrotZGry.setPreferredSize(new Dimension(150, 30));

        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setPreferredSize(new Dimension(80, 30));

        przyciskiPanel.add(powrotZGry);
        przyciskiPanel.add(reset);

        rodzic = mRodzic;
        this.add(przyciskiPanel, BorderLayout.WEST);
        this.add(wynik, BorderLayout.NORTH);
        stworzPlansze();
        PLANSZA.setPreferredSize(new Dimension(700, 600));
        this.add(PLANSZA, BorderLayout.SOUTH);
        gra = new Gra(ROZMIAR);
    }
    public Color getKolor(int numerGracza) {
        if (numerGracza >= 1 && numerGracza <= 2) {
            return koloryGraczy[numerGracza - 1];
        }
        return null;
    }
    private void stworzPlansze() {
        guziki = new JButton[ROZMIAR][ROZMIAR];
        panelBok = new JTextField[ROZMIAR];
        panelDol = new JTextField[ROZMIAR+1];
        int rozmiarPola = 70;
        int przerwa = 4;
        int x=0;
        int y=50;
        for(int i=0; i<ROZMIAR; i++) {
            panelBok[i] = new KratkaNumeracja(Integer.toString(i+1));
            panelBok[i].setEditable(false);
            PLANSZA.add(panelBok[i]);
            for(int j=0; j<ROZMIAR; j++) {
                guziki[i][j] = new JButton();
                guziki[i][j].setBounds(x, y, rozmiarPola, rozmiarPola);
                PLANSZA.add(guziki[i][j]);
                guziki[i][j].addActionListener(this);
                guziki[i][j].setBackground(Color.WHITE);
                x+=rozmiarPola+przerwa;
            }
            x=0;
            y+=rozmiarPola+przerwa;
        }
        panelDol[0] = new KratkaNumeracja();
        panelDol[0].setEditable(false);
        PLANSZA.add(panelDol[0]);
        for(int i=1; i<ROZMIAR+1; i++) {
            panelDol[i] = new KratkaNumeracja(Character.toString(i+64));
            panelDol[i].setEditable(false);
            PLANSZA.add(panelDol[i]);
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton source = (JButton) e.getSource();
            if (source.getText().equals("Reset")) {
                resetujPlansze();
            } else {
                czyTura(e);
            }
        }

    }


    private void czyTura(ActionEvent e) {
        for(int i=0; i<ROZMIAR; i++) {
            for(int j=0; j<ROZMIAR; j++) {
                if(e.getSource()==guziki[i][j]) {
                    wykonajTure(i, j);
                    ustawKolor(i, j);
                    //System.out.println("Tura: " + gra.czyTura(Plansza.Wlasciciel.GRACZ1));
                }
            }
        }
    }
    private void wykonajTure(int x, int y) {
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.NIKT) {
            if(gra.czyTura(Plansza.Wlasciciel.GRACZ1)) {
                gra.pobierzPlansze().ustawWlasciciela(Plansza.Wlasciciel.GRACZ1, x, y);
                wynik.ustawWynik(1, gra.liczPunkty(Plansza.Wlasciciel.GRACZ1));
            }
            else {
                gra.pobierzPlansze().ustawWlasciciela(Plansza.Wlasciciel.GRACZ2, x, y);
                wynik.ustawWynik(2, gra.liczPunkty(Plansza.Wlasciciel.GRACZ2));
            }
            gra.nastepnaTura();
        }
    }
    private void ustawKolor(int x, int y) {
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ1)
            guziki[x][y].setBackground(kolorGracza1);
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ2)
            guziki[x][y].setBackground(kolorGracza2);
    }


    public void resetujPlansze() {
        gra = new Gra(ROZMIAR);
        wynik.ustawWynik(1, 0);
        wynik.ustawWynik(2, 0);

        for (int i = 0; i < ROZMIAR; i++) {
            for (int j = 0; j < ROZMIAR; j++) {
                guziki[i][j].setBackground(Color.WHITE);
            }
        }
    }
    public void ustawKolorGracza1(Color kolor) {
        kolorGracza1 = kolor;
    }

    public void ustawKolorGracza2(Color kolor) {
        kolorGracza2 = kolor;
    }
}
