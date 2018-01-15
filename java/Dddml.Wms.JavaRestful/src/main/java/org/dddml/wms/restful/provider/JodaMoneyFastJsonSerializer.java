package org.dddml.wms.restful.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastjsonSockJsMessageCodec;
import org.joda.money.Money;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by liyongchun on 16/9/6.
 */
public class JodaMoneyFastJsonSerializer implements ObjectSerializer {
    //FIXME 总感觉写的不够好，可能存在什么问题，尤其是SerializerFeature支持方面
    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if (o == null) {
            out.writeNull();
        }
        Money money = (Money) o;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("amount", money.getAmount());
        jsonObject.put("currency", money.getCurrencyUnit().getCurrencyCode());
        if (out.isEnabled(SerializerFeature.PrettyFormat)) {
            out.write(JSON.toJSONString(jsonObject, SerializerFeature.PrettyFormat));
        } else {
            out.write(jsonObject.toJSONString());
        }
    }
}
