package core.table.person.parentAndFriends;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Data
public class Person extends core.Person {

    @ManyToOne(fetch = LAZY)
    @Fetch(FetchMode.JOIN)
    private Person mother;

    @ManyToOne(fetch = LAZY)
    private Person father;

    @OneToMany
    @JoinColumn(name = "FRIEND_ID")
    @Fetch(FetchMode.JOIN)
    private List<Person> friends;

}
