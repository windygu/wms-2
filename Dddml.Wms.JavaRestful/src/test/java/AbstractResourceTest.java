import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Li Yongchun on 2016/9/5.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:META-INF/spring/app-context.xml"})
public abstract class AbstractResourceTest {

    public final static String BASE_URL = "http://localhost:8080/";

    public String getContentFromResponseInputStream(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String response = sb.toString();
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
}
