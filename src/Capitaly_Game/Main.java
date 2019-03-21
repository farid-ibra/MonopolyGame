// Farid Ibrahimli
//
// DQWMYW
//
// First PSE Assignment Capitaly Game
//
// 2018/10/15 16:38:23
//
// This solution was submitted and prepared by Farid Ibrahimli, DQWMYW for the
// First PSE Assignment Capitaly Game assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capitaly_Game;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Farid
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Input input = new Input();

        try {
            input.read("data.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //******************************************************************************************************************
        int k = 0;
        
        int j ;
        
        for (int i = 0; i < input.dices.size(); i++) {
            
            j = i % input.players.size();
            
            k = input.players.get(j).rightNowPlace(k, i, input.dices.get(i), input.fields.size());//k = (k + input.dices.get(i)) % input.fields.size();
            
            if ("G".equals(input.players.get(j).strategy) && "L".equals(input.fields.get(k).type)) {
            
                input.players.get(j).increaseCash(500);
            
            } else if ("C".equals(input.players.get(j).strategy) && "L".equals(input.fields.get(k).type)) {
            
                input.players.get(j).increaseCash(500);
            
            
            } else if ("T".equals(input.players.get(j).strategy) && "L".equals(input.fields.get(k).type)) {
            
                input.players.get(j).increaseCash(500);
            
            } //****************************************************************************************************************************   
            
            else if ("G".equals(input.players.get(j).strategy) && "S".equals(input.fields.get(k).type) && input.players.get(j).cash > 0) {
            
                input.players.get(j).reduceCash(800);
            
            } else if ("C".equals(input.players.get(j).strategy) && "S".equals(input.fields.get(k).type) && input.players.get(j).cash > 0) {
            
                input.players.get(j).reduceCash(800);
            
            } else if ("T".equals(input.players.get(j).strategy) && "S".equals(input.fields.get(k).type) && input.players.get(j).cash > 0) {
            
                input.players.get(j).reduceCash(800);
            
            } //*****************************************************************************************************************************   
            
            else if ("G".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 0) {
            
                input.players.get(j).reduceCash(1000);
               
                input.fields.get(k).takenOrNot = 1;
                
                input.players.get(j).OwnedFields.add(input.fields.get(k));
            
            } else if ("G".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 1
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == true) {
                
                input.players.get(j).reduceCash(4000);
                
                input.fields.get(k).takenOrNot = 2;
            } else if ("G".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 1
               
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).reduceCash(500);
            
            } else if ("G".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 2
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).reduceCash(2000);
            
            } else if ("G".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash < 500 && input.fields.get(k).takenOrNot == 1
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).losingFields(input.players.get(j).OwnedFields);
            
            } else if ("G".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash < 2000 && input.fields.get(k).takenOrNot == 2
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).losingFields(input.players.get(j).OwnedFields);
            
            } //*********************************************************************************************************************************
            
            else if ("C".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash >= 2000 && input.fields.get(k).takenOrNot == 0) {
            
                input.players.get(j).reduceCash(1000);
                
                input.fields.get(k).takenOrNot = 1;
                
                input.players.get(j).OwnedFields.add(input.fields.get(k)); 
            
            } else if ("C".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash >= 8000 && input.fields.get(k).takenOrNot == 1
                   
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == true) {
                
                input.players.get(j).reduceCash(4000);
                
                input.fields.get(k).takenOrNot = 2;
            
            } else if ("C".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 1
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).reduceCash(500);
            
            } else if ("C".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 2
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).reduceCash(2000);
            
            } else if ("C".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash < 500 && input.fields.get(k).takenOrNot == 1
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).losingFields(input.players.get(j).OwnedFields);
            
            } else if ("C".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash < 2000 && input.fields.get(k).takenOrNot == 2
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).losingFields(input.players.get(j).OwnedFields);
            
            }
            
//**********************************************************************************************************************************************************

            int first = 0;
            
            if ("T".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 0
                    && input.players.get(j).isFirstBuying(first) == true) {
            
                input.players.get(j).reduceCash(1000);
                
                input.fields.get(k).takenOrNot = 1;
                
                input.players.get(j).OwnedFields.add(input.fields.get(k)); 
            
            } else if ("T".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 1
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == true && input.players.get(j).isFirstBuying(first) == true) {
            
                input.players.get(j).reduceCash(4000);
                
                input.fields.get(k).takenOrNot = 2;
            
            } else if ("T".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 1
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).reduceCash(500);
            
            } else if ("T".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash > 0 && input.fields.get(k).takenOrNot == 2
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).reduceCash(2000);
            
            } else if ("T".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash < 500 && input.fields.get(k).takenOrNot == 1
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).losingFields(input.players.get(j).OwnedFields);
            
            } else if ("T".equals(input.players.get(j).strategy) && "P".equals(input.fields.get(k).type) && input.players.get(j).cash < 2000 && input.fields.get(k).takenOrNot == 2
            
                    && input.fields.get(k).hasHouse(input.fields.get(k), input.players.get(j).OwnedFields) == false) {
                
                input.players.get(j).losingFields(input.players.get(j).OwnedFields);
            
            }
            if((i+1) % input.players.size()==0){
            
                for (int l = 0; l < input.players.size(); l++) {
                    
                
            System.out.println((l+1) + "th player's balance is " + input.players.get(l).cash);
            
          
                    
                System.out.println((l+1) + "th player's owned properties are ");
                
                for (int a = 0; a < input.players.get(l).OwnedFields.size(); a++) {
                    if(input.players.get(l).OwnedFields.size() >0)
                    System.out.println(input.players.get(l).OwnedFields.get(a).type);
                
                }
            }
                }
           
        } 
    }
}
