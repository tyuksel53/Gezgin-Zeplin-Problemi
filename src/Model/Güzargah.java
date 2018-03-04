package Model;

import java.util.ArrayList;

public class Güzargah {

    public double gidelenMesafe;
    public int dugumSayisi;
    public int yolcuSayisi;
    public double kar;
    public ArrayList<Node> dugumler;

    public Güzargah(double gidelenMesafe,int dugumSayisi,int yolcuSayisi,double kar,ArrayList<Node> dugumler)
    {
        this.gidelenMesafe = gidelenMesafe;
        this.dugumSayisi = dugumSayisi;
        this.yolcuSayisi = yolcuSayisi;
        this.kar = kar;
        this.dugumler = dugumler;
    }
}
