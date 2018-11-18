package com.snake.field.cell;

import com.snake.Const;
import com.snake.objects.GameObject;
import com.sun.javafx.geom.Vec2d;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by x0152 on 11.08.16.
 */
public class CellHeadSnake extends CellSnake{

    public CellHeadSnake(GameObject gameObject, Vec2d vec2d){
        super(gameObject ,vec2d);
    }

    public void R_Draw(Graphics2D g, Rectangle2D rectangle2D){
        //rectangle2D.setRect(rectangle2D.getX() + 4, rectangle2D.getY() + 4, rectangle2D.getWidth() - 4, rectangle2D.getHeight() - 4);

        g.setColor(Const.COLOR_SNAKE_HEADER);
        g.draw(rectangle2D);
        g.fill(rectangle2D);
    }
}
