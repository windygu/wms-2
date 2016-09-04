package org.dddml.wms.specialization;


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


    public TypeConverter getTypeConverter() {
        return new DefaultTypeConverter();
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
