package org.example;

import java.util.Collections;
import java.util.List;

public class Top3Calculator {
    public List<Student> calcutate(List<Student> students) {
        Collections.sort(students);
        return students.subList(0, 3);
    }
}