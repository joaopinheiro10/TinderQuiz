package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class EndView extends AbstractView {

    @Override
    public void show() {

        MenuInputScanner menu = new MenuInputScanner(Messages.OPTIONS);
        menu.setMessage(Colors.BLUE + Messages.MENU_VIEW + Colors.NOCOLOR);
        menu.setError(Messages.MENU_VIEW_ERROR);

        prompt.getUserInput(menu);
    }
}
