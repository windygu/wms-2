package org.dddml.wms.specialization;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ReflectUtils {
    private ReflectUtils() {
    }

    public static Object getPropertyValue(String propertyName, Object obj) {
        Object val = null;
        String pn = toPascalCase(propertyName);
        try {
            val = obj.getClass().getMethod("get" + pn, new Class[0]).invoke(obj);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);// e.printStackTrace();
        }
        return val;
    }

    public static Class<?> getPropertyType(String propertyName, Object obj) {
        BeanInfo info = null;
        try {
            info = Introspector.getBeanInfo(obj.getClass());
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);//e.printStackTrace();
        }
        Optional<PropertyDescriptor> pd =
                Arrays.stream(info.getPropertyDescriptors())
                        .filter(p -> Objects.equals(p.getName().toLowerCase(), propertyName.toLowerCase()))
                        .findFirst();
        if (pd.isPresent()) {
            return pd.get().getPropertyType();
        }
        throw new RuntimeException(String.format("Property %1$s is NOT present.", propertyName));
    }

    public static boolean trySetPropertyValue(String propertyName, Object obj, Object value,
                                              BiFunction<Object, Class<?>, Object> convert) {
        boolean throwOnError = false;
        return trySetPropertyValue(propertyName, obj, value, convert, throwOnError);
    }

    public static void setPropertyValue(String propertyName, Object obj, Object value) {
        boolean throwOnError = true;
        BiFunction<Object, Class<?>, Object> convert = (o, c) -> {
            //if (throwOnError) {
            //    throw new UnsupportedOperationException("Convert function is NOT definded.");
            //} else
            return o;
        };
        trySetPropertyValue(propertyName, obj, value, convert, throwOnError);
    }

    private static boolean trySetPropertyValue(String propertyName, Object obj, Object value,
                                               BiFunction<Object, Class<?>, Object> convert, boolean throwOnError) {
        String pascalName = toPascalCase(propertyName);
        Class propCls = value == null ? Object.class : value.getClass();
        Object targetPropVal = value;
        Method m = null;
        //        if(value == null) {
        //            m = getNullValueSetterMethod(obj.getClass(), pascalName);
        //        }
        try {
            m = obj.getClass().getMethod("set" + pascalName, new Class[]{propCls});
        } catch (NoSuchMethodException e) {
            if (throwOnError) {
                throw new RuntimeException(e);// e.printStackTrace();
            } else {
                try {
                    Class<?> pt = getPropertyType(propertyName, obj);
                    m = obj.getClass().getMethod("set" + pascalName, new Class[]{pt});
                    targetPropVal = convert.apply(value, pt);
                } catch (NoSuchMethodException e1) {
                    if (throwOnError) {
                        throw new RuntimeException(e);// e.printStackTrace();
                    } else {
                        return false;
                    }
                } catch (Exception ex) {
                    if (throwOnError) {
                        throw new RuntimeException(e);// e.printStackTrace();
                    } // esle {}
                }
            }
        }
        if (m == null && throwOnError) {
            throw new RuntimeException(new NoSuchMethodException());
        }
        try {
            m.invoke(obj, new Object[]{targetPropVal});
            return true;
        } catch (IllegalAccessException | InvocationTargetException e) {
            if (throwOnError) {
                throw new RuntimeException(e);// e.printStackTrace();
            }
        }
        return false;
    }

    private static Method getNullValueSetterMethod(Class<?> clazz, String pn) {
        Method m;
        final String methodName = "set" + pn;
        m = Arrays.stream(clazz.getDeclaredMethods())
                .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                .findFirst().orElse(null);
        if (m == null) {
            m = Arrays.stream(clazz.getMethods())
                    .filter(me -> me.getName().equals(methodName) && me.getParameterCount() == 1)
                    .findFirst().orElse(null);
        }
        return m;
    }

    private static String toPascalCase(String propertyName) {
        String pn = propertyName;
        if (Character.isLowerCase(propertyName.charAt(0))) {
            pn = Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        }
        return pn;
    }

    //    public static final Map<String, Class<?>> CLASS_MAP;
    //    static {
    //        Map<String, Class<?>> clsMap = new HashMap<>();
    //        clsMap.put("Boolean", Boolean.class);
    //        clsMap.put("Date", Date.class);
    //        clsMap.put("BigDecimal", BigDecimal.class);
    //        clsMap.put("Integer", Integer.class);
    //        clsMap.put("Long", Long.class);
    //        clsMap.put("String", String.class);
    //        clsMap.put("java.sql.Timestamp", java.sql.Timestamp.class);
    //        clsMap.put("java.sql.Date", java.sql.Date.class);
    //        CLASS_MAP = clsMap;
    //    }

}
