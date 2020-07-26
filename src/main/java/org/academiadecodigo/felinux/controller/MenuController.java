package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.view.UserOptions;
import java.util.Map;

public class MenuController extends AbstractController {

    private Map<Integer,Controller> controllerMap;
    private Controller exitController;

    public void setControllerMap ( Map<Integer, Controller> controllerMap ) {
        this.controllerMap = controllerMap;
    }

    public void setExitController (Controller exitController) {
        this.exitController = exitController;
    }

    public void optionHandler ( int userInput ) {

        if ( userInput == UserOptions.EXIT.getOption() ) {
            exitController.execute();
            return;
        }

        controllerMap.get(userInput).execute();

    }

}
