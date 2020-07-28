package org.academiadecodigo.felinux.view;

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

        scanner.setMessage(Messages.USERNAME);

        loginController.setName(prompt.getUserInput(scanner));

        checkNumber();
    }

    private void checkNumber() {

        StringInputScanner phone = new StringInputScanner();
        phone.setMessage(Messages.PHONE_NUMBER);
        phone.setError(Messages.PHONE_NUMBER_WRONG);
        String phoneNumber = prompt.getUserInput(phone);

        if (phoneNumber.matches(regexPattern)) {
            loginController.setPhoneNumber(phoneNumber);
        } else {
            printStream.println(Messages.PHONE_NUMBER_WRONG);
            checkNumber();
        }
    }

}
