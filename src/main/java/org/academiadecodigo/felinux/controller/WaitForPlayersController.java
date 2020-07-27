package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.model.client.Client;

public class WaitForPlayersController extends AbstractController {

    Bootstrap bootstrap;
    Client client;

    @Override
    public void execute () {
        super.execute();
        gameController.addBootstrap(id, bootstrap);
        gameController.addClient(id, client);
        gameController.addPlayerReady();
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
