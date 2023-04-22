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
    private JPanel PLANSZA = new JPanel(new GridLayout(ROZMIAR, ROZMIAR));
    JButton[][] guziki;
    private WskaznikWyniku wynik = new WskaznikWyniku();
    public OknoGry() {
        this.setSize(700, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(wynik, BorderLayout.NORTH);
        //wynik.setBounds(0, 0, 200, 30);
        stworzPlansze();
        //PLANSZA.setSize(900, 900);
        PLANSZA.setBounds(0, 30, 600, 600);
        this.add(PLANSZA, BorderLayout.CENTER);
        this.setVisible(true);
        gra = new Gra(ROZMIAR);
        //this.pack();

    }

    private void stworzPlansze() {
        guziki = new JButton[ROZMIAR][ROZMIAR];
        int rozmiarPola = 70;
        int przerwa = 4;
        int x=0;
        int y=50;
        for(int i=0; i<ROZMIAR; i++) {
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
                    System.out.println("Tura: " + gra.czyTura(Plansza.Wlasciciel.GRACZ1));
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
            guziki[x][y].setBackground(Color.RED);
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ2)
            guziki[x][y].setBackground(Color.GREEN);
    }
}
