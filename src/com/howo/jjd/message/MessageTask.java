package com.howo.jjd.message;


import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int i = 0, k = 0, u = 0, m = 0;
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
              MessagePriority pri = iterator.next().getPriority();
            if (pri == MessagePriority.HIGH) {
                 i++;
            }
            else if (pri == MessagePriority.LOW) {
                k++;
            }
           else if (pri == MessagePriority.URGENT) {
                u++;
            }
            if (pri == MessagePriority.MEDIUM) {
               m++;
            }
        }
        System.out.println("сообщений LOW: " + k + "; сообщений MEDIUM: " + m + "; сообщений HIGH: " + i + "; сообщений URGENT: " + u);
    }


    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
      //  int[] i = new int[];
//        Iterator<Message> iterator = messageList.listIterator();
//        while (iterator.hasNext()) {
//            int k = iterator.next().getCode();
//            int m = 0;
//            if (k == 0){
//            m++;
//            System.out.println(m);}
//        }
     //   System.out.println(m);    ?????? не нравится мне вариант который я знаю,
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messageHashSet = new HashSet<>(messageList);
        System.out.println("Уникальные сообщения: " + messageHashSet.size());
    }

    public static LinkedHashSet<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        LinkedHashSet<Message> messageLinkedHashSet = new LinkedHashSet<>(messageList);

        return messageLinkedHashSet;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("Без заданного приоритета :До:" + messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority() == priority) {
                iterator.remove();
            }
        }
        System.out.println("Без заданного приоритета: После: " + messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("С заданным приоритетом: До:" + messageList);
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority() != priority) {
                iterator.remove();
            }
        }
        System.out.println("С заданным приоритетом: После: " + messageList);
    }


    public static void main(String[] args) {
        List<Message> messages = MessageGenerator.generate(34);
        // вызов методов
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
        MessageTask.uniqueMessageCount(messages);
        System.out.println(MessageTask.uniqueMessagesInOriginalOrder(messages));
        MessageTask.removeEach(messages, MessagePriority.HIGH);
        MessageTask.removeOther(messages, MessagePriority.LOW);
    }
}