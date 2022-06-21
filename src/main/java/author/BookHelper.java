package author;

import author.entity.Author;
import author.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
public class BookHelper {

    private SessionFactory sessionFactory;

    public BookHelper() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Book addBook(Book book) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public List<Book> getBookList() {
        //Отктыть сессию - для манипуляции с персист обьектами
        Session session = sessionFactory.openSession();

        //этап подготовки запроса
        //обьект-конструктор запросов для Crteria API
        CriteriaBuilder cb = session.getCriteriaBuilder(); //не использовать session.createCriteria, т.к. deprecated
        CriteriaQuery cq = cb.createQuery(Book.class);
        Root<Author> root = cq.from(Book.class); //первостепенный, корневой author.entity (в aql запросе - from)
        cq.select(root); // необязательный оператор если нужно получит все значения

        //Этап выполнения запроса
        Query query = session.createQuery(cq);
        List<Book> bookList = query.getResultList();
        session.close();
        return bookList;
    }

    public Book getBookById(long id) {
        Session session = sessionFactory.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

}
