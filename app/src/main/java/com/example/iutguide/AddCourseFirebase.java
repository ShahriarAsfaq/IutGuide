package com.example.iutguide;

public class AddCourseFirebase {
    private  String courseName;
    private  String courseCredit;


    public AddCourseFirebase(){

    }
    public AddCourseFirebase(String courseName,String courseCredit) {
        this.courseName = courseName;
        this.courseCredit=courseCredit;
    }


   public  String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public  String getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit = courseCredit;
    }
}
