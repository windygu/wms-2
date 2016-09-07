package org.dddml.wms.specialization;

import org.joda.money.Money;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtils {
    private ReflectUtils(){
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
    }

}
