package NewClass;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Sergey Klunniy
 */
@Entity
@Table(name = "author", schema = "library", catalog = "")
public class AuthorEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }
}
