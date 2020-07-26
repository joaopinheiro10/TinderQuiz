package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.felinux.controller.LoginController;


public class LoginView extends AbstractView {

    private LoginController loginController;
    private final String regexPattern = "(9[1236]\\d) ?(\\d{3}) ?(\\d{3})";

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    @Override
    public void show() {

        StringInputScanner scanner = new StringInputScanner();
        scanner.setError("");

        scanner.setMessage(Messages.USERNAME);

        scanner.setError("");
        loginController.setName(prompt.getUserInput(scanner));

        checkNumber();
    }

    private void checkNumber() {

        IntegerInputScanner phone = new IntegerInputScanner();
        phone.setMessage(Messages.PHONE_NUMBER);
        String phoneNumber = prompt.getUserInput(phone).toString();

        if (phoneNumber.matches(regexPattern)) {
            loginController.setPhoneNumber(phoneNumber);
        } else {
            checkNumber();
        }
    }

}
