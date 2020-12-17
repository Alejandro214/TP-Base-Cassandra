import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SimpleClientTest {
    SimpleClient client;

    @Before
    public void setUp() {
        client = new SimpleClient();
        client.connect("127.0.0.1");
        client.getSession();
        client.createSchema();
        client.loadData();
        client.querySchema();
    }

    @Test
    public void testClient() { }

    @After
    public void clear() {
        client.returnSession().execute("DROP TABLE simplex.playlists");
        client.returnSession().execute("DROP TABLE simplex.songs");
        client.closeSession();
        client.close();
    }
}
