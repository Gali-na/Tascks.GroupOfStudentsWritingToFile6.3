package org.example;

import java.io.File;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Group group = CreatGroup.creatGroup();
        /*System.out.println("*****************");
        System.out.println(group.toString());
        System.out.println("*****************");
        System.out.println(group.toString());
        System.out.println("*****************");

        System.out.println(group.searchStudentBySurname("Zolotareva"));
        System.out.println("*****************");
        System.out.println("*****************");
        ArrayList<Student> students = new ArrayList<Student>(group.getStudentList());

        Collections.sort(students, new ComparisonBySurname());
        for (Student st : students) {
            System.out.println(st.toString());
        }
        System.out.println();
        System.out.println("*****************");
        Collections.sort(students, new SortBySurname());
        for (Student st : students) {
            System.out.println(st.toString());
        }
        System.out.println();
        System.out.println("*****************");
        Collections.sort(students, new SortByAverageRating());
        for (Student st : students) {
            System.out.println(st.toString());
        }
        MilitaryCommissar militaryCommissar = new CommissarUniversity();
        System.out.println(militaryCommissar.listManAfter18(group));


           Group group1 = CreatGroup.creatGroup();*/
                System.out.println(WriteGroupToFile.writeToFile(group,new File("Group.txt")));
        Group group1= ReadInformationFromFile.readGroupFromFile(new File("Group.txt"));
        System.out.println(group1.toString());
        System.out.println(ReadInformationFromFile.readGroupFromFile(new File("Group.txt")).toString());



    }
}