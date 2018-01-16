package org.dddml.wms.restful.provider;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.Money;

import java.io.IOException;

/**
 * Created by liyongchun on 16/9/6.
 */
public class JodaMoneyJacksonSerializer extends JsonSerializer<Money> {
    @Override
    public void serialize(Money value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeStringField("amount", value.getAmount().toString());
        gen.writeStringField("currency", value.getCurrencyUnit().getCurrencyCode());
        gen.writeEndObject();
    }
}
