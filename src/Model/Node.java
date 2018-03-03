package Model;

import Kütüphane.Portal;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.HashMap;

public class Node {

    private int plakaKodu;

    private int[] komsuluklar;


    private HashMap<Integer,Double> komsularVeDegerleri = new HashMap<Integer, Double>();

    public HashMap<Integer, Double> getKomsularVeDegerleri() {
        return komsularVeDegerleri;
    }

    public void setvalueKomsularVeDegerleri(int index,double val)
    {
        this.komsularVeDegerleri.put(index,val);
    }
    public void setKomsularVeDegerleri(ArrayList<Node> dugumler,int yolcuSayisi) {

        for(int i=0;i<komsuluklar.length;i++)
        {
            if(Portal.getInstance().gidilebilirMi(this,dugumler.get( komsuluklar[i]-1),yolcuSayisi))
            {
                komsularVeDegerleri.put(komsuluklar[i],Portal.getInstance().mesafeyiBul(this,
                        dugumler.get(komsuluklar[i] -1)));
            }else
            {
                komsularVeDegerleri.put(komsuluklar[i],null); // zeplin gidememiş
            }
        }

    }

    private int kordinatX;
    private int kordinatY;

    private double latitude;
    private double longitute;
    private int altitude;

    public void setPlakaKodu(int plakaKodu) {
        this.plakaKodu = plakaKodu;
    }

    public void setKomsuluklar(int[] komsuluklar) {
        this.komsuluklar = komsuluklar;
    }

    public void setKordinatX(int kordinatX) {
        this.kordinatX = kordinatX;
    }

    public void setKordinatY(int kordinatY) {
        this.kordinatY = kordinatY;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitute(double longitute) {
        this.longitute = longitute;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getPlakaKodu() {

        return plakaKodu;
    }

    public int[] getKomsuluklar() {
        return komsuluklar;
    }

    public int getKordinatX() {
        return kordinatX;
    }

    public int getKordinatY() {
        return kordinatY;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitute() {
        return longitute;
    }

    public int getAltitude() {
        return altitude;
    }

}
