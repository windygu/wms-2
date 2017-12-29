package org.dddml.wms.domain.service;

import org.dddml.wms.domain.attributeset.AttributeSetState;
import org.dddml.wms.domain.attributeset.AttributeSetStateQueryRepository;
import org.dddml.wms.domain.attribute.AttributeState;
import org.dddml.wms.domain.attribute.AttributeStateQueryRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/8.
 */
public class AttributeSetServiceImpl implements AttributeSetService {

    private AttributeSetStateQueryRepository attributeSetStateQueryRepository;

    private AttributeStateQueryRepository attributeStateQueryRepository;

    public void setAttributeSetStateQueryRepository(AttributeSetStateQueryRepository attributeSetStateQueryRepository) {
        this.attributeSetStateQueryRepository = attributeSetStateQueryRepository;
    }

    public void setAttributeStateQueryRepository(AttributeStateQueryRepository attributeStateQueryRepository) {
        this.attributeStateQueryRepository = attributeStateQueryRepository;
    }

    @Transactional(readOnly = true)
    public Map<String, String> getPropertyExtensionFieldDictionary(String attributeSetId) {
        AttributeSetState attributeSetState = attributeSetStateQueryRepository.get(attributeSetId);
        Map<String, String> map = new HashMap<>();
        if (attributeSetState != null && attributeSetState.getAttributeUses() != null) {
            attributeSetState.getAttributeUses().forEach(state -> {
                AttributeState attributeState = attributeStateQueryRepository.get(state.getAttributeId());
                if (attributeSetState != null) {
                    map.put(attributeState.getAttributeName(), attributeState.getFieldName());
                }
            });
        }
        return map;
    }
}
