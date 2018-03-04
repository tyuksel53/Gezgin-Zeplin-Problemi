package Model;

import java.util.ArrayList;

public class Güzargah {

    public double gidelenMesafe;
    public int dugumSayisi;
    public int yolcuSayisi;
    public double kar;
    public ArrayList<Node> dugumler;
    public double yuzdeElli_karFiyat;
    public double tutar;

    public Güzargah(double gidelenMesafe,int dugumSayisi,int yolcuSayisi,double kar,ArrayList<Node> dugumler,double tutar)
    {
        this.gidelenMesafe = gidelenMesafe;
        this.dugumSayisi = dugumSayisi;
        this.yolcuSayisi = yolcuSayisi;
        this.kar = kar;
        this.dugumler = dugumler;
        this.tutar = tutar;
    }

    public Güzargah(double gidelenMesafe,int dugumSayisi,int yolcuSayisi,double kar,ArrayList<Node> dugumler,double yüzdeKar,double tutar)
    {
        this.gidelenMesafe = gidelenMesafe;
        this.dugumSayisi = dugumSayisi;
        this.yolcuSayisi = yolcuSayisi;
        this.kar = kar;
        this.dugumler = dugumler;
        this.yuzdeElli_karFiyat = yüzdeKar;
    }
}
