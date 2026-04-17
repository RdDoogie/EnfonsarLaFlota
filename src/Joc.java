public class Joc {
    private Jugador[] jugadors;
    private Entrades entrades = new Entrades();

    public Joc(){
        this.jugadors = new Jugador[2];
        this.jugadors[0] = new Jugador("Jugador 1", 10, this.entrades);
        this.jugadors[1] = new Jugador("Jugador 2", 10, this.entrades);
    }


    private Vaixell[] generarFlota() {
        return new Vaixell[]{
                new Vaixell(TipusVaixell.PORTAVIONS),
                new Vaixell(TipusVaixell.CUIRASSAT),
                new Vaixell(TipusVaixell.CUIRASSAT),
                new Vaixell(TipusVaixell.SUBMARI),
                new Vaixell(TipusVaixell.SUBMARI),
                new Vaixell(TipusVaixell.FRAGATA),
                new Vaixell(TipusVaixell.FRAGATA),
                new Vaixell(TipusVaixell.PATRULLER),
                new Vaixell(TipusVaixell.PATRULLER)
        };
    }

    public void iniciarPartida(){
        Sortides.mostrarIniciPartida();

        Sortides.mostrarPreparacioFlota(jugadors[0].getNom());
        jugadors[0].posicionarFlota(generarFlota());

        Sortides.mostrarPreparacioFlota(jugadors[1].getNom());
        jugadors[1].posicionarFlota(generarFlota());

        buclePrincipal();
    }

    public void buclePrincipal(){
        boolean partidaAcabada = false;
        Jugador jugadorActual = jugadors[0];
        Jugador rival = jugadors[1];

        while (!partidaAcabada) {
            Sortides.mostrarTorn(jugadorActual.getNom());

            rival.getTaulellPropi().mostrarTaulell(true);

            jugadorActual.escollirObjectiu(rival.getTaulellPropi());

            if (rival.hasPerdut()) {
                Sortides.mostrarVictoria(jugadorActual.getNom());
                partidaAcabada = true;
            } else {
                Jugador temporal = jugadorActual;
                jugadorActual = rival;
                rival = temporal;
            }
        }

        Sortides.mostrarFi();
    }
}