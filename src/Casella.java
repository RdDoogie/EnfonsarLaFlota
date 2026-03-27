public class Casella {
    private boolean disparada;
    private PartVaixell contingut;
    private Vaixell vaixellMare;

    public Casella() {
        this.disparada = false;
        this.contingut = null;
    }




    public void setContingut(PartVaixell contingut){
        this.contingut = contingut;
    }


    public boolean teVaixell(){
        return this.contingut != null;
    }

    public void setVaixellMare(Vaixell vaixell) {
        this.vaixellMare = vaixell;
    }

    public boolean rebreTret() {
        if (this.disparada) {
            System.out.println("Ja havies disparat en aquesta coordenada!");
            return false;
            }

        this.disparada = true;

        if (this.teVaixell()) {
            this.contingut.rebreImpacte();

            if (this.vaixellMare.estaEnfonsat()) {
                System.out.println("Tocat i enfonsat!!");
            } else {
                System.out.println("Tocat!");
            }
        } else {
            System.out.println("Aigua!");
        }

        return true;

        }

    public char obtenirCaracter(boolean amagarVaixells) {
        if (!this.disparada){
            if(this.teVaixell() && !amagarVaixells){
                return 'V';
            } else {
                return 'A';
            }
        } else {
            if (this.teVaixell()){
                return 'X';
            }else {
                return 'D';
            }
        }
    }

    }


