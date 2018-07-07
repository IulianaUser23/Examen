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

        try{
            ser.addRuta(r1);
            ser.addRuta(r2);
            ser.addRuta(rt1);
            ser.addRuta(rt2);
        }catch (Exception e){}

       GUI ui = new GUI(ser);
       ui.initGUI();
    }
}
