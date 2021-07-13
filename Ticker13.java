/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Ticker13 extends TickerBehaviour{


    public Ticker13(Agent a, long period) {
        super(a, period);
    }

    int score = 0;
    int enemeyScore = 0;
    static String opp = "";
    socreboard ScoreBoard;
    ContainerController main1 = this.getAgent().getContainerController();
    int t = 0;    @Override
    protected void onTick() {
        System.out.println("We are in Behaviour of team 13");
        if(ScoreBoard != null && t < 5)
        {
            ScoreBoard.UpdateTime();
            t+=1;
            
        }
        else if(t>=5)
        {
            if(score>enemeyScore)
            {
                System.err.println("Team 13 Wins");
                try{

                        AgentController Team2 = main1.getAgent(opp);
                        Team2.kill();
                        AgentController Team1 = main1.getAgent("Team13");
                        Team1.suspend();
                        mainScore sc = new mainScore("Team13", opp, score, enemeyScore);
                        sc.updateScore("Team13", opp, score, enemeyScore);

                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }

                
            }
            else
            {
                System.err.println(opp+" wins");
                try{

                        AgentController Team1 = main1.getAgent("Team13");
                        Team1.kill();            
                        AgentController Team2 = main1.getAgent(opp);
                        Team2.suspend();
                        mainScore sc = new mainScore("Team13", opp, score, enemeyScore);
                        sc.updateScore("Team13", opp, score, enemeyScore);
                    }
                    catch (Exception ex)
                    {
                        ex.printStackTrace();
                    }
            }
        }

        try{
        ACLMessage msg = this.getAgent().receive();
        String s = msg.getContent();
        System.out.println("Content recieved for team 13");
        System.out.println(Arrays.toString(s.split(" ")));
        String[] arr = s.split(" ");
        
        boolean check = false;
            System.out.println("Contents of arr[0]");
            System.out.println(arr[0]);
        for(int i = 0 ; i<arr.length;i++)
        {
            if(arr[i].charAt(0) == 'H' || arr[i].charAt(0) == 'E')
            {
                check = true;
            }

        }
        ArrayList<Integer> subNum = new ArrayList<Integer>();

            if(check)
            {
                opp = arr[0];
                
                subNum = new ArrayList<Integer>();
                if(arr.length>3)
                {
                    enemeyScore = Integer.parseInt(arr[3]);
                }
                s = arr[2];
                arr = s.split(",");
                ArrayList<Integer> Num = new ArrayList<>();
                for(int i=0;i<arr.length;i++)
                {
                    Num.add(Integer.parseInt(arr[i]));
                }
                Collections.shuffle(Num);
                if(Num.size()>2)
                {
                    for(int i=0;i<Num.size()-1;i++)
                    {
                        subNum.add(Num.get(i));
                    }
                }
                else
                {
                    for(int i=0;i<Num.size()-1;i++)
                    {
                        subNum.add(Num.get(i));
                    }                    
                }
                if(max(subNum)!=5)
                {
                    String temp = "";
                    for(int i =0 ; i<Num.size();i++)
                    {
                        if(max(subNum)!=Num.get(i))
                        {
                            if(i+1 == Num.size())
                            {
                                temp = temp+Num.get(i);
                            }
                            else
                            {
                                temp = temp+Num.get(i)+",";
                            }
                        }
                    }
                    
                    ACLMessage masg = new ACLMessage(ACLMessage.INFORM);
                    masg.addReceiver(new AID(opp,AID.ISLOCALNAME));
                    
                    masg.setContent("Team13 H "+temp);
                    this.getAgent().send(masg);             
                }
                else
                {
                    ACLMessage masg = new ACLMessage(ACLMessage.INFORM);
                    masg.addReceiver(new AID(opp,AID.ISLOCALNAME));
                    score++;
                    System.out.println("Team13 Scored Goal!");
                    System.out.println("Score:\n"+opp+" "+enemeyScore+" - "+score+" Team13");
                    if(ScoreBoard!=null){
                    ScoreBoard.updateScore(score, enemeyScore);
                    }
                    ArrayList<Integer> states = new ArrayList<>();
                    states.add(0);
                    states.add(1);
                    states.add(2);
                    states.add(3);
                    states.add(13);
                    states.add(5);
                    Collections.shuffle(states);
                    String temp ="";
                    for(int i =0 ; i<states.size();i++)
                    {

                            if(i+1 == states.size())
                            {
                                temp = temp+states.get(i);
                            }
                            else
                            {
                                temp = temp+states.get(i)+",";
                            }

                    }
                    
                    masg.setContent("Team13 E "+temp+" "+score);
                    this.getAgent().send(masg);

                }                
                
            }
            else
            {
                ACLMessage masg = new ACLMessage(ACLMessage.INFORM);
                opp = arr[0];
                masg.addReceiver(new AID(arr[0],AID.ISLOCALNAME));
                ScoreBoard = new socreboard("Team13",opp,0,0);
                

                ArrayList<Integer> states = new ArrayList<>();
                states.add(0);
                states.add(1);
                states.add(2);
                states.add(3);
                states.add(13);
                states.add(5);
                Collections.shuffle(states);


                subNum = new ArrayList<Integer>();
                for(int i=0;i<states.size()-1;i++)
                {
                    subNum.add(states.get(i));
                }
                System.out.println(subNum);
                if(max(subNum)!=5)
                {
                    String temp = "";
                    for(int i =0 ; i<states.size();i++)
                    {
                        if(max(subNum)!=states.get(i))
                        {
                            if(i+1 == states.size())
                            {
                                temp = temp+states.get(i);
                            }
                            else
                            {
                                temp = temp+states.get(i)+",";
                            }
                        }
                    }
                    System.out.println(temp);
                    masg.setContent("Team13 H "+temp);
                    this.getAgent().send(masg);                
                }
                else
                {
                    masg = new ACLMessage(ACLMessage.INFORM);
                    masg.addReceiver(new AID(opp,AID.ISLOCALNAME));
                    score++;
                    System.out.println("Team13 Scored Goal!");
                    System.out.println("Score:\n"+opp+" "+enemeyScore+" - "+score+" Team13");
                    if(ScoreBoard!=null){
                    ScoreBoard.updateScore(score, enemeyScore);
                    }
                    states = new ArrayList<>();
                    states.add(0);
                    states.add(1);
                    states.add(2);
                    states.add(3);
                    states.add(13);
                    states.add(5);
                    Collections.shuffle(states);
                    String temp ="";
                    for(int i =0 ; i<states.size();i++)
                    {

                            if(i+1 == states.size())
                            {
                                temp = temp+states.get(i);
                            }
                            else
                            {
                                temp = temp+states.get(i)+",";
                            }

                    }
                    
                    masg.setContent("Team13 E "+temp+" "+score);
                    this.getAgent().send(masg);

                }

               
            }
                    
        
           }
        
        catch (NullPointerException e) {
            System.out.println("Message has not been received yet in team13");
            
        }
    }
        
    
    
    public int max(ArrayList<Integer> arr)
    {
        int temp=0;
        for(int i = 0;i<arr.size();i++)
        {
            if(temp<arr.get(i))
            {
                temp = arr.get(i);
            }
        }
        return temp;
    }
    public int min(ArrayList<Integer> arr)
    {
        int temp=8;
        for(int i = 0;i<arr.size();i++)
        {
            if(temp>arr.get(i))
            {
                temp = arr.get(i);
            }
        }
        return temp;
    }


    
}
