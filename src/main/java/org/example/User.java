package org.example;

import java.util.Collection;

public class User {
    private int id;
    private String name;
    private boolean online;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", online=" + online +
                ", age=" + age +
                '}';
    }
}
