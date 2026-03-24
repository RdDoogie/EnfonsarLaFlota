public class PartVaixell {
    private int coordenadaX;
    private int coordenadaY;
    private boolean estaDisparat = false;

    public void rebreImpacte(){
        this.estaDisparat = true;
    }

    public void setCoordenades(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public boolean estaTocat(){
        return estaDisparat;
    }

    public int getCoordenadaX (){
        return this.coordenadaX;
    }

    public int getCoordenadaY(){ return this.coordenadaY; }
}
