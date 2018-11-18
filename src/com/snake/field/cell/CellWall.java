package com.snake.field.cell;

import com.snake.Const;
import com.snake.Game;
import com.snake.objects.GameObject;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by x0152 on 15.08.16.
 */
public class CellWall extends Cell{

    public CellWall(GameObject gameObject){
        super(gameObject);
    }

    public void R_Draw(Graphics2D g, Rectangle2D rectangle){
        g.setColor(Color.black);
        g.draw(rectangle);
        g.setColor(Const.COLOR_WALL);
        g.fill(rectangle);
    }


}
