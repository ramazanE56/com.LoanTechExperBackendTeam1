package hooks.db;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

public class HooksDb {
    @Before
    public void dbHook() {
        System.out.println("creating database connection");
        DBUtils.createConnection();

    }

    @After
    public void afterDbHook() {
        System.out.println("closing database connection");
        DBUtils.closeConnection();

    }
}
