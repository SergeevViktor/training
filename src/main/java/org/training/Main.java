package org.training;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вариант №1----------------");
        CustomStringBuilder custom = new CustomStringBuilder();

        custom.append("Привет, ");
        custom.append("Виктор!");

        System.out.println(custom);
        custom.undo();
        System.out.println(custom);
        custom.undo();
        System.out.println(custom);
        System.out.println("'Привет,' удалилось!");

        //Вариант 2
        System.out.println("Вариант №2----------------");
        CustomStringBuilder custom2 = new CustomStringBuilder("Hello world!");

        custom2.append(" Hello, Viktor!");

        System.out.println(custom2);
        custom2.undo();
        System.out.println(custom2);
        custom2.undo();
        System.out.println(custom2);
        System.out.println("'Hello world!' не удалилось!");
    }
}