package service;

import domain.Ruta;
import repository.Repository;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by User on 07.07.2018.
 */
public class Service {
    private Repository repo;

    //constructorul care ia ca parametru repo-ul
    public Service (Repository r){
        this.repo = r;
    }

    //functia de adaugare
    public void addRuta (Ruta r) throws Exception {
        this.repo.add(r);
    }

    public ArrayList<Ruta> getAll(){
        return this.repo.getAll();
    }
    //functia de stergere




}
