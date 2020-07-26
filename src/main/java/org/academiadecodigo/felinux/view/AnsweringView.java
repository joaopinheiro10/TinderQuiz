package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.AnsweringController;

public class AnsweringView extends AbstractView{

    AnsweringController answeringController;

    public void setAnsweringController(AnsweringController answeringController) {
        this.answeringController = answeringController;
    }

    @Override
    public void show() {
        StringInputScanner scanner = new StringInputScanner();

        printStream.println(Colors.GREEN + answeringController.getGameController().getCurrentPlayerName() + Messages.QUESTION);
        scanner.setMessage(answeringController.getGameController().getQuestion());
        printStream.println(Messages.CURRENT_ROUND + answeringController.getGameController().getRoundNumber());
        answeringController.validateAnswer(prompt.getUserInput(scanner));
    }
}
