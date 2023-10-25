package org.campusmolndal;

public class Todo {
    private String name;
    private String todo;

    public Todo() {
    }

    public Todo(String name, String todo) {
        this.name = name;
        this.todo = todo;
    }

    public String getName() {
        return this.name;
    }

    public String getTodo() {
        return this.todo;
    }
}
