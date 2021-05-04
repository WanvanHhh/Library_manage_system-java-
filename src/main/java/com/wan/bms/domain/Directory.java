package com.wan.bms.domain;

public class Directory {
    private Long id;

    private String name;

    private String describes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describes='" + describes + '\'' +
                '}';
    }
}