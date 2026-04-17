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

                Sortides.mostrarVaixellsPendents();
                for (int j = i; j < vaixellsAPosicionar.length; j++) {
                    Sortides.mostrarMidaVaixell(vaixellsAPosicionar[j].getMida());
                }

                Sortides.mostrarColocantVaixell(v.getMida());

                int x = entrada.obtenirCoordenada("Introdueix la coordenada fila (x): ");
                int y = entrada.obtenirCoordenada("Introdueix la coordenada columna (y): ");
                Orientacio orientacio = entrada.obtenirOrientacio();

                colocat = this.taulellPropi.colLocarVaixell(v, x, y, orientacio);

                if (!colocat) {
                    Sortides.mostrarErrorColocacio();
                }
            }
        }

        Sortides.mostrarFlotaPosicionada();
        this.taulellPropi.mostrarTaulell(false);
    }

    public boolean hasPerdut(){
        return taulellPropi.totsElsVaixellsEnfonsats();
    }

    public void escollirObjectiu(Taulell taulellRival){
        Sortides.mostrarOnDisparar(this.nom);
        boolean disparValid = false;

        while(!disparValid) {
            int x = entrada.obtenirCoordenada("Introdueix la coordenada x on vols disparar: ");
            int y = entrada.obtenirCoordenada("Introdueix la coordenada y on vols disparar: ");

            disparValid = taulellRival.getCasellaConcreta(x, y).rebreTret();
        }
    }
}