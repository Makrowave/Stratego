package GUI;

import javax.swing.*;
import java.awt.*;

public class KratkaNumeracja extends JTextField {
    KratkaNumeracja() {

    }
    KratkaNumeracja(String s) {
        this.setText(s);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.setFont(new Font("Helvetica", Font.BOLD, 20));
    }
}
