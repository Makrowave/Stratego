package GUI;

import Logic.Gra;
import Logic.Plansza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import static GUI.Kolory.*;

public class OknoGry extends JPanel implements ActionListener {
    private final int ROZMIAR = 7;
    private Gra gra;
    private final JPanel PLANSZA = new PanelKwadrat(new GridLayout(ROZMIAR+1, ROZMIAR+1));
    private JButton[][] guziki;
    private final WskaznikWyniku wynik = new WskaznikWyniku();
    private final Okno rodzic;
    public OknoGry(Okno mRodzic) {
        rodzic = mRodzic;
        this.setSize(700, 700);
        this.setLayout(new BorderLayout());
        this.setBackground(kolorTla);


        //Guzik powrot do menu
        JButton powrotZGry = new JButton("Powrót do menu");
        powrotZGry.setBackground(kolorGuzika);
        powrotZGry.addActionListener(rodzic);
        powrotZGry.setPreferredSize(new Dimension(180, 45));
        powrotZGry.setBackground(kolorGuzika);
        powrotZGry.setFont(new Font("Helvetica", Font.BOLD, 16));


        //Guzik reset
        JButton reset = new JButton("Reset");
        reset.setBackground(kolorGuzika);
        reset.addActionListener(this);
        reset.setPreferredSize(new Dimension(80, 45));
        reset.setBackground(kolorGuzika);
        reset.setFont(new Font("Helvetica", Font.BOLD, 16));

        //Dolaczenie do panelu i dolaczenie panelu do panelu z wynikiem
        JPanel przyciskiPanel = new JPanel(new FlowLayout());
        przyciskiPanel.setPreferredSize(new Dimension(700, 50));
        przyciskiPanel.add(powrotZGry);
        przyciskiPanel.add(reset);
        przyciskiPanel.setBackground(kolorTla);
        wynik.add(przyciskiPanel, BorderLayout.CENTER);

        //Faktyczne stworzenie widoku
        stworzPlansze();
        this.add(PLANSZA, BorderLayout.CENTER);
        this.add(wynik, BorderLayout.NORTH);
        gra = new Gra(ROZMIAR);
    }
    //Tworzy fizyczną planszę
    private void stworzPlansze() {
        guziki = new JButton[ROZMIAR][ROZMIAR];
        JTextField[] panelBok = new JTextField[ROZMIAR];
        JTextField[] panelDol = new JTextField[ROZMIAR + 1];
        int rozmiarPola = 70;
        for(int i=0; i<ROZMIAR; i++) {
            panelBok[i] = new KratkaNumeracja(Integer.toString(i+1));
            panelBok[i].setEditable(false);
            panelBok[i].setBackground(ciemnyKolor);
            PLANSZA.add(panelBok[i]);
            for(int j=0; j<ROZMIAR; j++) {
                guziki[i][j] = new JButton();
                guziki[i][j].setPreferredSize(new Dimension(rozmiarPola, rozmiarPola));
                PLANSZA.add(guziki[i][j]);
                guziki[i][j].addActionListener(this);
                guziki[i][j].setBackground(kolorGuzika);
            }
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
        if (e.getSource() instanceof JButton source) {
            //Reset
            if (source.getText().equals("Reset")) {
                resetujPlansze();
            } else {
                //Sprawdza czy źródłem jest którykolwiek guzik z planszy
                for(int i=0; i<ROZMIAR; i++) {
                    for(int j=0; j<ROZMIAR; j++) {
                        if(e.getSource()==guziki[i][j]) {
                            wykonajTure(i, j);
                            ustawKolor(i, j);
                        }
                    }
                }
            }
        }

    }
    private void wykonajTure(int x, int y) {
        //Jeżeli komórka jest pusta
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.NIKT) {
            //Jeżeli tura gracza pierwszego ustaw komórkę i policz wynik
            if(gra.czyTura(Plansza.Wlasciciel.GRACZ1)) {
                gra.pobierzPlansze().ustawWlasciciela(Plansza.Wlasciciel.GRACZ1, x, y);
                wynik.ustawWynik(1, gra.liczPunkty(Plansza.Wlasciciel.GRACZ1));
            }
            //To samo dla gracza 2
            else {
                gra.pobierzPlansze().ustawWlasciciela(Plansza.Wlasciciel.GRACZ2, x, y);
                wynik.ustawWynik(2, gra.liczPunkty(Plansza.Wlasciciel.GRACZ2));
            }
            gra.nastepnaTura();
        }
    }
    private void ustawKolor(int x, int y) {
        if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ1)
            guziki[x][y].setBackground(rodzic.pobierzUstawienia().pobierzKolor(1));
        else if(gra.pobierzPlansze().pobierzWlasiciela(x, y) == Plansza.Wlasciciel.GRACZ2)
            guziki[x][y].setBackground(rodzic.pobierzUstawienia().pobierzKolor(2));
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
        gra.reset();
    }
}
