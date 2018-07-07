package ui;

import domain.Ruta;
import domain.RutaCalatori;
import domain.RutaMarfa;
import service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    //imi aduc service-ul
    private Service service;
    //creez lista (spatiul) in care vor fi afisate elem
    private JList<String > lista = new JList<String>();
    //panoul pt nume fisier (window)

    private JLabel labelNumeFisier = new JLabel("Nume fisier");
    private JTextField numeFisier = new JTextField();


    private JLabel labelOrasPornire = new JLabel("Oras Pornire");
    private JTextField OrasPornire = new JTextField();

    private JLabel labelOrasDestinatie = new JLabel("Oras Destinatie");
    private JTextField OrasDestinatie = new JTextField();

    private JLabel labelDurata = new JLabel("Durata calatoriei");
    private JTextField Durata = new JTextField();

    private JLabel labelTipuriVagoane = new JLabel("Cate tipuri de vagoane");
    private JTextField TipuriVagoane = new JTextField();

    private JLabel labelTonaj= new JLabel("Tonajul");
    private JTextField Tonaj = new JTextField();

    private JButton butonSalveaza = new JButton("Salveaza"); //am creat butoane

    private JButton butonAddRutaCalatori = new JButton("Adauga ruta calatori");
    private JButton butonAddRutaMarfa = new JButton("Adauga ruta marfa");

    //imi fac constructorul, unde iau ca param service-ul
    public GUI(Service ser){
        this.service = ser;
        this.initGUI();
        this.populeazaLista();

       this.handlerButonAddRutaCalatori();
       this.handlerButonAddRutaMarfa();
    }


    public void initGUI(){

        //imi fac layout-ul pentru fereastra: tipul, dimensiune
        this.setLayout(new BorderLayout());
        this.setSize(new Dimension(600,400));
        this.add(this.lista, BorderLayout.NORTH); //fereastra cu elem situata pe border centrat

        JPanel componentaJos = new JPanel(new GridLayout(2,2));
        componentaJos.add(this.labelNumeFisier);
        componentaJos.add(this.numeFisier);
        componentaJos.add(this.butonSalveaza);//pentru aceste doua operatii
        this.add(componentaJos,BorderLayout.SOUTH); //adaug componetaJos JPanel in partea de jos a BorderLayout-ului

        JPanel componentaPrincipala = new JPanel(new GridLayout(6,4) );
        JPanel componentaFr = componentaPrincipala;
        JPanel componentaMS = componentaPrincipala;
        componentaFr.add(this.labelOrasPornire);
        componentaFr.add(this.OrasPornire);
        componentaFr.add(this.labelOrasDestinatie);
        componentaFr.add(this.OrasDestinatie);
        componentaFr.add(this.labelDurata);
        componentaFr.add(this.Durata);
        componentaMS.add(this.labelTipuriVagoane);
        componentaMS.add(this.TipuriVagoane);
        componentaMS.add(this.labelTonaj);
        componentaMS.add(this.Tonaj);

        componentaFr.add(this.butonAddRutaCalatori);
        componentaMS.add(this.butonAddRutaMarfa);

        this.add(componentaPrincipala, BorderLayout.CENTER);


        //le fac vizibile si sa se si inchida aplicatia cand inchid fereastra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //functia de populare a listei
    public void populeazaLista(){
        DefaultListModel<String> listModel = new DefaultListModel<>(); //am facut modelul listei si populez cu un for
        for (Ruta s: this.service.getAll()){
            listModel.addElement(s.toString());  //populez lista folosind functia toString
        }this.lista.setModel(listModel);
    }

    private void handlerButonAddRutaCalatori() {
        this.butonAddRutaCalatori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String op =OrasPornire.getText();
                String od = OrasDestinatie.getText();
                int dr = Integer.parseInt(Durata.getText());
                int tp = Integer.parseInt(TipuriVagoane.getText());
                try {
                   Ruta rc = new RutaCalatori(op, od, dr, tp);
                   service.addRuta(rc);
               } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex.getMessage());
              }
               populeazaLista();
               //pot pune sa imi stearga ce am adaugat eu in fiecare casuta dupa apasarea butonului add
            }
        });
    }

    private void handlerButonAddRutaMarfa() {
        this.butonAddRutaCalatori.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String op =OrasPornire.getText();
                String od = OrasDestinatie.getText();
                int tn = Integer.parseInt(Tonaj.getText());
                try {
                    Ruta rm = new RutaMarfa(op,od,tn);
                    service.addRuta(rm);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                populeazaLista();
            }
        });
    }

//
//    //creez functia care atunci cand apas butonul salveaza sa faca operatiunea
//    public void handlerButonSalveaza(){
//        this.butonSalveaza.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String numeFis = numeFisier.getText();
//                try{
//                    service.salveaza(numeFis);
//                }catch (FileNotFoundException el){
//                    el.printStackTrace();
//                }
//            }
//        });
//    }

}
