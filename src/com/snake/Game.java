package com.snake;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import com.snake.field.Field;
import com.snake.objects.*;
import com.snake.render.*;
import com.snake.render.Window;

import javax.swing.*;

/**
 * Created by x0152 on 11.07.16.
 */
public class Game {

    public Game() {
        window = new Window();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                for (GameObject gameObject : objects) {
                    gameObject.HandlerKeyEvent(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        this.scoreCounter = new JLabel("Score: " + score);
        this.recordCounter = new JLabel("Record: " + record);
        JPanel topBar = new JPanel();
        topBar.add(this.scoreCounter);
        topBar.add(this.recordCounter);
        window.add(topBar, BorderLayout.NORTH);
    }

    private void Init(){
        if(render != null) {
            window.remove(render);
        }
        this.objects.clear();

        if(this.record < this.score){
            this.record = this.score;
            this.recordCounter.setText("Record: " + this.record);
        }

        this.score = 0;

        for(int i = 0; i < Const.COUNT_WALL; ++i) {
            this.objects.add(new Wall());
        }

        this.playerSnake = new Snake();

        this.objects.add(this.playerSnake);
        this.objects.add(new Food());
        this.speed = Const.START_SPEED;
    }

    public void Play(){
        while (true) {
            Init();
            Run();
        }
    }

    private void Run(){
        render = new Render(window);
        Field field = new Field();

        window.setVisible(true);
        render.setVisible(true);

        while (true){
            Render(field);

            if(!IsPlayGame()){
                JOptionPane.showMessageDialog(null, "Game Over! Your score: " + score + ", your record: " + record, "Game Over", JOptionPane.INFORMATION_MESSAGE);

                return;
            }
            if((this.speed > 60) && (new Random().nextInt(10) < 2)) {
                this.speed *= this.deltaSpeed;
            }

            try {
                java.lang.Thread.sleep(speed);
            }catch (Exception e) {
                e.getStackTrace();
            }

            for (Iterator<GameObject> it = this.objects.iterator(); it.hasNext();) {
                GameObject gameObject = it.next();
                score += gameObject.GetScore();
            }

            scoreCounter.setText("Score: " + score);
        }
    }

    private boolean IsPlayGame(){
        if(!this.playerSnake.IsLive()){
            return false;
        }

        return true;
    }

    private void Render(Field field){
        for (Iterator<GameObject> it = this.objects.iterator(); it.hasNext();) {
            GameObject object = it.next();
            object.Update(field);
        }

        field.Clear();

        for (Iterator<GameObject> it = this.objects.iterator(); it.hasNext();) {
            GameObject object = it.next();
            object.DrawObject(field);
        }

        render.DrawField(field);
        window.repaint();


    }
    private int speed = Const.START_SPEED;
    private int score = 0;
    private int record = 0;
    private float deltaSpeed = 0.999999f; //0.1 <= deltaSpeed <= 0.9
    private Render render;
    private JLabel scoreCounter;
    private JLabel recordCounter;
    private ArrayList<GameObject> objects = new ArrayList<GameObject>();
    private Snake playerSnake = null;
    private JFrame window = null;
}
