package com.howo.jjd.patExam;

//command
public class ExitCommand implements Command {
    private Menu menu;

    public ExitCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit();
    }
}
