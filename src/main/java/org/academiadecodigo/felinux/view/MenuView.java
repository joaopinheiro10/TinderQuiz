package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.felinux.controller.MenuController;
import org.academiadecodigo.felinux.server.Server;

public class MenuView extends AbstractView {

    private MenuController menuController;
    private Server server;

    public void setMenuController(MenuController menuController) {
        this.menuController = menuController;
    }

    public void setServer ( Server server ) {
        this.server = server;
    }

    @Override
    public void show() {

        MenuInputScanner menuScanner = new MenuInputScanner(UserOptions.getMessages());
        menuScanner.setMessage(Messages.MENU_VIEW);
        menuScanner.setError(Messages.MENU_VIEW_ERROR);


        menuController.optionHandler(prompt.getUserInput(menuScanner));

    }

}
