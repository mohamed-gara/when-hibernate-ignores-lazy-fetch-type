package core.table.person.parentAndFriends;

import core.table.AbstractEntityTable;

public class ParentAndFriendsEntityTable extends AbstractEntityTable {

    public static final int MOTHER_ID = 1;
    public static final int FATHER_ID = 2;
    public static final int PERSON_ID = 3;
    public static final int FRIEND_ID = 4;

    public static final String MOTHER_NAME = "Yasmine";
    public static final String FATHER_NAME = "Yacine";
    public static final String PERSON_NAME = "Ali";
    public static final String FRIEND_NAME = "Med";

    private static final String[] COLUMNS = {"ID", "NAME", "MOTHER_ID", "FATHER_ID", "FRIEND_ID"};
    private static final Object[][] ROWS = new Object[][] {
                                               {MOTHER_ID, MOTHER_NAME, null     , null     , null     },
                                               {FATHER_ID, FATHER_NAME, null     , null     , null     },
                                               {PERSON_ID, PERSON_NAME, MOTHER_ID, FATHER_ID, null     },
                                               {FRIEND_ID, FRIEND_NAME, null     , null     , PERSON_ID}
                                           };

    public ParentAndFriendsEntityTable() {
        super(Person.class, COLUMNS, ROWS);
    }

}
