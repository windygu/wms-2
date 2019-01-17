package org.dddml.wms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.metamodel.EntityType;


/**
 * Created by yangjiefeng on 2018/12/20.
 */
@SpringBootApplication
//@ImportResource(value = {"classpath*:/config/SpringConfigs.xml", "classpath*:/config/TestDataSourceConfig.xml"})
@ImportResource(value = {"classpath*:/config/SpringConfigs.xml"})
public class TestJpa {

    public static void main(final String[] args) {
        //ConfigurableApplicationContext ctx = SpringApplication.run(WmsApplication.class, args);
        ApplicationContext ac = SpringApplication.run(TestJpa.class, args);

        EntityManagerFactory entityManagerFactory = ac.getBean(EntityManagerFactory.class);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println(entityManager.getMetamodel().getEntities().size());
        for (EntityType entityType : entityManager.getMetamodel().getEntities()) {
            System.out.println("----------------------");
            System.out.println(entityType.getName());
            System.out.println(entityType.getJavaType());
        }
    }
//
//    @Bean
//    EntityManagerTest getEntityManagerTest() {
//        return new EntityManagerTest();
//    }
//
////    @Bean
////    LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
////        return new LocalEntityManagerFactoryBean();
////    }
//
//    public static class EntityManagerTest {
//        @Resource
//        private EntityManagerFactory entityManagerFactory;
//
//        @PostConstruct
//        protected synchronized void testGetMeta() {
//        }
//    }
}
