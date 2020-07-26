package org.academiadecodigo.felinux.view;

public class WelcomeView extends AbstractView {


    @Override
    public void show() {

        printStream.println(Colors.CLEAR);
        printStream.flush();

        printStream.println(Messages.WELCOME);
    }
}
