package org.dddml.wms.restful.resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.dddml.wms.restful.provider.JodaMoneyFastJsonDeserializer;
import org.dddml.wms.restful.provider.JodaMoneyFastJsonSerializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * JodaMoney FastJson 序列化和反序列化测试
 * Created by Li Yongchun on 2016/9/7.
 */
public class JodaMoneyFastJsonTest {

    private static final BigDecimal TEST_AMOUNT = BigDecimal.valueOf(2.35);
    private static final String CURRENCY_CODE = "CNY";

    public static final String TEST_STRING = "{\"amount\":2.35,\"currency\":\"CNY\"}";

    @BeforeClass
    public static void before() {
        SerializeConfig.getGlobalInstance().put(Money.class, new JodaMoneyFastJsonSerializer());
        ParserConfig.global.putDeserializer(Money.class, new JodaMoneyFastJsonDeserializer());
    }


    /**
     * Money 转 JSON String
     */
    @Test
    public void moneyToFastJsonString() {
        Money money = Money.of(CurrencyUnit.of(CURRENCY_CODE), TEST_AMOUNT);
        String jsonString = JSON.toJSONString(money);
        Assert.assertEquals(TEST_STRING, jsonString);
        System.out.println(jsonString);
    }


    /**
     * JSON String 转 Money
     */
    @Test
    public void jsonStringToFastJson() {
        Money money = JSON.parseObject(TEST_STRING, Money.class);
        Assert.assertNotNull(money);
        Assert.assertEquals(TEST_AMOUNT, money.getAmount());
        Assert.assertEquals(CURRENCY_CODE, money.getCurrencyUnit().getCurrencyCode());
        System.out.println(money.toString());
    }

    /**
     * 测试SerializerFeature对结果的影响，效果不是很理想。
     */
    @Test
    public void tempObjectToJsonString() {
        TempClass tempClass = new TempClass("Li Yongchun", Money.of(CurrencyUnit.of(CURRENCY_CODE), TEST_AMOUNT), 20);
        System.out.println(JSON.toJSONString(tempClass));
        System.out.println(JSON.toJSONString(tempClass, true));
    }

    private static class TempClass {
        private String name;
        private Money salary;
        private Integer age;

        public TempClass(String name, Money salary, Integer age) {
            this.name = name;
            this.salary = salary;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Money getSalary() {
            return salary;
        }

        public void setSalary(Money salary) {
            this.salary = salary;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
