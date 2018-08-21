package org.dddml.wms.restful.clienttests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.dddml.wms.restful.json.JodaMoneyJacksonDeserializer;
import org.dddml.wms.restful.json.JodaMoneyJacksonSerializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Joda Money Jackson Serializer & Deserializer test
 * Created by Li Yongchun on 2016/9/7.
 */
public class JodaMoneyJacksonTest {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static final BigDecimal TEST_AMOUNT = BigDecimal.valueOf(2.35);
    private static final String CURRENCY_CODE = "CNY";

    public static final String TEST_STRING = "{\"amount\":\"2.35\",\"currency\":\"CNY\"}";

    @BeforeClass
    public static void before() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(Money.class, new JodaMoneyJacksonSerializer());
        module.addDeserializer(Money.class, new JodaMoneyJacksonDeserializer());
        objectMapper.registerModule(module);
    }


    @Test
    public void JsonStringToMoney() {
        try {
            Money money = objectMapper.readValue(TEST_STRING, Money.class);
            Assert.assertNotNull(money);
            Assert.assertEquals(TEST_AMOUNT, money.getAmount());
            Assert.assertEquals(CURRENCY_CODE, money.getCurrencyUnit().getCurrencyCode());
            System.out.println("反序列化:" + money.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void MoneyToJacksonString() {
        Money money = Money.of(CurrencyUnit.of(CURRENCY_CODE), TEST_AMOUNT);
        try {
            String result = objectMapper.writeValueAsString(money);
            Assert.assertEquals(TEST_STRING, result);
            System.out.println("序列化：" + result);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
}
