package Ekran;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class EkraniOlustur extends JFrame {

    private static ArrayList<String> sehirKordinatlar = new ArrayList<>();
    private static int clickCounter = 0;
    public EkraniOlustur()
    {
        this.setTitle("Gezgin Zeplin Problemi");
        this.setContentPane(new Harita());

        //actions
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(EkraniOlustur.this,
                        "Çıkmak istediğinden emin misin ? ", "Uygulama Kapanıyor?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                        System.exit(0);
                }
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                sehirKordinatlar.add("" + clickCounter + "," + e.getX() + "," + e.getY() );
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //components
        JButton btnHesapla = new JButton("Hesapla");
        btnHesapla.setBounds(600,500,90,30);
        btnHesapla.addActionListener(e -> {

            for(int i=0;i<sehirKordinatlar.size();i++)
            {
                System.out.println(sehirKordinatlar.get(i));
            }

        });

        JLabel lbBaslangic = new JLabel("Başlangıç şehrin plakası girin:");
        lbBaslangic.setBounds(10,380,200,50);
        
        JTextField tfBaslangicPlaka = new JTextField();
        tfBaslangicPlaka.setBounds(10,420,175,30);

        JLabel lbBitis = new JLabel("Bitiş şehrin plakası girin:");
        lbBitis.setBounds(220,380,200,50);

        JTextField tfBitisPlaka = new JTextField();
        tfBitisPlaka.setBounds(220,420,175,30);

        JLabel lbYolcu = new JLabel("Yolcu sayisini girin:");
        lbYolcu.setBounds(430,380,200,50);

        JTextField tfYolcuSayisi = new JTextField();
        tfYolcuSayisi.setBounds(430,420,175,30);

        this.add(lbYolcu);
        this.add(tfYolcuSayisi);

        this.add(lbBitis);
        this.add(tfBitisPlaka);

        this.add(tfBaslangicPlaka);
        this.add(lbBaslangic);

        this.add(btnHesapla);
        this.setSize(738,600);

        this.setLayout(null);
        this.setVisible(true);

    }

}
