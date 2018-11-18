package com.snake.objects;
import com.snake.Const;
import com.snake.event.Event;
import com.snake.field.*;
import com.snake.field.cell.Cell;
import com.snake.field.cell.CellWall;

import java.awt.event.KeyEvent;
import java.util.Random;


/**
 * Created by x0152 on 11.07.16.
 */
public class Wall implements GameObject{

    public Wall(int x, int y){
        this.x = Math.min(Math.max(x, 0), Const.HORIZONTAL_COUNT_CELLS - 1);
        this.y = Math.min(Math.max(y, 0), Const.VERTICAL_COUNT_CELLS - 1);
    }

    public Wall() {
       GeneratedCoordinates();
    }

    public void GeneratedCoordinates(){
        Random random = new Random();

        while (this.x == 0 || this.y == 0) {
            this.x = random.nextInt(Const.HORIZONTAL_COUNT_CELLS);
            this.y = random.nextInt(Const.VERTICAL_COUNT_CELLS);
        }
    }

    public void DrawObject(Field field){
        Cell[][] cells = field.GetCells();

        cells[this.x][this.y] = new CellWall(this);
    }
	
	public void Update(Field field){
        Cell[][] cells = field.GetCells();

        GameObject gameObject = cells[this.x][this.y].GetObject();
        if(gameObject != this) {
            while (gameObject instanceof CellWall) {
                GeneratedCoordinates();
                gameObject = cells[this.x][this.y].GetObject();
            }
        }
	}
    public int GetScore(){
        return 0;
    }
	public void HandlerKeyEvent(KeyEvent keyEvent){

    }

    private int x = 0;
    private int y = 0;
}
