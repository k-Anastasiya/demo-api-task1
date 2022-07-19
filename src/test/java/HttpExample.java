import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;


public class HttpExample {
    public static void main(String[] args) throws IOException {


            try {
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(new HttpGet("https://www.4pda.ru/"));
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String data = IOUtils.toString(entity.getContent());
                    System.out.println("data" + data);
                }
                System.out.println();
                for (Header header : response.getAllHeaders()) {
                    System.out.println(header.getName() + ":" + header.getValue());
                }
                System.out.println();
                System.out.println("ProtocolVersion:" + response.getProtocolVersion());
                System.out.println("Status Code" + response.getStatusLine().getStatusCode());
                System.out.println("reason phrase:" + response.getStatusLine().getReasonPhrase());
                System.out.println("Status.line" + response.getStatusLine().toString());
            } catch (Throwable caurse) {
                caurse.printStackTrace();
            }
        }



}
