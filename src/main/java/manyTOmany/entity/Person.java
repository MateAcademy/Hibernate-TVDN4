package manyTOmany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "person")
    private List<HomeAddress> homeAddress;

    public Person(String name, List<HomeAddress> homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }


}
