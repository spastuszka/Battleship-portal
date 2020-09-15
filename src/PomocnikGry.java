import java.io.*;
import java.util.*;

public class PomocnikGry {
    private static final String alfabet = "abcdefg";
    private int dlugoscPlanszy = 7;
    private int wielkoscPlanszy = 49;
    private int [] plansza = new int[wielkoscPlanszy];
    private int iloscPortali = 0;

    public String pobierzDaneWejsciowe(String komunikat){
        String daneWejsciowe = null;
        System.out.println(komunikat+" ");
        try {
            BufferedReader is =
                    new BufferedReader(new InputStreamReader(System.in));
            daneWejsciowe = is.readLine();
            if(daneWejsciowe.length() == 0) return null;
        }catch (IOException e){
            System.out.println("IOException: "+e);
        }
        return  daneWejsciowe.toLowerCase();
    }

    public ArrayList rozmiescPortal(int wielkoscPortalu){
        ArrayList<String> zajetePola = new ArrayList<>();

        //Współrzędne zapisane jako 'f6'
        String [] wspolrzedneLnc =
                new String[wielkoscPortalu];

        //pomocniczy łańcuch

        String pomoc = null;

        //bieżące proponowane współrzędne
        int [] wspolrzedne = new int[wielkoscPortalu];

        //licznik ilości prób
        int prob = 0;

        //flaga ktora daje info czy znaleziono dobre miejsce

        boolean powodzenie = false;

        //bieżące miejsce początkowe
        int polozenie = 0;

        //n-ty portal do rozmieszczenia

        iloscPortali++;

        //przyrost w poziomie

        int inkr = 1;

        //jeśli portal nieparzysty, to umieszczany jest w
        // pionie
        if((iloscPortali % 2) == 1){
            inkr = dlugoscPlanszy;
        }

        //główna pętla poszukiwania
        while (!powodzenie & prob++ <200){

            //wybor losowego punktu początkowego
            polozenie =
                    (int)(Math.random() * wielkoscPlanszy);

            int x = 0;

            //zakładamy, że się udało
            powodzenie = true;

            //szukamy sąsiadujących pustych pól planszy

            while (powodzenie && x < wielkoscPortalu){

                //jeśli jeszcze nie zajęte
                if(plansza[polozenie] == 0){

                    //zapisujemy miejsce
                    wspolrzedne[x++] = polozenie;

                    //sprawdzamy nastepne sasaidujace pole
                    polozenie += inkr;

                    //sprawdzamy czy nie wyjdzie poza zakres
                    if(polozenie >= wielkoscPlanszy){
                        powodzenie = false;
                    }
                }else {
                    powodzenie = false;
                }
            }
        }

        int x = 0;
        int wiersz = 0;
        int kolumna = 0;

        while (x<wielkoscPortalu){
            plansza[wspolrzedne[x]] = 1;
            wiersz =
                    (int) (wspolrzedne[x] / dlugoscPlanszy);

            //pobranie liczby określającej kolumnę
            kolumna = wspolrzedne[x] % dlugoscPlanszy;

            //konwersja to postaci alfanumerycznej

            pomoc = String.valueOf(alfabet.charAt(kolumna));

            zajetePola.add(pomoc.concat(Integer.toString(wiersz)));
            x++;
        }
        return zajetePola;
    }
}
