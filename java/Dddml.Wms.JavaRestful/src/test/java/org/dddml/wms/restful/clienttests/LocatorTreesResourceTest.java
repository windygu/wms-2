package org.dddml.wms.restful.clienttests;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.dddml.wms.specialization.PropertyMetadataDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Created by Li Yongchun on 2016/9/7.
 */
public class LocatorTreesResourceTest extends AbstractResourceTest {
    private final static String RESOURCE_RUL = BASE_URL.concat("locatorTrees/");

    @Test
    public void GetMetadataFilteringFieldsTest() throws IOException {
        String url = RESOURCE_RUL.concat("_metadata/filteringFields");
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        HttpResponse response = HTTP_CLIENT.execute(httpGet);
        String responseText = getContentFromResponse(response);
        Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
        List<PropertyMetadataDto> dtos = JSON.parseArray(responseText, PropertyMetadataDto.class);
        //System.out.print(JSON.toJSONString(dtos, SerializerFeature.PrettyFormat));
    }

    @Test
    public void getLocatorTreesByFilter() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
            Timestamp timestamp1=Timestamp.from(instant);
            LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            ZoneId zoneId=ZoneId.of("Asia/Shanghai");
            Date now=new Date();
            String nowString= now.toString();
            Timestamp timestamp2=new Timestamp(now.getTime());

            Instant instant3=now.toInstant();
            String time=instant3.toString();
            LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
            LocalDateTime localDateTime3 = localDateTime1.atZone(ZoneId.systemDefault()).toLocalDateTime();
            Assert.assertEquals(0, localDateTime1.compareTo(localDateTime3));
            Instant instant1 = localDateTime1.toInstant(ZoneOffset.UTC);
            Instant instant2 = localDateTime2.toInstant(ZoneOffset.UTC);
            int five = 5;

        } catch (Exception ex) {

        }
    }
}
