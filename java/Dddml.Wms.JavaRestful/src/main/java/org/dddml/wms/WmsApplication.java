package org.dddml.wms;

import org.dddml.wms.specialization.ApplicationContext;
import org.dddml.wms.specialization.spring.SpringApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.event.ContextStartedEvent;

/**
 * Created by liusizuo on 2018/7/5 .
 */
@SpringBootApplication
@ImportResource("classpath*:/config/SpringConfigs.xml")
public class WmsApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(WmsApplication.class, args);
		ApplicationContext.current = new SpringApplicationContext(ctx);
		ctx.publishEvent(new ContextStartedEvent(ctx));
	}
}
