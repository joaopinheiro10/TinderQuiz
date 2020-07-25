package org.academiadecodigo.felinux.controller;


public class WaitingController extends AbstractController{



    @Override
    public void execute() {

        System.out.println("cheguei à waiting controller");
        view.show();

    }

}
