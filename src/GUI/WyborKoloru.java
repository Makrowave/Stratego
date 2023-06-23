package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;

import static GUI.Kolory.*;

public class WyborKoloru extends JPanel implements DocumentListener {
    private final JPanel widokKolor;
    private final Ustawienia rodzic;
    private final int gracz;
    public WyborKoloru(String gracz, Color mPodstawowyKolor, Ustawienia mRodzic) {
        this.setBackground(kolorTla);
        this.gracz = Integer.parseInt(gracz.substring(6));
        rodzic = mRodzic;
        //Tekst wyświetlany na ekranie (Gracz 1/Gracz 2)
        JLabel tekstGracz = new JLabel(gracz);
        tekstGracz.setFont(new Font("Helvetica", Font.BOLD, 16));
        tekstGracz.setAlignmentX(Component.CENTER_ALIGNMENT);
        tekstGracz.setHorizontalAlignment(JTextField.CENTER);
        tekstGracz.setBorder(new LineBorder(kolorGranicy, 1));
        tekstGracz.setOpaque(true);
        tekstGracz.setBackground(kolorGuzika);
        tekstGracz.setPreferredSize(new Dimension(50, 50));
        tekstGracz.setSize(new Dimension(50, 130));

        //Kwadrat wyświetlający kolor
        widokKolor = new JPanel();
        widokKolor.setBackground(mPodstawowyKolor);
        widokKolor.setAlignmentX(Component.CENTER_ALIGNMENT);
        widokKolor.setPreferredSize(new Dimension(200, 200));

        //Pole tekstowe do wpisania liczby heksadecymalnej
        JTextField poleKolor = new JTextField(7);
        poleKolor.setFont(new Font("Helvetica", Font.PLAIN, 14));
        poleKolor.setText(kolorNaSzestnastkowy(mPodstawowyKolor));
        poleKolor.setAlignmentX(Component.CENTER_ALIGNMENT);
        poleKolor.setPreferredSize(new Dimension(50, 30));
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

    private void ustawKolor(DocumentEvent e) {
        if(e.getDocument().getLength() == 7) {
            try {
                Color kolor = Color.decode(e.getDocument().getText(0, 7));
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
