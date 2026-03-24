import java.util.Scanner;

public class Jugador {
    private String nom;
    private Taulell taulellPropi;
    private Entrades entrada;

    public Jugador(String nom, int mida, Entrades entrada){
        this.nom = nom;
        this.taulellPropi = new Taulell(mida);
        this.entrada = entrada;
    }

    public String getNom(){
        return nom;
    }

    public void posicionarFlota(Vaixell[] vaixellsAPosicionar) {
        System.out.println("Comandant " + this.nom + ", prepara la teva flota!");

        for(Vaixell v: vaixellsAPosicionar){
            boolean colocat= false;

            while(!colocat){
                int x = entrada.obtenirCoordenada("Introdueix la coordenada x: ");
                int y = entrada.obtenirCoordenada("Introdueix la coordenada y: ");
                Orientacio orientacio = entrada.obtenirOrientacio();

                colocat = this.taulellPropi.colLocarVaixell(v, x, y, orientacio);
            }
        }
    }

    public void escollirObjectiu(Casella[][] casellaADisparar){
        System.out.println("Comandant "+ this.nom + ", on vols disparar?");
        boolean disparValid = false;

        while(!disparValid) {
            int x = entrada.obtenirCoordenada("Introdueix la coordenada x on vols disparar: ");
            int y = entrada.obtenirCoordenada("Introdueix la coordenada y on vols disparar: ");

            disparValid = casellaADisparar[x][y].rebreTret();
        }

    }

}
