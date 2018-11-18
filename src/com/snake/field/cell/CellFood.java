package com.snake.field.cell;

import com.snake.Const;
import com.snake.Game;
import com.snake.objects.GameObject;
import com.sun.javafx.geom.Vec2f;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Created by x0152 on 13.07.16.
 */
public class CellFood extends Cell {

    public CellFood(GameObject gameObject, int size){
        super(gameObject);
        this.size = size;
    }

    public void R_Draw(Graphics2D g, Rectangle2D rectangle){

        Random randomColor = new Random();


        //draw cell
        g.setColor(Const.COLOR_EMPATY);
        g.draw(rectangle);

        //draw food
        g.setColor(new Color(randomColor.nextInt(255),
                randomColor.nextInt(255),
                randomColor.nextInt(255)));
        double part = rectangle.getWidth() / 6;
        rectangle.setRect(rectangle.getX() + part,
                                    rectangle.getY() + part,
                                        rectangle.getWidth() - part * 1.6f,
                                            rectangle.getHeight() - part * 1.6f);

        g.fillOval((int)rectangle.getX(),
                (int)rectangle.getY(),
                (int)rectangle.getWidth(),
                (int)rectangle.getHeight());
    }

    private int size = 0;
}

