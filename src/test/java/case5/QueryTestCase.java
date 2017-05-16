package case5;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.family.FamilyEntityTable;
import core.table.person.family.Person;
import org.junit.Test;

import javax.persistence.TypedQuery;

import static core.table.person.family.FamilyEntityTable.CHILD_NAME;
import static core.table.person.family.FamilyEntityTable.MOTHER_NAME;

@Data(FamilyEntityTable.class)
public class QueryTestCase extends EntityLoadingTestCase {

    @Test
    public void query() throws Exception {

        String queryString = "SELECT DISTINCT person           " +
                             "FROM Person person               " +
                             "  JOIN person.children child     " +
                             "WHERE person.mother.name LIKE %s " +
                             "  AND child.name = %s            ";

        queryString = String.format(queryString, quote(MOTHER_NAME), quote(CHILD_NAME));

        TypedQuery<Person> query = entityManager.createQuery(queryString, Person.class);

        Person person = query.getSingleResult();

        assertThat(person)
            .hasLazyLoaded("children")
            .hasLazyLoaded("mother")
            .hasLazyLoaded("father");
    }

}
