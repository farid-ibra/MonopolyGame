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
public abstract class Field {

    public Field(String type) {
        this.type = type;
        this.takenOrNot = 0;
    }

    String type;
    int takenOrNot;
    
    public String getType() {
        return type;
    }

    public boolean hasHouse(Field a, ArrayList<Field> f){ //the method for checking if there is a house already built in a property or not
    boolean exist = false;
        for (int i = 0; i < f.size(); i++) {
            if(a == f.get(i))
                exist=true;
        }
        return exist;
    }
}
