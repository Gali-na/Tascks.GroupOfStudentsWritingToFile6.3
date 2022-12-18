package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ReadInformationFromFileTest {
    private Student student1() {
        Student student1 = new Student();
        student1.setSurname("Zolotareva");
        student1.setName("Natalia");
        student1.setAge(19);
        student1.setGender(Gender.WOMAN);
        student1.setAverageRating(3);
        return student1;
    }

    private Student student2() {
        Student student2 = new Student();
        student2.setSurname("Zolotareva");
        student2.setName("Aria");
        student2.setAge(20);
        student2.setGender(Gender.WOMAN);
        student2.setAverageRating(3);
        return student2;
    }

    private Student student3() {
        Student student3 = new Student();
        student3.setSurname("Tsivka");
        student3.setName("Galina");
        student3.setAge(20);
        student3.setGender(Gender.WOMAN);
        student3.setAverageRating(4);
        return student3;
    }

    @Test
    void readGroupFromFile_FileIsNull_GetGroupIsEmpty() {
        File file = null;
        Group group = ReadInformationFromFile.readGroupFromFile(file);
        assertEquals(null, group.getName());
        assertEquals(0, group.getStudentList().size());
    }

    @Test
    void readGroupFromFile_FileIsNotFile_GetGroupIsEmpty() {
        File file = new File("C:\\Users");
        Group group = ReadInformationFromFile.readGroupFromFile(file);
        assertEquals(null, group.getName());
        assertEquals(0, group.getStudentList().size());
    }

    @Test
    void readGroupFromFile_FileHasInformationAboutGroup_GetGroup() {
        File file = new File("Group.txt");
        Group groupExpected = new Group();
        groupExpected.setName("GGGG");
        groupExpected.addStudent(student1());
        groupExpected.addStudent(student2());
        groupExpected.addStudent(student3());
        WriteGroupToFile.writeToFile(groupExpected, file);
        Group groupActual = ReadInformationFromFile.readGroupFromFile(file);
        List<Student> studentsListActual = new ArrayList<Student>(groupActual.getStudentList());
        List<Student> studentsListExpected = new ArrayList<Student>(groupExpected.getStudentList());
        Collections.sort(studentsListActual, new ComparisonBySurname());
        Collections.sort(studentsListExpected, new ComparisonBySurname());
        assertEquals(groupExpected.getName(), groupActual.getName());
        assertEquals(studentsListExpected, studentsListActual);
    }
}