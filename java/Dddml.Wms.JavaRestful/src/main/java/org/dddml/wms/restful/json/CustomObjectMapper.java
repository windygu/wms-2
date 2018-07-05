package org.dddml.wms.restful.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.money.Money;

import java.text.SimpleDateFormat;

/**
 * Created by Li Yongchun on 2016/9/1.
 */
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        super();
        setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        SimpleModule simpleModule = new SimpleModule();
        /***增加新的反序列化器*/
        simpleModule.addDeserializer(Money.class, new JodaMoneyJacksonDeserializer());
        /**序列化器*/
        simpleModule.addSerializer(Money.class, new JodaMoneyJacksonSerializer());
        registerModule(simpleModule);
    }
}
