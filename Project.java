/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Project {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        
        jade.core.Runtime run = jade.core.Runtime.instance(); 
        Profile p = new ProfileImpl("localhost", 1099, "Football cup");
        ContainerController main1 = run.createMainContainer(p);
        try{
            // How to create agent
            AgentController rma = main1.createNewAgent("jade", "jade.tools.rma.rma", null);
            rma.start();
            //second arg is the class name of agent i.e. for example project.agent1

            AgentController Team1 = main1.createNewAgent("Team1", "project.Team1", null);
            Team1.start();            
            AgentController Team2 = main1.createNewAgent("Team2", "project.Team2", null);
            Team2.start();

            AgentController Team3 = main1.createNewAgent("Team3", "project.Team3", null);
            Team3.start();
            AgentController Team4 = main1.createNewAgent("Team4", "project.Team4", null);
            Team4.start();
            AgentController Team5 = main1.createNewAgent("Team5", "project.Team5", null);
            Team5.start();            
            AgentController Team6 = main1.createNewAgent("Team6", "project.Team6", null);
            Team6.start();

            AgentController Team7 = main1.createNewAgent("Team7", "project.Team7", null);
            Team7.start();
            AgentController Team8 = main1.createNewAgent("Team8", "project.Team8", null);
            Team8.start();            
            AgentController Team9 = main1.createNewAgent("Team9", "project.Team9", null);
            Team9.start();            
            AgentController Team10 = main1.createNewAgent("Team10", "project.Team10", null);
            Team10.start();

            AgentController Team11 = main1.createNewAgent("Team11", "project.Team11", null);
            Team11.start();
            AgentController Team12 = main1.createNewAgent("Team12", "project.Team12", null);
            Team12.start();
            AgentController Team13 = main1.createNewAgent("Team13", "project.Team13", null);
            Team13.start();            
            AgentController Team14 = main1.createNewAgent("Team14", "project.Team14", null);
            Team14.start();

            AgentController Team15 = main1.createNewAgent("Team15", "project.Team15", null);
            Team15.start();
            AgentController Team16 = main1.createNewAgent("Team16", "project.Team16", null);
            Team16.start();
            AgentController CupOrganizer = main1.createNewAgent("CupOrganizer", "project.CupOrganizer", null);
            CupOrganizer.start();

            //Thread.sleep(1000);

            
            

                        
            
        }
        catch (StaleProxyException ex)
        {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
}
