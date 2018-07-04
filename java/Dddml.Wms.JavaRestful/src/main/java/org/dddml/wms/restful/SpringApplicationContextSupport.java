package org.dddml.wms.restful;

import org.dddml.wms.specialization.spring.SpringApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Li Yongchun on 2016/8/31.
 */
@Component
public class SpringApplicationContextSupport implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        org.dddml.wms.specialization.ApplicationContext.setCurrent(new SpringApplicationContext(applicationContext));
    }
}
