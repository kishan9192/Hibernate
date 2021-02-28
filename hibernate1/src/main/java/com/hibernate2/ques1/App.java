package com.hibernate2.ques1;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {
    public static void main(String[] args) {
        Categories cat1 = new Categories();
        cat1.setCatId(1);
        cat1.setCatName("Beverages");

        Categories cat2 = new Categories();
        cat2.setCatId(2);
        cat2.setCatName("Dairy Products");

        Categories cat3 = new Categories();
        cat3.setCatId(3);
        cat3.setCatName("Seafood");

        Product prod1 = new Product();
        prod1.setProdId(1);
        prod1.setProdName("Soft drinks");

        Product prod2 = new Product();
        prod2.setProdId(2);
        prod2.setProdName("Coffees");

        Product prod3 = new Product();
        prod3.setProdId(3);
        prod3.setProdName("Cheese");

        Product prod4 = new Product();
        prod4.setProdId(4);
        prod4.setProdName("Fish");

        Supplier sup1 = new Supplier();
        sup1.setSupplierId(1);
        sup1.setSupplierName("Tokyo Traders");

        Supplier sup2 = new Supplier();
        sup2.setSupplierId(2);
        sup2.setSupplierName("Zaheer Khan");

        Supplier sup3 = new Supplier();
        sup3.setSupplierId(3);
        sup3.setSupplierName("BBK Electronics");

        /* Setting remaining members of categories after mapping is done */
        cat1.getSupplist().add(sup1);
        cat1.getSupplist().add(sup2);
        cat1.getSupplist().add(sup3);
        cat2.getSupplist().add(sup1);
        cat2.getSupplist().add(sup2);
        cat2.getSupplist().add(sup3);
        cat3.getSupplist().add(sup1);
        cat3.getSupplist().add(sup2);
        cat3.getSupplist().add(sup3);

        cat1.setProdObj(prod1);
        cat1.setProdObj(prod2);
        cat2.setProdObj(prod3);
        cat3.setProdObj(prod4);

        /* Setting remaining members of products after mapping is done */

        prod1.getCatlist().add(cat1);
        prod2.getCatlist().add(cat1);
        prod3.getCatlist().add(cat2);
        prod4.getCatlist().add(cat3);


        /* Setting remaining members of supplier after mapping is done */

        sup1.getCatm2m().add(cat1);
        sup1.getCatm2m().add(cat2);
        sup1.getCatm2m().add(cat3);
        sup2.getCatm2m().add(cat1);
        sup2.getCatm2m().add(cat2);
        sup2.getCatm2m().add(cat3);
        sup3.getCatm2m().add(cat1);
        sup3.getCatm2m().add(cat2);
        sup3.getCatm2m().add(cat3);

        Configuration config = (new Configuration().configure().addAnnotatedClass(Categories.class)
                                    .addAnnotatedClass(Supplier.class)
                                    .addAnnotatedClass(Product.class));

        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sfactory = config.buildSessionFactory(registry);
        Session session = sfactory.openSession();
        session.beginTransaction();

        session.save(cat1);
        session.save(cat2);
        session.save(cat3);

        session.save(prod1);
        session.save(prod2);
        session.save(prod3);
        session.save(prod4);

        session.save(sup1);
        session.save(sup2);
        session.save(sup3);
        session.getTransaction().commit();
    }
}

// Product - Categories : one to many (1 extra table product-categories)
// categories - suppliers : many to many (1 extra table categories-suppliers)
// Total tables = 5 (Categories, Supplier, Product, product-categories, categories-supplier)