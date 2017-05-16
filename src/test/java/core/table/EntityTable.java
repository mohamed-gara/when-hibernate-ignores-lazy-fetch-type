package core.table;

public interface EntityTable {

    Class<?> entityClass();

    String name();

    String[] columns();

    Object[][] rows();

}
