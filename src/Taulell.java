import java.util.ArrayList;
import java.util.List;

public class Taulell{
    private Casella[][] graella;
    private int mida;
    private List<Vaixell> vaixells;


    public Taulell(int mida){
        for(int i = 0; i < mida; i++){
            for(int j = 0;j<mida; j++){
                this.graella[i][j] = new Casella();
            }
        }
    }

    public Taulell (Casella[][] graella, Vaixell[] vaixells, int mida){
        this.mida = mida;
        this.graella = new Casella[mida][mida];
        this.vaixells = new ArrayList<>();

        for(int i = 0; i < mida; i++){
            for(int j = 0;j<mida; j++){
                this.graella[i][j] = new Casella();
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

            this.graella[filaActual][colActual].setContingut(new PartVaixell());

            vaixell.getParts()[i].setCoordenades(filaActual, colActual);
        }

        this.vaixells.add(vaixell);

        return true;
    }
    private boolean posicioEsValida(Vaixell vaixell, int x, int y, Orientacio orientacio) {
        if (orientacio == Orientacio.HORITZONTAL) {
            if (x + vaixell.getMida() > graella.length) return false;

            for (int i = 0; i < vaixell.getMida(); i++) {
                if (!graella[x + i][y].estaDisparada() || graella[x + i][y].esVaixell()) return false;
            }
        } else if (orientacio == Orientacio.VERTICAL) {
            if (y + vaixell.getMida() > graella[0].length) return false;

            for (int i = 0; i < vaixell.getMida(); i++) {
                if (!graella[x][y + i].estaDisparada() || graella[x + i][y].esVaixell()) return false;
            }
        }
        return true;
    }



    public boolean totsElsVaixellsEnfonsats(){
        for(int i = 0; i<graella.length; i++){
            for (int j = 0; j<graella[i].length;j++){
                if(!graella[i][j].getContingut().estaTocat()){
                    return false;
                }
            }
        }
        return true;
    }

    public void imprimirTaulell(){
        for (int i = 0; i<graella.length;i++) {
            for (int j = 0; j<graella[i].length;j++){
                if(j != 9){
                    System.out.print(graella[i][j].obtenirCaracter() + " ");
                } else {
                    System.out.print(graella[i][j].obtenirCaracter());
                }
            }
            System.out.println();
        }
    }
}