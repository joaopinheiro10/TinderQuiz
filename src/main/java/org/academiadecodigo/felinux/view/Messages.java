package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.utilits.ASCIIArtGenerator;
import org.academiadecodigo.felinux.utilits.RectangleBoxText;


public class Messages {
    /**
     * Menu options messages
     */

    public static final String WELCOME = Colors.GREEN + "\n\n" +
            ASCIIArtGenerator.printTextArt("Welcome To Tinder Quiz", 10)
            + Colors.NOCOLOR;

    public static final String MENU_VIEW = Colors.BLUE + "Please choose an option:" + Colors.NOCOLOR;
    public static final String MENU_VIEW_ERROR = Colors.YELLOW + "Invalid option." + Colors.NOCOLOR;

    public static final String WAITING_FOR_PLAYERS = Colors.YELLOW + "The game will start when all players are ready.\n" +
            "Please wait." + Colors.NOCOLOR;

    public static final String RIGHT = Colors.GREEN  + "Great Success" + Colors.NOCOLOR;
    public static final String WRONG = Colors.RED + "Google that next time" + Colors.NOCOLOR;
    public static final String USERNAME = Colors.BLUE + "Username: " + Colors.NOCOLOR;
    public static final String PHONE_NUMBER =Colors.BLUE + "What's your phone number: " + Colors.NOCOLOR;
    public static final String CURRENT_QUESTION = "This is the current question: ";


    /**
     * Game messages
     */
    public static final String STARTGAME = "Start Game";
    public static final String INSTRUCTIONS = "Instructions";
    public static final String EXIT = "Quit";

    public static final String WAITING = " turn now, please wait...";


    public static final String GAMERULES = Colors.BLUE +  RectangleBoxText.printText("These are the game rules:\n" +
            "\n1-Minimum 2, Maximum 4 players;\n" +
            "2-Player credentials: username, contact (optional)\n" +
            "3-Question: Right, don't \"drink\" and move on to the next. \n" +
            "Fail, drink, move on to the next; (Everyone sees a question and an answer)\n" +
            "4-Bonus round at the end of each round\n" +
            "5-The game ends after x rounds (one being selected at the beginning - with minimum and maximum)\n" +
            "6-After the end, verification or correspondence (scoring interval) between the players\n" +
            "7-Chat idea - style bar (optional)", 100, 15) + Colors.NOCOLOR;

    public static final String WAITINGCONNECTIONS = Colors.BLUE + "Waiting to save someone's life." + Colors.NOCOLOR;
}

