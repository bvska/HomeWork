package com.ifmo.jjd.lesson6;
// com.ifmo.jjd.lesson6.Application   // полное имя пакета
public class Application {
    public static void main(String[] args) {
        // перенос в пакет правой кнопкой и remove и refactor, либо перетаскиваем
        // пакеты чтоб не было проблем с одинаковыми именами классов
        ColouringBook dogs = new ColouringBook();
        // создание объекта
        // тип_данных имя_переменной new конструкор();
        // создание объекта типа ColouringBook
        ColouringBook flowers = new ColouringBook();
        ColouringBook cats = new ColouringBook();
        //  у них есть одинаковый набор характеристик
        // dog.title = "Собаки"  // обратились ск свойсву title объекта dogs и присвоили ему знаечение
        // для flowers значение по умолчанию null

        // при таком подходе в свойто можно записать все что угодно, и это
        // может навредить прграмме, например
        // dogs.title = "";
         // dogs.title = null;
        // поэтому лучше ограничить доступ к свойству
        dogs.setTitle("Собаки");
        flowers.setTitle("Цветы");
        cats.setTitle("Кошки");


        String dogsTitle = dogs.getTitle();
        System.out.println(dogsTitle);
        String flowersTitle = flowers.getTitle();

        Author ivan = new Author("Ivan");
        Author rick = new Author("Rick", "Volkov");
        // в момент когда мы создаем объект значение его свойт null

        ivan.setName("Ivan");
        ivan.setSurname("Petrov");

        System.out.println(ivan.getSurname());
        System.out.println();
       // System.out.println(ivan.getFullName());
        dogs.setAuthor(ivan);
        // dogs.getAuthor() - объект Author
        System.out.println(dogs.getAuthor().getFullname());
        System.out.println(dogs);
       // System.out.println("        ".length());  // такоего быть не может
        ColouringShelf shelf = new ColouringShelf(10, "желтый");
        System.out.println(shelf);

        //shelf.addColouring(dogs);
        //shelf.addColouring(flowers);
        shelf.addColouring(dogs, flowers, dogs, cats);
        System.out.println(shelf.getBooksInfo());


    }
}
