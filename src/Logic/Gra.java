package Logic;

public class Gra {
    private final Plansza plansza;
    private final int ROZMIAR;
    private Plansza.Wlasciciel tura;
    public Gra(int pRozmiar) {
        ROZMIAR = pRozmiar;
        plansza = new Plansza(ROZMIAR);
    }
    public Plansza pobierzPlansze() {
        return plansza;
    }
    public boolean czyTura(Plansza.Wlasciciel gracz) {
        return tura==gracz;
    }
    public void nastepnaTura() {
        liczPunkty(tura);
        if(tura==Plansza.Wlasciciel.GRACZ1)
            tura = Plansza.Wlasciciel.GRACZ2;
        else
            tura = Plansza.Wlasciciel.GRACZ1;
    }
    private void liczPunkty(Plansza.Wlasciciel gracz) {
        //Rows
        short ciag = 0;
        for(int i=0; i<ROZMIAR; i++) {
            for(int j=0; j<ROZMIAR; j++) {
                if(plansza.pobierzWlasiciela(i, j)==gracz)
                    ciag++;
            }
        }
    }
}
