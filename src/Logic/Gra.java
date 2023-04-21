package Logic;

public class Gra {
    public enum Tura {
        GRACZ1, GRACZ2
    }
    private final Plansza plansza;
    private final int ROZMIAR;
    private Tura tura;
    public Gra(int pRozmiar) {
        ROZMIAR = pRozmiar;
        plansza = new Plansza(ROZMIAR);
    }
    public Plansza pobierzPlansze() {
        return plansza;
    }
    public boolean czyTura(Tura gracz) {
        return tura==gracz;
    }
    public void nastepnaTura() {
        if(tura==Tura.GRACZ1)
            tura = Tura.GRACZ2;
        else
            tura = Tura.GRACZ1;
    }
}
