package com.howo.jjd.patExam;

//command
public class LoadCommand implements Command {
    private Menu menu;

    public LoadCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.loadGame();
    }
}
