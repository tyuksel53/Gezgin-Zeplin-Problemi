package Ekran;

import Kütüphane.Portal;
import Model.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GirisEkranı extends JFrame {

    public GirisEkranı()
    {
        this.setTitle("Ana Menü");

        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(GirisEkranı.this,
                        "Çıkmak istediğinden emin misin ? ", "Uygulama Kapanıyor?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){

                        /*Açık ekranları kapatan kısım*/

                        Window[] windows = getWindows();

                        for (Window window : windows)
                        {
                            if (window instanceof JDialog)
                            {
                                window.dispose();
                            }
                        }
                        System.exit(0);
                }
            }
        });


        //components
        JButton btnHesapla = new JButton("Hesapla");
        btnHesapla.setBounds(110,250,90,30);

        btnHesapla.addActionListener(e -> {
            ArrayList<Node> grafDugumler = new ArrayList<>();
            Portal myPortal = Portal.getInstance();

            grafDugumler = myPortal.dogumleriTanimla();
            new YoluGoster("Optimal 1");

        });

        JLabel lbBaslangic = new JLabel("Başlangıç şehrin plakası girin:");
        lbBaslangic.setBounds(25,10,200,50);

        JTextField tfBaslangicPlaka = new JTextField();
        tfBaslangicPlaka.setBounds(25,50,175,30);

        JLabel lbBitis = new JLabel("Bitiş şehrin plakası girin:");
        lbBitis.setBounds(25,90,200,50);

        JTextField tfBitisPlaka = new JTextField();
        tfBitisPlaka.setBounds(25,130,175,30);

        JLabel lbYolcu = new JLabel("Yolcu sayisini girin:");
        lbYolcu.setBounds(25,170,200,50);

        JTextField tfYolcuSayisi = new JTextField();
        tfYolcuSayisi.setBounds(25,210,175,30);

        this.add(lbYolcu);
        this.add(tfYolcuSayisi);

        this.add(lbBitis);
        this.add(tfBitisPlaka);

        this.add(tfBaslangicPlaka);
        this.add(lbBaslangic);

        this.add(btnHesapla);

        this.setSize(255,330);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

}
