package Kütüphane;

import Model.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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


    public double mesafeyiBul(double lat1, double lon1, double lat2, double lon2) {
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

    private double radyan_dereceye(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    private double derece_radyana(double deg) {
        return (deg * Math.PI / 180.0);
    }
}
