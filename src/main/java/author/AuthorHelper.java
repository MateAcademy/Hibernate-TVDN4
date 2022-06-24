package author;

import author.entity.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
public class AuthorHelper {

    private SessionFactory sessionFactory;

    public AuthorHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Author addAuthor(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.getTransaction().commit();
        session.close();
        return author;
    }

    public Author update(Author author) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Author author1 = new Author();
        if (author.getId() != 0) {
            author1 = session.get(Author.class, author.getId());
        }

        if (author1 == null) {
            System.out.println("Такого нет автора");
            return null;
        }

        author1.setName(author.getName());
        author1.setLastName(author.getLastName());
        author1.setEmail(author.getEmail());

//        session.save(author1);

        session.flush();

        session.getTransaction().commit();
        session.close();
        return author;
    }


    //HQL, когда получаем выборку транзакцию не берем и не коммитим: session.getTransaction().commit()
    public List<Author> getListAuthorByName(String sql, String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery(sql);
        query.setString("myName", name);
        List authorList = query.list();

//        session.getTransaction().commit();
        session.close();
        return authorList;
    }

    public Author getListAuthorByNameAndId(String name, int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Author a where a.name = :myName and a.id = ?1 ");
        query.setString("myName", name);
        query.setInteger(1, id);
        Author author = (Author) query.getSingleResult();

        session.close();
        return author;
    }

    public List<Author> getAuthorList() {
        //Отктыть сессию - для манипуляции с персист обьектами
        Session session = sessionFactory.openSession();

//Selection  SELECT * FROM cars
        Criteria criteria = session.createCriteria(Author.class, "a");
       //  select * from author a;

        criteria.add(Restrictions.eq("title", "ttt"));
        criteria.add(Restrictions.between("title", 5, 20));
        criteria.add(Restrictions.like("title", "fff"));
        criteria.add(Restrictions.or("title", "fff"));
        criteria.add(Restrictions.sqlRestriction("data>2022-06-06"));
        criteria.addOrder(Order.asc(id));
        // select from Author where title = ttt;

        //       cb.uniqueResult()
        List<Author> authorList = criteria.list();
        session.close();
        return authorList;
    }

    public List<Author> getAuthorList2() {
        //Отктыть сессию - для манипуляции с персист обьектами
        Session session = sessionFactory.openSession();

        //этап подготовки запроса
        //обьект-конструктор запросов для Crteria API
        CriteriaBuilder cb = session.getCriteriaBuilder(); //не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery cq = cb.createQuery(Author.class);
        Root<Author> root = cq.from(Author.class); //первостепенный, корневой author.entity (в aql запросе - from)

        Selection[] selections = {root.get("id"), root.get("name")};

//        cq.select(root); // необязательный оператор если нужно получит все значения
        cq.select(cb.construct(Author.class, selections)); // необязательный оператор если нужно получит все значения

        //Этап выполнения запроса
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }

    public Author getAuthorByID(long id) {
        Session session = sessionFactory.openSession();
        Author author = session.get(Author.class, id);
        session.close();
        return author;
    }

}
