public class Vaixell {
    private PartVaixell[] parts;
    private int mida;
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

    public boolean estaEnfonsat() {
        int count = 0;
        for (int i = 0; i < parts.length; i++){
            if (! parts[i].estaTocat()){
                return false;
            }
        }
        return true;
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
