package Kütüphane;

import Model.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class PathFinder {

    ArrayList<Node> gezilenİller = new ArrayList<>();
    ArrayList<Node> dugumler;
    HashMap<Integer,Double> ilDeger = new HashMap<>();

    public PathFinder(ArrayList<Node> Dugumler)
    {
        this.dugumler = Dugumler;
    }

    public void yolu_bul(int baslangicPlaka, int bitisPlaka)
    {
        Node baslangic = dugumler.get(baslangicPlaka-1);
        gezilenİller.add(baslangic);
        Node bitis = dugumler.get(bitisPlaka-1);

        Node currentDestination = null;
        double minVal =999999999;
        int destination = 0;
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
            }else
            {
                break;
            }

        }




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

    private ArrayList<Node> yoluGoster()
    {

        return null;
    }

}
