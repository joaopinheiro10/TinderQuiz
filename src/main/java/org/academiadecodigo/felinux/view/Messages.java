package org.academiadecodigo.felinux.view;


import org.academiadecodigo.felinux.utilits.PseudoTex;
import org.academiadecodigo.felinux.utilits.RectangleBoxText;


public class Messages {
    /**
     * Menu options messages
     */

    public static final String WELCOME = Colors.GREEN +
            PseudoTex.printText("Tinder Quiz", 10)
            + Colors.NOCOLOR;

    public static final String CONNECTED = "Connected to IP: ";
    public static final String PORT = " at Port: ";

    public static final String MENU_VIEW = Colors.BLUE + "Please choose an option:" + Colors.NOCOLOR;
    public static final String MENU_VIEW_ERROR = Colors.YELLOW + "Invalid option." + Colors.NOCOLOR;

    public static final String WAITING_FOR_PLAYERS = Colors.YELLOW + "The game will start when all players are ready.\n" +
            "Please wait." + Colors.NOCOLOR;

    public static final String[] OPTIONS = {"Go Back."};

    public static final String QUESTION = Colors.BLUE + " is your turn: " + Colors.NOCOLOR;
    public static final String RIGHT = Colors.GREEN  + " got the right answer." + Colors.NOCOLOR;
    public static final String WRONG = Colors.RED + " failed the answer, Google it next time. But now DRINK!" + Colors.NOCOLOR;
    public static final String USERNAME = Colors.BLUE + "Insert your name: " + Colors.NOCOLOR;
    public static final String PHONE_NUMBER =Colors.BLUE + "What's your phone number: " + Colors.NOCOLOR;
    public static final String PHONE_NUMBER_WRONG =Colors.RED + "Please insert a valid phone number (p.ex: 9********)" + Colors.NOCOLOR;


    public static final String CURRENT_QUESTION = Colors.BLUE + "Current question is: " + Colors.NOCOLOR;
    public static final String CURRENT_ROUND = "\n" + Colors.BLUE + "CURRENT ROUND: " + Colors.NOCOLOR;
    public static final String ANSWER_WAS = Colors.BLUE + " answered this: " + Colors.NOCOLOR;

    /**
     * Game messages
     */
    public static final String STARTGAME = "Start Game";
    public static final String INSTRUCTIONS = "Instructions";
    public static final String EXIT = "Quit";

    public static final String WAITING = Colors.YELLOW + " turn now, please wait..." + Colors.NOCOLOR;


    public static final String GAMERULES = Colors.BLUE + RectangleBoxText.printText("These are the game rules:\n" +
                    "\n1- 4 Players\n" +
                    "2- Each round every player receives a question\n" +
                    "3- If you answer it right, don't drink and move on to the next \n" +
                    "4- If you fail, drink, move on to the next\n" +
                    "5- The game ends after 10 rounds\n" +
                    "6- After the end, game checks if you matched with someone\n"
            , 100, 15) + Colors.NOCOLOR;

    public static final String WAITINGCONNECTIONS = Colors.BLUE + "Waiting to save someone's life." + Colors.NOCOLOR;

    public static final String NO_MATCH = Colors.RED + "You have no matches! Loser." + Colors.NOCOLOR;
    public static final String MATCH = Colors.GREEN + "YOU HAVE A MATCH WITH THE FOLLOWING PLAYERS: \n\n" + Colors.NOCOLOR;
    public static final String AVERAGE = Colors.BLUE + "You're an average person and still got no matches, how's that like?" + Colors.NOCOLOR;
    public static final String GENIUS = Colors.CYAN + "You're so smart that you have no matches. Dumb it down, please" + Colors.NOCOLOR;
}
