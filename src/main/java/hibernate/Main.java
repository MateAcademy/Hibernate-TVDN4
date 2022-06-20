package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

/**
 * @author Sergey Klunniy
 */
public class Main {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(new Student("Max"));
            session.getTransaction().commit();
            session.close();
        }
    }
}
