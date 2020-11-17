package com.howo.jjd.lambda.course;

import java.util.function.Predicate;

public class LambdaPredicate {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());


        System.out.println(university);

        university.getCourses().forEach(System.out::println);

        System.out.println(" ");
        Predicate<Course> minThree = obj -> obj.getDuration() >= 3;
//        university.filtered(minThree);
//        university.getCourses().forEach(System.out::println);

        Predicate<Course> minPrice = obj -> obj.getPrice() >=20000;
//        university.filtered(minPrice);
//        university.getCourses().forEach(System.out::println);

        Predicate<Course> name = obj -> !obj.getName().equals("JJD");
//        university.filtered(name);
//        university.getCourses().forEach(System.out::println);

        Predicate<Course> minPriceDur = obj -> (obj.getPrice() >=20000 || obj.getDuration() >= 3);
//        university.filtered(minPriceDur);
//        university.getCourses().forEach(System.out::println);
        Predicate<Course> minPDN = obj -> (obj.getPrice() >=20000 || obj.getDuration() >= 3 || !obj.getName().equals("JJD"));
        university.filtered(minPDN);
        university.getCourses().forEach(System.out::println);
    }



}
