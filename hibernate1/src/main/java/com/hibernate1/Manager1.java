package com.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.*;

public class Manager1 {

    private static <EmployeeSchema> List<EmployeeSchema> getallemployees(Class<EmployeeSchema> type, Session session) {
        CriteriaBuilder criteriabuilder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeSchema> criteria = criteriabuilder.createQuery(type);
        criteria.from(type);
        List<EmployeeSchema> allemployees = session.createQuery(criteria).getResultList();
        return allemployees;
    }

    public static void main(String args[]) {


        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Scanner s = new Scanner(System.in);
        int choice;
        char cont;
        do {
            System.out.println("1. Create employee\n" +
                    "2. Update employee by id\n" +
                    "3. Update all employees record\n"+
                    "4. Delete employee \n" +
                    "5. Get all employee\n" +
                    "6. Get Employee by id\n" +
                    "7. exit\n" +
                    "Enter your choice (1-7)");

            int option = s.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter the Employee ID");
                    int Eid = s.nextInt();

                    System.out.println("Enter First Name ");
                    String Fname = s.next();

                    System.out.println("Enter Last Name ");
                    String Lname = s.next();

                    System.out.println("Enter Age");
                    int Age = s.nextInt();

                    System.out.println("Enter the Designation");
                    String Designation = s.next();

                    System.out.println("Enter the Date of Birth");
                    String DOB = s.next();

                    System.out.println("Enter the Salary");
                    int Salary = s.nextInt();

                    EmployeeSchema emp = new EmployeeSchema();
                    emp.setId(Eid);
                    emp.setFirstName(Fname);
                    emp.setLastName(Lname);
                    emp.setAge(Age);
                    emp.setDesignation(Designation);
                    emp.setDob(DOB);
                    emp.setSalary(Salary);

                    Transaction tx = session.beginTransaction();
                    session.save(emp);
                    tx.commit();

                    System.out.println("Employee has been successfully created");
                    break;

                case 2:
                    tx = session.beginTransaction();
                    System.out.println("Enter Employee Id whose details are to be updated");
                    int currentID = s.nextInt();
                    System.out.println("Enter the attribute to update:\n" +
                            "1- Employee ID\n" +
                            "2- First Name\n" +
                            "3- Last Name\n" +
                            "4- Age\n" +
                            "5- Designation\n" +
                            "6- Date of Birth\n" +
                            "7- Salary");
                    int attribute = s.nextInt();
                    switch (attribute) {
                        case 1:
                            System.out.println("Enter New ID");
                            int updatedID = s.nextInt();
                            s.nextLine();

                            String sqlquery = String.format("Update Employee SET EmpId ='%d' where EmpId ='%d';", updatedID, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("Employee ID successfully updated !");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;


                        case 2:
                            System.out.println("Enter the updated First Name");
                            String updatedFname = s.next();
                            sqlquery = String.format("Update Employee SET First_name ='%s' where EmpId ='%d';", updatedFname, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("First Name of employee with ID = " + currentID + "Updated");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;


                        case 3:
                            System.out.println("Enter the updated Last Name");
                            String updatedLname = s.next();
                            sqlquery = String.format("Update Employee SET Last_name ='%s' where EmpId ='%d';", updatedLname, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("Last Name of employee with ID = " + currentID + "Updated");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;

                        case 4:
                            System.out.println("Enter the updated Age of Employee ");
                            int updatedAge = s.nextInt();
                            sqlquery = String.format("Update Employee SET Age ='%s' where EmpId ='%d';", updatedAge, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("Age of employee with ID = " + currentID + "Updated");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;

                        case 5:
                            System.out.println("Enter the updated Designation of Employee ");
                            String updatedDesignation = s.next();
                            sqlquery = String.format("Update Employee SET Designation ='%s' where EmpId ='%d';", updatedDesignation, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("Designation of employee with ID = " + currentID + "Updated");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;


                        case 6:
                            System.out.println("Enter the updated DOB of Employee ");
                            String updatedDOB = s.next();
                            sqlquery = String.format("Update Employee SET DOB ='%s' where EmpId ='%d';", updatedDOB, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("DOB of employee with ID = " + currentID + "Updated");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;

                        case 7:
                            System.out.println("Enter the updated Salary of Employee ");
                            int updatedSalary = s.nextInt();
                            sqlquery = String.format("Update Employee SET Salary ='%s' where EmpId ='%d';", updatedSalary, currentID);
                            try {
                                session.createSQLQuery(sqlquery).executeUpdate();
                                System.out.println("Salary of employee with ID = " + currentID + "Updated");
                                tx.commit();
                            } catch (Exception e2) {
                                System.out.println("Enter the correct Employee ID");
                            }
                            break;
                    }

                case 3:
                    tx = session.beginTransaction();
                    System.out.println("Updating the designation of all employees");
                    String sqlquery = "Update Employee SET Designation = 'Software Engineer' where Designation = 'Intern'";
                    try {
                        session.createSQLQuery(sqlquery).executeUpdate();
                        System.out.println("All records updated");
                        tx.commit();
                    } catch (Exception e) {
                        System.out.println("Can't update fields");
                    }
                    break;
                case 4:

                    tx = session.beginTransaction();
                    System.out.println("Enter the Emplyee ID of the Employee whose records are to be delete");
                    int eiddelete = s.nextInt();
                    sqlquery = String.format("Delete from Employee where EmpId ='%d';", eiddelete);
                    try {
                        session.createSQLQuery(sqlquery).executeUpdate();
                        System.out.println("1 record deleted !");
                        tx.commit();
                    } catch (Exception e2) {
                        System.out.println("Employee Not Found!");
                    }
                    break;

                case 5:

                    List<EmployeeSchema> allemployees = getallemployees(EmployeeSchema.class, session);
                    System.out.println("All Records of Employee Table !! ");
                    for (int i = 0; i < allemployees.size(); i++) {
                        // we need to typecast the object to EmployeeSchema object
                        System.out.println("\nEmployee ID           First Name             Last Name");
                        EmployeeSchema employee = (EmployeeSchema) allemployees.get(i);
                        System.out.println(employee.getId() + "                      " + employee.getFirstName() + "                " + employee.getLastName());
                    }
                    System.out.println("\n\n");


                case 6:
                    System.out.println("Enter id of employee whose records are to be fetched");
                    Eid = s.nextInt();
                    emp = session.load(EmployeeSchema.class, Eid);
                    System.out.println("ID = " + emp.getId());
                    System.out.println("First Name :" + emp.getFirstName());
                    System.out.println(" Last Name : " + emp.getLastName());
                    System.out.println("Date of Birth : " + emp.getDob());
                    System.out.println("Age : " + emp.getAge());
                    System.out.println("Designation : " + emp.getDesignation());
                    System.out.println("Salary : " + emp.getSalary());
                    break;
                case 7:
                    System.out.println("Exitted Successfully");
                    break;

                default:
                    System.out.println("Please select the correct option");
            }
            System.out.println("Do you want to Continue(Y/N)");
            cont = s.next().charAt(0);
        } while (cont == 'y' || cont == 'Y');

    }
}