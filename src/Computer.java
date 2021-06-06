/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticandtoe;

import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Computer {
    String computerName;
    String computerSymbol;
    static int f = 0;



    Computer() {
        computerName = "Dell";

    }
    int Computerturn(JButton[] boxes, String playersymbol) {

      
        int index2;
        
        int index = choosemove(boxes, computerSymbol, 3);
        Random random=new Random();

        // 1.computer searches for three symbols in a line(r,c) and tries to put fourth sign to win if possible
        if (index != -1) {
            if (!boxes[index].getText().equals("-")) {

                while (boxes[index].getText().equals(computerSymbol) || boxes[index].getText().equals(playersymbol)) {
                    index = random.nextInt(15 - 0 + 1) + 0;



                }
            }

            return index;

        }
        // 2.If it is not possible, computer tries to block upcoming fourth sign of opponent
        else {
            index = choosemove(boxes, playersymbol, 3);

            if (index != -1) {


                return index;

            } else {
                /* computer tries to attack by putting its third sign into a line.*/
                index = choosemove(boxes, computerSymbol, 2);
                index2 = checkforcomputersymbolalreadyintheline(boxes, computerSymbol, playersymbol, 2);

                if (index2 != -1 && index != -1) {

                    return index;



                } else {
                      /*computer blocks upcoming opponent`s third in a line. */
                    index = choosemove(boxes, playersymbol, 2);
                    index2 = checkforcomputersymbolalreadyintheline(boxes, playersymbol, computerSymbol, 2);
                    if (index2 != -1 && index != -1) {

                        return index;



                    }
                    else{
                        /*If there is no threat of third sign in a line, program decides to attack by putting the second sign */
                        index=choosemove(boxes, playersymbol, 3);
                         if(index==-1){  //there are not three symbol in any line 
                         
                            index2=choosemove(boxes, computerSymbol, 1);
                              if(index2!=-1){
                                  return index2;
                              
                              }
                              else{
                                     
                              return randomindex(boxes, playersymbol);
                              }
                         
                         }
                         else{
                          /*move randomly*/
                          return randomindex(boxes, playersymbol);
                         }
                    
                    
                    
                    
                    }
                  
                        

                    }

                }
            }

        }
    






    int randomindex(JButton[] boxes,String playersymbol){
        Random random = new Random();
     int  index = random.nextInt(15 - 0 + 1) + 0;

                        if (!boxes[index].getText().equals("-")) {

                            while (boxes[index].getText().equals(computerSymbol) || boxes[index].getText().equals(playersymbol)) {
                                index = random.nextInt(15 - 0 + 1) + 0;



                            }
                        }

                        return index;

    
    }
    int choosemove(JButton[] boxes, String symbol, int count) { //count is no of same row

        for (int i = 0; i < 16; i++) {

            if (boxes[i].getText().equals(symbol)) { //4 rows/columns will checkfor same 3 

                int rowcount = 0;

                int columncount = 0;

                int leftcrossSectioncount = 0;

                int rightcrossSectioncount = 0;


                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    for (int j = i; j < 4; j++) {
                        if (boxes[j].getText().equals(symbol)) {


                            rowcount = rowcount + 1;


                        }

                    }
                    for (int j = i; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol)) {

                            columncount++;


                        }

                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol)) {

                            leftcrossSectioncount++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol)) {

                            rightcrossSectioncount++;

                        }

                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 4; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }

                    if (value == true) {


                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 0; j < 4; j++)
                                if (boxes[j].getText().equals("-")) //- check for cell is empty or not
                                    return j;
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }

                    if (value == true) {
                        if (columncount == count) {

                            for (int j = i; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 5) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 15; k = k + 3) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }

                }

                if (i == 4 || i == 5 || i == 6 || i == 7) {

                    for (int j = i; j < 8; j++) {
                        if (boxes[j].getText().equals(symbol)) {

                            rowcount++;

                        }

                    }
                    for (int j = i - 4; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol)) {

                            columncount++;

                        }

                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol)) {

                            leftcrossSectioncount++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol)) {

                            rightcrossSectioncount++;

                        }

                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 4; k < 8; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 4; j < 8; j++)
                                if (boxes[j].getText().equals("-"))
                                    return j; // index where computer will put symbol to win   
                        }

                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i - 4; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (columncount == count) {

                            for (int j = i - 4; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 5) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 16; k = k + 3) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }

                    }
                }
                if (i == 8 || i == 9 || i == 10 || i == 11) {

                    for (int j = i; j < 12; j++) {
                        if (boxes[j].getText().equals(symbol)) {

                            rowcount++;

                        }

                    }
                    for (int j = i - 8; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol)) {

                            columncount++;

                        }

                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol)) {

                            leftcrossSectioncount++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol)) {

                            rightcrossSectioncount++;

                        }

                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 8; k < 12; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 8; j < 12; j++)
                                if (boxes[j].getText().equals("-"))
                                    return j; // index where computer will put symbol to win   
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i - 8; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (columncount == count) {

                            for (int j = i - 8; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 15; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }

                    }
                }
                if (i == 12 || i == 13 || i == 14 || i == 15) {
                    for (int j = i; j < 16; j++) {
                        if (boxes[j].getText().equals(symbol)) {

                            rowcount++;

                        }

                    }
                    for (int j = i - 12; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol)) {

                            columncount++;

                        }

                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol)) {

                            leftcrossSectioncount++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol)) {

                            rightcrossSectioncount++;

                        }

                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 12; k < 16; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 12; j < 16; j++)
                                if (boxes[j].getText().equals("-"))
                                    return j; // index where computer will put symbol to win   
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i - 12; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (columncount == count) {

                            for (int j = i - 12; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 5) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 15; k = k + 3) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-")) {
                                    return j;
                                }
                            }

                        }
                    }

                }
            }
        }

        return -1;
    }

    boolean checkforComputerWin(JButton[] boxes) {
        for (int i = 0; i < 16; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 12) { //from left to right check
                if (boxes[i].getText().equals(computerSymbol) && boxes[i + 1].getText().equals(computerSymbol)) {
                    if (boxes[i + 2].getText().equals(computerSymbol) && boxes[i + 3].getText().equals(computerSymbol)) {
                        JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }
            }
            if (i == 3 || i == 7 || i == 11 || i == 15) { //from right to left check
                if (boxes[i].getText().equals(computerSymbol) && boxes[i - 1].getText().equals(computerSymbol)) {
                    if (boxes[i - 2].getText().equals(computerSymbol) && boxes[i - 3].getText().equals(computerSymbol)) {
                        JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }

            }
            if (i == 0 || i == 1 || i == 2 || i == 3) { // from up to bottom
                if (boxes[i].getText().equals(computerSymbol) && boxes[i + 4].getText().equals(computerSymbol)) {
                    if (boxes[i + 8].getText().equals(computerSymbol) && boxes[i + 12].getText().equals(computerSymbol)) {
                     JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }

            }
            if (i == 12 || i == 13 || i == 14 || i == 15) { //from bottom to up
                if (boxes[i].getText().equals(computerSymbol) && boxes[i - 4].getText().equals(computerSymbol)) {
                    if (boxes[i - 8].getText().equals(computerSymbol) && boxes[i - 12].getText().equals(computerSymbol)) {
                       JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }

            }
            if (i == 3) { //cross section from upper right corner to bottom-left corner
                if (boxes[i].getText().equals(computerSymbol) && boxes[i + 3].getText().equals(computerSymbol)) {
                    if (boxes[i + 6].getText().equals(computerSymbol) && boxes[i + 9].getText().equals(computerSymbol)) {
                        JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }
            }
            if (i == 0) { //cross section from upper left corner to bottom-right corner
                if (boxes[i].getText().equals(computerSymbol) && boxes[i + 5].getText().equals(computerSymbol)) {
                    if (boxes[i + 10].getText().equals(computerSymbol) && boxes[i + 15].getText().equals(computerSymbol)) {
                        JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }
            }
            if (i == 12) { // from bottom-left to upper right
                if (boxes[i].getText().equals(computerSymbol) && boxes[i - 3].getText().equals(computerSymbol)) {
                    if (boxes[i - 6].getText().equals(computerSymbol) && boxes[i - 9].getText().equals(computerSymbol)) {
                     JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }

            }
            if (i == 15) {
                if (boxes[i].getText().equals(computerSymbol) && boxes[i - 5].getText().equals(computerSymbol)) {
                    if (boxes[i - 10].getText().equals(computerSymbol) && boxes[i - 15].getText().equals(computerSymbol)) {
                        JOptionPane.showMessageDialog(null, computerName+" Win");
                        return true;
                    }
                }

            }
        }

        return false;
    }

    int checkforcomputersymbolalreadyintheline(JButton[] boxes, String symbol1, String symbol2, int count) {
        for (int i = 0; i < 16; i++) {

            if (boxes[i].getText().equals(symbol1)) { //4 rows/columns will checkfor same 3 

                int rowcount = 0;
                int rowcount2 = 0;
                int columncount = 0;
                int columncount2 = 0;
                int leftcrossSectioncount = 0;
                int lefcrossSectioncount2 = 0;
                int rightcrossSectioncount = 0;
                int rightcrossSectioncount2 = 0;


                if (i == 0 || i == 1 || i == 2 || i == 3) {
                    for (int j = i; j < 4; j++) {
                        if (boxes[j].getText().equals(symbol1)) {


                            rowcount = rowcount + 1;


                        }
                        if (boxes[j].getText().equals(symbol2)) {
                            rowcount2++;

                        }

                    }
                    for (int j = i; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol1)) {

                            columncount++;


                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            columncount2++;


                        }


                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol1)) {

                            leftcrossSectioncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            lefcrossSectioncount2++;


                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol1)) {

                            rightcrossSectioncount++;


                            if (boxes[j].getText().equals(symbol2)) {

                                rightcrossSectioncount2++;


                            }

                        }
                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 4; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }

                    if (value == true) {

                        if (rowcount == count && rowcount2 == 1) {
                            return -1;
                        }
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 0; j < 4; j++)
                                if (boxes[j].getText().equals("-")) //- check for cell is empty or not
                                    return j;
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }

                    if (value == true) {
                        if (columncount == count && columncount2 == 1) {
                            return -1;
                        }
                        if (columncount == count) {

                            for (int j = i; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 5) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count && lefcrossSectioncount2 == 1) {
                            return -1;
                        }
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }

                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 15; k = k + 3) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count && rightcrossSectioncount2 == 1) {
                            return -1;
                        }
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }

                }

                if (i == 4 || i == 5 || i == 6 || i == 7) {

                    for (int j = i; j < 8; j++) {
                        if (boxes[j].getText().equals(symbol1)) {

                            rowcount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            rowcount2++;

                        }

                    }
                    for (int j = i - 4; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol1)) {

                            columncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            columncount2++;

                        }


                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol1)) {

                            leftcrossSectioncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            lefcrossSectioncount2++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol1)) {

                            rightcrossSectioncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            rightcrossSectioncount2++;

                        }

                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 4; k < 8; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rowcount == count && rowcount2 == 1) {
                            return -1;

                        }
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 4; j < 8; j++)
                                if (boxes[j].getText().equals("-"))
                                    return j; // index where computer will put symbol to win   
                        }

                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i - 4; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (columncount == count && columncount2 == 1) {
                            return -1;

                        }
                        if (columncount == count) {

                            for (int j = i - 4; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 5) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count && lefcrossSectioncount2 == 1) {
                            return -1;

                        }
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 16; k = k + 3) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count && rightcrossSectioncount2 == 1) {
                            return -1;

                        }
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }

                    }
                }
                if (i == 8 || i == 9 || i == 10 || i == 11) {

                    for (int j = i; j < 12; j++) {
                        if (boxes[j].getText().equals(symbol1)) {

                            rowcount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            rowcount2++;

                        }


                    }
                    for (int j = i - 8; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol1)) {

                            columncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            columncount2++;

                        }

                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol1)) {

                            leftcrossSectioncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            lefcrossSectioncount2++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol1)) {

                            rightcrossSectioncount++;

                        }

                        if (boxes[j].getText().equals(symbol2)) {

                            rightcrossSectioncount2++;

                        }
                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 8; k < 12; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rowcount == count && rowcount2 == 1) {
                            return -1;

                        }
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 8; j < 12; j++)
                                if (boxes[j].getText().equals("-"))
                                    return j; // index where computer will put symbol to win   
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i - 8; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (columncount == count && columncount2 == 1) {
                            return -1;

                        }
                        if (columncount == count) {

                            for (int j = i - 8; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count && lefcrossSectioncount2 == 1) {
                            return -1;

                        }
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 15; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count && rightcrossSectioncount2 == 1) {
                            return -1;

                        }
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }

                    }
                }
                if (i == 12 || i == 13 || i == 14 || i == 15) {
                    for (int j = i; j < 16; j++) {
                        if (boxes[j].getText().equals(symbol1)) {

                            rowcount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            rowcount2++;

                        }

                    }
                    for (int j = i - 12; j < 16; j = j + 4) {


                        if (boxes[j].getText().equals(symbol1)) {

                            columncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            columncount2++;

                        }

                    }
                    for (int j = 0; j < 16; j = j + 5) {


                        if (boxes[j].getText().equals(symbol1)) {

                            leftcrossSectioncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            lefcrossSectioncount2++;

                        }

                    }
                    for (int j = 3; j < 15; j = j + 3) {


                        if (boxes[j].getText().equals(symbol1)) {

                            rightcrossSectioncount++;

                        }
                        if (boxes[j].getText().equals(symbol2)) {

                            rightcrossSectioncount2++;

                        }

                    }
                    boolean value = false;
                    //computer symbol in same line 
                    for (int k = 12; k < 16; k++) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rowcount == count && rowcount2 == 1) {
                            return -1;
                        }
                        if (rowcount == count) { // found 3 common symbol in row 
                            for (int j = 12; j < 16; j++)
                                if (boxes[j].getText().equals("-"))
                                    return j; // index where computer will put symbol to win   
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = i - 12; k < 16; k = k + 4) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (columncount == count && columncount2 == 1) {
                            return -1;
                        }
                        if (columncount == count) {

                            for (int j = i - 12; j < 16; j = j + 4) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }
                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 0; k < 16; k = k + 5) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (leftcrossSectioncount == count && lefcrossSectioncount2 == 1) {
                            return -1;
                        }
                        if (leftcrossSectioncount == count) {
                            for (int j = 0; j < 16; j = j + 5) {

                                if (boxes[j].getText().equals("-"))
                                    return j;
                            }

                        }
                    }
                    value = false;
                    //computer symbol in same line 
                    for (int k = 3; k < 15; k = k + 3) {
                        if (boxes[k].getText().equals("-")) { //check for  empty cell

                            value = true;

                        }
                    }
                    if (value == true) {
                        if (rightcrossSectioncount == count && rightcrossSectioncount2 == 1) {
                            return -1;
                        }
                        if (rightcrossSectioncount == count) {
                            for (int j = 3; j < 15; j = j + 3) {

                                if (boxes[j].getText().equals("-")) {
                                    return j;
                                }
                            }

                        }
                    }

                }
            }
        }

        return -1;
    }
}