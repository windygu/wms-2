package org.dddml.wms.restful.annotation;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 加注此注解的资源类或者资源方法，在调用时，将进行客户端用户Token验证
 * Created by Li Yongchun on 2016/9/13.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface Logged {
}
