package org.dddml.wms.specialization.annotation;


import java.lang.annotation.*;

/**
 * Created by yangjiefeng on 2018/8/24.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Specification {
    Class value();
}
