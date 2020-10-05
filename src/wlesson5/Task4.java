package wlesson5;

public class Task4 {
    public static void main(String[] args) {
        String s = "руСАлка";
        s = s.toLowerCase();

        System.out.println(s.substring(0,1).toUpperCase() + s.substring(1));
    }
}
