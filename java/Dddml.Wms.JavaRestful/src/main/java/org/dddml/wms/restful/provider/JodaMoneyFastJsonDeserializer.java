package org.dddml.wms.restful.provider;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * 将金额转化为JodaMoney，FastJson 反序列化器
 */
public class JodaMoneyFastJsonDeserializer implements ObjectDeserializer {
    public static final String AMOUNT = "amount";
    public static final String CURRENCY = "currency";

    @Override
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object o) {
        try {
            JSONObject jsonObject = (JSONObject) defaultJSONParser.parse(defaultJSONParser.getInput());
            String amount = jsonObject.getString(AMOUNT);
            String currency = jsonObject.getString(CURRENCY);
            Money money = Money.of(CurrencyUnit.of(currency), new BigDecimal(amount));
            return (T) money;
        } catch (Exception ex) {
            throw new JSONException("金额错误");
        }
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}
