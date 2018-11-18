package com.snake.field.cell;

import com.snake.objects.GameObject;
import sun.awt.X11.ColorData;
import sun.plugin.dom.css.Rect;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by x0152 on 11.07.16.
 */
public abstract class Cell {

    public Cell(GameObject gameObject){
        this.gameObject = gameObject;
    }

    private void SaveColor(Graphics2D g){
        color = g.getColor();
    }

    private void RestoreColor(Graphics2D g){
        g.setColor(this.color);
    }

    public void Draw(Graphics2D g, Rectangle2D rectangle){
        SaveColor(g);
        R_Draw(g, rectangle);
        RestoreColor(g);
    }

    public GameObject GetObject(){
        return this.gameObject;
    }

    public abstract void R_Draw(Graphics2D g, Rectangle2D rectangle);

    Color color;
    GameObject gameObject; //к какому объекту привязан
}

