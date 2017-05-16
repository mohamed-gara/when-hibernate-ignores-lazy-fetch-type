package core.table.person.couple;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Person extends core.Person {

    @OneToOne(fetch = LAZY)
    private Person wife;

    @OneToOne(fetch = LAZY, mappedBy = "wife")
    private Person husband;

    public Person getPartner() {

        if((wife != null) && (husband != null))
            throw new IllegalStateException();

        if(wife != null)
            return wife;

        if(husband != null)
            return husband;

        return null;
    }

}
