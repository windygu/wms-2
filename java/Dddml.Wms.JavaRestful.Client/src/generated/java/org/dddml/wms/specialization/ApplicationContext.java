package org.dddml.wms.specialization;


import org.dddml.support.criterion.DefaultTypeConverter;

/**
 * Created by Yang on 2016/7/20.
 */
public class ApplicationContext {

    public static volatile ApplicationContext current;

    public static void setCurrent(ApplicationContext context) {
        current = context;
    }

    public Object get(String name) {
        throw new UnsupportedOperationException();
    }

    public <T> T get(Class<T> type) {
        throw new UnsupportedOperationException();
    }

    public TypeConverter getTypeConverter() {
        return new DefaultTypeConverter();
    }

    public TimestampService getTimestampService() {
        return new TimestampService() {
            @Override
            public Object now(Class type) {
                if (type.equals(java.sql.Timestamp.class)) {
                    return new java.sql.Timestamp(new java.util.Date().getTime());
                } else if (type.equals(java.util.Date.class)) {
                    return new java.util.Date();
                } else if (type.equals(Long.class)) {
                    return System.currentTimeMillis();
                } else {
                    throw new IllegalArgumentException("Unknown type: " + type);
                }
            }
        };
    }

    public ClobConverter getClobConverter() {
        return (ClobConverter) get("clobConverter");
    }

    public static class DefaultTypeConverter implements TypeConverter {

        private org.dddml.support.criterion.DefaultTypeConverter innerTypeConverter = new org.dddml.support.criterion.DefaultTypeConverter();

        @Override
        public Object convertFromString(Class type, String text) {
            return innerTypeConverter.convertFromString(type, text);
        }

        @Override
        public String convertToString(Object value) {
            return innerTypeConverter.convertToString(value);
        }

        @Override
        public String convertToString(Class type, Object value) {
            return innerTypeConverter.convertToString(value);
        }

        @Override
        public String[] convertToStringArray(Object[] values) {
            return innerTypeConverter.convertToStringArray(values);
        }
    }
}
