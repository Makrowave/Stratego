package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static GUI.Kolory.ciemnyKolor;
import static GUI.Kolory.kolorGranicy;

public class KratkaNumeracja extends JTextField {
    KratkaNumeracja() {
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setFont(new Font("Helvetica", Font.BOLD, 20));
        this.setBackground(ciemnyKolor);
        this.setBorder(new LineBorder(kolorGranicy, 1));
    }
    KratkaNumeracja(String s) {
        this();
        this.setText(s);
    }
}
