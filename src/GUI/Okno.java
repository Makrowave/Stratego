package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Okno extends JFrame implements ActionListener {
    Menu menu;
    OknoGry gra;
    Ustawienia ustawienia;

    public Okno() {
        this.setTitle("Stratego");
        //Ikona
        URL URLIkony = getClass().getClassLoader().getResource("resource/Stratego.png");
        if(URLIkony != null) {
            ImageIcon ikona = new ImageIcon(URLIkony);
            this.setIconImage(ikona.getImage());
        }
        menu = new Menu(this);
        gra = new OknoGry(this);
        ustawienia = new Ustawienia(this);
        //Ustawiam wyświetlaną zawartość
        this.setContentPane(menu);
        this.setSize(810, 885);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //Przełączenie między menu, ustawieniami i grą
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().equals("Graj")) {
            this.setContentPane(gra);
            this.revalidate();
            gra.setVisible(true);
        }
        if(e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().equals("Powrót do menu")) {
            this.setContentPane(menu);
            this.revalidate();
            gra.resetujPlansze();
        }
        if(e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().equals("Ustawienia")) {
            this.setContentPane(ustawienia);
            this.revalidate();
        }
    }
    public Ustawienia pobierzUstawienia() {
        return ustawienia;
    }
}

