package org.dddml.wms.restful.resource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/10.
 */
public class AppTest {

    public static void setReturnedFieldsString(String value) {
        Map<String, String> returnedFields = new HashMap<>();
        String returnedFieldsString = value;
        HashMap<String, String> fsMap = new HashMap<String, String>();
        if (returnedFieldsString != null) {
            String[] fs = returnedFieldsString.split(",");
            for (String f : fs) {
                if (f != null && !f.trim().isEmpty()) {
                    String f1 = f.trim();
                    int i = f.indexOf('.');
                    if (i >= 0) {
                        fsMap.put(f1.substring(0, i), f1.substring(i + 1));
                    } else {
                        fsMap.put(f1, null);
                    }
                }
            }
        }
        returnedFields = fsMap;
    }

    public static void main(String[] args){
        setReturnedFieldsString("buildings.name,buildings.street.address");
        //setReturnedFieldsString("a.b,a.c.d.e.f,q,rs");
    }

}
