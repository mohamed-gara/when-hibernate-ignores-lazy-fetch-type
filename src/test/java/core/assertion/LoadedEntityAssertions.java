package core.assertion;

import javax.persistence.PersistenceUnitUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class LoadedEntityAssertions<T> {

    private T loadedEntity;
    private PersistenceUnitUtil puUtil;

    public LoadedEntityAssertions(T entity, PersistenceUnitUtil puUtil) {
        this.loadedEntity = entity;
        this.puUtil =  puUtil;
    }

    public LoadedEntityAssertions hasLazyLoaded(String attibute) {

        assertThat(isLoaded(attibute))
            .isFalse();

        return this;
    }

    public LoadedEntityAssertions hasEagerlyLoaded(String attribute) {

        assertThat(isLoaded(attribute))
            .isTrue();

        return this;
    }

    private boolean isLoaded(String attibute) {
        return puUtil.isLoaded(loadedEntity, attibute);
    }
}