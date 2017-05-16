package core.table.person.family;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Person extends core.Person {

    @ManyToOne(fetch = LAZY)
    private Person mother;

    @ManyToOne(fetch = LAZY)
    private Person father;

    @OneToMany(mappedBy = "father")
    private List<Person> children;

    //@OneToMany(mappedBy = "mother")
    //private List<Person> children;

}
