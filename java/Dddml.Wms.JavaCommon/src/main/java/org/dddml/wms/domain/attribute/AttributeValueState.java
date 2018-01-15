package org.dddml.wms.domain.attribute;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attribute.AttributeValueStateEvent.*;

public interface AttributeValueState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    AttributeValueId getAttributeValueId();

    void setAttributeValueId(AttributeValueId attributeValueId);

    String getValue();

    void setValue(String value);

    String getAttributeValueName();

    void setAttributeValueName(String attributeValueName);

    String getDescription();

    void setDescription(String description);

    String getReferenceId();

    void setReferenceId(String referenceId);

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

    String getAttributeId();

    void setAttributeId(String attributeId);


    boolean isStateUnsaved();

    boolean getForReapplying();


    void mutate(Event e);

    void when(AttributeValueStateEvent.AttributeValueStateCreated e);

    void when(AttributeValueStateEvent.AttributeValueStateMergePatched e);

    void when(AttributeValueStateEvent.AttributeValueStateRemoved e);
    
}

