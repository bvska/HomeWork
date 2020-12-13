package com.howo.jjd.patExam;

//command
public class StartCommand implements Command {
    private Menu menu;

    public StartCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.start();
    }
}
