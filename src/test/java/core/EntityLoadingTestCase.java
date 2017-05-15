package core;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.Destination;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Insert;
import com.ninja_squad.dbsetup.operation.Operation;
import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import java.util.HashMap;
import java.util.Map;

import static com.ninja_squad.dbsetup.Operations.*;
import static java.util.Arrays.asList;
import static org.hibernate.cfg.AvailableSettings.*;

public abstract class EntityLoadingTestCase {

    private static final String TEST_DB_URL = "jdbc:h2:mem:db1;DB_CLOSE_DELAY=-1";
    private static final String TEST_DB_USER = "sa";
    private static final String TEST_DB_PASSWORD = "";

    protected EntityManager entityManager;
    protected PersistenceUnitUtil puUtil;

    @Before
    public void init() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default", properties());
        entityManager = entityManagerFactory.createEntityManager();
        puUtil = entityManagerFactory.getPersistenceUnitUtil();

        DbSetup dbSetup = new DbSetup(destination(), operations());
        dbSetup.launch();
    }

    @After
    public void destroy() {
        entityManager.getEntityManagerFactory().close();
    }

    protected abstract Class<?> entityClass();

    protected abstract String[] columns();

    protected abstract Object[][] rows();

    private Map<String, Object> properties() {

        Map<String, Object> properties = new HashMap<>();

        properties.put(SCANNER          , new SingleClassScanner(entityClass()));
        properties.put(JPA_JDBC_URL     , TEST_DB_URL);
        properties.put(JPA_JDBC_USER    , TEST_DB_USER);
        properties.put(JPA_JDBC_PASSWORD, TEST_DB_PASSWORD);

        return properties;
    }

    private Destination destination() {
        return new DriverManagerDestination(TEST_DB_URL, TEST_DB_USER, TEST_DB_PASSWORD);
    }

    private Operation operations() {

        Insert.Builder insertOperationBuilder = insertInto(table())
                                                    .columns(columns());

        asList(rows())
            .forEach(insertOperationBuilder::values);

        return sequenceOf(
                          deleteAllFrom(table()),
                          insertOperationBuilder.build()
                         );
    }

    private String table() {
        return entityClass().getSimpleName();
    }

    protected String quote(String string) {
        return String.format("'%s'", string);
    }

    protected <T> LoadedEntityAssertions<T> assertThat(T entity){
        return new LoadedEntityAssertions<>(entity, puUtil);
    }

}
