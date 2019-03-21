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

/**
 *
 * @author Farid
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Input {

    public ArrayList<Field> fields;
    public ArrayList<Player> players;
    public ArrayList<Integer> dices;
    

    public Input() {
        fields = new ArrayList<>();
        players = new ArrayList<>();
        dices = new ArrayList<>();
    }

    public void read(String filename) throws FileNotFoundException, InvalidInputException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)));
        int numFields = sc.nextInt();
        for (int i = 0; i < numFields; i++) {
            Field field;
            String temp = sc.next();
            switch (temp) {
                case "P":
                    field = new Property(temp);
                    break;
                case "S":
                    field = new Service(temp);
                    break;
                case "L":
                    field = new Lucky (temp);
                    break;
                default:
                    throw new InvalidInputException();
                    
            }
           
            fields.add(field);
        }
        
        
             int numPlayers = sc.nextInt();
            for (int i = 0; i < numPlayers; i++) {
            Player player;
            String temp1 = sc.next();
            switch (temp1) {
                case "G":
                    player = new Greedy(temp1);
                    break;
                case "T":
                    player = new Tactical(temp1);
                    break;
                case "C":
                    player = new Careful(temp1);
                    break;
                default:
                    throw new InvalidInputException();
            }
                players.add(player);
        }
            
            while (sc.hasNextInt()) {
            int dice = sc.nextInt(); 
            dices.add(dice);
        }
       
    }
    
    
}
    
