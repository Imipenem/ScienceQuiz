package com.heumehle.zeth.sciencequiz;

public class PersonJ {

    private String surName;
    private String name;
    private int age;

    public PersonJ(String surName, String name, int age) {
        this.surName = surName;
        this.name = name;
        this.age = age;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Surname: " + surName + System.lineSeparator());
        stringBuilder.append("Name: " + name + System.lineSeparator());
        stringBuilder.append("Age: " + age + System.lineSeparator());

        return stringBuilder.toString();
    }
}
