package main;

import domain.Ruta;
import domain.RutaCalatori;
import domain.RutaMarfa;
import repository.Repository;
import service.Service;
import ui.GUI;

public class Main {

    public static void main(String[] args) {

        Repository repo = new Repository();
        Service ser = new Service(repo);

        Ruta r1 = new RutaCalatori("bistrita","oradea", 4, 2);
        Ruta r2 = new RutaCalatori("bistrita","bucuresti", 12, 3);
        Ruta rt1 = new RutaMarfa("bistrita", "beclean", 2);
        Ruta rt2 = new RutaMarfa("bistrita", "Jucu", 7) ;

//        try{
//            ser.addProdus(r1);
//            ser.addProdus(r2);
//            ser.addProdus(rt1);
//            ser.addProdus(rt2);
//        }catch (Exception e){}
//
       // GUI ui = new GUI();
       // ui.run();
    }
}
