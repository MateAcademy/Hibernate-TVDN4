package author;

import author.entity.Author;
import author.entity.Book;

import java.util.List;

/**
 * @author Sergey Klunniy
 */
public class Main {
    public static void main(String[] args) {
//        BookHelper bk = new BookHelper();

//        Book book = new Book("Java Proffessional", "SOLID");
//        bk.addBook(book);
//
//        List<Book> bookList = bk.getBookList();
//        for (Book book : bookList) {
//            System.out.println(book);
//        }

//        System.out.println();
//
//        System.out.println(bk.getBookById(1l));

//        System.out.println(bookList);


        AuthorHelper ah = new AuthorHelper();
        ah.update(new Author(8L, "Oleksandr7", "PP"));

//        Author authorByID = ah.getAuthorByID(2);
//        authorByID.setName("Oleksandr12");
//        authorByID.setLastName("Pushkin12");
//        List<Author> pyshkin = ah.getListAuthorByName("from Author a where a.name = :myName", "Oleksandr");
//        System.out.println(pyshkin);


//        Author author = new Author("Mike");
//        Author a = new Author("Dolla6", "dolla6@gmail.com", "Joy");
//        ah.addAuthor(author);
//        ah.addAuthor(a);
//
//        List<Author> authorList = ah.getListAuthorByName("Pyshkin");
//        List<Author> authorList = ah.getAuthorList();
//        for (Author author : authorList) {
//            System.out.println(author.getId() + " " + author.getName() + " " + author.getEmail());
//        }
//
//        System.out.println(ah.getListAuthorByNameAndId("Pyshkin", 2));
//
////        List<Author> authorList = ah.getAuthorList();
////        for (Author author : authorList) {
////            System.out.println(author.getId() + " " + author.getName());
////        }
//
////        List<Author> authorList = ah.getAuthorList2();
////        for (Author author : authorList) {
////            System.out.println(author.getId() + " " + author.getName());
////        }
//
////        System.out.println(ah.getAuthorByID(2));

    }
}
