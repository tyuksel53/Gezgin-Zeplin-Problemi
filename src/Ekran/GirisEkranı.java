package Ekran;

import Kütüphane.PathFinder;
import Kütüphane.Portal;
import Model.Güzargah;
import Model.Node;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

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
        JButton btnProblem1 = new JButton("Problem 1");
        btnProblem1.setBounds(130,180,95,30);

        JButton btnProblem2 = new JButton("Problem 2");
        btnProblem2.setBounds(25,180,95,30);

        JLabel lbBaslangic = new JLabel("Başlangıç şehrin plakası girin:");
        lbBaslangic.setBounds(25,10,225,50);

        JTextField tfBaslangicPlaka = new JTextField();
        tfBaslangicPlaka.setBounds(25,50,200,30);

        JLabel lbBitis = new JLabel("Bitiş şehrin plakası girin:");
        lbBitis.setBounds(25,90,225,50);

        JTextField tfBitisPlaka = new JTextField();
        tfBitisPlaka.setBounds(25,130,200,30);


        btnProblem1.addActionListener(e -> {
            Portal.getInstance().problem1_dosyalari_sil();
            int baslangicPlaka = Integer.parseInt( tfBaslangicPlaka.getText() );
            int bitisPlaka = Integer.parseInt( tfBitisPlaka.getText() );

            ArrayList<Node> grafDugumler  = Portal.getInstance().dogumleriTanimla();
            ArrayList<Güzargah> güzargahlar = new ArrayList<>();
            for(int yolcuSayisi=5;yolcuSayisi<=50;yolcuSayisi++)
            {
                for(int i=0;i<grafDugumler.size();i++)
                {
                    grafDugumler.get(i).setKomsularVeDegerleri(grafDugumler,yolcuSayisi);
                }

                PathFinder findMyPath = new PathFinder(grafDugumler);
                ArrayList<Node> yol = findMyPath.yolu_bul(baslangicPlaka,bitisPlaka);

                if(yol.size() != 0)
                {
                    /*dosyaya yazma işlemi*/
                    Portal.getInstance().problem1_dosyaya_yaz(grafDugumler,yolcuSayisi);

                    double gidilenMesafe = findMyPath.gidilenMesafe(bitisPlaka);
                    double tutar = (gidilenMesafe / 100) * 1000;
                    double kar = (yolcuSayisi * 20) - tutar;
                    yol.add(grafDugumler.get(baslangicPlaka -1));
                    Güzargah güzargah = new Güzargah(gidilenMesafe,yol.size(),yolcuSayisi,kar,yol,tutar);
                    güzargahlar.add(güzargah);
                }else
                {
                    break;
                }

            }

            Collections.sort(güzargahlar, new Comparator<Güzargah>() {
                @Override
                public int compare(Güzargah z1, Güzargah z2) {
                    if (z1.kar > z2.kar)
                        return -1;
                    if (z1.kar < z2.kar)
                        return 1;
                    return 0;
                }
            });


            if(güzargahlar.size() == 0)
            {
                JOptionPane.showMessageDialog(null,"Yol bulunamadı");
                return;
            }

            /* güzargahları filtreleme işlemei */
            HashMap<Double,Double> check = new HashMap<>();
            ArrayList<Güzargah> basitleştirilmisGüzargahlar = new ArrayList<>();

            for(int i=0;i<güzargahlar.size();i++)
            {
                Güzargah suankiGüzargah = güzargahlar.get(i);
                if(check.get(suankiGüzargah.gidelenMesafe) == null)
                {
                    check.put(suankiGüzargah.gidelenMesafe,suankiGüzargah.kar);
                    basitleştirilmisGüzargahlar.add(suankiGüzargah);

                }
            }

            /* son olarak en iyi kardan , en kötü kara doğru güzargahların listelenmesi */
            int counter=0;
            for(int i=basitleştirilmisGüzargahlar.size()-1;i>=0;i--)
            {
                Güzargah suankiGüzargah = basitleştirilmisGüzargahlar.get(i);
                counter++;
                NumberFormat formatter = new DecimalFormat("#0.00");
                String aciklama = "Toplam Gidilen mesafe: "+ formatter.format(suankiGüzargah.gidelenMesafe)
                        + "_Tutar: " + formatter.format(suankiGüzargah.tutar)
                        + "_Yolcu sayisi: "+ suankiGüzargah.yolcuSayisi
                        + "_Elde edilen kar: " +formatter.format(suankiGüzargah.kar);
                new YoluGoster(""+counter+". Güzargah - Yolcu sayisi: "+suankiGüzargah.yolcuSayisi
                        , suankiGüzargah.dugumler,aciklama);
            }
        });



        btnProblem2.addActionListener(e -> {
            Portal.getInstance().problem1_dosyalari_sil();
            int baslangicPlaka = Integer.parseInt( tfBaslangicPlaka.getText() );
            int bitisPlaka = Integer.parseInt( tfBitisPlaka.getText() );

            ArrayList<Node> grafDugumler  = Portal.getInstance().dogumleriTanimla();
            ArrayList<Güzargah> güzargahlar = new ArrayList<>();
            for(int yolcuSayisi=10;yolcuSayisi<=50;yolcuSayisi+=10)
            {
                for(int i=0;i<grafDugumler.size();i++)
                {
                    grafDugumler.get(i).setKomsularVeDegerleri(grafDugumler,yolcuSayisi);
                }

                PathFinder findMyPath = new PathFinder(grafDugumler);
                ArrayList<Node> yol = findMyPath.yolu_bul(baslangicPlaka,bitisPlaka);

                if(yol.size() != 0)
                {
                    /*dosyaya yazma işlemi*/
                    Portal.getInstance().problem2_dosyaya_yaz(grafDugumler,yolcuSayisi);

                    double gidilenMesafe = findMyPath.gidilenMesafe(bitisPlaka);
                    double tutar = (gidilenMesafe / 100) * 1000;
                    double alinamsiGerekenFiyat = ( (tutar / 2) + tutar ) / yolcuSayisi;
                    yol.add(grafDugumler.get(baslangicPlaka -1));
                    Güzargah güzargah = new Güzargah(gidilenMesafe,yol.size(),yolcuSayisi,tutar,yol,alinamsiGerekenFiyat,tutar);
                    güzargahlar.add(güzargah);
                }else
                {
                    break;
                }

            }

            Collections.sort(güzargahlar, new Comparator<Güzargah>() {
                @Override
                public int compare(Güzargah z1, Güzargah z2) {
                    if (z1.kar > z2.kar)
                        return -1;
                    if (z1.kar < z2.kar)
                        return 1;
                    return 0;
                }
            });


            if(güzargahlar.size() == 0)
            {
                JOptionPane.showMessageDialog(null,"Yol bulunamadı");
                return;
            }

            /* güzargahları filtreleme işlemei */
            HashMap<Double,Double> check = new HashMap<>();
            ArrayList<Güzargah> basitleştirilmisGüzargahlar = new ArrayList<>();
            int counter=0;
            for(int i=0;i<güzargahlar.size();i++)
            {
                Güzargah suankiGüzargah = güzargahlar.get(i);
                counter++;
                NumberFormat formatter = new DecimalFormat("#0.00");
                String aciklama = "Toplam Gidilen mesafe: "+ formatter.format(suankiGüzargah.gidelenMesafe)
                        + "_Tutar: " +formatter.format(suankiGüzargah.kar)
                        + "_Yolcu Sayisi: "+ suankiGüzargah.yolcuSayisi
                        + "_50% Kar için alinmasi gereken fiyat: " + formatter.format(suankiGüzargah.yuzdeElli_karFiyat);
                new YoluGoster(""+counter+". Güzargah - Yolcu sayisi: "+suankiGüzargah.yolcuSayisi
                        , suankiGüzargah.dugumler,aciklama);
            }

        });


        this.add(lbBitis);
        this.add(tfBitisPlaka);
        this.add(btnProblem2);
        this.add(tfBaslangicPlaka);
        this.add(lbBaslangic);

        this.add(btnProblem1);

        this.setSize(263,300);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setVisible(true);
    }

}
