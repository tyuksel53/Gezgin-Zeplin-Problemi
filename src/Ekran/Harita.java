package Ekran;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Harita extends JPanel {

    private BufferedImage buffImg;

    public Harita() {
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
        //TODO: Burda yol çizdirilecek

       /* g.setColor(Color.red);

        try (BufferedReader br = new BufferedReader(new FileReader("harita-kordinatlar.txt"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                g.fillOval(Integer.parseInt(sCurrentLine.split(",")[1] ),Integer.parseInt(sCurrentLine.split(",")[2] ),10,10);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //TODO:END
    }

}
