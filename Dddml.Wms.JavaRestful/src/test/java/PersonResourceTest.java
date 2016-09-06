import com.alibaba.fastjson.JSON;
import org.dddml.support.criterion.Conjunction;
import org.dddml.support.criterion.Restrictions;
import org.dddml.wms.domain.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import static com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat;

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
            System.out.println(yearPlanDto.getDescription());
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
                System.out.println("--" + monthPlanDto.getDescription());

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
                    System.out.println("----" + createDayPlanDto.getDescription());
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
            System.out.println(json);
            int responseCode = connection.getResponseCode();
            Assert.assertEquals("20", String.valueOf(responseCode).substring(0, 2));
            System.out.println(connection.getResponseMessage());
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
                String response = getContentFromResponseInputStream(connection.getInputStream());
                //System.out.println(response);
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


    /**
     * 获取符合条件的Person总数
     */
    @Test
    public void getPersonCount() {
        try {

            Conjunction conjunctionAll = Restrictions.conjunction();
            conjunctionAll.add(Restrictions.eq("personalName.firstName", FIRST_NAME));
            conjunctionAll.add(Restrictions.eq("personalName.lastName", LAST_NAME));

            String filterJson = JSON.toJSONString(conjunctionAll, PrettyFormat);

            System.out.println(filterJson);

            String url = RESOURCE_URL.concat("_count")
                    .concat((filterJson == null || filterJson.length() < 1) ? "" : "?filter=" + URLEncoder.encode(filterJson, "UTF-8"));
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
                String response = getContentFromResponseInputStream(connection.getInputStream());
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
}
