package ui;

import service.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class GUI extends JFrame {

    //imi aduc service-ul
    private Service service;
    //creez lista (spatiul) in care vor fi afisate elem
    private JList<String > lista = new JList<String>();
    //panoul pt nume fisier (window)
    private JLabel labelNumeFisier = new JLabel("Nume fisier");
    //textul cu nume fisier
    private JTextField numeFisier = new JTextField();

    private JLabel labelOrasPornire = new JLabel("Oras Pornire");
    private JTextField orasPornire = new JTextField();
    private JLabel labelOrasDestinatie = new JLabel("Oras Destinatie");
    private JTextField orasDestinatie = new JTextField();
    private JLabel labelDurata = new JLabel("Durata calatoriei");
    private JTextField durata = new JTextField();
    private JLabel labelTipuriVagoane = new JLabel("Cate tipuri de vagoane");
    private JTextField tipuriVagoane = new JTextField();

    private JLabel labelTonaj= new JLabel("Tonajul");
    private JTextField tonaj = new JTextField();

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
        componentaJos.add(this.butonSterge);  //problema spune sa salvam si sa stergem si atunci adaugam butoane
        componentaJos.add(this.butonSalveaza);//pentru aceste doua operatii
        this.add(componentaJos,BorderLayout.SOUTH); //adaug componetaJos JPanel in partea de jos a BorderLayout-ului

        JPanel componentaPrincipala = new JPanel(new GridLayout(6,4) );
        JPanel componentaFr = componentaPrincipala;
        JPanel componentaMS = componentaPrincipala;
        componentaFr.add(this.labelId);
        componentaFr.add(this.Id);
        componentaFr.add(this.labelClsEnerg);
        componentaFr.add(this.ClsEnerg);
        componentaFr.add(this.labelAreCong);
        componentaFr.add(this.AreCong);

        componentaMS.add(this.labelIdM);
        componentaMS.add(this.IdM);
        componentaMS.add(this.labelCantE);
        componentaMS.add(this.CantE);

        componentaFr.add(this.butonAddF);
        componentaMS.add(this.butonAddM);

        this.add(componentaPrincipala, BorderLayout.CENTER);


        //le fac vizibile si sa se si inchida aplicatia cand inchid fereastra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    //functia de populare a listei
    public void populeazaLista(){
        DefaultListModel<String> listModel = new DefaultListModel<>(); //am facut modelul listei si populez cu un for
        for (Produs p: this.service.getAll()){
            listModel.addElement(p.toString());  //populez lista folosind functia toString
        }this.lista.setModel(listModel);
    }

    //creez functia de adaugare
    public void handlerButonAddFr(){
        this.butonAddF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(Id.getText());
                String clsEnerg = ClsEnerg.getText();
                boolean areCongelator = AreCong.isValid();
                try {
                    Produs fr = new Frigider(id,clsEnerg,areCongelator);
                    service.addProdus(fr);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                populeazaLista();
                //pot pune sa imi stearga ce am adaugat eu in fiecare casuta dupa apasarea butonului add
                Id.setText("");
                ClsEnerg.setText("");
                AreCong.setText("");

            }
        });
    }
    public void handlerButonAddM(){
        this.butonAddM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(IdM.getText());
                double cantE = Double.parseDouble(CantE.getText());
                try {
                    Produs m = new MasinaSpalat(id,cantE);
                    service.addProdus(m);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                populeazaLista();
                //pot pune sa imi stearga ce am adaugat eu in fiecare casuta dupa apasarea butonului add
                IdM.setText("");
                CantE.setText("");

            }
        });
    }

    //creez functia de stergere: cand dau click pe un eveniment si apoi buton de sterge sa se stearga produsul
    public void handlerButonSterge(){
        this.butonSterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idx = lista.getSelectedIndex();
                service.sterge(idx);

                populeazaLista();

            }
        });
    }

    //creez functia care atunci cand apas butonul salveaza sa faca operatiunea
    public void handlerButonSalveaza(){
        this.butonSalveaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeFis = numeFisier.getText();
                try{
                    service.salveaza(numeFis);
                }catch (FileNotFoundException el){
                    el.printStackTrace();
                }
            }
        });
    }

}
