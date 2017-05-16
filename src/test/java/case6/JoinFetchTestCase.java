package case6;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.parent.ParentEntityTable;
import core.table.person.parent.Person;
import org.junit.Test;

import javax.persistence.TypedQuery;

import static core.table.person.parent.ParentEntityTable.PERSON_ID;

@Data(ParentEntityTable.class)
public class JoinFetchTestCase extends EntityLoadingTestCase {

    @Test
    public void overriddenUsingFetch() throws Exception {

        String queryString = "SELECT person              " +
                             "FROM Person person         " +
                             "  JOIN FETCH person.mother " +
                             "WHERE person.id = %d       ";

        queryString = String.format(queryString, PERSON_ID);

        TypedQuery<Person> query = entityManager.createQuery(queryString, Person.class);

        Person person = query.getSingleResult();

        assertThat(person)
            .hasEagerlyLoaded("mother")
            .hasLazyLoaded("father");
    }

}
