public class Casella {
    private boolean disparada;
    private PartVaixell contingut;

    public Casella() {
        this.disparada = false;
        this.contingut = null;
    }
    public PartVaixell getContingut(){
        return contingut;
    }
    public boolean estaDisparada(){
        return disparada;
    }

    public boolean esVaixell(){
        return contingut==null;
    }

    public void setContingut(PartVaixell contingut){
        this.contingut = contingut;
    }

    public void assignarVaixell(PartVaixell part){
        this.contingut = part;
    }

    public boolean teVaixell(){
        return this.contingut != null;
    }

    public boolean rebreTret() {
        if (this.disparada) {
            System.out.println("Ja havies disparat en aquesta coordenada!");
            return false;
            }

        this.disparada = true;

        if (this.teVaixell()) {
            System.out.println("Tocat!");

            this.contingut.rebreImpacte();
        } else {
            System.out.println("Aigua!");
        }

        return true;


        }
    public char obtenirCaracter() {
        if (!this.disparada) return 'A';
        if (teVaixell()) return 'X';
        return 'D';
    }
    }


