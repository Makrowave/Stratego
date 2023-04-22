package GUI;

import javax.swing.*;
import java.awt.*;

public class WskaznikWyniku extends JPanel {
    JTextField gracz1 = new JTextField();
    JTextField gracz2 = new JTextField();
    WskaznikWyniku() {
        this.setLayout(new BorderLayout());
        this.setSize(100, 50);
        gracz1.setText("GRACZ 1: 0");
        gracz2.setText("GRACZ 2: 0");
        gracz1.setEditable(false);
        gracz2.setEditable(false);
        gracz1.setBounds(0, 0, 60, 30);
        gracz2.setBounds(60, 0, 60, 30);
        this.add(gracz1, BorderLayout.EAST);
        this.add(gracz2, BorderLayout.WEST);
    }

    public void ustawWynik(int gracz, int wynik) {
        if(gracz==1)
            gracz1.setText("GRACZ 1: " + wynik);
        if(gracz==2)
            gracz2.setText("GRACZ 1: " + wynik);
    }
}
