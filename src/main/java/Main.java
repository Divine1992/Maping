import com.divine.main.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager em = null;
        try{
            factory = Persistence.createEntityManagerFactory("Hibernate");
            em = factory.createEntityManager();
            em.getTransaction().begin();

            createManyToMany(em);

            em.getTransaction().commit();
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            em.close();
            factory.close();
        }
    }

    private static void createMe(EntityManager em){
        User user = new User();
        user.setName("Yurii");
        user.setSurname("Hizun");
        em.persist(user);
    }

    private static void createInheritance(EntityManager em){
        Company company = new Company();
        company.setName("C1");

        Departament departament = new Departament();
        departament.setCountEmployee(100);

        Headquoter headquoter = new Headquoter();
        headquoter.setName("Boby");

        em.persist(company);
        em.persist(departament);
        em.persist(headquoter);
    }

    private static void createManyToOne(EntityManager em){
        School school = new School();
        school.setAddress("Kiev");
        List<Children> childrens = new ArrayList<>();

        Children children1 = new Children();
        children1.setName("Ben");
        children1.setSchool(school);
        Children children2 = new Children();
        children2.setName("Ana");
        children2.setSchool(school);

        childrens.add(children1);
        childrens.add(children2);
        school.setChildrens(childrens);

        em.persist(school);

    }

    private static void createOneToOne(EntityManager em){
        Owner owner = new Owner();
        owner.setName("Ben");
        Car car = new Car();
        car.setModel("BMW");
        car.setOwner(owner);
        owner.setCar(car);
        em.persist(owner);
    }

    private static void createManyToMany(EntityManager em){
        Customer customer1 = new Customer();
        customer1.setName("C1");
        Customer customer2 = new Customer();
        customer2.setName("C2");

        Staff s1 = new Staff();
        s1.setName("нннн");
        Staff s2 = new Staff();
        s2.setName("фівіфв");
        Staff s3 = new Staff();
        s3.setName("йййй");
        Set<Staff> staffSet = new HashSet<>();
        staffSet.add(s1);
        staffSet.add(s2);
        customer1.setStaffs(staffSet);
        staffSet.add(s3);
        customer2.setStaffs(staffSet);

        Task task1 = new Task();
        task1.setName("Заказ1");
        Task task2 = new Task();
        task2.setName("Заказ2");
        Set<Task> orders = new HashSet<>();
        orders.add(task1);
        orders.add(task2);
        customer2.setTasks(orders);

        em.persist(customer1);
        em.persist(customer2);
    }
}
