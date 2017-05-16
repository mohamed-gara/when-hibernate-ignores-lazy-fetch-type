package core.table.person.family;

import core.table.AbstractEntityTable;

public class FamilyEntityTable extends AbstractEntityTable {

    public static final int MOTHER_ID = 1;
    public static final int FATHER_ID = 2;
    public static final int PERSON_ID = 3;
    public static final int CHILD_ID  = 4;

    public static final String MOTHER_NAME = "Yasmine";
    public static final String FATHER_NAME = "Yacine";
    public static final String PERSON_NAME = "Ali";
    public static final String CHILD_NAME  = "Kimo";

    private static String[] COLUMNS = {"ID", "NAME", "MOTHER_ID", "FATHER_ID"};
    private static final Object[][] ROWS = new Object[][]{
                                              {MOTHER_ID, MOTHER_NAME, null     , null     },
                                              {FATHER_ID, FATHER_NAME, null     , null     },
                                              {PERSON_ID, PERSON_NAME, MOTHER_ID, FATHER_ID},
                                              {CHILD_ID , CHILD_NAME , null     , PERSON_ID}
                                           };

    public FamilyEntityTable() {
        super(Person.class, COLUMNS, ROWS);
    }

}
