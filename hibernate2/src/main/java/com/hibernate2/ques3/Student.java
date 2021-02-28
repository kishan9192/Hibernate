package com.hibernate2.ques3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    private int rollno;
    private String name;
    private int marks;


    // One to one relationship between student and laptop. Each student will have one laptop
    //    @OneToOne
    //    private Laptop laptop;

    // One to many relation: One student can have multiple laptops
    // mapped by's name will be same as student object in the laptop class(Same names)
        @OneToMany(mappedBy = "student")
        private List<Laptop> laptops = new ArrayList<>();

    //    These methods were for one to one relationship
    //    public Laptop getLaptop() {
    //        return laptop;
    //    }
    //
    //    public void setLaptop(Laptop laptop) {
    //        this.laptop = laptop;
    //    }

    // *****************************************************//

    // For one to many. It'll create a separate table
    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }


    // so this mapped by is the student object in laptop class. (below many to many annotation)
    //    @ManyToMany(mappedBy = "students")
    //    List<Laptop>laptops = new ArrayList<>();
    //
    //    public List<Laptop> getLaptops() {
    //        return laptops;
    //    }
    //
    //    public void setLaptops(List<Laptop> laptops) {
    //        this.laptops = laptops;
    //    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

}
