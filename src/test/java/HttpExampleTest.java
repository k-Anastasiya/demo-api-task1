import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

public class HttpExampleTest {
    @Test
    public void checkStatusCodeGetMethod(){
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(new HttpGet("https://www.4pda.ru/"));
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                int expected = 200;
                int actual = response.getStatusLine().getStatusCode();
                Assert.assertEquals(expected,actual);
            }
        } catch (Throwable caurse) {
            caurse.printStackTrace();
        }
    }
}
