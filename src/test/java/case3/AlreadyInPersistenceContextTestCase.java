package case3;

import core.EntityLoadingTestCase;
import org.junit.Test;

public class AlreadyInPersistenceContextTestCase extends EntityLoadingTestCase {

    private static final String[] COLUMNS = {"ID", "NAME", "WIFE_ID"};

    private static final int HUSBAND_ID = 1;
    private static final int WIFE_ID    = 2;

    private static final String WIFE_NAME    = "Yasmine";
    private static final String HUSBAND_NAME = "Yasine";

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
            {WIFE_ID   , WIFE_NAME   , null   },
            {HUSBAND_ID, HUSBAND_NAME, WIFE_ID}
        };
    }

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
