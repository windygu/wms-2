package org.dddml.wms;

import org.dddml.wms.tool.ApplicationServiceReflectUtils;
import org.dddml.wms.tool.XmlEntityDataTool;

import java.util.List;
import java.util.Map;

/**
 * Created by yangjiefeng on 2018/1/30.
 */
public class InitEntityXmlData {

    // ///////////////////////////////////////////////////////////////////////////
    // 使用 data 目录中的数据（xml）文件初始化
    // ///////////////////////////////////////////////////////////////////////////
    public static void createEntityXmlData() {
        Map<String, List<Object>> allData = XmlEntityDataTool.deserializeAllGroupByEntityName(
                XmlEntityDataTool.DEFAULT_XML_DATA_LOCATION_PATTERN);
        for (Map.Entry<String, List<Object>> kv : allData.entrySet()) {
            for (Object e : kv.getValue()) {
                try {
                    ApplicationServiceReflectUtils.invokeApplicationServiceInitializeMethod(kv.getKey(), e);
                } catch (Exception ex) {
                    if(isCausedByConstraintViolation(ex)) {
                        ex.printStackTrace();
                    } else {
                        ex.printStackTrace();
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    public static boolean isCausedByConstraintViolation(Exception ex) {
        boolean b = false;
        Throwable c = ex;
        while (c != null) {
            if (c.getClass().getName().endsWith("ConstraintViolationException")) {
                b = true;
                break;
            }
            if (c.getMessage() != null && c.getMessage().startsWith("Duplicate entry")) {
                b = true;
                break;
            }
            if(c.getMessage() != null && c.getMessage().startsWith("[rebirth]")) {
                b = true;
                break;
            }
            c = c.getCause();
        }
        return b;
    }
}
