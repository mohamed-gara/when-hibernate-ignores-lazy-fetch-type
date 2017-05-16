package case1;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.simple.Person;
import core.table.person.simple.PersonEntityTable;
import org.junit.Test;

import static core.table.person.simple.PersonEntityTable.PERSON_ID;

@Data(PersonEntityTable.class)
public class BasicAttributeTestCase extends EntityLoadingTestCase {

    @Test
    public void basicAttributeIsNotLazyLoaded() {

        Person person = entityManager.find(Person.class, PERSON_ID);

        assertThat(person)
            .hasEagerlyLoaded("comment");
    }
}
