package com.snake.field;

import com.snake.Const;
import com.snake.field.cell.Cell;
import com.snake.field.cell.CellFood;
import com.snake.field.cell.EmpatyCell;

/**
 * Created by x0152 on 11.07.16.
 */
public class Field {
    public Field(){
        cells = new Cell[(int)Const.HORIZONTAL_COUNT_CELLS]
                        [(int)Const.VERTICAL_COUNT_CELLS];

        for(int i = 0; i < Const.HORIZONTAL_COUNT_CELLS; ++i){
            for(int j = 0; j < Const.VERTICAL_COUNT_CELLS; ++j){
                cells[i][j] = new EmpatyCell();
            }
        }
    }

    public Cell[][] GetCells(){
        return this.cells;
    }

    public void Clear(){
        for(int i = 0; i < Const.HORIZONTAL_COUNT_CELLS; ++i){
            for(int j = 0; j < Const.VERTICAL_COUNT_CELLS; ++j){
                cells[i][j] = new EmpatyCell();
            }
        }
    }


    private Cell[][] cells;

}
