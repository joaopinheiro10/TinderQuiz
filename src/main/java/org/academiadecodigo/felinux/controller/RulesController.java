package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.Messages;

import java.util.Map;

public class RulesController extends AbstractController {

    private Controller nextController;

    public void setNextController ( Controller nextController ) {
        this.nextController = nextController;
    }

    @Override
    public void execute() {
        super.execute();
        nextController.execute();
    }


}
