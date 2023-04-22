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
        if(tura==Plansza.Wlasciciel.GRACZ1)
            tura = Plansza.Wlasciciel.GRACZ2;
        else
            tura = Plansza.Wlasciciel.GRACZ1;
    }
    public int liczPunkty(Plansza.Wlasciciel gracz) {
        //Rows
        int punkty = 0;
        boolean ciag = false;
        for(int i=0; i<ROZMIAR; i++) {
            for(int j=0; j<ROZMIAR-1; j++) {
                if(plansza.pobierzWlasiciela(i, j)==gracz &&
                        plansza.pobierzWlasiciela(i, j+1)==gracz) {
                    ciag = true;
                    punkty++;
                    if(j==5)
                        punkty++;
                }
                else if(ciag) {
                    ciag=false;
                    punkty++;
                }
            }
            ciag=false;
        }
        return punkty;
    }
}
