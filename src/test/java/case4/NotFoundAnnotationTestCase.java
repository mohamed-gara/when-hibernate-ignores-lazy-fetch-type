package case4;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.parent.ParentEntityTable;
import core.table.person.parent.Person;
import org.junit.Test;

import static core.table.person.parent.ParentEntityTable.PERSON_ID;

@Data(ParentEntityTable.class)
public class NotFoundAnnotationTestCase extends EntityLoadingTestCase {

    @Test
    public void entityIsNotLazyLoaded() throws Exception {

        Person person = entityManager.find(Person.class, PERSON_ID);

        assertThat(person)
            .hasEagerlyLoaded("mother")
            .hasLazyLoaded("father");

    }

}
