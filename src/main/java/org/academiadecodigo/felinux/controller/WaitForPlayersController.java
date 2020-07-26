package org.academiadecodigo.felinux.controller;

public class WaitForPlayersController extends AbstractController {

    @Override
    public void execute () {
        super.execute();
        gameController.addPlayerReady();
    }
}
