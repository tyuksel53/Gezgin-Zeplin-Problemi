package Kütüphane;

import Model.Node;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Portal {
    private static Portal ourInstance = new Portal();

    public static Portal getInstance() {
        return ourInstance;
    }

    private Portal() {

    }

    public ArrayList<Node> dogumleriTanimla()
    {
        ArrayList<Node> dugumler = new ArrayList<>();

        // haritanın kordinatları okunamsı
        try (BufferedReader br = new BufferedReader(new FileReader("harita-kordinatlar.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                Node yeni = new Node();
                yeni.setKordinatX(Integer.parseInt(sCurrentLine.split(",")[1]));
                yeni.setKordinatY(Integer.parseInt(sCurrentLine.split(",")[2]));
                dugumler.add(yeni);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        //lat-long dosyası okunması
        int sayac=0;
        try (BufferedReader br = new BufferedReader(new FileReader("lat-long.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] okunanSatir = sCurrentLine.split(",");
                dugumler.get(sayac).setLatitude(Double.parseDouble(okunanSatir[0]));
                dugumler.get(sayac).setLongitute(Double.parseDouble(okunanSatir[1]));
                dugumler.get(sayac).setPlakaKodu(Integer.parseInt(okunanSatir[2]));
                dugumler.get(sayac).setAltitude(Integer.parseInt(okunanSatir[3]));
                sayac++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sayac = 0;

        //Komsulukalrın okunması
        try (BufferedReader br = new BufferedReader(new FileReader("Komşuluklar.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] komusularDummy = sCurrentLine.split(",");
                int[] komsuluklar = new int[komusularDummy.length-1];
                for(int i=0;i<komusularDummy.length;i++)
                {
                    if(i== 0)
                    {
                        continue;
                    }
                    komsuluklar[i-1] = Integer.parseInt(komusularDummy[i]);
                }
                dugumler.get(sayac).setKomsuluklar(komsuluklar);
                sayac++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return dugumler;
    }


    public double mesafeyiBul(Node suanki,Node hedef) {

        double lat1 = suanki.getLatitude();
        double lon1 = suanki.getLongitute();
        double lat2 = hedef.getLatitude();
        double lon2 = hedef.getLongitute();

        double theta = lon1 - lon2;
        double mesafe = Math.sin(derece_radyana(lat1)) * Math.sin(derece_radyana(lat2))
                + Math.cos(derece_radyana(lat1)) *
                Math.cos(derece_radyana(lat2)) * Math.cos(derece_radyana(theta));

        mesafe = Math.acos(mesafe);
        mesafe = radyan_dereceye(mesafe);
        mesafe = mesafe * 60 * 1.1515;
        mesafe = mesafe * 1.609344;
        return (mesafe);
    }

    public boolean gidilebilirMi(Node suankiKonum,Node hedefKonum,int yolucuSayisi)
    {
        double mesafe = mesafeyiBul(suankiKonum,hedefKonum);

        double yukseklik = Math.abs( (hedefKonum.getAltitude() + 40) - suankiKonum.getAltitude() );

        double atanValue = Math.toDegrees( Math.atan(  yukseklik / mesafe ) );

        return (80 - yolucuSayisi) > Math.floor( (atanValue) ); /* koşula göre gidebilir */
    }

    private double radyan_dereceye(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    private double derece_radyana(double deg) {
        return (deg * Math.PI / 180.0);
    }
    public void problem1_dosyalari_sil()
    {
        /* önceki işlemden kalan dosyaların silinmesi */
        File directory = new File("dosyaCiktisi/problem1");
        File[] files = directory.listFiles();
        for (File file : files)
        {
            if (!file.delete())
            {
                System.out.println("Dosya silinemedi "+file);
            }
        }
    }
    public void problem1_dosyaya_yaz(ArrayList<Node> dugumler,int yolcuSayisi)
    {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("dosyaCiktisi/problem1/lat-long-komsuluklar-yolcusayisi-"+yolcuSayisi+".txt", "UTF-8");
        } catch (Exception ex) {
            System.out.println("Dosya açılamadı");
        }
        writer.println();
        writer.println("plaka,lat,long,komsu1,komsu2,komsu3.....");
        for(int i=0;i<dugumler.size();i++)
        {
            Node currentNode = dugumler.get(i);
            String komsuluklar = "";
            NumberFormat formatter = new DecimalFormat("#0.00");
            for(int j=0;j<currentNode.getKomsuluklar().length;j++)
            {
                if(currentNode.getKomsularVeDegerleri()
                    .get(currentNode.getKomsuluklar()[j]) == null)
                {
                    komsuluklar = komsuluklar + "null,";
                }else
                {
                    komsuluklar = komsuluklar +formatter.format(currentNode.getKomsularVeDegerleri()
                            .get(currentNode.getKomsuluklar()[j])) + ",";
                }

            }
            komsuluklar = komsuluklar.substring(0,komsuluklar.length()-1);

            writer.println("" + currentNode.getPlakaKodu() + "," + currentNode.getLatitude() +
                    "," + currentNode.getLongitute() + "," + komsuluklar);
        }
        writer.close();
    }
}
