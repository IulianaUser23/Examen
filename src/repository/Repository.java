package repository;

import domain.Ruta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 07.07.2018.
 */
public class Repository {

    private ArrayList<Ruta> rute = new ArrayList<Ruta>();
    public Ruta find (String orasDestinatie){

        Ruta r = this.rute.stream()
                .filter(pr -> pr.getOrasDestinatie().equals(orasDestinatie))
                .findFirst()
                .orElse(null);
        return r;
    }
    //functia de adaugare
    public void add (Ruta r) throws Exception {

         this.rute.add(r);
    }
    //functie de getAll
    public ArrayList<Ruta> getAll() {
        return new ArrayList<Ruta>(this.rute);
    }

}
