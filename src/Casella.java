public class Casella {
    private boolean disparada;
    private PartVaixell partVaixell;
    private Vaixell vaixellMare;

    public Casella() {
        this.disparada = false;
        this.partVaixell = null;
    }

    public void setPartVaixell(PartVaixell partVaixell){
        this.partVaixell = partVaixell;
    }

    public boolean teVaixell(){
        return this.partVaixell != null;
    }

    public void setVaixellMare(Vaixell vaixell) {
        this.vaixellMare = vaixell;
    }

    public boolean rebreTret() {
        if (this.disparada) {
            Sortides.mostrarJaDisparat();
            return false;
        }

        this.disparada = true;

        if (this.teVaixell()) {
            this.partVaixell.rebreImpacte();

            if (this.vaixellMare.estaEnfonsat()) {
                Sortides.mostrarEnfonsat();
            } else {
                Sortides.mostrarTocat();
            }
        } else {
            Sortides.mostrarAigua();
        }

        return true;
    }

    public char obtenirCaracter(boolean amagarVaixells) {
        if (!this.disparada){
            if(this.teVaixell() && !amagarVaixells){
                return 'V';
            } else {
                return '-';
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