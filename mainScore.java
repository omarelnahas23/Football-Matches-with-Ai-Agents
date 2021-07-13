/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class  mainScore extends JFrame{
     String Home = "";
     String Enemy = "";
     int Score1 = 0;
     int Score2 = 0;
     static JPanel panel;
     static JFrame frame;
     
     
     
    mainScore(String home , String enemy,int score1 , int score2)
    {
        frame = new JFrame("ScoreBoard of the cup");
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(frame.getSize());
        Score1 = score1;
        Score2 = score2;
        Home = home;
        Enemy = enemy;
        panel.setSize(frame.getSize());
        frame.setLocation(700, 300);
        frame.setSize(500, 500);
       
        
        frame.add(panel);
        frame.show();

        
    }

    void updateScore(String home,String en,int score1,int score2)
    {
        JLabel score = new JLabel();
        score.setFont(new Font("Arial",Font.BOLD, 20));
        score.setText("     "+this.Home+" "+score1+" - "+score2+" "+this.Enemy);
        panel.add(score);
        this.panel.repaint();        
    }

    
}
