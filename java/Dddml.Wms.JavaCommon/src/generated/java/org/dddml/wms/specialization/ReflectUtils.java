package org.dddml.wms.specialization;

import org.joda.money.Money;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.*;

public class ReflectUtils {
    private ReflectUtils() {
    }

    public static final Map<String, Class> CLASS_MAP = new HashMap<>();

    static {
        CLASS_MAP.put("Boolean", Boolean.class);
        CLASS_MAP.put("Date", Date.class);
        CLASS_MAP.put("BigDecimal", BigDecimal.class);
        CLASS_MAP.put("Integer", Integer.class);
        CLASS_MAP.put("Long", Long.class);
        CLASS_MAP.put("Money", Money.class);
        CLASS_MAP.put("String", String.class);
        CLASS_MAP.put("java.sql.Timestamp", java.sql.Timestamp.class);
        CLASS_MAP.put("java.sql.Date", java.sql.Date.class);
    }

    public static Object getPropertyValue(String propertyName, Object obj) {
        Object val = null;
        String pn = propertyName;
        if (Character.isLowerCase(propertyName.charAt(0))) {
            pn = Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        }
        try {
            val = obj.getClass().getMethod("get" + pn, new Class[0]).invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        }
        //        else {
        //            BeanInfo info = Introspector.getBeanInfo(obj.getClass());
        //            Optional<PropertyDescriptor> pd =
        //                    Arrays.stream(info.getPropertyDescriptors()).filter(p -> p.getName().equals(propertyName)).findFirst();
        //            if(pd.isPresent()) {
        //                val = pd.get().getReadMethod().invoke(obj);
        //            }
        //        }
        return val;
    }

}
