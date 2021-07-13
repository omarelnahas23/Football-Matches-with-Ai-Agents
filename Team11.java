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
public class Team11 extends Agent{

    @Override
    protected void setup() {
        System.out.println("we are in team11");
        //Team1Behaviour b1 = new Team1Behaviour();
        Ticker11 b1 = new Ticker11(this, 5000);
        addBehaviour(b1);
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
