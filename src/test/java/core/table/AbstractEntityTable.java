package core.table;

public abstract class AbstractEntityTable implements EntityTable {

    private Class<?> entityClass;

    private String[] columns;

    private Object[][] rows;

    public AbstractEntityTable(Class<?> entityClass, String[] columns, Object[][] rows) {
        this.entityClass = entityClass;
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public Class<?> entityClass() {
        return entityClass;
    }

    @Override
    public String name(){
        return entityClass.getSimpleName();
    }

    @Override
    public String[] columns() {
        return columns;
    }

    @Override
    public Object[][] rows() {
        return rows;
    }
}
