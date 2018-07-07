package domain;

/**
 * Created by User on 07.07.2018.
 */
public abstract class Ruta {


    protected String orasPornire;
    protected String orasDestinatie;

    public Ruta (String orasPornire, String orasDestinatie){
        this.orasPornire=orasPornire;
        this.orasDestinatie=orasDestinatie;

    }

    public String getOrasPornire() {
        return orasPornire;
    }


    public String getOrasDestinatie() {
        return orasDestinatie;
    }


    public abstract String toString();
}
