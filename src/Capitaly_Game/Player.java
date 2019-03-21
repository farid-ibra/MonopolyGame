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

import java.util.ArrayList;

/**
 *
 * @author Farid
 */
public abstract class Player {
    String strategy;
    int cash;
    ArrayList<Field>OwnedFields = new ArrayList<Field>();

    public Player(String strategy) {
        this.strategy = strategy;
        this.cash = 10000;
    }

    public String getStrategy() {
        return strategy;
    }
    
    
    
    public void buyField(int value,int takenOrNot){ //the method for for buying property
        this.cash = this.cash - value;
        takenOrNot = 1;
    }
    
    public void reduceCash(int value) { //the method for reduce cash in case of buying property or house, or pay rent or pay for service field.
        this.cash = this.cash - value;
    }
    
    public void increaseCash(int value){ //the method for increase cash in case of get rent or get money from lucky field
        this.cash = this.cash + value;
    }
    
    public void losingFields(ArrayList<Field> f){ //the method for making free the properties that bought when the owner player has lost the game
        for (int i = 0; i < f.size(); i++) {
            f.get(i).takenOrNot = 0;
        }
    }
    public boolean isFirstBuying(int first){ // the method for checking if there is a house in the bought property. if it is free then the owner player can built a house on it
    boolean yes = true;
        if(first==1) {yes=false; first=0;}
     return yes;
    }
    
    public int rightNowPlace(int k,int i,int a,int b){ //the method that store player's position from previous round.
    k = (k + a) % b;
    return k;
    }
}
