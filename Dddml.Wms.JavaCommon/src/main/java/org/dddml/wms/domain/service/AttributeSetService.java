package org.dddml.wms.domain.service;

import java.util.Map;

/**
 * Created by yangjiefeng on 2017/8/8.
 */
public interface AttributeSetService {
    Map<String, String> getPropertyExtensionFieldDictionary(String attributeSetId);
}

