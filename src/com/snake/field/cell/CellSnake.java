package com.snake.field.cell;

import com.snake.Const;
import com.snake.objects.GameObject;
import com.sun.javafx.geom.Vec2d;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by x0152 on 10.08.16.
 */
public class CellSnake extends Cell{
    public CellSnake(GameObject gameObject, Vec2d position){
        super(gameObject);
        this.position.x = position.x;
        this.position.y = position.y;
    }

    public void R_Draw(Graphics2D g, Rectangle2D rectangle){
        //rectangle.setRect(rectangle.getX() + 5, rectangle.getY() + 5, rectangle.getWidth() - 5, rectangle.getHeight() - 5);
        g.setColor(Const.COLOR_SNAKE);
        g.fill(rectangle);
        g.setColor(Const.COLOR_BORDER_SNAKE);
        g.draw(rectangle);
    }

    public Vec2d GetPosition(){
        return position;
    }

    private Vec2d position = new Vec2d();
}
