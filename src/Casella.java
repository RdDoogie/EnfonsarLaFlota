public class Casella {
    private boolean esVaixell;
    private boolean esMarcada;
    private int coordenadaX;
    private int coordenadaY;
    private char state = 'O';

    public Casella(){
        this.esVaixell = false;
        this.esMarcada = false;

    }

    public void setState(char state){
        this.state = state;
    }

    public char getState() {
        return state;
    }
}
