public class Sortides {

    public static void imprimirMissatge(String missatge) {
        System.out.print(missatge);
    }

    public static void mostrarIniciPartida() {
        System.out.println("COMENÇA LA PARTIDA D'ENFONSAR LA FLOTA!");
    }

    public static void mostrarPreparacioFlota(String nomJugador) {
        System.out.println(nomJugador + " prepara la teva flota.");
    }

    public static void mostrarTorn(String nomJugador) {
        System.out.println("Torn De " + nomJugador.toUpperCase());
    }

    public static void mostrarVictoria(String nomJugador) {
        System.out.println("VICTÒRIA! " + nomJugador + " ha enfonsat tota la flota enemiga!");
    }

    public static void mostrarFi() {
        System.out.println("Gracies per jugar!");
    }

    public static void mostrarVaixellsPendents() {
        System.out.println("Vaixells pendents de col·locar:");
    }

    public static void mostrarMidaVaixell(int mida) {
        System.out.println("Vaixell de mida: " + mida);
    }

    public static void mostrarColocantVaixell(int mida) {
        System.out.println("Col·locant el vaixell de mida " + mida);
    }

    public static void mostrarErrorColocacio() {
        System.out.println("ERROR: El vaixell surt del taulell o xoca amb un altre. Torna-ho a provar.");
    }

    public static void mostrarFlotaPosicionada() {
        System.out.println("Flota posicionada correctament!");
    }

    public static void mostrarOnDisparar(String nom) {
        System.out.println("Capita " + nom + ", on vols disparar?");
    }

    public static void mostrarJaDisparat() {
        System.out.println("Ja havies disparat en aquesta casella! Proven un altre.");
    }

    public static void mostrarEnfonsat() {
        System.out.println("Tocat i enfonsat!");
    }

    public static void mostrarTocat() {
        System.out.println("Tocat!");
    }

    public static void mostrarAigua() {
        System.out.println("Aigua!");
    }

    public static void mostrarErrorNumero() {
        System.out.println("Error: Perfavor, introdueix un numero valid.");
    }

    public static void mostrarErrorOrientacio() {
        System.out.println("Error: Perfavor, introdueix H o V.");
    }

    public static void mostrarTaulell(Casella[][] graella, boolean amagarVaixells) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < graella.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < graella[i].length; j++) {
                System.out.print(graella[i][j].obtenirCaracter(amagarVaixells) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}