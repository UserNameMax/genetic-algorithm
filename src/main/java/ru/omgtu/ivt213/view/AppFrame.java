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
        for (int j = 0;j<10;++j){
            for (int i = 0; i<10;++i){
                if (map.checkCell(new Pair<>(i,j))){
                    g.fillRect(i*getWidth()/10, j*getHeight()/10, getWidth()/10, getHeight()/10);
                }
            }
        }
    }

}
