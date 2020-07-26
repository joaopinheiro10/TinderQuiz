package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.controller.GameController;
import org.academiadecodigo.felinux.model.client.Client;

import java.util.LinkedList;


public class ScoreView extends AbstractView {

    GameController gameController;


    @Override
    public void show() {

        LinkedList<Client> clients = gameController.getClients();

        for (Client client : clients) {
            printStream.print(Colors.CYAN + "\t" +
                    ( client.getName().length() < 7 ? client.getName() : client.getName().substring(0, 7) ) +
                    Colors.NOCOLOR);
        }
        printStream.println();

        for (Client client : clients) {
            printStream.print(Colors.PURPLE + "\t" + client.getNumberOfCorrectAnswers() + Colors.NOCOLOR);
        }
        printStream.println("\n\n");
    }


    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }
}
