package org.dddml.wms.restful.provider;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * 将金额转化为JodaMoney，Jackson Json 反序列化器
 */
public class JodaMoneyJacksonDeserializer extends JsonDeserializer<Money> {
    @Override
    public Money deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            JsonNode node = p.getCodec().readTree(p);
            String amount = node.get("amount").asText();
            String currency = node.get("currency").asText();
            Money money = Money.of(CurrencyUnit.of(currency), new BigDecimal(amount));
            return money;
        } catch (Exception ex) {
            throw new JsonParseException(p, ex.getMessage());
        }
    }
}
