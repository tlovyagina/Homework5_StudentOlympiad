package org.example;

import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private String patronymic;
    private List<Integer> score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        if (average() > o.average())
            return -1;
        if (average() < o.average())
            return 1;
        return surname.compareTo(o.getSurname());
    }

    public float average() {
        if (score == null || score.isEmpty())
            return 0;

        int summ = 0;

        for (Integer i : score) {
            summ = summ + i;
        }
        return (float) summ / score.size();
    }
}