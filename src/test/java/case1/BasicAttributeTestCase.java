package case1;

import core.EntityLoadingTestCase;
import org.junit.Test;

public class BasicAttributeTestCase extends EntityLoadingTestCase {

    private static final String[] COLUMNS = {"ID", "NAME", "COMMENT"};

    private static final int    PERSON_ID = 1;
    private static final String PERSON_NAME = "Gara";
    private static final String PERSON_COMMENT = "All rights ...";

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
            {PERSON_ID, PERSON_NAME, PERSON_COMMENT}
        };
    }

    @Test
    public void basicAttributeIsEagerlyLoaded() throws Exception {

        Person person = entityManager.find(Person.class, PERSON_ID);

        assertThat(person)
            .hasEagerlyLoaded("comment");
    }
}
