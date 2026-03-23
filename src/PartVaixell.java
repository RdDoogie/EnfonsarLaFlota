public class PartVaixell {
    private int coordenadaX;
    private int coordenadaY;
    private EstatPartVaixell estat;

    public void rebreImpacte(){
        this.estat = EstatPartVaixell.TOCAT;
    }

    public void setCoordenades(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public boolean estaTocat(){
        return estat == EstatPartVaixell.TOCAT;
    }

    public int getCoordenadaX (){
        return this.coordenadaX;
    }

    public int getCoordenadaY(){ return this.coordenadaY; }
}
