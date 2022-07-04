package author;

import author.entity.Author;

import java.util.List;

/**
 * @author Sergey Klunniy
 */
public class Main {

//Прикрутить update, логгирование и опшинал
    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();

// 1.
//        Author a = ah.getAuthorByID(1);
//
//        Author author = new Author("Taras", "taras@gmail.com");
//        ah.getAuthorByNameAndEmail(author);
//
//        author.setEmail(null);
//        ah.updateAuthor(author);

//2.
        List<Author> authorList = ah.getAuthorList3();
        authorList.forEach(System.out::println);

//3. удаление
//        ah.deleteById(14);







////        Author author = new Author("Mike" );
//        Author author = new Author("Dolla", "dolla@gmail.com");
//        ah.addAuthor(author);

//        List<Author> authorList = ah.getListAuthorByName("Pyshkin");
////        for (Author author : authorList) {
////            System.out.println(author.getId() + " " + author.getName());
////        }
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
