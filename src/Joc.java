public class Joc {
    private Jugador jugador1;
    private Jugador jugador2;
    private Entrades entrades;

    public Joc(){
        this.entrades = new Entrades();

        this.jugador1 = new Jugador("Jugador 1", 10, this.entrades);
        this.jugador2 = new Jugador("Jugador 2", 10, this.entrades);
    }

    public void iniciarPartida(){
        System.out.println("COMENÇA LA PARTIDA D'ENFONSAR LA FLOTA!");
        Vaixell[] flotaInicial = {
                new Vaixell(TipusVaixell.PORTAVIONS),
                new Vaixell(TipusVaixell.CUIRASSAT),
                new Vaixell(TipusVaixell.CUIRASSAT),
                new Vaixell(TipusVaixell.SUBMARI),
                new Vaixell(TipusVaixell.SUBMARI),
                //new Vaixell(TipusVaixell.SUBMARI),
                new Vaixell(TipusVaixell.FRAGATA),
                //new Vaixell(TipusVaixell.FRAGATA),
                new Vaixell(TipusVaixell.FRAGATA),
                new Vaixell(TipusVaixell.PATRULLER),
                //new Vaixell(TipusVaixell.PATRULLER),
                // new Vaixell(TipusVaixell.PATRULLER),
                new Vaixell(TipusVaixell.PATRULLER),
        };
        System.out.println(jugador1.getNom() + " prepara la teva flota.");
        jugador1.posicionarFlota(flotaInicial);
        System.out.println(jugador2.getNom() + " prepara la teva flota.");
        jugador2.posicionarFlota(flotaInicial);

        buclePrincipal();
    }

    public void buclePrincipal(){
        boolean partidaAcabada = false;
        Jugador jugadorActual = jugador1;
        Jugador rival = jugador2;


        while (!partidaAcabada) {
            System.out.println("\n--- TORN DE " + jugadorActual.getNom().toUpperCase() + " ---");
            rival.getTaulellPropi().mostrarTaulell(true);
            jugadorActual.escollirObjectiu(rival.getTaulellPropi());

            if (rival.hasPerdut()) {
                System.out.println("VICTÒRIA! " + jugadorActual.getNom() + " ha destruït tota la flota enemiga!");
                partidaAcabada = true;
            } else {
                Jugador temporal = jugadorActual;
                jugadorActual = rival;
                rival = temporal;
            }
        }

        System.out.println("Gràcies per jugar!");
    }

}

