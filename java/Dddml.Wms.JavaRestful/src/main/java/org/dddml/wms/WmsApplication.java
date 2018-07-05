package org.dddml.wms;

import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.spring.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by liusizuo on 2018/7/5 .
 */
@SpringBootApplication
public class WmsApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(new Object[]{WmsApplication.class, "classpath*:/config/SpringConfigs.xml"}, args);
		ApplicationContext.current = new SpringApplicationContext(ctx);
		ctx.publishEvent(new ContextStartedEvent(ctx));
	}
}
