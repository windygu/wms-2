package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.dddml.wms.specialization.PropertyMetadataDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Li Yongchun on 2016/9/7.
 */
public class LocatorTreesResourceTest extends AbstractResourceTest {
    private final static CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    private final static String RESOURCE_RUL = BASE_URL.concat("locatorTrees/");

    @Test
    public void GetMetadataFilteringFieldsTest() throws IOException {
        String url = RESOURCE_RUL.concat("_metadata/filteringFields");
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        String responseText = getConentFromResponse(response);
        Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
        List<PropertyMetadataDto> dtos = JSON.parseArray(responseText, PropertyMetadataDto.class);
        System.out.print(JSON.toJSONString(dtos, SerializerFeature.PrettyFormat));
    }
}
