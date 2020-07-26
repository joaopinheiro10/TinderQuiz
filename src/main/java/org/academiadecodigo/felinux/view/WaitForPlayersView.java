package org.academiadecodigo.felinux.view;

public class WaitForPlayersView extends AbstractView {
    @Override
    public void show() {

        printStream.println(Colors.YELLOW +  Messages.WAITING_FOR_PLAYERS);
    }
}
