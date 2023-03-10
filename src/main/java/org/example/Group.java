package org.example;

import java.util.*;
import java.util.Iterator;

public class Group {
        private String name;
        private Set<Student> studentList;
        private  int numberStudents;

        public Group() {

            studentList = new HashSet<Student>(10);
            numberStudents = 0;
        }

        public Set<Student> getStudentList() {
            return studentList;
        }

        public String getName() {

            return name;
        }


        public void setName(String name) {
            if (name != null) {
                this.name = name;
            } else {
                System.out.println("Name is incorrect");
            }
        }

        private boolean groupVerification() {
            if (this.getName() != null) {
                return true;
            }
            return false;
        }

        private boolean studentVerification(Student student) {
            if (student != null
                    && student.getAge() != 0
                    && student.getName() != null
                    && student.getSurname() != null
                    && student.getGender() != null
                    && (student.averageRating > 1)
                    && (student.averageRating <= 5)) {
                return true;
            }
            return false;
        }

        public String addStudent(Student student) {
            String rezult = "The student's details are incorrect, the student was not added to the group";
            if (numberStudents == 10) {
                rezult = "Group is full";
            }
            if (studentVerification(student) == true
                    && groupVerification() == true
                    && numberStudents < 10) {
                studentList.add(student);
                ++numberStudents;
                rezult = "Student successfully added";
            }

            if (groupVerification() == false) {
                rezult = "Group created without naming, student cannot be added";
            }
            return rezult;
        }

        public String removeStudent(Student student) {
            String rezult = "This student is not in the group";
            if (studentVerification(student) == true
                    && groupVerification() == true) {
                Iterator<Student> iterator = this.studentList.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().equals(student)) {
                        iterator.remove();
                        rezult = "Student successfully removed";
                    }
                }
            }
            if (groupVerification() == false || studentVerification(student) == false) {
                rezult = "Group created without naming, student cannot be removd";
            }
            return rezult;
        }

        public ArrayList<Student> searchStudentBySurname(String surname) {
            ArrayList<Student> students = new ArrayList<Student>();
            Iterator<Student> iterator = this.studentList.iterator();
            while (iterator.hasNext()) {
                Student student1 = iterator.next();
                if (student1.getSurname().equals(surname)) {
                    students.add(student1);
                }
            }
            return students;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return getName().equals(group.getName()) && getStudentList().equals(group.getStudentList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStudentList());
    }

    @Override
        public String toString() {
            StringBuilder students = new StringBuilder();
            Iterator<Student> iterator = this.studentList.iterator();
            while (iterator.hasNext()) {
                Student student1 = iterator.next();
                students.append(student1.toString() + "\n");
            }
            return students.toString();
        }
}
