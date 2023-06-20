package GUI;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

public class WyborKoloru extends JPanel implements DocumentListener {
    private final JPanel widokKolor;
    private final Ustawienia rodzic;
    private final Color podstawowyKolor;
    private final int gracz;
    public WyborKoloru(String gracz, Color mPodstawowyKolor, Ustawienia mRodzic) {
        this.gracz = Integer.parseInt(gracz.substring(6));
        podstawowyKolor = mPodstawowyKolor;
        rodzic = mRodzic;
        //Tekst wyświetlany na ekranie (Gracz 1/Gracz 2)
        JLabel tekstGracz = new JLabel(gracz);
        tekstGracz.setAlignmentX(Component.CENTER_ALIGNMENT);
        tekstGracz.setPreferredSize(new Dimension(50, 50));
        tekstGracz.setSize(new Dimension(50, 130));

        //Kwadrat wyświetlający kolor
        widokKolor = new JPanel();
        widokKolor.setBackground(podstawowyKolor);
        widokKolor.setAlignmentX(Component.CENTER_ALIGNMENT);
        widokKolor.setPreferredSize(new Dimension(100, 100));

        //Pole tekstowe do wpisania liczby heksadecymalnej
        JTextField poleKolor = new JTextField(7);
        poleKolor.setText(kolorNaSzestnastkowy(podstawowyKolor));
        poleKolor.setAlignmentX(Component.CENTER_ALIGNMENT);
        poleKolor.setPreferredSize(new Dimension(50, 20));
        poleKolor.getDocument().addDocumentListener(this);

        //Dodanie do panelu i ustawienie layoutu
        this.setLayout(new BorderLayout());
        this.add(tekstGracz, BorderLayout.NORTH);
        this.add(widokKolor, BorderLayout.CENTER);
        this.add(poleKolor, BorderLayout.SOUTH);
    }
    private String kolorNaSzestnastkowy(Color kolor) {
        return String.format("#%02x%02x%02x", kolor.getRed(), kolor.getGreen(), kolor.getBlue());
    }
    private Color szestnaskowyNaKolor(String s, Color podstawowyKolor) {
        String hex;
        int liczba;
        if(s.length() == 7) {
            hex = s.substring(1);
            try {
                System.out.println("Zwracam kolor");
                return new Color(Integer.parseInt(hex, 16));
            } catch (NumberFormatException e) {
                System.out.println("tutaj blad");
                return podstawowyKolor;
            }
        } else {
            System.out.println("albo tutaj blad");
            return podstawowyKolor;
        }
    }
    private void ustawKolor(DocumentEvent e) {
        if(e.getDocument().getLength() == 7) {
            try {
                Color kolor = szestnaskowyNaKolor(e.getDocument().getText(0, 7), podstawowyKolor);
                rodzic.ustawKolor(kolor, gracz);
                widokKolor.setBackground(kolor);
            } catch (BadLocationException ex) {
                System.out.println("Blad");
                throw new RuntimeException(ex);
            }
        }
    }
    //Metody sprawdzające aktualizację pola tekstowego (z interfejsu DocumentListener)
    @Override
    public void insertUpdate(DocumentEvent e) {
        ustawKolor(e);
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        ustawKolor(e);
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        ustawKolor(e);
    }

}
