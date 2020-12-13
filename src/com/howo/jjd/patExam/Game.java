package com.howo.jjd.patExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int i = 0;


    protected void fox() {
        System.out.println("Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком. Это утро не " +
                "было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было. Лисёнок ждал, ждал," +
                " но так и не смог дождаться своего друга. \"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\" -" +
                " подумал Лисёнок. Как поступить Лисенку?");
        System.out.println("1. Вернуться домой");
        System.out.println("2. Отправиться на поиски");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("fox");
        // вариант,  после сохранения мы продолжаем игру
        // аналогично добавляем такую строку во всем методы
        // i = getNumber();
        else if (i == 1) backHome();
        else if (i == 2) goInSearch();
        else fox();
    }

    protected void backHome() {
        System.out.println("Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и " +
                "увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!" +
                " Игра завершилась успехом");
        System.out.println(" ");
        System.out.println("Вы прошли игру. Успех");
    }

    protected void goInSearch() {
        System.out.println("Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему." +
                " Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.");
        System.out.println("1. Попытаться разузнать о Бельчонке у лесных жителей");
        System.out.println("2. Искать Бельчонка в одиночку");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("tryToFindOut");
        else if (i == 1) tryToFindOut();
        else if (i == 2) searchOne();
        else goInSearch();
    }

    protected void tryToFindOut() {
        System.out.println("Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у" +
                " Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?");
        System.out.println("1. Расспросить Сову");
        System.out.println("2. Расспросить Волка");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("tryToFindOut");
        else if (i == 1) askOwl();
        else if (i == 2) askWolf();
        else tryToFindOut();
    }

    protected void searchOne() {
        System.out.println("Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился." +
                " Теперь его самого нужно искать. Игра завершилась неудачей");
    }

    protected void askOwl() {
        System.out.println("Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего в глубь леса. " +
                "Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.");
        System.out.println("1. Поверить Сове и отправиться в глубь леса");
        System.out.println("2. Сове не стоит верить->Искать Бельчонка в одино");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("askOwl");
        else if (i == 1) believeOwl();
        else if (i == 2) searchOne();
        else askOwl();
    }

    protected void askWolf() {
        System.out.println("Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному." +
                " И как теперь поступить?");
        System.out.println("1. Волк прав->Вернуться домой");
        System.out.println("2. Искать Бельчонка в одиночку");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("askWolf");
        else if (i == 1) backHome();
        else if (i == 2) searchOne();
        else askWolf();
    }

    protected void believeOwl() {
        System.out.println("В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, " +
                "что знает, если Лисёнок принесёт ему мёда.");
        System.out.println("1. Нет, потрачено слишком много времени, нужно идти дальше->Искать Бельчонка в одиночку");
        System.out.println("2. Нужно воспользоваться шансом и раздобыть мёд");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("believeOwl");
        else if (i == 1) searchOne();
        else if (i == 2) getHoney();
        else believeOwl();
    }

    protected void getHoney() {
        System.out.println("Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже боялся.");
        System.out.println("1. Подождать, вдруг пчёлы улетят");
        System.out.println("2. Нужно попытаться выкрасть мёд немедленно");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("getHoney");
        else if (i == 1) waitBees();
        else if (i == 2) stealHoney();
        else getHoney();
    }

    protected void waitBees() {
        System.out.println("Лисёнок подождал немного, и пчёлы разлетелись." +
                "Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?");
        System.out.println("1. Поесть немного и передохнуть");
        System.out.println("2. Скорее отнести мёд Медвежонку");
        System.out.println("3. Сохранить игру и выйти");
        i = getNumber();
        if (i == 3) SaveGame.save("waitBees");
        else if (i == 1) eatRest();
        else if (i == 2) honeyForTeddyBear();
        else waitBees();
    }

    protected void stealHoney() {
        System.out.println("Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь. Игра закончилась неудачей");
    }

    protected void eatRest() {
        System.out.println("Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски. " +
                "Игра завершилась неудачей");
    }

    protected void honeyForTeddyBear() {
        System.out.println("Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, " +
                "что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности," +
                " и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.");
        System.out.println("1. Межвежонок ничего не знает, нужно продолжить поиски->Искать Бельчонка в одиночку");
        System.out.println("2. Может быть он прав и Лисёнок просто паникует->Вернуться домой");
        i = getNumber();
        if (i == 1) goInSearch();
        else if (i == 2) backHome();
        else honeyForTeddyBear();
    }


    protected int getNumber() {
        try {
            i = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return i;
    }


}
