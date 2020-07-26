package org.academiadecodigo.felinux.controller;

public class ExitController extends AbstractController {

    @Override
    public void execute () {
        gameController.removePlayer(id);
        super.execute();
    }
}
