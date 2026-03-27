public enum TipusVaixell {
    PORTAVIONS(5),
    CUIRASSAT(4),
    SUBMARI(3),
    FRAGATA(2),
    PATRULLER(1);


    private int mida;

    TipusVaixell(int mida){
        this.mida = mida;
    }

    public int getMida(){
        return mida;
    }
}
