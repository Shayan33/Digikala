package model.service;

import model.common.EntityFactory;
import model.entity.Category;
import model.entity.Customer;
import model.entity.Product;
import model.entity.Warehouse;
import org.infinispan.notifications.cachelistener.annotation.TransactionRegistered;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class Methods {


    public List<Product> selectAllProducts() {
        EntityManager entityManager = EntityFactory.getEntityManager();
        Query query = entityManager.
                createQuery("SELECT PRO FROM product PRO");
        List<Product> productList = query.getResultList();
        return productList;
    }

    public List<Category> selectAllCategories() {
        EntityManager entityManager = EntityFactory.getEntityManager();
        Query query = entityManager.
                createQuery("SELECT CAT FROM category CAT");
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }

    public List<Customer> selectAllCustomers() {
        EntityManager entityManager = EntityFactory.getEntityManager();
        Query query = entityManager.
                createQuery("SELECT CUS FROM customer CUS");
        List<Customer> customerList = query.getResultList();
        return customerList;
    }

    @TransactionRegistered
    public void updateProductList(Product product) {


        EntityManager entityManager = EntityFactory.getEntityManager();
        entityManager.getTransaction().begin();
        /* Query query = entityManager.
                createQuery("UPDATE product PRO SET PRO.wqty = :wqty, PRO.available = :available WHERE PRO.id = :id");
        query.setParameter("id", inId);
        query.setParameter("available", inAvailable);
        query.setParameter("wqty", inWqty);*/

        /*Query query = entityManager.
                createQuery("UPDATE product PRO SET PRO.wqty = 3 WHERE PRO.id = :id");
        int updateCount = query.setParameter("id", inId).executeUpdate();*/

        //entityManager.createQuery("UPDATE product SET wqty = 3 WHERE id = 3").executeUpdate();

        Product product1 = entityManager.find(Product.class, product.getId());
        entityManager.merge(product1);
        product1.setWqty(product.getWqty());
        entityManager.getTransaction().commit();


    }

    public void addProduct(Product product) {

        EntityManager entityManager = EntityFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Product product1 = new Product();
        product1.setpName(product.getpName());
        product1.setAvailable(product.getAvailable());
        product1.setPrice(product.getPrice());
        product1.setWqty(product.getWqty());
        product1.setWarehouse(product.getWarehouse());
        product1.setCategory(product.getCategory());

        entityManager.persist(product1);

        entityTransaction.commit();
        entityManager.close();
    }

    public void updateProductTable(List<Product> productList) {
        for (int i = 0; i < productList.size(); i++) {
            updateProductList(productList.get(i));
        }
    }

    public void addWarehouse(Warehouse warehouse) {
        EntityManager entityManager = EntityFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Warehouse warehouse1 = new Warehouse();
        warehouse1.setwName(warehouse.getwName());

        entityManager.persist(warehouse1);

        entityTransaction.commit();
        entityManager.close();

    }

    public void deleteProduct(Product product){
        EntityManager entityManager = EntityFactory.getEntityManager();
        Query q = entityManager.createQuery("from product where id = :prid ");
        q.setParameter("prid", product.getId());
        Product product1 = (Product) q.getResultList().get((int) product.getId());
        entityManager.remove(product1);

    }

    public void addCustomer (Customer customer) {
        EntityManager entityManager = EntityFactory.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer1 = new Customer();
        customer1.setcFName(customer.getcFName());
        customer1.setcLName(customer.getcLName());
        customer1.setcGender(customer.getcGender());
        customer1.setcMail(customer.getcMail());
        customer1.setcUName(customer.getcUName());
        customer1.setcPass(customer.getcPass());

        entityManager.persist(customer1);

        entityTransaction.commit();
        entityManager.close();

    }








    /*public Methods() throws RemoteException {

    }*/

  /*  @Override
    public Boolean validateUser(String username, String password) throws Exception {
        System.out.println("****login done*****");
        return true;
    }*/


}