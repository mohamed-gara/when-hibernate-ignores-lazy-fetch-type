package case4;

import core.EntityLoadingTestCase;
import org.junit.Test;

public class NotFoundAnnotationTestCase extends EntityLoadingTestCase {

    private static String[] COLUMNS = {"ID", "NAME", "MOTHER_ID", "FATHER_ID"};

    private static final int MOTHER_ID = 1;
    private static final int FATHER_ID = 2;
    private static final int PERSON_ID = 3;

    private static final String MOTHER_NAME = "Yasmine";
    private static final String FATHER_NAME = "Yasine";
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
        return new Object[][] {
            {MOTHER_ID, MOTHER_NAME, null     , null     },
            {FATHER_ID, FATHER_NAME, null     , null     },
            {PERSON_ID, PERSON_NAME, MOTHER_ID, FATHER_ID}
        };
    }
    @Test
    public void loaded() throws Exception {

        Person person = entityManager.find(Person.class, PERSON_ID);

        assertThat(person)
            .hasEagerlyLoaded("mother")
            .hasLazyLoaded("father");

    }

}
