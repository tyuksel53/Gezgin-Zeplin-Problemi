package Ekran;

import Model.Node;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class YoluGoster extends JFrame {

    public YoluGoster(String title, ArrayList<Node> yol,String aciklama)
    {
        this.setTitle(title);
        this.setContentPane(new Harita(yol));
        String[] aciklamalar = aciklama.split("_");

        JLabel gidilenMesafe = new JLabel(aciklamalar[0]);
        gidilenMesafe.setBounds(10,400,200,30);
        this.add(gidilenMesafe);

        JLabel tutar = new JLabel(aciklamalar[1]);
        tutar.setBounds(10,430,200,30);
        this.add(tutar);

        JLabel yolcuSayisi = new JLabel(aciklamalar[2]);
        yolcuSayisi.setBounds(10,460,200,30);
        this.add(yolcuSayisi);

        JLabel kar = new JLabel(aciklamalar[3]);
        kar.setBounds(10,490,700,30);
        this.add(kar);


        this.setSize(738,600);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);

    }

}
