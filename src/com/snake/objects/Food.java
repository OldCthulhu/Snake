package com.snake.objects;
import com.snake.Const;
import com.snake.Game;
import com.snake.event.Event;
import com.snake.field.*;
import com.snake.field.cell.*;
import com.snake.field.cell.Cell;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by x0152 on 11.07.16.
 */

public class Food implements GameObject {

    public void DrawObject(Field field){
        Cell[][] cells = field.GetCells();
        Cell cell = new CellFood(this, sizeFood);
        cells[x][y] = cell;
    }
    public int GetScore(){
        return 0;
    }

	public void Update(Field field){
        Cell[][] cells = field.GetCells();

        if(this.x < 0 || this.y < 0){
            Generation();
        }

        GameObject gameObject = cells[this.x][this.y].GetObject();
        if(gameObject != this) {
            while (gameObject instanceof CellWall || gameObject instanceof CellSnake) {
                Generation();
                gameObject = cells[this.x][this.y].GetObject();
            }
        }
	}

	public int GetSize(){
	    return sizeFood;
    }

	public void Generation(){
	    sizeFood = new Random().nextInt(9) + 1;

        Random horizontalRandomCoord = new Random();
        Random verticalRandomCoord = new Random();

        this.x = horizontalRandomCoord.nextInt(Const.HORIZONTAL_COUNT_CELLS);
        this.y = verticalRandomCoord.nextInt(Const.VERTICAL_COUNT_CELLS);
    }

    public void HandlerKeyEvent(KeyEvent keyEvent){

    }

    private int x = -1;
    private int y = -1;
    private int sizeFood = 0;
}
