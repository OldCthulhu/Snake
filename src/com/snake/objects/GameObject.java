package com.snake.objects;
import com.snake.event.Event;
import com.snake.field.*;

import java.awt.event.KeyEvent;

/**
 * Created by x0152 on 11.07.16.
 */
public interface GameObject {
    void DrawObject(Field field);
	void Update(Field field);
    void HandlerKeyEvent(KeyEvent event);
    int GetScore();
}
