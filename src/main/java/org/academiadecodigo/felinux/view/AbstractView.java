package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.Prompt;

public abstract class AbstractView implements View{

    protected Prompt prompt;


    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }
}
