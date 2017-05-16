package case7;

import core.EntityLoadingTestCase;
import core.table.Data;
import core.table.person.parent.ParentEntityTable;
import core.table.person.parent.Person;
import org.junit.Test;

import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.Map;

import static core.table.person.parent.ParentEntityTable.PERSON_ID;

@Data(ParentEntityTable.class)
public class EntityGraphTestCase extends EntityLoadingTestCase {

    @Test
    public void overriddenWithEntityGraph() throws Exception {

        EntityGraph<Person> graph = entityManager.createEntityGraph(Person.class);
        graph.addAttributeNodes("mother");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.loadgraph", graph);

        Person person = entityManager.find(Person.class, PERSON_ID, hints);

        assertThat(person)
            .hasEagerlyLoaded("mother")
            .hasLazyLoaded("father");
    }

}
