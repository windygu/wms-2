package org.dddml.wms.domain.attributeset;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attributeset.AttributeUseEvent.*;

public interface AttributeUseState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    AttributeSetAttributeUseId getAttributeSetAttributeUseId();

    void setAttributeSetAttributeUseId(AttributeSetAttributeUseId attributeSetAttributeUseId);

    String getAttributeId();

    void setAttributeId(String attributeId);

    Integer getSequenceNumber();

    void setSequenceNumber(Integer sequenceNumber);

    Long getVersion();

    void setVersion(Long version);

    String getCreatedBy();

    void setCreatedBy(String createdBy);

    Date getCreatedAt();

    void setCreatedAt(Date createdAt);

    String getUpdatedBy();

    void setUpdatedBy(String updatedBy);

    Date getUpdatedAt();

    void setUpdatedAt(Date updatedAt);

    Boolean getActive();

    void setActive(Boolean active);

    Boolean getDeleted();

    void setDeleted(Boolean deleted);

    String getAttributeSetId();

    void setAttributeSetId(String attributeSetId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(AttributeUseEvent.AttributeUseStateCreated e);

    void when(AttributeUseEvent.AttributeUseStateMergePatched e);

    void when(AttributeUseEvent.AttributeUseStateRemoved e);
    
}

