package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.dddml.wms.domain.AttributeSetInstanceStateDto;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by Li Yongchun on 2016/9/10.
 */
public class AttributeSetInstanceResourceTest extends AbstractResourceTest {

    private final static String RESOURCE_URL = BASE_URL.concat("attributeSetInstances");

    /**
     * public JSONArray GetAll(@Context HttpServletRequest request,
     *
     * @QueryParam("sort") String sort,
     * @QueryParam("fields") String fields,
     * @DefaultValue("0") @QueryParam("firstResult") Integer firstResult,
     * @QueryParam("maxResults") Integer maxResults,
     * @QueryParam("filter") String filter) {
     */
    @Test
    public void getAllTest() {
        //AttributeSetInstanceStateDto dto = new AttributeSetInstanceStateDto();
        String sort = "createdAt";
        String fields = "";// "attributeSetInstanceId,attributeSetId,color";
        Integer firstResult = 0;
        Integer maxResults = 2;
        // 先不测试filter
        //String filter= JSONObject.toJSONString(dto);
        String url = RESOURCE_URL.concat("?sort=").concat(sort).concat("&fields=").concat(fields).concat("&firstResult=")
                .concat(String.valueOf(firstResult)).concat("&maxResults=").concat(String.valueOf(maxResults));
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON);
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpGet);
            String responseText = getContentFromResponse(response);
            System.out.println(responseText);
            Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
            JSONArray jsonArray = JSONArray.parseArray(responseText);
            Assert.assertEquals(true, jsonArray.size() >= 0);
            jsonArray.forEach(o -> {
                JSONObject jsonObject = (JSONObject) o;
                jsonObject.entrySet().forEach((entry) -> {
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                });
            });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void getByIdTest() {
        String attributeSetInstanceId = "4af69ca7-59c3-4ec2-827a-73c6f05ffce6";
        String url = RESOURCE_URL.concat("/").concat(attributeSetInstanceId);
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON);
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpGet);
            String responseText = getContentFromResponse(response);
            System.out.println(responseText);
            Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
            if (response.getStatusLine().getStatusCode() == Response.Status.OK.getStatusCode()) {
                JSONObject jsonObject = JSONObject.parseObject(responseText);
                Assert.assertNotNull(jsonObject);
                System.out.println(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void getCount() {
        String url = RESOURCE_URL.concat("/_count").concat("?attributeSetId=").concat("TestColorAttributeSetId8c0fXA8idM6GE");
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader(HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON);
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpGet);
            String responseText = getContentFromResponse(response);
            System.out.println(responseText);
            Assert.assertEquals(true, String.valueOf(response.getStatusLine().getStatusCode()).startsWith("20"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void putTest() {
        String attributeSetInstanceId = UUID.randomUUID().toString();
        String url = RESOURCE_URL.concat("/").concat(attributeSetInstanceId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("serialNumber", "serialNumber");
        jsonObject.put("lot", "lot");
        jsonObject.put("description", "description");
        jsonObject.put("attributeSetInstanceId", attributeSetInstanceId);
        jsonObject.put("attributeSetId", "TestColorAttributeSetId8c0fXA8idM6GE");
        jsonObject.put("Color", "G");//注意，凡是动态字段的属性名称第一个字母必须大写，否则影响转换
        HttpPut httpPut = new HttpPut(url);
        StringEntity entity = new StringEntity(jsonObject.toJSONString(), "utf-8");
        entity.setContentType(MediaType.APPLICATION_JSON);
        httpPut.setEntity(entity);
        httpPut.setHeader(HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON);
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpPut);
            System.out.println(getContentFromResponse(response));
            Assert.assertEquals(204, response.getStatusLine().getStatusCode());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void postTest() {
        String url = RESOURCE_URL;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("serialNumber", "serialNumber");
        jsonObject.put("lot", "lot");
        jsonObject.put("description", "description");
        jsonObject.put("attributeSetId", "TestColorAttributeSetId8c0fXA8idM6GE");
        jsonObject.put("Color", "P");//注意，凡是动态字段的属性名称第一个字母必须大写，否则影响转换
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(jsonObject.toJSONString(), "utf-8");
        entity.setContentType(MediaType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        httpPost.setHeader(HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON);
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpPost);
            String attributeSetInstanceId = getContentFromResponse(response);
            System.out.println(attributeSetInstanceId);
            Assert.assertNotNull(attributeSetInstanceId);
            Assert.assertEquals(201, response.getStatusLine().getStatusCode());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void patchTest() {
        String attributeSetInstanceId = "a6ba1b3c-622a-4f3b-8782-42078c3942d0";
        String url = RESOURCE_URL.concat("/").concat(attributeSetInstanceId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version",0);
        jsonObject.put("serialNumber", "serialNumber-modify");
        jsonObject.put("lot", "lot-modify");
        jsonObject.put("description", "description-modify");
        jsonObject.put("attributeSetInstanceId", attributeSetInstanceId);
        jsonObject.put("attributeSetId", "TestColorAttributeSetId8c0fXA8idM6GE");
        jsonObject.put("Color", "F");//注意，凡是动态字段的属性名称第一个字母必须大写，否则影响转换
        HttpPatch httpPatch = new HttpPatch(url);
        StringEntity entity = new StringEntity(jsonObject.toJSONString(), "utf-8");
        entity.setContentType(MediaType.APPLICATION_JSON);
        httpPatch.setEntity(entity);
        httpPatch.setHeader(HTTP_HEADER_ACCEPT, MediaType.APPLICATION_JSON);
        try {
            HttpResponse response = HTTP_CLIENT.execute(httpPatch);
            System.out.println(getContentFromResponse(response));
            Assert.assertEquals(204, response.getStatusLine().getStatusCode());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
