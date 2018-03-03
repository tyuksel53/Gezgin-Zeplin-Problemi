package Ekran;

import Model.Node;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class YoluGoster extends JFrame {

    public YoluGoster(String title, ArrayList<Node> yol,double kar)
    {
        this.setTitle(title);
        this.setContentPane(new Harita(yol));

        NumberFormat formatter = new DecimalFormat("#0.00");
        JLabel kartxt = new JLabel("Elde Edilen kar: " + formatter.format(kar));
        kartxt.setBounds(500,400,200,100);
        this.add(kartxt);
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
