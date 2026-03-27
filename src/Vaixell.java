public class Vaixell {
    private PartVaixell[] parts;
    private TipusVaixell mida;

    public Vaixell(TipusVaixell mida) {
        this.mida = mida;
        this.parts = new PartVaixell[mida.getMida()];

        for (int i = 0; i < mida.getMida(); i++) {
            this.parts[i] = new PartVaixell();
        }
    }
    public PartVaixell[] getParts(){
        return parts;
    }

    public boolean estaEnfonsat() {
        for (int i = 0; i < parts.length; i++){
            if (! parts[i].estaTocat()){
                return false;
            }
        }
        return true;
    }


    public int getMida(){
        return mida.getMida();
    }
}
