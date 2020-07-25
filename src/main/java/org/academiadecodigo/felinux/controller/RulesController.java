package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.Messages;

import java.util.Map;

public class RulesController extends AbstractController {

    private Map<String, Controller> controllerMap;

    @Override
    public void execute() {
        super.execute();

    }

    public void receiveInput(String option) {
        if (option == Messages.EXIT) {
            return;
        }

        if (!controllerMap.containsKey(option)) {
            throw new IllegalStateException(Messages.MENU_VIEW_ERROR);
        }

        //controllerMap.get(option);
    }

}
