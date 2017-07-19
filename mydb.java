package memorizeappwithdbflow.fisher.com.memorizeappwithdbflow;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Mohammad Hasan on 6/16/2017.
 */

@Database(name = mydb.NAME, version = mydb.VERSION)
public class mydb {
    public static final String NAME = "mydb";

    public static final int VERSION = 1;
}
