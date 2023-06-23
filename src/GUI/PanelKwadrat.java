package GUI;

import javax.swing.*;
import java.awt.*;

public class PanelKwadrat extends JPanel {
    public PanelKwadrat(LayoutManager layout) {
        super(layout);
    }
    //To przesłonięcie ma na celu zapewnienie, że plansza będzie kwadratem
    @Override
    public void setBounds(int x, int y, int width, int height) {
        int bok = Math.max(width, height);

        //Upewnienie się, że plansza nie wyjdzie poza granice okienka aplikacji
        int bok_rodzica = getParent().getWidth();
        if(bok > bok_rodzica) bok = bok_rodzica;
        bok_rodzica = getParent().getHeight() - 50; //60 to "bardzo prowizoryczne przesunięcie", ta wartość generalnie reprezentuje wysokość menu z wynikiem i guzikami
        if(bok > bok_rodzica) bok = bok_rodzica;

        super.setBounds(x, y, bok, bok);
    }
}
