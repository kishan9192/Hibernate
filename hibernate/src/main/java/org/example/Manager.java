package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager {
    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        //String sql = "insert into PERSON values(10, 'SqlDEmo', 'Demo', 22)";
        Person p1 = new Person();

        p1.setId(6);
        p1.setFirstName("Richa");
        p1.setLastName("Goel");
        p1.setAge(20);

        session.save(p1);

        tx.commit();
        session.close();
        System.out.println("Done");
    }
}
