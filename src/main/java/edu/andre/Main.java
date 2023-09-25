package edu.andre;

import edu.andre.models.Address;
import edu.andre.models.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        listEmployees();
    }

    private static void listEmployees() {
        System.out.println("### listEmployees");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-pu");
        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("from Employee");
        List<Employee> employees = query.getResultList();

        System.out.println(employees);

        System.out.println("----------------------");

        var t = em.find(Employee.class, 1L);
        System.out.println(t);

        em.close();
        emf.close();
    }

    private static void createEmployees() {
        System.out.println("### createEmployees");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Address address = new Address("Wisdom Street", 70, "Close to patience.");
        Employee employee1 = new Employee("André Felipe", "andre@gmail.com", "123", address);
        Employee employee2 = new Employee("Ana Paula", "ana.paula@gmail.com", "456", address);
        em.persist(address);
        em.persist(employee1);
        em.persist(employee2);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
