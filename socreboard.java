/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author DELL
 */
public class socreboard extends JFrame{
     String Home = "";
     String Enemy = "";
     int Score1 = 0;
     int Score2 = 0;
     JPanel panel;
     JFrame frame;
     JLabel score;
     JLabel Time;
     int time = 0;
    socreboard(String home , String enemy,int score1 , int score2)
    {
        frame = new JFrame(home+" vs "+enemy);
        panel = new JPanel();
        score = new JLabel();
        Time = new JLabel();
        score.setFont(new Font("Arial",Font.BOLD, 40));
        Time.setFont(new Font("Arial",Font.BOLD, 40));
        Time.setSize(50,50);
        score.setSize(50,50);
        panel.setLayout(new BorderLayout());
        panel.setSize(frame.getSize());
        Score1 = score1;
        Score2 = score2;
        Home = home;
        Enemy = enemy;
        score.setText("     "+home+" "+score1+" - "+score2+" "+enemy);
        Time.setText("           "+"00:00:00");
        frame.setLocation(700, 300);
        frame.setSize(500, 500);
        panel.add(score,BorderLayout.CENTER);
        panel.add(Time,BorderLayout.NORTH);
        frame.add(panel);
        frame.show();

        
    }
    void UpdateTime()
    {
        this.time+=1;
        if (this.time>=10){
        this.Time.setText("           "+"00:00:"+this.time);
        }
        else
        {
             this.Time.setText("           "+"00:00:0"+this.time);
        }
        
        this.panel.repaint();
        
    }
    void updateScore(int score1,int score2)
    {
        
        this.score.setText("     "+this.Home+" "+score1+" - "+score2+" "+this.Enemy);
        this.Score1 = score1;
        this.Score2 = score2;
        this.panel.repaint();        
    }

    
}
