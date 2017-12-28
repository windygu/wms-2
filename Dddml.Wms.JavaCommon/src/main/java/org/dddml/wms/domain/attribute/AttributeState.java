package org.dddml.wms.domain.attribute;

import java.util.Set;
import java.util.Date;
import org.dddml.wms.domain.*;
import org.dddml.wms.specialization.Event;
import org.dddml.wms.domain.attribute.AttributeStateEvent.*;

public interface AttributeState
{
    Long VERSION_ZERO = 0L;

    Long VERSION_NULL = VERSION_ZERO - 1;

    String getAttributeId();

    void setAttributeId(String attributeId);

    String getAttributeName();

    void setAttributeName(String attributeName);

    String getOrganizationId();

    void setOrganizationId(String organizationId);

    String getDescription();

    void setDescription(String description);

    Boolean getIsMandatory();

    void setIsMandatory(Boolean isMandatory);

    Boolean getIsInstanceAttribute();

    void setIsInstanceAttribute(Boolean isInstanceAttribute);

    String getAttributeValueType();

    void setAttributeValueType(String attributeValueType);

    Integer getAttributeValueLength();

    void setAttributeValueLength(Integer attributeValueLength);

    Boolean getIsList();

    void setIsList(Boolean isList);

    String getFieldName();

    void setFieldName(String fieldName);

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


    boolean isStateUnsaved();

    boolean getForReapplying();

    AttributeValueStates getAttributeValues();

    AttributeAliasStates getAliases();


    void mutate(Event e);

    void when(AttributeStateEvent.AttributeStateCreated e);

    void when(AttributeStateEvent.AttributeStateMergePatched e);

    void when(AttributeStateEvent.AttributeStateDeleted e);
    
}

