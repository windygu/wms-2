package org.dddml.wms.restful.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import org.dddml.support.json.JodaMoneyFastJsonDeserializer;
import org.dddml.support.json.JodaMoneyFastJsonSerializer;
import org.joda.money.Money;
import org.springframework.beans.factory.InitializingBean;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

/**
 * JAX-RS Provider for fastjson.
 *
 * @author smallnest
 */
@Provider
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object>, InitializingBean {
    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (mediaType != null) {
            String subtype = mediaType.getSubtype();
            return "json".equalsIgnoreCase(subtype) || subtype.endsWith("+json") || "javascript".equals(subtype)
                    || "x-javascript".equals(subtype);
        }
        return false;
    }


    private String readFromByteStream(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        inputStream.close();
        inputStream.close();
        return sb.toString();
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        try {
            String content = readFromByteStream(entityStream);
            return JSON.parseObject(content, genericType);
        } catch (Exception ex) {

            throw new WebApplicationException("读取请求数据错误");
        }
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return isReadable(type, genericType, annotations, mediaType);
    }

    @Override
    public long getSize(Object o, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Object o, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException, WebApplicationException {
        entityStream.write(JSON.toJSONString(o).getBytes(Charset.forName("utf8")));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        /**
         * 添加反序列化器
         */
        ParserConfig.global.putDeserializer(Money.class, new JodaMoneyFastJsonDeserializer());
        //添加序列化器
        SerializeConfig.getGlobalInstance().put(Money.class, new JodaMoneyFastJsonSerializer());
    }
}
