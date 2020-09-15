import java.util.ArrayList;

public class Portal {

    //Składowe obiektu Portal
    /*obiekt ArrayList zawiera pola zajmowane przez ten
    Portal*/
    //- nazwa Portalu
    private ArrayList<String> polaPolozenia;
    private String nazwa;

    /*Metoda dziękie której zapisujemy położenie Portalu
    (Położenie losowo generowane przez metodę
    rozmiescPortal() w PomocnikGry)*/
    public void setPolaPolozenia(ArrayList<String> ppol){
        polaPolozenia = ppol;
    }

    //Metoda ustanawiająca nazwę Portalu<
    public void setNazwa(String nazwaPortalu){
        this.nazwa = nazwaPortalu;
    }


    public String sprawdz(String ruch){

        String wynik = "pudło";

        /*Wykorzystanie metody ArrayList.indexOf();
        * Jeśli pole wskazane przez gracza jest jednym z
        * pól zapisanych w tablicy, to metoda zwórcu jego
        *  index
        * Inaczej będzie zwracać -1*/
        int indeks = polaPolozenia.indexOf(ruch);

        if(indeks >=0){

            //Usunięcie elementu z tablicy
            polaPolozenia.remove(indeks);

            //Sprawdzenie za pomocą metody isEmpty() czy
            // wszystkie pola zajmowane przez Portal
            // zostały już trafione
            if(polaPolozenia.isEmpty()){
                wynik = "zatopiony";
                //Info o zatopieniu
                System.out.println("Auć Zatopiłeś portal "+nazwa+" : (");
            }else{
                wynik = "trafiony";
            }
        }
        //Zwracamy wynik: pudło, trafony lub zatopiony
        return wynik;
    }
}
