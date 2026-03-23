import java.util.ArrayList;
import java.util.List;

public class Taulell{
    private EstatCasella[][] graella;
    private int mida;
    private List<Vaixell> vaixells;

    public Taulell (EstatCasella[] graella, Vaixell[] vaixells, int mida){
        this.mida = mida;
        this.graella = new EstatCasella[mida][mida];
        this.vaixells = new ArrayList<>();

        for(int i = 0; i < mida; i++){
            for(int j = 0;j<mida; j++){
                this.graella[i][j] = EstatCasella.AIGUA;
            }
        }
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

            this.graella[filaActual][colActual] = EstatCasella.VAIXELL_INTACTE;

            vaixell.getParts()[i].setCoordenades(filaActual, colActual);
        }

        this.vaixells.add(vaixell);

        return true;
    }
    private boolean posicioEsValida(Vaixell vaixell, int x, int y, Orientacio orientacio) {
        if (orientacio == Orientacio.HORITZONTAL) {
            if (x + vaixell.getMida() > graella.length) return false;

            for (int i = 0; i < vaixell.getMida(); i++) {
                if (graella[x + i][y] != EstatCasella.AIGUA) return false;
            }
        } else if (orientacio == Orientacio.VERTICAL) {
            if (y + vaixell.getMida() > graella[0].length) return false;

            for (int i = 0; i < vaixell.getMida(); i++) {
                if (graella[x][y + i] != EstatCasella.AIGUA) return false;
            }
        }
        return true;
    }
}