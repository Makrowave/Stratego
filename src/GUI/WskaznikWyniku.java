package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static GUI.Kolory.*;

public class WskaznikWyniku extends JPanel {
    JTextField gracz1 = new JTextField(12);
    JTextField gracz2 = new JTextField(12);
    WskaznikWyniku() {
        this.setBackground(kolorTla);
        this.setLayout(new BorderLayout());
        this.setSize(200, 50);
        gracz1.setText("GRACZ 1: 0");
        gracz2.setText("GRACZ 2: 0");
        gracz1.setEditable(false);
        gracz2.setEditable(false);
        gracz1.setPreferredSize(new Dimension(50, 25));
        gracz2.setPreferredSize(new Dimension(50, 25));
        gracz1.setBackground(kolorGuzika);
        gracz2.setBackground(kolorGuzika);
        gracz1.setBorder(new LineBorder(kolorGranicy, 1));
        gracz2.setBorder(new LineBorder(kolorGranicy, 1));
        gracz1.setFont(new Font("Helvetica", Font.BOLD, 16));
        gracz2.setFont(new Font("Helvetica", Font.BOLD, 16));
        gracz1.setHorizontalAlignment(JTextField.CENTER);
        gracz2.setHorizontalAlignment(JTextField.CENTER);
        this.add(gracz1, BorderLayout.WEST);
        this.add(gracz2, BorderLayout.EAST);
    }

    public void ustawWynik(int gracz, int wynik) {
        if(gracz==1)
            gracz1.setText("GRACZ 1: " + wynik);
        if(gracz==2)
            gracz2.setText("GRACZ 2: " + wynik);
    }
}
