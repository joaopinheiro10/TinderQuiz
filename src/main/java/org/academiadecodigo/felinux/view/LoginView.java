package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.LoginController;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.utilits.ASCIIArtGenerator;

public class LoginView extends AbstractView {

    private LoginController loginController;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {
        System.out.println("HERE");
        //prompt = new Prompt(server.getClientConnectionList().get(0).getInputStream(),
                //server.getClientConnectionList().get(0).getPrintStream());
        StringInputScanner scanner = new StringInputScanner();

        scanner.setMessage(Messages.USERNAME);

        scanner.setError("");
        loginController.setName(prompt.getUserInput(scanner));

        IntegerInputScanner phone = new IntegerInputScanner();
        phone.setMessage(Messages.PHONE_NUMBER);
        loginController.setPhoneNumber(prompt.getUserInput(phone));

    }

}
