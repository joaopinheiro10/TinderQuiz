package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.server.Server;

public class GameController implements Controller{

    private Server server;



    public void changeName(int id, String name) {
        server.getClient(id).setName(name);
        System.out.println(name);
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void execute() {

    }
}
