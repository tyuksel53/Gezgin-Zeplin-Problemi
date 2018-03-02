package MyJFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EkraniOlustur {


    public EkraniOlustur()
    {
        JFrame ekran = new JFrame("Gezgin Zeplin Problemi");
        //actions
        ekran.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ekran.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(ekran,
                        "Çıkmak istediğinden emin misin ? ", "Uygulama Kapanıyor?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        System.exit(0);
                }
            }
        });

        //components
        JButton btnHesapla = new JButton("Hesapla");
        btnHesapla.setBounds(600,500,90,30);

        JLabel map = new JLabel(new ImageIcon("drawable/map.jpg"));
        map.setBounds(0,0,700,337);

        JLabel lbBaslangic = new JLabel("Başlangıç şehrin plakası girin:");
        lbBaslangic.setBounds(10,340,200,50);
        
        JTextField tfBaslangicPlaka = new JTextField();
        tfBaslangicPlaka.setBounds(10,380,175,30);

        JLabel lbBitis = new JLabel("Bitiş şehrin plakası girin:");
        lbBitis.setBounds(220,340,200,50);

        JTextField tfBitisPlaka = new JTextField();
        tfBitisPlaka.setBounds(220,380,175,30);

        JLabel lbYolcu = new JLabel("Yolcu sayisini girin:");
        lbYolcu.setBounds(430,340,200,50);

        JTextField tfYolcuSayisi = new JTextField();
        tfYolcuSayisi.setBounds(430,380,175,30);

        ekran.add(lbYolcu);
        ekran.add(tfYolcuSayisi);

        ekran.add(lbBitis);
        ekran.add(tfBitisPlaka);

        ekran.add(tfBaslangicPlaka);
        ekran.add(lbBaslangic);

        ekran.add(map);
        ekran.add(btnHesapla);
        ekran.setSize(715,600);
        ekran.setLayout(null);
        ekran.setVisible(true);

    }

}
