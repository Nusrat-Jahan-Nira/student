package com.example.student;

public class Greeting {

    private long id;
    private String name;

    public Greeting(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getID() {
        return id;
    }

    public void setName(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
