package case6;

import core.EntityLoadingTestCase;
import org.junit.Test;

import javax.persistence.TypedQuery;

public class JoinFetchTestCase extends EntityLoadingTestCase {

    private static String[] COLUMNS = {"ID", "NAME", "MOTHER_ID", "FATHER_ID"};

    private static final int MOTHER_ID = 1;
    private static final int FATHER_ID = 2;
    private static final int PERSON_ID = 3;

    private static final String MOTHER_NAME = "Yasmine";
    private static final String FATHER_NAME = "Yacine";
    private static final String PERSON_NAME = "Ali";

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
            {PERSON_ID, PERSON_NAME, MOTHER_ID, FATHER_ID}
        };
    }

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
