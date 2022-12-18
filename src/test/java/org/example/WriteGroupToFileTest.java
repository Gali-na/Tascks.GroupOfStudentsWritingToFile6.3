package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriteGroupToFileTest {

    @Test
    void writeToFile_FileIsNull_GetFalse() {
        File file = null;
        Group group = CreatGroup.creatGroup();
       assertEquals(false,WriteGroupToFile.writeToFile(group,file));

    }

    @Test
    void writeToFile_FileIsNotFile_GetFalse() {
        File file = null;
        Group group = CreatGroup.creatGroup();
        assertEquals(false,WriteGroupToFile.writeToFile(group,file));

    }

    @Test
    void writeToFile_FileExist_GetTrue() {
        File file = new File("Group.txt");
        Group group = CreatGroup.creatGroup();
        WriteGroupToFile.writeToFile(group,file);
        assertEquals(true, WriteGroupToFile.writeToFile(group,file));

    }

    @Test
    void writeToFile_FileExist_GetTrueCheckElementFromGroup() {
        File file = new File("Group.txt");
        Group group = CreatGroup.creatGroup();
        WriteGroupToFile.writeToFile(group,file);
        Group actualGroup= ReadInformationFromFile.readGroupFromFile(file);
        List<Student> studentsListActual = new ArrayList<>(actualGroup.getStudentList());
        List<Student> studentsListExpected = new ArrayList<>(group.getStudentList());
        Collections.sort(studentsListActual, new ComparisonBySurname());
        Collections.sort(studentsListExpected, new ComparisonBySurname());
        assertEquals(group.getName(), actualGroup.getName());
        assertEquals(studentsListExpected, studentsListActual);
        assertEquals(true, WriteGroupToFile.writeToFile(group,file));

    }

}