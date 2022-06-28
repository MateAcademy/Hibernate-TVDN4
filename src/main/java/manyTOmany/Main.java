package manyTOmany;

import manyTOmany.entity.HomeAddress;
import manyTOmany.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Sergey Klunniy
 */
public class Main {

   // private static final Logger logger = Logger.getGlobal();
    private static final Logger logger2 = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        //logger.info("старт программы");
        logger2.info("main method");

//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("manytomany.cfg.xml").build();
//
//        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//
//
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//
//        HomeAddress homeAddress  = new HomeAddress("Maydan 25A");
//        HomeAddress homeAddress2  = new HomeAddress("Lesy Ukrainka 1");
//        List<HomeAddress> list = new ArrayList<>();
//        list.add(homeAddress);
//        list.add(homeAddress2);
//
//        Person person = new Person("Max", list);
//        List<Person> people = new ArrayList<>();
//        people.add(person);
//
//        homeAddress.setPerson(people);
//        homeAddress2.setPerson(people);
//
//        session.persist(person);
//        session.persist(homeAddress);
//        session.persist(homeAddress2);
//        session.getTransaction().commit();
//        session.close();
    }
}
