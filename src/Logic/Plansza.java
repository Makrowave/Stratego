package Logic;


public class Plansza {
    public enum Wlasciciel {
        NIKT, GRACZ1, GRACZ2
    }
    private Wlasciciel[][] PLANSZA;
    private final int ROZMIAR;
    private int pustePola;
    public Plansza(int pSize) {
        this.ROZMIAR = pSize;
        InitializeBoard();
    }
    private void InitializeBoard() {
        PLANSZA = new Wlasciciel[ROZMIAR][ROZMIAR];
        for(int i = 0; i< ROZMIAR; i++) {
            for(int j = 0; j< ROZMIAR; j++) {
                PLANSZA[i][j] = Wlasciciel.NIKT;
            }
        }
        pustePola = ROZMIAR*ROZMIAR;
    }
    public Wlasciciel pobierzWlasiciela(int x, int y) {
        return PLANSZA[x][y];
    }
    public void ustawWlasciciela(Wlasciciel wlasciciel, int x, int y) {
        if(wlasciciel!=Wlasciciel.NIKT)
            pustePola--;
        PLANSZA[x][y] = wlasciciel;
    }
}
