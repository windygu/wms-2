package org.dddml.wms.web.servlet.handler;

import com.stormpath.spring.web.servlet.handler.MapRestErrorConverter;
import com.stormpath.spring.web.servlet.handler.RestError;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

/**
 * Provides the following attributes
 * when possible, like {@link org.springframework.boot.autoconfigure.web.DefaultErrorAttributes}:
 * <ul>
 * <li>timestamp - The time that the errors were extracted</li>
 * <li>status - The status code</li>
 * <li>error - The error reason</li>
 * <li>exception - The class name of the root exception</li>
 * <li>message - The exception message</li>
 * <li>errors - Any {@link ObjectError}s from a {@link BindingResult} exception
 * <li>trace - The exception stack trace</li>
 * <li>path - The URL path when the exception was raised</li>
 * </ul>
 *
 * @author Yang Jiefeng
 */
public class SpringBootMapRestErrorConverter extends MapRestErrorConverter {

    public SpringBootMapRestErrorConverter() {
        setMessageKey("message");
        setStatusKey("status");
    }

    @Override
    public Map convert(RestError re) {
        Map map = super.convert(re);

        map.put("timestamp", new Date());

        String msg = re.getMessage();
        if (!map.containsKey("error") &&  msg != null) {
            String errorName = RestErrorResolverImpl.getErrorName(msg);
            if (errorName != null && !errorName.isEmpty()) {
                map.put("error", errorName);
                if (msg.length() > errorName.length() + 2) {
                    map.put(getMessageKey(), msg.substring(errorName.length() + 2).trim());
                }
            }
        }

        return map;
    }

}
