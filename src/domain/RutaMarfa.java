package domain;

/**
 * Created by User on 07.07.2018.
 */
public class RutaMarfa extends Ruta {

    protected int tonaj;

    public RutaMarfa (String orasPornire, String orasDestinatie, int tonaj){
        super (orasPornire, orasDestinatie);
        this.tonaj=tonaj;

    }

    @Override
    public String toString() {
        return "orasPornire" + orasPornire + "orasDestinatie" + orasDestinatie +
                "tonaj=" + tonaj +
                '}';
    }
}
