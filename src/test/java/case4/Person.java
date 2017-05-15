package case4;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Person extends core.Person {

    @ManyToOne(fetch = LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private Person mother;

    @ManyToOne(fetch = LAZY)
    @NotFound(action = NotFoundAction.EXCEPTION)
    private Person father;

}
