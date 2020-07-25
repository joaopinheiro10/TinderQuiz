package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerSetInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import org.academiadecodigo.felinux.controller.RulesController;

public class RulesView extends AbstractView{

    RulesController rulesController;

    public void setRulesController(RulesController rulesController) {
        this.rulesController = rulesController;
    }

    @Override
    public void show() {

        System.out.println(Messages.GAMERULES);


    }


    public void backToMenu() {

        String[] options = {"Go Back"};
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage(Messages.MENU_VIEW);
        menu.setError(Messages.MENU_VIEW_ERROR);
        prompt.getUserInput(menu);
    }
}
