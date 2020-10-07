package com.ifmo.jjd.lesson6;


//  имя public  класса должно соответствовать имени файла
//  в файле должен быть тлько один public класс, классов без модификаторов может быть сколько угодно
//  область видимости public класса вся программа
//  без слов, область видимости весь пакет. (default)
// название
// количесво картинок
// автор ( имя, фамилия)
public class ColouringBook {
    // эта называется - свойства / поля / атрибуты
    private String title;  // название // закрыли доступ к свойсву модификатором privet
    private int pageCount; //  название , значение по умолчанию 0
    private Author author; // автор , значение по умолчанию null
    // Alt + Enter создание геттера и сеттера
    // значеине свойст по умолчанию:
    // boolean: false
    // целочисленные типы: 0
    // с плавающей точкой: 0.0
    // char: u0000
    // ссылочный типы: null

    // модификаторы дотупа:
    // privete  - доступно только в рамках текущего класса
    // packege-private / default - доступ в рамках пакета (модификатор по умолчанию)
    // protected доступ как у default + рамках дочернего класса
    // public -доступен из любого участка программы


    // сеттер - метод, котрыре позволит выполнить проверку входящих
    // данных и установить значение свойст объекта( если проверки пройденны)
    // создание сеттера
    // void - это говорит что метод ничего не вернет, а просто выполняет действие
    // setTitle - имя метода (оно дожно отражать то что происходит в этом методе)
    // (String title) говорим что метод готов принять на вход переменную типа String - аргумент метода
    public void setTitle(String title) {
        // все это делается для того чтоб title != null; и не былобы пусто " "
        if (title == null || title.length() < 3)
            throw new IllegalArgumentException("title должен быть не меньше 3");
        // ( title.length() < 3 ||  title == null ) так будет ошибка потмоу что может
        // быть null.length ...
        // присваиваем значение свойства title равное (String title)
        // this - ссылка на текущий объект (такущий это такой объект у которого в данных момент
        // вызывается метод)
        // this можно не использовать если у аргумента и у свойства были бы разные названия
        // пример  (String someTitle) title = someTitle
        this.title = title;
    }

        // геттер - метод, который возвращает значение свойства
        // public - модификатор доступа - можем обратить в любом месте программы
        // String - тип возвращаемого результата\ значения
        // getTitle -  название метода
        // () - без аргумента
        public String getTitle(){
            // return - прерыват работу метода в той точке где он объявлен
            return title;
        }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        if (pageCount < 5)
            throw new IllegalArgumentException("pageCount не может быть меньше 5 страниц");
        this.pageCount = pageCount;

        //  структура класса
        // класс {
        //     свойства
        //     конструкторы
        //     геттеры + сеттеры
        //    методы
        //    переопределенные методы (к которым относится toString)
        // }



    }

    public Author getAuthor() {
        return author;
    }


    @Override
    public String toString() {
        return "ColouringBook{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }

    public void setAuthor(Author author) {
        if (author == null)
            throw new IllegalArgumentException("автор не может быть null");
        this.author = author;



        }
    }



