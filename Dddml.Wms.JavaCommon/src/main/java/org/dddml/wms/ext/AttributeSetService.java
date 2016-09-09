package org.dddml.wms.ext;

import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/8.
 */
public interface AttributeSetService {
    Map<String, String> getExtensionPropertyFieldDictionary(String attributeSetId);
}
