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
//        for (Produs p: this.produse)
//                if (p.getId() == id)
//                    return p;
//
//            return null;

        Ruta r = this.rute.stream()
                .filter(pr -> pr.getOrasDestinatie().equals(orasDestinatie))
                .findFirst()
                .orElse(null);
        return r;
    }
    //functia de adaugare
    public void add (Ruta r) throws Exception {
       Ruta ruta =this.find(r.getOrasDestinatie());
        if(ruta != null)
            throw new Exception("Ruta existenta!"); //daca pun throw new Exception, imi si prinde aici exceptia
        this.rute.add(r);
    }
    //functie de getAll
    public ArrayList<Ruta> getAll() {
        return new ArrayList<Ruta>(this.rute);
    }

}
