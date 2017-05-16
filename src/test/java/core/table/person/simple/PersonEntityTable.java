package core.table.person.simple;

import core.table.AbstractEntityTable;

public class PersonEntityTable extends AbstractEntityTable {

    public static final int PERSON_ID = 1;
    public static final String PERSON_NAME = "Gara";
    public static final String PERSON_COMMENT = "All rights ...";

    private static final String[] COLUMNS = {"ID", "NAME", "COMMENT"};
    private static final Object[][] ROWS = new Object[][]{
                                                   {PERSON_ID, PERSON_NAME, PERSON_COMMENT}
                                               };

    public PersonEntityTable() {
        super(Person.class, COLUMNS, ROWS);
    }

}
