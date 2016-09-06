import com.alibaba.fastjson.JSON;
import org.apache.http.client.HttpClient;
import org.dddml.support.criterion.*;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.PropertyMetadataDto;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import static com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect;
import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;
import static com.alibaba.fastjson.serializer.SerializerFeature.UseISO8601DateFormat;

/**
 * Created by Li Yongchun on 2016/9/5.
 */

public class PersonResourceTest extends AbstractResourceTest {

    public static final String RESOURCE_URL = BASE_URL + "people/";
    public static final String REQUESTER_ID = "requestId";
    public static final String FIRST_NAME = "Andy";
    public static final String LAST_NAME = "Liu";
    public static final String FULL_NAME = FIRST_NAME + "," + LAST_NAME;


    private CreateOrMergePatchPersonDto.CreatePersonDto createPerson() {
        CreateOrMergePatchPersonDto.CreatePersonDto dto = new CreateOrMergePatchPersonDto.CreatePersonDto();
        PersonalNameDto personalNameDto = new PersonalNameDto();
        personalNameDto.setFirstName(FIRST_NAME);
        personalNameDto.setLastName(LAST_NAME);
        dto.setPersonalName(personalNameDto);
        //dto.setVersion(1L);
        dto.setCommandId(UUID.randomUUID().toString());
        dto.setActive(true);
        dto.setBirthDate(new Date());
        ContactDto contactDto = new ContactDto();
        contactDto.setAddress("上海市联航路1188号");
        PersonalNameDto personalNameDto1 = new PersonalNameDto();
        personalNameDto1.setLastName("紧急联系人Last Name");
        personalNameDto1.setFirstName("紧急联系人First name");
        contactDto.setPhoneNumber("紧急联系人电话号码在此");
        contactDto.setPersonalName(personalNameDto1);
        dto.setEmergencyContact(contactDto);
        dto.setIsPropertyActiveRemoved(false);
        PersonalNameDto lovesDto = new PersonalNameDto();
        lovesDto.setFirstName("Lovers first name");
        lovesDto.setLastName("lovers last name");
        dto.setLoves(lovesDto);
        List<CreateOrMergePatchYearPlanDto.CreateYearPlanDto> yearPlanDtos = new ArrayList<>();
        Random random = new Random();
        int loop = random.nextInt(3) + 1;//随机生成1到4个年计划
        for (int i = 0; i < loop; i++) {
            int year = 2016 + i;
            CreateOrMergePatchYearPlanDto.CreateYearPlanDto yearPlanDto = new CreateOrMergePatchYearPlanDto.CreateYearPlanDto();
            yearPlanDto.setRequesterId(REQUESTER_ID);
            yearPlanDto.setActive(true);
            yearPlanDto.setDescription(year + "年计划");
            yearPlanDto.setIsPropertyActiveRemoved(false);
            yearPlanDto.setIsPropertyDescriptionRemoved(false);
            //yearPlanDto.setCommandId(dto.getCommandId());
            yearPlanDto.setYear(year);
            yearPlanDtos.add(yearPlanDto);
            //System.out.println(yearPlanDto.getDescription());
            int monthStart = random.nextInt(3) + 1;//这里定义为起始月份，随机的，最小是1，最大是3
            int monthLoop = random.nextInt(9) + 1;//生成几个月的月计划？最少是1，最多是9个
            List<CreateOrMergePatchMonthPlanDto.CreateMonthPlanDto> monthPlanList = new ArrayList<>();
            for (int j = 0; j < monthLoop; j++) {
                CreateOrMergePatchMonthPlanDto.CreateMonthPlanDto monthPlanDto = new CreateOrMergePatchMonthPlanDto.CreateMonthPlanDto();
                int month = monthStart + j;
                monthPlanDto.setDescription(yearPlanDto.getYear() + "年" + month + "月计划");
                monthPlanDto.setActive(true);
                monthPlanDto.setMonth(month);
                monthPlanDto.setRequesterId(REQUESTER_ID);
                monthPlanList.add(monthPlanDto);
                //System.out.println("--" + monthPlanDto.getDescription());

                int dayStart = random.nextInt(10) + 1;//起始日
                int dayLoop = random.nextInt(15) + 1;

                List<CreateOrMergePatchDayPlanDto.CreateDayPlanDto> dayPlanDtos = new ArrayList<>();
                for (int k = 0; k < dayLoop; k++) {
                    int day = dayStart + k;
                    CreateOrMergePatchDayPlanDto.CreateDayPlanDto createDayPlanDto = new CreateOrMergePatchDayPlanDto.CreateDayPlanDto();
                    createDayPlanDto.setRequesterId(REQUESTER_ID);
                    createDayPlanDto.setActive(true);
                    createDayPlanDto.setDay(day);
                    createDayPlanDto.setDescription(yearPlanDto.getYear() + "年" + month + "月" + day + "日计划");
                    dayPlanDtos.add(createDayPlanDto);
                    //System.out.println("----" + createDayPlanDto.getDescription());
                }
                monthPlanDto.setDayPlans(dayPlanDtos.toArray(new CreateOrMergePatchDayPlanDto.CreateDayPlanDto[0]));
            }
            yearPlanDto.setMonthPlans(monthPlanList.toArray(new CreateOrMergePatchMonthPlanDto.CreateMonthPlanDto[0]));
        }
        dto.setYearPlans(yearPlanDtos.toArray(new CreateOrMergePatchYearPlanDto[0]));
        dto.setRequesterId("RequestId");
        return dto;
    }

    @Test
    public void CreatePerson() {
        try {
            String url = RESOURCE_URL.concat(URLEncoder.encode(FULL_NAME, "UTF-8"));
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            //写入
            OutputStream outputStream = connection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
            CreateOrMergePatchPersonDto.CreatePersonDto dto = createPerson();
            String json = JSON.toJSONString(dto, PrettyFormat);
            writer.write(json);
            writer.flush();
            writer.close();
            //System.out.println(json);
            int responseCode = connection.getResponseCode();
            getContentFromResponseInputStream(connection);
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private CreateOrMergePatchPersonDto.MergePatchPersonDto createMergePatchPersonInfo() {
        CreateOrMergePatchPersonDto.MergePatchPersonDto dto = new CreateOrMergePatchPersonDto.MergePatchPersonDto();
        dto.setPersonalName(new PersonalNameDto());
        dto.setVersion(1L);
        dto.getPersonalName().setFirstName(FIRST_NAME);
        dto.getPersonalName().setLastName(LAST_NAME);
        List<CreateOrMergePatchYearPlanDto.MergePatchYearPlanDto> yearPlanDtos = new ArrayList<>();
        CreateOrMergePatchYearPlanDto.MergePatchYearPlanDto yearPlanDto = new CreateOrMergePatchYearPlanDto.MergePatchYearPlanDto();
        yearPlanDto.setYear(2016);
        yearPlanDtos.add(yearPlanDto);
        List<CreateOrMergePatchMonthPlanDto> monthPlanDtos = new ArrayList<>();
        RemoveMonthPlanDto removeMonthPlanDto = new RemoveMonthPlanDto();
        removeMonthPlanDto.setMonth(5);
        removeMonthPlanDto.setDescription("2016年5月份计划删除了");
        monthPlanDtos.add(removeMonthPlanDto);
        yearPlanDto.setMonthPlans(monthPlanDtos.toArray(new CreateOrMergePatchMonthPlanDto[0]));
        dto.setYearPlans(yearPlanDtos.toArray(new CreateOrMergePatchYearPlanDto.MergePatchYearPlanDto[0]));
        return dto;
    }

    /**
     * 修改Person信息
     */
    @Test
    public void ModifyPerson() {
        try {
            String url = RESOURCE_URL.concat(URLEncoder.encode(FULL_NAME, "UTF-8"));
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("x-http-method-override", "PATCH");//用来模拟 PATCH 方法
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            //写入
            OutputStream outputStream = connection.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter writer = new BufferedWriter(outputStreamWriter);
            CreateOrMergePatchPersonDto.MergePatchPersonDto dto = createMergePatchPersonInfo();
            String json = JSON.toJSONString(dto, PrettyFormat);
            writer.write(json);
            writer.flush();
            writer.close();
            System.out.println(json);
            int responseCode = connection.getResponseCode();
            getContentFromResponseInputStream(connection);
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取指定Person的详细信息
     */
    @Test
    public void getPerson() {
        String url = RESOURCE_URL.concat(FULL_NAME);
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                PersonStateDto personStateDto = null;
                if (response != null && response.length() > 0) {
                    personStateDto = JSON.parseObject(response, PersonStateDto.class);
                    System.out.println(JSON.toJSONString(personStateDto, PrettyFormat));
                }
                Assert.assertNotNull(personStateDto);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static final String PERSONAL_NAME_FIRST_NAME = "personalName.firstName";
    public static final String PERSONAL_NAME_LAST_NAME = "personalName.lastName";
    public static final String ACTIVE = "active";
    public static final String BIRTH_DATE = "birthDate";


    /**
     * 生成过滤条件
     *
     * @return
     */
    private String createFilter() {
        try {
            Conjunction conjunctionAll = Restrictions.conjunction();
            conjunctionAll.add(Restrictions.eq(PERSONAL_NAME_FIRST_NAME, FIRST_NAME));
            conjunctionAll.add(Restrictions.eq(PERSONAL_NAME_LAST_NAME, LAST_NAME));
            conjunctionAll.add(Restrictions.eq(ACTIVE, true));
            //conjunctionAll.add(Restrictions.gt(BIRTH_DATE, new Date()));
            CriterionDto dto = new CriterionDto(conjunctionAll, new DefaultTypeConverter());
            /**DisableCircularReferenceDetect 去掉循环引用*/
            String filterJson = JSON.toJSONString(dto, UseISO8601DateFormat, DisableCircularReferenceDetect, PrettyFormat);
            System.out.println(filterJson);
            return URLEncoder.encode(filterJson, "UTF-8");
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 获取符合条件的Person总数
     */
    @Test
    public void getPersonCount() {
        try {
            String filterJson = createFilter();
            String url = RESOURCE_URL.concat("_count")
                    .concat((filterJson == null || filterJson.length() < 1) ? "" : "?filter=" + filterJson);
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                System.out.println("数量：" + response);
                Assert.assertEquals(true, response != null && response.length() > 0);
                Integer count = Integer.valueOf(response);
                Assert.assertEquals(true, count >= 0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void getPersons() {
        try {
            String filterJson = createFilter();
            String fields = PERSONAL_NAME_FIRST_NAME + "," + PERSONAL_NAME_LAST_NAME;
            String sort = BIRTH_DATE;
            String firstResult = "0";
            String maxResults = "10";
            String url = RESOURCE_URL
                    .concat((filterJson == null || filterJson.length() < 1) ? "" : "?filter=" + filterJson)
                    .concat(StringHelper.isNullOrEmpty(sort) ? "" : "&sort=" + sort)
                    .concat(StringHelper.isNullOrEmpty(firstResult) ? "" : "&maxResults=" + maxResults)
                    .concat(StringHelper.isNullOrEmpty(firstResult) ? "" : "&firstResult=" + firstResult)
                    .concat(StringHelper.isNullOrEmpty(fields) ? "" : "&fields=" + fields);
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                List<PersonStateDto> personStateDtos = JSON.parseArray(response, PersonStateDto.class);
                System.out.println("符合条件的数据数量：" + personStateDtos.size());
                Assert.assertEquals(true, personStateDtos.size() >= 0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 删除
     */
    @Test
    public void deletePerson() {
        String commandId = "770c7764-f63b-46a7-9659-0b5fa79e03f9";
        int version = 0;
        String url = RESOURCE_URL.concat(FULL_NAME).concat("?commandId=").concat(commandId)
                .concat("&version=").concat(String.valueOf(version))
                .concat("&requestId=").concat(REQUESTER_ID);
        System.out.println(url);
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("DELETE");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals(204, responseCode);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 获取可过滤的查询条件
     */
    @Test
    public void getFilteringFields() {
        String url = RESOURCE_URL.concat("_metadata/filteringFields");
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                if (response != null && response.length() > 0) {
                    List<PropertyMetadataDto> dtos = JSON.parseArray(response, PropertyMetadataDto.class);
                    Assert.assertEquals(true, dtos.size() >= 0);
                    System.out.println(JSON.toJSONString(dtos, PrettyFormat));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    @Test
    public void getStateEvent() {
        String url = RESOURCE_URL.concat(FULL_NAME).concat("/_stateEvents/").concat("-1");
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                if (response != null && response.length() > 0) {
                    PersonStateEvent stateEvent = JSON.parseObject(response, PersonStateEvent.class);
                    System.out.println(JSON.toJSONString(stateEvent, PrettyFormat));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 获取年计划
     */
    @Test
    public void getYearPlan() {
        String url = RESOURCE_URL.concat(FULL_NAME).concat("/YearPlans/").concat("2016");//{year}/MonthPlans/{month});
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                if (response != null && response.length() > 0) {
                    YearPlanStateDto stateEvent = JSON.parseObject(response, YearPlanStateDto.class);
                    System.out.println(JSON.toJSONString(stateEvent, PrettyFormat));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 获取月计划
     */
    @Test
    public void getMonthPlan() {
        String url = RESOURCE_URL.concat(FULL_NAME).concat("/YearPlans/").concat("2016").concat("/MonthPlans/").concat("7");
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                if (response != null && response.length() > 0) {
                    MonthPlanIdDto stateEvent = JSON.parseObject(response, MonthPlanIdDto.class);
                    System.out.println(JSON.toJSONString(stateEvent, PrettyFormat));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 获取日计划
     */
    @Test
    public void getDayPlan() {
        String url = RESOURCE_URL.concat(FULL_NAME).concat("/YearPlans/").concat("2016").concat("/MonthPlans/").concat("7").concat("/DayPlans/").concat("5");
        try {
            URL requestUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("ACCEPT", "application/json");
            connection.connect();
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String response = getContentFromResponseInputStream(connection);
                if (response != null && response.length() > 0) {
                    DayPlanIdDto stateEvent = JSON.parseObject(response, DayPlanIdDto.class);
                    System.out.println(JSON.toJSONString(stateEvent, PrettyFormat));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


