package ru.job4j.tracker.lambda.streamapi.builder;

public class Student {
    private String name;
    private int age;
    private String school;
    private int schoolNumber;
    private boolean highSchool;
    private String direction;

    public static class Builder {
        private String name;
        private int age;
        private String school;
        private int schoolNumber;
        private boolean highSchool;
        private String direction;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildAge(int age) {
            this.age = age;
            return this;
        }

        Builder buildSchool(String school) {
            this.school = school;
            return this;
        }

        Builder buildSchoolNumber(int schoolNumber) {
            this.schoolNumber = schoolNumber;
            return this;
        }

        Builder buildhighSchool(Boolean highSchool) {
            this.highSchool = highSchool;
            return this;
        }

        Builder buildDirection(String direction) {
            this.direction = direction;
            return this;
        }

        Student build() {
            Student student = new Student();
            student.name = name;
            student.age = age;
            student.school = school;
            student.schoolNumber = schoolNumber;
            student.highSchool = highSchool;
            student.direction = direction;
            return student;
        }
    }

    public static void main(String[] args) {
        Student student = new Builder()
                .buildName("Igor")
                .buildAge(32)
                .buildSchool("Lomonosova")
                .buildSchoolNumber(12)
                .buildhighSchool(false)
                .buildDirection("engineer")
                .build();

        Student student1 = new Builder()
                .buildName("Saveliy")
                .buildAge(15)
                .build();

        System.out.println(student.name + " | " + student.age);
        System.out.println(student1.name + " | " + student1.age);
    }
}
