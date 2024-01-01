package hooks.db;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

public class HooksDb extends DBUtils {
    @Before
    public void dbHook() {
        System.out.println("creating database connection");
        createConnection();

    }

    @After
    public void afterDbHook() {
        System.out.println("closing database connection");
        closeConnection();

    }
}
