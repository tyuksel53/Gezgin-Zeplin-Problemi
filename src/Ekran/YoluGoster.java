package Ekran;

import Model.Node;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class YoluGoster extends JFrame {

    public YoluGoster(String title, int baslangicPlaka, int bitisPlaka, ArrayList<Node> yol)
    {
        this.setTitle(title);
        this.setContentPane(new Harita(yol));


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

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

        this.setSize(738,500);

        this.setLayout(null);
        this.setVisible(true);

    }

}
