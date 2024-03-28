package com.example.pekan3_pm_d;

public class Student {
    private String name;
    private String university;
    private Integer image;

    public Student(String name, String university, Integer image) {
        this.name = name;
        this.university = university;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
