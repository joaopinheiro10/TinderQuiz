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
        System.out.println("View Answer");
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage(answeringController.getGameController().getQuestion());
        scanner.setError("");
       answeringController.validateAnswer(prompt.getUserInput(scanner));
        if (answeringController.isAnswer()) {
            printStream.println(Messages.RIGHT);
        } else {
            printStream.println(Messages.WRONG);
        }
    }
}
