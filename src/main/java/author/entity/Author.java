package author.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Sergey Klunniy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "first_name")
    private String name;
    private String email;

    public Author(String name) {
        this.name = name;
    }

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
//        if (email == null)
//            return "Author{" +
//                    "id=" + id +
//                    ", name='" + name;

        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
