package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.felinux.controller.RulesController;
import org.academiadecodigo.felinux.server.Server;

public class RulesView extends AbstractView{

    RulesController rulesController;

    public void setRulesController(RulesController rulesController) {
        this.rulesController = rulesController;
    }

    @Override
    public void show() {

        printStream.println(Messages.GAMERULES);
        backToMenu();

    }


    public void backToMenu() {

        String[] options = {"Go Back"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage(Colors.BLUE + Messages.MENU_VIEW + Colors.NOCOLOR);
        menu.setError(Messages.MENU_VIEW_ERROR);

        prompt.getUserInput(menu);
    }
}
