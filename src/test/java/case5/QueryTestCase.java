package case5;

import core.EntityLoadingTestCase;
import org.junit.Test;

import javax.persistence.TypedQuery;

public class QueryTestCase extends EntityLoadingTestCase {

    private static String[] COLUMNS = {"ID", "NAME", "MOTHER_ID", "FATHER_ID"};

    private static final int MOTHER_ID = 1;
    private static final int FATHER_ID = 2;
    private static final int PERSON_ID = 3;
    private static final int CHILD_ID  = 4;

    private static final String MOTHER_NAME = "Yasmine";
    private static final String FATHER_NAME = "Yacine";
    private static final String PERSON_NAME = "Ali";
    private static final String CHILD_NAME  = "Kimo";

    @Override
    protected Class<?> entityClass() {
        return Person.class;
    }

    @Override
    protected String[] columns(){
        return COLUMNS;
    }

    @Override
    protected Object[][] rows(){
        return new Object[][]{
            {MOTHER_ID, MOTHER_NAME, null     , null     },
            {FATHER_ID, FATHER_NAME, null     , null     },
            {PERSON_ID, PERSON_NAME, MOTHER_ID, FATHER_ID},
            {CHILD_ID , CHILD_NAME , null     , PERSON_ID}
        };
    }

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
