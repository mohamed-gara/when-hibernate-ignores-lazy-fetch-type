package case6;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Person extends core.Person {

    @ManyToOne(fetch = LAZY)
    private Person mother;

    @ManyToOne(fetch = LAZY)
    private Person father;

}
