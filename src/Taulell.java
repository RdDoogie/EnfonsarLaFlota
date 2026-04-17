import java.util.ArrayList;
import java.util.List;

public class Taulell{
    private Casella[][] graella;
    private int mida;
    private List<Vaixell> vaixells;

    public Taulell(int mida){
        this.mida = mida;
        this.graella = new Casella[mida][mida];
        for(int i = 0; i < mida; i++){
            for(int j = 0;j<mida; j++){
                this.graella[i][j] = new Casella();
            }
        }
        this.vaixells = new ArrayList<>();
    }

    public Casella getCasellaConcreta(int x, int y){
        return graella[x][y];
    }

    public Casella[][] getGraella() {
        return graella;
    }

    public boolean colLocarVaixell(Vaixell vaixell, int x, int y, Orientacio orientacio) {
        if (!posicioEsValida(vaixell, x, y, orientacio)) {
            return false;
        }

        for (int i = 0; i < vaixell.getMida(); i++) {
            int filaActual = x;
            int colActual = y;

            if (orientacio == Orientacio.HORITZONTAL) {
                colActual = y + i;
            } else {
                filaActual = x + i;
            }

            this.graella[filaActual][colActual].setPartVaixell(vaixell.getParts()[i]);
            this.graella[filaActual][colActual].setVaixellMare(vaixell);
            vaixell.getParts()[i].setCoordenades(filaActual, colActual);
        }
        this.vaixells.add(vaixell);
        return true;
    }

    private boolean posicioEsValida(Vaixell vaixell, int x, int y, Orientacio orientacio) {
        if (orientacio == Orientacio.HORITZONTAL) {
            if (y + vaixell.getMida() > graella[0].length) return false;
            for (int i = 0; i < vaixell.getMida(); i++) {
                if (graella[x][y + i].teVaixell()) return false;
            }
        } else if (orientacio == Orientacio.VERTICAL) {
            if (x + vaixell.getMida() > graella.length) return false;
            for (int i = 0; i < vaixell.getMida(); i++) {
                if (graella[x + i][y].teVaixell()) return false;
            }
        }
        return true;
    }

    public boolean totsElsVaixellsEnfonsats() {
        for (Vaixell v : this.vaixells) {
            if (!v.estaEnfonsat()) {
                return false;
            }
        }
        return true;
    }


    public void mostrarTaulell(boolean amagarVaixells) {
        Sortides.mostrarTaulell(this.graella, amagarVaixells);
    }
}