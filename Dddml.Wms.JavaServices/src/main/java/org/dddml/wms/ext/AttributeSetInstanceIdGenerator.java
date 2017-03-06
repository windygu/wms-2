package org.dddml.wms.ext;

import org.dddml.wms.domain.AttributeSetInstanceCommand;
import org.dddml.wms.domain.AttributeSetInstanceState;
import org.dddml.wms.domain.AttributeSetInstanceStateRepository;
import org.dddml.wms.specialization.IdGenerator;
import org.dddml.wms.support.AttributeSetInstancePropertyUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Li Yongchun on 2016/9/9.
 */
public class AttributeSetInstanceIdGenerator implements IdGenerator<String, AttributeSetInstanceCommand.CreateAttributeSetInstance, AttributeSetInstanceState> {

    private AttributeSetInstanceStateRepository attributeSetInstanceStateRepository;


    public void setAttributeSetInstanceStateRepository(AttributeSetInstanceStateRepository attributeSetInstanceStateRepository) {
        this.attributeSetInstanceStateRepository = attributeSetInstanceStateRepository;
    }

    @Override
    public String generateId(AttributeSetInstanceCommand.CreateAttributeSetInstance createAttributeSetInstance) {
        String hash = AttributeSetInstancePropertyUtils.getHash(createAttributeSetInstance);
        return hash;
    }

    @Override
    public String getNextId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(AttributeSetInstanceCommand.CreateAttributeSetInstance createAttributeSetInstance, AttributeSetInstanceState attributeSetInstanceState) {
        return AttributeSetInstancePropertyUtils.equals(createAttributeSetInstance, attributeSetInstanceState);
    }

    @Override
    public boolean isSurrogateIdEnabled() {
        return true;
    }

    /*
    public GetOrGenerateIdResult<String> getOrGenerateId(AttributeSetInstanceCommand.CreateAttributeSetInstance createAttributeSetInstance) {
        GetOrGenerateIdResult<String> result = new GetOrGenerateIdResult<>();
        createAttributeSetInstance.setHash(hash);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("hash", hash);
        AttributeSetInstanceState old = attributeSetInstanceStateRepository.getFirst(hashMap.entrySet().iterator().next(), null);
        if (old != null) {
            if (AttributeSetInstancePropertyUtils.equals(createAttributeSetInstance, old)) {
                result.setReused(true);
                result.setId(old.getAttributeSetInstanceId());
                return result;
            }
        }
        result.setReused(false);
        result.setId(getNextId());
        return result;
    }
    */
}
