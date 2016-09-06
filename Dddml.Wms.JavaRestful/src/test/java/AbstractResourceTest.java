import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Li Yongchun on 2016/9/5.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:META-INF/spring/app-context.xml"})
public abstract class AbstractResourceTest {

    public final static String BASE_URL = "http://localhost:8080/";
}
