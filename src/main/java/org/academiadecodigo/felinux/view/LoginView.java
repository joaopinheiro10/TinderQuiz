package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.LoginController;
import org.academiadecodigo.felinux.server.Server;

public class LoginView extends AbstractView {

    LoginController loginController;
    Server server;

    public void setServer(Server server) {
        this.server = server;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {
        System.out.println("HERE");
        prompt = new Prompt(server.getClientConnectionList().get(0).getInputStream(),
                server.getClientConnectionList().get(0).getPrintStream());
        StringInputScanner scanner = new StringInputScanner();
        scanner.setMessage("The Message");
        scanner.setError("");
        server.getClientConnectionList().get(0).getClient().setName(prompt.getUserInput(scanner));
    }

    private void shoGameIntro() {
    }
}
