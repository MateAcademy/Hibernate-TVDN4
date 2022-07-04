package author;

import author.entity.Author;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
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

//буду искать автора по имени и email и присваиваю автору id

    public Author getAuthorByNameAndEmail(Author author) {
        try{
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Author a where a.name = :myName and a.email = ?1 ");
            query.setString("myName", author.getName());
            query.setString(1, author.getEmail());
            Author author2 = (Author) query.getSingleResult();
            author.setId(author2.getId());
            session.close();
            return author2;
        } catch (Exception e) {
            System.out.println("нет такого автора");
            return null;
        }

    }
    public Author updateAuthor(Author author) {

        if (author.getId()<=0)
            return null;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author2 = session.get(Author.class, author.getId());
        author2.setName(author.getName());
        author2.setEmail(author.getEmail());
        session.update(author2);
        session.getTransaction().commit();
        session.close();
        return author2;
    }


    //HQL, когда получаем выборку транзакцию не берем и не коммитим: session.getTransaction().commit()
    public List<Author> getListAuthorByName(String name) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Author a where a.name = :myName");
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
        Criteria cb = session.createCriteria(Author.class);
        List<Author> authorList = cb.list();
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
        cq.select(root); // необязательный оператор если нужно получит все значения
        //Этап выполнения запроса
        Query query = session.createQuery(cq);
        List<Author> authorList = query.getResultList();
        session.close();
        return authorList;
    }

    public List<Author> getAuthorList3() {
        Session session = sessionFactory.openSession();

//CriteriaBuilder нужен для построения запроса, с помощью него мы используем разную логику
//т.е это обьект - конструктор запросов для критериа API
        CriteriaBuilder cb = session.getCriteriaBuilder();
//для формирования запроса
        CriteriaQuery cq = cb.createQuery(Author.class);

//первостепенный, корневой entity(в sql запросе)
        Root<Author> root = cq.from(Author.class);
        Selection[] selections = {root.get("id"), root.get("name")};

//указываем класс нашего персистентного обьекта
//для формирования запроса
        cq.select(cb.construct(Author.class, selections));
//        cq.select(root)
//                .where(cb.like(root.<String>get("name"), "%ysh%"));
//                .where(cb.equal(root.<String>get("name"), "%ysh%"));
//                .where(cb.equal(root.<String>get("name"), "Pyshkin"));

        //select id, name From author where last name like %ush%

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

    public void deleteById(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = session.get(Author.class, id);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteCriteria() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

// этап подготовки запроса
//Обьект-конструктор запросов для Criteria API
        CriteriaBuilder cb = session.getCriteriaBuilder();

        CriteriaDelete<Author> cd = cb.createCriteriaDelete(Author.class);

        Root<Author> root = cd.from(Author.class); //первостепенный корневой entity чтобы получить
        // доступ к метаданным (в sql запросе - from)

        cd.where(cb.like(root.<String>get("name"), "%1%"));

//        cd.where(cb.or(
//                cb.and(
//                        cb.like(root.<String>get("name"), "%author"),
//                        cb.like(root.<String>get("lastName"), "%2%")
//                ), cb.equal(root.get("name"), "Lermontov"))
//        );

        Query query = session.createQuery(cd);

        query.executeUpdate();
        session.close();
    }

}
