package com.snake.render;
import javax.swing.*;

import com.snake.Const;

import java.awt.*;

/**
 * Created by x0152 on 11.07.16.
 */
public class Window extends JFrame {
    public  Window(){
        getContentPane().setBackground(Color.GRAY);
        setLocation(0, 0);
        setSize((int)(Const.WINDOW_WIDTH),
                (int)(Const.WINDOW_HEIGHT));
    }

}
