package com.hibernate2.ques3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String lname;
    // This is on the basis of one to many relationship in the student's class.
    // this time we don't get a third table while creating the mapping, cause the mapping
    // is done by laptop class. More precisely, it is done by the student object inside laptop class.
    // So for many to one relation. Many laptops belong to one student. therefore there can be a sepatate column of
    // student rollnumber in the laptop table, instead of creating a new table altogether
        @ManyToOne
        private Student student;

        public Student getStudent() {
            return student;

        }

        public void setStudent(Student student) {
            this.student = student;
        }


    // Many students can have many laptops
    //    @ManyToMany
    //    private List<Student> students = new ArrayList<>();
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }


    //    public List<Student> getStudents() {
    //        return students;
    //    }
    //
    //    public void setStudents(List<Student> students) {
    //        this.students = students;
    //    }
}