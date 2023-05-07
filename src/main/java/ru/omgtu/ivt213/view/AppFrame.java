package ru.omgtu.ivt213.view;

import ru.omgtu.ivt213.CellsMap;
import ru.omgtu.ivt213.utils.Pair;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class AppFrame extends JFrame {
    CellsMap map;
    JPanel canvas;

    public AppFrame(CellsMap map) {
        super("title");
        this.map = map;
        setSize(480, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        canvas = new JPanel();
        canvas.setBounds(0, 0, 600, 400);
        canvas.setBackground(Color.WHITE);
        add(canvas);
        setSize(610, 400);
    }
    public void paint(Graphics g) {
        int length = 100;
        for (int j = 0;j<length;++j){
            for (int i = 0; i<length;++i){
                if (map.checkCell(new Pair<>(i,j))){
                    g.fillRect(i*getWidth()/length, j*getHeight()/length, getWidth()/length, getHeight()/length);
                }
            }
        }
    }

}
