package GUI;

import Logic.Gra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;

public class Okno extends JFrame implements ActionListener {
    Menu menu;
    OknoGry gra;
    Ustawienia ustawienia;

    public Okno() {
        menu = new Menu(this);
        this.add(menu);
        menu.setVisible(true);
        gra = new OknoGry(this);
        this.add(gra);
        gra.setVisible(false);
        ustawienia = new Ustawienia(this, gra);
        this.add(ustawienia);
        ustawienia.setVisible(false);
        this.setSize(700, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().equals("Graj")) {
            menu.setVisible(false);
            gra.setVisible(true);
        }
        if(e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().equals("Powrót do menu")) {
            gra.setVisible(false);
            menu.setVisible(true);
        }
        if(e.getSource() instanceof JButton && ((JButton)e.getSource()).getText().equals("Ustawienia")) {
            System.out.println("testHEHEHEHEH");
            menu.setVisible(false);
            ustawienia.setVisible(true);

        }
        }

    }

