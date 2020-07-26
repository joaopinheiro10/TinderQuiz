package org.academiadecodigo.felinux.view;

public enum UserOptions {

    START_GAME(1,Messages.STARTGAME),
    INSTRUCTIONS(2,Messages.INSTRUCTIONS),
    EXIT(3,Messages.EXIT);

    private int option;
    private String message;

    UserOptions(int option, String message) {
        this.option = option;
        this.message = message;
    }

    public static String[] getMessages(){
        String [] messages = new String[values().length] ;
        for (UserOptions userOptions : values()) {
            messages[userOptions.getOption()-1] = userOptions.getMessage();
        }
        return  messages;
    }

    public int getOption() {
        return option;
    }

    public String getMessage() {
        return message;
    }
}
