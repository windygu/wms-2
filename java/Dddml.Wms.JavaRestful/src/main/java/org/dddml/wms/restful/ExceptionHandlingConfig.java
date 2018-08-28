package org.dddml.wms.restful;

import com.stormpath.spring.web.servlet.handler.DefaultRestErrorResolver;
import com.stormpath.spring.web.servlet.handler.RestExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerExceptionResolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/8/28.
 */
@Configuration
@EnableWebMvc
public class ExceptionHandlingConfig extends WebMvcConfigurerAdapter {
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public AcceptHeaderLocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }

    @Bean
    public AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver() {
        AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver = new AnnotationMethodHandlerExceptionResolver();
        annotationMethodHandlerExceptionResolver.setOrder(0);
        return annotationMethodHandlerExceptionResolver;
    }

    @Bean
    public DefaultRestErrorResolver defaultRestErrorResolver() {
        DefaultRestErrorResolver restErrorResolver = new DefaultRestErrorResolver();
        restErrorResolver.setLocaleResolver(localeResolver());
        restErrorResolver.setDefaultMoreInfoUrl("mailto:support@dddml.org");
        Map<String, String> exceptionMappingDefinitions = new HashMap<>();
        // exceptionMappingDefinitions.put("org.dddml.wms.security.JwtTokenMalformedException", "401, _exmsg");
        exceptionMappingDefinitions.put("org.dddml.wms.specialization.DomainError", "500, _exmsg");
        // <!-- 500 (catch all): -->
        exceptionMappingDefinitions.put("Throwable","500");
        restErrorResolver.setExceptionMappingDefinitions(exceptionMappingDefinitions);
        return restErrorResolver;
    }

    @Bean
    public RestExceptionHandler restExceptionHandler() {
        RestExceptionHandler restExceptionHandler = new RestExceptionHandler();
        restExceptionHandler.setOrder(1);
        // //////////////////// restErrorResolver ///////////////////////////
        restExceptionHandler.setErrorResolver(defaultRestErrorResolver());
        // ////////////////////////////////////////////////////////////////////
        return restExceptionHandler;
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(annotationMethodHandlerExceptionResolver());
        exceptionResolvers.add(restExceptionHandler());
    }

}