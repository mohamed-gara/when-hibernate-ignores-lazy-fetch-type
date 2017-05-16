package case2;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.couple.CoupleEntityTable;
import core.table.person.couple.Person;
import org.junit.Test;

import static core.table.person.couple.CoupleEntityTable.WIFE_ID;

@Data(CoupleEntityTable.class)
public class OneToOneInverseSideTestCase extends EntityLoadingTestCase {

    @Test
    public void inverseSideRelationshipIsNotLazyLoaded() {

        Person person = entityManager.find(Person.class, WIFE_ID);

        assertThat(person)
           .hasEagerlyLoaded("husband");
    }
}
