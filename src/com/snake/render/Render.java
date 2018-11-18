package com.snake.render;

import com.snake.Const;
import com.snake.field.*;
import com.snake.field.cell.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;


/**
 * Created by x0152 on 11.07.16.
 */
public class Render extends JPanel{

    public Render(JFrame window){
        //this.setLocation(0, Const.HEIGHT_TOP_BAR);
        //this.setSize(Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        //window.getContentPane().setLayout(null);
        window.add(this, BorderLayout.CENTER);
    }


    @Override
    public void paintComponent(Graphics g){
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.drawImage(_canvas, null, null);
    }

    public void DrawField(Field field){
        Graphics2D graphics2D = (Graphics2D) _canvas.getGraphics();
        graphics2D.clearRect(0, 0, Const.WINDOW_WIDTH, Const.WINDOW_HEIGHT);
        Cell[][] cells = field.GetCells();
        for(int i = 0; i < cells.length; ++i){
            for(int j = 0; j < cells[i].length; ++j){
                int x = i * (int)Const.SIZE_CELL;
                int y = j * (int)Const.SIZE_CELL;

                Rectangle2D rectangleCell = new Rectangle2D.Float(x, y, Const.SIZE_CELL - 1,
                        Const.SIZE_CELL - 1);

                cells[i][j].Draw(graphics2D, rectangleCell);
            }
        }
    }

    public BufferedImage _canvas = new BufferedImage(Const.WINDOW_WIDTH,
            Const.WINDOW_HEIGHT,
            BufferedImage.TYPE_INT_RGB);

}
