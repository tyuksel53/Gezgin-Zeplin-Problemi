package Ekran;

import Model.Node;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Harita extends JPanel {

    private BufferedImage buffImg;
    private ArrayList<Node> yol;
    public Harita(ArrayList<Node> yol) {
        this.yol = yol;
        try {
            buffImg = ImageIO.read(new File("drawable/map.jpg"));
        } catch (IOException e) {
            System.out.println("Harita yüklenemdi");
            System.exit(0);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(buffImg, 10, 39, null);

        g.setColor(Color.red);
        for(int i=0;i<yol.size()-1;i++)
        {
            g.drawLine(yol.get(i).getKordinatX(),yol.get(i).getKordinatY(),
                    yol.get(i+1).getKordinatX(),yol.get(i+1).getKordinatY());
        }
        for(int i=0;i<yol.size();i++)
        {
            g.fillOval(yol.get(i).getKordinatX(),yol.get(i).getKordinatY(),10,10);
        }

    }

}
