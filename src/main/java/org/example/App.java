package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        while (true) {
            System.out.println("Введите через пробел ФИО студента (для выхода введите 0): ");
            String surname = scanner.next();

            if (surname.equals("0")) break;

            Student student = new Student();
            student.setSurname(surname);
            student.setName(scanner.next());
            student.setPatronymic(scanner.next());

            System.out.println("Введите через пробел оценки студента (для завершения ввода оценок введите 0): ");
            List<Integer> score = new ArrayList<>();

            while (true) {
                int ball = scanner.nextInt();
                if (ball == 0) break;
                score.add(ball);
            }

            student.setScore(score);
            studentList.add(student);
        }

        Top3Calculator top3Calculator = new Top3Calculator();
        List<Student> top3 = top3Calculator.calcutate(studentList);

        System.out.println("Победители олимпиады:");

        for (int i = 0; i < top3.size(); i++) {
            System.out.println(i + 1 + " " + "место: " + top3.get(i).getSurname() + " " + top3.get(i).getName() + " " + top3.get(i).getPatronymic());
        }
    }
}