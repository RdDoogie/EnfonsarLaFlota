public class Vaixell {
    private PartVaixell[] parts;
    private int mida;
    private boolean estaEnfonsat;
    public Vaixell(int mida) {
        this.mida = mida;
        this.parts = new PartVaixell[mida];

        for (int i = 0; i < mida; i++) {
            this.parts[i] = new PartVaixell();
        }
    }
    public PartVaixell[] getParts(){
        return parts;
    }
    public boolean comprovarSiEstaEnfonsat() {
        int count = 0;
        for (int i = 0; i < parts.length; i++){
            if (parts[i].estaTocat()){
                count++;
            }
        }
        return count == mida;
    }

    public void rebreImpacte(int x, int y){
        for (int i = 0; i<parts.length; i++){
            if(parts[i].getCoordenadaX() == x && parts[i].getCoordenadaY() == y) {
                parts[i].rebreImpacte();
            }
        }
    }

    public int getMida(){
        return mida;
    }
}
