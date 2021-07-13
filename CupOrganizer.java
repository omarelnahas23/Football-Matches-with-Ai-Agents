/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ContainerController;
import java.sql.Time;
import java.util.*;

/**
 *
 * @author DELL
 */
public class CupOrganizer extends Agent {
    ArrayList<String> Teams = new ArrayList<String>();
    ArrayList<String> Score = new ArrayList<String>();
    ArrayList<Time> time = new ArrayList<Time>();
    ArrayList<String> Referee = new ArrayList<String>();
    ArrayList<String> PlayGround = new ArrayList<String>();
    @Override
    protected void setup() {
        Teams.add("Team1");
        Teams.add("Team2");
        Teams.add("Team3");
        Teams.add("Team4");
        Teams.add("Team5");
        Teams.add("Team6");
        Teams.add("Team7");
        Teams.add("Team8");
        Teams.add("Team9");
        Teams.add("Team10");
        Teams.add("Team11");
        Teams.add("Team12");
        Teams.add("Team13");
        Teams.add("Team14");
        Teams.add("Team15");
        Teams.add("Team16");
        time.add(new Time(3,20,20));
        time.add(new Time(3,20,21));
        time.add(new Time(3,20,22));
        time.add(new Time(3,20,23));
        time.add(new Time(3,20,24));
        time.add(new Time(3,20,25));
        time.add(new Time(3,20,26));
        time.add(new Time(3,20,27));
        Referee.add("Refree1");
        Referee.add("Refree2");
        Referee.add("Refree3");
        Referee.add("Refree4");
        Referee.add("Refree5");
        Referee.add("Refree6");
        Referee.add("Refree7");
        Referee.add("Refree8");

        PlayGround.add("Staduim1");
        PlayGround.add("Staduim2");
        PlayGround.add("Staduim3");
        PlayGround.add("Staduim4");
        PlayGround.add("Staduim5");
        PlayGround.add("Staduim6");
        PlayGround.add("Staduim7");
        PlayGround.add("Staduim8");
        Collections.shuffle(Teams);
        Collections.shuffle(time);
        Collections.shuffle(Referee);
        Collections.shuffle(PlayGround);
        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
       /* boolean flag = true;
        try{
            msg.addReceiver(new AID(Teams.get(0),AID.ISLOCALNAME));
          }
        catch (Exception e)
        {
            flag = false;
        }
        
        if(flag){
        */


           
        msg.addReceiver(new AID(Teams.get(0),AID.ISLOCALNAME));
        msg.setContent(Teams.get(1)+" "+time.get(0).toString()+" "+Referee.get(0)+" "+PlayGround.get(0));
        this.send(msg);
        
        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(2),AID.ISLOCALNAME));
        msg.setContent(Teams.get(3)+" "+time.get(1).toString()+" "+Referee.get(1)+" "+PlayGround.get(1));
        this.send(msg);
        

        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(4),AID.ISLOCALNAME));
        msg.setContent(Teams.get(5)+" "+time.get(2).toString()+" "+Referee.get(2)+" "+PlayGround.get(2));
        this.send(msg);      
        
        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(6),AID.ISLOCALNAME));
        msg.setContent(Teams.get(7)+" "+time.get(1).toString()+" "+Referee.get(3)+" "+PlayGround.get(3));
        this.send(msg);
        

        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(8),AID.ISLOCALNAME));
        msg.setContent(Teams.get(9)+" "+time.get(2).toString()+" "+Referee.get(4)+" "+PlayGround.get(4));
        this.send(msg);      
        
        
        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(10),AID.ISLOCALNAME));
        msg.setContent(Teams.get(11)+" "+time.get(1).toString()+" "+Referee.get(5)+" "+PlayGround.get(5));
        this.send(msg);
        

        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(12),AID.ISLOCALNAME));
        msg.setContent(Teams.get(13)+" "+time.get(2).toString()+" "+Referee.get(6)+" "+PlayGround.get(6));
        this.send(msg);      
        msg = new ACLMessage(ACLMessage.INFORM);
        msg.addReceiver(new AID(Teams.get(14),AID.ISLOCALNAME));
        msg.setContent(Teams.get(15)+" "+time.get(2).toString()+" "+Referee.get(7)+" "+PlayGround.get(7));
        this.send(msg);     
        
    //    }
        
        //msg = new ACLMessage(ACLMessage.INFORM);
        //msg.addReceiver(new AID(Teams.get(2),AID.ISLOCALNAME));
        //msg.setContent(Teams.get(3)+" "+time.get(1).toString()+" "+Referee.get(1)+" "+PlayGround.get(1));
        //this.send(msg);
    }

    @Override
    protected void takeDown() {
        super.takeDown(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
