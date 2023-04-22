package Logic;

public class Gra {
    private final Plansza plansza;
    private final int ROZMIAR;
    private Plansza.Wlasciciel tura;
    public Gra(int pRozmiar) {
        ROZMIAR = pRozmiar;
        plansza = new Plansza(ROZMIAR);
        tura= Plansza.Wlasciciel.GRACZ1;
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
        int punkty = 0;
        boolean ciag = false;
        //Poziomo
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
        //Pionowo
        for(int i=0; i<ROZMIAR; i++) {
            for(int j=0; j<ROZMIAR-1; j++) {
                if(plansza.pobierzWlasiciela(j, i)==gracz &&
                        plansza.pobierzWlasiciela(j+1, i)==gracz) {
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
        //Skos / do połowy
        for(int i=1; i<ROZMIAR; i++) {
            for(int j=0; j<i; j++) {
                if(plansza.pobierzWlasiciela(i-j, j)==gracz &&
                plansza.pobierzWlasiciela(i-j-1, j+1)==gracz) {
                    ciag=true;
                    punkty++;
//                    if(i==j+1)
//                        punkty++;
                }
                else if(ciag) {
                    ciag=false;
                    punkty++;
                }
            }
            //jedno dodatkowe wywolanie - jesli skonczy sie skos
            if(ciag) {
                ciag=false;
                punkty++;
            }
        }
        //Skos / od połowy do końca
        //Szuka od końca tablicy do środka bez środkowej przekątnej (jest ona liczona na górze)
        for(int j=ROZMIAR-2; j>0; j--){
           for(int i=ROZMIAR-1; i>j; i--) {
               if(plansza.pobierzWlasiciela(i, j+(ROZMIAR-1-i))==gracz &&
                       plansza.pobierzWlasiciela(i-1, j+1+(ROZMIAR-1-i))==gracz) {
                   ciag=true;
                   punkty++;
               }
               else if(ciag) {
                   ciag=false;
                   punkty++;
               }
           }
           //jedno dodatkowe wywolanie - jesli skonczy sie skos
            if(ciag) {
                ciag=false;
                punkty++;
            }
        }
        //Skos \ od 6,0 do połowy
        for(int i=ROZMIAR-2; i>0; i--) {
            for(int j=0; j<ROZMIAR-1-i ; j++) {
                if(plansza.pobierzWlasiciela(i+j, j)==gracz &&
                        plansza.pobierzWlasiciela(i+j+1, j+1)==gracz) {
                    ciag=true;
                    punkty++;
                }
                else if(ciag) {
                    ciag=false;
                    punkty++;
                }
            }
            if(ciag) {
                ciag=false;
                punkty++;
            }
        }
        for(int j=0; j<ROZMIAR-1; j++) {
            for(int i=0; i<ROZMIAR-1-j; i++) {
                if(plansza.pobierzWlasiciela(i, j+i)==gracz &&
                        plansza.pobierzWlasiciela(i+1, j+i+1)==gracz) {
                    ciag=true;
                    punkty++;
                }
                else if(ciag) {
                    ciag=false;
                    punkty++;
                }
            }
            if(ciag) {
                ciag=false;
                punkty++;
            }
        }
        return punkty;
    }
}
