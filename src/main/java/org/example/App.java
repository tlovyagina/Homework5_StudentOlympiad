package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        System.out.println("Введите количество заданий на олимпиаде: ");
        int taskCount = readInt();

        while (true) {
            System.out.println("Введите через пробел ФИО студента (для выхода введите 0): ");
            String surname = scanner.next();

            if (surname.equals("0")) break;

            Student student = new Student();
            student.setSurname(surname);
            student.setName(scanner.next());
            student.setPatronymic(scanner.next());
            scanner.nextLine();

            System.out.println("Введите оценки студента: ");
            List<Integer> score = new ArrayList<>();

            for (int i = 0; i < taskCount; i++) {
                score.add(readBalls());
            }
            scanner.nextLine();

            student.setScore(score);
            studentList.add(student);
        }

        Top3Calculator top3Calculator = new Top3Calculator();
        List<Student> top3 = top3Calculator.calcutate(studentList);

        System.out.println("Победители олимпиады: ");

        for (int i = 0; i < top3.size(); i++) {
            System.out.println(i + 1 + " " + "место: " + top3.get(i).getSurname() + " " + top3.get(i).getName() + " " + top3.get(i).getPatronymic());
        }
    }

    public static int readBalls() {
        String string = scanner.next();

        while (!string.matches("[0-5]")) {
            System.out.println("Некорректное значение. Повторите ввод: ");
            string = scanner.next();
        }
        return Integer.parseInt(string);
    }

    public static int readInt() {
        String string = scanner.nextLine();

        while (!string.matches("[1-9][0-9]*")) {
            System.out.println("Некорректное значение. Повторите ввод: ");
            string = scanner.nextLine();
        }
        return Integer.parseInt(string);
    }
}