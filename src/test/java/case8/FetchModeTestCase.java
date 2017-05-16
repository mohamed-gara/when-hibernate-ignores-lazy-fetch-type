package case8;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.parentAndFriends.ParentAndFriendsEntityTable;
import core.table.person.parentAndFriends.Person;
import org.junit.Test;

import static core.table.person.parentAndFriends.ParentAndFriendsEntityTable.PERSON_ID;

@Data(ParentAndFriendsEntityTable.class)
public class FetchModeTestCase extends EntityLoadingTestCase {

    @Test
    public void fetchMode() throws Exception {

        Person person = entityManager.find(Person.class, PERSON_ID);

        assertThat(person)
            .hasEagerlyLoaded("mother")
            .hasLazyLoaded("father")
            .hasEagerlyLoaded("friends");
    }

}
