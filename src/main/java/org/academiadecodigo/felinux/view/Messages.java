package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.utilits.ASCIIArtGenerator;
import org.academiadecodigo.felinux.utilits.RectangleBoxText;

import java.awt.*;


public class Messages {
    /**
     * Menu options messages
     * */

    public static final String WELCOME = ASCIIArtGenerator.printTextArt("Welcome To Tinder Quiz",10);
    public static final String INSTRUCTIONS = "Instructions";
    public static final String EXIT = "Quit";

    public static final String MENU_VIEW = "Please choose an option.";
    public static final String MENU_VIEW_ERROR = "Invalid option.";

    public static final String RIGHT = "RIGHT";
    public static final String  WRONG= "WRONG";

    /**
     * Game messages
     * */
    public static final String STARTGAME = "Game start";
    public static final String ANSWER = "Instructions";
    public static final String WAITING = "Other player's turn";


    public static final String GAMERULES =  RectangleBoxText.printText("These are the game rules:\n" +
            "\n1-Minimum 2, Maximum 4 players;\n" +
            "2-Player credentials: username, contact (optional)\n" +
            "3-Question: Right, don't \"drink\" and move on to the next. \n" +
            "Fail, drink, move on to the next; (Everyone sees a question and an answer)\n" +
            "4-Bonus round at the end of each round\n" +
            "5-The game ends after x rounds (one being selected at the beginning - with minimum and maximum)\n" +
            "6-After the end, verification or correspondence (scoring interval) between the players\n" +
            "7-Chat idea - style bar (optional)", 100, 15);
}

