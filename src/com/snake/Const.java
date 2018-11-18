package com.snake;

import java.awt.*;

/**
 * Created by x0152 on 11.07.16.
 */
public class Const {
    public static int SIZE_CELL = 30;
    public static int HORIZONTAL_COUNT_CELLS = 25;
    public static int VERTICAL_COUNT_CELLS = 25;
    public static int HEIGHT_TOP_BAR = 0;
    public static int WINDOW_WIDTH = HORIZONTAL_COUNT_CELLS * SIZE_CELL + 11;
    public static int WINDOW_HEIGHT = VERTICAL_COUNT_CELLS * SIZE_CELL + HEIGHT_TOP_BAR + 56;
    public static int COUNT_WALL = 20;
    public static int START_SPEED = 200;

    public static Color COLOR_SNAKE = Color.GREEN;
    public static Color COLOR_SNAKE_HEADER = Color.YELLOW;
    public static Color COLOR_WALL = Color.WHITE;
    public static Color COLOR_EMPATY = Color.blue;
    public static Color COLOR_BORDER_SNAKE = Color.black;
}
