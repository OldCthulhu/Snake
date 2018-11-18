/**
 * Created by x0152 on 11.07.16.
 */

package com.snake.objects;
import com.snake.Const;
import com.snake.event.Event;
import com.snake.field.*;
import com.snake.field.cell.Cell;
import com.snake.field.cell.CellHeadSnake;
import com.snake.field.cell.CellSnake;
import com.snake.field.cell.EmpatyCell;
import com.sun.javafx.css.StyleCache;
import com.sun.javafx.geom.Vec2d;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

enum DIRECTION_SNAKE{
    TOP(new Vec2d(0, -1)),
    BOTTOM(new Vec2d(0, 1)),
    LEFT(new Vec2d(-1, 0)),
    RIGHT(new Vec2d(1, 0));

    private Vec2d vector;

    DIRECTION_SNAKE(Vec2d vec2d) {
        this.vector = vec2d;
    }

    public Vec2d GetVector(){
        return this.vector;
    }
}

public class Snake implements GameObject {

    public Snake(){
        this.head = new CellSnake(this, new Vec2d(0, 1));
        AddPart();
    }

    public void DrawObject(Field field){
        Cell[][] cells = field.GetCells();

        for(CellSnake partSnake : this.partsSnake){//draw body
            Vec2d postionPartSnake = partSnake.GetPosition();
            cells[(int)postionPartSnake.x][(int)postionPartSnake.y] = partSnake;
        }

        Vec2d positionHead = this.head.GetPosition();//draw head

        cells[(int)positionHead.x][(int)positionHead.y] = head;
		
	}

	public void Update(Field field){
        Cell[][] cells = field.GetCells();
	    Vec2d positionHead = this.head.GetPosition();


        //Incease snake
        if (!this.partsSnake.isEmpty()) {
            if(this.IsIncrease) {
                IsIncrease = false;
            }else {
                this.partsSnake.remove(this.partsSnake.size() - 1); //delete tail
            }

            this.partsSnake.add(0, new CellSnake(this, positionHead));
        }
        else {
            if (this.IsIncrease) {
                AddPart();
                IsIncrease = false;
            }
        }


		//move head
		positionHead.x += this.direrctionSnake.GetVector().x;
        positionHead.y += this.direrctionSnake.GetVector().y;

        //Mirror coordinates
        if(IsOutputAbroad(positionHead)){
            if(positionHead.x < 0){
                positionHead.x = Const.HORIZONTAL_COUNT_CELLS - 1;
            }else if(positionHead.y < 0){
                positionHead.y = Const.VERTICAL_COUNT_CELLS - 1;
            }else if(positionHead.x > Const.HORIZONTAL_COUNT_CELLS - 1){
                positionHead.x = 0;
            }else if(positionHead.y > Const.VERTICAL_COUNT_CELLS - 1){
                positionHead.y = 0;
            }

        }

        //Checking collision objects with snake
        GameObject counterObject = cells[(int)positionHead.x][(int)positionHead.y].GetObject();

        //collision with snake
        if(counterObject == this){
            Death();
            return;
        }

        //collision with food
        if(counterObject instanceof Food){
            Increase();
            ((Food) counterObject).Generation();
            score += ((Food) counterObject).GetSize();
        }

        //collision with wall
        if(counterObject instanceof Wall){
            Death();
            return;
        }

        //create a new head for new the coordinates
        this.head = new CellHeadSnake(this, positionHead);

        IsControl = true;
    }

    public void AddPart(){
        if(!partsSnake.isEmpty()) {
            CellSnake lastPartSnake = this.partsSnake.get(this.partsSnake.size() - 1);
            Vec2d positionLastPartSnake = lastPartSnake.GetPosition();

            positionLastPartSnake.x -= direrctionSnake.GetVector().x;
            positionLastPartSnake.y -= direrctionSnake.GetVector().y;

            this.partsSnake.add(new CellSnake(this, positionLastPartSnake));
        }else{
            Vec2d positionHeadSnake = this.head.GetPosition();
            this.partsSnake.add(new CellSnake(this, positionHeadSnake));
        }
    }


    public int GetScore(){
        int tmp = this.score;
        this.score = 0;
        return tmp;
    }

    public void Death(){
        isLive = false;
    }

    public boolean IsOutputAbroad(Vec2d postion){
        return postion.x < 0 || postion.x >= Const.HORIZONTAL_COUNT_CELLS ||
                postion.y < 0 || postion.y >= Const.VERTICAL_COUNT_CELLS;
    }

    public void Increase(){
        this.IsIncrease = true;
    }

    public void HandlerKeyEvent(KeyEvent event) {
        if(!this.IsControl){
            return;
        }

        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            if (direrctionSnake != DIRECTION_SNAKE.RIGHT) {
                direrctionSnake = DIRECTION_SNAKE.LEFT;
            }
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (direrctionSnake != DIRECTION_SNAKE.LEFT) {
                direrctionSnake = DIRECTION_SNAKE.RIGHT;
            }
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            if (direrctionSnake != DIRECTION_SNAKE.TOP) {
                direrctionSnake = DIRECTION_SNAKE.BOTTOM;
            }
        } else if (event.getKeyCode() == KeyEvent.VK_UP) {
            if (direrctionSnake != DIRECTION_SNAKE.BOTTOM) {
                direrctionSnake = DIRECTION_SNAKE.TOP;
            }
        }

        IsControl = false;
    }

    public boolean IsLive(){return this.isLive;}
    public boolean IsIncrease = false;
    private boolean IsControl = false; //Blocks rotation the snake more then once per frame
	private DIRECTION_SNAKE direrctionSnake = DIRECTION_SNAKE.BOTTOM;
    private CellSnake head = null;
	private ArrayList<CellSnake> partsSnake = new ArrayList<CellSnake>();
	private int length = 1;
    private int score = 0;
    private boolean isLive = true;
}
