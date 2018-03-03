package Kütüphane;

import Model.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {

    ArrayList<Node> gezilenİller = new ArrayList<>();
    ArrayList<Node> dugumler;
    HashMap<Integer,Double> ilDeger = new HashMap<>();
    HashMap<Integer,String> yol = new HashMap<>();
    public PathFinder(ArrayList<Node> Dugumler)
    {
        this.dugumler = Dugumler;
    }

    public ArrayList<Node> yolu_bul(int baslangicPlaka, int bitisPlaka)
    {
        int counter = 0;
        Node baslangic = dugumler.get(baslangicPlaka-1);
        gezilenİller.add(baslangic);
        Node bitis = dugumler.get(bitisPlaka-1);

        Node currentDestination = null;
        double minVal =999999999;
        int destination = 0;
        int onceki_plaka = baslangicPlaka;
        while(true)
        {

            for(int j=0;j<gezilenİller.size();j++)
            {
                baslangic = gezilenİller.get(j);

                for(int i=0;i<baslangic.getKomsuluklar().length;i++)
                {
                    if(baslangic.getKomsularVeDegerleri().get(baslangic.getKomsuluklar()[i]) != null &&
                            baslangic.getKomsularVeDegerleri().get(baslangic.getKomsuluklar()[i]) < minVal)
                    {
                        if(ilDeger.get(baslangic.getKomsuluklar()[i]) == null)
                        {
                            onceki_plaka = baslangic.getPlakaKodu();
                            destination = baslangic.getKomsuluklar()[i];
                            minVal = baslangic.getKomsularVeDegerleri().get(baslangic.getKomsuluklar()[i]);
                        }
                        else if( ilDeger.get(baslangic.getKomsuluklar()[i] ) >
                                baslangic.getKomsularVeDegerleri().get(baslangic.getKomsuluklar()[i]) )
                        {
                            ilDeger.put(baslangic.getKomsuluklar()[i],
                                    baslangic.getKomsularVeDegerleri().get(baslangic.getKomsuluklar()[i]));
                        }

                    }
                }
            }
            if(destination == 31)
            {
                Object mundi = 0;
                toString();
            }
            boolean control = false;
            for(int i=1;i<82;i++)
            {
                if(ilDeger.get(i) == null)
                {
                    control = true;
                    break;
                }
            }
            if(control == true && destination != 0 && minVal != 999999999)
            {
                ilDeger.put(destination,minVal);
                yol.put(counter,""+onceki_plaka + "->" + destination);
                onceki_plaka = destination;
                try
                {
                    currentDestination = dugumler.get(destination-1);
                }
                catch (Exception ex)
                {
                    int mundi = destination;
                }

                currentDestination.setvalueKomsularVeDegerleri(baslangic.getPlakaKodu(),900000000);
                dugumler.set(destination-1,currentDestination);
                komsuluklariGuncelle(currentDestination,minVal);
                gezilenİller.add(currentDestination);
                minVal =999999999;
                destination = 0;
                counter++;
            }else
            {
                Object walk;
                break;
            }

        }


        return yoluGoster(baslangicPlaka,bitisPlaka);
    }

    private void komsuluklariGuncelle(Node currentNode,double minVal)
    {
        for(int i=0;i<currentNode.getKomsuluklar().length;i++)
        {
            if(currentNode.getKomsularVeDegerleri().get(currentNode.getKomsuluklar()[i]) != null )
            {
                currentNode.setvalueKomsularVeDegerleri(currentNode.getKomsuluklar()[i],
                        currentNode.getKomsularVeDegerleri().get(currentNode.getKomsuluklar()[i]) + minVal);
            }
        }
        dugumler.set(currentNode.getPlakaKodu()-1,currentNode);
    }

    private ArrayList<Node> yoluGoster(int baslangic,int bitis)
    {
        ArrayList<Node> path = new ArrayList<>();
        for(int i=yol.size()-1;i>=0;i--)
        {
            String[] adim =  yol.get(i).replace("->"," ").split(" ");
            if(Integer.parseInt(adim[1]) == bitis)
            {
                System.out.println(yol.get(i));
                path.add(dugumler.get(Integer.parseInt(adim[1]) -1));
                bitis = Integer.parseInt(adim[0]);
            }
        }

        return path;
    }

}
