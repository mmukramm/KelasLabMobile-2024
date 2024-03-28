package com.example.pekan3_pm_d;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Student> students = generateDummyStudents();

    private static ArrayList<Student> generateDummyStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Jung Hyun-bin", "Seoul National University", R.drawable.img1));
        students.add(new Student("Song Hyun-seok", "Seoul National University", R.drawable.img2));
        students.add(new Student("Kyung Do-hyun", "Seoul National University", R.drawable.img3));
        students.add(new Student("Park Hyun-min", "Seoul National University", R.drawable.img4));
        students.add(new Student("Kim Ki-hong", "Yonsei University", R.drawable.img5));
        students.add(new Student("Lee Dong-kyu", "Korea University", R.drawable.img6));
        students.add(new Student("Chae Seung-min", "Korea University", R.drawable.img7));
        students.add(new Student("Shin Jae-yoon", "Pohang University ", R.drawable.img8));
        students.add(new Student("Shin Min-sub", "Pohang University", R.drawable.img9));
        students.add(new Student("Kwak Dong-hyeon", "Harvard University", R.drawable.img1));
        return students;
    }

}
