package case3;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.couple.CoupleEntityTable;
import core.table.person.couple.Person;
import org.junit.Test;

import static core.table.person.couple.CoupleEntityTable.HUSBAND_ID;
import static core.table.person.couple.CoupleEntityTable.WIFE_ID;

@Data(CoupleEntityTable.class)
public class AlreadyInPersistenceContextTestCase extends EntityLoadingTestCase {

    @Test
    public void lazyLoaded() throws Exception {

        Person husband = entityManager.find(Person.class, HUSBAND_ID);

        assertThat(husband)
            .hasLazyLoaded("wife");

    }

    @Test
    public void alreadyLoaded() throws Exception {

        entityManager.find(Person.class, WIFE_ID);
        Person husband = entityManager.find(Person.class, HUSBAND_ID);

        assertThat(husband)
            .hasEagerlyLoaded("wife"); // hasAlreadyLoaded

    }

}
