package org.example;

import java.io.*;

public class ReadInformationFromFile {
    public static Group readGroupFromFile(File file) {
        String line = "";
        Group group = new Group();
        int i = 0;
        if (CheakFile.check(file)) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                while ((line = reader.readLine()) != null) {
                    if (i == 0) {
                        group.setName(line);
                        i++;
                        continue;
                    }
                    if (line == "\n") {
                        continue;
                    }
                  String[] strings=  line.split(" ");
                    Student student = new Student();
                   student.setSurname(strings[0]);
                   student.setName(strings[1]);
                   if (Gender.WOMAN.toString().equals(strings[2])){
                       student.setGender(Gender.WOMAN);
                   }else{
                       student.setGender(Gender.MAN);
                   }
                   student.setAge(Integer.valueOf(strings[3].toString()));
                   student.setAverageRating(Integer.valueOf(strings[4]));
                   group.addStudent(student);
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return group;
    }
}
