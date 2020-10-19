package com.howo.jjd.kontrol;

public class GroupLessons implements AddDel {
    private final String name = "Групповые занятия";

    protected Abonement[] grA = new Abonement[20];

    public String getName() {
        return name;
    }

    @Override
    public void addZal(Abonement ab) {
        for (int i = 0; i < grA.length; i++) {
            if (grA[i] == null){
                grA[i] = ab;
                System.out.println(Logger.clientInfo(ab, name));
                return;}
            if (grA[grA.length- 1 ] != null){
                System.out.println("мест нет");
                return;}
        }
    }
    public Boolean test(Abonement ab){
        for (int i = 0; i < grA.length; i++) {
            if (grA[i] == ab)
                return true;
        }
        return  false;
    }

    @Override
    public void delZal() {
        for (int i = 0; i < grA.length; i++) {
            grA[i] = null;
        }
    }

    @Override
    public void delTimeZal() {
        for (int i = 0; i < grA.length ; i++) {
            if (grA[i] instanceof DayAbon)
                grA[i] = null;
        }
    }


}
