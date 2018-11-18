package com.snake.field.cell;

import com.snake.Const;
import com.snake.objects.GameObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by x0152 on 13.07.16.
 */
public class EmpatyCell extends Cell {

    public EmpatyCell(){
        super(null);
    }

    public void R_Draw(Graphics2D g, Rectangle2D rectangle){
        rectangle.setRect(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
        g.setColor(Const.COLOR_EMPATY);
        g.draw(rectangle);
    }
}
