package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.LoginController;


public class LoginView extends AbstractView {

    private LoginController loginController;

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {

        StringInputScanner scanner = new StringInputScanner();
        scanner.setError("");

        System.out.println(prompt);
        System.out.println(printStream);
        printStream.println(Messages.WELCOME);

        scanner.setMessage(Messages.USERNAME);

        scanner.setError("");
        loginController.setName(prompt.getUserInput(scanner));

        IntegerInputScanner phone = new IntegerInputScanner();
        phone.setMessage(Messages.PHONE_NUMBER);
        loginController.setPhoneNumber(prompt.getUserInput(phone));

    }

}
