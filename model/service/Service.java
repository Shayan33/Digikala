package model.service;

import model.common.EntityFactory;
import model.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashSet;
import java.util.Set;

public class Service {
    public void register() {
        EntityManager entityManager = EntityFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer1 = new Customer();
        customer1.setcFName("Shayan");
        customer1.setcLName("Alipour");
        customer1.setcGender("male");
        customer1.setcMail("sth@gmail.com");
        customer1.setcUName("Shayan33");
        customer1.setcPass("myDigiKala123");

        Customer customer2 = new Customer();
        customer2.setcFName("Ali");
        customer2.setcLName("Hejazi");
        customer2.setcGender("male");
        customer2.setcMail("ghtdd@gmail.com");
        customer2.setcUName("Ali35");
        customer2.setcPass("123myDigiKala");

        Category category1 = new Category();
        category1.setCatName("Accessories");

        Category category2 = new Category();
        category2.setCatName("Laptop");

        Category category3 = new Category();
        category3.setCatName("stationery");

        Category category4 = new Category();
        category4.setCatName("SmartPhone");

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setwName("West");

        Warehouse warehouse2 = new Warehouse();
        warehouse2.setwName("South");

        Warehouse warehouse3 = new Warehouse();
        warehouse3.setwName("North");

        Product product1 = new Product();
        product1.setpName("HTC M9Plus");
        product1.setAvailable("yes");
        product1.setPrice("500$");
        product1.setWqty("33");
        product1.setWarehouse(warehouse2);
        product1.setCategory(category4);

        Product product2 = new Product();
        product2.setpName("Lenovo Z500");
        product2.setAvailable("no");
        product2.setPrice("800$");
        product2.setWqty("0");
        product2.setWarehouse(warehouse3);
        product2.setCategory(category2);

        Product product3 = new Product();
        product3.setpName("Pen");
        product3.setAvailable("yes");
        product3.setPrice("3$");
        product3.setWqty("35");
        product3.setWarehouse(warehouse1);
        product3.setCategory(category3);

        Product product4 = new Product();
        product4.setpName("Glass");
        product4.setAvailable("yes");
        product4.setPrice("230$");
        product4.setWqty("5");
        product4.setWarehouse(warehouse1);
        product4.setCategory(category1);

        Department department1 = new Department();
        department1.setdName("Support");

        Department department2 = new Department();
        department2.setdName("Sales");

        Department department3 = new Department();
        department3.setdName("Finance");

        Employee employee1 = new Employee();
        employee1.seteFName("Reza");
        employee1.seteLName("Zadeh");
        employee1.setDepartment(department1);

        Employee employee2 = new Employee();
        employee2.seteFName("Kamal");
        employee2.seteLName("Karimi");
        employee2.setDepartment(department2);

        Employee employee3 = new Employee();
        employee3.seteFName("Ebrahim");
        employee3.seteLName("Noori");
        employee3.setDepartment(department2);

        Employee employee4 = new Employee();
        employee4.seteFName("Hamid");
        employee4.seteLName("Asgari");
        employee4.setDepartment(department3);

        Employee employee5 = new Employee();
        employee5.seteFName("Parham");
        employee5.seteLName("Majlesi");
        employee5.setDepartment(department2);

        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(category1);
        entityManager.persist(category2);
        entityManager.persist(category3);
        entityManager.persist(category4);
        entityManager.persist(warehouse1);
        entityManager.persist(warehouse2);
        entityManager.persist(warehouse3);
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.persist(product4);
        entityManager.persist(department1);
 9o0i00999oo9o]9o9ooo9o       entityManager.persist(department2);
        entityManager.persist(department3);
        entityManager.persist(employee1);
        entityManager.persist(employee2);
        entityManager.persist(employee3);
        entityManager.persist(employee4);
        entityManager.persist(employee5);


        //Test Address $ Customer Relation Initialization
        /*Set<Customer> ad1 = new HashSet<>();
        Set<Customer> ad2 = new HashSet<>();


        Customer customer1 = new Customer();
        customer1.setcFName("Shayan");
        customer1.setcLName("Alipour");
        customer1.setcGender("male");
        customer1.setcMail("sth@gmail.com");
        customer1.setcUName("Shayan33");
        customer1.setcPass("myDigiKala123");

        Customer customer2 = new Customer();
        customer2.setcFName("Ali");
        customer2.setcLName("Hejazi");
        customer2.setcGender("male");
        customer2.setcMail("ghtdd@gmail.com");
        customer2.setcUName("Ali35");
        customer2.setcPass("123myDigiKala");

        Set<Address> c1 = new HashSet<>();
        Set<Address> c2 = new HashSet<>();

        Address address1 = new Address();
        address1.setAddress("Markham,ON,Canada");

        Address address2 = new Address();
        address2.setAddress("Shahran,Tehran,Iran");

        ad1.add(customer1);

        ad2.add(customer1);
        ad2.add(customer2);


        c1.add(address1);
        c1.add(address2);

        c2.add(address2);

        customer1.setAddresses(c1);
        customer2.setAddresses(c2);

        address1.setCustomers(ad1);
        address2.setCustomers(ad2);

        System.out.println(customer1.getAddresses());
        System.out.println("****");
        System.out.println(customer2.getAddresses());

        entityManager.persist(customer1);
        entityManager.persist(customer2);
        entityManager.persist(address1);
        entityManager.persist(address2);*/

        entityTransaction.commit();
        entityManager.close();


    }
}
