package com.test.microservivce.mvc.bean;

public class Demo {
    private long id;
    private String name ;

    public long getId() {
        return id;
    }

    public Demo() {
    }

    public Demo(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
