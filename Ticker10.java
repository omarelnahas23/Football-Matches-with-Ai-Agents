/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class Ticker10 extends TickerBehaviour{

    public Ticker10(Agent a, long period) {
        super(a, period);
    }
    boolean flag=false;
    int score = 0;
    int enemeyScore = 0;
    static String opp = "";
    socreboard ScoreBoard;
    ContainerController main1 = this.getAgent().getContainerController();
    int t = 0;
    @Override
    protected void onTick() {
        System.out.println("We are in Behaviour of team 10");
        
        if(ScoreBoard != null && t < 5)
        {
            ScoreBoard.UpdateTime();
            t+=1;
            
        }
        else if(t>=5)
        {
            if(score>enemeyScore)
            {
                System.err.println("Team 10 Wins");
                try{

                        AgentController Team2 = main1.getAgent(opp);
                        Team2.kill();
                        AgentController Team1 = main1.getAgent("Team10");
                        Team1.suspend();
                        mainScore sc = new mainScore("Team10", opp, score, enemeyScore);
                        sc.updateScore("Team10", opp, score, enemeyScore);

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

                        AgentController Team1 = main1.getAgent("Team10");
                        Team1.kill();            
                        AgentController Team2 = main1.getAgent(opp);
                        Team2.suspend();
                        mainScore sc = new mainScore("Team10", opp, score, enemeyScore);
                        sc.updateScore("Team10", opp, score, enemeyScore);
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
        System.out.println("Content recieved for team10 ");
        System.out.println(Arrays.toString(s.split(" ")));
        String[] arr = s.split(" ");
        
        boolean check = false;
        boolean EnemeyGoal = false;
        for(int i = 0 ; i<arr.length;i++)
        {
            if(arr[i].charAt(0) == 'H' || arr[i].charAt(0) == 'E' )
            {
                check = true;
            }

            if(arr[0].charAt(0)=='f')
            {
                check = true;
            }            
        }

            if(check)
            {
                opp = arr[0];
                
                System.out.println("Call back from "+opp+"\nContent:");
                System.out.println(msg.getContent());
                
                arr = msg.getContent().split(" ");
                if(arr.length>3)
                {
                    enemeyScore = Integer.parseInt(arr[3]);
                }
                arr = arr[2].split(",");
                ArrayList<Integer> Num = new ArrayList<>();
                for(int i=0;i<arr.length;i++ )
                {
                    Num.add(Integer.parseInt(arr[i]));
                }
                Collections.shuffle(Num);
                ArrayList<Integer> subNum = new ArrayList<Integer>();
                if(Num.size()>2)
                {
                    for(int i=0;i<Num.size()-1;i++)
                    {
                        subNum.add(Num.get(i));
                    }

                }
                else
                {
                    for(int i=0;i<Num.size();i++)
                    {
                        subNum.add(Num.get(i));
                    }
                }
                if(min(subNum)!=0)
                {
                    String temp = "";
                    for(int i =0 ; i<Num.size();i++)
                    {
                        if(min(subNum)!=Num.get(i))
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
                    System.out.println(temp);
                    ACLMessage masg = new ACLMessage(ACLMessage.INFORM);
                    masg.addReceiver(new AID(opp,AID.ISLOCALNAME));
                    masg.setContent("Team10 H "+temp);
                    this.getAgent().send(masg);                
                }
                else
                {
                    ACLMessage masg = new ACLMessage(ACLMessage.INFORM);
                    masg.addReceiver(new AID(opp,AID.ISLOCALNAME));
                    score++;
                    System.out.println("Team10 Scored Goal!");
                    System.out.println("Score:\nTeam10 "+score+" - "+enemeyScore+" "+opp);
                    if(ScoreBoard!=null){
                    ScoreBoard.updateScore(score, enemeyScore);
                    }
                    ArrayList<Integer> states = new ArrayList<Integer>();
                    states.add(0);
                    states.add(1);
                    states.add(2);
                    states.add(3);
                    states.add(4);
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
                    
                    masg.setContent("Team10 H "+temp+" "+score);
                    this.getAgent().send(masg);
                }


            }
            else
            {
                ACLMessage masg = new ACLMessage(ACLMessage.INFORM);
                opp = arr[0];
                masg.addReceiver(new AID(arr[0],AID.ISLOCALNAME));
                ScoreBoard = new socreboard("Team10",opp,0,0);
                
                ArrayList<Integer> states = new ArrayList<>();
                states.add(0);
                states.add(1);
                states.add(2);
                states.add(3);
                states.add(4);
                states.add(5);
                Collections.shuffle(states);

                ArrayList<Integer> subNum = new ArrayList<Integer>();
                for(int i=0;i<states.size()-1;i++)
                {
                    subNum.add(states.get(i));
                }
                
                if(min(subNum)!=0)
                {
                    String temp = "";
                    for(int i =0 ; i<states.size();i++)
                    {
                        if(min(subNum)!=states.get(i))
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
                    masg.setContent("Team10 H "+temp);
                    this.getAgent().send(masg);                
                }
                else
                {
                    masg = new ACLMessage(ACLMessage.INFORM);
                    masg.addReceiver(new AID(opp,AID.ISLOCALNAME));
                    score++;
                    System.out.println("Team10 Scored Goal!");
                    System.out.println("Score:\nTeam10 "+score+" - "+enemeyScore+" "+opp);
                    if(ScoreBoard!=null){
                    ScoreBoard.updateScore(score, enemeyScore);
                    }
                    states = new ArrayList<>();
                    states.add(0);
                    states.add(1);
                    states.add(2);
                    states.add(3);
                    states.add(4);
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
 
                    
                    masg.setContent("Team10 H "+temp+" "+score);
                    this.getAgent().send(masg);
                }


            }
        
        
        }
        catch (NullPointerException e) {
            System.out.println("Message has not been received yet in team 10");
            
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
