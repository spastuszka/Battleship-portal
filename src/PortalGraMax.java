import java.util.ArrayList;

public class PortalGraMax {

    //Deklaracja i inicjalizacja niezbędnych zmiennych.

    private PomocnikGry pomocnik = new PomocnikGry();

    /*Utworzenie obiektu ArrayList zawierającego obiekty
    Można w niej zapisywac tylko obiekty typu Portal*/
    private ArrayList<Portal> listaPortali =
            new ArrayList<>();
    private int iloscRuchow = 0;

    private void przygotujGre(){
        //tworzymy portale i określamy ich położenie
        Portal pierwszy = new Portal();
        pierwszy.setNazwa("onet.pl");

        Portal drugi = new Portal();
        drugi.setNazwa("wp.com");

        Portal trzeci = new Portal();
        trzeci.setNazwa("gog.com");

        listaPortali.add(pierwszy);
        listaPortali.add(drugi);
        listaPortali.add(trzeci);

        System.out.println("Twoim celem jest zatopienie " +
                "trzech portali.");
        System.out.println("onet.pl,wp.pl.gog.com");
        System.out.println("Postaraj się je zatopić w jak" +
                " namniejszej ilości ruchów");

        //powtarzanie dla każdego Portalu w tablicy
        for(Portal rozmieszczanyPortal : listaPortali){

            //Poproszenie pomocnika gry o wygenerowanie
            // położenia portalu
            ArrayList<String> nowePolozenie =
                    pomocnik.rozmiescPortal(3);
            rozmieszczanyPortal.setPolaPolozenia(nowePolozenie);
        }
    }

    private void rozpocznijGre(){
        while (!listaPortali.isEmpty()){
            String ruchGracza =
                    pomocnik.pobierzDaneWejsciowe("Podaj " +
                            "pole: ");
            sprawdzRuchGracza(ruchGracza);
        }
        zakonczGre();
    }

    private void sprawdzRuchGracza(String ruch){

        //inkrementacja ilości ruchów wykonanych przez
        // gracza
        iloscRuchow++;

        //Początkowe założenie, że gracz spudłował
        String wynik = "pudło";

        for(Portal portalDoSprawdzenia : listaPortali){

            //Nakazanie Portalowi, by sprawdził ruch i
            // określił, czy został trafony lub zatopiony
            wynik = portalDoSprawdzenia.sprawdz(ruch);

            if(wynik.equals("trafiony")){
                break;
            }

            if(wynik.equals("zatopiony")){
                listaPortali.remove(portalDoSprawdzenia);
                break;
            }
        }
        System.out.println(wynik);
    }

    private void zakonczGre(){
        System.out.println("Wszystkie Portale zostały " +
                "zatopione! Teraz Twoje informacje nie " +
                "mają znaczenia.");
        if(iloscRuchow<=18){
            System.out.println("Wykonałeś jedynie "+iloscRuchow+" ruchów.");
        }else {
            System.out.println("Wykonałeś aż "+iloscRuchow+" ruchów. Popraw się!");
        }
    }

    public static void main(String[] args) {
        PortalGraMax gra = new PortalGraMax();
        gra.przygotujGre();
        gra.rozpocznijGre();
    }
}
