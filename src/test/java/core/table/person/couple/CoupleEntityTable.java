package core.table.person.couple;

import core.table.AbstractEntityTable;

public class CoupleEntityTable extends AbstractEntityTable {

    public static final int HUSBAND_ID = 1;
    public static final int WIFE_ID    = 2;

    public static final String WIFE_NAME    = "Yasmine";
    public static final String HUSBAND_NAME = "Yacine";

    private static final String[] COLUMNS = {"ID", "NAME", "WIFE_ID"};
    private static final Object[][] ROWS = new Object[][] {
                                                  {WIFE_ID   , WIFE_NAME   , null   },
                                                  {HUSBAND_ID, HUSBAND_NAME, WIFE_ID}
                                               };

    public CoupleEntityTable() {
        super(Person.class, COLUMNS, ROWS);
    }

}
