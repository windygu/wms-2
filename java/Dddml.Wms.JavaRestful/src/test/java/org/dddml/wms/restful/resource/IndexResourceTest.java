package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Li Yongchun on 2016/9/5.
 */
public class IndexResourceTest extends AbstractResourceTest {
    @Test
    public void getIndex() {
        String url = "http://localhost:8080/";
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            Assert.assertEquals(connection.getResponseCode(), HttpURLConnection.HTTP_OK);
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String response = sb.toString();
            System.out.println(response);
            IndexResource.PersonTemp personTemp = JSONObject.parseObject(response, IndexResource.PersonTemp.class);
            Assert.assertNotNull(personTemp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
