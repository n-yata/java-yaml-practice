package jp.sample.entities;

import lombok.Data;

@Data
public class Person {
    String firstName;
    String famiryName;
    String nationality;
    int age;

    public Person() {}

    public Person(String firstName, String famiryName, String nationality, int age) {
        this.firstName = firstName;
        this.famiryName = famiryName;
        this.nationality = nationality;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + firstName + ", famiryName=" + famiryName + ", natonality=" + nationality + ", age="
                + age + "]";
    }


}
