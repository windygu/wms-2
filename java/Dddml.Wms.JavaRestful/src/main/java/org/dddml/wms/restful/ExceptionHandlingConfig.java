package org.dddml.wms.restful;

import com.stormpath.spring.web.servlet.handler.DefaultRestErrorResolver;
import com.stormpath.spring.web.servlet.handler.RestErrorConverter;
import com.stormpath.spring.web.servlet.handler.RestErrorResolver;
import com.stormpath.spring.web.servlet.handler.RestExceptionHandler;
import org.dddml.wms.web.servlet.handler.RestErrorResolverImpl;
import org.dddml.wms.web.servlet.handler.SpringBootMapRestErrorConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/8/28.
 */
@Configuration
public class ExceptionHandlingConfig { //extends WebMvcConfigurerAdapter
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Bean
    public AcceptHeaderLocaleResolver localeResolver() {
        return new AcceptHeaderLocaleResolver();
    }

    @Bean
    public FixedLocaleResolver fixedLocaleResolver() {
        FixedLocaleResolver fixedLocaleResolver = new FixedLocaleResolver(Locale.SIMPLIFIED_CHINESE);
        return fixedLocaleResolver;
    }

    @Bean
    public RestErrorConverter restErrorConverter() {
        return new SpringBootMapRestErrorConverter();
    }

    @Bean
    public RestErrorResolver restErrorResolver() {
        RestErrorResolverImpl restErrorResolver = new RestErrorResolverImpl();
        restErrorResolver.setLocaleResolver(fixedLocaleResolver());
        restErrorResolver.setDefaultMoreInfoUrl("mailto:support@dddml.org");
        Map<String, String> exceptionMappingDefinitions = new HashMap<>();
        // exceptionMappingDefinitions.put("org.dddml.wms.security.JwtTokenMalformedException", "401, _exmsg");
        exceptionMappingDefinitions.put("org.dddml.wms.specialization.DomainError", "400, _exmsg");
        exceptionMappingDefinitions.put("java.lang.RuntimeException", "500, _exmsg");
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
        restExceptionHandler.setErrorResolver(restErrorResolver());
        // ///////////////////  restErrorConverter //////////////////////////
        restExceptionHandler.setErrorConverter(restErrorConverter());
        // //////////////////////////////////////////////////////////////////
        return restExceptionHandler;
    }

    //
    //    @Override
    //    public void addInterceptors(InterceptorRegistry registry) {
    //        registry.addInterceptor(localeChangeInterceptor());
    //    }

    //    @Override
    //    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    //        //exceptionResolvers.add(annotationMethodHandlerExceptionResolver());
    //        exceptionResolvers.add(restExceptionHandler());
    //    }

    //    @Bean
    //    public AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver() {
    //        AnnotationMethodHandlerExceptionResolver annotationMethodHandlerExceptionResolver = new AnnotationMethodHandlerExceptionResolver();
    //        annotationMethodHandlerExceptionResolver.setOrder(0);
    //        return annotationMethodHandlerExceptionResolver;
    //    }


}