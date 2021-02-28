package com.hibernate2.ques3;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");


        Student st = new Student();
        st.setMarks(95);
        st.setName("Kishan");
        st.setRollno(3195);
        st.getLaptops().add(laptop);
        laptop.setStudent(st);
        //  st.setLaptop(laptop);
        //  Following loc are for Mapping:
        //  laptop.getStudents().add(st);

        // st.getLaptops will return the list of laptops, and we can add current laptop in that list
        st.getLaptops().add(laptop);


        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory sf = config.buildSessionFactory(registry);
        Session session = sf.openSession();

        session.beginTransaction();
        session.save(laptop);
        session.save(st);
        session.getTransaction().commit();
    }
}
