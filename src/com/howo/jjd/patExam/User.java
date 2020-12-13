package com.howo.jjd.patExam;

// invoker
public class User {
    private Command start;
    private Command exit;
    private Command load;

    public User(Command start, Command exit, Command load) {
        this.start = start;
        this.exit = exit;
        this.load = load;
    }

    protected void startGame(){
        start.execute();
    }
    protected void exitGame(){
        exit.execute();
    }
    protected void loadGame(){
        load.execute();
    }

}
