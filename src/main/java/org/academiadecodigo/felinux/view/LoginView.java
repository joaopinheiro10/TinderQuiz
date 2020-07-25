package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.LoginController;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.utilits.ASCIIArtGenerator;

public class LoginView extends AbstractView {

    private LoginController loginController;
    private Server server;

    public void setServer(Server server) {
        this.server = server;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {
        System.out.println("HERE");
        //prompt = new Prompt(server.getClientConnectionList().get(0).getInputStream(),
                //server.getClientConnectionList().get(0).getPrintStream());
        StringInputScanner scanner = new StringInputScanner();
        try {
            scanner.setMessage(ASCIIArtGenerator.printTextArt(Messages.STARTGAME,10));
        } catch (Exception e) {
            e.printStackTrace();
        }
        scanner.setError("");
/*
        System.out.println(prompt);
        System.out.println(printStream);
        printStream.println("Hey!");

        prompt.getUserInput(scanner);
*/
        loginController.setName(prompt.getUserInput(scanner));

    }

}
