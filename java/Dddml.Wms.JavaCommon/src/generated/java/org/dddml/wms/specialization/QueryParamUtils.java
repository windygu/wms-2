package org.dddml.wms.specialization;

import org.dddml.support.criterion.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/7/31.
 */
public class QueryParamUtils {

    public static List<String> getQueryOrders(String str, String separator) {
        List<String> orders = new ArrayList<>();
        if (StringHelper.isNullOrEmpty(str)) {
            return orders;
        }
        String[] splits = str.split(separator);
        for (String item : splits) {
            if (!StringHelper.isNullOrEmpty(item)) {
                orders.add(item);
            }
        }
        return orders;
    }

    public static List<String> getQuerySorts(Map<String, String[]> queryNameValuePairs) {
        String[] values = queryNameValuePairs.get("sort");
        List<String> sorts = new ArrayList<>();
        if (values == null) {
            return null;
        }
        if (values.length == 1
                && !values[0].toLowerCase().endsWith(",asc")
                && !values[0].toLowerCase().endsWith(",desc")) {
            return getQueryOrders(values[0], ",");
        }
        Arrays.stream(values).forEach(s -> {
            if (s.toLowerCase().endsWith(",asc")) {
                String f = s.substring(0, s.length() - 4).trim();
                if (!f.isEmpty()) {
                    sorts.add(f);
                }
            } else if (s.toLowerCase().endsWith(",desc")) {
                String f = s.substring(0, s.length() - 5).trim();
                if (!f.isEmpty()) {
                    sorts.add("-" + f);
                }
            } else {
                String f = s.trim();
                if (!f.isEmpty()) {
                    sorts.add(f);
                }
            }
        });
        return sorts;
    }

}
