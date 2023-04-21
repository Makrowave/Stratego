package GUI;

import Logic.Gra;
import Logic.Plansza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OknoGry extends JFrame implements ActionListener {

    private int ROZMIAR = 7;
    private Gra gra;
    JButton[][] guziki;
    public OknoGry() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        gra = new Gra(ROZMIAR);
        stworzPlansze();
    }

    private void stworzPlansze() {
        guziki = new JButton[ROZMIAR][ROZMIAR];
        int rozmiarPola = 70;
        int przerwa = 4;
        int x=0;
        int y=0;
        for(int i=0; i<ROZMIAR; i++) {
            for(int j=0; j<ROZMIAR; j++) {
                guziki[i][j] = new JButton();
                guziki[i][j].setBounds(x, y, rozmiarPola, rozmiarPola);
                add(guziki[i][j]);
                guziki[i][j].addActionListener(this);
                guziki[i][j].setBackground(Color.WHITE);
                //System.out.println(guziki[i][j].getWidth() + " " + guziki[i][j].getHeight());
                x+=rozmiarPola+przerwa;
            }
            x=0;
            y+=rozmiarPola+przerwa;
        }
    }
    public void actionPerformed(ActionEvent e) {
        czyTura(e);
    }
    private void czyTura(ActionEvent e) {
        for(int i=0; i<ROZMIAR; i++) {
            for(int j=0; j<ROZMIAR; j++) {
                if(e.getSource()==guziki[i][j]) {
                    wykonajTure(i, j);
                    ustawKolor(i, j);
                    System.out.println("Tura: " + gra.czyTura(Gra.Tura.GRACZ1));
                }
            }
        }
    }
    private void wykonajTure(int x, int y) {
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.NIKT) {
             if(gra.czyTura(Gra.Tura.GRACZ1)) {
                 gra.pobierzPlansze().ustawWlasciciela(Plansza.Wlasciciel.GRACZ1, x, y);
             }
             else {
                 gra.pobierzPlansze().ustawWlasciciela(Plansza.Wlasciciel.GRACZ2, x, y);
             }
            gra.nastepnaTura();
        }
    }
    private void ustawKolor(int x, int y) {
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ1)
            guziki[x][y].setBackground(Color.RED);
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ2)
            guziki[x][y].setBackground(Color.GREEN);
    }
}
