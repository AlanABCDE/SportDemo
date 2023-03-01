package com.noob.sportsdemo.entity;

public class Instructor {
    private int instructor_id;
    private String instructor_name;
    private String instructor_sex;
    private int instructor_tel ;
    private int rank_id ;

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public String getInstructor_sex() {
        return instructor_sex;
    }

    public void setInstructor_sex(String instructor_sex) {
        this.instructor_sex = instructor_sex;
    }

    public int getInstructor_tel() {
        return instructor_tel;
    }

    public void setInstructor_tel(int instructor_tel) {
        this.instructor_tel = instructor_tel;
    }

    public int getRank_id() {
        return rank_id;
    }

    public void setRank_id(int rank_id) {
        this.rank_id = rank_id;
    }
}
