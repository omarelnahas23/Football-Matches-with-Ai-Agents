/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import jade.core.Agent;


/**
 *
 * @author DELL
 */
public class Team10 extends Agent{

    @Override
    protected void setup() {
        System.out.println("we are in team10");
        Ticker10 b2 = new Ticker10(this,5000);
        addBehaviour(b2);
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
