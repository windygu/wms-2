package org.dddml.wms.ext;

import org.dddml.wms.domain.AttributeSetState;
import org.dddml.wms.domain.AttributeSetStateRepository;
import org.dddml.wms.domain.AttributeState;
import org.dddml.wms.domain.AttributeStateRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Li Yongchun on 2016/9/8.
 */
public class AttributeSetServiceImpl implements AttributeSetService {

    private AttributeSetStateRepository attributeSetStateRepository;

    private AttributeStateRepository attributeStateRepository;

    public void setAttributeSetStateRepository(AttributeSetStateRepository attributeSetStateRepository) {
        this.attributeSetStateRepository = attributeSetStateRepository;
    }

    public void setAttributeStateRepository(AttributeStateRepository attributeStateRepository) {
        this.attributeStateRepository = attributeStateRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Map<String, String> getExtensionPropertyFieldDictionary(String attributeSetId) {
        AttributeSetState attributeSetState = attributeSetStateRepository.get(attributeSetId);
        Map<String, String> map = new HashMap<>();
        if (attributeSetState != null && attributeSetState.getAttributeUses() != null) {
            attributeSetState.getAttributeUses().forEach(state -> {
                AttributeState attributeState = attributeStateRepository.get(state.getAttributeId());
                if (attributeSetState != null) {
                    map.put(attributeState.getName(), attributeState.getFieldName());
                }
            });
        }
        return map;
    }
}
