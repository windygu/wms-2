package org.dddml.wms.web.servlet.handler;

import com.stormpath.spring.web.servlet.handler.DefaultRestErrorResolver;
import com.stormpath.spring.web.servlet.handler.RestError;
import org.springframework.context.MessageSource;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * Created by yangjiefeng on 2018/8/29.
 */
public class RestErrorResolverImpl extends DefaultRestErrorResolver {

    private MessageSource messageSource;
    private LocaleResolver localeResolver;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
        super.setMessageSource(messageSource);
    }

    @Override
    public void setLocaleResolver(LocaleResolver resolver) {
        this.localeResolver = resolver;
        super.setLocaleResolver(resolver);
    }

    @Override
    public RestError resolveError(ServletWebRequest webRequest, Object handler, Exception ex) {
        RestError re = super.resolveError(webRequest, handler, ex);
        String msg = re.getMessage();
        if (msg == null || msg.isEmpty()) {
            return re;
        }
        String errorName = getErrorName(msg);
        if (errorName != null) {
            if (messageSource != null) {
                Locale locale = null;
                if (localeResolver != null) {
                    locale = localeResolver.resolveLocale(webRequest.getRequest());
                    String oldErrorName = errorName;
                    errorName = messageSource.getMessage(errorName, null, errorName, locale);
                    if (!oldErrorName.equals(errorName)) {
                        RestError.Builder builder = new RestError.Builder();
                        builder.setStatus(re.getStatus())
                                .setCode(re.getCode())
                                .setMoreInfoUrl(re.getMoreInfoUrl())
                                .setThrowable(re.getThrowable())
                                .setDeveloperMessage(re.getDeveloperMessage())
                                .setMessage("[" + errorName + "]" + msg.substring(oldErrorName.length() + 2));
                        return builder.build();
                    }
                }
            }
        }
        return re;
    }

    static String getErrorName(String msg) {
        String errorName = null;
        if (msg.startsWith("[")) {
            int errorNameEndIdx = msg.indexOf("]");
            if (errorNameEndIdx > 1) {
                errorName = msg.substring(1, errorNameEndIdx);
            }
        }
        return errorName;
    }

}
