package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;

public class ExitController extends AbstractController {

    Bootstrap bootstrap;

    @Override
    public void execute () {

        gameController.removePlayer(id);

        bootstrap.closeSocket();
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }
}
