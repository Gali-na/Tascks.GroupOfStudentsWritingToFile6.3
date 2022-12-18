package org.example;

import java.io.*;
import java.util.Set;

public class WriteGroupToFile {
    public static boolean writeToFile(Group group, File file) {
         StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(group.getName());
        stringBuilder.append("\n");
        Set<Student> students = group.getStudentList();
        for (Student student : students) {
            stringBuilder.append(student.getSurname() + " ");
            stringBuilder.append(student.getName() + " ");
            stringBuilder.append(student.getGender() + " ");
            stringBuilder.append(student.getAge() + " ");
            stringBuilder.append(student.getAverageRating() + " ");
            stringBuilder.append("\n");
        }
        if (CheakFile.check(file)) {
            try (Writer writer = new BufferedWriter(new FileWriter(file))) {
                   writer.write(stringBuilder.toString());
            } catch (IOException e) {
                e.getMessage();
                return false;
            }
        }
        return true;
    }
}
