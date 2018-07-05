package org.dddml.wms.specialization;

public interface TypeConverter
{
    Object convertFromString(java.lang.Class type, String text);

    String convertToString(Object value);

    String convertToString(java.lang.Class type, Object value);

    String[] convertToStringArray(Object[] values);

}
