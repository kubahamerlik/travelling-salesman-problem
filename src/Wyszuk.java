public class Wyszuk {
    public static int wyszukaj_indeks(String miasto, String[] miasta, int n){

        for(int i = 0; i < n; i++){
            if(miasto.equals(miasta[i])){
                return i;
            }
        }

        return 2*n;
    }

    public static void uzupelnij_tab(int miastoz, int miastodo, int odleglosc, int[][] tab){
        tab[miastoz][miastodo] = odleglosc;
        tab[miastodo][miastoz] = odleglosc;
    }

    public static void tablica(){

    }
}
