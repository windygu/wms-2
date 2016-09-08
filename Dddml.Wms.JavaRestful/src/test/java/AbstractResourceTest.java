import org.apache.http.HttpResponse;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/**
 * Created by Li Yongchun on 2016/9/5.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:META-INF/spring/app-context.xml"})
public abstract class AbstractResourceTest {

    public final static String BASE_URL = "http://localhost:8080/";

    public String getConentFromResponse(HttpResponse response) {
        if (response == null) {
            return null;
        }
        try {
            if (response.getEntity() == null || response.getEntity().getContent() == null) {
                return null;
            }
            return getContentFromResponseInputStream(response.getEntity().getContent());
        } catch (Exception ex) {
            return null;
        }
    }


    public String getContentFromResponseInputStream(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String response = sb.toString();
            System.out.println(response);
            return response;
        } catch (IOException ex) {
            return null;
        } finally {
            try {
                reader.close();
                inputStreamReader.close();
            } catch (Exception ex) {
            }
        }
    }

    public String getContentFromConnection(HttpURLConnection connection) {
        if (connection == null) {
            return null;
        }
        InputStream inputStream = null;
        try {
            int responseCode = connection.getResponseCode();
            if (String.valueOf(responseCode).startsWith("20")) {
                inputStream = connection.getInputStream();
            } else {
                inputStream = connection.getErrorStream();
            }
        } catch (Exception ex) {
            return null;
        }
        return getContentFromResponseInputStream(inputStream);
    }
}
