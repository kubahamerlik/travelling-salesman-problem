import java.io.*;
import java.util.*;

public class TSE {


    static int n = 16;

    static int[][] dist = new int[n][n];
    static int MAX = 10000000;

    static int[][] memo = new int[n + 1][1 << (n + 1)];

    static int fun(int i, int mask)
    {
        if (mask == ((1 << i) | 3))
            return dist[1][i];
        // memoization
        if (memo[i][mask] != 0)
            return memo[i][mask];

        int res = MAX;


        for (int j = 1; j <= n; j++)
            if ((mask & (1 << j)) != 0 && j != i && j != 1)
                res = Math.min(res,
                        fun(j, mask & (~(1 << i))) + dist[j][i]);
        return memo[i][mask] = res;
    }

    public static void main(String[] args)
    {

        String[][] trojki = {
                {"Białystok", "Olsztyn", "210"},
                {"Białystok", "Warszawa", "132"},
                {"Białystok", "Lublin", "226"},
                {"Białystok", "Bydgoszcz", "306"},
                {"Białystok", "Gdańsk", "289"},
                {"Białystok", "Łódź", "209"},
                {"Białystok", "Poznań", "306"},
                {"Białystok", "Szczecin", "448"},
                {"Białystok", "GorzówWielkopolski", "391"},
                {"Białystok", "Wrocław", "333"},
                {"Białystok", "Opole", "343"},
                {"Białystok", "Katowice", "309"},
                {"Białystok", "Kielce", "247"},
                {"Białystok", "Kraków", "327"},
                {"Białystok", "Rzeszów", "320"},
                {"Olsztyn", "Warszawa", "161"},
                {"Olsztyn", "Lublin", "263"},
                {"Olsztyn", "Bydgoszcz", "187"},
                {"Olsztyn", "Gdańsk", "114"},
                {"Olsztyn", "Łódź", "211"},
                {"Olsztyn", "Poznań", "268"},
                {"Olsztyn", "Szczecin", "367"},
                {"Olsztyn", "GorzówWielkopolski", "353"},
                {"Olsztyn", "Wrocław", "335"},
                {"Olsztyn", "Opole", "350"},
                {"Olsztyn", "Katowice", "316"},
                {"Olsztyn", "Kielce", "273"},
                {"Olsztyn", "Kraków", "353"},
                {"Olsztyn", "Rzeszów", "355"},
                {"Warszawa", "Lublin", "118"},
                {"Warszawa", "Bydgoszcz", "200"},
                {"Warszawa", "Gdańsk", "229"},
                {"Warszawa", "Łódź", "104"},
                {"Warszawa", "Poznań", "198"},
                {"Warszawa", "Szczecin", "340"},
                {"Warszawa", "GorzówWielkopolski", "283"},
                {"Warszawa", "Wrocław", "225"},
                {"Warszawa", "Opole", "228"},
                {"Warszawa", "Katowice", "193"},
                {"Warszawa", "Kielce", "128"},
                {"Warszawa", "Kraków", "209"},
                {"Warszawa", "Rzeszów", "207"},
                {"Lublin", "Bydgoszcz", "286"},
                {"Lublin", "Gdańsk", "341"},
                {"Lublin", "Łódź", "189"},
                {"Lublin", "Poznań", "287"},
                {"Lublin", "Szczecin", "429"},
                {"Lublin", "GorzówWielkopolski", "372"},
                {"Lublin", "Wrocław", "314"},
                {"Lublin", "Opole", "319"},
                {"Lublin", "Katowice", "248"},
                {"Lublin", "Kielce", "148"},
                {"Lublin", "Kraków", "211"},
                {"Lublin", "Rzeszów", "114"},
                {"Bydgoszcz", "Gdańsk", "116"},
                {"Bydgoszcz", "Łódź", "155"},
                {"Bydgoszcz", "Poznań", "97"},
                {"Bydgoszcz", "Szczecin", "219"},
                {"Bydgoszcz", "GorzówWielkopolski", "183"},
                {"Bydgoszcz", "Wrocław", "197"},
                {"Bydgoszcz", "Opole", "254"},
                {"Bydgoszcz", "Katowice", "258"},
                {"Bydgoszcz", "Kielce", "262"},
                {"Bydgoszcz", "Kraków", "312"},
                {"Bydgoszcz", "Rzeszów", "380"},
                {"Gdańsk", "Łódź", "206"},
                {"Gdańsk", "Poznań", "197"},
                {"Gdańsk", "Szczecin", "262"},
                {"Gdańsk", "GorzówWielkopolski", "281"},
                {"Gdańsk", "Wrocław", "295"},
                {"Gdańsk", "Opole", "345"},
                {"Gdańsk", "Katowice", "311"},
                {"Gdańsk", "Kielce", "314"},
                {"Gdańsk", "Kraków", "365"},
                {"Gdańsk", "Rzeszów", "422"},
                {"Łódź", "Poznań", "143"},
                {"Łódź", "Szczecin", "282"},
                {"Łódź", "GorzówWielkopolski", "226"},
                {"Łódź", "Wrocław", "145"},
                {"Łódź", "Opole", "167"},
                {"Łódź", "Katowice", "137"},
                {"Łódź", "Kielce", "139"},
                {"Łódź", "Kraków", "193"},
                {"Łódź", "Rzeszów", "274"},
                {"Poznań", "Szczecin", "168"},
                {"Poznań", "GorzówWielkopolski", "109"},
                {"Poznań", "Wrocław", "127"},
                {"Poznań", "Opole", "182"},
                {"Poznań", "Katowice", "232"},
                {"Poznań", "Kielce", "260"},
                {"Poznań", "Kraków", "286"},
                {"Poznań", "Rzeszów", "368"},
                {"Szczecin", "GorzówWielkopolski", "73"},
                {"Szczecin", "Wrocław", "247"},
                {"Szczecin", "Opole", "289"},
                {"Szczecin", "Katowice", "337"},
                {"Szczecin", "Kielce", "402"},
                {"Szczecin", "Kraków", "391"},
                {"Szczecin", "Rzeszów", "473"},
                {"GorzówWielkopolski", "Wrocław", "187"},
                {"GorzówWielkopolski", "Opole", "229"},
                {"GorzówWielkopolski", "Katowice", "278"},
                {"GorzówWielkopolski", "Kielce", "342"},
                {"GorzówWielkopolski", "Kraków", "332"},
                {"GorzówWielkopolski", "Rzeszów", "414"},
                {"Wrocław", "Opole", "81"},
                {"Wrocław", "Katowice", "129"},
                {"Wrocław", "Kielce", "252"},
                {"Wrocław", "Kraków", "183"},
                {"Wrocław", "Rzeszów", "265"},
                {"Opole", "Katowice", "83"},
                {"Opole", "Kielce", "210"},
                {"Opole", "Kraków", "138"},
                {"Opole", "Rzeszów", "220"},
                {"Katowice", "Kielce", "132"},
                {"Katowice", "Kraków", "67"},
                {"Katowice", "Rzeszów", "148"},
                {"Kielce", "Kraków", "100"},
                {"Kielce", "Rzeszów", "145"},
                {"Kraków", "Rzeszów", "112"}};


        //String start = "Warszawa";
        //System.out.println(start);

        String[] miast = {"Białystok", "Bydgoszcz", "Gdańsk", "GorzówWielkopolski",
                "Katowice", "Kielce", "Kraków", "Lublin",
                "Łódź", "Olsztyn", "Opole", "Poznań",
                "Rzeszów", "Szczecin", "Warszawa", "Wrocław"};

        Wyszuk wyszukaj = new Wyszuk();
        int miastoz, miastodo, odleglosc;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dist[i][j] = 0;
            }
        }

        for(int i = 0; i < 120; i++) {
            miastoz = Wyszuk.wyszukaj_indeks(trojki[i][0], miast, n);
            miastodo = Wyszuk.wyszukaj_indeks(trojki[i][1], miast, n);
            odleglosc = Integer.parseInt(trojki[i][2]);
            Wyszuk.uzupelnij_tab(miastoz, miastodo, odleglosc, dist);
            //System.out.println("miasto początkowe: " + miastoz + " Miasto do: " + miastodo + " Odległość: " + odleglosc);
        }

        int[][] temp = new int[n+1][n+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                temp[i][j] = 0;
            }
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                temp[i][j] = dist[i-1][j-1];
            }
        }

//        for(int i = 0; i < n + 1; i++){
//            for(int j = 0; j < n + 1; j++){
//                System.out.print(temp[i][j] + " ");
//            }
//            System.out.println();
//        }

        dist = temp;




        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        int ans = MAX;
        for (int i = 1; i <= n; i++)

            ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1) + dist[i][1]);

        System.out.println(
                "The cost of most efficient tour = " + ans);
    }
}

