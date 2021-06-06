/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
package ticandtoe;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Player {
    String playerName;
    String playerSymbolChoose;

    public Player(String playerName, String playerSymbolChoose) {
        this.playerName = playerName;
        this.playerSymbolChoose = playerSymbolChoose;
    }

    Player() {

    }
    void checkForPlayerWin(JButton[] boxes) {
        for (int i = 0; i < 16; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 12) { //from left to right check
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i + 1].getText().equals(playerSymbolChoose)) {
                    if (boxes[i + 2].getText().equals(playerSymbolChoose) && boxes[i + 3].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win");
                        break;
                    }
                }
            }
            if (i == 3 || i == 7 || i == 11 || i == 15) { //from right to left check
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i - 1].getText().equals(playerSymbolChoose)) {
                    if (boxes[i - 2].getText().equals(playerSymbolChoose) && boxes[i - 3].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }

            }
            if (i == 0 || i == 1 || i == 2 || i == 3) { // from up to bottom
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i + 4].getText().equals(playerSymbolChoose)) {
                    if (boxes[i + 8].getText().equals(playerSymbolChoose) && boxes[i + 12].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }

            }
            if (i == 12 || i == 13 || i == 14 || i == 15) { //from bottom to up
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i - 4].getText().equals(playerSymbolChoose)) {
                    if (boxes[i - 8].getText().equals(playerSymbolChoose) && boxes[i - 12].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }

            }
            if (i == 3) { //cross section from upper right corner to bottom-left corner
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i + 3].getText().equals(playerSymbolChoose)) {
                    if (boxes[i + 6].getText().equals(playerSymbolChoose) && boxes[i + 9].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }
            }
            if (i == 0) { //cross section from upper left corner to bottom-right corner
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i + 5].getText().equals(playerSymbolChoose)) {
                    if (boxes[i + 10].getText().equals(playerSymbolChoose) && boxes[i + 15].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }
            }
            if (i == 12) { // from bottom-left to upper right
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i - 3].getText().equals(playerSymbolChoose)) {
                    if (boxes[i - 6].getText().equals(playerSymbolChoose) && boxes[i - 9].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }

            }
            if (i == 15) {
                if (boxes[i].getText().equals(playerSymbolChoose) && boxes[i - 5].getText().equals(playerSymbolChoose)) {
                    if (boxes[i - 10].getText().equals(playerSymbolChoose) && boxes[i - 15].getText().equals(playerSymbolChoose)) {
                        JOptionPane.showMessageDialog(null, "Player Win ");
                        break;
                    }
                }

            }
        }


    }
    
    boolean checkForDraw(JButton[] boxes) {
        for (int i = 0; i < 16; i++) {
            if (boxes[i].getText().equals("-"))
                return false;
        }
        return true;
    }
}