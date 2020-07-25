package org.academiadecodigo.felinux.view;

import org.academiadecodigo.bootcamp.Prompt;

import java.io.PrintStream;

public abstract class AbstractView implements View{

    protected Prompt prompt;
    protected PrintStream printStream;

    public Prompt getPrompt() {
        return prompt;
    }

    public void setPrompt(Prompt prompt){
        this.prompt = prompt;
    }

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }
}
