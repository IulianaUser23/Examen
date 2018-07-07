package domain;

/**
 * Created by User on 07.07.2018.
 */
public class RutaCalatori extends Ruta{

    private int ore;
    private int nrVagoane;

    public RutaCalatori (String orasPornire, String orasDestinatie, int ore, int nrVagoane){
        super(orasPornire, orasDestinatie);
        this.ore = ore;
        this.nrVagoane=nrVagoane;
    }


    @Override
    public String toString() {
        return "orasPornire" + orasPornire + "orasDestinatie" + orasDestinatie +
                "ore=" + ore +
                ", nrVagoane=" + nrVagoane +
                '}';
    }

}
