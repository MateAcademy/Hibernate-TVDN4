package manyTOmany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import manyTOmany.entity.Person;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sergey Klunniy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HomeAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;

    @ManyToMany
    @JoinTable(name = "address_persons")
    private List<Person> person;

}
