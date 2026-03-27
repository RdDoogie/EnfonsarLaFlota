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

    public Taulell getTaulellPropi(){
        return taulellPropi;
    }


    public void posicionarFlota(Vaixell[] vaixellsAPosicionar) {

        for(int i = 0; i < vaixellsAPosicionar.length; i++) {
            Vaixell v = vaixellsAPosicionar[i];
            boolean colocat = false;

            while(!colocat) {
                this.taulellPropi.mostrarTaulell(false);

                System.out.println("Vaixells pendents de col·locar:");
                for (int j = i; j < vaixellsAPosicionar.length; j++) {
                    System.out.println("Vaixell de mida: " + vaixellsAPosicionar[j].getMida());
                }

                System.out.println("Col·locant el vaixell de mida " + v.getMida() + " ---");

                int x = entrada.obtenirCoordenada("Introdueix la coordenada fila (x): ");
                int y = entrada.obtenirCoordenada("Introdueix la coordenada columna (y): ");
                Orientacio orientacio = entrada.obtenirOrientacio();

                colocat = this.taulellPropi.colLocarVaixell(v, x, y, orientacio);

                if (!colocat) {
                    System.out.println("ERROR:El vaixell surt del taulell o xoca amb un altre. Torna a provar.");
                }
            }
        }

        System.out.println("Flota posicionada correctament!");
        this.taulellPropi.mostrarTaulell(false);
    }

    public boolean hasPerdut(){
        return taulellPropi.totsElsVaixellsEnfonsats();
    }

    public void escollirObjectiu(Taulell taulellRival){
        System.out.println("Comandant "+ this.nom + ", on vols disparar?");
        boolean disparValid = false;

        while(!disparValid) {
            int x = entrada.obtenirCoordenada("Introdueix la coordenada x on vols disparar: ");
            int y = entrada.obtenirCoordenada("Introdueix la coordenada y on vols disparar: ");

            disparValid = taulellRival.getCasellaConcreta(x, y).rebreTret();
        }

    }

    

}
